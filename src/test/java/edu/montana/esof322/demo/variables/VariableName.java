package edu.montana.esof322.demo.variables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class VariableName {

    private static final Object AN_ERROR_OCCURRED = 1;
    public static final int MAX_REPORT_INDEX = 200;

    void badNames(){
        int x = 0, xx = 0, y = 0, x1 = 0;
        int fido = 0;

        x = x * xx;
        y = fido + SalesTax( fido );
        x = x + LateFee( x1, x ) + y;
        x = x + Interest( x1, x );

    }

    void goodNames(){
        int balance = 0;
        int lastPayment = 0;
        int monthlyTotal = 0;
        int newPurchases = 0;
        int customerID = 0;

        balance = balance - lastPayment;
        monthlyTotal = newPurchases + SalesTax( newPurchases );
        balance = balance + LateFee( customerID, balance ) + monthlyTotal;
        balance = balance + Interest( customerID, balance );
    }

    void shortNames() {

        List<String> strings = Arrays.asList("a", "ab", "abc");
        Stream<Integer> lengths = strings.stream()
                .map(String::length);

       List<Integer> lengthsList = new ArrayList<>();
        for (String s : strings) {
            lengthsList.add(s.length());
        }

    }

    void namingTypes() {

        String[] strings = new String[]{"a", "ab", "abc"};

        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            // do something w/ the string
        }

        boolean finished = true;
        while (!finished) {
            keepDoingIt();        
        }

        int intSumOfLengths = 0;
        for (String string : strings) {
            intSumOfLengths += string.length();
        }

    }

    void typeSpecificConsiderations() {

        int count = 0;
        int MAX_JOBS = 200;

        while (count < 0) {
            keepDoingIt();
        }

        System.out.println("An error occurred!");

        System.out.println(localize(getCurrentLocale(),
                AN_ERROR_OCCURRED));

    }

    private boolean localize(Object currentLocale, Object anErrorOccurred) {
        return false;
    }

    private Object getCurrentLocale() {
        return null;
    }


    class Student {
        String _name;

        public Student(String name) {
            _name = name;
        }
    }


    private void keepDoingIt() {
    }

    enum Color {
        RED,
        GREEN,
        BLUE
    }

    private void enumExample() {

        String colorCode =
                computeColorCode(Color.RED, 128);

    }

    private String computeColorCode(Color red, int i) {
        return null;
    }

    private void booleanExamples() {
        int elementIndex = 0, MAX_ELEMENTS = 0, lastElementIndex = 0;

        boolean finished = (elementIndex < 0) || (MAX_ELEMENTS < elementIndex);
        boolean repeatedElt = elementIndex == lastElementIndex;
        if (finished || repeatedElt) {
            cleanUp();
        }


    }

    private int _i;
    private int _l;

    private void maybeCleanUpReports(int reportIndex,
                                     int lastReportIndex) {
        boolean invalidIndex = !isValidReportIndex(reportIndex);
        boolean isLastReport = reportIndex == lastReportIndex;
        if (invalidIndex || isLastReport) {
            cleanUp();
        }
    }

    private boolean isValidReportIndex(int reportIndex) {
        return (0 < reportIndex) && (reportIndex < MAX_REPORT_INDEX);
    }

    private void cleanUp() {

    }

    private int Interest(int x1, int x) {
        return 0;
    }

    private int LateFee(int x1, int x) {
        return 0;
    }

    private int SalesTax(int fido) {
        return 0;
    }

}
