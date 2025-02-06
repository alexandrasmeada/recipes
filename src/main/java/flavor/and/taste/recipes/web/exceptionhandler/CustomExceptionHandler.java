package flavor.and.taste.recipes.web.exceptionhandler;

import flavor.and.taste.recipes.model.Error;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
@Component
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class})
    protected ResponseEntity<Error> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error(e.getMessage(), e);

        Error error = Error.builder()
                .requestId(MDC.get("X-Request-ID"))
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.toString())
                .message(e.getMessage())
                .reason(e.getLocalizedMessage())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<Error> handleAllExceptions(Exception e) {
        log.error(e.getMessage(), e);

        Error error = Error.builder()
                .requestId(MDC.get("X-Request-ID"))
                .code(INTERNAL_SERVER_ERROR.value())
                .status(INTERNAL_SERVER_ERROR.toString())
                .message(e.getMessage())
                .reason(e.getLocalizedMessage())
                .build();

        return new ResponseEntity<>(error, INTERNAL_SERVER_ERROR);
    }
}
