package com.fenixbao92.lwpl.aop;

import com.fenixbao92.lwpl.config.redis.RedisTool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Service
@Slf4j
public class WxSessionProcessInterceptor implements HandlerInterceptor {

    @Resource
    private RedisTool redisTool;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {       //请求进入这个拦截器
        String sessionId = request.getHeader("sessionId");
        log.info("request received ==== sessionId:{},uri:{}",sessionId,request.getRequestURI());
        if (sessionId == null) {
            return true;
        }
        String openId = redisTool.get(sessionId);
        if (openId == null) {
            return true;
        }
        return false;        //有的话就继续操作
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}
