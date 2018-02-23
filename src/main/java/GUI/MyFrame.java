package GUI;

import javax.swing.*;

public class MyFrame extends JFrame {

    // on extend la JFrame afin que l'on puisse avoir une frame principal
    public MyFrame() {

        this.setTitle("Client RMI");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(1000, 300);

        PanelConnexion cf = new PanelConnexion(this);
        this.add(cf);
        this.pack();

    }

    public void switchPanel(MyPanel panel) {

        this.setContentPane(panel);
        this.pack();
        this.setLocationRelativeTo(null);

    }

}
