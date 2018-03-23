package com.rovelo.labo2;

/**
 * Created by Cometela on 21/3/2018.
 */

public class Juego {
    Jugador jugador1;
    Jugador jugador2;
    int scoreJ1;
    int scoreJ2;

    public int getScoreJ1() {
        return scoreJ1;
    }

    public int getScoreJ2() {
        return scoreJ2;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public void setScoreJ1(int scoreJ1) {
        this.scoreJ1 = scoreJ1;
    }

    public void setScoreJ2(int scoreJ2) {
        this.scoreJ2 = scoreJ2;
    }
}
