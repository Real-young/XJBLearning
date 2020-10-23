package booming.leetcode;

import java.util.Stack;

public class leetcode_856 {
    public int scoreOfParentheses(String S) {
        int score = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(') {
                stack.push(0);
            } else if (stack.peek() == 0) {
                stack.pop();
                stack.push(1);
            } else {
                int inScore = 0;
                while (stack.peek() != 0) {
                    inScore += stack.pop();
                }
                stack.pop();
                stack.push(inScore * 2);
            }
        }
        while (!stack.isEmpty()) {
            score += stack.pop();
        }
        return score;
    }

}
