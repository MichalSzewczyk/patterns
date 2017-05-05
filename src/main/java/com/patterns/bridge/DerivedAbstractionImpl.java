package com.patterns.bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Michał Szewczyk on 2017-05-05.
 */
public class DerivedAbstractionImpl<T extends Comparable<T>> extends DerivedAbstraction<T> {
    @Override
    public Object[] sort(ArrayList<T> collection, Comparator<T> comparator) {
        Collections.sort(collection, comparator);
        return collection.toArray();
    }

    @Override
    public Object[] sort(ArrayList<T> collection) {
        Collections.sort(collection);
        return collection.toArray();
    }
}
