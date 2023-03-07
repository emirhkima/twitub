package main.java.com.ubo.tp.twitub.ihm;

import main.java.com.ubo.tp.twitub.datamodel.Twit;

import javax.swing.*;
import java.util.Set;

//create NewPage class to create a new page on which user will navigate
public class TwitsView extends JFrame {

    public TwitsView(Set<Twit> twits) {

        JPanel content = new JPanel();

        new Toolbar(this);

        DefaultListModel listModel = new DefaultListModel();

        System.out.println(twits.size());

        for(Twit twit : twits) {
            listModel.addElement(twit.getText());
        }

        content.add(new JList(listModel.toArray()));

        this.add(content);

        this.setTitle("Twitub");
        this.setVisible(true);
        this.setSize(400, 400);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}