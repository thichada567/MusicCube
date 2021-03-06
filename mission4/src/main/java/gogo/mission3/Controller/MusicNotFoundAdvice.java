package gogo.mission3.Controller;

import gogo.mission3.Exception.MusicNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MusicNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MusicNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String musicNotFoundHandler(MusicNotFoundException ex) {
        return ex.getMessage();
    }
}
