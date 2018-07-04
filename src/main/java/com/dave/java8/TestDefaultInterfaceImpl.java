package com.dave.java8;

/**
 * Created by David on 19/03/2017.
 */
public class TestDefaultInterfaceImpl implements TestDefaultInterface {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    @Override
    public void sayGoodBy(String name) {

    }
}
