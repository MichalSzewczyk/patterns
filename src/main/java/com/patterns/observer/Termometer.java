package com.patterns.observer;

/**
 * Created by Michał Szewczyk on 2017-04-29.
 */
public interface Termometer {
    void addTemperatureObserver(TemperatureObserver observer);

    float getTemperature();
}
