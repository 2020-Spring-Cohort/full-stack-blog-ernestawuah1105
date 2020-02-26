package org.wcci.blog.Storage;

import org.wcci.blog.Models.Post;

public interface PostStorage {
    Post findPostById(long id);
    void store(Post postToStore);
}
