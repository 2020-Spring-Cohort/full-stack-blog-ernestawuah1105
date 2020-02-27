package org.wcci.blog.Storage;
import org.wcci.blog.Models.Genre;

import java.util.Collection;

public interface GenreStorage {
    Collection<Genre> findAllGenres();

    void store (Genre genre);

    Genre findGenreByName(String genreLocation);

    Collection<Genre> findAllGenre();
}
