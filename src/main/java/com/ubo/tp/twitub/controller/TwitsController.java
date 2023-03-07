package main.java.com.ubo.tp.twitub.controller;

import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.ihm.AuthenticationView;
import main.java.com.ubo.tp.twitub.ihm.TwitsView;

import java.util.HashSet;
import java.util.Set;

public class TwitsController {

    private IDatabase db;
    private User user;
    private TwitsView view;
    protected Set<ILoginObserver> observers;
    protected Set<Twit> twits;

    public TwitsController(TwitsView view, IDatabase db, User user){
        this.view = view;
        this.db = db;
        this.user = user;
        this.observers = new HashSet<>();
        this.twits = new HashSet<>();
    }

    public void addObserver(ILoginObserver observer) {
        this.observers.add(observer);
    }
}