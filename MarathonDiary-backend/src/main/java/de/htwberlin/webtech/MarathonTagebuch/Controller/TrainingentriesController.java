package de.htwberlin.webtech.MarathonTagebuch.Controller;

import de.htwberlin.webtech.MarathonTagebuch.Entities.TrainingentriesEntity;
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
    public TrainingentriesEntity createEntry(@RequestBody TrainingentriesEntity entry){
        return service.save(entry);
    }

    @GetMapping("/{id}")
    public TrainingentriesEntity getEntry(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping
    public List<TrainingentriesEntity> getAllEntries() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        service.delete(id);
    }
}
