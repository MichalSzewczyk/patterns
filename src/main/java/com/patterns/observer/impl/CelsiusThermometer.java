package com.patterns.observer.impl;

import com.patterns.observer.interfaces.Thermometer;
import com.patterns.visitor.impl.VisitableAbstractObservable;
import com.patterns.visitor.interfaces.DetectorVisitor;

/**
 * Created by Michał Szewczyk on 2017-04-29.
 */
public class CelsiusThermometer extends VisitableAbstractObservable implements Thermometer {
    private float temperature;

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        this.notifyObservers();
    }

    @Override
    public float getTemperature() {
        return temperature;
    }

    @Override
    public void accept(DetectorVisitor visitor) {
        visitor.visit(this);
    }
}
