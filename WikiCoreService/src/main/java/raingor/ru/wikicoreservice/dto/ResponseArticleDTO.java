package raingor.ru.wikicoreservice.dto;

public record ResponseArticleDTO(
        Long id,
        Long author_id, //dalee zamenim na userDto
        String title,
        String content,
        String format
) {
}
