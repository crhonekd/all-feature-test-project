package com.dave.java8.model;

import java.util.function.Consumer;

/**
 * Created by David on 04/11/2017.
 */
public interface Request {
    String getRequestName();
    void process(Consumer<Request> function);
}
