package de.htwberlin.webtech.MarathonTagebuch;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/entries")
@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173", "https://marathondiary.onrender.com"})
public class MyController {
    @GetMapping
    public List<MarathonDiary> Greeting () {
        MarathonDiary entry = new MarathonDiary(LocalDate.of(2024,05,17), 2.5, 5.0, 3.0, 5.0, false);
        MarathonDiary entry1 = new MarathonDiary(LocalDate.of(2024,05,15),2.0,6.0, 4.0, 3.0, false);
        MarathonDiary entry2 = new MarathonDiary(LocalDate.of(2024,05,13),4.0,10.0, 10.0, 3.5, true);
        MarathonDiary entry3 = new MarathonDiary(LocalDate.of(2024,05,11),3.0,12.0, 10.0, 5.0, false);
        MarathonDiary entry4 = new MarathonDiary(LocalDate.of(2024,05,9),5.0,12.0, 10.5, 5.0, false);
        return List.of(entry, entry1, entry2, entry3, entry4);
    }
}