package Stack;

import java.util.Stack;

public class IsValidSymbolPattern {

    public static boolean areSymbolsBalanced(String expr) {
        // Create a stack to hold the symbols
        Stack<Character> stack = new Stack<Character>();

        // Loop through each character in the string
        for (int i = 0; i < expr.length(); i++) {
            char x = expr.charAt(i);

            // If the character is an opening symbol, push it onto the stack
            if (x == '(' || x == '[' || x == '{') {
                stack.push(x);
                continue;
            }

            // If the stack is empty, the symbols are not balanced
            if (stack.isEmpty())
                return false;

            char check;
            // Check the top of the stack against the closing symbol
            switch (x) {
                case ')':
                    check = stack.pop();
                    // If the top of the stack is not the matching opening symbol, the symbols are not balanced
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        // If the stack is empty after processing the entire string, the symbols are balanced
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        String expr = "([{}]){";

        // Print whether the symbols in the string are balanced
        if (areSymbolsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");
    }

}
