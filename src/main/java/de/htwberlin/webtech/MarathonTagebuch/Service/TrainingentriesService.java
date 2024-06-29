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

    public List<TrainingentriesEntity> getAll() {
        return (List<TrainingentriesEntity>) repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public TrainingentriesEntity update(Long id, TrainingentriesEntity newEntry) {
        return repo.findById(id)
                .map(entry -> {
                    entry.setDate(newEntry.getDate());
                    entry.setTargetTime(newEntry.getTargetTime());
                    entry.setTargetKilometre(newEntry.getTargetKilometre());
                    entry.setKilometreRan(newEntry.getKilometreRan());
                    entry.setTimeRan(newEntry.getTimeRan());
                    entry.setGoalReached(newEntry.isGoalReached());
                    return repo.save(entry);
                })
                .orElseGet(() -> {
                    newEntry.setId(id);
                    return repo.save(newEntry);
                });
    }
}