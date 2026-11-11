package org.zdanek.java.collections.devjava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

/*https://dev.java/learn/api/collections-and-streams/collections-framework/collection-interface/*/
public class A03CollectionInterface {

    void main(){
        addAndRemove();
        containsAll();
        retainAll();
        removeIf();

        IO.println("-----------");
        IO.println("");

    }

    private static void containsAll() {
        IO.println("-----------");
        IO.println("containsALL");
        IO.println("Takes another collection as an argument and returns true if all the elements of the other collections are contained in this collection.");

        Collection<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        Collection<String> first = new ArrayList<>();
        first.add("one");
        first.add("two");

        Collection<String> second = new ArrayList<>();
        second.add("one");
        second.add("four");

        IO.println("Is first contained in strings? " + strings.containsAll(first));
        IO.println("Is second contained in strings? " + strings.containsAll(second));
    }

    private static void addAndRemove() {
        IO.println("-----------");
        IO.println("AddAndRemoveElements");

        Collection<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        IO.println("strings = " + strings);
        strings.remove("one");
        IO.println("strings = " + strings);


    }

    private static void removeIf() {
        IO.println("-----------");
        IO.println("removeIf");
        IO.println("Removes all of the elements of this collection that satisfy the given predicate (optional operation).");

        Predicate<String> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNullOrEmpty = isNull.or(isEmpty);

        Collection<String> strings = new ArrayList<>();
        strings.add(null);
        strings.add("");
        strings.add("one");
        strings.add("two");
        strings.add("");
        strings.add("three");
        strings.add(null);

        IO.println("strings = " + strings);
        strings.removeIf(isNullOrEmpty);
        IO.println("filtered strings = " + strings);

    }

    private static void retainAll() {
        IO.println("-----------");
        IO.println("retainAll");
        IO.println("This operation retains only the elements from this collection that are contained in the other collection; all the others are removed.");

        Collection<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        IO.println("strings = " + strings);


        Collection<String> toBeRetained = new ArrayList<>();
        toBeRetained.add("one");
        toBeRetained.add("four");
        IO.println("toBeRetained = " + toBeRetained);

        boolean hasChanged = strings.retainAll(toBeRetained);

        IO.println("Has strings changed? " + hasChanged);
        IO.println("strings = " + strings);
    }

}
