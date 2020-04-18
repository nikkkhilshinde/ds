package Tree.Trie;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Main class is a to demonstrate how trienode works
 * It allows user to add and retrieve data from node
 */

public class Main {
    public static void main(String[] args) {
        //trainTree();


        Scanner scanner = new Scanner(System.in);

        System.out.println("Loading object into memory...");
        TrieNode rootNode = retrieveRootNodeFromFile();
        System.out.println("Completed");
        System.out.println("Enter word for searching:");
        String input = scanner.nextLine();
        do{
            TrieNode tempNode = rootNode;
            for(int i = 0; i < input.length(); i++){
                tempNode =  searchInChildNodes(input.charAt(i), tempNode.nodes);
            }
            System.out.println(
                    String.format("Meaning of \"%s\" is %s",input,tempNode.meaning));
            input = scanner.nextLine();
        }while (!input.equals("end"));
//        persistNodeInFile(rootNode);
    }

    /**
     * It searches charAt in given child nodes
     *
     * @param  charAt   Character to be inserted into tree
     * @param  nodes    Arraylist of children for searching whether
     *                  charAt is present in them or not
     * @return          Returns node from children if charAt present
     *                  else create new one and then return
     */
    static TrieNode searchInChildNodes(char charAt,
                                               ArrayList<TrieNode> nodes) {
        for (TrieNode node : nodes) {
            if (node.data == charAt) {
                System.out.println(String.format
                        ("Node %c already present", charAt));
                return node;
            }
        }
        TrieNode trieNode = new TrieNode();
        trieNode.data = charAt;
        nodes.add(trieNode);

        System.out.println(
                String.format("Creating new Node for the %c",charAt));
        return trieNode;
    }

    static void trainTree(){
        TrieNode rootNode = retrieveRootNodeFromFile();
        AtomicInteger count = new AtomicInteger();
        File file = new File("dictionary_compact.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, String> wordMeaningMap = objectMapper.readValue(file,Map.class);

            wordMeaningMap.forEach((key, value) -> {

                TrieNode tempNode = rootNode;
                for(int i = 0; i < key.length(); i++){
                    tempNode =  searchInChildNodes(key.charAt(i), tempNode.nodes);
                }

                tempNode.meaning = value;
                System.out.println(count);
                count.getAndIncrement();
            });

            persistNodeInFile(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * It reads object of rootNode written into file and returns it
     *
     * @return          object of rootNode i.e TrieNode
     */
    static TrieNode retrieveRootNodeFromFile(){
        try(FileInputStream fileInputStream = new FileInputStream("rootNode.trie");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
            TrieNode trieNode = (TrieNode) objectInputStream.readObject();
            objectInputStream.close();
            System.out.println("Object read successfully");
            return trieNode;
        } catch (FileNotFoundException e) {
            System.out.println("File not found, creating new node");
            return new TrieNode();
        } catch (IOException e) {
            System.out.println(
                    String.format("Error occurred while reading object from file %s" +
                            ", returning new node",e.getMessage()));
            return new TrieNode();
        } catch (ClassNotFoundException e) {
            System.out.println("No object found in the file");
            return new TrieNode();
        }
    }

    /**
     * persistNodeInFile is using java serializable for writing that
     * rootNode into file
     *
     * @param  trieNode A rootNode to persist into file
     * @return          return true if successfully written into file
     *                  else false
     */
    static boolean persistNodeInFile(TrieNode trieNode){
        try(FileOutputStream fileOutputStream = new FileOutputStream("rootNode.trie");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
            
            objectOutputStream.writeObject(trieNode);
            objectOutputStream.close();
            System.out.println("Object written into file successfully.");
            return true;
        } catch (IOException e) {
            System.out.println(
                    String.format("Error occurred while writing object into file %s",e.getMessage()));
            return false;
        }
    }

}
