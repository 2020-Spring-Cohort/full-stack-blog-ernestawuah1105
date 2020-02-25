package org.wcci.blog.Repositories;

import org.springframework.stereotype.Service;
import org.wcci.blog.Models.Author;
import org.wecancodeit.library.models.Author;
import org.wecancodeit.library.storage.repositories.AuthorRepository;

@Service
public class AuthorStorageJpmImpl {
    private final AuthorRepository authorRepository;

    public AuthorStorageJpaImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void store(Author authorToStore) {
        authorRepository.save(authorToStore);
    }
}

