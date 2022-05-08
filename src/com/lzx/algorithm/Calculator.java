package com.lzx.algorithm;

import com.lzx.datastructure.LinkedStack;
import com.lzx.datastructure.Stack;

/**
 * @author laizixiang
 */
public class Calculator {
    private final LinkedStack<Integer> numStack = new LinkedStack<>();
    private final LinkedStack<Character> operStack = new LinkedStack<>();
    public static final char PLUS = '+';
    public static final char MINUS = '-';
    public static final char MULTI = '*';
    public static final char DIVISION = '/';
    private final String expression;
    private Integer sum = 0;

    public static void main(String[] args) {

        Calculator calculator = new Calculator("5+3*6-3*3+2");
        System.out.println(calculator.infixToSuffix("1+((2+3)*4)-5"));
    }

    public Calculator(String expression) {
        this.expression = expression;
    }

    public Integer evaluate() {
        char[] chars = expression.toCharArray();
        for (char c : chars) {

            if (isOperator(c)) {
                if (operStack.isEmpty()) {
                    operStack.push(c);
                } else {
                    if (priority(c) <= priority(operStack.peek())) {
                        //如果运算符的优先级小于前者,例如：3*2-2的-优先级就小于*
                        numStack.push(calculate(numStack.pop(), numStack.pop(), operStack.pop()));
                    }
                    operStack.push(c);
                }

            } else {
                numStack.push(c - '0');
            }
        }
        //反转栈，从而使计算式能够从左向右计算
        numStack.reverse();
        operStack.reverse();
        while (!operStack.isEmpty()) {
            numStack.push(calculate(numStack.pop(), numStack.pop(), operStack.pop()));
        }
        return numStack.pop();
    }

    public Integer evaluateBySuffix(String suffixExpression) {

        return null;
    }

    public int priority(char operator) {
        if (operator == MULTI || operator == DIVISION) {
            return 2;
        } else if (operator == MINUS || operator == PLUS) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * @param infixExpression 传入一个中缀表达式，例如：1+((2+3)*2)-4-> 1 2 3+2*+4-
     */

    public String infixToSuffix(String infixExpression) {
        //s1 符号栈
        LinkedStack<Character> s1 = new LinkedStack<>();
        // s2 后缀表达栈
        LinkedStack<Character> s2 = new LinkedStack<>();
        char[] chars = infixExpression.toCharArray();
        for (char c : chars) {
            if (!isOperator(c)) {
                s2.push(c);
            } else {
                if (s1.isEmpty() || '(' == s1.peek()) {
                    s1.push(c);
                } else {
                    if (c == '(') {
                        s1.push(c);
                    } else if (c == ')') {
                        while (s1.peek() != '(') {
                            s2.push(s1.pop());
                        }
                        s1.pop();
                    } else {
                        while (!s1.isEmpty() && priority(s1.peek()) >= priority(c)) {
                            s2.push(s1.pop());
                        }
                        s1.push(c);
                    }
                }
            }
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.reverse();
        return s2.toString();
    }

    public boolean isOperator(char c) {
        return !(48 <= c && c <= 57);
    }


    public int calculate(int a, int b, char operator) {
        switch (operator) {
            case MINUS:
                return a - b;
            case PLUS:
                return a + b;
            case MULTI:
                return a * b;
            case DIVISION:
                return a / b;
            default:
                throw new RuntimeException("运算符异常！");


        }
    }


}
