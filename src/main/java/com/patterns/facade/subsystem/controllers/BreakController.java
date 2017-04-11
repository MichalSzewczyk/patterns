package com.patterns.facade.subsystem.controllers;

import com.patterns.facade.subsystem.components.Break;

/**
 * Created by Michał Szewczyk on 2017-04-11.
 */
public class BreakController {
    private final Break coolerBreak;

    public BreakController(Break coolerBreak) {
        this.coolerBreak = coolerBreak;
    }

    public void turnOn (){
        coolerBreak.setTurnedOn(true);
    }

    public void turnOff (){
        coolerBreak.setTurnedOn(true);
    }

}
