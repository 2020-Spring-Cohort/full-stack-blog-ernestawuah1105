package org.wcci.blog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Models.Post;
import org.wcci.blog.Models.Post;
import org.wcci.blog.Repositories.PostRepository;
import org.wcci.blog.Storage.GenreStorage;

@Component
public class Populator implements CommandLineRunner {
    private PostRepository postRepo;
    GenreStorage categoryStorageyStorage;
    GenreStorage genreStorage;
    private Post ReviewTwo;

    public Populator(GenreStorage categoryStorage, PostRepository postRepo){
        this.genreStorage = categoryStorage;
        this.postRepo = postRepo;
    }

    @Override
    public void run(String... args) throws Exception{
        Genre actionCat = new Genre("Action","");
        genreStorage.store(actionCat);
        Post actionReview = new Post("Jane Doe", "This movie sucks");
        Post action = ReviewTwo = new Post("The Dark Knight",".");
        postRepo.save(actionReview);
        Post actionReviewTwo = new Post("Matrix", "Good");
        postRepo.save(actionReviewTwo);
//
    }
}
