package de.htwberlin.webtech.MarathonTagebuch.Controller;

import de.htwberlin.webtech.MarathonTagebuch.Entities.TrainingentriesEntity;
import de.htwberlin.webtech.MarathonTagebuch.Entities.UserEntity;
import de.htwberlin.webtech.MarathonTagebuch.Service.TrainingentriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173", "https://marathondiary-frontend.onrender.com/"})
@RequestMapping("/entries")
public class TrainingentriesController {

    @Autowired
    TrainingentriesService service;

    @PostMapping
    public TrainingentriesEntity createEntry(@RequestBody TrainingentriesEntity entry, @RequestParam Long userId){
        UserEntity user = new UserEntity(); // Hole den Benutzer aus der Datenbank oder dem Kontext
        user.setId(userId);
        entry.setUser(user);
        return service.save(entry);
    }

    @GetMapping
    public List<TrainingentriesEntity> getAllEntries(@RequestParam Long userId) {
        UserEntity user = new UserEntity(); // Hole den Benutzer aus der Datenbank oder dem Kontext
        user.setId(userId);
        return service.getAllByUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        service.delete(id);
    }
}
