package com.patterns.command.swing.interfaces;

/**
 * Created by Michał Szewczyk on 2017-04-21.
 */
public interface Invoker <T extends Command>{
    void storeCommand(T command);

    boolean canUndo();

    boolean canRedo();

    void undo();

    void redo();
}
