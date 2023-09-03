package com.music.albums.api.exceptionhandler;

import com.music.albums.api.exceptions.EntityBadRequestException;
import javax.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException hmnre, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        ProblemType problemType = ProblemType.IMPROPERSIBLE_REQUIREMENT;
        String detail = "Verifique erro de sintaxe";
        
        InterceptorException interceptor = interceptorBuilder(
                status, problemType, detail).build();

        return handleExceptionInternal(hmnre, interceptor, new HttpHeaders(), status, request);

    }

    @ExceptionHandler(EntityBadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(
            EntityBadRequestException ebre, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        ProblemType problemType = ProblemType.ERROR_IN_REQUEST;
        String detail = ebre.getMessage();
        
        InterceptorException interceptor = interceptorBuilder(
                status, problemType, detail).build();

        return handleExceptionInternal(ebre, interceptor,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> treatmentEntityConflictException(
            DataIntegrityViolationException dive, WebRequest request) {

        HttpStatus status = HttpStatus.CONFLICT;

        ProblemType problemType = ProblemType.CONFLICTING_REQUESTS;
        String detail = dive.getMessage();
        
        InterceptorException interceptor = interceptorBuilder(
                status, problemType, detail).build();

        return handleExceptionInternal(dive, interceptor,
                new HttpHeaders(), HttpStatus.CONFLICT, request);

    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> treatmentEntityNotFoundException(
            EntityNotFoundException enfe, WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        ProblemType problemType = ProblemType.ENTITY_NOT_FOUND;
        String detail = enfe.getMessage();
        
        InterceptorException interceptor = interceptorBuilder(
                status, problemType, detail).build();

        return handleExceptionInternal(enfe, interceptor,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        if (body == null) {
            body = InterceptorException.builder()
                    .title(status.getReasonPhrase())
                    .status(status.value())
                    .build();

        } else if (body instanceof String) {
            body = InterceptorException.builder()
                    .title((String) body)
                    .status(status.value())
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private InterceptorException.InterceptorExceptionBuilder interceptorBuilder(
            HttpStatus status, ProblemType problemType, String detail) {

        return InterceptorException.builder()
                .status(status.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .detail(detail);
                

    }
}
