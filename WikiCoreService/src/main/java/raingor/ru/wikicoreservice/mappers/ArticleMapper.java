package raingor.ru.wikicoreservice.mappers;


import org.springframework.stereotype.Component;
import raingor.ru.wikicoreservice.domain.Article;
import raingor.ru.wikicoreservice.domain.Format;
import raingor.ru.wikicoreservice.dto.CreateArticleDTO;
import raingor.ru.wikicoreservice.dto.ResponseArticleDTO;

import java.util.List;

@Component
public class ArticleMapper {
    public ResponseArticleDTO toRequestArticleDTO(Article article) {
        return new ResponseArticleDTO(
                article.getId(),
                article.getAuthor_id(),
                article.getTitle(),
                article.getContent(),
                article.getFormat().name()
        );
    }

    public List<ResponseArticleDTO> toRequestArticleDTO(List<Article> articles) {
        return articles.stream()
                .map(this::toRequestArticleDTO)
                .toList();
    }

    public Article toArticle(CreateArticleDTO requestArticleDTO) {
        return new Article(
                requestArticleDTO.author_id(),
                requestArticleDTO.title(),
                requestArticleDTO.content(),
                Format.valueOf(requestArticleDTO.format())
        );
    }
}
