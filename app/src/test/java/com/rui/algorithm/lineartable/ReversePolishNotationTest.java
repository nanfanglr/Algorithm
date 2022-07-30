package com.rui.algorithm.lineartable;

import org.junit.Test;

public class ReversePolishNotationTest {

    @Test
    public void test() {
        //中缀表达式3*(17-15)+18/6的逆波兰表达式如下
        String[] notation = {"3", "17", "15", "-", "*", "18", "6", "/", "+"};
        int result = calculate(notation);
        System.out.println("逆波兰表达式的结果为:" + result);
    }

    private int calculate(String[] notation) {
        Stack<Integer> stack = new Stack<>();
        for (String curr : notation) {
            Integer o1;
            Integer o2;
            int result;
            switch (curr) {
                case "+":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 + o1;
                    stack.push(result);
                    break;
                case "-":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 - o1;
                    stack.push(result);
                    break;
                case "*":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 * o1;
                    stack.push(result);
                    break;
                case "/":
                    o1 = stack.pop();
                    o2 = stack.pop();
                    result = o2 / o1;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(curr));
                    break;
            }
        }
        return stack.pop();
    }


}
