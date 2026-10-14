package com.sportspulse.dp;

import java.util.Arrays;

public class BitmaskDP {

    private static final int INF = 1_000_000_000;

    /*
     * Solves the Traveling Salesman Problem using Bitmask DP.
     *
     * dist[i][j] = cost of travelling from player/location i
     *              to player/location j
     *
     * Returns the minimum possible travel cost.
     */
    public static int tsp(int[][] dist) {

        int n = dist.length;

        if (n == 0) {
            return 0;
        }

        int totalMasks = 1 << n;

        int[][] dp = new int[totalMasks][n];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        // Start from vertex 0
        dp[1][0] = 0;

        // Process every subset
        for (int mask = 1; mask < totalMasks; mask++) {

            for (int current = 0; current < n; current++) {

                if ((mask & (1 << current)) == 0) {
                    continue;
                }

                if (dp[mask][current] == INF) {
                    continue;
                }

                // Try visiting another vertex
                for (int next = 0; next < n; next++) {

                    if ((mask & (1 << next)) != 0) {
                        continue;
                    }

                    int newMask =
                            mask | (1 << next);

                    int newCost =
                            dp[mask][current]
                            + dist[current][next];

                    dp[newMask][next] =
                            Math.min(
                                    dp[newMask][next],
                                    newCost
                            );
                }
            }
        }

        // All vertices visited
        int finalMask = totalMasks - 1;

        int answer = INF;

        // Return to starting vertex
        for (int current = 1; current < n; current++) {

            answer = Math.min(
                    answer,
                    dp[finalMask][current]
                    + dist[current][0]
            );
        }

        return answer;
    }

    /*
     * Prints the DP table.
     */
    public static void printDPTable(int[][] dist) {

        int n = dist.length;
        int totalMasks = 1 << n;

        int[][] dp = new int[totalMasks][n];

        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        dp[1][0] = 0;

        for (int mask = 1; mask < totalMasks; mask++) {

            for (int current = 0; current < n; current++) {

                if ((mask & (1 << current)) == 0) {
                    continue;
                }

                if (dp[mask][current] == INF) {
                    continue;
                }

                for (int next = 0; next < n; next++) {

                    if ((mask & (1 << next)) != 0) {
                        continue;
                    }

                    int newMask =
                            mask | (1 << next);

                    int newCost =
                            dp[mask][current]
                            + dist[current][next];

                    dp[newMask][next] =
                            Math.min(
                                    dp[newMask][next],
                                    newCost
                            );
                }
            }
        }

        System.out.println(
                "\n========== BITMASK DP TABLE =========="
        );

        for (int mask = 0; mask < totalMasks; mask++) {

            System.out.print(
                    "Mask " + String.format("%" + n + "s",
                    Integer.toBinaryString(mask))
                    .replace(' ', '0')
                    + " : "
            );

            for (int i = 0; i < n; i++) {

                if (dp[mask][i] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(
                            dp[mask][i] + " "
                    );
                }
            }

            System.out.println();
        }
    }
}