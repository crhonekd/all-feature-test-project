package com.dave.java8;

import com.dave.java8.model.AllocationRequest;
import com.dave.java8.model.CapacityRequest;
import com.dave.java8.model.Request;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by David on 04/11/2017.
 */
public class FunctionsTest {


    public static void main(String[] args) {
        List<Request> requests = Arrays.asList(new AllocationRequest(), new CapacityRequest(), new AllocationRequest());
        requests.stream()
                .forEach(r -> r.process(printOnlyBiggerThanOne()));
    }

    private static Consumer<Request> print() {
        return req -> {
            System.out.println(req.getRequestName());
        };
    }

    private static Consumer<Request> printOnlyBiggerThanOne() {
        return req -> {
            if (!req.getRequestName().contains("1")) {
                System.out.println(req.getRequestName());
            }
        };
    }
}
