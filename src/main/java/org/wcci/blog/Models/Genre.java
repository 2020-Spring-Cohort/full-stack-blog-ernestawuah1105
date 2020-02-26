package org.wcci.blog.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class Genre {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String type;
    @OneToMany( mappedBy = "genre")
    private Collection<Post> posts;
    public Genre(String type) {
        this.type = type;
    }
    public Genre(){
    }

    public Genre(String action, String description) {
    }

    public String getType(){
        return type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }
}
