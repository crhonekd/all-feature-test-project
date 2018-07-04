package com.dave.myspring.service;

import javax.annotation.PostConstruct;

/**
 * Created by David on 02/11/2017.
 */
public class BusyOffice {
    PrintService printService;

    public BusyOffice() {
    }



    @PostConstruct
    private void init() {
        printService.setup();
    }

    public void setPrintService(PrintService printService) {
        this.printService = printService;
    }

    public void printSomething() {
        printService.print();
    }
}
