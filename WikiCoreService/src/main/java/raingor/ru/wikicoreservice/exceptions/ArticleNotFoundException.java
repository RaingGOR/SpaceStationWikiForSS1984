package raingor.ru.wikicoreservice.exceptions;

import org.springframework.http.HttpStatus;

public class ArticleNotFoundException extends ApiException{
    public ArticleNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Article not found");
    }
}
