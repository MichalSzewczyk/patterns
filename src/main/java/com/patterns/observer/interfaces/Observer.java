package com.patterns.observer.interfaces;

/**
 * Created by Michał Szewczyk on 2017-04-29.
 */

@FunctionalInterface
public interface Observer {
    void notifyStateChange();
}
