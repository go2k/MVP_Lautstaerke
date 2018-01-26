package app;

import gui.LautstaerkeFenster;
import model.Lautstaerke;

public class Main {
    public static void main(String[] args){
        Lautstaerke model = new Lautstaerke();
        LautstaerkeFenster fenster = new LautstaerkeFenster();
        model.addObserver(fenster);
        
        model.setLautstaerke(7);
    }
}
