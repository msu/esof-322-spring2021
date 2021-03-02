package edu.montana.esof322.demo.defensive;

import javax.annotation.Nonnull;

public class Assertions {

    public static boolean isValidEmail(String string) {
        assert string != null : "Expected non-null string";
        return string.contains("@");
    }

    public static boolean isValidEmail2(@Nonnull String string) {
        return string.contains("@");
    }

    public static void main(String[] args) {
        System.out.println(isValidEmail("foo@bar.com"));
        //System.out.println(isValidEmail(null));
        System.out.println(isValidEmail2(null));
    }

}
