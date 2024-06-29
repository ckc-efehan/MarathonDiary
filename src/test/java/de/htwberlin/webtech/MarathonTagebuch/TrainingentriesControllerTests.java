package de.htwberlin.webtech.MarathonTagebuch;

import de.htwberlin.webtech.MarathonTagebuch.Controller.TrainingentriesController;
import de.htwberlin.webtech.MarathonTagebuch.Entities.TrainingentriesEntity;
import de.htwberlin.webtech.MarathonTagebuch.Service.TrainingentriesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class TrainingentriesControllerTests {



    private MockMvc mockMvc;

    @Mock
    private TrainingentriesService service;

    @InjectMocks
    private TrainingentriesController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void testCreateEntry() throws Exception {
        TrainingentriesEntity entry = new TrainingentriesEntity(LocalDate.now(), 2.0, 5.0, 4.0, 1.5, true);
        when(service.save(any(TrainingentriesEntity.class))).thenReturn(entry);

        mockMvc.perform(post("/entries")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"date\":\"2024-06-05\",\"targetTime\":2.0,\"targetKilometre\":5.0,\"kilometreRan\":4.0,\"timeRan\":1.5,\"goalReached\":true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.targetTime").value(2.0))
                .andExpect(jsonPath("$.targetKilometre").value(5.0));

        verify(service, times(1)).save(any(TrainingentriesEntity.class));
    }

    @Test
    void testGetAllEntries() throws Exception {
        TrainingentriesEntity entry1 = new TrainingentriesEntity(LocalDate.now(), 2.0, 5.0, 4.0, 1.5, true);
        TrainingentriesEntity entry2 = new TrainingentriesEntity(LocalDate.now(), 3.0, 6.0, 5.0, 2.0, false);
        List<TrainingentriesEntity> entries = Arrays.asList(entry1, entry2);

        when(service.getAll()).thenReturn(entries);

        mockMvc.perform(get("/entries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].targetTime").value(2.0))
                .andExpect(jsonPath("$[1].targetTime").value(3.0));

        verify(service, times(1)).getAll();
    }

    @Test
    void testDeleteEntry() throws Exception {
        doNothing().when(service).delete(anyLong());

        mockMvc.perform(delete("/entries/{id}", 1L))
                .andExpect(status().isOk());

        verify(service, times(1)).delete(1L);
    }
}
