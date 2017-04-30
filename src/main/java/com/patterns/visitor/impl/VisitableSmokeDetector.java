package com.patterns.visitor.impl;

import com.patterns.observer.impl.IntelligentSmokeDetector;
import com.patterns.visitor.interfaces.DetectorVisitor;

/**
 * Created by Michał Szewczyk on 2017-04-30.
 */
public class VisitableSmokeDetector extends IntelligentSmokeDetector {
    @Override
    public void accept(DetectorVisitor visitor) {
        visitor.visit(this);
    }
}
