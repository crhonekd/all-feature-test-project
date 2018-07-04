package com.dave.generics;

/**
 * Created by David on 10/04/2017.
 */
public abstract class DeleteMe {

    public String setSomething() {
        return getFileName("aa", "bb", "cc");
    }

    protected String getFileName(String aa, String bb, String cc) {
        return getFileName(aa, bb);
    }

    protected String getFileName(String aa, String bb) {
        return aa + bb;
    }

    public static void main(String[] args) {
        DeleteMeChild one = new DeleteMeChild();
        System.out.println(one.setSomething());

        DeleteMeChild2 two = new DeleteMeChild2();
        System.out.println(two.setSomething());
    }
}
