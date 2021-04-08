package edu.montana.esof322.homework.homework3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class JLisp {

    public Integer eval(String string) {
        LinkedList<String> tokens = tokenize(string);
        return eval(tokens);
    }

    private LinkedList<String> tokenize(String string) {
        LinkedList<String> tokens = new LinkedList<>();
        char[] chars = string.toCharArray();
        int i = 0;
        while (i < chars.length) {
            char currentChar = chars[i];
            if (Character.isDigit(currentChar)) {
                String intString = String.valueOf(currentChar);
                while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
                    intString += chars[i + 1];
                    i++;
                }
                tokens.add(intString);
            } else {
                if (!Character.isWhitespace(currentChar)) {
                    tokens.add(String.valueOf(currentChar));
                }
            }
            i++;
        }
        return tokens;
    }

    private Integer eval(LinkedList<String> tokens) {
        String str = tokens.pop();
        if (str.equals("(")) {
            Integer result = eval(tokens);
            tokens.pop(); // pop off closing paren
            return result;
        } else if (str.equals("+")) {
            Integer arg1 = eval(tokens);
            Integer arg2 = eval(tokens);
            return arg1 + arg2;
        } else {
            return Integer.parseInt(str);
        }
    }

    public static void main(String[] args) throws IOException {
        JLisp lisp = new JLisp();
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("> ");
            String string = obj.readLine();
            System.out.println("Result : " + lisp.eval(string));
        } while(true);
    }

}
