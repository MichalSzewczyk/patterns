package com.patterns.decorator.impl;

import com.patterns.decorator.interfaces.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Michał Szewczyk on 2017-04-21.
 */

@Service
public class HtmlTextServiceDecorator implements TextService {
    @Qualifier("textServiceImpl")
    @Autowired
    private TextService textService;

    public HtmlTextServiceDecorator() {
    }

    public HtmlTextServiceDecorator(TextService textService) {
        this.textService = textService;
    }

    @Override
    public void saveText(String text) {
        String html =
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "<body>\n" +
                        "\n" +
                        text + "\n" +
                        "</body>\n" +
                        "</html>\n";
        textService.saveText(html);
    }
}
