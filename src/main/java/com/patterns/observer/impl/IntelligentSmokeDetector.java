package com.patterns.observer.impl;

import com.patterns.observer.interfaces.SmokeDetector;
import com.patterns.visitor.impl.VisitableAbstractObservable;
import com.patterns.visitor.interfaces.DetectorVisitor;

/**
 * Created by Michał Szewczyk on 2017-04-29.
 */
public class IntelligentSmokeDetector extends VisitableAbstractObservable implements SmokeDetector{
    private boolean smokeDetected;

    public void setSmokeDetected(boolean smokeDetected) {
        this.smokeDetected = smokeDetected;
        this.notifyObservers();
    }

    @Override
    public boolean hasSmokeBeenDetected() {
        return smokeDetected;
    }

    @Override
    public void accept(DetectorVisitor visitor) {
        visitor.visit(this);
    }
}
