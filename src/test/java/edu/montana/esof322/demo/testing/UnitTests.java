package edu.montana.esof322.demo.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTests {

    RPNCalculator calculator;

    @BeforeEach
    public void setupCalc(){
        calculator = new RPNCalculator();
    }

    @AfterEach
    public void teardownCalc(){
        calculator = null;
    }

    public static class RPNCalculator {
        public Integer eval(String str) {
            String[] strings = str.split(" ");
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

    @Test
    public void testBasicRPNWorks() {
        RPNCalculator calc = new RPNCalculator();
        Integer integer = calc.eval("1 1 +");
        assertEquals(2, integer);
    }

}
