// TrainingentriesRepository.java
package de.htwberlin.webtech.MarathonTagebuch.Interface;

import de.htwberlin.webtech.MarathonTagebuch.Entities.TrainingentriesEntity;
import de.htwberlin.webtech.MarathonTagebuch.Entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingentriesRepository extends CrudRepository<TrainingentriesEntity, Long> {
    List<TrainingentriesEntity> findByUser(UserEntity user);
}
