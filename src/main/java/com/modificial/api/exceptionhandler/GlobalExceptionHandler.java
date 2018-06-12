package com.modificial.api.exceptionhandler;

import com.modificial.api.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author modificial
 * @date 2018/6/12
 * @company codingApi
 * @description
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理controller抛出的异常
     *
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public String handleServiceException(HttpServletRequest request, Exception e)
    {
        log.error("Request FAILD, URL = {}", request.getRequestURI());
        log.error(e.toString(), e);
        return e.getMessage();
    }
    /**
     * 处理其他抛出的异常
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleException(HttpServletRequest request, Exception e)
    {
        log.error("Request FAILD, URL = {}", request.getRequestURI());
        log.error(e.toString(), e);
        return e.getMessage();
    }
}
