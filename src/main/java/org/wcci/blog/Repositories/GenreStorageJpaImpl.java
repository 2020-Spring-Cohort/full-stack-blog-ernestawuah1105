package org.wcci.blog.Repositories;


import org.springframework.stereotype.Service;
import org.wcci.blog.Models.Genre;

import java.util.Collection;

@Service

public class GenreStorageJpaImpl implements GenreStorage {
    private final GenreRepository genreRepository;

    public CampusStorageJpaImpl(GenreRepository genreRepository) {

        this.genreRepository = genreRepository;
    }

    @Override
    public Collection<Genre> findAllGenre() {
        return (Collection<Genre>) genreRepository.findAll();
    }

    @Override
    public void store(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public Genre findgenreByLocation(String genreLocation) {
        return genreRepository.findByLocation(genreLocation).get();
    }
}

