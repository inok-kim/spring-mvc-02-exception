package hello.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// ResponseStatusExceptionResolver.java
// resolveResponseStatus -> resolveResponseStatus -> applyStatusAndReason -> response.sendError
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "error.bad")
public class BadRequestException extends RuntimeException{

}
