package Searching.StringSearchingAlgorithms;

class TrieNode {
    private final TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26]; // For 26 letters
    }

    public boolean containsKey(char ch) {
        return children[ch -'a'] != null;
    }

    public TrieNode get(char ch) {
        return children[ch -'a'];
    }

    public void put(char ch, TrieNode node) {
        children[ch -'a'] = node;
    }

    public void setEnd() {
        isEndOfWord = true;
    }

    public boolean isEnd() {
        return isEndOfWord;
    }
}

