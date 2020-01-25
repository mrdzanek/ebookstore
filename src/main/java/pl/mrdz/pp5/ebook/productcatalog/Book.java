package pl.mrdz.pp5.ebook.productcatalog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
public class Book {
    String title;
    String description;
    String cover;
    Boolean published;
    BigDecimal price;


}
