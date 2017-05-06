package com.patterns.state;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Michał Szewczyk on 2017-05-06.
 */
public class GameSupervisor {
    private List<String> players;
    private GameEngine gameEngine;
    private String mainPlayer;
    private boolean isStarted;

    private void checkIfLowerThenMax(int playerNumber) {
        if (playerNumber > gameEngine.getMaxPlayers())
            throw new IllegalArgumentException("Number of users out of required bounds.");
    }

    private void checkIfGreaterThenMin(int playerNumber) {
        if (playerNumber < gameEngine.getMinPlayers())
            throw new IllegalArgumentException("Number of users out of required bounds.");
    }

    private void checkIfPlayerNumberInBounds(int playerNumber) {
        checkIfLowerThenMax(playerNumber);
        checkIfGreaterThenMin(playerNumber);
    }

    private void checkIfStarted() {
        if (isStarted)
            throw new IllegalStateException("Starting already started game.");
    }

    public GameSupervisor(String mainPlayer, int minPlayers, int maxPlayers) {
        this.mainPlayer = mainPlayer;
        this.players = new LinkedList<>();
        gameEngine = new GameEngine(minPlayers, maxPlayers);
    }

    void removePlayer(String userName) {
        checkIfGreaterThenMin(players.size() - 1);
        players.remove(userName);
        if (players.size() == 0)
            dispose();
    }

    void addPlayer(String userName) {
        checkIfStarted();
        checkIfLowerThenMax(players.size() + 1);
        players.add(userName);
    }

    void startGame() {
        gameEngine.setPlayers(players.toArray(new String[]{}));
        checkIfPlayerNumberInBounds(players.size());
        checkIfStarted();
        gameEngine.startGame();
        isStarted = true;
        gameEngine.deactivatePlayer(mainPlayer);
    }

    void dispose() {

    }
}
