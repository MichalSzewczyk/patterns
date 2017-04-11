package com.patterns.solid;

/**
 * Created by Michał Szewczyk on 2017-04-11.
 *
 * Dependency inversion principle refers to specific form of decoupling software modules.
 * High level modules should not depend on low level modules, but on abstraction.
 * Abstraction should not depend on details. Details should depend on abstractions
 * We should define interaction between modules based on abstraction.
 */
public class DependencyInverision {
    //breaking the rule:
    class BrokenOperator {
        public void prepare (){
            //...
        }

        public void perform (){
            //...
        }

        public void operate (){
            //...
        }
    }

    class BrokenProcessor {
        BrokenOperator operator = new BrokenOperator();

        void process (){
            operator.prepare();
            operator.perform();
            operator.operate();
            //...
        }
    }

    interface Operator {
        void operate();
    }

    class BasicOperator implements Operator{
        public void operate() {
            prepare();
            perform();
            //...
        }
        private void prepare (){
            //...
        }

        private void perform (){
            //...
        }

    }

    class FixedProcessor {
        private final Operator operator;

        public FixedProcessor(Operator operator) {
            this.operator = operator;
        }

        void process (){
            operator.operate();
            //...
        }
    }
}
