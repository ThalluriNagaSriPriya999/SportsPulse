package com.sportspulse.suffix;

import java.util.HashMap;
import java.util.Map;

public class SuffixTree {

    private static class Node {

        Map<Character, Node> children =
                new HashMap<>();

        String edgeLabel = "";

        boolean isEnd;
    }

    private final Node root;

    public SuffixTree(String text) {

        root = new Node();

        build(text);
    }

    private void build(String text) {

        for (int i = 0; i < text.length(); i++) {

            insertSuffix(
                    text.substring(i)
            );
        }
    }

    private void insertSuffix(String suffix) {

        Node current = root;

        int position = 0;

        while (position < suffix.length()) {

            char firstChar =
                    suffix.charAt(position);

            Node child =
                    current.children.get(firstChar);

            if (child == null) {

                child = new Node();

                child.edgeLabel =
                        suffix.substring(position);

                child.isEnd = true;

                current.children.put(
                        firstChar,
                        child
                );

                return;
            }

            String label =
                    child.edgeLabel;

            int commonLength =
                    commonPrefixLength(
                            suffix,
                            position,
                            label
                    );

            if (commonLength == label.length()) {

                current = child;

                position += commonLength;

            } else {

                Node split = new Node();

                split.edgeLabel =
                        label.substring(
                                0,
                                commonLength
                        );

                current.children.put(
                        firstChar,
                        split
                );

                child.edgeLabel =
                        label.substring(commonLength);

                split.children.put(
                        child.edgeLabel.charAt(0),
                        child
                );

                position += commonLength;

                if (position < suffix.length()) {

                    Node newChild = new Node();

                    newChild.edgeLabel =
                            suffix.substring(position);

                    newChild.isEnd = true;

                    split.children.put(
                            newChild.edgeLabel.charAt(0),
                            newChild
                    );

                } else {

                    split.isEnd = true;
                }

                return;
            }
        }

        current.isEnd = true;
    }

    private int commonPrefixLength(
            String suffix,
            int position,
            String label) {

        int length = 0;

        while (
                position + length < suffix.length()
                &&
                length < label.length()
                &&
                suffix.charAt(position + length)
                        == label.charAt(length)
        ) {

            length++;
        }

        return length;
    }

    public boolean contains(String pattern) {

        if (pattern == null ||
                pattern.isEmpty()) {

            return true;
        }

        Node current = root;

        int position = 0;

        while (position < pattern.length()) {

            Node child =
                    current.children.get(
                            pattern.charAt(position)
                    );

            if (child == null) {
                return false;
            }

            String label =
                    child.edgeLabel;

            int i = 0;

            while (
                    i < label.length()
                    &&
                    position + i < pattern.length()
                    &&
                    label.charAt(i)
                            == pattern.charAt(position + i)
            ) {

                i++;
            }

            if (
                    i < label.length()
                    &&
                    position + i < pattern.length()
            ) {
                return false;
            }

            position += i;

            if (position == pattern.length()) {
                return true;
            }

            current = child;
        }

        return true;
    }

    public void printTree() {

        System.out.println(
                "\n========== SUFFIX TREE ==========");

        printNode(root, "");
    }

    private void printNode(
            Node node,
            String indent) {

        for (Node child :
                node.children.values()) {

            System.out.println(
                    indent +
                    "└── " +
                    child.edgeLabel
            );

            printNode(
                    child,
                    indent + "    "
            );
        }
    }
}