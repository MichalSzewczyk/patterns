package com.patterns.observer.impl;

import com.patterns.observer.interfaces.Thermometer;

/**
 * Created by Michał Szewczyk on 2017-04-29.
 */
public class CelsiusThermometer extends AbstractObservable implements Thermometer {
    private float temperature;

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        this.notifyObservers();
    }

    @Override
    public float getTemperature() {
        return temperature;
    }
}
