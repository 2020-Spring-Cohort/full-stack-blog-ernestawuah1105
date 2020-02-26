package org.wcci.blog.Repositories;


import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {


    Object findById(long l);

     Object save(Post testPost);
}

