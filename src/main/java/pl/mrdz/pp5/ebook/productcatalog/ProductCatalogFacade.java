package pl.mrdz.pp5.ebook.productcatalog;

import java.util.List;

public class ProductCatalogFacade {
    BookRepository repository;
    public ProductCatalogFacade(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> allBooks() {
        return repository.findAll();
    }

    public void addBook(Book book) {
        repository.save(book);
    }
}
