package com.sportspulse.string;

import java.util.*;

public class AhoCorasick {

    private static class Node {

        Map<Character, Node> children =
                new HashMap<>();

        Node failure;

        List<String> outputs =
                new ArrayList<>();
    }

    private final Node root;

    public AhoCorasick() {
        root = new Node();
    }

    public void addPattern(String pattern) {

        Node current = root;

        for (char c : pattern.toLowerCase().toCharArray()) {

            current = current.children.computeIfAbsent(
                    c, k -> new Node());
        }

        current.outputs.add(pattern.toLowerCase());
    }

    public void buildFailureLinks() {

        Queue<Node> queue = new LinkedList<>();

        root.failure = root;

        for (Node child : root.children.values()) {

            child.failure = root;
            queue.add(child);
        }

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            for (Map.Entry<Character, Node> entry :
                    current.children.entrySet()) {

                char character = entry.getKey();

                Node child = entry.getValue();

                Node failureNode = current.failure;

                while (failureNode != root &&
                       !failureNode.children.containsKey(character)) {

                    failureNode = failureNode.failure;
                }

                if (failureNode.children.containsKey(character) &&
                    failureNode.children.get(character) != child) {

                    child.failure =
                            failureNode.children.get(character);

                } else {

                    child.failure = root;
                }

                child.outputs.addAll(
                        child.failure.outputs);

                queue.add(child);
            }
        }
    }

    public Map<String, List<Integer>> search(String text) {

        Map<String, List<Integer>> results =
                new LinkedHashMap<>();

        Node current = root;

        text = text.toLowerCase();

        for (int i = 0; i < text.length(); i++) {

            char character = text.charAt(i);

            while (current != root &&
                   !current.children.containsKey(character)) {

                current = current.failure;
            }

            if (current.children.containsKey(character)) {

                current = current.children.get(character);

            } else {

                current = root;
            }

            for (String pattern : current.outputs) {

                int position =
                        i - pattern.length() + 1;

                results.computeIfAbsent(
                        pattern,
                        k -> new ArrayList<>())
                        .add(position);
            }
        }

        return results;
    }
} 