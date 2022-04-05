package com;

import java.util.Stack;

public class Expression {

    Stack stack = new Stack();

    String str;

    char[] calculate = {'+', '-', '*', '/'};

    public Expression(String str) {
        this.str = str;
    }

    public void Handle() {
        for (int i = 0; i < str.length(); i++) {
            boolean isCalculate = false;
            for (int j = 0; j < calculate.length; j++) {
                if (str.charAt(i) == calculate[j]) {
                    int num2 = (int) stack.pop();
                    int num1 = (int) stack.pop();
                    switch (calculate[j]) {
                        case '+':
                            stack.push(num1 + num2);
                            break;
                        case '-':
                            stack.push(num1 - num2);
                            break;
                        case '*':
                            stack.push(num1 * num2);
                            break;
                        case '/':
                            stack.push(num1 / num2);
                            break;
                    }
                    isCalculate = true;
                }
            }
            if (!isCalculate) {
                stack.push(Integer.parseInt(String.valueOf(str.charAt(i))));
            }
        }

        System.out.println("结果是" + stack.pop());
    }
}
