package raingor.ru.wikicoreservice.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articles", schema = "public")
public class Article extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long author_id;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private Format format;

    @Column(nullable = false)
    private boolean deleted = false;

    private Long deleted_by;

    public Article(Long author_id, String title,
                   String content, Format format) {

        super(OffsetDateTime.now(), null, null);
        this.author_id = author_id;
        this.title = title;
        this.content = content;
        this.format = format;
        this.deleted = false;
    }
}
