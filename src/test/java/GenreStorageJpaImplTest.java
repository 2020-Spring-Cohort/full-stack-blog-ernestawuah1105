import javafx.beans.binding.BooleanExpression;
import org.junit.Test;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Repositories.GenreRepository;
import org.wcci.blog.Storage.GenreStorage;
import org.wcci.blog.Storage.GenreStorageJpaImpl;

import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class GenreStorageJpaImplTest {
    private Object Genre1;
    private GenreRepository mockGenreRepo;

    @Test
    public void shouldFindAllGenres() {
        mockGenreRepo = mock(GenreRepository.class);
        Genre testGenre = new Genre("Test");
        GenreStorage underTest = new GenreStorageJpaImpl(mockGenreRepo);
        when(mockGenreRepo.findAll()).thenReturn(Collections.singletonList(testGenre));
        underTest.store(testGenre);
        verify(mockGenreRepo).save(testGenre);
        assertTrue(mockGenreRepo.findAll().contains(testGenre));
    }

    @Test
    public void shouldRetrieveSingleGenreByLocation() {
        GenreRepository mockGenreRepo = mock(GenreRepository.class);
        Genre testCampus1 = new Genre("Test");
        Genre testGenre2 = new Genre("Test");
        GenreStorage underTest = new GenreStorageJpaImpl(mockGenreRepo);
        Genre testGenre1 = new Genre();
        underTest.store(testGenre1);
        underTest.store(testGenre2);
        Optional<Genre> us1Optional = Optional.of(testCampus1);
        Object testGenre1Optional = new Object();
        when(mockGenreRepo.findByname("Test")).thenReturn(testGenre1Optional);

        Optional<Genre> testGenre2Optional = Optional.of(testGenre2);
        when(mockGenreRepo.findByname("Test")).thenReturn(testGenre2Optional);

        Genre retrievedCampus1 = underTest.findGenreByName("Test");
        Genre retrievedGenre2 = underTest.findGenreByName("Test");
        assertTrue(retrievedCampus1.equals(testGenre1));
        assertTrue(retrievedGenre2.equals(testGenre2));
    }

}


