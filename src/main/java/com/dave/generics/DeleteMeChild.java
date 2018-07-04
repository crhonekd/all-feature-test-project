package com.dave.generics;

/**
 * Created by David on 10/04/2017.
 */
public class DeleteMeChild extends  DeleteMe {
    @Override
    protected String getFileName(String aa, String bb) {
        return "Only two params: " + aa + " " + bb;
    }
}
