package dev.patika.vetproject.core.exception;


import dev.patika.vetproject.core.result.Result;
import dev.patika.vetproject.core.result.ResultData;
import dev.patika.vetproject.core.utilities.Msg;
import dev.patika.vetproject.core.utilities.ResultHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

//aldıgımexceptionları yakalayıp ona göre response vericek
@ControllerAdvice
public class GlobalExceptionHAndler {

@ExceptionHandler (NotFoundException.class)
public ResponseEntity <Result> handleNotFoundException (NotFoundException e){
    return new ResponseEntity<>(ResultHelper.notFoundError(e.getMessage()), HttpStatus.NOT_FOUND);
}



//--------------------------------------------------------------------------------------------------------
@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData<List<String>>> handleValidationErrors(MethodArgumentNotValidException e){

    List<String> validationErrorList = e.getBindingResult().getFieldErrors().stream()
            .map(FieldError::getDefaultMessage).collect(Collectors.toList());
    //id boş olamaz
    //isim dolu olmalı

   //  ResultData<List<String>> resultData = new ResultData<>(false, Msg.VALIDATE_ERROR,"400", validationErrorList);
    return new ResponseEntity<>(ResultHelper.validateError(validationErrorList), HttpStatus.BAD_REQUEST);
//--------------------------------------------------------------------------------------------------------

}

}
