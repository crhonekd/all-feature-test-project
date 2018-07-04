package com.dave.java8;

/**
 * Created by David on 19/03/2017.
 */
public interface TestDefaultInterface {

    public void sayHello(String name);

    default public void sayGoodBy(String name) {
        System.out.println("Goodby " + name);
    }
}
