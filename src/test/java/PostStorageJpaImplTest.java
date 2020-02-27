import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.wcci.blog.Models.Author;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Models.Post;
import org.wcci.blog.Repositories.PostRepository;
import org.wcci.blog.Storage.PostStorage;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;

public class PostStorageJpaImplTest {
    public PostStorageJpaImplTest(Object postRepo) {

    }

    class BookStorageJpaImplTest {
        private PostRepository postRepo;
        private PostStorage underTest;
        private Post testPost;

        @BeforeEach
        void setUp() {
            postRepo = mock(PostRepository.class);
            underTest = (PostStorage) new PostStorageJpaImplTest(postRepo);
            Genre testGenre = new Genre("Test");
            Author testAuthor = new Author("Test");
            testPost = new Post("Test Book", "Test Description", testGenre, testAuthor);

        }


        @Test
        public void shouldFindpostById() {
            when(postRepo.findById(1L)).thenReturn(Optional.of(testPost));
            Post retrievedPost = underTest.findPostById(1L);
            assertThat(retrievedPost).isEqualTo(testPost);
        }


        @Test
        public void shouldStorePost() {
            underTest.store(testPost);
            verify(postRepo).save(testPost);
        }
    }

}
