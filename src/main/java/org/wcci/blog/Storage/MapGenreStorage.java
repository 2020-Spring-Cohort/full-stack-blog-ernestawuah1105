package org.wcci.blog.Storage;

import org.wcci.blog.Models.Genre;
import org.wcci.blog.Storage.GenreStorage;

import java.util.Collection;
import java.util.HashMap;

public class MapGenreStorage implements GenreStorage {
    private HashMap<String, Genre> genres;

    public Collection<Genre> findAllgenres() {
        return genres.values();
    }

    @Override
    public Collection<Genre> findAllGenres() {
        return genres.values();
    }

    @Override
    public void store(Genre genre) {
        genres.put(genre.getName(), genre);
    }

    @Override
    public Genre findGenreByName(String genreLocation) {
        return genres.get(genreLocation);
    }


    @Override
    public Object findAllGenre() {
        return null;
    }
}
