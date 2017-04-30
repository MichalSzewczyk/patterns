package com.patterns.visitor.interfaces;

import com.patterns.observer.impl.CelsiusThermometer;
import com.patterns.visitor.impl.VisitableAbstractObservable;
import com.patterns.visitor.impl.VisitableSmokeDetector;

/**
 * Created by Michał Szewczyk on 2017-04-30.
 */
public interface DetectorVisitor extends Visitor<DetectorVisitor, VisitableAbstractObservable> {
    void visit(VisitableSmokeDetector visitable);

    void visit(CelsiusThermometer visitable);
}
