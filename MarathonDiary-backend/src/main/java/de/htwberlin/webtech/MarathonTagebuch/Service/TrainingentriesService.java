package de.htwberlin.webtech.MarathonTagebuch.Service;

import de.htwberlin.webtech.MarathonTagebuch.Entities.TrainingentriesEntity;
import de.htwberlin.webtech.MarathonTagebuch.Interface.TrainingentriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingentriesService {

    @Autowired
    TrainingentriesRepository repo;

    public TrainingentriesEntity save(TrainingentriesEntity trainingentries){
        return repo.save(trainingentries);
    }

    public TrainingentriesEntity get(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<TrainingentriesEntity> getAll() {
        return (List<TrainingentriesEntity>) repo.findAll();
    }
}
