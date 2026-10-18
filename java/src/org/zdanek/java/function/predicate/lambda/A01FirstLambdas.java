package org.zdanek.java.function.predicate.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//https://dev.java/learn/language/fp/lambdas/first-lambdas/
public class A01FirstLambdas {
    void main(){
        /*
        Consumer () -> {}; s -> IO.println(s); takes something, returns nothing
        Supplier () -> t; () -> new Ballon(); takes no arguments, returns something
        Function t -> u; person -> person.getAge(); takes something, returns something else
        Predicate t -> true; age -> age > 20; takes something, returns boolean
        */
        IO.println("------");
        IO.println("// Consumer: takes something, returns nothing");
        // Consumer: takes something, returns nothing
        Consumer<String> printer = s -> IO.println("Message: " + s);
        printer.accept("Duke loves Java");
        printer.accept("Duke also loves coffee");

        IO.println("------");
        IO.println("// Supplier: takes no arguments, returns something");
        // Supplier: takes no arguments, returns something
        Supplier<String> greeting = () -> "Duke loves Java";
        IO.println("Did we already mention that " + greeting.get() + "?");


        IO.println("------");
        IO.println("// Predicate: takes something, returns boolean");
        // Predicate: takes something, returns boolean
        Predicate<String> hasFourChars = s -> s.length() == 4;
        IO.println("'Duke'  has 4 chars? " + hasFourChars.test("Duke"));
        IO.println("'loves' has 4 chars: " + hasFourChars.test("loves"));
        IO.println("'Java'  has 4 chars: " + hasFourChars.test("Java"));

        IO.println("------");
        IO.println("// Function: takes something, returns something else");
        // Function: takes something, returns something else
        Function<String, Integer> getLength = s -> s.length();
        IO.println("Length of 'Duke': " + getLength.apply("Duke"));


        IO.println("------");
        IO.println("");

    }
}
