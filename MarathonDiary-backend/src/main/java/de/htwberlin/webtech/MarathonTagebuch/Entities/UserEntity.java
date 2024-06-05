package de.htwberlin.webtech.MarathonTagebuch.Entities;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.util.List;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String username;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TrainingentriesEntity> trainingEntries;

    public UserEntity(){
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TrainingentriesEntity> getTrainingEntries() {
        return trainingEntries;
    }

    public void setTrainingEntries(List<TrainingentriesEntity> trainingEntries) {
        this.trainingEntries = trainingEntries;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
