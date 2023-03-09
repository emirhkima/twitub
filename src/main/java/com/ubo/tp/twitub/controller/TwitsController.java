package com.ubo.tp.twitub.controller;

import com.ubo.tp.twitub.datamodel.IDatabase;
import com.ubo.tp.twitub.datamodel.Twit;
import com.ubo.tp.twitub.datamodel.User;
import com.ubo.tp.twitub.ihm.TwitsView;
import com.ubo.tp.twitub.controller.ILoginObserver;

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
        this.observers = new HashSet<ILoginObserver>();
        this.twits = new HashSet<>();
    }

    public void addObserver(ILoginObserver observer) {
        this.observers.add(observer);
    }
}