package Trie;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The Trienode class is an actual node of the tree
 */
public class TrieNode implements Serializable {
    /**
     * data holds a single character
     * for every character there will be new node
     */
    char data;

    /**
     * A list of Trienodes to save all the child nodes
     * of a particular parent node
     */
    ArrayList<TrieNode> nodes;

    /**
     * At the leaf node, it will contain meaning of the
     * that word from root node to leaf node
     */
    String meaning;

    TrieNode(){
        nodes = new ArrayList<>();
    }
}
