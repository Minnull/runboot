package com.run.boot.advice;

import com.run.boot.exception.ErrorStatus;
import com.run.boot.exception.RunbootException;
import com.run.boot.result.RunResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/**
 * @author : maweijie
 * @date : 2019/1/31
 * @description:
 */
@ControllerAdvice(basePackages = {"com.run.boot.controller"})
public class RunbootControllerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(RunbootControllerAdvice.class);

    @Autowired
    private MessageSource messageSource;


    /**
     * 拦截捕捉自定义异常 MyException.class
     */
    @ResponseBody
    @ExceptionHandler(value = RunbootException.class)
    public RunResult myErrorHandler(RunbootException ex) {
        LOGGER.error(ex.getMessage(), ex);
        RunResult response = new RunResult();
        response.setError(ex.getStatus(), ex.getMessage());
        return response;
    }

    @ResponseBody
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public RunResult HttpRequestErrorHandler(HttpMessageNotReadableException ex) {
        LOGGER.error(ex.getMessage(), ex);
        RunResult response = new RunResult();
        response.setError(ErrorStatus.SYSTEM_ERROR, ex.getMessage());
        return response;
    }

    /**
     * 全局异常捕捉处理
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public RunResult errorHandler(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        LOGGER.info("advice worked...");
        RunResult response = new RunResult();
        response.setError(ErrorStatus.SYSTEM_ERROR, messageSource.getMessage(String.valueOf(ErrorStatus.SYSTEM_ERROR), null, Locale.getDefault()));
        return response;
    }
}
