package com.rovelo.labo2;

/**
 * Created by Cometela on 21/3/2018.
 */

public class Jugador {
    int puntaje;
    boolean ADV = false;

    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }
    public void setADV(boolean adv){
        ADV=adv;
    }
    public boolean getADV(){
        return ADV;
    }
}

