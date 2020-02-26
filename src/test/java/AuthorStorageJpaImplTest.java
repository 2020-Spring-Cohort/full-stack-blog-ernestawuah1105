import org.junit.Test;
import org.wcci.blog.Models.Author;
import org.wcci.blog.Repositories.AuthorRepository;
import org.wcci.blog.Storage.AuthorStorage;
import org.wcci.blog.Storage.AuthorStorageJpaImpl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AuthorStorageJpaImplTest {
    @Test
    public void shouldStoreAuthor() {
        AuthorRepository authorRepo = mock(AuthorRepository.class);
        AuthorStorage underTest = new AuthorStorageJpaImpl(authorRepo);
        Author testAuthor = new Author("Tester", "MacTeston");
        underTest.store(testAuthor);
        verify(authorRepo).save(testAuthor);
    }
}

