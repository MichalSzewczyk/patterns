package com.patterns.observer.impl;

import com.patterns.observer.interfaces.SmokeDetector;

/**
 * Created by Michał Szewczyk on 2017-04-29.
 */
public class InteligentSmokeDetector extends AbstractObservable implements SmokeDetector{
    private boolean smokeDetected;

    public void setSmokeDetected(boolean smokeDetected) {
        this.smokeDetected = smokeDetected;
    }

    @Override
    public boolean hasSmokeBeenDetected() {
        return smokeDetected;
    }
}
