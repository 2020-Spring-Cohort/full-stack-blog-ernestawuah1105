package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Storage.GenreStorage;
import org.wcci.blog.Storage.MapGenreStorage;

import static org.assertj.core.api.Assertions.assertThat;

public class MapGenreStorageTest {

    @Test
    public void shouldStoreCampusInMap() {
        Genre testGenre = new Genre("Test");
        GenreStorage underTest = new MapGenreStorage();
        underTest.store(testGenre);
        assertThat(underTest.findAllGenre()).contains(testGenre);
    }

    @Test
    public void shouldRetrieveSingleCampusByLocation() {
        Genre testGenre1 = new Genre("Test");
        Genre testGenre2 = new Genre("Test");
        GenreStorage underTest = new MapGenreStorage();
        underTest.store(testGenre1);
        underTest.store(testGenre2);
        Genre retrievedGenre1 = underTest.findGenreByName("Test");
        Genre retrievedGenre2 = underTest.findGenreByName("Test");
        assertThat(retrievedGenre1).isEqualTo(testGenre1);
        assertThat(retrievedGenre2).isEqualTo(testGenre2);
    }
}

}
