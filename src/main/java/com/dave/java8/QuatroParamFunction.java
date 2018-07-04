package com.dave.java8;

@FunctionalInterface
public interface QuatroParamFunction<A, B, C, D> {

    void perform(A a, B b, C c, D d);
}
