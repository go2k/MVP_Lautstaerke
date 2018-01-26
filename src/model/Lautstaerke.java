package model;

import java.util.Observable;

public class Lautstaerke extends Observable {

    private int lautstaerke;

    public Lautstaerke() {
        lautstaerke = 1;
    }

    public int getLautstaerke() {
        return lautstaerke;
    }

    public void setLautstaerke(int lautstaerke) {
        if (lautstaerke >= 0 && lautstaerke <= 10) {
            this.lautstaerke = lautstaerke;
            // Alle Observer (Beobachter) benachrichtigen
            setChanged();
            notifyObservers();
        }
    }
}
