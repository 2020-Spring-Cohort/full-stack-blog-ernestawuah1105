package org.wcci.blog.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Storage.AuthorStorage;
import org.wcci.blog.Storage.GenreStorage;
import org.wcci.blog.Storage.PostStorage;

@Controller
public class GenreController {
    private GenreStorage genreStorage;

    public GenreController(GenreStorage genreStorage) {
        this.genreStorage = genreStorage;
    }

    public GenreController(GenreStorage genreStorage, AuthorStorage authorStorage, PostStorage bookStorage) {

    }

    @RequestMapping("/genres")
    public String displayGenres(Model model) {
        model.addAttribute("genres", genreStorage.findAllGenres());
        return "genresView";
    }

    @GetMapping("/genres/{genreLocation}")
    public String displaySingleGenre(@PathVariable String genreLocation, Model model) {
        Genre retrievedGenre = genreStorage.findGenreByName(genreLocation);
        model.addAttribute("genre", retrievedGenre);
        return "genreView";
    }
    @PostMapping("/add-genre")
    public String  addGenre(@RequestParam String location) {
        genreStorage.store(new Genre(location));
        return "redirect:genres";
    }
    @GetMapping("/")
    public String displayHomePage(Model model) {
        return"Home";
    }


    public void displaySinglePost(String los_testa, Model mockModel) {

    }
}



