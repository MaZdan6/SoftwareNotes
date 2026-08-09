package org.zdanek.java25;

//Instance Main Methods
public class InstanceMainMethods {

    int number= 6;

    void main() {
        System.out.println("Hello, World!");
        System.out.println("Hello from instance main!");
        System.out.println("Value of i : " + number);

        IO.println("Enter your name:");
        String name = IO.readln();
        IO.println("Hello, " + name + "!");

    }
}
