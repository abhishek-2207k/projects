package com.order.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.order.Exception.ErrorData;
import com.order.Exception.OrderNotFoundException;


@RestControllerAdvice
public class ExceptionHandlerClass {
	
	 @ExceptionHandler(OrderNotFoundException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public ErrorData errorHandler(OrderNotFoundException re) {
	        ErrorData er=new ErrorData();
	        er.setMessage(re.getMessage());
	        return er;
	    }

}
