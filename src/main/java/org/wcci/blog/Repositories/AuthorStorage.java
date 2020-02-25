package org.wcci.blog.Repositories;

import org.wcci.blog.Models.Author;

public interface AuthorStorage {
    void store(Author authorToStore);
}
