package de.htwberlin.webtech.MarathonTagebuch.Controller;

import de.htwberlin.webtech.MarathonTagebuch.Entities.TrainingentriesEntity;
import de.htwberlin.webtech.MarathonTagebuch.Service.TrainingentriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = { "https://marathondiary-frontend.onrender.com/", "http://localhost:5173"})
@RequestMapping("/entries")
public class TrainingentriesController {

    @Autowired
    TrainingentriesService service;

    @PostMapping
    public TrainingentriesEntity createEntry(@RequestBody TrainingentriesEntity entry){
        return service.save(entry);
    }

    @GetMapping
    public List<TrainingentriesEntity> getAllEntries() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public TrainingentriesEntity updateEntry(@PathVariable Long id, @RequestBody TrainingentriesEntity entry) {
        return service.update(id, entry);
    }
}