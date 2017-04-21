package com.patterns.command.impl;

import com.patterns.command.interfaces.Command;
import com.patterns.command.interfaces.Invoker;
import com.patterns.command.swing.util.ActionLinkedList;
import com.patterns.command.swing.util.ActionList;
import org.springframework.stereotype.Service;

/**
 * Created by Michał Szewczyk on 2017-04-21.
 */

@Service
public class InvokerImpl implements Invoker<Command> {
    private final ActionList<Command> commands;

    public InvokerImpl() {
        this.commands = new ActionLinkedList<>();
    }

    @Override
    public void storeCommand(Command textCommand) {
        this.commands.add(textCommand);
    }

    @Override
    public boolean canUndo() {
        return this.commands.canStepBack();
    }

    @Override
    public boolean canRedo() {
        return this.commands.canStepForward();
    }

    @Override
    public void undo() {
        Command command = commands.stepBack();
        command.undo();
    }

    @Override
    public void redo() {
        Command command = commands.stepForward();
        command.execute();
    }


}
