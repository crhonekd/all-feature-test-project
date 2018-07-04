package com.dave.generics;

/**
 * Created by David on 10/04/2017.
 */
public class DeleteMeChild2 extends  DeleteMe {
    @Override
    protected String getFileName(String aa, String bb, String cc) {

        return "Three params: " + aa + " " + bb + " " + cc;
    }
}
