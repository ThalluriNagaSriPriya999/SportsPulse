package com.sportspulse.dp;

public class Levenshtein {

    public static int distance(String a, String b) {

        int m = a.length();
        int n = b.length();

        int[][] dp = new int[m + 1][n + 1];

        // Empty string conversions
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (a.charAt(i - 1) == b.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(
                            insert,
                            Math.min(delete, replace)
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

                if (a.charAt(i - 1) == b.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    dp[i][j] = 1 + Math.min(
                            dp[i][j - 1],
                            Math.min(
                                    dp[i - 1][j],
                                    dp[i - 1][j - 1]
                            )
                    );
                }
            }
        }

        System.out.println("\n========== LEVENSHTEIN DP TABLE ==========");

        System.out.print("    ");

        for (int j = 0; j < n; j++) {
            System.out.print("  " + b.charAt(j));
        }

        System.out.println();

        for (int i = 0; i <= m; i++) {

            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(a.charAt(i - 1) + " ");
            }

            for (int j = 0; j <= n; j++) {
                System.out.printf("%3d", dp[i][j]);
            }

            System.out.println();
        }

        System.out.println("\nMinimum Edit Distance = " + dp[m][n]);
    }
}