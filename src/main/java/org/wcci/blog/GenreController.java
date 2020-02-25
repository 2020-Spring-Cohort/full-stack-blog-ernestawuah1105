package org.wcci.blog;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Repositories.GenreStorage;

@Controller
public class GenreController {
    private GenreStorage genreStorage;

    public GenreController(GenreStorage genreStorage) {
        this.genreStorage = genreStorage;
    }

    @RequestMapping("/genres")
    public String displayGenres(Model model) {
        model.addAttribute("genres", genreStorage.findAllGenres());
        return "genresView";
    }

    @GetMapping("/genres/{genreLocation}")
    public String displaySingleGenre(@PathVariable String genreLocation, Model model) {
        Genre retrievedGenre = genreStorage.findGenreByLocation(genreLocation);
        model.addAttribute("campus", retrievedGenre);
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


}



