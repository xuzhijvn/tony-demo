 /*
  *       Copyright© (2020) Lalamove Co., Ltd.
  */
 package com.tony.advice;

 import lombok.extern.slf4j.Slf4j;
 import org.apache.commons.io.IOUtils;
 import org.springframework.core.MethodParameter;
 import org.springframework.http.HttpHeaders;
 import org.springframework.http.HttpInputMessage;
 import org.springframework.http.converter.HttpMessageConverter;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RestControllerAdvice;
 import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

 import java.io.ByteArrayInputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import java.lang.reflect.Type;
 import java.nio.charset.StandardCharsets;

 /**
  * @author tony老师
  * @create 2021-05-24
  * @description: RequestBodyAdvice接口实现类，实现数据的解密操作
  */
 @Slf4j
 @RestControllerAdvice
 public class ParamEncryptRequestBodyAdvice implements RequestBodyAdvice {

     @Override
     public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
         return methodParameter.hasParameterAnnotation(RequestBody.class) && methodParameter.hasParameterAnnotation(Encrypt.class);
     }

     @Override
     public Object handleEmptyBody(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
         return o;
     }

     @Override
     public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
         return new HttpInputMessage() {
             @Override
             public InputStream getBody() throws IOException {
                 log.info("此处进行解密数据");
                 return new ByteArrayInputStream(IOUtils.toString(httpInputMessage.getBody()).replace("-encrypt", "").getBytes(StandardCharsets.UTF_8));
             }

             @Override
             public HttpHeaders getHeaders() {
                 return httpInputMessage.getHeaders();
             }
         };
     }

     @Override
     public Object afterBodyRead(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
         return o;
     }
 }
