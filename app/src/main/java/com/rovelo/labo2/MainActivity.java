package com.rovelo.labo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtView1, txtView2, tempTxtView, tempTxtView2,prueba;
    Juego nuevoJuego = new Juego();
    Jugador J1 = new Jugador();
    Jugador J2 = new Jugador();
    int b,d;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nuevoJuego.setJugador1(J1);
        nuevoJuego.setJugador2(J2);


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
        nuevoJuego.getJugador1().setPuntaje(b);
        int score = nuevoJuego.getScoreJ1();

        if(b==40 && nuevoJuego.getJugador2().getADV() && d==40){
            nuevoJuego.getJugador2().setADV(false);
        }
        else if(b==40 && nuevoJuego.getJugador1().getADV()){

            txtView2.setText(""+0);
            b=0;
            tempTxtView = findViewById(R.id.Set1Jugador1);
            score+=1;
            tempTxtView.setText(String.valueOf(score));
            nuevoJuego.setScoreJ1(score);
            nuevoJuego.getJugador1().setPuntaje(0);
            nuevoJuego.getJugador2().setPuntaje(0);
            nuevoJuego.getJugador2().setADV(false);
            nuevoJuego.getJugador1().setADV(false);

        }
        else if (b==40){
            if(nuevoJuego.getJugador1().getPuntaje()-nuevoJuego.getJugador2().getPuntaje()!=0){
                txtView2.setText(""+0);
                b=0;
                tempTxtView = findViewById(R.id.Set1Jugador1);
                score+=1;
                tempTxtView.setText(String.valueOf(score));
                nuevoJuego.setScoreJ1(score);
                nuevoJuego.getJugador1().setPuntaje(0);
                nuevoJuego.getJugador2().setPuntaje(0);
                nuevoJuego.getJugador2().setADV(false);
                nuevoJuego.getJugador1().setADV(false);
            }
            else{
                nuevoJuego.getJugador1().setADV(true);
            }
        }
        else if(b<30){
            b+=15;
        }
        else{
            b+=10;
        }
        txtView1.setText(String.valueOf(b));
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
            nuevoJuego.getJugador1().setPuntaje(0);
            nuevoJuego.getJugador2().setPuntaje(0);
            nuevoJuego.getJugador2().setADV(false);
            nuevoJuego.getJugador1().setADV(false);

        }
        else if (d==40){
            if(nuevoJuego.getJugador2().getPuntaje()-nuevoJuego.getJugador1().getPuntaje()!=0){
                d=0;
                txtView1.setText(""+0);
                tempTxtView2 = findViewById(R.id.Set1Jugador2);
                score+=1;
                tempTxtView2.setText(String.valueOf(score));
                nuevoJuego.setScoreJ2(score);
                nuevoJuego.getJugador1().setPuntaje(0);
                nuevoJuego.getJugador2().setPuntaje(0);
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
    }
}
