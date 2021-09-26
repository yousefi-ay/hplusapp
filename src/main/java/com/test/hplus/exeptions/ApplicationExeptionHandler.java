package com.test.hplus.exeptions;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;

@ControllerAdvice
public class ApplicationExeptionHandler {

    @ExceptionHandler({ApplicationExeptions.class, AsyncRequestTimeoutException.class})
    public String handleExeption()
    {
        System.out.println("in global exeption handler");
        return "error";
    }
}
