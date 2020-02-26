package org.wcci.blog.Storage;

import org.wcci.blog.Models.Author;

public interface AuthorStorage {
    void store(Author authorToStore);
}
