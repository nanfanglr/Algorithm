package com.rui.algorithm.lineartable;

import org.junit.Test;

public class BracketsMatchTest {
    @Test
    public void testBracketMatch() {
        String str = "(上海(长安)()))";
        boolean match = isMatch(str);
        System.out.println(str + "中的括号是否匹配:" + match);

    }

    private boolean isMatch(String str) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            String s = str.charAt(i) + "";
            if (s.equals("(")) {
                stack.push(s);
            } else if (s.equals(")")) {
                String pop = stack.pop();
                if (pop == null) {
                    return false;
                }
            }
        }
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}
