package org.wcci.blog.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Object save(Author testAuthor);
}
