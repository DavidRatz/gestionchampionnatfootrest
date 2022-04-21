package be.technifutur.gestionchampionnatfootrest.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import be.technifutur.gestionchampionnatfootrest.exceptions.ElementNotFoundException;
import be.technifutur.gestionchampionnatfootrest.models.dtos.ErrorDTO;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdvisor /* extends ResponseEntityExceptionHandler */{

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleElementNotFound(ElementNotFoundException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(
                        ErrorDTO.builder()
                                .message( ex.getMessage() )
                                .method( HttpMethod.resolve(request.getMethod()) )
                                .status(404)
                                .uri( request.getRequestURI() )
                                .build()
                );
    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        System.out.println("salut");
//        return ResponseEntity.ok("salut");
//    }
}
