package Stack;

import java.util.Stack;

public class RemoveOuterParentheses {

    public String removeOuterParentheses(String str) {
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<str.length();){
            i = getNextParenthesesAfterRemoveOuter(i,str,ans);
        }
        return ans.toString();
    }

    static int getNextParenthesesAfterRemoveOuter(int i, String str, StringBuilder ans){
        int j = i+1, t=1;
        while(t!=0 && j<str.length()){
            if(str.charAt(j)=='(') t += 1;
            else t -= 1;
            j++;
        }
        ans.append(str, i+1, j-1);
        return j;
    }

    public static String removeOuterParenthesesWithStack(String S) {
        StringBuilder s = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (!stack.isEmpty()) {
                    s.append(c);
                }
                stack.push(c);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    s.append(c);
                }
            }
        }
        return s.toString();
    }

}
