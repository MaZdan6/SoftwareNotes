package org.zdanek.java25.flexibleconstructorbodies;

public class Person {

    String name;
    int age;

    Person(String name, int age) {
        System.out.println("Person constructor called");
        IO.println(String.format("Name:%s, age=%s", name, age));
        this.name = name;
        this.age = age;
    }
}
