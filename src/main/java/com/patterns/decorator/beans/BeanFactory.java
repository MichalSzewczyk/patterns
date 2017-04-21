package com.patterns.decorator.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.PrintStream;

/**
 * Created by Michał Szewczyk on 2017-04-21.
 */

@Configuration
public class BeanFactory {
    @Bean
    PrintStream getPrintStream(){
        return System.out;
    }
}
