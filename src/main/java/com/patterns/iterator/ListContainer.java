package com.patterns.iterator;

import com.patterns.observer.interfaces.Observable;
import com.patterns.observer.interfaces.Observer;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

/**
 * Created by Michał Szewczyk on 2017-04-30.
 */

@SuppressWarnings("unchecked")
public class ListContainer<T> implements Observable {
    private int counter;
    private int numberOfLists;
    private List<Observer> observers;
    private BasicList[] lists;

    public ListContainer(int numberOfLists) {
        this.numberOfLists = numberOfLists;
        this.lists = new BasicList[numberOfLists];
        observers = new java.util.LinkedList<>();
        for (int i = 0; i < numberOfLists; i++) {
            this.lists[i] = new LinkedList();
        }
    }

    private int loadBalancer(int numberOfElements) {
        OptionalDouble avgLoad = Stream.of(lists).mapToInt(BasicList::size).average();
        int roundedAvg = (int) avgLoad.orElseThrow(IllegalStateException::new);
        int index = 0;
        int bestValue = Integer.MAX_VALUE;
        for (int i = 0; i < numberOfLists; i++) {
            if (bestValue > lists[i].size() + numberOfElements - roundedAvg) {
                bestValue = lists[i].size() + numberOfElements - roundedAvg;
                index = i;
            }
        }
        return index;
    }

    public void addMany(T... elements) {
        notifyObservers();
        int index = loadBalancer(elements.length);
        Stream.of(elements).forEach(lists[index]::add);
    }

    public Iterator<T> getIterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private BasicList[] lists = ListContainer.this.lists;
            private int listCounter;
            private Iterator currentIterator = lists[listCounter].getIterator();

            @Override
            public T next() {
                if (!currentIterator.hasNext()) {
                    while (!currentIterator.hasNext())
                        currentIterator = lists[++listCounter].getIterator();
                }
                return (T) currentIterator.next();
            }

            @Override
            public boolean hasNext() {
                if (currentIterator.hasNext())
                    return true;
                while (!currentIterator.hasNext()) {
                    if (listCounter == lists.length - 1)
                        return false;
                    currentIterator = lists[++listCounter].getIterator();
                }
                return true;
            }

            @Override
            public void notifyStateChange() {
                throw new ConcurrentModificationException();
            }
        };
        return iterator;
    }

    @Override
    public void addObserver(Observer observer) {
        this.addObserver(observer);
    }

    private void notifyObservers() {
        this.observers.forEach(Observer::notifyStateChange);
    }

    @Override
    public String toString() {
        return "ListContainer{" +
                "lists=" + Arrays.toString(lists) +
                '}';
    }
}
