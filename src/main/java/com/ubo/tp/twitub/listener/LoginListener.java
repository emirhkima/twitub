package main.java.com.ubo.tp.twitub.listener;

import main.java.com.ubo.tp.twitub.controller.LoginController;
import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.ihm.AuthenticationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {

    private final LoginController loginController;
    private final AuthenticationView view;
    private final IDatabase db;

    public LoginListener(LoginController loginController, AuthenticationView view, IDatabase db) {
        this.loginController = loginController;
        this.view = view;
        this.db = db;
    }

    public void actionPerformed(ActionEvent e) {
        User user = null;

        for (User u : this.db.getUsers()) {
            if(u.getUserTag().equals(this.view.getUser().getUserTag()) && u.getUserPassword().equals(this.view.getUser().getUserPassword())) {
                user = u;
            }
        }

        if(loginController.checkUser(this.view.getUser())){

            this.loginController.setUser(user);

            this.view.showMessage("Login succesfully!");
        }else{
            this.view.showMessage("Invalid username and/or password!");
        }

    }
}
