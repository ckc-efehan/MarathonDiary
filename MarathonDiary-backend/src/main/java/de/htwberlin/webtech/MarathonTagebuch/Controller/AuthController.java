// AuthController.java
package de.htwberlin.webtech.MarathonTagebuch.Controller;

import de.htwberlin.webtech.MarathonTagebuch.Entities.UserEntity;
import de.htwberlin.webtech.MarathonTagebuch.Interface.UserRepository;
import de.htwberlin.webtech.MarathonTagebuch.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173", "https://marathondiary-frontend.onrender.com/"})
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CustomUserDetailsService userDetailsService;


    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user) {
        return userDetailsService.save(user);
    }
}
