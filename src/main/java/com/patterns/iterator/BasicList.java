package com.patterns.iterator;

/**
 * Created by Michał Szewczyk on 2017-04-30.
 */
public interface BasicList<T> {
    T get(int index);

    void remove(int index);

    void add(T value);

    void add(T value, int index);

    Iterator<T> getIterator();

    int size();
}
