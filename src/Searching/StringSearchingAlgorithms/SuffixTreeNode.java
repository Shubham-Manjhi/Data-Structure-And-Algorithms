package Searching.StringSearchingAlgorithms;

import java.util.*;

class SuffixTreeNode {
    HashMap<Character, SuffixTreeNode> children = new HashMap<>();
    char value;
    ArrayList<Integer> indexes = new ArrayList<>();

    public SuffixTreeNode() { }

    public void insertString(String s, int index) {
        indexes.add(index);
        if (s != null && !s.isEmpty()) {
            value = s.charAt(0);
            SuffixTreeNode child;
            if (children.containsKey(value)) {
                child = children.get(value);
            } else {
                child = new SuffixTreeNode();
                children.put(value, child);
            }
            String remainder = s.substring(1);
            child.insertString(remainder, index);
        }
    }

    public ArrayList<Integer> search(String s) {
        if (s == null || s.isEmpty()) {
            return indexes;
        } else {
            char first = s.charAt(0);
            if (children.containsKey(first)) {
                String remainder = s.substring(1);
                return children.get(first).search(remainder);
            }
        }
        return null;
    }
}

class SuffixTree {
    SuffixTreeNode root = new SuffixTreeNode();

    public SuffixTree(String s) {
        for (int i = 0; i < s.length(); i++) {
            String suffix = s.substring(i);
            root.insertString(suffix, i);
        }
    }

    public ArrayList<Integer> search(String s) {
        return root.search(s);
    }

    public static void main(String[] args) {
        SuffixTree tree = new SuffixTree("banana");
        ArrayList<Integer> list = tree.search("ana");
        if (list != null) {
            for (int i : list) {
                System.out.println(i);
            }
        }
    }
}
