package org.zdanek.java.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

//https://www.baeldung.com/java-8-streams
public class StreamCreation {

    void main(){

        //empty()
        Stream<String> streamEmpty = Stream.empty();

        IO.println("-----------");
        IO.println("streamOfCollection");
        Collection<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> streamOfCollection = collection.stream();
        streamOfCollection.forEach(element -> IO.println(element));


        IO.println("-----------");
        IO.println("Stream of Array");
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);
        streamOfArrayPart.forEach(element -> IO.println(element));


        IO.println("-----------");
        IO.println("");

        IO.println("-----------");
        IO.println("");

    }
}
