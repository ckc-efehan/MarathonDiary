// AuthController.java
package de.htwberlin.webtech.MarathonTagebuch.Controller;

import de.htwberlin.webtech.MarathonTagebuch.Entities.UserEntity;
import de.htwberlin.webtech.MarathonTagebuch.Interface.UserRepository;
import de.htwberlin.webtech.MarathonTagebuch.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService userDetailsService;


    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user) {
        return userDetailsService.save(user);
    }
}
