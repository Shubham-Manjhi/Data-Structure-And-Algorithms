package Stack;

import java.util.Stack;

    public class ExpressionCalculator {
        public static void main(String[] args) {
            System.out.println(calculate("1 + 1")); // Output: 2
            System.out.println(calculate(" 2-1 + 2 ")); // Output: 3
            System.out.println(calculate("(1+(4+5+2)-3)+(6+8)")); // Output: 23
        }

        public static int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int operand = 0;
            int result = 0; // For the on-going result
            int sign = 1;  // 1 means positive, -1 means negative

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isDigit(ch)) {
                    // Forming operand, since it could be more than one digit
                    operand = 10 * operand + (int)(ch - '0');
                } else if (ch == '+') {
                    // Evaluate the expression to the left
                    // with result, sign, operand
                    result += sign * operand;
                    // Save the recently encountered '+' sign
                    sign = 1;
                    // Reset operand
                    operand = 0;
                } else if (ch == '-') {
                    result += sign * operand;
                    sign = -1;
                    operand = 0;
                } else if (ch == '(') {
                    // Push the result and sign on to the stack
                    // for later use, as result/sign will be updated
                    // for the evaluation of the expression within
                    // the parenthesis
                    stack.push(result);
                    stack.push(sign);
                    // Reset result and sign for the next level calculation
                    sign = 1;
                    result = 0;
                } else if (ch == ')') {
                    // Evaluate the expression to the left
                    // with result, sign and operand
                    result += sign * operand;
                    // ')' marks the end of an expression within a
                    // pair of parenthesis
                    // Its result is multiplied with the sign and
                    // added to the result calculated for the expression
                    // to the left of the parenthesis
                    result *= stack.pop();    // stack.pop() is the sign before the parenthesis
                    result += stack.pop();   // stack.pop() now is the result calculated before the parenthesis
                    // Reset the operand
                    operand = 0;
                }
            }
            return result + (sign * operand);
        }
    }
