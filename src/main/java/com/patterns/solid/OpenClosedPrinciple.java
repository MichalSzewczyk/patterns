package com.patterns.solid;

/**
 * Created by Michał Szewczyk on 2017-04-11.
 * Software entities (classes, modules, functions, etc.) should be open for extension, but
 * closed for modification. If there is a need to extend the system, it should be possible
 * to do without changing already existing (and working) parts.
 */
public class OpenClosedPrinciple {
    //Breaking the rule:
    static class Processor {
        private final Settings settings;

        public Processor(Settings settings) {
            this.settings = settings;
        }

        private void firstOperation(){
            //...
        }

        private void secondOperation(){
            //...
        }

        public void performOperation(){
            if(settings.isFirst()){
                firstOperation();
            } else {
                secondOperation();
            }
        }
    }

    static class Settings {
        final private boolean first;

        public Settings(boolean first) {
            this.first = first;
        }

        public boolean isFirst() {
            return first;
        }
    }
    //In case of adding third operation we would have to change the Settings class which
    //breaks the open/closed principle
    //Better solution is for example to relay on polymorphism:
    interface AbstractProcessor {
        void operation ();
    }

    static class FirstProcessor implements AbstractProcessor{
        public void operation() {
            //instead of firstOperation
        }
    }

    static class SecondProcessor implements AbstractProcessor{
        public void operation() {
            //instead of secondOperation
        }
    }

    //in order to add new way of processing we can create a new implementation of AbstractProcessor
    //so no changes in already existing classes are done
}
