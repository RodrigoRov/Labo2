package com.rovelo.labo2;

/**
 * Created by Cometela on 23/3/2018.
 */

public class Set {
    int set;
    Juego game;
    boolean tiebreak;

    public void setSet(int set){
        this.set=set;
    }

    public int getSet() {
        return set;
    }

    public void setGame(Juego game) {
        this.game = game;
    }

    public Juego getGame() {
        return game;
    }

    public boolean isTiebreak() {
        return tiebreak;
    }

    public void setTiebreak(boolean tiebreak) {
        this.tiebreak = tiebreak;
    }
}
