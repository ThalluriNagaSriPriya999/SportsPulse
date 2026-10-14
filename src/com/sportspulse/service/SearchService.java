package com.sportspulse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sportspulse.data.SampleData;
import com.sportspulse.model.Match;
import com.sportspulse.model.Player;
import com.sportspulse.string.AhoCorasick;
import com.sportspulse.string.KMP;
import com.sportspulse.string.RabinKarp;
import com.sportspulse.string.Trie;
import com.sportspulse.string.ZAlgorithm;

public class SearchService {

    private List<Player> players;
    private List<Match> matches;

    private Trie playerTrie;

    public SearchService() {

        players = SampleData.getPlayers();
        matches = SampleData.getMatches();

        playerTrie = new Trie();

        for (Player player : players) {
            playerTrie.insert(player.getName());
        }
    }

    // -----------------------------------------
    // KMP PLAYER SEARCH
    // -----------------------------------------

    public List<Player> searchPlayers(String query) {

        List<Player> results = new ArrayList<>();

        for (Player player : players) {

            List<Integer> positions =
                    KMP.search(player.getName(), query);

            if (!positions.isEmpty()) {
                results.add(player);
            }
        }

        return results;
    }

    // -----------------------------------------
    // KMP TEAM SEARCH
    // -----------------------------------------

    public List<Player> searchByTeam(String query) {

        List<Player> results = new ArrayList<>();

        for (Player player : players) {

            List<Integer> positions =
                    KMP.search(player.getTeam(), query);

            if (!positions.isEmpty()) {
                results.add(player);
            }
        }

        return results;
    }

    // -----------------------------------------
    // KMP COMMENTARY SEARCH
    // -----------------------------------------

    public void searchCommentary(String query) {

        System.out.println("\n========== COMMENTARY SEARCH ==========");

        boolean found = false;

        for (Match match : matches) {

            List<Integer> positions =
                    KMP.search(match.getCommentary(), query);

            if (!positions.isEmpty()) {

                found = true;

                System.out.println("\nMatch ID: "
                        + match.getMatchId());

                System.out.println(
                        "Teams: "
                        + match.getTeamA()
                        + " vs "
                        + match.getTeamB());

                System.out.println(
                        "Pattern found at positions: "
                        + positions);
            }
        }

        if (!found) {
            System.out.println("Pattern not found.");
        }
    }

    // -----------------------------------------
    // TRIE PREFIX SEARCH
    // -----------------------------------------

    public List<String> searchPlayerPrefix(String prefix) {

        return playerTrie.startsWith(prefix);
    }

    // -----------------------------------------
    // Z ALGORITHM
    // -----------------------------------------

    public void analyzePattern(String text, String pattern) {

        List<Integer> positions =
                ZAlgorithm.search(text, pattern);

        System.out.println("\n========== Z-ALGORITHM ==========");
        System.out.println("Pattern: " + pattern);
        System.out.println("Occurrences: " + positions);
    }

    // -----------------------------------------
    // RABIN-KARP
    // -----------------------------------------

    public void searchIdentifier(String text, String pattern) {

        List<Integer> positions =
                RabinKarp.search(text, pattern);

        System.out.println("\n========== RABIN-KARP ==========");
        System.out.println("Pattern: " + pattern);
        System.out.println("Occurrences: " + positions);
    }

    // -----------------------------------------
    // AHO-CORASICK
    // -----------------------------------------

    public void detectEvents(String commentary) {

        AhoCorasick aho = new AhoCorasick();

        aho.addPattern("goal");
        aho.addPattern("foul");
        aho.addPattern("assist");
        aho.addPattern("save");
        aho.addPattern("penalty");

        aho.buildFailureLinks();

        Map<String, List<Integer>> results =
                aho.search(commentary);

        System.out.println("\n========== EVENT DETECTION ==========");

        if (results.isEmpty()) {

            System.out.println(
                    "No known sports events detected.");

            return;
        }

        for (Map.Entry<String, List<Integer>> entry :
                results.entrySet()) {

            System.out.println(
                    entry.getKey()
                    + " -> "
                    + entry.getValue());
        }
    }
}