package org.zdanek.java.function.predicate.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

//https://dev.java/learn/language/fp/lambdas/functional-interfaces/
public class A02UsingLambdas {
    void main(){


        IO.println("------");
        IO.println("Supplier");
        Random random = new Random(314L);
        Supplier<Integer> newRandom = () -> random.nextInt(10);

        for (int index = 0; index < 5; index++) {
            IO.println(newRandom.get() + " ");
        }

        IO.println("------");
        IO.println("Using Specialized Supplier");
        Random randomInt = new Random(314L);
        IntSupplier newRandomInt = () -> randomInt.nextInt(10);
        for (int i = 0; i < 5; i++) {
            int nextRandom = newRandomInt.getAsInt();
            IO.println("next random = " + nextRandom);
        }

        IO.println("------");
        IO.println("Implementing and Using Consumers");
        IntSupplier newRandomIntC = () -> randomInt.nextInt(10);
        Consumer<String> printer = s -> IO.println(s);
        for (int i = 0; i < 5; i++) {
            int nextRandom = newRandomIntC.getAsInt();
            printer.accept("next random = " + nextRandom);
        }

        IO.println("------");
        IO.println("Consuming Two Elements with a BiConsumer");
        BiConsumer<Random, Integer> randomNumberPrinter =
                (randomB, number) -> {
                    for (int i = 0; i < number; i++) {
                        IO.println("next random = " + randomB.nextInt(10));
                    }
                };
        randomNumberPrinter.accept(new Random(314L), 3);

        IO.println("------");
        IO.println("Implementing and Using Predicates");
        Predicate<String> length3 = s -> s.length() == 3;
        String word = "Ana"; // any word
        boolean isOfLength3 = length3.test(word);
        IO.println("Is '"+word+"'of length 3? " + isOfLength3);

        IO.println("------");
        IO.println("Testing Two Elements with a BiPredicate");
        BiPredicate<String, Integer> isOfLength = (wordB, length) -> word.length() == length;
        String wordB = "Lambda"; // really any word will do!
        int length = 3;
        boolean isWordOfLength3 = isOfLength.test(word, length);
        IO.println("Is '"+wordB+"'of length 3? " + isOfLength.test(word, length));

        IO.println("------");
        IO.println("Passing a Predicate to a Collection");
        List<String> immutableStrings =
                List.of("one", "two", "three", "four", "five");
        List<String> strings = new ArrayList<>(immutableStrings);
        IO.println("strings = " + strings);
        Predicate<String> isEvenLength = s -> s.length() % 2 == 0;
        strings.removeIf(isEvenLength);
        IO.println("strings = " + strings);



        IO.println("------");
        IO.println("UnaryOperator");
        IO.println("Passing a Unary Operator to a List");
        List<String> stringsU = Arrays.asList("one", "two", "three");
        IO.println(stringsU);
        UnaryOperator<String> toUpperCase = wordU -> wordU.toUpperCase();
        stringsU.replaceAll(toUpperCase);
        IO.println(stringsU);

    }
}
