package com.sportspulse;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==============================================");
            System.out.println("       SPORTSPULSE - SPORTS ANALYTICS");
            System.out.println("==============================================");
            System.out.println("1. String Analytics [CO1]");
            System.out.println("2. Suffix Structure Analytics [CO2]");
            System.out.println("3. Advanced DP Analytics [CO3]");
            System.out.println("4. Run Complete CO1-CO3 Test");
            System.out.println("0. Exit");
            System.out.println("==============================================");

            System.out.print("Enter your choice: ");
            int choice = readInt();

            switch (choice) {

                case 1:
                    stringAnalyticsMenu();
                    break;

                case 2:
                    suffixAnalyticsMenu();
                    break;

                case 3:
                    dpAnalyticsMenu();
                    break;

                case 4:
                    runCompleteTest();
                    break;

                case 0:
                    System.out.println("\nThank you for using SportsPulse!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // =========================================================
    // CO1 - STRING ANALYTICS
    // =========================================================

    private static void stringAnalyticsMenu() {

        while (true) {

            System.out.println("\n==============================================");
            System.out.println("          CO1 - STRING ANALYTICS");
            System.out.println("==============================================");
            System.out.println("1. KMP Pattern Matching");
            System.out.println("2. Z Algorithm");
            System.out.println("3. Rabin-Karp");
            System.out.println("4. Aho-Corasick");
            System.out.println("5. Trie");
            System.out.println("0. Back");
            System.out.println("==============================================");

            System.out.print("Enter your choice: ");
            int choice = readInt();

            switch (choice) {

                case 1:
                    testKMP();
                    break;

                case 2:
                    testZAlgorithm();
                    break;

                case 3:
                    testRabinKarp();
                    break;

                case 4:
                    testAhoCorasick();
                    break;

                case 5:
                    testTrie();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // =========================================================
    // KMP
    // =========================================================

    private static void testKMP() {

        System.out.println("\n========== KMP STRING MATCHING ==========");

        String text = "Arjun scored a goal for Thunder FC";
        String pattern = "goal";

        List<Integer> positions =
                com.sportspulse.string.KMP.search(text, pattern);

        System.out.println("Text    : " + text);
        System.out.println("Pattern : " + pattern);

        if (positions.isEmpty()) {
            System.out.println("Pattern not found.");
        } else {
            System.out.println(
                    "Pattern found at positions: " + positions
            );
        }

        System.out.println("Time Complexity  : O(n + m)");
        System.out.println("Space Complexity : O(m)");
    }

    // =========================================================
    // Z ALGORITHM
    // =========================================================

    private static void testZAlgorithm() {

        System.out.println("\n========== Z ALGORITHM ==========");

        String text = "Thunder FC scored a goal";
        String pattern = "goal";

        try {

            Object result =
                    com.sportspulse.string.ZAlgorithm.search(
                            text,
                            pattern
                    );

            System.out.println("Text    : " + text);
            System.out.println("Pattern : " + pattern);
            System.out.println("Result  : " + result);

        } catch (Exception e) {

            System.out.println(
                    "Z Algorithm test could not be executed."
            );
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println("Time Complexity  : O(n + m)");
        System.out.println("Space Complexity : O(n + m)");
    }

    // =========================================================
    // RABIN-KARP
    // =========================================================

    private static void testRabinKarp() {

        System.out.println("\n========== RABIN-KARP ==========");

        String text = "Thunder FC scored a goal";
        String pattern = "goal";

        try {

            Object result =
                    com.sportspulse.string.RabinKarp.search(
                            text,
                            pattern
                    );

            System.out.println("Text    : " + text);
            System.out.println("Pattern : " + pattern);
            System.out.println("Result  : " + result);

        } catch (Exception e) {

            System.out.println(
                    "Rabin-Karp test could not be executed."
            );
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println("Average Time Complexity : O(n + m)");
        System.out.println("Worst Case              : O(nm)");
        System.out.println("Space Complexity        : O(1)");
    }

    // =========================================================
    // AHO-CORASICK
    // =========================================================

    private static void testAhoCorasick() {

        System.out.println("\n========== AHO-CORASICK ==========");

        try {

            com.sportspulse.string.AhoCorasick aho =
                    new com.sportspulse.string.AhoCorasick();

            aho.addPattern("goal");
            aho.addPattern("penalty");
            aho.addPattern("assist");

            aho.buildFailureLinks();

            String text =
                    "Arjun scored a goal after a brilliant assist and penalty";

            System.out.println("Text: " + text);
            System.out.println(
                    "Patterns: goal, penalty, assist"
            );

            aho.search(text);

        } catch (Exception e) {

            System.out.println(
                    "Aho-Corasick test could not be executed."
            );
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println(
                "Time Complexity : O(n + total pattern length + matches)"
        );
        System.out.println(
                "Space Complexity: O(total pattern length)"
        );
    }

    // =========================================================
    // TRIE
    // =========================================================

    private static void testTrie() {

        System.out.println("\n========== TRIE ==========");

        try {

            com.sportspulse.string.Trie trie =
                    new com.sportspulse.string.Trie();

            trie.insert("Arjun");
            trie.insert("Aravind");
            trie.insert("Rahul");
            trie.insert("Rohan");
            trie.insert("Ravi");

            System.out.println("Inserted player names:");
            System.out.println("Arjun");
            System.out.println("Aravind");
            System.out.println("Rahul");
            System.out.println("Rohan");
            System.out.println("Ravi");

            System.out.println("\nPlayers starting with 'Ra':");

            List<String> results =
                    trie.startsWith("Ra");

            if (results.isEmpty()) {
                System.out.println("No matching players found.");
            } else {
                for (String word : results) {
                    System.out.println(word);
                }
            }

        } catch (Exception e) {

            System.out.println("Trie test failed.");
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println("Time Complexity : O(L)");
        System.out.println(
                "Space Complexity: O(total characters)"
        );
    }

    // =========================================================
    // CO2 - SUFFIX STRUCTURES
    // =========================================================

    private static void suffixAnalyticsMenu() {

        while (true) {

            System.out.println("\n==============================================");
            System.out.println(
                    "       CO2 - SUFFIX STRUCTURE ANALYTICS"
            );
            System.out.println("==============================================");
            System.out.println("1. Suffix Array");
            System.out.println("2. LCP - Kasai Algorithm");
            System.out.println("3. SA-IS");
            System.out.println("4. Suffix Tree");
            System.out.println("5. Suffix Automaton");
            System.out.println("0. Back");
            System.out.println("==============================================");

            System.out.print("Enter your choice: ");
            int choice = readInt();

            switch (choice) {

                case 1:
                    testSuffixArray();
                    break;

                case 2:
                    testLCP();
                    break;

                case 3:
                    testSAIS();
                    break;

                case 4:
                    testSuffixTree();
                    break;

                case 5:
                    testSuffixAutomaton();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // =========================================================
    // SUFFIX ARRAY
    // =========================================================

    private static void testSuffixArray() {

        System.out.println("\n========== SUFFIX ARRAY ==========");

        String text = "banana";

        try {

            com.sportspulse.suffix.SuffixArray suffixArray =
                    new com.sportspulse.suffix.SuffixArray(text);

            System.out.println("Text: " + text);

            suffixArray.printSuffixArray();

        } catch (Exception e) {

            System.out.println("Suffix Array test failed.");
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println(
                "Current implementation: comparison-based construction"
        );
    }

    // =========================================================
    // LCP - KASAI
    // =========================================================

    private static void testLCP() {

        System.out.println("\n========== LCP - KASAI ALGORITHM ==========");

        String text = "banana";

        try {

            com.sportspulse.suffix.SuffixArray suffixArray =
                    new com.sportspulse.suffix.SuffixArray(text);

            Integer[] sa =
                    suffixArray.getSuffixArray();

            int[] lcp =
                    com.sportspulse.suffix.LCPKasai.buildLCP(
                            text,
                            sa
                    );

            System.out.println("Text: " + text);

            System.out.println("\nSuffix Array:");

            for (int i = 0; i < sa.length; i++) {

                System.out.println(
                        i + " -> " + sa[i]
                                + " -> "
                                + text.substring(sa[i])
                );
            }

            System.out.println("\nLCP Array:");

            for (int i = 0; i < lcp.length; i++) {

                System.out.println(
                        "Index " + i + " : " + lcp[i]
                );
            }

        } catch (Exception e) {

            System.out.println("LCP test failed.");
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println("Time Complexity : O(n)");
        System.out.println("Space Complexity: O(n)");
    }

    // =========================================================
    // SA-IS
    // =========================================================

    private static void testSAIS() {

        System.out.println("\n========== SA-IS SUFFIX ARRAY ==========");

        String text = "banana";

        try {

            int[] suffixArray =
                    com.sportspulse.suffix.SAIS.buildSuffixArray(text);

            System.out.println("Text: " + text);

            for (int position : suffixArray) {

                System.out.println(
                        position
                                + " -> "
                                + text.substring(position)
                );
            }

        } catch (Exception e) {

            System.out.println("SA-IS test failed.");
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println(
                "Purpose: Efficient suffix-array construction"
        );
    }

    // =========================================================
    // SUFFIX TREE
    // =========================================================

    private static void testSuffixTree() {

        System.out.println("\n========== SUFFIX TREE ==========");

        String text = "banana";

        try {

            com.sportspulse.suffix.SuffixTree tree =
                    new com.sportspulse.suffix.SuffixTree(text);

            System.out.println("Text: " + text);

            tree.printTree();

            System.out.println(
                    "\nContains 'ana': "
                            + tree.contains("ana")
            );

            System.out.println(
                    "Contains 'xyz': "
                            + tree.contains("xyz")
            );

        } catch (Exception e) {

            System.out.println("Suffix Tree test failed.");
            System.out.println("Reason: " + e.getMessage());
        }
    }

    // =========================================================
    // SUFFIX AUTOMATON
    // =========================================================

    private static void testSuffixAutomaton() {

        System.out.println("\n========== SUFFIX AUTOMATON ==========");

        String text = "banana";

        try {

            com.sportspulse.suffix.SuffixAutomaton automaton =
                    new com.sportspulse.suffix.SuffixAutomaton(text);

            System.out.println("Text: " + text);

            System.out.println(
                    "Contains 'ana': "
                            + automaton.contains("ana")
            );

            System.out.println(
                    "Contains 'nan': "
                            + automaton.contains("nan")
            );

            System.out.println(
                    "Contains 'xyz': "
                            + automaton.contains("xyz")
            );

        } catch (Exception e) {

            System.out.println(
                    "Suffix Automaton test failed."
            );
            System.out.println("Reason: " + e.getMessage());
        }
    }

    // =========================================================
    // CO3 - ADVANCED DP
    // =========================================================

    private static void dpAnalyticsMenu() {

        while (true) {

            System.out.println("\n==============================================");
            System.out.println("          CO3 - ADVANCED DP ANALYTICS");
            System.out.println("==============================================");
            System.out.println("1. Levenshtein Edit Distance");
            System.out.println("2. Damerau-Levenshtein Distance");
            System.out.println("3. Bitmask DP - TSP");
            System.out.println("4. Matrix Chain Multiplication");
            System.out.println("5. Subset DP");
            System.out.println("0. Back");
            System.out.println("==============================================");

            System.out.print("Enter your choice: ");
            int choice = readInt();

            switch (choice) {

                case 1:
                    testLevenshtein();
                    break;

                case 2:
                    testDamerau();
                    break;

                case 3:
                    testBitmaskDP();
                    break;

                case 4:
                    testMatrixChainDP();
                    break;

                case 5:
                    testSubsetDP();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // =========================================================
    // LEVENSHTEIN
    // =========================================================

    private static void testLevenshtein() {

        System.out.println(
                "\n========== LEVENSHTEIN DISTANCE =========="
        );

        String a = "goal";
        String b = "gool";

        try {

            int distance =
                    com.sportspulse.dp.Levenshtein.distance(a, b);

            System.out.println("String 1: " + a);
            System.out.println("String 2: " + b);
            System.out.println("Edit Distance: " + distance);

            com.sportspulse.dp.Levenshtein.printTable(a, b);

        } catch (Exception e) {

            System.out.println(
                    "Levenshtein test failed."
            );
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println("Time Complexity : O(mn)");
        System.out.println("Space Complexity: O(mn)");
    }

    // =========================================================
    // DAMERAU-LEVENSHTEIN
    // =========================================================

    private static void testDamerau() {

        System.out.println(
                "\n========== DAMERAU-LEVENSHTEIN =========="
        );

        String a = "goal";
        String b = "gola";

        try {

            int distance =
                    com.sportspulse.dp.DamerauLevenshtein
                            .distance(a, b);

            System.out.println("String 1: " + a);
            System.out.println("String 2: " + b);
            System.out.println("Distance: " + distance);

            com.sportspulse.dp.DamerauLevenshtein
                    .printTable(a, b);

        } catch (Exception e) {

            System.out.println(
                    "Damerau-Levenshtein test failed."
            );
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println("Time Complexity : O(mn)");
        System.out.println("Space Complexity: O(mn)");
    }

    // =========================================================
    // BITMASK DP
    // =========================================================

    private static void testBitmaskDP() {

        System.out.println("\n========== BITMASK DP - TSP ==========");

        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        try {

            int result =
                    com.sportspulse.dp.BitmaskDP.tsp(graph);

            System.out.println(
                    "Minimum TSP Cost: " + result
            );

            com.sportspulse.dp.BitmaskDP
                    .printDPTable(graph);

        } catch (Exception e) {

            System.out.println(
                    "Bitmask DP test failed."
            );
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println("Time Complexity : O(n² × 2ⁿ)");
        System.out.println("Space Complexity: O(n × 2ⁿ)");
    }

    // =========================================================
    // MATRIX CHAIN
    // =========================================================

    private static void testMatrixChainDP() {

        System.out.println(
                "\n========== MATRIX CHAIN MULTIPLICATION =========="
        );

        int[] dimensions = {
                10, 20, 30, 40, 30
        };

        try {

            int result =
                    com.sportspulse.dp.MatrixChainDP
                            .minimumMultiplications(dimensions);

            System.out.println(
                    "Minimum Multiplications: " + result
            );

            com.sportspulse.dp.MatrixChainDP
                    .printDPTable(dimensions);

        } catch (Exception e) {

            System.out.println(
                    "Matrix Chain DP test failed."
            );
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println("Time Complexity : O(n³)");
        System.out.println("Space Complexity: O(n²)");
    }

    // =========================================================
    // SUBSET DP
    // =========================================================

    private static void testSubsetDP() {

        System.out.println("\n========== SUBSET DP ==========");

        int[] values = {
                3, 34, 4, 12, 5, 2
        };

        int target = 9;

        try {

            boolean possible =
                    com.sportspulse.dp.SubsetDP
                            .canFormTarget(values, target);

            System.out.println(
                    "Values: "
                            + java.util.Arrays.toString(values)
            );

            System.out.println("Target: " + target);

            System.out.println(
                    "Target possible: " + possible
            );

            com.sportspulse.dp.SubsetDP
                    .printDPTable(values, target);

        } catch (Exception e) {

            System.out.println(
                    "Subset DP test failed."
            );
            System.out.println("Reason: " + e.getMessage());
        }

        System.out.println(
                "Time Complexity : O(n × target)"
        );
        System.out.println(
                "Space Complexity: O(n × target)"
        );
    }

    // =========================================================
    // COMPLETE TEST
    // =========================================================

    private static void runCompleteTest() {

        System.out.println("\n\n");
        System.out.println("================================================");
        System.out.println("       SPORTSPULSE COMPLETE REVIEW TEST");
        System.out.println("              CO1 + CO2 + CO3");
        System.out.println("================================================");

        System.out.println("\n--------------- CO1 TESTS ---------------");

        testKMP();
        testZAlgorithm();
        testRabinKarp();
        testAhoCorasick();
        testTrie();

        System.out.println("\n--------------- CO2 TESTS ---------------");

        testSuffixArray();
        testLCP();
        testSAIS();
        testSuffixTree();
        testSuffixAutomaton();

        System.out.println("\n--------------- CO3 TESTS ---------------");

        testLevenshtein();
        testDamerau();
        testBitmaskDP();
        testMatrixChainDP();
        testSubsetDP();

        System.out.println("\n================================================");
        System.out.println("       CO1-CO3 TEST EXECUTION COMPLETED");
        System.out.println("================================================");
    }

    // =========================================================
    // INPUT
    // =========================================================

    private static int readInt() {

        while (true) {

            try {

                return Integer.parseInt(
                        sc.nextLine().trim()
                );

            } catch (NumberFormatException e) {

                System.out.print(
                        "Please enter a valid number: "
                );
            }
        }
    }
}