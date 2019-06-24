package com.stackroute.userloginservice.exception;

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

    @ExceptionHandler(UserNameOrPasswordOrRoleEmptyException.class)
    public ResponseEntity<?> handleUserNameOrPasswordEmptyException(UserNameOrPasswordOrRoleEmptyException e){
        return new ResponseEntity<String>("User Name/Role/Password is Empty !", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<?> handleRoleNotFoundException(RoleNotFoundException e){
        return new ResponseEntity<String>("User Role is Empty !", HttpStatus.NOT_FOUND);
    }

}
