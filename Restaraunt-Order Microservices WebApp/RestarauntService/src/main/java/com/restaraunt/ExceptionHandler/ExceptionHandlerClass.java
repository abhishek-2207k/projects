package com.restaraunt.ExceptionHandler;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.restaraunt.exception.BudgetException;
import com.restaraunt.exception.CuisineNotFoundException;
import com.restaraunt.exception.DistanceException;
import com.restaraunt.exception.ErrorData;
import com.restaraunt.exception.FoodItemNotFoundException;
import com.restaraunt.exception.LocationNotFoundException;
import com.restaraunt.exception.MenuItemException;
import com.restaraunt.exception.RestarauntNotFoundException;


@RestControllerAdvice
public class ExceptionHandlerClass {
    @ExceptionHandler(RestarauntNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorData errorHandler(RestarauntNotFoundException re) {
        ErrorData er=new ErrorData();
        er.setMessage(re.getMessage());
        return er;
    }
    
    @ExceptionHandler(BudgetException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorData errorHandler(BudgetException re) {
        ErrorData er=new ErrorData();
        er.setMessage(re.getMessage());
        return er;
    }
    
    @ExceptionHandler(CuisineNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorData errorHandler(CuisineNotFoundException re) {
        ErrorData er=new ErrorData();
        er.setMessage(re.getMessage());
        return er;
    }
    
    @ExceptionHandler(MenuItemException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorData errorHandler(MenuItemException re) {
        ErrorData er=new ErrorData();
        er.setMessage(re.getMessage());
        return er;
    }
    
    @ExceptionHandler(DistanceException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorData errorHandler(DistanceException re) {
        ErrorData er=new ErrorData();
        er.setMessage(re.getMessage());
        return er;
    }
    
    @ExceptionHandler(LocationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorData errorHandler(LocationNotFoundException re) {
        ErrorData er=new ErrorData();
        er.setMessage(re.getMessage());
        return er;
    }
    
    @ExceptionHandler(FoodItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorData errorHandler(FoodItemNotFoundException re) {
        ErrorData er=new ErrorData();
        er.setMessage(re.getMessage());
        return er;
    }
}