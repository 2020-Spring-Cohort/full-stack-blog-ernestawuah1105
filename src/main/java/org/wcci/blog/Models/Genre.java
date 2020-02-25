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
    public String getType(){
        return type;
    }
}
