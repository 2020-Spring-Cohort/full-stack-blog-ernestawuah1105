package org.wcci.blog.Storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.Models.Author;
import org.wcci.blog.Repositories.AuthorRepository;

@Service
public class AuthorStorageJpaImpl implements AuthorStorage {
    private AuthorRepository authorRepository;

    public AuthorStorageJpaImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void store(Author authorToStore) {
        authorRepository.save(authorToStore);
    }
}

