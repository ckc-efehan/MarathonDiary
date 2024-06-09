// UserEntity.java
package de.htwberlin.webtech.MarathonTagebuch.Entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<TrainingentriesEntity> trainingEntries;

    // Getter und Setter

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

    public Set<TrainingentriesEntity> getTrainingEntries() {
        return trainingEntries;
    }

    public void setTrainingEntries(Set<TrainingentriesEntity> trainingEntries) {
        this.trainingEntries = trainingEntries;
    }
}
