package com.fenixbao92.lwpl.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

/**
 *  * HTTP 请求工具类
 *  
 */

@Slf4j
public class HttpUtil {
    private HttpUtil() {
    }

    /**
     *  * post 请求封装
     *  *
     *  * @param value
     *  * @param URL
     *  * @return
     *  
     */

    public static String post(String URL,Object value) {

        if (!StringUtils.isNotBlank(URL)) {
            return null;

        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(NON_EMPTY);
        String requestJson = null;
        try {
            requestJson = objectMapper.writeValueAsString(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("requestJson:{}", requestJson);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(180000);// 设置超时
        requestFactory.setReadTimeout(180000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        log.info("URL:{}", URL);
        ResponseEntity<String> response = restTemplate.exchange(URL, HttpMethod.POST, entity, String.class);
        Integer code = response.getStatusCode().value();
        if (200 != code) {
            log.error("URL:{}", URL);
        }
        return response.getBody();
    }


    /**
     *  * get请求封装
     *  *
     *  * @param uriComponents
     *  * @return
     *  
     */

    public static String get(String URL) {

//        UriComponents uriComponents = UriComponentsBuilder.fromUriString(URL).build().expand(values)
//                .encode();

        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(5000);
        requestFactory.setConnectTimeout(5000);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
//        URI uri = uriComponents.toUri();
//        log.info(uri.toString());
        ResponseEntity<String> response = restTemplate.getForEntity(URL, String.class);
        Integer code = response.getStatusCode().value();
        if (200 != code) {
            log.error(URL);
        }
        return response.getBody();
    }

    public static void main(String[] args){
        String URL = "https://lyy.fenixbao92.com/book/page/0/5";
        Object x = get(URL);
        System.out.println(x);
    }

}

