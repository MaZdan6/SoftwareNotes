package org.zdanek.java25.flexibleconstructorbodies;

public class Employee extends Person{
    String department;

    Employee(String name, int age, String department) {
        // Flexible constructor body allows this:
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older");
        }
        System.out.println("Initializing Employee...");

        super(name, age); // can call super AFTER code

        this.department = department;
        System.out.println("Employee assigned to department: " + department);
    }
}
