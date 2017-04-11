package com.patterns.solid;

/**
 * Created by Michał Szewczyk on 2017-04-11.
 *
 * If T is subtype of type S then objects of type S may be replaced with objects of type T
 * without altering any of desirable properties of S
 */
public class LiskovSubstitutionPrinciple {
    //breaking the rule:
    class Addition {
        public int add (int a, int b){
            return a + b;
        }
    }

    class BrokenAddition extends Addition {
        @Override
        public int add (int a, int b){
            return a - b;
        }
    }
    //BrokenAddition breaks the Liskov substitution principle because it
    //gives different results then the base class and replacing Addition with BrokenAddition
    //would give different results
}
