package com.dave.generics;

/**
 * Created by David on 10/03/2017.
 */
public class MyPair<K, V> implements Pair<K, V> {

    private K key;
    private V value;

    public MyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public K key() {
        return this.key;
    }

    @Override
    public V value() {
        return this.value;
    }

    public <U> void inspect(U thirdType) {
        System.out.println(this.key().getClass().getName());
        System.out.println(this.value().getClass().getName());
        System.out.println(thirdType.getClass().getName());
    }
}
