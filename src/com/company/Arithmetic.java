package com.company;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by pratap on 5/16/17.
 */
public class Arithmetic {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        char[] tokens = exp.toCharArray();
        Stack<Integer> values = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder builder = new StringBuilder();
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    builder.append(tokens[i++]);
                }
                i--;
                values.push(Integer.parseInt(builder.toString()));
            } else if (tokens[i] == '(') {
                operator.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (operator.peek() != '(') {
                    values.push(evaluate(operator.pop(), values.pop(), values.pop()));
                }
                operator.pop();
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                while (!operator.empty() && hasPrecedence(tokens[i], operator.peek())) {
                    values.push(evaluate(operator.pop(), values.pop(), values.pop()));
                }
                operator.push(tokens[i]);
            }
        }
        while (!operator.empty()) {
            values.push(evaluate(operator.pop(), values.pop(), values.pop()));
        }
        System.out.println(values.pop());
    }

    private static int evaluate(char operator, int v2, int v1) {
        switch (operator) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
            case '/':
                if (v2 == 0) {
                    throw new ArithmeticException("Cannot Divide by zero");
                }
                return v1 / v2;
        }
        return 0;
    }

    private static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }
}