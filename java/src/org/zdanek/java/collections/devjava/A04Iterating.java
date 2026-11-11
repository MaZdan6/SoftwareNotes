package org.zdanek.java.collections.devjava;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/*https://dev.java/learn/api/collections-and-streams/collections-framework/iterating/*/
public class A04Iterating {

    void main(){

        IO.println("-----------");
        IO.println("Iterating");


        forEach();


        iterator();

        https://dev.java/learn/api/collections-and-streams/collections-framework/iterating/#:~:text=Updating%20a%20Collection%20While%20Iterating%20over%20It

        IO.println("-----------");
        IO.println("");
        IO.println("");

    }

    private static void iterator() {
        IO.println("-----------");
        IO.println("Iterator");
        IO.println("Iterating over the elements of a collection uses a special object, an instance of the Iterator interface.");

        Collection<String> strings = List.of("one", "two", "three", "four");
        for (Iterator<String> iterator = strings.iterator(); iterator.hasNext();) {
            String element = iterator.next();
            if (element.length() == 3) {
                IO.println(element);
            }
        }
    }

    private static void forEach() {
        IO.println("-----------");
        IO.println("forEach");
        IO.println("");

        Collection<String> strings = List.of("one", "two", "three");

        for (String element: strings) {
            IO.println(element);
        }
    }


}
