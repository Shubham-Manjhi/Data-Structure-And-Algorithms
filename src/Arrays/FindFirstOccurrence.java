package Arrays;

public class FindFirstOccurrence {

    public int strStr(String haystack, String needle) {
        // If needle is an empty string, we return 0
        if (needle.isEmpty()) {
            return 0;
        }

        // Use the indexOf method to find the first occurrence of needle in haystack
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        FindFirstOccurrence strStr = new FindFirstOccurrence();

        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println(strStr.strStr(haystack1, needle1)); // Output: 0

        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(strStr.strStr(haystack2, needle2)); // Output: -1
    }
}
