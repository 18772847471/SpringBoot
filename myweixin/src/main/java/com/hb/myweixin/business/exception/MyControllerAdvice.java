package com.hb.myweixin.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyControllerAdvice {
    /**
     * 全局异常统一处理
     * @param ex
     * @param request
     * @param httpServletRequest
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity errorHandler(Exception ex,HttpServletRequest request,HttpServletRequest httpServletRequest) {
        return new ResponseEntity("服务器异常,请联系管理员",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
