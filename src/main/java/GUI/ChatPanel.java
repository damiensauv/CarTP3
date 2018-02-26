package GUI;

import Interface.IClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends MyPanel implements ActionListener {

    public IClient client;

    public ChatPanel(MyFrame frame, IClient client) {
        super(frame);
        this.client = client;
        this.getMyFrame().setSize(1000, 300);

        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridwidth = 10;
        gbc.gridheight = 10;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        JTextArea chatBox = new JTextArea(30, 40);
        chatBox.setEditable(false);
        this.add(new JScrollPane(chatBox), gbc);


        gbc.gridx = 10;
        gbc.gridwidth = 5;
        gbc.gridheight = 5;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.VERTICAL;
        //TESTS AFFICHAGE
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("toto");

        JList<String> listeco = new JList(listModel);
        this.add(listeco, gbc);

        //ZONE DE SAISIE
        gbc.gridx = 0;
        gbc.gridwidth = 10;
        gbc.gridheight = 1;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField chatsaisie = new JTextField(20);
        this.add(chatsaisie, gbc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
