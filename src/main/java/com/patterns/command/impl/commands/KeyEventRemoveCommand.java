package com.patterns.command.impl.commands;

import javax.swing.*;

/**
 * Created by Michał Szewczyk on 2017-04-21.
 */
public class KeyEventRemoveCommand extends KeyEventCommand {
    public KeyEventRemoveCommand(JTextField textField, String actionAfter, String actionBefore) {
        super(textField, actionAfter, actionBefore);
    }
}
