import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Storage.AuthorStorage;
import org.wcci.blog.Storage.GenreStorage;
import org.wcci.blog.Storage.PostStorage;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class WebLayerTest {
    @MockBean
    GenreStorage mockStorage;
    @MockBean
    PostStorage bookStorage;
    @MockBean
    AuthorStorage authorStorage;
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void genresShouldBeOKAndReturnTheGenresViewWithGenresModelAttribute() throws Exception {
        mockMvc.perform(get("/genres"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("genresView"))
                .andExpect(model().attributeExists("genres"));
    }



    @Test
    public void shouldReceiveOKFromSingleGenreEndpoint() throws Exception {
        Genre testGenre = new Genre("Test");
        when(mockStorage.findGenreByName("Test")).thenReturn(testGenre);
        mockMvc.perform(get("/genre/Test"))
                .andExpect(status().isOk())
                .andExpect(view().name("genreView"))
                .andExpect(model().attributeExists("genre"));
    }

    @Test
    public void shouldBeAbleToCreateNewGenre() throws Exception {
        mockMvc.perform(post("/add-genre")
                .param("location", "Test"))
                .andExpect(status().is3xxRedirection());
        verify(mockStorage).store(new Genre("Test"));
    }

}


