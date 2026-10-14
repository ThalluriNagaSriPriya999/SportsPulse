package com.sportspulse.model;

public class Player {

    private int playerId;
    private String name;
    private String team;
    private String position;
    private int age;
    private double performanceScore;

    public Player(int playerId, String name, String team,
                  String position, int age, double performanceScore) {

        this.playerId = playerId;
        this.name = name;
        this.team = team;
        this.position = position;
        this.age = age;
        this.performanceScore = performanceScore;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {
        this.performanceScore = performanceScore;
    }

    @Override
    public String toString() {

        return String.format(
            "ID: %d | %-18s | Team: %-12s | Position: %-12s | Age: %d | Score: %.2f",
            playerId,
            name,
            team,
            position,
            age,
            performanceScore
        );
    }
}