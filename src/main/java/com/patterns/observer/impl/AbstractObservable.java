package com.patterns.observer.impl;

import com.patterns.observer.interfaces.Observable;
import com.patterns.observer.interfaces.Observer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Michał Szewczyk on 2017-04-29.
 */
public abstract class AbstractObservable implements Observable {
    protected List<Observer> observers;

    public AbstractObservable() {
        this.observers = new LinkedList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    protected void notifyObservers(){
        observers.forEach(Observer::notifyStateChange);
    }
}
