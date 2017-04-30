package com.patterns.iterator;

import com.patterns.observer.interfaces.Observable;
import com.patterns.observer.interfaces.Observer;

import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Created by Michał Szewczyk on 2017-04-30.
 */
public class LinkedList<T> implements BasicList<T>, Observable {
    private Node head;
    private Node tail;
    private int size;
    private List<Observer> observers;

    public LinkedList() {
        observers = new java.util.LinkedList<>();
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    private Node getNode(int index) {
        Node actual = head;
        int counter = 0;
        while (counter++ != index) {
            actual = actual.next;
        }
        return actual;
    }

    @Override
    public void remove(int index) {
        notifyObservers();
        if (index == 0) {
            head = head.next;
        } else {
            Node toRemove = getNode(index - 1);
            toRemove.next = toRemove.next.next;
        }
        size--;
    }

    @Override
    public void add(T value) {
        notifyObservers();
        Node added = new Node(value);
        if (head == null) {
            head = added;
        }
        if (tail == null) {
            tail = added;
        } else {
            tail.next = added;
        }
        tail = added;
        size++;
    }

    @Override
    public void add(T value, int index) {
        notifyObservers();
        if (index == 0) {
            Node added = new Node(value);
            added.next = head;
            head = added;
        } else {
            Node prev = getNode(index - 1);
            Node added = new Node(value);
            if (prev != null) {
                added.next = prev.next;
                prev.next = added;
            }
        }
        size++;
    }

    @Override
    public Iterator<T> getIterator() {
        Iterator<T> iterator = new Iterator<T>() {
            private Node actual = LinkedList.this.head;

            @Override
            public T next() {
                actual = actual.next;
                return actual.value;
            }

            @Override
            public boolean hasNext() {
                return actual != null && actual.next != null;
            }

            @Override
            public void notifyStateChange() {
                throw new ConcurrentModificationException();
            }
        };
        this.addObserver(iterator);
        return iterator;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node actual = head;
        while (actual != null && actual.next != null) {
            stringBuilder.append(actual.value);
            if (actual.next.next != null) stringBuilder.append(", ");
            actual = actual.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    private void notifyObservers() {
        observers.forEach(Observer::notifyStateChange);
    }

    private class Node {
        private Node next;
        private T value;

        private Node(T value) {
            this.value = value;
        }
    }


}
