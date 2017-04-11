package com.patterns.facade.subsystem.controllers;

import com.patterns.facade.subsystem.components.OilPomp;

/**
 * Created by Michał Szewczyk on 2017-04-11.
 */
public class OilPompController {
    private OilPomp first;

    private OilPomp second;

    public OilPompController(OilPomp first, OilPomp second) {
        this.first = first;
        this.second = second;
    }

    public void turnPompsOn() {
        first.setTurnedOn(true);
        second.setTurnedOn(true);
    }

    public void turnPompsOff() {
        first.setTurnedOn(false);
        second.setTurnedOn(false);
    }
}
