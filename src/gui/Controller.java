package gui;

import java.util.Observable;
import java.util.Observer;
import model.LautstaerkeLesen;
import model.LautstaerkeSchreiben;

public class Controller implements EventController, Observer {

    private LautstaerkeLesen modelLesen;
    private LautstaerkeSchreiben modelSchreiben;
    private int lautstaerke;

    public Controller(LautstaerkeSchreiben modelSchreiben) {
        this.modelSchreiben = modelSchreiben;
    }

    @Override
    public void lauter() {
        modelSchreiben.setLautstaerke(lautstaerke + 1);
    }

    @Override
    public void leiser() {
        System.out.println("gui.Controller.leiser()");
    }

    @Override
    public void mute() {
        System.out.println("gui.Controller.mute()");
    }

    @Override
    public void update(Observable o, Object arg) {
        // Controller holt sich Daten vom Model
        LautstaerkeLesen model = (LautstaerkeLesen) o;
        lautstaerke = model.getLautstaerke();
    }
}
