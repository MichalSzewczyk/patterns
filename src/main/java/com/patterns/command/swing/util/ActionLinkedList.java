package com.patterns.command.swing.util;

/**
 * Created by Michał Szewczyk on 2017-04-21.
 */
public class ActionLinkedList<T> implements ActionList<T> {
    private Node<T> actual;

    public void add(T value) {
        if (actual == null) {
            actual = new Node<>(value, null, null);
        } else if (actual.next != null) {
            Node<T> tmp = new Node<>(value, actual.next, actual);
            actual.next = tmp;
            actual = tmp;
        } else {
            Node<T> tmp = new Node<>(value, null, actual);
            actual.next = tmp;
            actual = tmp;
        }
    }

    public T stepBack() {
        if (actual.prev == null) return null;
        Node<T> tmp = actual;
        actual = actual.prev;
        return tmp.getValue();
    }

    public boolean canStepBack() {
        return actual.prev != null;
    }

    public boolean canStepForward() {
        return actual.next != null;
    }

    public T stepForward() {
        if (actual.next == null) return null;
        actual = actual.next;
        return actual.getValue();
    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;
        private Node<T> prev;

        private Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        private T getValue() {
            return value;
        }

        private Node<T> getNext() {
            return next;
        }

        private void setNext(Node<T> next) {
            this.next = next;
        }

        private Node<T> getPrev() {
            return prev;
        }

        private void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }
}
