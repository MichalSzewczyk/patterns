package com.patterns.bridge;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Michał Szewczyk on 2017-05-05.
 */
public abstract class DerivedAbstraction<T extends Comparable<T>> extends MainAbstraction<T> {
    public abstract Object[] sort(ArrayList<T> collection, Comparator<T> comparator);
}
