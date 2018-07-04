package com.dave.kafka.spring.configuration;

import com.dave.kafka.spring.model.Person;
import com.dave.kafka.spring.beans.request.DataRequest;
import com.dave.kafka.spring.mapper.JsonMapper;
import com.dave.kafka.spring.mapper.Jackson2JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {

    @Bean
    public JsonMapper<Person> objectToJsonStringMapper() {
        return new Jackson2JsonMapper<Person>();
    }

    @Bean
    public JsonMapper<DataRequest> requestToJsonStringMapper() {
        return new Jackson2JsonMapper<DataRequest>();
    }

}
