package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.LautstaerkeLesen;

public class LautstaerkeFenster extends JFrame implements Observer {
    private EventController controller;
    
    private JButton buttonLauter;
    private JButton buttonLeiser;
    private JButton buttonMute;

    private JLabel labelLautstaerke;

    public LautstaerkeFenster() {
        initComponents();
        initEvents();
    }

    public void setController(EventController controller) {
        this.controller = controller;
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

        this.setSize(200, 100);
        this.setTitle("Lautstärke");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        // View holt sich Daten vom Model
        LautstaerkeLesen model = (LautstaerkeLesen) o;
        int lautstaerke = model.getLautstaerke();

        // Daten anzeigen
        String lautstaerkeText = String.valueOf(lautstaerke);
        labelLautstaerke.setText(lautstaerkeText);
    }

    private void initEvents() {
        buttonLauter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.lauter();
            }
        });
        buttonLeiser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.leiser();
            }
        });
        buttonMute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.mute();
            }
        });
    }
    
    public void deaktiviereMinus(){
        buttonLeiser.setEnabled(false);
    }
    
    public void aktiviereMinus(){
        buttonLeiser.setEnabled(true);
    }
    
    public void deaktivierePlus(){
        buttonLauter.setEnabled(false);
    }
    
    public void aktivierePlus(){
        buttonLauter.setEnabled(true);
    }
}
