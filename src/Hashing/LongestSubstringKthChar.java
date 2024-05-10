package Hashing;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class LongestSubstringKthChar {
    public int longestSubstring(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int count = 0;
        for (Map.Entry<Character, Integer> i : map.entrySet()) {
            if (i.getValue() >= k) {
                count += i.getValue();
            }
        }
        return count;
    }
}
