// UserRepository.java
package de.htwberlin.webtech.MarathonTagebuch.Interface;

import de.htwberlin.webtech.MarathonTagebuch.Entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
