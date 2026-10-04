package org.zdanek.java.stream.devjava;

import java.util.List;

//https://dev.java/learn/api/collections-and-streams/streams/
//https://dev.java/learn/api/collections-and-streams/streams/map-filter-reduce/
public class A01ProcessingData {


    void main() {

        // Map-Filter-Reduce Algorithm
        //compute the total population living in cities that have more than 100k inhabitants.
        List<City> cities =
                List.of(
                        new City(100_000),
                        new City(200_000),
                        new City(500_000));

        notStreamMethod(cities);
        streamMethod(cities);
    }


    private static void notStreamMethod(List<City> cities) {

        IO.println("--------");
        IO.println("notStreamMethod");
        int sum = 0;
        for (City city : cities) {
            int population = city.population();
            if (population > 100_000) {
                sum += population;
            }
        }
        IO.println("Sum = " + sum);
    }

 
    private static void streamMethod(List<City> cities) {

        IO.println("--------");
        IO.println("StreamMethod");
        int sum = cities.stream()
                .filter(city -> city.population > 100000)
                .mapToInt(City::population)
                .sum();
        IO.println("Sum = " + sum);
    }

    record City(int population) {
    }
}
