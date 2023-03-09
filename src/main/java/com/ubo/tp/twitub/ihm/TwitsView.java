package com.ubo.tp.twitub.ihm;

import com.ubo.tp.twitub.datamodel.Twit;

import javax.swing.*;
import java.awt.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class TwitsView extends JFrame {

    public TwitsView(Set<Twit> twits) {

        new Toolbar(this);

        DefaultListModel listModel = new DefaultListModel();

        for(Twit twit : twits) {
            JPanel content = new JPanel();
            listModel.addElement(twit.getTwiter().getUserTag() + "\t\t" + this.convertTime(twit.getEmissionDate()));
            listModel.addElement(twit.getText());
            content.add(new JList(listModel));
            content.setPreferredSize(new Dimension(400, 400));
            this.add(content);
        }

        this.setTitle("Twitub");
        this.setVisible(true);
        this.setSize(400, 400);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private String convertTime(long time){
        Date date = new Date(time);
        Format format = new SimpleDateFormat("dd/mm/yyyy HH:mm");
        return format.format(date);
    }
}