package com.dave.myspring.service;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

/**
 * Created by David on 02/11/2017.
 */
public class LocalPrinterService implements PrintService {

    @Value("${service.printer.type:Default Printer}")
    private String printerType;

    public LocalPrinterService() {
    }

    @PostConstruct
    private void init() {
        System.out.println("Printer initialised: " + getPrinterType());
    }

    @Override
    public void print() {
        System.out.println("Printing locally");
    }

    @Override
    public void setup() {
        System.out.println("Setting local printer...., printer type is: " + getPrinterType());
    }

    public String getPrinterType() {
        return printerType;
    }

    public void setPrinterType(String printerType) {
        this.printerType = printerType;
    }
}
