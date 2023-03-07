package main.java.com.ubo.tp.twitub.ihm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe de la vue principale de l'application.
 */
public class DirectoryPicker extends JFrame implements ActionListener {
    String selectedDirectory = "";
    public DirectoryPicker() {
        if(this.selectedDirectory.isEmpty()) {
            this.chooseDirectory();
        }
    }

    public void chooseDirectory() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.showOpenDialog(null);
        this.selectedDirectory = fc.getSelectedFile().getAbsolutePath();
    }

    public String getSelectedDirectory() {
        System.out.println(this.selectedDirectory);
        return this.selectedDirectory;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
