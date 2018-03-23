package com.rovelo.labo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtView1, txtView2, tempTxtView, tempTxtView2,res;
    Button Jugador1,Jugador2,Reset;
    Juego nuevoJuego = new Juego();
    Jugador J1 = new Jugador();
    Jugador J2 = new Jugador();
    Set sets = new Set();
    int b,d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sets.setGame(nuevoJuego);
        nuevoJuego.setJugador1(J1);
        nuevoJuego.setJugador2(J2);
        sets.setSet(1);

    }

    public void changeText(View v){
        //txtView1 = findViewById(R.id.textView1);
        //txtView2 = findViewById(R.id.textView2);
        String aux;
        aux = txtView1.getText().toString();
        txtView1.setText(txtView2.getText().toString());
        txtView2.setText(aux);
    }

    public void Jugar1(View v){

        txtView1 = findViewById(R.id.ScoreJugador1);
        txtView2 = findViewById(R.id.ScoreJugador2);

        String a = txtView1.getText().toString();
        b = Integer.parseInt(a);
        String c = txtView2.getText().toString();
        d = Integer.parseInt(c);
        int score = nuevoJuego.getScoreJ1();
        int set = sets.getSet();
        switch (set) {
            case 1:
                if(sets.isTiebreak()){
                    b+=1;
                    if(b==7 && b-d>=2){
                        txtView2.setText("" + 0);
                        b = 0;
                        tempTxtView = findViewById(R.id.Set1Jugador1);
                        score += 1;
                        tempTxtView.setText(String.valueOf(score));
                        tempTxtView2 = findViewById(R.id.Set1Jugador2);
                        String fin = String.valueOf(6)+"("+String.valueOf(nuevoJuego.getScoreJ2())+")";
                        tempTxtView2.setText(fin);
                        nuevoJuego.setScoreJ1(score);
                        sets.setSet(2);
                    }
                    else if(b>7 && b-d>=2){
                        txtView2.setText("" + 0);
                        b = 0;
                        tempTxtView = findViewById(R.id.Set1Jugador1);
                        score += 1;
                        tempTxtView.setText(String.valueOf(score));
                        nuevoJuego.setScoreJ1(score);
                        sets.setSet(2);
                    }
                    txtView1.setText(String.valueOf(b));
                }
                else {
                    if (b == 40 && nuevoJuego.getJugador2().getADV() && d == 40) {
                        nuevoJuego.getJugador2().setADV(false);
                    } else if (b == 40 && nuevoJuego.getJugador1().getADV()) {

                        txtView2.setText("" + 0);
                        b = 0;
                        tempTxtView = findViewById(R.id.Set1Jugador1);
                        score += 1;
                        tempTxtView.setText(String.valueOf(score));
                        nuevoJuego.setScoreJ1(score);
                        nuevoJuego.getJugador2().setADV(false);
                        nuevoJuego.getJugador1().setADV(false);

                    } else if (b == 40) {
                        if (b - d != 0) {
                            txtView2.setText("" + 0);
                            b = 0;

                            tempTxtView = findViewById(R.id.Set1Jugador1);
                            score += 1;
                            tempTxtView.setText(String.valueOf(score));
                            nuevoJuego.setScoreJ1(score);
                            nuevoJuego.getJugador2().setADV(false);
                            nuevoJuego.getJugador1().setADV(false);
                        } else {
                            nuevoJuego.getJugador1().setADV(true);
                        }
                    } else if (b < 30) {
                        b += 15;
                    } else {
                        b += 10;
                    }
                    txtView1.setText(String.valueOf(b));
                    if (score == 6 && score - nuevoJuego.getScoreJ2() >= 2) {
                        sets.setSet(2);
                        int temp = nuevoJuego.getJugador1().getPuntaje();
                        temp += 1;
                        nuevoJuego.getJugador1().setPuntaje(temp);
                        nuevoJuego.setScoreJ2(0);
                        nuevoJuego.setScoreJ1(0);
                    } else if (score == 7 && nuevoJuego.getScoreJ2() == 5) {
                        sets.setSet(2);
                        int temp = nuevoJuego.getJugador1().getPuntaje();
                        temp += 1;
                        nuevoJuego.getJugador1().setPuntaje(temp);
                        nuevoJuego.setScoreJ2(0);
                        nuevoJuego.setScoreJ1(0);
                    }
                }
                break;
            case 2:
                if(sets.isTiebreak()){

                }
                else {
                    if (b == 40 && nuevoJuego.getJugador2().getADV() && d == 40) {
                        nuevoJuego.getJugador2().setADV(false);
                    } else if (b == 40 && nuevoJuego.getJugador1().getADV()) {

                        txtView2.setText("" + 0);
                        b = 0;
                        tempTxtView = findViewById(R.id.Set2Jugador1);
                        score += 1;
                        tempTxtView.setText(String.valueOf(score));
                        nuevoJuego.setScoreJ1(score);
                        nuevoJuego.getJugador2().setADV(false);
                        nuevoJuego.getJugador1().setADV(false);

                    } else if (b == 40) {
                        if (b - d != 0) {
                            txtView2.setText("" + 0);
                            b = 0;

                            tempTxtView = findViewById(R.id.Set2Jugador1);
                            score += 1;
                            tempTxtView.setText(String.valueOf(score));
                            nuevoJuego.setScoreJ1(score);
                            nuevoJuego.getJugador2().setADV(false);
                            nuevoJuego.getJugador1().setADV(false);
                        } else {
                            nuevoJuego.getJugador1().setADV(true);
                        }
                    } else if (b < 30) {
                        b += 15;
                    } else {
                        b += 10;
                    }

                    txtView1.setText(String.valueOf(b));
                    if (score == 6 && score - nuevoJuego.getScoreJ2() >= 2) {
                        sets.setSet(3);
                        int temp = nuevoJuego.getJugador1().getPuntaje();
                        temp += 1;
                        nuevoJuego.getJugador1().setPuntaje(temp);
                        nuevoJuego.setScoreJ2(0);
                        nuevoJuego.setScoreJ1(0);
                    } else if (score == 7 && nuevoJuego.getScoreJ2() == 5) {
                        sets.setSet(3);
                        int temp = nuevoJuego.getJugador1().getPuntaje();
                        temp += 1;
                        nuevoJuego.getJugador1().setPuntaje(temp);
                        nuevoJuego.setScoreJ2(0);
                        nuevoJuego.setScoreJ1(0);
                    }
                }
                break;
            case 3:
                if(sets.isTiebreak()){

                }
                else {
                    if (b == 40 && nuevoJuego.getJugador2().getADV() && d == 40) {
                        nuevoJuego.getJugador2().setADV(false);
                    } else if (b == 40 && nuevoJuego.getJugador1().getADV()) {

                        txtView2.setText("" + 0);
                        b = 0;
                        tempTxtView = findViewById(R.id.Set3Jugador1);
                        score += 1;
                        tempTxtView.setText(String.valueOf(score));
                        nuevoJuego.setScoreJ1(score);
                        nuevoJuego.getJugador2().setADV(false);
                        nuevoJuego.getJugador1().setADV(false);

                    } else if (b == 40) {
                        if (b - d != 0) {
                            txtView2.setText("" + 0);
                            b = 0;

                            tempTxtView = findViewById(R.id.Set3Jugador1);
                            score += 1;
                            tempTxtView.setText(String.valueOf(score));
                            nuevoJuego.setScoreJ1(score);
                            nuevoJuego.getJugador2().setADV(false);
                            nuevoJuego.getJugador1().setADV(false);
                        } else {
                            nuevoJuego.getJugador1().setADV(true);
                        }
                    } else if (b < 30) {
                        b += 15;
                    } else {
                        b += 10;
                    }

                    txtView1.setText(String.valueOf(b));
                    if (score == 6 && score - nuevoJuego.getScoreJ2() >= 2) {
                        sets.setSet(4);
                        int temp = nuevoJuego.getJugador1().getPuntaje();
                        temp += 1;
                        nuevoJuego.getJugador1().setPuntaje(temp);
                        nuevoJuego.setScoreJ2(0);
                        nuevoJuego.setScoreJ1(0);
                    } else if (score == 7 && nuevoJuego.getScoreJ2() == 5) {
                        sets.setSet(4);
                        int temp = nuevoJuego.getJugador1().getPuntaje();
                        temp += 1;
                        nuevoJuego.getJugador1().setPuntaje(temp);
                        nuevoJuego.setScoreJ2(0);
                        nuevoJuego.setScoreJ1(0);
                    } else {

                    }
                }
                break;
            case 4:
                if(nuevoJuego.getJugador1().getPuntaje()<nuevoJuego.getJugador2().getPuntaje()){
                    res = findViewById(R.id.Resultado);
                    res.setText("Gano Jugador 2");
                    Jugador1 = findViewById(R.id.BotonJugador1);
                    Jugador1.setEnabled(false);
                    Jugador2 = findViewById(R.id.BotonJugador2);
                    Jugador2.setEnabled(false);
                }
                else{
                    res = findViewById(R.id.Resultado);
                    res.setText("Gano Jugador 1");
                    Jugador1 = findViewById(R.id.BotonJugador1);
                    Jugador1.setEnabled(false);
                    Jugador2 = findViewById(R.id.BotonJugador2);
                    Jugador2.setEnabled(false);
                }
                break;
        }
    }
    public void Jugar2(View v){

        txtView1 = findViewById(R.id.ScoreJugador1);
        txtView2 = findViewById(R.id.ScoreJugador2);

        String a = txtView1.getText().toString();
        b = Integer.parseInt(a);
        String c = txtView2.getText().toString();
        d = Integer.parseInt(c);
        nuevoJuego.getJugador2().setPuntaje(d);
        int score = nuevoJuego.getScoreJ2();
        int set = sets.getSet();
        switch (set){
            case 1:
                if(sets.isTiebreak()){

                }
                else {}
                if(b==40 && nuevoJuego.getJugador1().getADV() && d==40){
                    nuevoJuego.getJugador1().setADV(false);
                }
                else if(d==40 && nuevoJuego.getJugador2().getADV()){

                    d=0;
                    txtView1.setText(""+0);
                    tempTxtView2 = findViewById(R.id.Set1Jugador2);
                    score+=1;
                    tempTxtView2.setText(String.valueOf(score));
                    nuevoJuego.setScoreJ2(score);
                    nuevoJuego.getJugador2().setADV(false);
                    nuevoJuego.getJugador1().setADV(false);

                }
                else if (d==40){
                    if(d-b!=0){
                        d=0;
                        txtView1.setText(""+0);
                        tempTxtView2 = findViewById(R.id.Set1Jugador2);
                        score+=1;
                        tempTxtView2.setText(String.valueOf(score));
                        nuevoJuego.setScoreJ2(score);
                        nuevoJuego.getJugador2().setADV(false);
                        nuevoJuego.getJugador1().setADV(false);
                    }
                    else{
                        nuevoJuego.getJugador2().setADV(true);
                    }
                }
                else if(d<30){
                    d+=15;
                }
                else{
                    d+=10;
                }
                txtView2.setText(String.valueOf(d));
                if(score==6 && score-nuevoJuego.getScoreJ1()>=2){
                    sets.setSet(2);
                    int temp = nuevoJuego.getJugador2().getPuntaje();
                    temp+=1;
                    nuevoJuego.getJugador2().setPuntaje(temp);
                    nuevoJuego.setScoreJ2(0);
                    nuevoJuego.setScoreJ1(0);
                }
                else if(score==7 && nuevoJuego.getScoreJ1()==5){
                    sets.setSet(2);
                    int temp = nuevoJuego.getJugador2().getPuntaje();
                    temp+=1;
                    nuevoJuego.getJugador2().setPuntaje(temp);
                    nuevoJuego.setScoreJ2(0);
                    nuevoJuego.setScoreJ1(0);
                }
                else{

                }
                break;
            case 2:
                if(sets.isTiebreak()){

                }
                else {}
                if(b==40 && nuevoJuego.getJugador1().getADV() && d==40){
                    nuevoJuego.getJugador1().setADV(false);
                }
                else if(d==40 && nuevoJuego.getJugador2().getADV()){

                    d=0;
                    txtView1.setText(""+0);
                    tempTxtView2 = findViewById(R.id.Set2Jugador2);
                    score+=1;
                    tempTxtView2.setText(String.valueOf(score));
                    nuevoJuego.setScoreJ2(score);
                    nuevoJuego.getJugador2().setADV(false);
                    nuevoJuego.getJugador1().setADV(false);

                }
                else if (d==40){
                    if(d-b!=0){
                        d=0;
                        txtView1.setText(""+0);
                        tempTxtView2 = findViewById(R.id.Set2Jugador2);
                        score+=1;
                        tempTxtView2.setText(String.valueOf(score));
                        nuevoJuego.setScoreJ2(score);
                        nuevoJuego.getJugador2().setADV(false);
                        nuevoJuego.getJugador1().setADV(false);
                    }
                    else{
                        nuevoJuego.getJugador2().setADV(true);
                    }
                }
                else if(d<30){
                    d+=15;
                }
                else{
                    d+=10;
                }
                txtView2.setText(String.valueOf(d));
                if(score==6 && score-nuevoJuego.getScoreJ1()>=2){
                    sets.setSet(3);
                    int temp = nuevoJuego.getJugador2().getPuntaje();
                    temp+=1;
                    nuevoJuego.getJugador2().setPuntaje(temp);
                    nuevoJuego.setScoreJ2(0);
                    nuevoJuego.setScoreJ1(0);

                }
                else if(score==7 && nuevoJuego.getScoreJ1()==5){
                    sets.setSet(3);
                    int temp = nuevoJuego.getJugador2().getPuntaje();
                    temp+=1;
                    nuevoJuego.getJugador2().setPuntaje(temp);
                    nuevoJuego.setScoreJ2(0);
                    nuevoJuego.setScoreJ1(0);
                }
                else{

                }
                break;

            case 3:
                if(sets.isTiebreak()){

                }
                else {
                    if (b == 40 && nuevoJuego.getJugador1().getADV() && d == 40) {
                        nuevoJuego.getJugador1().setADV(false);
                    } else if (d == 40 && nuevoJuego.getJugador2().getADV()) {

                        d = 0;
                        txtView1.setText("" + 0);
                        tempTxtView2 = findViewById(R.id.Set3Jugador2);
                        score += 1;
                        tempTxtView2.setText(String.valueOf(score));
                        nuevoJuego.setScoreJ2(score);
                        nuevoJuego.getJugador2().setADV(false);
                        nuevoJuego.getJugador1().setADV(false);

                    } else if (d == 40) {
                        if (d - b != 0) {
                            d = 0;
                            txtView1.setText("" + 0);
                            tempTxtView2 = findViewById(R.id.Set3Jugador2);
                            score += 1;
                            tempTxtView2.setText(String.valueOf(score));
                            nuevoJuego.setScoreJ2(score);
                            nuevoJuego.getJugador2().setADV(false);
                            nuevoJuego.getJugador1().setADV(false);
                        } else {
                            nuevoJuego.getJugador2().setADV(true);
                        }
                    } else if (d < 30) {
                        d += 15;
                    } else {
                        d += 10;
                    }
                    txtView2.setText(String.valueOf(d));
                    if (score == 6 && score - nuevoJuego.getScoreJ1() >= 2) {
                        sets.setSet(4);
                        int temp = nuevoJuego.getJugador2().getPuntaje();
                        temp += 1;
                        nuevoJuego.getJugador2().setPuntaje(temp);
                        nuevoJuego.setScoreJ2(0);
                        nuevoJuego.setScoreJ1(0);
                    } else if (score == 7 && nuevoJuego.getScoreJ1() == 5) {

                        sets.setSet(4);
                        int temp = nuevoJuego.getJugador2().getPuntaje();
                        temp += 1;
                        nuevoJuego.getJugador2().setPuntaje(temp);
                        nuevoJuego.setScoreJ2(0);
                        nuevoJuego.setScoreJ1(0);
                    } else {
                        sets.setTiebreak(true);
                    }
                }
                break;
            case 4:
                if(nuevoJuego.getJugador2().getPuntaje()>nuevoJuego.getJugador1().getPuntaje()){
                    res = findViewById(R.id.Resultado);
                    res.setText("Jugador 2 Gano");
                    Jugador1 = findViewById(R.id.BotonJugador1);
                    Jugador1.setEnabled(false);
                    Jugador2 = findViewById(R.id.BotonJugador2);
                    Jugador2.setEnabled(false);
                }
                else{
                    res = findViewById(R.id.Resultado);
                    res.setText("Jugador 1 Gano");
                    Jugador1 = findViewById(R.id.BotonJugador1);
                    Jugador1.setEnabled(false);
                    Jugador2 = findViewById(R.id.BotonJugador2);
                    Jugador2.setEnabled(false);
                }

                break;
        }

    }

    public void Reset(View v){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
