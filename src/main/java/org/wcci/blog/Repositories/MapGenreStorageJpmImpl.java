package org.wcci.blog.Repositories;

import org.wcci.blog.Models.Genre;

import java.util.Collection;
import java.util.HashMap;

public class MapGenreStorageJpmImpl {

        private final HashMap<String, Genre> genre;

        public MapGenreStorageStorage() { genre = new HashMap<>();
        }

        @Override
        public Collection<Genre> findAllCampuses() {
            return genre.values();
        }

        @Override
        public void store(Genre genre) {
            genre.put(genre.getLocation(), genre);
        }

        @Override
        public Campus findCampusByLocation(String campusLocation) {
            return campuses.get(campusLocation);
        }
    }
}
