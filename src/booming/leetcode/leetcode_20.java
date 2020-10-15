package booming.leetcode;

// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/

import stack.Stack;

public class leetcode_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char left = stack.pop();
                if (left == '(' && c != ')') return false;
                if (left == '[' && c != ']') return false;
                if (left == '{' && c != '}') return false;
            }

        }
        return stack.isEmpty();
    }
}
