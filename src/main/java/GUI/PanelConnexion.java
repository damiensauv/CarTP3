package GUI;

import Impl.Client;
import Interface.IClient;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

public class PanelConnexion extends MyPanel implements ActionListener {


    private JButton boutonOK, boutonAnnuler, boutonValider;
    private JLabel label, labelmdp;
    private JTextField champtexte;
    private JPasswordField champmdp;


    public PanelConnexion(MyFrame frame) {
        super(frame);

        this.setLayout(new FlowLayout());

        label = new JLabel("Votre identifiant :");
        labelmdp = new JLabel("Votre mot de passe :");
        champtexte = new JTextField(25);
        champmdp = new JPasswordField(25);
        boutonOK = new JButton();
        boutonAnnuler = new JButton();
        boutonValider = new JButton();
        boutonValider.setText("Valider");
        boutonOK.setText("OK");
        boutonAnnuler.setText("Annuler");

        boutonOK.addActionListener(this);

        this.add(label);
        this.add(champtexte);
        this.add(labelmdp);
        this.add(champmdp);
        this.add(boutonAnnuler);
        this.add(boutonOK);
        this.setVisible(true);
        boutonOK.setEnabled(false);


        champtexte.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed();
            }

            public void removeUpdate(DocumentEvent e) {
                changed();
            }

            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            public void changed() {
                if (champtexte.getText().isEmpty()) {
                    boutonOK.setEnabled(false);
                } else {
                    boutonOK.setEnabled(true);
                }

            }
        });

        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == boutonOK) {
            try {
                IClient client = new Client(champtexte.getText(), String.valueOf(champmdp.getPassword()));
                if (this.getMyFrame().service.connect(client))
                    this.getMyFrame().switchPanel(new ChatPanel(this.getMyFrame(), client));
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
        }
    }
}
