package com.patterns.state;

/**
 * Created by Michał Szewczyk on 2017-05-06.
 */
public class GameEngine {
    private int maxPlayers;
    private int minPlayers;
    private String[] players;

    public GameEngine(int minPlayers, int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.minPlayers = minPlayers;
    }

    void startGame(){

        System.out.println("Starting game.");
    }
    void setPlayers(String [] players){
        this.players = players;
        System.out.println("Setting players names.");
    }
    void deactivatePlayer(String userName){
        System.out.println("Deactivating player.");
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public int getMinPlayers() {
        return minPlayers;
    }
}
