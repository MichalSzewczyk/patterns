package com.patterns.decorator.impl;

import com.patterns.decorator.interfaces.TextService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Michał Szewczyk on 2017-04-21.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.patterns.decorator");
        String testText = "sample \ntest \ntext";
        TextService serviceNormal = context.getBean(TextServiceImpl.class);
        serviceNormal.saveText(testText);
        TextService serviceHtmlDecorator = context.getBean(HtmlTextServiceDecorator.class);
        serviceHtmlDecorator.saveText(testText);
        TextService serviceUnixToWin = context.getBean(UnixToWinTextServiceDecorator.class);
        serviceUnixToWin.saveText(testText);
    }
}
