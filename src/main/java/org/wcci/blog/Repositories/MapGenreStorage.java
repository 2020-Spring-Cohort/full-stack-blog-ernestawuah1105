package org.wecancodeit.library.storage;

import org.wecancodeit.library.models.Campus;

import java.util.Collection;
import java.util.HashMap;


public class MapCampusStorage implements GenreStorage {
    private final HashMap<String, Genre> campuses;

    public MapGenreStorage() { genres = new HashMap<>();
    }

    @Override
    public Collection<Genre> findAllgenres() {
        return genres.values();
    }

    @Override
    public void s
    tore(Genre genre) {
        genre.put(genres.getLocation(), genre);
    }

    @Override
    public Genre findGenreByLocation(String genreLocation) {
        return genres.get(genreLocation);
    }
}