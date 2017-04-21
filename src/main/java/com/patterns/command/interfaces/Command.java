package com.patterns.command.interfaces;

/**
 * Created by Michał Szewczyk on 2017-04-21.
 */
public interface Command {
    void execute();

    void undo();
}
