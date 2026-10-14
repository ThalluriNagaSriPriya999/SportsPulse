package com.sportspulse.dp;

public class DamerauLevenshtein {

    public static int distance(String a, String b) {

        int m = a.length();
        int n = b.length();

        int[][] dp = new int[m + 1][n + 1];

        // Base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                int cost;

                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    cost = 0;
                } else {
                    cost = 1;
                }

                // Insert, Delete, Replace
                dp[i][j] = Math.min(
                        dp[i - 1][j] + 1,
                        Math.min(
                                dp[i][j - 1] + 1,
                                dp[i - 1][j - 1] + cost
                        )
                );

                // Transposition
                if (i > 1 && j > 1
                        && a.charAt(i - 1) == b.charAt(j - 2)
                        && a.charAt(i - 2) == b.charAt(j - 1)) {

                    dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i - 2][j - 2] + 1
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void printTable(String a, String b) {

        int m = a.length();
        int n = b.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                int cost =
                        a.charAt(i - 1) == b.charAt(j - 1)
                        ? 0 : 1;

                dp[i][j] = Math.min(
                        dp[i - 1][j] + 1,
                        Math.min(
                                dp[i][j - 1] + 1,
                                dp[i - 1][j - 1] + cost
                        )
                );

                if (i > 1 && j > 1
                        && a.charAt(i - 1) == b.charAt(j - 2)
                        && a.charAt(i - 2) == b.charAt(j - 1)) {

                    dp[i][j] = Math.min(
                            dp[i][j],
                            dp[i - 2][j - 2] + 1
                    );
                }
            }
        }

        System.out.println("\n========== DAMERAU-LEVENSHTEIN ==========");

        System.out.print("    ");

        for (int j = 0; j < n; j++) {
            System.out.printf("%3c", b.charAt(j));
        }

        System.out.println();

        for (int i = 0; i <= m; i++) {

            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.printf("%c ", a.charAt(i - 1));
            }

            for (int j = 0; j <= n; j++) {
                System.out.printf("%3d", dp[i][j]);
            }

            System.out.println();
        }

        System.out.println(
                "\nMinimum Damerau-Levenshtein Distance = "
                + dp[m][n]
        );
    }
}