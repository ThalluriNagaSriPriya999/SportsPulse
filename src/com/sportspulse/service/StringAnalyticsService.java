package com.sportspulse.service;

import java.util.List;
import java.util.Scanner;

import com.sportspulse.model.Player;

public class StringAnalyticsService {

    private SearchService searchService;
    private Scanner scanner;

    public StringAnalyticsService() {

        searchService = new SearchService();
        scanner = new Scanner(System.in);
    }

    public void showMenu() {

        while (true) {

            System.out.println();
            System.out.println("==============================================");
            System.out.println("        STRING & SEARCH ANALYTICS");
            System.out.println("==============================================");

            System.out.println("1. Search Player using KMP");
            System.out.println("2. Search Team using KMP");
            System.out.println("3. Search Match Commentary using KMP");
            System.out.println("4. Detect Multiple Events using Aho-Corasick");
            System.out.println("5. Player Prefix Search using Trie");
            System.out.println("6. Pattern Analysis using Z-Algorithm");
            System.out.println("7. Identifier Search using Rabin-Karp");
            System.out.println("0. Back");

            System.out.print("\nEnter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    searchPlayer();
                    break;

                case 2:
                    searchTeam();
                    break;

                case 3:
                    searchCommentary();
                    break;

                case 4:
                    detectEvents();
                    break;

                case 5:
                    prefixSearch();
                    break;

                case 6:
                    zSearch();
                    break;

                case 7:
                    rabinKarpSearch();
                    break;

                case 0:
                    return;

                default:
                    System.out.println(
                            "Invalid choice.");
            }
        }
    }

    private void searchPlayer() {

        System.out.print(
                "\nEnter player name/pattern: ");

        String query = scanner.nextLine();

        List<Player> results =
                searchService.searchPlayers(query);

        System.out.println(
                "\n========== KMP PLAYER SEARCH ==========");

        if (results.isEmpty()) {

            System.out.println(
                    "No player found.");

        } else {

            for (Player player : results) {
                System.out.println(player);
            }
        }
    }

    private void searchTeam() {

        System.out.print(
                "\nEnter team name/pattern: ");

        String query = scanner.nextLine();

        List<Player> results =
                searchService.searchByTeam(query);

        System.out.println(
                "\n========== KMP TEAM SEARCH ==========");

        if (results.isEmpty()) {

            System.out.println(
                    "No players found for this team.");

        } else {

            for (Player player : results) {
                System.out.println(player);
            }
        }
    }

    private void searchCommentary() {

        System.out.print(
                "\nEnter commentary pattern: ");

        String query = scanner.nextLine();

        searchService.searchCommentary(query);
    }

    private void detectEvents() {

        System.out.print(
                "\nEnter match commentary: ");

        String commentary = scanner.nextLine();

        searchService.detectEvents(commentary);
    }

    private void prefixSearch() {

        System.out.print(
                "\nEnter player name prefix: ");

        String prefix = scanner.nextLine();

        List<String> results =
                searchService.searchPlayerPrefix(prefix);

        System.out.println(
                "\n========== TRIE PREFIX SEARCH ==========");

        if (results.isEmpty()) {

            System.out.println(
                    "No matching players.");

        } else {

            for (String player : results) {
                System.out.println(player);
            }
        }
    }

    private void zSearch() {

        System.out.print(
                "\nEnter text: ");

        String text = scanner.nextLine();

        System.out.print(
                "Enter pattern: ");

        String pattern = scanner.nextLine();

        searchService.analyzePattern(
                text, pattern);
    }

    private void rabinKarpSearch() {

        System.out.print(
                "\nEnter identifier/text: ");

        String text = scanner.nextLine();

        System.out.print(
                "Enter search pattern: ");

        String pattern = scanner.nextLine();

        searchService.searchIdentifier(
                text, pattern);
    }
}