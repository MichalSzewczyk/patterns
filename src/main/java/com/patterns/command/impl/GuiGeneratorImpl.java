package com.patterns.command.impl;

import com.patterns.command.decorator.CommandDecorator;
import com.patterns.command.impl.commands.KeyEventAddCommand;
import com.patterns.command.impl.commands.KeyEventCommand;
import com.patterns.command.impl.commands.KeyEventRemoveCommand;
import com.patterns.command.interfaces.Command;
import com.patterns.command.interfaces.GuiGenerator;
import com.patterns.command.interfaces.Invoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Michał Szewczyk on 2017-04-20.
 */

@Component
public class GuiGeneratorImpl implements GuiGenerator {
    private JFrame frame;
    private JTextField textField;
    private JButton undoButton;
    private JButton redoButton;
    private JLabel label;
    private Invoker<Command> invoker;

    @Autowired
    public GuiGeneratorImpl(Invoker<Command> invoker) {
        this.invoker = invoker;
        invoker.storeCommand(new KeyEventCommand(textField, "", ""));
    }

    private void prepareMainFrame() {
        frame = new JFrame("Basic Text Editor");
        frame.setLayout(new GridLayout(4, 1));
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void prepareTextField() {
        textField = new JTextField("", SwingConstants.CENTER);
    }

    private void prepareButtons() {
        undoButton = new JButton("Undo");
        undoButton.setEnabled(false);
        redoButton = new JButton("Redo");
        redoButton.setEnabled(false);
    }

    private void combineElements() {
        frame.getContentPane().add(textField);
        frame.getContentPane().add(undoButton);
        frame.getContentPane().add(redoButton);
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);
    }

    private void refresh() {
        redoButton.setEnabled(invoker.canRedo());
        undoButton.setEnabled(invoker.canUndo());
        label.setText(String.valueOf(CommandDecorator.getCounter()));
    }

    private void prepareLabel() {
        this.label = new JLabel("", SwingConstants.CENTER);
    }

    private void setListeners() {
        undoButton.addActionListener((actionEvent) -> {
            invoker.undo();
            refresh();
        });
        redoButton.addActionListener((actionEvent) -> {
            invoker.redo();
            refresh();
        });

        textField.addKeyListener(new KeyListener() {
            private String before;

            @Override
            public void keyTyped(KeyEvent e) {
                before = textField.getText();
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (before.length() > textField.getText().length())
                    invoker.storeCommand(new CommandDecorator(new KeyEventRemoveCommand(textField, textField.getText(), before)));
                else
                    invoker.storeCommand(new CommandDecorator(new KeyEventAddCommand(textField, textField.getText(), before)));
                refresh();
            }
        });
    }

    @Override
    public void generateGui() {
        prepareButtons();
        prepareMainFrame();
        prepareTextField();
        prepareLabel();
        setListeners();

        combineElements();
    }
}
