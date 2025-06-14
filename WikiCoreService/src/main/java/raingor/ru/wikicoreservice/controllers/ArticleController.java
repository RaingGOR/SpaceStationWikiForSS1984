package raingor.ru.wikicoreservice.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import raingor.ru.wikicoreservice.dto.CreateArticleDTO;
import raingor.ru.wikicoreservice.dto.RequestArticleDTO;
import raingor.ru.wikicoreservice.services.ArticleService;

import java.util.List;

/*
 * Need:
 * Main
 * GetAllWithPages
 * GetPage
 * UpdatePage
 * SoftDeletePage
 */

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping
    public List<RequestArticleDTO> getAllArticles(
            @RequestParam(value = "offset", defaultValue = "0") Integer offset,
            @RequestParam(value = "limit", defaultValue = "10") Integer limit
    ) {
        return articleService.getAllArticles(PageRequest.of(offset, limit));
    }

    @GetMapping("/{id}")
    public RequestArticleDTO getArticle(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    // от редактора и выше
    @PostMapping
    public HttpStatus createArticle(CreateArticleDTO createArticleDTO) {
        articleService.createArticle(createArticleDTO);

        return HttpStatus.CREATED;
    }
    // от редактора и выше
    @DeleteMapping("/soft/{id}")
    public HttpStatus softDelete(@PathVariable Long id) {
        articleService.softDelete(id);

        return HttpStatus.OK;
    }

    // старший редактор онли
    @DeleteMapping("/{id}")
    public HttpStatus deleteArticle(@PathVariable Long id) {
        articleService.hardDelete(id);

        return HttpStatus.OK;
    }
}
