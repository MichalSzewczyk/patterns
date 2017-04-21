package com.patterns.command.swing.util;

/**
 * Created by Michał Szewczyk on 2017-04-21.
 */
public interface ActionList<T> {
    void add(T value);

    T stepBack();

    T stepForward();

    boolean canStepBack();

    boolean canStepForward();
}
