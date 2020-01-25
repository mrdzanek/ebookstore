package pl.mrdz.pp5.ebook.productcatalog;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class ProductCatalogFacadeTest {

    @Test
    public void itAllowAddBookToCatalog() {
        ProductCatalogFacade api = new ProductCatalogFacade();
        Book book = thereIsBookIWouldLikeToHave();
        api.addBook(book);

        List<Book> books = api.allBooks();
        assertThat(books).hasSize(1);
    }

    private Book thereIsBookIWouldLikeToHave() {
        return Book.builder()
                .cover("https://e-uczelnia.uek.krakow.pl/pluginfile.php/47376/course/section/2688/TWb.jpg")
                .title("Sadistic programmer")
                .description("Journey from hell")
                .price(BigDecimal.valueOf(120.0))
                .published(true)
                .build();
    }
}
