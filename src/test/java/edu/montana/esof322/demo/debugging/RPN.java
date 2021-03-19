package edu.montana.esof322.demo.debugging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class RPN {

    static LinkedList<Integer> stack = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        String line;
        do {
            System.out.print("" + stack.toString() + " > ");
            line = obj.readLine();
            String[] splitString = line.split(" ");
            Integer value = rpn(splitString);
            System.out.println("  Answer : " + value);
        } while (line != "stop");
    }

    private static Integer rpn(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.equals("+")) {
                Integer arg2 = stack.pop();
                Integer arg1 = stack.pop();
                stack.push(arg1 + arg2);
            } else {
                stack.push(Integer.parseInt(arg));
            }
        }
        return stack.peek();
    }

}
