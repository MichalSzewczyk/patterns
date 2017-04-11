package com.patterns.facade;

import com.patterns.facade.subsystem.controllers.BreakController;
import com.patterns.facade.subsystem.controllers.MainPowerController;
import com.patterns.facade.subsystem.controllers.OilPompController;
import com.patterns.facade.subsystem.controllers.SupportPowerController;

/**
 * Created by Michał Szewczyk on 2017-04-11.
 */
public interface CoolerFacade {
    void turnOnCooler();

    void turnOffCooler();

    BreakController getBreakController();

    MainPowerController getMainPowerController();

    OilPompController getOilPompController();

    SupportPowerController getSupportPowerController();
}
