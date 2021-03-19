package edu.montana.esof322.demo.closures;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClosuresDemo {

    @Test
    void closureExample() {

        int length = 2;
        List<String> strings =
                Arrays.asList("a", "ab", "abc");

        List<String> longEnoughStrings =
                strings
                        .stream()
                        .filter(s -> s.length() >= length)
                        .collect(Collectors.toList());

//        System.out.println(longEnoughStrings.collect(Collectors.joining(",")));

        ArrayList<String> result = new ArrayList<>();
        for (String str : strings) {
            if (str.length() >= length) {
                result.add(str);
            }
        }

    }

    void closureExample2() {
        Runnable runIt =
                ()-> {
                    System.out.println("This is a lambda expression");
                };
        runIt.run();

        String str = "This is a lambda expression";
        Runnable runIt2 =
                ()-> System.out.println(str);

        runIt2.run();

    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("This is a runnable");
        }
    }

    public static void main(String[] args) {
    }

    private static Runnable makeARunnable() {
        String string = "This is an anonymous inner class runnable...";
        return new Runnable() {
            @Override
            public void run() {
                System.out.println(string);
            }
        };
    }


}
