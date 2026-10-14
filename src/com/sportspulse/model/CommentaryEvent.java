package com.sportspulse.model;

public class CommentaryEvent {

    private int eventId;
    private int matchId;
    private int minute;
    private String eventType;
    private String playerName;
    private String description;

    public CommentaryEvent(int eventId, int matchId,
                           int minute, String eventType,
                           String playerName, String description) {

        this.eventId = eventId;
        this.matchId = matchId;
        this.minute = minute;
        this.eventType = eventType;
        this.playerName = playerName;
        this.description = description;
    }

    public int getEventId() {
        return eventId;
    }

    public int getMatchId() {
        return matchId;
    }

    public int getMinute() {
        return minute;
    }

    public String getEventType() {
        return eventType;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {

        return minute + "' | " +
               eventType + " | " +
               playerName + " | " +
               description;
    }
}