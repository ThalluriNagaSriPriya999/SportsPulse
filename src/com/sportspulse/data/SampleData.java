package com.sportspulse.data;

import java.util.ArrayList;
import java.util.List;

import com.sportspulse.model.CommentaryEvent;
import com.sportspulse.model.Match;
import com.sportspulse.model.PerformanceRecord;
import com.sportspulse.model.Player;
import com.sportspulse.model.Team;

public class SampleData {

    public static List<Player> getPlayers() {

        List<Player> players = new ArrayList<>();

        players.add(new Player(
                101, "Arjun Sharma", "Thunder FC",
                "Forward", 22, 91.5));

        players.add(new Player(
                102, "Rahul Verma", "Thunder FC",
                "Midfielder", 24, 87.2));

        players.add(new Player(
                103, "Vikram Reddy", "Thunder FC",
                "Defender", 25, 82.8));

        players.add(new Player(
                104, "Aditya Kumar", "Storm United",
                "Forward", 21, 89.7));

        players.add(new Player(
                105, "Rohan Singh", "Storm United",
                "Midfielder", 23, 85.4));

        players.add(new Player(
                106, "Kiran Patel", "Storm United",
                "Goalkeeper", 27, 88.1));

        players.add(new Player(
                107, "Sanjay Rao", "Warriors FC",
                "Defender", 26, 80.6));

        players.add(new Player(
                108, "Manoj Das", "Warriors FC",
                "Forward", 22, 86.9));

        return players;
    }

    public static List<Team> getTeams() {

        List<Player> players = getPlayers();

        List<Team> teams = new ArrayList<>();

        Team thunder = new Team(
                1, "Thunder FC", "India");

        Team storm = new Team(
                2, "Storm United", "India");

        Team warriors = new Team(
                3, "Warriors FC", "India");

        for (Player player : players) {

            if (player.getTeam().equals("Thunder FC")) {
                thunder.addPlayer(player);
            }

            if (player.getTeam().equals("Storm United")) {
                storm.addPlayer(player);
            }

            if (player.getTeam().equals("Warriors FC")) {
                warriors.addPlayer(player);
            }
        }

        teams.add(thunder);
        teams.add(storm);
        teams.add(warriors);

        return teams;
    }

    public static List<Match> getMatches() {

        List<Match> matches = new ArrayList<>();

        matches.add(new Match(
                1001,
                "Thunder FC",
                "Storm United",
                "2026-09-20",
                "National Stadium",
                "Thunder FC won 3-2",
                "Arjun Sharma scored a goal in the 15th minute. "
                + "Aditya Kumar responded with a goal. "
                + "Rahul Verma provided an assist. "
                + "Thunder FC scored the winning goal in the 78th minute."
        ));

        matches.add(new Match(
                1002,
                "Warriors FC",
                "Thunder FC",
                "2026-09-24",
                "City Arena",
                "Draw 1-1",
                "Manoj Das scored an early goal. "
                + "Arjun Sharma created a chance. "
                + "Thunder FC equalized in the second half."
        ));

        matches.add(new Match(
                1003,
                "Storm United",
                "Warriors FC",
                "2026-09-28",
                "Sports Complex",
                "Storm United won 2-0",
                "Aditya Kumar scored a goal. "
                + "Kiran Patel made an important save. "
                + "Storm United controlled possession."
        ));

        return matches;
    }

    public static List<PerformanceRecord> getPerformanceRecords() {

        List<PerformanceRecord> records = new ArrayList<>();

        records.add(new PerformanceRecord(
                101, 1001, 95, 2, 1, 42, 2));

        records.add(new PerformanceRecord(
                102, 1001, 88, 0, 2, 57, 3));

        records.add(new PerformanceRecord(
                103, 1001, 82, 0, 0, 49, 7));

        records.add(new PerformanceRecord(
                104, 1001, 90, 1, 0, 38, 1));

        records.add(new PerformanceRecord(
                105, 1001, 84, 0, 1, 51, 4));

        records.add(new PerformanceRecord(
                106, 1003, 89, 0, 0, 28, 0));

        records.add(new PerformanceRecord(
                108, 1002, 87, 1, 0, 31, 2));

        return records;
    }

    public static List<CommentaryEvent> getEvents() {

        List<CommentaryEvent> events = new ArrayList<>();

        events.add(new CommentaryEvent(
                1, 1001, 15,
                "GOAL",
                "Arjun Sharma",
                "Goal scored from inside the box"));

        events.add(new CommentaryEvent(
                2, 1001, 31,
                "FOUL",
                "Vikram Reddy",
                "Tactical foul near midfield"));

        events.add(new CommentaryEvent(
                3, 1001, 45,
                "ASSIST",
                "Rahul Verma",
                "Excellent through pass"));

        events.add(new CommentaryEvent(
                4, 1001, 78,
                "GOAL",
                "Arjun Sharma",
                "Winning goal"));

        events.add(new CommentaryEvent(
                5, 1002, 12,
                "GOAL",
                "Manoj Das",
                "Opening goal"));

        events.add(new CommentaryEvent(
                6, 1003, 23,
                "SAVE",
                "Kiran Patel",
                "Excellent goalkeeper save"));

        return events;
    }
}