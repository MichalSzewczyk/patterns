package com.patterns.solid;

/**
 * Created by Michał Szewczyk on 2017-04-11.
 * <p>
 * Users of the interface should not be forced to implement methods which they are not using
 */
public class InterfaceSegregation {
    //Breaking the rule:
    interface OnlineShopItem {
        String getName();

        String getCode();

        int getWeight();
    }

    //The following example is ok:
    class Book implements OnlineShopItem {
        public String getName() {
            return "Sample Book";
        }

        public String getCode() {
            return "foo";
        }

        public int getWeight() {
            return 10;
        }
    }

    //But in case of eBook how can we get it's physical weight?
    class EBook implements OnlineShopItem {
        public String getName() {
            return "Sample Book";
        }

        public String getCode() {
            return "foo";
        }

        //Interface segregation is broken here:
        public int getWeight() {
            throw new UnsupportedOperationException();
        }
    }


}
