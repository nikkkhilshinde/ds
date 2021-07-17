package leetcode.tree;

import java.util.*;

//class WordFilter {
//
//    Trie trie;
//
//    public WordFilter(String[] words) {
//
//        this.trie = new Trie();
//        this.trie.insertWords(words);
//    }
//
//    public int f(String prefix, String suffix) {
//        if (this.trie.checkPrefixExists(prefix) && this.trie.checkSuffixExists(suffix)) {
//            List<Integer> prefixList = new ArrayList<>();
//            List<Integer> suffixList = new ArrayList<>();
//            trie.getLeavesByPrefix(prefix, prefixList);
//            trie.getLeavesBySuffix(suffix, suffixList);
//            List<Integer> result = new ArrayList<>();
//            prefixList.forEach(item -> {
//                if (suffixList.contains(item)) result.add(item);
//            });
//            Collections.sort(result);
//            if (result.isEmpty()) return -1;
//            return result.get(result.size() - 1);
//        }
//        return -1;
//    }
//}
//
//class Trie {
//    static class Node {
//        Character ch;
//        Map<Character, Node> children;
//        Boolean end;
//
//        public Node(Character ch) {
//            this.ch = ch;
//            this.children = new HashMap<>();
//            this.end = false;
//        }
//
//        public Node() {
//            this.children = new HashMap<>();
//            this.end = false;
//        }
//    }
//
//    Node prefixRoot;
//    Node suffixRoot;
//
//    public Trie() {
//        this.prefixRoot = new Node();
//        this.suffixRoot = new Node();
//    }
//
//    public void getLeavesBySuffix(String suffix, List<Integer> list) {
//        Node rootDummy = this.suffixRoot;
//        for (int i = suffix.length() - 1; i >= 0; i--) {
//            rootDummy = rootDummy.children.get(suffix.charAt(i));
//        }
//        getLeavesBySuffixHelper(rootDummy,list);
//    }
//
//    public void getLeavesBySuffixHelper(Node root, List<Integer> list) {
//        if (root.end) {
//            list.add(root.index);
//        }
//        root.children.forEach((key, value) -> {
//            getLeavesBySuffixHelper(value, list);
//        });
//    }
//
//    public void getLeavesByPrefix(String prefix, List<Integer> list) {
//        Node rootDummy = this.prefixRoot;
//        for (int i = 0; i < prefix.length(); i++) {
//            rootDummy = rootDummy.children.get(prefix.charAt(i));
//        }
//        getLeavesByPrefixHelper(rootDummy, list);
//    }
//
//    public void getLeavesByPrefixHelper(Node root, List<Integer> list) {
//        if (root.index >= 0) {
//            list.add(root.index);
//        }
//        root.children.forEach((key, value) -> {
//            getLeavesByPrefixHelper(value, list);
//        });
//    }
//
//    public boolean checkSuffixExists(String suffix) {
//        Node rootDummy = this.suffixRoot;
//        for (int i = suffix.length() - 1; i >= 0; i--) {
//            if (rootDummy.children.containsKey(suffix.charAt(i))) {
//                rootDummy = rootDummy.children.get(suffix.charAt(i));
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean checkPrefixExists(String prefix) {
//        Node rootDummy = this.prefixRoot;
//        for (int i = 0; i < prefix.length(); i++) {
//            if (rootDummy.children.containsKey(prefix.charAt(i))) {
//                rootDummy = rootDummy.children.get(prefix.charAt(i));
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public void insertWords(String[] words) {
//        for (int i = 0; i < words.length; i++) {
//            insertWordInSuffix(words[i], i);
//            insertWordInPrefix(words[i], i);
//        }
//    }
//
//    public void insertWordInSuffix(String word, int index) {
//        Node rootDummy = this.suffixRoot;
//        for (int i = word.length() - 1; i >= 0; i--) {
//            if (rootDummy.children.containsKey(word.charAt(i))) {
//                rootDummy = rootDummy.children.get(word.charAt(i));
//            } else {
//                Node newNode = new Node(word.charAt(i));
//                rootDummy.children.put(word.charAt(i), newNode);
//                rootDummy = rootDummy.children.get(word.charAt(i));
//            }
//        }
//        rootDummy.index = index;
//    }
//
//    public void insertWordInPrefix(String word, int index) {
//        Node rootDummy = this.prefixRoot;
//        for (int i = 0; i < word.length(); i++) {
//            if (rootDummy.children.containsKey(word.charAt(i))) {
//                rootDummy = rootDummy.children.get(word.charAt(i));
//            } else {
//                Node newNode = new Node(word.charAt(i));
//                rootDummy.children.put(word.charAt(i), newNode);
//                rootDummy = rootDummy.children.get(word.charAt(i));
//            }
//        }
//        rootDummy.index = index;
//    }
//}
///**
// * Your WordFilter object will be instantiated and called as such:
// * WordFilter obj = new WordFilter(words);
// * int param_1 = obj.f(prefix,suffix);
// */