import org.junit.Test;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Storage.GenreStorage;
import org.wcci.blog.Storage.MapGenreStorage;

import java.util.Collection;

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
        Genre testGenre2 = new String (String) test = "Test";
        GenreStorage underTest = new MapGenreStorage();
        underTest.store(testGenre1);
        underTest.store(testGenre2);
        Genre retrievedGenre1 = underTest.findGenreByname("Test");
        Genre retrievedGenre2 = underTest.findGenreByname("Test");
        assertThat(retrievedGenre1).isEqualTo(testGenre1);
        assertThat(retrievedGenre2).isEqualTo(testGenre2);
    }
}
}
