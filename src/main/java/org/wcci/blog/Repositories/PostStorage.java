package org.wcci.blog.Repositories;

import org.wcci.blog.Models.Post;

public interface PostStorage {
    Post findPostById(Long id);
    void store(Post postToStore);
}
