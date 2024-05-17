package Basics;

public class IsPangram {

    public static boolean isPangram(String sentence) {
        boolean[] mark = new boolean[26];
        int index = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if ('A' <= sentence.charAt(i) && sentence.charAt(i) <= 'Z') {
                index = sentence.charAt(i) - 'A';
            } else if('a' <= sentence.charAt(i) && sentence.charAt(i) <= 'z') {
                index = sentence.charAt(i) - 'a';
            }
            mark[index] = true;
        }

        for (int i = 0; i <= 25; i++) {
            if (!mark[i]) return false;
        }
        return true;
    }

    public static boolean isPangramRecursive(String sentence, int index, boolean[] mark) {
        if (index == sentence.length()) {
            for (boolean b : mark) {
                if (!b) return false;
            }
            return true;
        }

        char ch = sentence.charAt(index);
        if ('a' <= ch && ch <= 'z') {
            mark[ch - 'a'] = true;
        }
        return isPangramRecursive(sentence, index + 1, mark);
    }

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog";
        System.out.println(isPangram(sentence));

        boolean[] mark = new boolean[26];
        System.out.println(isPangramRecursive(sentence.toLowerCase(), 0, mark));
    }
}