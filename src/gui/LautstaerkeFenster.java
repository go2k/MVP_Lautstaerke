package gui;



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LautstaerkeFenster extends JFrame {
    private EventPresenter presenter;
    
    private JButton buttonLauter;
    private JButton buttonLeiser;
    private JButton buttonMute;

    private JLabel labelLautstaerke;

    public LautstaerkeFenster() {
        initComponents();
        initEvents();
    }

    public void setPresenter(EventPresenter presenter) {
        this.presenter = presenter;
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

    private void initEvents() {
        buttonLauter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.lauter();
            }
        });
        buttonLeiser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.leiser();
            }
        });
        buttonMute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.mute();
            }
        });
    }

    public void setLautstaerke(String lautstaerke ) {
        this.labelLautstaerke.setText(lautstaerke);
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
