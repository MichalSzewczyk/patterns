package com.patterns.facade;

import com.patterns.facade.subsystem.controllers.BreakController;
import com.patterns.facade.subsystem.controllers.MainPowerController;
import com.patterns.facade.subsystem.controllers.OilPompController;
import com.patterns.facade.subsystem.controllers.SupportPowerController;

/**
 * Created by Michał Szewczyk on 2017-04-11.
 * Facade gives simplified interface to use complex system.
 * Facade can:
 * 1. make software library easier to use
 * 2. make library more readable
 * 3. reduce dependencies of outside code
 * 4. wrap poorly designed collection of API with a single, well design API
 * <p>
 * Facade is used when the system is complex and difficult to understand, this pattern hides complexity
 * of larger system.
 */
public class CoolerFacadeImpl implements CoolerFacade {
    private BreakController breakController;
    private MainPowerController mainPowerController;
    private OilPompController oilPompController;
    private SupportPowerController supportPowerController;

    public CoolerFacadeImpl(BreakController breakController, MainPowerController mainPowerController, OilPompController oilPompController, SupportPowerController supportPowerController) {
        this.breakController = breakController;
        this.mainPowerController = mainPowerController;
        this.oilPompController = oilPompController;
        this.supportPowerController = supportPowerController;
    }

    //Facade simplifies usage of complex system:
    public void turnOnCooler() {
        oilPompController.turnPompsOn();
        breakController.turnOff();
        mainPowerController.turnOn();
        supportPowerController.turnOn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Waiting to stand up was interrupted.");
        }
        supportPowerController.turnOff();
        System.out.println("System is running.");
    }

    public void turnOffCooler() {
        mainPowerController.turnOff();
        breakController.turnOn();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Waiting to stop was interrupted.");
        }
        oilPompController.turnPompsOff();
    }

    // But also provides the way to use elements of subsystem directly:
    public BreakController getBreakController() {
        return breakController;
    }

    public MainPowerController getMainPowerController() {
        return mainPowerController;
    }

    public OilPompController getOilPompController() {
        return oilPompController;
    }

    public SupportPowerController getSupportPowerController() {
        return supportPowerController;
    }

}
