package de.htwberlin.webtech.MarathonTagebuch;

public class MarathonDiary {
    private double targetTime;
    private double targetKilometre;
    private double kilometreRan;
    private double timeRan;
    private boolean goalReached;

    public MarathonDiary(double targetTime, double targetKilometre, double kilometreRan, double timeRan, boolean goalReached) {
        this.targetTime = targetTime;
        this.targetKilometre = targetKilometre;
        this.kilometreRan = kilometreRan;
        this.timeRan = timeRan;
        this.goalReached = goalReached;
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
