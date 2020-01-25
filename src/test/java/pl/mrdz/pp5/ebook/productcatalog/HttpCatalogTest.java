package pl.mrdz.pp5.ebook.productcatalog;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class HttpCatalogTest {
    @Autowired
    TestRestTemplate http;

    @Autowired
    ProductCatalogFacade productCatalogFacade;

    @LocalServerPort
    int port;

    public void itAllowListProductViaHttpEndpoint() {
        therIsPublishedBook("Lord of the rings");
        therIsPublishedBook("Hobbit");

        ResponseEntity<Book[]> response = http.getForEntity(
                String.format("localhost:%s/api/products", port),
                Book[].class
        );

        assertThat(response).isEqualTo((HttpStatus.OK));
        assertThat(response.getBody()).hasSize(2);
        assertThat(mapToTitles(response.getBody())).contains("Hobbit");
    }
}
