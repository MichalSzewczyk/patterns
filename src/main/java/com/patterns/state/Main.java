package com.patterns.state;

/**
 * Created by Michał Szewczyk on 2017-05-06.
 */
public class Main {
    public static void main(String[] args) {
        GameSupervisor g = new GameSupervisor("1", 3, 5);
        g.addPlayer("1");
        g.addPlayer("2");
        g.addPlayer("3");
        try {
            g.removePlayer("2");
        } catch (Throwable t) {
            System.out.println(String.format("Thrown %s as expected.", t.getMessage()));
        }
        g.addPlayer("4");
        g.addPlayer("5");
        try {
            g.addPlayer("6");
        } catch (Throwable t) {
            System.out.println(String.format("Thrown %s as expected.", t.getMessage()));
        }
        g.removePlayer("5");
        g.removePlayer("1");
        g.startGame();
    }
}
