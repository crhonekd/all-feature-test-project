package com.dave.xmlSchemaValidation;

import com.dave.xmlSchemaValidation.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.xml.transform.StringResult;

/**
 * Created by David on 04/04/2017.
 */

@ContextConfiguration({"classpath:beanFactory-example.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMarshaller {

    @Autowired
    private Marshaller marshaler;


    @Test
    public void testMarshaller() throws Exception {
        System.out.println();
        Person p = new Person();
        p.setFirstName("Jouda");
        p.setLastName("Bida");
        p.setAge(32);
        StringResult result = new StringResult();

        marshaler.marshal(p,result );
        System.out.println(result.toString());
    }

}
