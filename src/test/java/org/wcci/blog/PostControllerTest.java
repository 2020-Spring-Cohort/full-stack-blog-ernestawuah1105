package org.wcci.blog;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.Controllers.PostController;
import org.wcci.blog.Models.Author;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Models.Post;
import org.wcci.blog.Repositories.HashTagRepository;
import org.wcci.blog.Storage.PostStorage;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PostControllerTest {
    private PostController underTest;
    private Model model;
    private PostStorage mockStorage;
    private Post testPost;
    private HashTagRepository hashTagRepo;

    @BeforeEach
    void setUp() {
        mockStorage = mock(PostStorage.class);
        hashTagRepo = mock(HashTagRepository.class);
        underTest = new PostController(mockStorage);
        model = mock(Model.class);
        Genre testGenre = new Genre("Test");
        Author testAuthor = new Author("Test");
        testPost = new Post("Test", "Test", testGenre, testAuthor);
        when(mockStorage.findPostById(1L)).thenReturn(testPost);

    }
    @Test
    public void displayPostReturnsPostTemplate() {
        String result = underTest.displayPost(1L, model);
        assertThat(result).isEqualTo("post-view");
}
    @Test
    public void displayPostInteractsWithDependenciesCorrectly() {

        underTest.displayPost(1L, model);
        verify(mockStorage).findPostById(1L);
        verify(model).addAttribute("post", testPost);
    }
    @Test
    public void displayPostMappingIsCorrect() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/posts/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("Post-view"))
                .andExpect(model().attributeExists("post"))
                .andExpect(model().attribute("post", testPost));
    }

}
