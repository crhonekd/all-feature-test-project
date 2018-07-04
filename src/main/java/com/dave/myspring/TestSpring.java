package com.dave.myspring;

import com.dave.myspring.service.BusyOffice;
import com.dave.myspring.service.LocalPrinterService;
import com.dave.myspring.service.PrintService;
import com.dave.myspring.service.RemotePrinterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by David on 02/11/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class, TestSpring.Test2Configuration.class})
@TestPropertySource("classpath:spring-test.properties")
public class TestSpring {

    @Configuration
    static class Test2Configuration {

//        @Bean
//        @Primary
//        public BusyOffice busyOffice() {
//            BusyOffice office = new BusyOffice();
//            office.setPrintService(new RemotePrinterService());
//            return office;
//        }
    }

    @Inject
    BusyOffice busyOffice;

    @Test
    public void testWired() {
        busyOffice.printSomething();
    }

}

