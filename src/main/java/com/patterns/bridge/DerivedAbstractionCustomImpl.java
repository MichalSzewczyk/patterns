package com.patterns.bridge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.BiFunction;

/**
 * Created by Michał Szewczyk on 2017-05-05.
 */

@SuppressWarnings("unchecked")
public class DerivedAbstractionCustomImpl<T extends Comparable<T>> extends DerivedAbstraction<T> {
    private Object[] sort(ArrayList<T> collection, BiFunction<T, T, Integer> compareTo) {
        //bubble sort
        boolean hasChanged = true;
        Object[] arr = collection.toArray();
        while (hasChanged) {
            hasChanged = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (compareTo.apply((T) arr[i], (T) arr[i + 1]) > 0) {
                    T tmp = (T) arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    hasChanged = true;
                    break;
                }
            }
        }
        return arr;
    }

    @Override
    public Object[] sort(ArrayList<T> collection, Comparator<T> comparator) {
        return sort(collection, comparator::compare);
    }

    @Override
    public Object[] sort(ArrayList<T> collection) {
        return sort(collection, (BiFunction<T, T, Integer>) Comparable::compareTo);
    }
}
