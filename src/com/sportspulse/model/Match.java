package com.sportspulse.model;

public class Match {

    private int matchId;
    private String teamA;
    private String teamB;
    private String date;
    private String venue;
    private String result;
    private String commentary;

    public Match(int matchId, String teamA, String teamB,
                 String date, String venue,
                 String result, String commentary) {

        this.matchId = matchId;
        this.teamA = teamA;
        this.teamB = teamB;
        this.date = date;
        this.venue = venue;
        this.result = result;
        this.commentary = commentary;
    }

    public int getMatchId() {
        return matchId;
    }

    public String getTeamA() {
        return teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public String getResult() {
        return result;
    }

    public String getCommentary() {
        return commentary;
    }

    @Override
    public String toString() {

        return "\nMatch ID: " + matchId +
               "\n" + teamA + " vs " + teamB +
               "\nDate: " + date +
               "\nVenue: " + venue +
               "\nResult: " + result;
    }
}