package com.dave.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by David on 10/03/2017.
 */
public class TestGenerics {

    public static void main(String[] args) {

        MyPair<Integer, String> pair = new MyPair<>(123, "123");

        pair.inspect(new Date());

        tryMe(Arrays.asList(1,2,3,4));
    }

    private static <H extends List<K>, K extends Number> void tryMe(H val) {

        for (Number n : val) {
        System.out.println(n);
        }
    }
}
