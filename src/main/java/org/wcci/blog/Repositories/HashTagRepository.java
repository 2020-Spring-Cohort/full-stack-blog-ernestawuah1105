package org.wcci.blog.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Models.Hashtag;

import java.util.Optional;

public interface HashTagRepository extends CrudRepository<Hashtag, Long> {
    Optional<Hashtag> findByName(String hashTagName);
}
