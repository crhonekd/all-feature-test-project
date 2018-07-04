package com.dave.java8.model;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * Created by David on 04/11/2017.
 */
public class AllocationRequest implements Request {
    private static AtomicInteger counter = new AtomicInteger(0);
    private String name;

    public AllocationRequest() {
        this.name = "Allocation Req." + counter.incrementAndGet();
    }

    @Override
    public String getRequestName() {
        return name;
    }

    @Override
    public void process(Consumer<Request> function) {
        function.accept(this);
    }
}
