package edu.montana.esof322.demo.statements;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StatementsDemo {

    private static List<String> _data;

    @Test
    public void obviousDependencies() {
        List<String> data = getData();
        printData(data);
    }

    @Test
    public void badStatements() {
        genData();
        addData("foo");
    }

    @Test
    public void obviousClassDependencies() {
        List<String> data = getData();
        DataPrinter dataPrinter = new DataPrinter(data);
        dataPrinter.printData();
    }

    @Test
    public void badClassDependencies() {
        genData();
        BadDataPrinter dataPrinter = new BadDataPrinter();
        dataPrinter.printData();
    }

    @Test
    public void ifStatemetents() {

        List<String> data = getData();

        if (data != null) {
            printData(data);
        } else {
            System.out.println("Data was null!");
        }

        if (data != null) {
            printData(data);
        } else {
            // TODO
        }

        if (data != null) {
            printData(data);
        }


    }

    @Test
    public void forStatemetents() {

        List<String> data = getData();
        for (String datum : data) {
            System.out.println(datum);
        }

        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);
            System.out.println(s);
        }

        data.forEach(System.out::println);

    }

    @Test
    public void whileStatemetents() throws FileNotFoundException {

        List<String> data = getData();

        Iterator<String> iterator = data.iterator();

        while (iterator.hasNext()) {
            String str = iterator.next();
            PrimitiveIterator.OfInt chars = str.chars().iterator();
            while (chars.hasNext()) {
                Integer currentCharacter = chars.next();
                if (Character.isDigit(currentCharacter)) {
                    System.out.println(currentCharacter);
                }
            }
        }

        File file = new File("file.txt");
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()){
            System.out.println(fileScanner.nextLine());
        }

        do {
            System.out.println("Enter command: ");
        } while (processCommand());

        while (iterator.hasNext()) {
            String string = iterator.next();
            if (string.equals("STOP")) {
                break;
            }
            if (string.equals("DO NOT PRINT")) {
                continue;
            }
            System.out.println(string);
        }

        while (true) {
            if (checkCondition()) {
                break;
            }
        }

        for (String string : data) {
            if (string.equals("STOP")) {
                break;
            }
            if (string.equals("DO NOT PRINT")) {
                continue;
            }
            System.out.println(string);
        }

        while (iterator.hasNext()) {
            String str = iterator.next();
            PrimitiveIterator.OfInt chars = str.chars().iterator();
            while (chars.hasNext()) {
                Integer currentCharacter = chars.next();
                if (Character.isDigit(currentCharacter)) {
                    System.out.println(currentCharacter);
                    break;
                }
            }
        }

        while (iterator.hasNext()) {
            String str = iterator.next();
            PrimitiveIterator.OfInt chars = str.chars().iterator();
            while (chars.hasNext()) {
                Integer currentCharacter = chars.next();
                System.out.println(currentCharacter);
            }
        }

        while (iterator.hasNext()) {
            String str = iterator.next();
            printCharacterVals(str);
        }

    }

    private boolean checkCondition() {
        return false;
    }

    private boolean processCommand() {
        return false;
    }

    public int aGoodLookingFunction(List<String> data) {
        int zeroLenthStrings = 0;

        for (String datum : data) {
            if (datum.length() == 0) {
                zeroLenthStrings++;
            }
        }

        return zeroLenthStrings;
    }

    private void printCharacterVals(String str) {
        PrimitiveIterator.OfInt chars = str.chars().iterator();
        while (chars.hasNext()) {
            Integer currentCharacter = chars.next();
            System.out.println(currentCharacter);
        }
    }

    @Test
    public void switchStatements() {

        List<String> data = getData();

        switch (data.size()) {
            case 0:
                System.out.println("Zero elements");
                break;
            case 1:
                System.out.println("One element");
                break;
            case 2:
                System.out.println("Two elements");
                break;
            default:
                System.out.println("Many elements");
        }


    }


    static private void addData(String moreData) {
        _data.add(moreData);
    }

    static private void genData() {
        _data = getData();
    }

    private static List<String> getData() {
        return new ArrayList<>(Arrays.asList("Some", "data"));
    }

    private static void printData(List<String> data) {
        System.out.println(data);
    }

    private class DataPrinter {
        public DataPrinter(List<String> data) {
            _data = data;
        }

        public void printData() {
            System.out.println(_data);
        }
    }

    private class BadDataPrinter {
        public void printData() {
            System.out.println(_data);
        }
    }
}
