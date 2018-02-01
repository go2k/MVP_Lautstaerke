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
        controller.setView(view);
        
        model.addObserver(view);
        model.addObserver(controller);

        LautstaerkeFenster view2 = new LautstaerkeFenster();
        Controller controller2 = new Controller(model);        
        view2.setController(controller2);
        controller2.setView(view2);
        
        model.addObserver(view2);
        model.addObserver(controller2);

        
        model.setLautstaerke(7);
    }
}
