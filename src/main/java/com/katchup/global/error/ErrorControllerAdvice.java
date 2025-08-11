package com.katchup.global.error;

import com.katchup.global.common.response.CommonResponse;
import com.katchup.global.error.exception.BaseErrorCode;
import com.katchup.global.error.exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ErrorControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CommonResponse> handleCustomException(CustomException ex) {
        final BaseErrorCode errorCode = ex.getErrorCode();
        final ErrorResponse errorResponse =
                ErrorResponse.of(errorCode.errorClassName(), errorCode.getMessage());
        final CommonResponse response =
                CommonResponse.onFailure(errorCode.getHttpStatus().value(), errorResponse);
        return ResponseEntity.status(errorCode.getHttpStatus()).body(response);
    }
}
