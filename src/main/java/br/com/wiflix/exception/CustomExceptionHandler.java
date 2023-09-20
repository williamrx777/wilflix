package br.com.wiflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<String> handleRecordNotFoundException(RecordNotFoundException recordNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(recordNotFoundException.getMessage());
    }

    @ExceptionHandler(FilmeNotFoundException.class)
    public ResponseEntity<String> filmeRecordNotFoundException(FilmeNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
