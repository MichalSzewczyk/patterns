package com.patterns.iterator;

import com.patterns.observer.interfaces.Observer;

/**
 * Created by Michał Szewczyk on 2017-04-30.
 */
public interface Iterator<T> extends Observer {
    T next();

    boolean hasNext();
}
