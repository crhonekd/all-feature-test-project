package com.dave.java8;


import com.dave.model.Employee;
import com.dave.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.function.*;

/**
 * Created by David on 19/03/2017.
 */
public class FunctionInterfaceTest {


    public static void main(String[] args) {

    Consumer<Integer> consumer = s -> System.out.println(s);

    List<Integer> list = Arrays.asList(1,2);
    list.forEach(consumer);
        list.stream()
                .map(i -> i + 1)
                .filter(i -> i < 3)
                .distinct()
                .allMatch(i -> i ==1);
    takeMyFuncInt((String s) -> System.out.println("Hello " + s));
        System.out.println(Thread.currentThread().getName());

    new Thread(()-> System.out.println("one...")).start();

    RowMapper<Person> mapper = (row, index) -> {
        row.getString(index);
        return new Employee();
    };
        java.util.function.Supplier<String> sup = () -> {
            return "Hello Supplier";
        };

        System.out.println(sup.get());

        java.util.function.BiFunction<Person, Person, String> biF = (Person p1, Person p2) -> {

            return p1.getFirstName() + " " + p2.getLastName();
        };

        Function<String, Integer> f2 = i -> {


            return Integer.parseInt(i);
        };

        System.out.println(f2.apply("77777777"));

        BiFunction<String, Integer, Integer> stringIntegerObjectBiFunction = (String str, Integer intr) -> {
            return 5;
        };

        System.out.println(stringIntegerObjectBiFunction.apply("joujou", 4));


        QuatroParamFunction<String, String, Integer, Double> stringStringIntegerDoubleQuatroParamFunction =
                (String s1, String s2, Integer int1, Double d1) -> {

        };

        DoubleParamFunction<Integer, Integer, Integer> intBinaryOperator = (Integer a, Integer b) -> {
            return a + b;
        };

    }

    private static void takeMyFuncInt(MyFunctionalInterface<String> mi) {
        mi.perform("bla");
    }
}
