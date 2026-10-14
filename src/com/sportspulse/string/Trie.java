package com.sportspulse.string;

import java.util.*;

public class Trie {

    private static class Node {

        Map<Character, Node> children =
                new TreeMap<>();

        boolean isEnd;
    }

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {

        if (word == null || word.isEmpty()) {
            return;
        }

        Node current = root;

        for (char c : word.toLowerCase().toCharArray()) {

            current = current.children.computeIfAbsent(
                    c, k -> new Node());
        }

        current.isEnd = true;
    }

    public boolean search(String word) {

        Node node = findNode(word);

        return node != null && node.isEnd;
    }

    public List<String> startsWith(String prefix) {

        List<String> results = new ArrayList<>();

        Node node = findNode(prefix);

        if (node == null) {
            return results;
        }

        collectWords(node,
                prefix.toLowerCase(),
                results);

        return results;
    }

    private Node findNode(String word) {

        if (word == null || word.isEmpty()) {
            return root;
        }

        Node current = root;

        for (char c : word.toLowerCase().toCharArray()) {

            if (!current.children.containsKey(c)) {
                return null;
            }

            current = current.children.get(c);
        }

        return current;
    }

    private void collectWords(
            Node node,
            String currentWord,
            List<String> results) {

        if (node.isEnd) {
            results.add(currentWord);
        }

        for (Map.Entry<Character, Node> entry :
                node.children.entrySet()) {

            collectWords(
                    entry.getValue(),
                    currentWord + entry.getKey(),
                    results);
        }
    }
}