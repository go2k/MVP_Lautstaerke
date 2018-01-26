package gui;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.Lautstaerke;

public class LautstaerkeFenster extends JFrame implements Observer {

    private JButton buttonLauter;
    private JButton buttonLeiser;
    private JButton buttonMute;

    private JLabel labelLautstaerke;

    public LautstaerkeFenster() {
        initComponents();
    }

    private void initComponents() {
        buttonLauter = new JButton("+");
        buttonLeiser = new JButton("-");
        buttonMute = new JButton("MUTE");
        labelLautstaerke = new JLabel("---");
        labelLautstaerke.setHorizontalAlignment(0);
        this.add(buttonLauter, BorderLayout.EAST);
        this.add(buttonLeiser, BorderLayout.WEST);
        this.add(buttonMute, BorderLayout.NORTH);
        this.add(labelLautstaerke);
        
        this.setSize(200,100);
        this.setTitle("Lautstärke");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        int lautstaerke = ((Lautstaerke)o).getLautstaerke();
        String lautstaerkeText = String.valueOf(lautstaerke);
        labelLautstaerke.setText(lautstaerkeText);
    }

}
