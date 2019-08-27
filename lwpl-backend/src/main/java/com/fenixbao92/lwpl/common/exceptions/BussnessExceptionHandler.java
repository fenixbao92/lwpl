package com.fenixbao92.lwpl.common.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Create by fenixbao92 on 2019/5/13.
 */
@ControllerAdvice
@Slf4j
public class BussnessExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public void handleException(HttpServletRequest request, HttpServletResponse response, BusinessException e) throws IOException {
        log.error("异常：---Host {} invokes url {} ERROR: {}", request.getRemoteHost(), request.getRequestURL(), e.getMessage());
        response.setStatus(e.getCode());
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = response.getWriter();
        try{
            out.write(om.writeValueAsString(e.getMessage()));
        }catch (Exception e1){
            out.write("unKnow error");
        }finally {
            out.flush();
            out.close();
        }
    }

}
