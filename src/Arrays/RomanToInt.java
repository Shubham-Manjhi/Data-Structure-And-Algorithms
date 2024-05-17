package Arrays;

import java.util.*;

public class RomanToInt {
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int prev = 0;
        for (char c : s.toCharArray()) {
            int current = map.get(c);
            result += current;
            if (current > prev) {
                result -= 2 * prev;
            }
            prev = current;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));    // Output: 3
        System.out.println(romanToInt("LVIII"));   // Output: 58
        System.out.println(romanToInt("MCMXCIV")); // Output: 1994
    }
}
