package com.dave.java8;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by David on 04/11/2017.
 */
public class OptionalsTest {

    private static List<String> longNames = new ArrayList<>();
    public static void main(String[] args) {
        List<String> names = Arrays.asList("David", "Jan", "Petr", "Ludovic");


        names.stream()
                .filter(name -> {
                    return name.contains("a");
                })
        .map(Optional::ofNullable)
        .findAny()
                .ifPresent(System.out::println);

        Optional<List<String>> namesOptional = Optional.ofNullable(names);


                namesOptional
                .ifPresent(getListConsumer());

                longNames.stream().forEach(s -> System.out.println(s));

    int aaa = names.stream()
            .findFirst()
            .map(s -> s.length())
            .orElse(2);

    String qqq = names.stream()
            .findFirst()
            .orElse("zilc");

        System.out.println("length: " + aaa);
        String blah = Optional.ofNullable(names)
                .flatMap(OptionalsTest::getSecondItem)
                .orElse("Nada");

        System.out.println("-->" + blah);

        Optional.ofNullable(names)
        .get()
        .stream()
        .forEach(processItem());



    }

    private static Optional<String> getSecondItem(List<String> strings) {
        return Optional.ofNullable(strings.get(1));
    }

    private static Consumer<? super String> processItem() {
        return s -> {
            System.out.println(s);
        };
    }


    private static Consumer<List<String>> getListConsumer() {
        return (a) -> {
            List<String> collect = a.stream()
                    .filter(s -> s.length() > 3)
                    .map(s -> s + " is longer")
                    .collect(Collectors.toList());
            longNames.addAll(collect);

        };
    }

}
