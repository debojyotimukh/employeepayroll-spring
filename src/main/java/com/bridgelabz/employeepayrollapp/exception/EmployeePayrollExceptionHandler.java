package com.bridgelabz.employeepayrollapp.exception;

import java.util.List;
import java.util.stream.Collectors;

import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
        List<String> allMsgs = allErrors.stream().map(objError -> objError.getDefaultMessage())
                .collect(Collectors.toList());

        log.error(allMsgs.toString());

        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST call", allMsgs);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException e) {
        log.error(e.getMessage());
        ResponseDTO responseDTO = new ResponseDTO("Some exception cought", e.getMessage());

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.EXPECTATION_FAILED);
    }
}
