package com.playground.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Java 8 Streams playground
 */
public class StreamsPlayground {

    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        List<Integer> numCollection = new ArrayList<>();
        numCollection.add(1);
        numCollection.add(2);
        numCollection.add(3);
        numCollection.add(4);
        numCollection.add(5);

        /******** Filters *********/
        System.out.println("Filters");
        stringCollection.stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        /******** Sorted **********/
        System.out.println("Sorted");
        stringCollection.stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);

        /******** Map **********/
        System.out.println("Map");
        stringCollection.stream()
                .filter((s) -> s.startsWith("a"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        /******** Match **********/
        System.out.println("Match");
        boolean anyMatch = stringCollection.stream()
                .anyMatch(s -> s.startsWith("d"));
        System.out.println(anyMatch);

        /******** Count **********/
        System.out.println("Count");
        long count = stringCollection.stream()
                .filter((s) -> s.startsWith("a"))
                .count();
        System.out.println(count);

        /******** Reduce **********/
        System.out.println("Reduce");
        Optional<Integer> optional = numCollection.stream()
                                        .reduce((n1, n2) -> n1 + n2);
        System.out.println(optional.get());

        /******** Parallel Streams **********/
        List<String> randomStrings = new ArrayList<>(1000000);
        for(int i = 0; i < 1000000; i++) {
            randomStrings.add(UUID.randomUUID().toString());
        }

        //Sequential sort
        long t0 = System.nanoTime();
        randomStrings.stream()
                    .sorted()
                    .count();
        long t1 = System.nanoTime();
        System.out.println(String.format("Sequential stream time taken %d", TimeUnit.NANOSECONDS.toMillis( t1 - t0)));

        //Parallel sort
        t0 = System.nanoTime();
        randomStrings.parallelStream()
                .sorted()
                .count();
        t1 = System.nanoTime();
        System.out.println(String.format("Parallel stream time taken %d", TimeUnit.NANOSECONDS.toMillis( t1 - t0)));
    }
}
