package com.patterns.observer.impl;

import com.patterns.observer.interfaces.SmokeDetector;

/**
 * Created by Michał Szewczyk on 2017-04-29.
 */
public class SmokeAlarm extends Alarm<SmokeDetector> {
    private static final String smokeAlert = "Smoke has been detected.";

    public SmokeAlarm(SmokeDetector observable) {
        super(observable);
    }

    @Override
    public void notifyStateChange() {
        if(this.observable.hasSmokeBeenDetected()){
            System.out.println(smokeAlert);
        }
    }
}
