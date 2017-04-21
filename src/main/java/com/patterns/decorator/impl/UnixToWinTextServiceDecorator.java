package com.patterns.decorator.impl;

import com.patterns.decorator.interfaces.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Michał Szewczyk on 2017-04-21.
 */

@Service
public class UnixToWinTextServiceDecorator implements TextService {
    @Qualifier("textServiceImpl")
    @Autowired
    private TextService textService;

    public UnixToWinTextServiceDecorator() {
    }

    public UnixToWinTextServiceDecorator(TextService textService) {
        this.textService = textService;
    }


    @Override
    public void saveText(String text) {
        text = text.replaceAll("\n", "\r\n");
        textService.saveText(text);
    }
}
