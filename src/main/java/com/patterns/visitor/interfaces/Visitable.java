package com.patterns.visitor.interfaces;

/**
 * Created by Michał Szewczyk on 2017-04-30.
 */
public interface Visitable<V extends Visitor<V,T>, T extends Visitable<V,T>> {
    void accept(V visitor);
}
