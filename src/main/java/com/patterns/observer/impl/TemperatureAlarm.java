package com.patterns.observer.impl;

/**
 * Created by Michał Szewczyk on 2017-04-29.
 */
public class TemperatureAlarm extends Alarm<CelsiusThermometer> {
    private final float maxTemperature;
    private final static String temperatureAlert = "Temperature is over limit:\nTemperature: %s\nLimit: %s\n";

    public TemperatureAlarm(CelsiusThermometer observable, float maxTemperature) {
        super(observable);
        this.maxTemperature = maxTemperature;
    }

    @Override
    public void notifyStateChange() {
        if(this.observable.getTemperature()>maxTemperature){
            System.out.println(String.format(temperatureAlert, this.observable.getTemperature(), maxTemperature));
        }
    }
}
