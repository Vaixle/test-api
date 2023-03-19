package com.vaixle.testapi.controller.advice;

import com.vaixle.testapi.exception.NotEnoughException;
import com.vaixle.testapi.exception.NotFoundException;
import com.vaixle.testapi.payload.response.AdviceErrorMessage;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(value = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AdviceErrorMessage productNotFoundException(NotFoundException ex) {
        return new AdviceErrorMessage(ex.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AdviceErrorMessage methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errors = new ArrayList<>();
        for (FieldError fieldError: fieldErrors) {
            errors.add(fieldError.getDefaultMessage());
        }
        return new AdviceErrorMessage(errors.toString());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AdviceErrorMessage constraintViolationException(ConstraintViolationException ex) {
        return new AdviceErrorMessage(ex.getMessage());
    }

    @ExceptionHandler(value = DataAccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AdviceErrorMessage dataAccessException(DataAccessException ex) {
        return new AdviceErrorMessage(ex.getCause().getCause().getMessage());
    }

    @ExceptionHandler(value = NotEnoughException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AdviceErrorMessage notEnoughException(NotEnoughException ex) {
        return new AdviceErrorMessage(ex.getMessage());
    }
}
