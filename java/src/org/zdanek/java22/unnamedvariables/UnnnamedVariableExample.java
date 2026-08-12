package org.zdanek.java22.unnamedvariables;

//https://docs.oracle.com/en/java/javase/25/language/unnamed-variables-patterns.html#GUID-D54E1CF1-BDFD-4B57-8A6E-5B4C87F4D58A
public class UnnnamedVariableExample {

    void unnamedVariable() {
        int[] orderIDs = {34, 45, 23, 27, 15};
        int total = 0;
        for (int _ : orderIDs) {
            total++;
        }
        System.out.println("Total: " + total);
    }

    void namedVariable() {
        int[] orderIDs = {34, 45, 23, 27, 15};
        int total = 0;
        for (int id : orderIDs) {
            total++;
        }
        IO.println("Total: " + total);
    }

    void main() {
        //old
        namedVariable();
        //new
        unnamedVariable();

    }




}
