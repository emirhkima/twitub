package com.ubo.tp.twitub.controller;

import com.ubo.tp.twitub.core.Twitub;
import com.ubo.tp.twitub.datamodel.*;
import com.ubo.tp.twitub.ihm.AuthenticationView;
import com.ubo.tp.twitub.controller.ILoginObserver;

import java.util.HashSet;
import java.util.Set;

public class LoginController {

    private IDatabase db;
    private User user;
    private AuthenticationView view;
    private Twitub mainController;
    protected final Set<ILoginObserver> observers;

    public LoginController(AuthenticationView view, IDatabase db, Twitub mainController){
        this.view = view;
        this.db = db;
        this.mainController = mainController;
        this.observers = new HashSet<>();
    }

    public boolean checkUser(User user) {

        for (User u : this.db.getUsers()) {
            if(u.getUserTag().equals(user.getUserTag()) && u.getUserPassword().equals(user.getUserPassword())) {
                this.view.setVisible(false);
                this.view.dispose();
                return true;
            }
        }

        return false;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.mainController.setUser(user);
        this.mainController.initMainView();
    }

    public void addObserver(ILoginObserver observer) {
        this.observers.add(observer);
    }
}