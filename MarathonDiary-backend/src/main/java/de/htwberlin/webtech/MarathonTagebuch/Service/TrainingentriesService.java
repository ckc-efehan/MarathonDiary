// TrainingentriesService.java
package de.htwberlin.webtech.MarathonTagebuch.Service;

import de.htwberlin.webtech.MarathonTagebuch.Entities.TrainingentriesEntity;
import de.htwberlin.webtech.MarathonTagebuch.Entities.UserEntity;
import de.htwberlin.webtech.MarathonTagebuch.Interface.TrainingentriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingentriesService {

    @Autowired
    private TrainingentriesRepository repo;

    public TrainingentriesEntity save(TrainingentriesEntity trainingentries) {
        return repo.save(trainingentries);
    }

    public List<TrainingentriesEntity> getAllByUser(UserEntity user) {
        return repo.findByUser(user);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
