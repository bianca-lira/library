package com.br.library.exception;

import javassist.NotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class LibraryExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String VALIDATION_NOT_BLANK = "NotBlank";
    private static final String VALIDATION_NOT_NULL = "NotNull";
    private static final String VALIDATION_LENGTH = "Length";
    private static final String VALIDATION_PATTERN = "Pattern";
    private static final String VALIDATION_MIN = "Min";

    private static final String MSG_ERROR = "Ocorreu um erro. Tente novamente em alguns instante ou contacte o administrador.";

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request) {
        String msgUser = "Recurso não encontrado.";
        String msgDeveloper = ex.toString();
        List<Error> errors = List.of(new Error.Builder()
                .status(HttpStatus.NOT_FOUND.value())
                .title(msgUser)
                .detail(msgDeveloper)
                .userMessage(msgUser)
                .timestamp(LocalDateTime.now()).build());
        return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(BusinessRulesException.class)
    public ResponseEntity<Object> businessRulesException(BusinessRulesException ex, WebRequest request) {
        String msgUser = ex.getMessage();
        String msgDeveloper = ex.getMessage();
        List<Error> errors = Arrays.asList(new Error.Builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Ocorreu um erro.")
                .detail(msgDeveloper)
                .userMessage(msgUser)
                .timestamp(LocalDateTime.now()).build());
        return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> notFoundException(NotFoundException ex, WebRequest request) {
        String msgUser = ex.getMessage();
        String msgDeveloper = ex.getMessage();
        List<Error> errors = Arrays.asList(new Error.Builder()
                .status(HttpStatus.NOT_FOUND.value())
                .title("Ocorreu um erro.")
                .detail(msgDeveloper)
                .userMessage(msgUser)
                .timestamp(LocalDateTime.now()).build());
        return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Error> errors = generateListError(ex.getBindingResult());
        return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
    }

    private List<Error> generateListError(BindingResult bindingResult) {
        List<Error> errors = new ArrayList<>();

        bindingResult.getFieldErrors().forEach(fieldError -> {
            String msgUser = handlerErrorMsgUser(fieldError);
            String msgDeveloper = fieldError.toString();
            errors.add(new Error.Builder()
                    .status(HttpStatus.NOT_FOUND.value())
                    .title("Entidade não encontrada")
                    .detail(msgDeveloper)
                    .userMessage(msgUser)
                    .timestamp(LocalDateTime.now()).build());
        });

        return errors;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUncaught(Exception ex, WebRequest request) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String detail = MSG_ERROR;

        logger.error(ex.getMessage(), ex);

        Error problem = new Error.Builder()
                .status(status.value())
                .detail(detail)
                .title("Um erro inesperado aconteceu.")
                .timestamp(LocalDateTime.now())
                .userMessage(MSG_ERROR)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (body == null) {
            body = new Error.Builder()
                    .status(status.value())
                    .title(status.getReasonPhrase())
                    .timestamp(LocalDateTime.now())
                    .userMessage(MSG_ERROR)
                    .build();
        } else if (body instanceof String) {
            body = new Error.Builder()
                    .status(status.value())
                    .title((String) body)
                    .timestamp(LocalDateTime.now())
                    .userMessage(MSG_ERROR)
                    .build();
        }

        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private String handlerErrorMsgUser(FieldError fieldError) {
        if (VALIDATION_NOT_BLANK.equals(fieldError.getCode())) {
            return fieldError.getField() + " é obrigatório.";
        }
        if (VALIDATION_NOT_NULL.equals(fieldError.getCode())) {
            return fieldError.getField() + " é obrigatório.";
        }
        if (VALIDATION_LENGTH.equals(fieldError.getCode())) {
            return Objects.requireNonNull(fieldError.getDefaultMessage()).concat(String.format(" deve ter entre %s e %s caracterres.",
                    Objects.requireNonNull(fieldError.getArguments())[2], fieldError.getArguments()[1]));
        }
        if (VALIDATION_PATTERN.equals(fieldError.getCode())) {
            return fieldError.getField() + " formato inválido.";
        }
        if (VALIDATION_MIN.equals(fieldError.getCode())) {
            return Objects.requireNonNull(fieldError.getDefaultMessage()).concat(String.format(" deve ser maior ou igual a %s",
                    Objects.requireNonNull(fieldError.getArguments())[1]));
        }
        return fieldError.toString();
    }
}
