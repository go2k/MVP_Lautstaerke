package gui;

import java.util.Observable;
import java.util.Observer;
import model.LautstaerkeLesen;
import model.LautstaerkeSchreiben;

public class Presenter implements EventPresenter, Observer {
    private final int MAXVOLUME = 10;
    private LautstaerkeLesen modelLesen;
    private LautstaerkeSchreiben modelSchreiben;
    private int lautstaerke;
    private LautstaerkeFenster view;

    public Presenter(LautstaerkeSchreiben modelSchreiben) {
        this.modelSchreiben = modelSchreiben;
    }

    public void setView(LautstaerkeFenster view) {
        this.view = view;
    }
    
    @Override
    public void lauter() {
        modelSchreiben.setLautstaerke(lautstaerke + 1);
    }

    @Override
    public void leiser() {
        modelSchreiben.setLautstaerke(lautstaerke - 1);
    }

    @Override
    public void mute() {
        modelSchreiben.setLautstaerke(0);
    }

    @Override
    public void update(Observable o, Object arg) {
        // Presenter holt sich Daten vom Model
        LautstaerkeLesen model = (LautstaerkeLesen) o;
        lautstaerke = model.getLautstaerke();

        //Lautstaerke ausgeben
        String lautstaerkeText = String.format("%d", lautstaerke);
        view.setLautstaerke(lautstaerkeText);

        // Presenter (de)aktiviert Buttons in View
        if(lautstaerke <= 0){
            view.deaktiviereMinus();
        }else{
            view.aktiviereMinus();
        }
        if(lautstaerke >=MAXVOLUME){
            view.deaktivierePlus();
        }else{
            view.aktivierePlus();
        }

    }

    
}
