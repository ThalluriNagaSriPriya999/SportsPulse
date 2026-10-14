package com.sportspulse.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private int teamId;
    private String teamName;
    private String country;
    private List<Player> players;

    public Team(int teamId, String teamName, String country) {

        this.teamId = teamId;
        this.teamName = teamName;
        this.country = country;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getCountry() {
        return country;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public String toString() {

        return String.format(
            "Team ID: %d | %-15s | Country: %-15s | Players: %d",
            teamId,
            teamName,
            country,
            players.size()
        );
    }
}