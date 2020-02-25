package org.wcci.blog.Models;

import org.wcci.blog.Models.Post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class Hashtag {
    @Id
    @GeneratedValue
    private Long ID;
    private String name;
    @ManyToMany
    private Collection<Post> posts;
}
