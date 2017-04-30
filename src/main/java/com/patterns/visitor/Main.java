package com.patterns.visitor;

import com.patterns.visitor.impl.DetectorVisitorImpl;
import com.patterns.visitor.impl.VisitableSmokeDetector;
import com.patterns.visitor.impl.VisitableThermometer;
import com.patterns.visitor.interfaces.DetectorVisitor;

/**
 * Created by Michał Szewczyk on 2017-04-30.
 */
public class Main {
    public static void main(String[] args) {
        DetectorVisitor detectorVisitor = new DetectorVisitorImpl();
        VisitableSmokeDetector visitableSmokeDetector = new VisitableSmokeDetector();

        VisitableThermometer visitableThermometer = new VisitableThermometer();

        detectorVisitor.visit(visitableSmokeDetector);
        detectorVisitor.visit(visitableThermometer);

        visitableSmokeDetector.setSmokeDetected(true);
        visitableThermometer.setTemperature(20);
    }
}
