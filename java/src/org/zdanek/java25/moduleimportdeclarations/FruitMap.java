package org.zdanek.java25.moduleimportdeclarations;

/*import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;*/

import module java.base;

//https://docs.oracle.com/en/java/javase/25/language/module-import-declarations.html#GUID-E1581E3A-2B0F-4F3B-8FF1-6EBEC8A210DB
//Module Import Declarations
public class FruitMap {
    void main() {
        String[] fruits = new String[] { "apple", "berry", "citrus" };
        Map<String, String> m = Stream
                .of(fruits)
                .collect(Collectors.toMap(
                        s -> s.toUpperCase().substring(0,1),
                        Function.identity()));
        m.forEach((k, v) ->
                IO.println(k + " " + v));
    }
}
