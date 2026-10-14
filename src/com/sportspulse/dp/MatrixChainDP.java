package com.sportspulse.dp;

public class MatrixChainDP {

    /*
     * Finds the minimum number of scalar multiplications
     * required to multiply a chain of matrices.
     *
     * dimensions:
     * If dimensions = {10, 20, 30}
     *
     * Then:
     * A1 = 10 x 20
     * A2 = 20 x 30
     */

    public static int minimumMultiplications(int[] dimensions) {

        int n = dimensions.length - 1;

        if (n <= 0) {
            return 0;
        }

        int[][] dp = new int[n][n];

        // Chain length
        for (int length = 2; length <= n; length++) {

            for (int i = 0; i <= n - length; i++) {

                int j = i + length - 1;

                dp[i][j] = Integer.MAX_VALUE;

                // Try every possible split
                for (int k = i; k < j; k++) {

                    int cost =
                            dp[i][k]
                            + dp[k + 1][j]
                            + dimensions[i]
                            * dimensions[k + 1]
                            * dimensions[j + 1];

                    dp[i][j] =
                            Math.min(
                                    dp[i][j],
                                    cost
                            );
                }
            }
        }

        return dp[0][n - 1];
    }

    /*
     * Prints the DP table.
     */
    public static void printDPTable(int[] dimensions) {

        int n = dimensions.length - 1;

        if (n <= 0) {
            System.out.println(
                    "No matrices available."
            );
            return;
        }

        int[][] dp = new int[n][n];

        for (int length = 2; length <= n; length++) {

            for (int i = 0; i <= n - length; i++) {

                int j = i + length - 1;

                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int cost =
                            dp[i][k]
                            + dp[k + 1][j]
                            + dimensions[i]
                            * dimensions[k + 1]
                            * dimensions[j + 1];

                    dp[i][j] =
                            Math.min(
                                    dp[i][j],
                                    cost
                            );
                }
            }
        }

        System.out.println(
                "\n========== MATRIX CHAIN DP TABLE =========="
        );

        System.out.print("      ");

        for (int j = 0; j < n; j++) {
            System.out.printf("%8s", "M" + (j + 1));
        }

        System.out.println();

        for (int i = 0; i < n; i++) {

            System.out.printf(
                    "M%d    ",
                    i + 1
            );

            for (int j = 0; j < n; j++) {

                if (j < i) {

                    System.out.printf(
                            "%8s",
                            "-"
                    );

                } else {

                    System.out.printf(
                            "%8d",
                            dp[i][j]
                    );
                }
            }

            System.out.println();
        }
    }
}