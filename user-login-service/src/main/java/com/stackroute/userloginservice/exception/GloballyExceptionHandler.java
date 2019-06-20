package com.stackroute.userloginservice.exception;

import com.stackroute.userloginservice.exception.PasswordNotMatchException;
import com.stackroute.userloginservice.exception.UserNameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GloballyExceptionHandler {

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<?> handlePasswordNotMatchException(PasswordNotMatchException e){
        return new ResponseEntity<String>("Password Doesn't Match !", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNameNotFoundException.class)
    public ResponseEntity<?> handleUserNameNotFoundException(UserNameNotFoundException e){
        return new ResponseEntity<String>("User Name Not Found !", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNameOrPasswordEmptyException.class)
    public ResponseEntity<?> handleUserNameOrPasswordEmptyException(UserNameOrPasswordEmptyException e){
        return new ResponseEntity<String>("User Name/Password is Empty !", HttpStatus.NOT_FOUND);
    }

}
