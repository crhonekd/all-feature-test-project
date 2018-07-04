package com.dave.kafka.spring.service;

import java.io.IOException;

public interface ReceiverService<T> {

    public void process(T message) throws Exception;
}
