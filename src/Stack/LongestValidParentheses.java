package Stack;

import java.util.Stack;

public class LongestValidParentheses {

    public static String isValidParentheses(String parenthesesString) {

        StringBuilder longestValidParentheses = new StringBuilder();
        int longestValidParenthesesLength = 0;
        String finalLongestValidParentheses = "";

        Stack<Character> parenthesesStack = new Stack<>();
        for (char parentheses : parenthesesString.toCharArray()) {
            System.out.println(finalLongestValidParentheses);
            if (parentheses == '(' || parentheses == '{' || parentheses == '[') {
                parenthesesStack.push(parentheses);
            }  else {
                Character parenthesesPop = parenthesesStack.pop();




                if (parentheses == ')' && parenthesesPop == '(') {
                    longestValidParentheses.append('(');
                    longestValidParentheses.append(')');
                } else if (parentheses == '}' && parenthesesPop == '{') {
                    longestValidParentheses.append('{');
                    longestValidParentheses.append('}');
                } else if (parentheses == ']' && parenthesesPop == '[') {
                    longestValidParentheses.append('[');
                    longestValidParentheses.append(']');
                } else {
                    if (longestValidParentheses.length() > longestValidParenthesesLength) {
                        longestValidParenthesesLength = longestValidParentheses.length();
                        finalLongestValidParentheses = longestValidParentheses.toString();
                        longestValidParentheses = new StringBuilder();
                    }
                }

            }
        }
        return finalLongestValidParentheses;
    }

    public static void main(String[] args) {
        System.out.println(isValidParentheses("()()())"));
    }

}
