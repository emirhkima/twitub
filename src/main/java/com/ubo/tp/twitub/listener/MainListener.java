package com.ubo.tp.twitub.listener;

import com.ubo.tp.twitub.controller.LoginController;
import com.ubo.tp.twitub.core.Twitub;
import com.ubo.tp.twitub.ihm.AuthenticationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainListener implements ActionListener {

    private final Twitub mainController;
    private final LoginController loginController;

    public MainListener(Twitub mainController, LoginController loginController) {
        this.mainController = mainController;
        this.loginController = loginController;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            this.mainController.setUser(this.loginController.getUser());
            this.mainController.initMainView();
        } catch (Exception ex) {

        }
    }
}
