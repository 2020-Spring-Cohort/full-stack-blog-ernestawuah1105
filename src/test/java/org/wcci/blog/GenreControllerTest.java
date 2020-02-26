package org.wcci.blog;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.Controllers.GenreController;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Storage.AuthorStorage;
import org.wcci.blog.Storage.GenreStorage;
import org.wcci.blog.Storage.PostStorage;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class GenreControllerTest {
    private MockMvc mockMvc;
    private GenreController underTest;
    private GenreStorage campusStorage;
    private Model mockModel;
    private PostStorage bookStorage;
    private AuthorStorage authorStorage;
    private GenreStorage genreStorage;

    @BeforeEach
    public void setUp() {
        mockModel = mock(Model.class);
        GenreStorage genreStorage = mock(GenreStorage.class);
        authorStorage = mock(AuthorStorage.class);
        bookStorage = mock(PostStorage.class);
        underTest = new GenreController(genreStorage, authorStorage, bookStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
    }

    @Test
    public void shouldReturnViewWithOneGenre() {
        Genre testGenre = new Genre("TEST");
        Object genreStorage = new Object();
        when(genreStorage.findGenreByname( "TEST")).thenReturn(testGenre);

        underTest.displaySingleGenre(" TEST", mockModel);


        verify(genreStorage).findGenreByname("TEST");
        verify(mockModel).addAttribute("genre", testGenre);
    }

    @Test
    public void shouldReturnViewNamedGenreViewWhenDisplaySingleGenreIsCalled() {
        String viewName = underTest.displaySingleGenre("Test", mockModel);
        assertThat(viewName).isEqualTo("genreView");
    }

    @Test
    public void shouldGoToIndividualEndPoint() throws Exception {
        Genre testGenre = new Genre("TEST");
        when(genreStorage.findgenreByname("TEST")).thenReturn(testGenre);

        Object tester = new Object();
        mockMvc.perform(get("/genre/ TEST"))
                .andExpect(status().isOk())
                .andExpect(view().name("genreView"))
                .andExpect(model().attributeExists("genre"))
                .andExpect(model().attribute("genre", tester));
    }

    private StatusAssertions status() {


    }

    @Test
    public void genreEndPointDisplaysAllGenre() throws Exception {
        Genre testGenre = new Genre("test");

        List<Genre> genreCollection = Collections.singletonList(testGenre);
        Object genreStorage = new genreCollection();
        when(genreStorage.findAllGenre()).thenReturn(genreCollection);
        mockMvc.perform(get("/genre"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("genreView"))
                .andExpect(model().attributeExists("genre"))
                .andExpect(model().attribute("genre", genreCollection));
    }

    @Test
    public void addGenreShouldRedirectToGenresEndPoint() {
        String result = underTest.addGenre("Test");
        assertThat(result).isEqualTo("redirect:genres");
    }

    @Test
    public void addGenreShouldStoreANewGenre() {
        underTest.addGenre("Test");
        verify(genreStorage).store(new Genre("Test"));
    }

    @Test
    public void addGenreEndpointShouldAddNewGenre() throws Exception {
        mockMvc.perform(post("/add-genre")
                .param("location", "Test"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        verify(campusStorage).store(new Genre("Test "));
    }
}

}
