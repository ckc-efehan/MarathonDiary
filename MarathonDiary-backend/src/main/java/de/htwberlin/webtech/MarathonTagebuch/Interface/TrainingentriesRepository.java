package de.htwberlin.webtech.MarathonTagebuch.Interface;

import de.htwberlin.webtech.MarathonTagebuch.Entities.TrainingentriesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingentriesRepository extends CrudRepository<TrainingentriesEntity, Long> {
}
