package com.patterns.command.swing.impl;

import com.patterns.command.swing.interfaces.Command;

import javax.swing.*;

/**
 * Created by Michał Szewczyk on 2017-04-21.
 */

public class KeyEventCommand implements Command {
    private final String actionBefore;
    private final String actionAfter;
    private final JTextField textField;

    public KeyEventCommand(JTextField textField, String actionAfter, String actionBefore) {
        this.textField = textField;
        this.actionAfter = actionAfter;
        this.actionBefore = actionBefore;
    }

    @Override
    public void execute() {
        textField.setText(actionAfter);
    }

    @Override
    public void undo() {
        textField.setText(actionBefore);
    }
}
