package wgustudentproject.d424.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@Getter
public class RegisterAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;
}
