package org.wcci.blog.Repositories;
import org.wcci.blog.Models.Genre;

import java.util.Collection;

public interface GenreStorage {
    Collection<Genre> findAllGenres();

    void store (Genre genre);

    Genre findGenreByLocation(String genreLocation);
}
