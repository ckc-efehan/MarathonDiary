package de.htwberlin.webtech.MarathonTagebuch.Controller;

import de.htwberlin.webtech.MarathonTagebuch.Entities.TrainingentriesEntity;
import de.htwberlin.webtech.MarathonTagebuch.Service.TrainingentriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173", "https://marathondiary-frontend.onrender.com/"})
public class TrainingentriesController {

    @Autowired
    TrainingentriesService service;

    @PostMapping("/entries")
    public TrainingentriesEntity createEntry(@RequestBody TrainingentriesEntity entry){
        return service.save(entry);
    }

    @GetMapping("/entries/{id}")
    public TrainingentriesEntity getEntry(@PathVariable String id){
        Long entryID = Long.parseLong(id);
        return service.get(entryID);
    }
}