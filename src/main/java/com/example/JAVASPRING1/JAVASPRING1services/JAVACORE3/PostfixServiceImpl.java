package com.example.JAVASPRING1.JAVASPRING1services.JAVACORE3;

import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Deque;

@Service
public class PostfixServiceImpl implements PostfixService{

    @Override
    public double postfixCalculate(String expression) { // test với các phép tính có dấu +
        String postfix = convertToPostfix(expression);
        return evaluatePostfix(postfix);
    }
    // Xét độ ưu tiên
    public static String convertToPostfix(String expression) {
        StringBuilder postfix = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Xóa dấu '(' trong stack
            } else {
                // Xử lý các phép toán +, -, *, /
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static double evaluatePostfix(String postfixExpression) {
        Deque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < postfixExpression.length(); i++) {
            char ch = postfixExpression.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push((double) (ch - '0'));  // ch-'0' ép kiểu sang số nguyên
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(ch, operand1, operand2);
                stack.push(result);
            }
        }

        return stack.pop();
    }
    // Xét độ ưu tiên
    public static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }
    // tính toán nhân chia cộng trừ
    public static double performOperation(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
        }
        throw new IllegalArgumentException("Phép toán không hợp lệ: " + operator);
    }
}
