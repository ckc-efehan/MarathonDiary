package de.htwberlin.webtech.MarathonTagebuch;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.htwberlin.webtech.MarathonTagebuch.Controller.AuthController;
import de.htwberlin.webtech.MarathonTagebuch.Entities.UserEntity;
import de.htwberlin.webtech.MarathonTagebuch.Interface.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private AuthController authController;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testRegisterUser() throws Exception {
        UserEntity user = new UserEntity();
        user.setUsername("testuser");
        user.setPassword("testpassword");

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
        mockMvc.perform(post("/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isOk());

        verify(userRepository).save(any(UserEntity.class));
    }
}
