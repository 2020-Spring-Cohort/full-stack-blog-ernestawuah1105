package org.wcci.blog.Models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String body;
    @ManyToMany
    private Collection<Hashtag> hashtags;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Genre genre;
    private Date publishDate;

    public Post( String title, String postBody, Genre genre, Author author) {
        this.title = title;
        this.body = postBody;
        this.author = author;
        this.genre = genre;
    }
    public Post (){
    }
    public Post(String title, String postBody) {
        this.title = title;
        this.body = postBody;
    }

    public long getId() {return id; }
    public String getBody() {return body; }
    public String getTitle() {
        return title;
    }
    public Author getAuthor() {
        return author;
    }
    public Genre getGenre() {
        return genre;
    }
    public Date getPublishDate() {
        return publishDate;
    }
    public Collection<Hashtag> getHashtags() {
        return hashtags;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;

        Post post = (Post) o;

        if (getId() != 0 ? !(getId() == post.getId()) : post.getId() != 0) return false;
        if (getAuthor() != null ? !getAuthor().equals(post.getAuthor()) : post.getAuthor() != null)
            return false;
        if (getGenre() != null ? !getGenre().equals(post.getGenre()) : post.getGenre() != null) return false;
        if (getBody() != null ? !getBody().equals(post.getBody()) : post.getBody() != null) return false;
        return getTitle() != null ? getTitle().equals(post.getTitle()) : post.getTitle() == null;
    }


    public void addHasTag(Hashtag hashTOAdd) {
    hashtags.add(hashTOAdd);
}


}








