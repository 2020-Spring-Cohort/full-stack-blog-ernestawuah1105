import javafx.beans.binding.BooleanExpression;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.wcci.blog.Models.Genre;
import org.wcci.blog.Storage.GenreStorage;

public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private GenreStorage campusStorage;
    private Genre testGenre;

    @BeforeEach
    public void testClassSetup() {
        testGenre = new Genre("HTTP Request Test Genre");
        campusStorage.store(testGenre);
    }

    @Test
    public void genreEndPointReturnsOK() {
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/Genre", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void specificEndPointReturnsOK() {
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/genre/" + testGenre.getName(), String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    private BooleanExpression assertThat(HttpStatus statusCode) {
    }

}


