package com.patterns.observer;

/**
 * Created by Michał Szewczyk on 2017-04-29.
 */
public interface SmokeDetector {
    boolean hasSmokeBeenDetected();

    void addSmokeObserver(SmokeObserver observer);
}
