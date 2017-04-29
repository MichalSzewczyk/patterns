package com.patterns.observer;

import com.patterns.observer.impl.CelsiusThermometer;
import com.patterns.observer.impl.IntelligentSmokeDetector;
import com.patterns.observer.impl.SmokeAlarm;
import com.patterns.observer.impl.TemperatureAlarm;

/**
 * Created by Michał Szewczyk on 2017-04-29.
 */
public class Main {
    public static void main(String[] args) {
        IntelligentSmokeDetector smokeDetector = new IntelligentSmokeDetector();
        SmokeAlarm smokeAlarm = new SmokeAlarm(smokeDetector);
        smokeDetector.setSmokeDetected(true);

        CelsiusThermometer celsiusThermometer = new CelsiusThermometer();
        TemperatureAlarm temperatureAlarm = new TemperatureAlarm(celsiusThermometer, 10);
        celsiusThermometer.setTemperature(20);
    }
}
