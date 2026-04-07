package org.example.Bank.exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
     @ExceptionHandler
     public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(400).body("");
   }
}