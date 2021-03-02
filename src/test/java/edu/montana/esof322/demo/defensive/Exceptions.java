package edu.montana.esof322.demo.defensive;

public class Exceptions {


    static void throwsAnException() throws Exception {
        if(true) {
            throw new Exception("You shouldn't have done that...");
        }
        System.out.println("here");
    }

    static void nestsAnException()  {
        try {
            throwsAnException();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        System.out.println("\n================================");
        System.out.println("A Basic Exception");
        System.out.println("================================\n");
        try {
            throwsAnException();
            System.out.println("here2");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        System.out.println("\n================================");
        System.out.println("A Nested Exception");
        System.out.println("================================\n");
        try {
            nestsAnException();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        System.out.println("\n================================");
        System.out.println("Finally block");
        System.out.println("================================\n");
        try {
            throwsAnException();
        } catch (Exception e) {
            System.out.println("In exception handler...");
            e.printStackTrace(System.out);
        } finally {
            System.out.println("In finally...");
        }

        System.out.println("\n================================");
        System.out.println("An exception during exception handling");
        System.out.println("================================\n");
        try {
            throwsAnException();
        } catch (Exception e) {
            System.out.println("In exception handler...");
            // well that's silly
            String x = null;
            x.equals(null);
            e.printStackTrace(System.out);
        } finally {
            System.out.println("In finally...");
        }

    }


}
