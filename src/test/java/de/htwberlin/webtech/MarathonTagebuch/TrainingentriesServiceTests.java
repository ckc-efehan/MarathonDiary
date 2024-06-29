package de.htwberlin.webtech.MarathonTagebuch;

import de.htwberlin.webtech.MarathonTagebuch.Entities.TrainingentriesEntity;
import de.htwberlin.webtech.MarathonTagebuch.Interface.TrainingentriesRepository;
import de.htwberlin.webtech.MarathonTagebuch.Service.TrainingentriesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class TrainingentriesServiceTests {

    @Mock
    private TrainingentriesRepository repo;

    @InjectMocks
    private TrainingentriesService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        TrainingentriesEntity entry = new TrainingentriesEntity(LocalDate.now(), 2.0, 5.0, 4.0, 1.5, true);
        when(repo.save(any(TrainingentriesEntity.class))).thenReturn(entry);

        TrainingentriesEntity savedEntry = service.save(entry);

        assertEquals(entry, savedEntry);
        verify(repo, times(1)).save(entry);
    }

    @Test
    void testGetAll() {
        TrainingentriesEntity entry1 = new TrainingentriesEntity(LocalDate.now(), 2.0, 5.0, 4.0, 1.5, true);
        TrainingentriesEntity entry2 = new TrainingentriesEntity(LocalDate.now(), 3.0, 6.0, 5.0, 2.0, false);
        List<TrainingentriesEntity> entries = Arrays.asList(entry1, entry2);

        when(repo.findAll()).thenReturn(entries);

        List<TrainingentriesEntity> result = service.getAll();

        assertEquals(2, result.size());
        assertTrue(result.contains(entry1));
        assertTrue(result.contains(entry2));
        verify(repo, times(1)).findAll();
    }

    @Test
    void testDelete() {
        doNothing().when(repo).deleteById(anyLong());

        service.delete(1L);

        verify(repo, times(1)).deleteById(1L);
    }

    @Test
    void testUpdate() {
        TrainingentriesEntity existingEntry = new TrainingentriesEntity(LocalDate.now(), 2.0, 5.0, 4.0, 1.5, true);
        existingEntry.setId(1L);

        TrainingentriesEntity updatedEntry = new TrainingentriesEntity(LocalDate.now().plusDays(1), 3.0, 6.0, 5.0, 2.0, false);
        updatedEntry.setId(1L);

        when(repo.findById(1L)).thenReturn(Optional.of(existingEntry));
        when(repo.save(any(TrainingentriesEntity.class))).thenReturn(updatedEntry);

        TrainingentriesEntity result = service.update(1L, updatedEntry);

        assertEquals(updatedEntry.getDate(), result.getDate());
        assertEquals(updatedEntry.getTargetTime(), result.getTargetTime());
        assertEquals(updatedEntry.getTargetKilometre(), result.getTargetKilometre());
        assertEquals(updatedEntry.getKilometreRan(), result.getKilometreRan());
        assertEquals(updatedEntry.getTimeRan(), result.getTimeRan());
        assertEquals(updatedEntry.isGoalReached(), result.isGoalReached());

        verify(repo, times(1)).findById(1L);
        verify(repo, times(1)).save(any(TrainingentriesEntity.class));
    }
}
