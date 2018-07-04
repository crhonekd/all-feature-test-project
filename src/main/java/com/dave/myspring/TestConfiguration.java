package com.dave.myspring;

import com.dave.myspring.service.BusyOffice;
import com.dave.myspring.service.LocalPrinterService;
import com.dave.myspring.service.PrintService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by David on 02/11/2017.
 */
@org.springframework.context.annotation.Configuration
public class TestConfiguration {

    @Bean
    public PrintService localPrinterService() {
        return new LocalPrinterService();
    }

    @Bean
    @Primary
    public BusyOffice busyOffice() {
        BusyOffice office = new BusyOffice();
        office.setPrintService(localPrinterService());
        return office;
    }

}
