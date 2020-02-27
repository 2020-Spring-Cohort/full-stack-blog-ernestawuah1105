import org.junit.Test;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Storage.GenreStorage;
import org.wcci.blog.Storage.MapGenreStorage;

import java.util.Collection;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class MapCampusStorageJpaImplTest {
    private Object String;
    private String test;

    @Test
    public void shouldStoreGenreInMap() {
        Genre testGenre = new Genre("Test Town");
        GenreStorage underTest = new MapGenreStorage();
        underTest.store(testGenre);
        assertThat(underTest.findAllGenres()).contains(testGenre);
    }

    private Collection<Object> assertThat(Collection<Genre> allGenres) {
        return null;
    }

    @Test
    public void shouldRetrieveSingleGenreByname() {
        Genre testGenre1 = new Genre("Test");
        Genre testGenre2 = new Genre("Test2");
        GenreStorage underTest = new MapGenreStorage();
        underTest.store(testGenre1);
        underTest.store(testGenre2);
        Genre retrievedGenre1 = underTest.findGenreByName("Test");
        Genre retrievedGenre2 = underTest.findGenreByName("Test2");
        assertTrue(retrievedGenre1.equals(testGenre1));
        assertTrue(retrievedGenre2.equals(testGenre2));
    }
}

