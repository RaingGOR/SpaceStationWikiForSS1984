package raingor.ru.wikicoreservice.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private Long timestamp;
}
