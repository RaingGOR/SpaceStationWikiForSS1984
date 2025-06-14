package raingor.ru.userservice.exceptions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class ApiException extends RuntimeException {
    private final HttpStatus status;
    private final String message;

    public ApiException(HttpStatus httpStatus, String message) {
        super(message);
        this.status = httpStatus;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
