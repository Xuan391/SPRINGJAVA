package com.example.JAVASPRING1.javaspring1_services.javacore3;

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
    //chuyển đổi từ trung tố sang hậu tố
    public static String convertToPostfix(String expression) {
        expression = removeExtraSpaces(expression);
        System.out.println(expression);

        StringBuilder postfix = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                number.append(ch);
            } else {
                if (number.length() > 0) {
                    postfix.append(number).append(" ");
                    number.setLength(0);
                }
                if (ch == '(') {
                    stack.push(ch);
                }
                else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                        postfix.append(stack.pop()).append(" ");
                    }
                    stack.push(ch);
                }
            }
        }

        if (number.length() > 0) {
            postfix.append(number).append(" ");
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString();
    }

    public static double evaluatePostfix(String postfixExpression) {
        Deque<Double> stack = new ArrayDeque<>();

        for (int i = 0; i < postfixExpression.length(); i++) {
            char ch = postfixExpression.charAt(i);

            if (Character.isDigit(ch) || ch == '.') {
                // Xử lý số thập phân
                StringBuilder number = new StringBuilder();
                while (i < postfixExpression.length() && (Character.isDigit(ch) || ch == '.')) {
                    number.append(ch);
                    i++;
                    if (i < postfixExpression.length()) {
                        ch = postfixExpression.charAt(i);
                    }
                }
                double decimalNumber = Double.parseDouble(number.toString());
                stack.push(decimalNumber);
            } else if (ch != ' ') {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result = performOperation(ch, operand1, operand2);
                stack.push(result);
            }
        }

        return Math.ceil(stack.pop() * 10000) / 10000;
    }

    public static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

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

    public static String removeExtraSpaces(String input) {
        // Loại bỏ khoảng trắng đầu và cuối chuỗi
        String trimmed = input.trim();
        // Thay thế các khoảng trắng liên tiếp bằng một khoảng trắng duy nhất
        String result = trimmed.replaceAll("\\s+", "");
        return result;
    }
}
