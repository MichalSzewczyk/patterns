package com.patterns.iterator;

/**
 * Created by Michał Szewczyk on 2017-04-30.
 * <p>
 * Observable linked list
 */
public class Main {
    public static void main(String[] args) {
        BasicList<Integer> list = new LinkedList<>();
        //list basic usage
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(4, 4);
        list.remove(5);
        list.add(5, 5);
        //iterator with load balancer basic usage
        ListContainer<Integer> container = new ListContainer<>(5);

        container.addMany(1, 2, 3, 4);
        container.addMany(1, 2, 3, 4);
        container.addMany(1, 2, 3, 4, 5, 6, 7);
        container.addMany(1, 2);

        System.out.println(container);

        Iterator<Integer> it = container.getIterator();
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        while (it.hasNext()) {
            builder.append(it.next()).append(" ");
        }
        builder.append("]");
        System.out.println(builder.toString());
    }
}
