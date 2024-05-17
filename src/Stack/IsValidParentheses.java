package Stack;

import java.util.Stack;

public class IsValidParentheses {

    // Question : Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.


    // Average Solution Using Stack.
    public boolean isValidParentheses(String parenthesesString) {
        Stack<Character> parenthesesStack = new Stack<>();
        for (char parentheses : parenthesesString.toCharArray()) {
            if (
                parentheses == '('
                    || parentheses == '{'
                    || parentheses == '['
            ) {
                parenthesesStack.push(parentheses);
            } else if (
                parenthesesStack.isEmpty()
                    || parentheses == ')' && parenthesesStack.pop() != '('
                    || parentheses == '}' && parenthesesStack.pop() != '{'
                    || parentheses == ']' && parenthesesStack.pop() != '['
            ) {
                return false;
            }
        }
        return parenthesesStack.isEmpty();
    }

    // Optimized Solution with
    public boolean isValid(String parenthesesString) {
        int parenthesesLength = parenthesesString.length();
        if (parenthesesLength % 2 != 0) {
            return false;
        }
        int i = -1;
        char[] parenthesesArray = new char[parenthesesLength];
        for (char parentheses : parenthesesString.toCharArray()) {
            if (
                parentheses == '{'
                    || parentheses == '['
                    || parentheses == '('
            ) {
                parenthesesArray[++i] = parentheses;
            } else {
                if (
                    i >= 0 && ((parenthesesArray[i] == '(' && parentheses == ')')
                        || (parenthesesArray[i] == '{' && parentheses == '}')
                        || (parenthesesArray[i] == '[') && parentheses == ']'))
                    i--;
                else
                    return false;
            }
        }
        return i == -1;
    }

    public static void main(String[] args) {

        IsValidParentheses isValidParentheses = new IsValidParentheses();

        long start = System.currentTimeMillis();
        System.out.println(isValidParentheses.isValidParentheses("()()()(){}{}[][]()()"));
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time in milli seconds: "+ (end-start));

        start = System.currentTimeMillis();
        System.out.println(isValidParentheses.isValid("()()()(){}{}[][]()()"));
        end = System.currentTimeMillis();
        System.out.println("Elapsed Time in milli seconds: "+ (end-start));
    }
}
