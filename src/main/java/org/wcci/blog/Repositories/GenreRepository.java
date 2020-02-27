package org.wcci.blog.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Models.Genre;

import java.util.Collection;
import java.util.Optional;

public interface GenreRepository extends CrudRepository<Genre, Long> {

    Optional<Genre> findByName(String genrelocation);

    Object findByname(String test);

    Collection<Genre> findAll();

    Genre save(Genre testGenre);
}


