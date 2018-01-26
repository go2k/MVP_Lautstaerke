package app;

import gui.Controller;
import gui.LautstaerkeFenster;
import model.Lautstaerke;

public class Main {
    public static void main(String[] args){
        Lautstaerke model = new Lautstaerke();
        LautstaerkeFenster view = new LautstaerkeFenster();
        Controller controller = new Controller(model);
        
        view.setController(controller);        
        model.addObserver(view);
        model.addObserver(controller);

        
        model.setLautstaerke(7);
    }
}
