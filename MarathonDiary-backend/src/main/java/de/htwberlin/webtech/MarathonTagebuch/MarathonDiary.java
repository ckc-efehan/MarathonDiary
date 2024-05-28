package de.htwberlin.webtech.MarathonTagebuch;

import java.time.LocalDate;
import java.util.Date;


public class MarathonDiary {
    private LocalDate date;
    private double targetTime;
    private double targetKilometre;
    private double kilometreRan;
    private double timeRan;
    private boolean goalReached;

    public MarathonDiary(LocalDate date, double targetTime, double targetKilometre, double kilometreRan, double timeRan, boolean goalReached) {
        this.date = date;
        this.targetTime = targetTime;
        this.targetKilometre = targetKilometre;
        this.kilometreRan = kilometreRan;
        this.timeRan = timeRan;
        this.goalReached = goalReached;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getTargetTime() {
        return targetTime;
    }

    public double getTargetKilometre() {
        return targetKilometre;
    }

    public double getKilometreRan() {
        return kilometreRan;
    }

    public double getTimeRan() {
        return timeRan;
    }
    public boolean isGoalReached() {
        return goalReached;
    }
}
