package com.patterns.visitor.impl;

import com.patterns.observer.impl.AbstractObservable;
import com.patterns.visitor.interfaces.DetectorVisitor;
import com.patterns.visitor.interfaces.Visitable;

/**
 * Created by Michał Szewczyk on 2017-04-30.
 */
public abstract class VisitableAbstractObservable extends AbstractObservable implements Visitable<DetectorVisitor, VisitableAbstractObservable> {

}
