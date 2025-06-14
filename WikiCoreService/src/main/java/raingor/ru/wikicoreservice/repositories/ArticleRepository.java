package raingor.ru.wikicoreservice.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import raingor.ru.wikicoreservice.domain.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
