package raingor.ru.wikicoreservice.services;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import raingor.ru.wikicoreservice.domain.Article;
import raingor.ru.wikicoreservice.dto.CreateArticleDTO;
import raingor.ru.wikicoreservice.dto.ResponseArticleDTO;
import raingor.ru.wikicoreservice.exceptions.ArticleNotFoundException;
import raingor.ru.wikicoreservice.mappers.ArticleMapper;
import raingor.ru.wikicoreservice.repositories.ArticleRepository;

import java.time.OffsetDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    // добавим в будущем проверку на удаленность статьи и если она удалено "софтом" то смотрим права
    public ResponseArticleDTO getArticleById(Long id) {
        Article foundedPage = articleRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);

        return articleMapper.toRequestArticleDTO(foundedPage);
    }

    // изменим findAll без поиска "удаленных"
    public List<ResponseArticleDTO> getAllArticles(Pageable pageRequest) {
        if (pageRequest.isUnpaged()) {
            return null;
        }
        List<Article> articles = articleRepository.findAll(pageRequest).getContent();

        return articleMapper.toRequestArticleDTO(articles);
    }

    // добавим проверку на роль
    public void createArticle(CreateArticleDTO createArticleDTO) {
        Article createdArticle = articleMapper.toArticle(createArticleDTO);

        articleRepository.save(createdArticle);
    }

    // добавим проверку на роль
    public void softDelete(Long id) {
        Article foundedPage = articleRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);

        foundedPage.setDeleted(true);
        foundedPage.setDeletedAt(OffsetDateTime.now());
        foundedPage.setDeleted_by(1L);

        articleRepository.save(foundedPage);
    }

    // добавим проверку на роль
    public void hardDelete(Long id) {
        Article foundedPage = articleRepository.findById(id)
                .orElseThrow(ArticleNotFoundException::new);

        articleRepository.delete(foundedPage);
    }
}
