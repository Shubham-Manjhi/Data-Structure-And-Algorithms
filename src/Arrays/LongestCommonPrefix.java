package Arrays;

public class LongestCommonPrefix {

    // Function to find the longest common prefix string amongst an array of strings.
    public String longestCommonPrefix(String[] strs) {
        // If the array is empty, return an empty string.
        if (strs.length == 0) return "";

        // Initialize the prefix as the first string in the array.
        String prefix = strs[0];

        // Iterate over the rest of the strings in the array.
        for (int i = 1; i < strs.length; i++) {
            // Check if the current prefix is a prefix of the string.
            // If it's not, remove the last character from the prefix and check again.
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, return an empty string.
                if (prefix.isEmpty()) return "";
            }
        }

        // If it finishes checking all the strings and the prefix is not empty, return the prefix.
        return prefix;
    }

    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strs)); // Output: "fl"
    }
}
