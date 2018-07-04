package com.dave.kafka.spring.service;

import com.dave.kafka.spring.model.Person;
import com.dave.kafka.spring.beans.request.CreateUserDataRequest;
import com.dave.kafka.spring.beans.request.DataRequest;
import com.dave.kafka.spring.mapper.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StringReceiverServiceImpl implements ReceiverService<String> {

    private static Logger LOG = LoggerFactory.getLogger(StringReceiverServiceImpl.class.getName());
    @Autowired
    private JsonMapper<DataRequest> reqMapper;

    public void process(String message) throws Exception {
        try {
            DataRequest dataRequest = reqMapper.jsonToObject(message, DataRequest.class);
            if (dataRequest instanceof CreateUserDataRequest) {
                Person person = ((CreateUserDataRequest) dataRequest).getPerson();
                LOG.info("Received person's name: " + person.getName().getFirstName());
            }
        } catch (Exception e) {
            LOG.warn("Unable to parse incoming message: " + message);
        }
    }
}
