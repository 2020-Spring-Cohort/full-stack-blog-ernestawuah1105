package org.wcci.blog.Storage;

import org.springframework.stereotype.Service;
import org.wcci.blog.Models.Post;
import org.wcci.blog.Repositories.PostRepository;

import java.util.Optional;

@Service
public class PostStorageJpaImpl implements PostStorage {
    private final PostRepository postRepository;

    public PostStorageJpaImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post findPostById(long id) {
        return ((Optional<Post>) postRepository.findById(id)).get();
    }

    @Override
    public void store(Post postToStore) {
        postRepository.save(postToStore);
    }
}
