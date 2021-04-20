package com.coding.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    HashMap<Character, TrieNode> child;
    boolean isLast;

    public TrieNode() {
        child = new HashMap<>();
        for (char i = 'a'; i <= 'z'; i++)
            child.put(i, null);
        isLast = false;
    }
}

class PhoneBookDirectory {
    Map<String, Integer> phonebook;
    Trie trie;

    public PhoneBookDirectory() {
        phonebook = new HashMap<>();
        trie = new Trie();
    }

    public void addContact(String name, Integer phoneno) {
        phonebook.put(name, phoneno);
        trie.insert(name);
    }

    public void searchAndShowNoForAllCombination(String query) {
        trie.getContacts(query, phonebook);
    }
}


class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a Contact into the Trie
    public void insert(String s) {
        int len = s.length();
        // 'itr' is used to iterate the Trie Nodes
        TrieNode itr = root;
        for (int i = 0; i < len; i++) {
            // Check if the s[i] is already present in Trie
            TrieNode nextNode = itr.child.get(s.charAt(i));
            if (nextNode == null) {
                // If not found then create a new TrieNode
                nextNode = new TrieNode();
                // Insert into the HashMap
                itr.child.put(s.charAt(i), nextNode);
            }
            // Move the iterator('itr') ,to point to next Trie Node
            itr = nextNode;
            // If its the last character of the string 's' then mark 'isLast' as true
            if (i == len - 1)
                itr.isLast = true;
        }
    }

    // This function simply displays all dictionary words
// going through current node.  String 'prefix'
// represents string corresponding to the path from
// root to curNode.
    public void displayContactsUtil(TrieNode curNode,
                                    String prefix, ArrayList<String> contactsWithPrefix) { // Check if the string 'prefix' ends at this Node
// If yes then display the string found so far
        if (curNode.isLast) {
            contactsWithPrefix.add(prefix);
        }

// Find all the adjacent Nodes to the current
// Node and then call the function recursively
// This is similar to performing DFS on a graph
        for (char i = 'a'; i <= 'z'; i++) {
            TrieNode nextNode = curNode.child.get(i);
            if (nextNode != null) {
                displayContactsUtil(nextNode, prefix + i, contactsWithPrefix);
            }
        }
    }

    // Display suggestions after every character enter by
// the user for a given string 'str'
    void getContacts(String str, Map<String, Integer> phonebook) {
        TrieNode prevNode = root;
        String prefix = "";
        int len = str.length();
// Display the contact List for string formed
// after entering every character
        int i;
        for (i = 0; i < len; i++) {
// 'str' stores the string entered so far
            prefix += str.charAt(i);
// Get the last character entered
            char lastChar = prefix.charAt(i);
// Find the Node corresponding to the last
// character of 'str' which is pointed by
// prevNode of the Trie
            TrieNode curNode = prevNode.child.get(lastChar);
// If nothing found, then break the loop as
// no more prefixes are going to be present.
            if (curNode == null) {
                i++;
                break;
            }
            ArrayList<String> contactsWithPrefix = new ArrayList<>();
            displayContactsUtil(curNode, prefix, contactsWithPrefix);
            contactsWithPrefix.forEach(contact -> {
                System.out.println("Contact Name " + contact + " PhoneNumber is " + phonebook.get(contact));
            });
            // Change prevNode for next prefix
            prevNode = curNode;
        }
    }
}

// Driver code
class PhoneBook {
    public static void main(String args[]) {
        PhoneBookDirectory directory = new PhoneBookDirectory();
        directory.addContact("gforgeeks", 1234);
        directory.addContact("geeksquiz", 4567);
        directory.addContact("Ricky", 134242444);
        directory.addContact("Peter", 224323423);
        directory.addContact("Ron", 988232323);
        String query = "Ricky";
        directory.searchAndShowNoForAllCombination(query);
    }
}