package Arrays;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(ga.groupAnagrams(strs1));

        String[] strs2 = {""};
        System.out.println(ga.groupAnagrams(strs2));

        String[] strs3 = {"a"};
        System.out.println(ga.groupAnagrams(strs3));
    }
}
