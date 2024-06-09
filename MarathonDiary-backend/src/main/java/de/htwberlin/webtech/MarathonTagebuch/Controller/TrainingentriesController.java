// TrainingentriesController.java
package de.htwberlin.webtech.MarathonTagebuch.Controller;

import de.htwberlin.webtech.MarathonTagebuch.Entities.TrainingentriesEntity;
import de.htwberlin.webtech.MarathonTagebuch.Entities.UserEntity;
import de.htwberlin.webtech.MarathonTagebuch.Service.CustomUserDetailsService;
import de.htwberlin.webtech.MarathonTagebuch.Service.TrainingentriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173", "https://marathondiary-frontend.onrender.com/"})
@RequestMapping("/entries")
public class TrainingentriesController {

    @Autowired
    private TrainingentriesService service;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @PostMapping
    public TrainingentriesEntity createEntry(@RequestBody TrainingentriesEntity entry) {
        UserEntity user = getCurrentUser();
        entry.setUser(user);
        return service.save(entry);
    }

    @GetMapping
    public List<TrainingentriesEntity> getAllEntries() {
        UserEntity user = getCurrentUser();
        return service.getAllByUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        service.delete(id);
    }

    private UserEntity getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        return customUserDetailsService.findByUsername(username);
    }
}
