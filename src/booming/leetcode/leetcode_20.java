package booming.leetcode;

// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/

import stack.Stack;

import java.util.HashMap;

public class leetcode_20 {

//    private HashMap<Character, Character> map = new HashMap<>();
//
//    public leetcode_20() {
//        map.put('(',')');
//        map.put('[',']');
//        map.put('{','}');
//    }

    private static HashMap<Character, Character> map = new HashMap<>();

    static {
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
    }


    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        int length = s.length();
//        for (int i = 0; i < length; i++) {
//            char c = s.charAt(i);
//            if (c == '(' || c == '[' || c == '{') {
//                stack.push(c);
//            } else {
//                if (stack.isEmpty()) return false;
//                char left = stack.pop();
//                if (left == '(' && c != ')') return false;
//                if (left == '[' && c != ']') return false;
//                if (left == '{' && c != '}') return false;
//            }
//
//        }
//        return stack.isEmpty();


        Stack<Character> stack = new Stack<>();

        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (map.get(stack.pop()) != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
