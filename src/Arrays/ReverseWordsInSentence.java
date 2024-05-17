package Arrays;

public class ReverseWordsInSentence {

    public static String reverseWords(String s) {
        // Split the string into words
        String[] words = s.trim().split("\\s+");

        // Reverse the order of the words
        for (int i = 0; i < words.length / 2; i++) {
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }

        // Join the words back into a string, separated by a single space
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue")); // Output: "blue is sky the"
        System.out.println(reverseWords("  hello world  ")); // Output: "world hello"
        System.out.println(reverseWords("a good   example")); // Output: "example good a"
    }
}
