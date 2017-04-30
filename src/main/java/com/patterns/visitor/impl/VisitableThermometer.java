package com.patterns.visitor.impl;

import com.patterns.observer.impl.CelsiusThermometer;
import com.patterns.visitor.interfaces.DetectorVisitor;

/**
 * Created by Michał Szewczyk on 2017-04-30.
 */
public class VisitableThermometer extends CelsiusThermometer {
    @Override
    public void accept(DetectorVisitor visitor) {
        visitor.visit(this);
    }
}
