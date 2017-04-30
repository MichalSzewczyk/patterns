package com.patterns.visitor.impl;

import com.patterns.observer.impl.CelsiusThermometer;
import com.patterns.visitor.interfaces.DetectorVisitor;

/**
 * Created by Michał Szewczyk on 2017-04-30.
 */
public class DetectorVisitorImpl implements DetectorVisitor {
    @Override
    public void visit(VisitableAbstractObservable visitable) {
        visitable.addObserver(() -> System.out.println("Abstract observable changed it's state."));
    }

    @Override
    public void visit(VisitableSmokeDetector visitable) {
        visitable.addObserver(() -> {
            if (visitable.hasSmokeBeenDetected()) {
                System.out.println("Smoke alarm!");
            }
        });
    }

    @Override
    public void visit(CelsiusThermometer visitable) {
        visitable.addObserver(() -> {
            if (visitable.getTemperature() > 10) {
                System.out.println("Temperature exceeds the limit!");
            }
        });
    }
}
