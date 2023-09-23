package com.example.simplecalculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class calculations {
    public static double evaluate(String exp) {

        char[] tokens = exp.toCharArray();
        Queue<Object> values = new LinkedList<>();
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') {
                continue;
            } else if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();

                while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')) {
                    sbuf.append(tokens[i]);
                    if ((i + 1) < tokens.length && (tokens[i + 1] >= '0' && tokens[i + 1] <= '9' || tokens[i + 1] == '.')) {
                        i++;
                    } else {
                        break;
                    }
                }
                values.add(Double.parseDouble(sbuf.toString()));
            } else if (tokens[i] == '*' || tokens[i] == '-' || tokens[i] == '/' || tokens[i] == '+') {
                if (ops.isEmpty()) {
                    ops.push(tokens[i]);
                    continue;
                }
                char op1 = ops.peek();
                boolean hasHighPrecedence = hasPrecedence(op1, tokens[i]);
                if (hasHighPrecedence) {
                    char op = ops.pop();
                    values.add(op);
                    ops.push(tokens[i]);
                } else {
                    ops.push(tokens[i]);
                }
            } else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    values.add(ops.pop());
                }
                ops.pop();
            }
        }
        while (!ops.isEmpty()) {
            values.add(ops.pop());
        }
        Stack<Double> numStack = new Stack<>();
        while (!values.isEmpty()) {
            Object val = values.poll();
            if (val instanceof Character) {
                char v = (Character) val;
                if (v == '*' || v == '-' || v == '/' || v == '+') {
                    double num2, num1;
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    double ans = applyOp(v, num1, num2);
                    numStack.push(ans);

                }
            } else {
                double num = (double) val;
                numStack.push(num);
            }
        }
        return numStack.pop();

    }

    public static double applyOp(char op, double b, double a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            IllegalArgumentException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op1 == '*' && op2 == '/') {
            return false;
        } else if (op1 == '/' && op2 == '*') {
            return true;
        } else if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return true;
        } else return op1 == '+' && op2 == '-';
    }
}
