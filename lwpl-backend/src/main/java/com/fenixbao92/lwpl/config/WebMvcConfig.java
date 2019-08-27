package com.fenixbao92.lwpl.config;


import com.fenixbao92.lwpl.aop.WxSessionProcessInterceptor;
import com.fenixbao92.lwpl.common.utils.DateConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 拦截wx请求 将sessionId->openId->account并写入spring security
     */
    @Resource
    private WxSessionProcessInterceptor wxSessionProcessInterceptor;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }

    @Bean
    public ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(wxSessionProcessInterceptor).addPathPatterns("/wx/**");
    }

}
