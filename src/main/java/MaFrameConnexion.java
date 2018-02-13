import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaFrameConnexion extends JFrame {

    private JPanel panelco, panelchat, cardpanels;
    private JButton boutonOK, boutonAnnuler, boutonValider;
    private JLabel label,labelmdp;
    private JTextField champtexte,champeval;
    private JPasswordField champmdp;
    private JList<DefaultListModel> listenoms;
    private Integer current;

   
    public MaFrameConnexion() {

        // CardLayout Panel permettant d'alterner entre les différents panels.
        cardpanels = new JPanel();
        cardpanels.setLayout(new CardLayout());

        // Panel de connexion
        panelco = new JPanel();
        panelchat = new JPanel();

        panelco.setLayout(new FlowLayout());
        panelchat.setLayout(new GridBagLayout());

        // Variables pannel de connexion
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

        setTitle("Connexion utilisateur");
        panelco.add(label);
        panelco.add(champtexte);
        panelco.add(labelmdp);
        panelco.add(champmdp);
        panelco.add(boutonAnnuler);
        panelco.add(boutonOK);
        panelco.setVisible(true);

        boutonOK.setEnabled(false);

        
        // GridBagConstraints pour organiser les composants de la fenêtre
        // d'évaluation
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;

        // On ajoute les panels au CardLayout
        cardpanels.add(panelco, "1");
        cardpanels.add(panelchat, "2");

        add(cardpanels);


        // Test qui constate le bon remplissage de la zone de saisie pour
        // déverrouiller le bouton OK

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

        // ActionListener du bouton valider
        boutonValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                dispose();
               

            }
        });

        // ActionListener du bouton annuler
        boutonAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ferme la fenêtre.
                dispose();

            }
        });

        // ActionListener du bouton OK
        boutonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ferme la fenêtre.
                // dispose();
                ((CardLayout) cardpanels.getLayout()).show(cardpanels, "2");

                setTitle("Chat Room");
                
                //ZONE D'AFFICHAGE DU CHAT
                gbc.gridx = 0;
                gbc.gridwidth = 10;
                gbc.gridheight = 10;
                gbc.gridy = 0;
                gbc.fill = GridBagConstraints.BOTH;
                JTextArea chatBox = new JTextArea("Bienvenue sur le chat !");
                chatBox.setEditable(false);
                panelchat.add(new JScrollPane(chatBox), gbc);
                
              //ZONE D'AFFICHAGE DES UTILISATEURS CONNECTES
                gbc.gridx = 10;
                gbc.gridwidth = 5;
                gbc.gridheight = 5;
                gbc.gridy = 0;
                gbc.fill = GridBagConstraints.VERTICAL;
                //TESTS AFFICHAGE
                DefaultListModel listModel = new DefaultListModel();
                listModel.addElement("toto");
                
                
                JList<String> listeco = new JList(listModel);;
                panelchat.add(listeco, gbc);
                
              //ZONE DE SAISIE
                gbc.gridx = 0;
                gbc.gridwidth = 10;
                gbc.gridheight = 1;
                gbc.gridy = 10;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                JTextField chatsaisie = new JTextField();
                panelchat.add(chatsaisie, gbc);
                            
            }
        });

    }

    public static void main(String[] args) {
        MaFrameConnexion laframe = new MaFrameConnexion();

        laframe.setLocationRelativeTo(null);
        laframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        laframe.setVisible(true);
        laframe.setSize(1000, 300);
	}
}
