package com.example.player.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private String player;
    private int age;
    private double height;
    private double weight;
    private String nationality;
    private int index;
    private int minutesPlayed;
    private String position;

    // Performance metrics
    private int goalMistakes;
    private int mistakes;
    private int goals;
    private int assists;
    private int chances;
    private int chancesSuccessful;
    private double chancesSuccessfulPercentage;
    private int chancesCreated;
    private int shots;
    private int shotsOnTarget;

    // Discipline metrics
    private int yellowCards;
    private int redCards;
    private int fouls;
    private int foulsSuffered;

    // Passing metrics
    private int passes;
    private double passesAccuratePercentage;
    private int keyPasses;
    private double keyPassesAccuratePercentage;
    private int crosses;
    private double crossesAccuratePercentage;
    private int progressivePasses;
    private double progressivePassesAccuratePercentage;
    private int longPasses;
    private double longPassesAccuratePercentage;
    private int superLongPasses;
    private double superLongPassesAccuratePercentage;
    private double passesForwardToFinalThird;
    private double passesForwardToFinalThirdAccuratePercentage;
    private int passesIntoPenaltyBox;
    private double passesIntoPenaltyBoxAccuratePercentage;

    // Challenges metrics
    private int challenges;
    private double challengesAccuratePercentage;
    private int defensiveChallenges;
    private double defensiveChallengesAccuratePercentage;
    private int attackingChallenges;
    private double attackingChallengesWonPercentage;
    private int airChallenges;
    private double airChallengesWonPercentage;

    // Dribbling metrics
    private int dribbles;
    private double dribblesSuccessfulPercentage;
    private int dribblingInFinalThird;
    private double dribblingInFinalThirdSuccessfulPercentage;

    // Tackles and interceptions metrics
    private int tackles;
    private double tacklesSuccessfulPercentage;
    private int interceptions;
    private int pickingUp;
    private double xG;
}
