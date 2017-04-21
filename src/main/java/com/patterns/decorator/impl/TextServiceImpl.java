package com.patterns.decorator.impl;

import com.patterns.decorator.interfaces.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.PrintStream;

/**
 * Created by Michał Szewczyk on 2017-04-21.
 */

@Qualifier("textServiceImpl")
@Service
public class TextServiceImpl implements TextService {
    private final PrintStream printStream;

    @Autowired
    public TextServiceImpl(PrintStream printStream) {
        this.printStream = printStream;
    }

    @Override
    public void saveText(String text) {
        printStream.print(text);
    }
}
