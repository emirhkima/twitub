package main.java.com.ubo.tp.twitub.ihm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar implements ActionListener {

    JMenu fichier;
    JMenu help;
    JMenuItem quitter;
    JMenuItem aPropos;

    public Toolbar(JFrame f) {
        JMenuBar mb = new JMenuBar();
        fichier = new JMenu("Fichier");
        help = new JMenu("?");
        quitter = new JMenuItem("Quitter", new ImageIcon("src/main/resources/images/exitIcon_20.png"));
        quitter.addActionListener(this);
        aPropos = new JMenuItem("À propos");
        aPropos.addActionListener(this);
        fichier.add(quitter);
        help.add(aPropos);
        mb.add(fichier);
        mb.add(help);
        f.setJMenuBar(mb);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == quitter) {
            System.exit(0);
        }
        if(e.getSource() == aPropos) {
            JLabel label = new JLabel("<html><center>UBO M2-TIIL<br>Département Informatique");
            label.setHorizontalAlignment(SwingConstants.CENTER);
            JOptionPane.showMessageDialog(null, label, "À propos", JOptionPane.INFORMATION_MESSAGE);

        }
    }
}
