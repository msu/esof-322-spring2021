package edu.montana.esof322.demo.testing;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Spliterators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UnitTests2 {

    interface Splitter {
        String[] split(String str);
    }
    public static class BetterRPNCalculator {
        Splitter _splitter;
        public BetterRPNCalculator(Splitter splitter) {
            this._splitter = splitter;
        }
        public Integer eval(String str) {
            String[] strings = _splitter.split(str);
            LinkedList<Integer> stack = new LinkedList<Integer>();
            for (String string : strings) {
                if (string.equals("+")) {
                    Integer arg1 = stack.pop();
                    Integer arg2 = stack.pop();
                    stack.push(arg1 + arg2);
                } else {
                    stack.push(Integer.parseInt(string));
                }
            }
            return stack.pop();
        }
    }


    static class SpaceSplitter implements Splitter {
        @Override
        public String[] split(String str) {
            return str.split(" ");
        }
    }

    @Test
    public void testBasicRPNWorks() {
        BetterRPNCalculator calc = new BetterRPNCalculator(new SpaceSplitter());
        Integer integer = calc.eval("1 1 +");
        assertEquals(2, integer);
    }

    static class DashSplitter implements Splitter {
        @Override
        public String[] split(String str) {
            return str.split("-");
        }
    }

    @Test
    public void testDashedRPNWorks() {
        BetterRPNCalculator calc = new BetterRPNCalculator(new DashSplitter());
        Integer integer = calc.eval("1-1-+");
        assertEquals(2, integer);
    }

    @Test void testWithMock() {
        Splitter mock = mock(Splitter.class); // create a mock

        // give it a specification
        when(mock.split("1 1 +"))
                .thenReturn(new String[]{"1", "1", "+"});

        // run the normal test
        BetterRPNCalculator calc = new BetterRPNCalculator(mock);
        Integer integer = calc.eval("1 1 +");
        assertEquals(2, integer);

        // verify the interaction
        verify(mock).split("1 1 +");
    }

}
