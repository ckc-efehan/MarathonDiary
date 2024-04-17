package de.htwberlin.webtech.MarathonTagebuch;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {
    @GetMapping("/marathondiary")
    public List<MarathonDiary> Greeting () {
        MarathonDiary entry = new MarathonDiary(2.5,5.0, 3.0, 5.0, false);
        MarathonDiary entry1 = new MarathonDiary(2.0,6.0, 4.0, 3.0, false);
        MarathonDiary entry2 = new MarathonDiary(4.0,10.0, 10.0, 3.5, true);
        MarathonDiary entry3 = new MarathonDiary(5.0,12.0, 10.0, 5.0, false);
        MarathonDiary entry4 = new MarathonDiary(5.0,12.0, 10.5, 5.0, false);
        return List.of(entry, entry1, entry2, entry3, entry4);
    }
}
