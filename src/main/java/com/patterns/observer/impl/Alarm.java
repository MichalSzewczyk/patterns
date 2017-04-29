package com.patterns.observer.impl;

import com.patterns.observer.interfaces.Observable;
import com.patterns.observer.interfaces.Observer;

/**
 * Created by Michał Szewczyk on 2017-04-29.
 */
public abstract class Alarm<T extends Observable> implements Observer {
    protected final T observable;

    public Alarm(T observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    public abstract void notifyStateChange();
}
