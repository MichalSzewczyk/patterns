package com.patterns.facade.subsystem.controllers;

import com.patterns.facade.subsystem.components.MainPower;

/**
 * Created by Michał Szewczyk on 2017-04-11.
 */
public class SupportPowerController {
    private MainPower mainPower;

    public SupportPowerController(MainPower mainPower) {
        this.mainPower = mainPower;
    }

    public void turnOn (){
        mainPower.setTurnedOn(true);
    }

    public void turnOff (){
        mainPower.setTurnedOn(true);
    }
}