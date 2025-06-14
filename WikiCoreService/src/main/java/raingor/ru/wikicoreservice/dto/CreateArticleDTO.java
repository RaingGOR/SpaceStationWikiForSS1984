package raingor.ru.wikicoreservice.dto;

public record CreateArticleDTO(
        Long author_id, // dalee budem brat s cooki
        String title,
        String content,
        String format
) {
}
