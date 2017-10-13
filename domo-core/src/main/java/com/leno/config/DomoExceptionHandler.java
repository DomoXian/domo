package com.leno.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Created by XianGuo
 * Date: 2017-10-12 20:57
 */
@ControllerAdvice
@Slf4j
public class DomoExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String handlerException(Exception e) {
        log.error("服务器异常：",e);
        return "/error/500";
    }
}
