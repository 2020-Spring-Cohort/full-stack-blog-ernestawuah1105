package org.wcci.blog.Storage;


import org.springframework.stereotype.Service;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Repositories.GenreRepository;
import org.wcci.blog.Storage.GenreStorage;

import java.util.Collection;

@Service

public class GenreStorageJpaImpl implements GenreStorage {
    private final GenreRepository genreRepository;

    public GenreStorageJpaImpl(GenreRepository genreRepository) {

        this.genreRepository = genreRepository;
    }

    @Override
    public Collection<Genre> findAllGenres() {
        return (Collection<Genre>) genreRepository.findAll();
    }

    @Override
    public void store(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public Genre findGenreByName(String name) {
        return genreRepository.findByName(name).get();
    }

    @Override
    public Object findAllGenre() {
        return null;
    }
}

