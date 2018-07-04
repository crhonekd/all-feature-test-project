package com.dave.myspring.service;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

/**
 * Created by David on 02/11/2017.
 */
public class RemotePrinterService implements PrintService {

    @Value("${service.printer.type:Default Printer}")
    private String printerType;

    public RemotePrinterService() {
    }

    @PostConstruct
    private void init() {
        System.out.println("Remote Printer initialised: " + getPrinterType());
    }

    @Override
    public void print() {
        System.out.println("Printing remotely");
    }

    @Override
    public void setup() {
        System.out.println("Setting remote printer...., printer type is: " + getPrinterType());
    }

    public String getPrinterType() {
        return printerType;
    }

    public void setPrinterType(String printerType) {
        this.printerType = printerType;
    }
}
