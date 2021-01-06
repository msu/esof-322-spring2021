package edu.montana.esof322.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BagEquivalence {

    public static void main(String[] args) {
        List<String> a = Arrays.asList("A", "B", "C", "A");
        List<String> b = Arrays.asList("A", "C", "A", "B", "A");

        HashMap<String, Integer> aCounts = mapOfCounts(a);
        HashMap<String, Integer> bCounts = mapOfCounts(b);

        if (aCounts.equals(bCounts)) {
            System.out.println("Lists are bag equivalent!");
        }
    }

    private static HashMap<String, Integer> mapOfCounts(List<String> a) {
        HashMap<String, Integer> mapOfCounts = new HashMap<>();
        for (String str : a) {
            Integer integer = mapOfCounts.get(str);
            int newCount = integer == null ? 1 : integer + 1;
            mapOfCounts.put(str, newCount);
        }
        return mapOfCounts;
    }
}
