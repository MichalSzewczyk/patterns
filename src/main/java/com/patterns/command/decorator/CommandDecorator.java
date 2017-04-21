package com.patterns.command.decorator;

import com.patterns.command.interfaces.Command;

/**
 * Created by Michał Szewczyk on 2017-04-21.
 */
public class CommandDecorator implements Command {
    private final Command command;
    private static int counter;

    public CommandDecorator(Command command) {
        this.command = command;
        counter++;
    }

    @Override
    public void execute() {
        command.execute();
        counter++;
    }

    @Override
    public void undo() {
        command.undo();
        counter--;
    }

    public static int getCounter() {
        return counter;
    }
}
