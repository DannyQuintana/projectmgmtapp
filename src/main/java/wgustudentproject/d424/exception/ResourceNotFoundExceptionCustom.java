package wgustudentproject.d424.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExceptionCustom extends RuntimeException{
    public ResourceNotFoundExceptionCustom(String errorMessage){
        super(errorMessage);
    }
}
