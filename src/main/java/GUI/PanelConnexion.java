package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelConnexion extends MyPanel implements ActionListener {


    private JButton boutonOK, boutonAnnuler, boutonValider;
    private JLabel label, labelmdp;
    private JTextField champtexte, champeval;
    private JPasswordField champmdp;


    public PanelConnexion(MyFrame frame) {
        super(frame);

        this.setLayout(new FlowLayout());

        label = new JLabel("Votre identifiant :");
        labelmdp = new JLabel("Votre mot de passe :");
        champtexte = new JTextField(25);
        champmdp = new JPasswordField(25);
        champeval = new JTextField(25);
        boutonOK = new JButton();
        boutonAnnuler = new JButton();
        boutonValider = new JButton();
        boutonValider.setText("Valider");
        boutonOK.setText("OK");
        boutonAnnuler.setText("Annuler");

        this.add(label);
        this.add(champtexte);
        this.add(labelmdp);
        this.add(champmdp);
        this.add(boutonAnnuler);
        this.add(boutonOK);
        this.setVisible(true);
        boutonOK.setEnabled(false);

        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;

    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
