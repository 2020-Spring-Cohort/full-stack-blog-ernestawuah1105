import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.ResultMatcher;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Storage.AuthorStorage;
import org.wcci.blog.Storage.GenreStorage;
import org.wcci.blog.Storage.PostStorage;

import static org.mockito.Mockito.when;

public class SpringWebApplicationTest {

    @MockBean
    PostStorage bookStorage;
    @MockBean
    AuthorStorage authorStorage;
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GenreStorage campusStorage;

    @Test
    public void shouldReceiveOKFromGenresEndpoint() throws Exception {
        mockMvc.perform(get("/genres"))
                .andDo(print())
                .andExpect((ResultMatcher) status().isOk());
    }





    @Test
    public void shouldReceiveOKFromSingleGenreEndpoint() throws Exception {
        Genre testGenre = new Genre("Test");
        Object genreStorage = new Object();
        when(genreStorage.findGenreByname("Test")).thenReturn(testGenre);
        mockMvc.perform(get("/genre/Test"))
                .andExpect(status().isOk());
    }


}

}
