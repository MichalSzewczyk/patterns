package com.patterns.bridge;

import java.util.ArrayList;

/**
 * Created by Michał Szewczyk on 2017-05-05.
 */
public abstract class MainAbstraction<T extends Comparable<T>> {
    public abstract Object[] sort(ArrayList<T> collection);
}
