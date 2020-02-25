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
    private Collection<Hashtag> hashtag;
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
    public String getTitle() {
        return title;
    }
    public String getPostBody() {
        return body;
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
}
    @Override
    public String toString() {
        String description;
        return "Book{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;

        Post post = (Post) o;

        if (getId() != null ? !getId().equals(post.getId()) : post.getId() != null) return false;
        if (getDescription() != null ? !getDescription().equals(post.getDescription()) : post.getDescription() != null)
            return false;
        if (getGenre() != null ? !getGenre().equals(post.getGenre()) : post.getGenre() != null) return false;
        return getTitle() != null ? getTitle().equals(post.getTitle()) : post.getTitle() == null;
    }

    private Object getDescription() {
    }

    private Object getId() {
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getGenre() != null ? getGenre().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        return result;
    }
}





