package com;

import java.util.Stack;

public class CalculateScaleStack {

    Stack stack = new Stack();

    int n, d;

    String[] nums = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public CalculateScaleStack(int n, int d) {
        this.n = n;
        this.d = d;
    }

    public void Calculate() {
        int temp = n;
        int result = 0;
        while (temp != 0) {
            result = temp % d;
            temp = temp / d;
            stack.push(result);
        }
    }

    public void Show() {
        while (!stack.isEmpty()) {
            System.out.print(nums[(int) stack.pop() - 1]);
        }

    }
}
