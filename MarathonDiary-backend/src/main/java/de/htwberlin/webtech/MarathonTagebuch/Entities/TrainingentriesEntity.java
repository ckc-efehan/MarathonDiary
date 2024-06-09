package de.htwberlin.webtech.MarathonTagebuch.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class TrainingentriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double targetTime;
    private double targetKilometre;
    private double kilometreRan;
    private double timeRan;
    private boolean goalReached;

    //Leerer Konstruktor für Hibernate
    public TrainingentriesEntity() {
    }

    public TrainingentriesEntity(LocalDate date, double targetTime, double targetKilometre, double kilometreRan, double timeRan, boolean goalReached) {
        this.date = date;
        this.targetTime = targetTime;
        this.targetKilometre = targetKilometre;
        this.kilometreRan = kilometreRan;
        this.timeRan = timeRan;
        this.goalReached = goalReached;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isGoalReached() {
        return goalReached;
    }

    public void setGoalReached(boolean goalReached) {
        this.goalReached = goalReached;
    }

    public double getTimeRan() {
        return timeRan;
    }

    public void setTimeRan(double timeRan) {
        this.timeRan = timeRan;
    }

    public double getKilometreRan() {
        return kilometreRan;
    }

    public void setKilometreRan(double kilometreRan) {
        this.kilometreRan = kilometreRan;
    }

    public double getTargetKilometre() {
        return targetKilometre;
    }

    public void setTargetKilometre(double targetKilometre) {
        this.targetKilometre = targetKilometre;
    }

    public double getTargetTime() {
        return targetTime;
    }

    public void setTargetTime(double targetTime) {
        this.targetTime = targetTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
