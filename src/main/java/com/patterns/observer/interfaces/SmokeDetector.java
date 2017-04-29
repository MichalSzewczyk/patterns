package com.patterns.observer.interfaces;

/**
 * Created by Michał Szewczyk on 2017-04-29.
 */
public interface SmokeDetector extends Observable {
    boolean hasSmokeBeenDetected();
}
