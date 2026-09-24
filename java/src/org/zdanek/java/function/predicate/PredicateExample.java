package org.zdanek.java.function.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//https://www.baeldung.com/java-predicate-chain
public class PredicateExample {

    void main() {

        basicExamlple();
        multipleFilters();
        complexPredicate();
        combiningPredicates();
        PredicateOR();
        combinePredicatesInline();
        combiningCollectionOfPredicates();

    }

    private static void basicExamlple() {
        IO.println("-----");
        IO.println("basic example");
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        IO.println("all names: " + names.toString());
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        IO.println("names that start with A: " + result.toString());
    }

    private static void multipleFilters() {
        IO.println("-----");
        IO.println("multipleFilters");
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        IO.println("all names: " + names.toString());
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .filter(name -> name.length() < 5)
                .collect(Collectors.toList());
        IO.println("names that start with A and are longer than 5 shorter: " + result.toString());
    }

    private static void complexPredicate() {
        IO.println("-----");
        IO.println("complexPredicate");
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        IO.println("all names: " + names.toString());
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A") && name.length() < 5)
                .collect(Collectors.toList());
        IO.println("names that start with A and are longer than 5 shorter: " + result.toString());
    }

    private static void combiningPredicates() {
        IO.println("-----");
        IO.println("combiningPredicates");
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        IO.println("all names: " + names.toString());

        Predicate<String> predicate1 = str -> str.startsWith("A");
        Predicate<String> predicate2 = str -> str.length() < 5;

        List<String> result = names.stream()
                .filter(predicate1.and(predicate2))
                .collect(Collectors.toList());
        IO.println("names that start with A and are longer than 5 shorter: " + result.toString());
    }

    private static void PredicateOR() {
        IO.println("-----");
        IO.println("PredicateOR");
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        IO.println("all names: " + names.toString());

        Predicate<String> predicate1 = str -> str.startsWith("J");
        Predicate<String> predicate2 = str -> str.length() < 4;

        List<String> result = names.stream()
                .filter(predicate1.or(predicate2.negate()))
                .collect(Collectors.toList());
        IO.println("names that start with A OR are longer than 5 shorter: " + result.toString());
    }

    private static void combinePredicatesInline() {
        IO.println("-----");
        IO.println("combinePredicatesInline");
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        IO.println("all names: " + names.toString());

        List<String> result = names.stream()
                .filter(((Predicate<String>) name -> name.startsWith("A"))
                        .and(name -> name.length() < 5))
                .collect(Collectors.toList());
        IO.println("names that start with A AND are longer than 5 shorter: " + result.toString());
    }

    private static void combiningCollectionOfPredicates() {
        IO.println("-----");
        IO.println("combiningCollectionOfPredicates");
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        IO.println("all names: " + names.toString());

        List<Predicate<String>> allPredicates = new ArrayList<Predicate<String>>();
        allPredicates.add(str -> str.startsWith("A"));
        allPredicates.add(str -> str.contains("d"));
        allPredicates.add(str -> str.length() > 4);

        List<String> result = names.stream()
                .filter(allPredicates.stream().reduce(x->true, Predicate::and))
                .collect(Collectors.toList());
        IO.println("names that start with A AND contains 'd' AND are longer than 4: " + result.toString());
    }
}
