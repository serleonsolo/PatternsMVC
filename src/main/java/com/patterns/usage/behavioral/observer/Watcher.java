package com.patterns.usage.behavioral.observer;

import java.util.Observable;

public class Watcher implements java.util.Observer {

    private int watcherId;

    public Watcher(int watcherId) {
        this.watcherId = watcherId;
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.format("Watcher with id: %d is notified, target object: %s, command: %s",watcherId,observable,o);
        System.out.println("");
    }
}
