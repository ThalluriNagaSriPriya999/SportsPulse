package com.sportspulse.model;

public class PerformanceRecord {

    private int playerId;
    private int matchId;
    private int points;
    private int goals;
    private int assists;
    private int successfulPasses;
    private int tackles;

    public PerformanceRecord(int playerId, int matchId,
                             int points, int goals,
                             int assists, int successfulPasses,
                             int tackles) {

        this.playerId = playerId;
        this.matchId = matchId;
        this.points = points;
        this.goals = goals;
        this.assists = assists;
        this.successfulPasses = successfulPasses;
        this.tackles = tackles;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getMatchId() {
        return matchId;
    }

    public int getPoints() {
        return points;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getSuccessfulPasses() {
        return successfulPasses;
    }

    public int getTackles() {
        return tackles;
    }

    @Override
    public String toString() {

        return "Player ID: " + playerId +
               " | Match ID: " + matchId +
               " | Points: " + points +
               " | Goals: " + goals +
               " | Assists: " + assists +
               " | Passes: " + successfulPasses +
               " | Tackles: " + tackles;
    }
}