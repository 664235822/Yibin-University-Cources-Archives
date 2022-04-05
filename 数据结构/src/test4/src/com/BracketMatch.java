package com;

import java.util.Stack;

public class BracketMatch {

    Stack stack = new Stack();

    char[] leftBracket = {'(', '[', '{'};
    char[] rightBracket = {')', ']', '}'};

    String str;

    public BracketMatch(String str) {
        this.str = str;
    }

    public void Matching() {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 3; j++) {
                if (str.charAt(i) == leftBracket[j]) {
                    stack.push(j);
                }
                if (str.charAt(i) == rightBracket[j] && (int) stack.peek() == j) {
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("匹配");
        } else {
            System.out.println("不匹配");
        }
    }
}
