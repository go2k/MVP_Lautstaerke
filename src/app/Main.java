package app;

import gui.Presenter;
import gui.LautstaerkeFenster;
import model.Lautstaerke;

public class Main {
    public static void main(String[] args){
        Lautstaerke model = new Lautstaerke();
        
        LautstaerkeFenster view = new LautstaerkeFenster();
        Presenter presenter = new Presenter(model);
        view.setPresenter(presenter);
        presenter.setView(view);

        model.addObserver(presenter);

        
        model.setLautstaerke(7);
    }
}
