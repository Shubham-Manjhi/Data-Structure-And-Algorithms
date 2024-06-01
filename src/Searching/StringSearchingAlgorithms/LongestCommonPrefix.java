package Searching.StringSearchingAlgorithms;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        if (words.length == 1) {
            return words[0];
        }
        Trie trie = new Trie();
        for (int i = 1; i < words.length ; i++) {
            trie.insert(words[i]);
        }
        String firstWord = words[0];
        StringBuilder prefix = new StringBuilder();
        TrieNode temp = trie.root;
        for (char c : firstWord.toCharArray()) {
            if (temp.containsKey(c) && !temp.isEnd()) {
                prefix.append(c);
                temp = temp.get(c);
            } else {
                return prefix.toString();
            }
        }
        return prefix.toString();
    }
}
