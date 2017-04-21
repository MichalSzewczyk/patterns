package com.patterns.command.swing;


import com.patterns.command.interfaces.GuiGenerator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Michał Szewczyk on 2017-04-20.
 * <p>
 * Basic swing application to show usage of command pattern.
 */
public class SwingApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.patterns.command");
        GuiGenerator generator = context.getBean(GuiGenerator.class);

        javax.swing.SwingUtilities.invokeLater(generator::generateGui);
    }
}
