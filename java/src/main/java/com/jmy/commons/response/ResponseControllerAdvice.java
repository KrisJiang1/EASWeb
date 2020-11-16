package com.jmy.commons.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jmy.commons.exception.APIException;
import com.jmy.commons.result.ResultVO;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(basePackages = {"com.jmy.controller"})
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {

    //当supports方法要返回true才会执行beforeBodyWrite方法
    //所以当controller的返回值为ResultVO时 supports方法返回false 不进行额外的操作
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        //如果接口返回的类型本身就是ResultVO 那就没有必要进行额外的操作 ，返回false
        return !returnType.getGenericParameterType().equals(ResultVO.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //String类型不能直接包装,所以要进行些特别的处理
        if (returnType.getGenericParameterType().equals(String.class)){
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                //将数据包装在ResultVO里后，在转换为json字符串响应给前端
                return objectMapper.writeValueAsString(new ResultVO<>(data));
            } catch (JsonProcessingException e) {
                throw new APIException("返回String类型错误");
            }
        }
        //将原来的数据包装在ResultVO里
        return new ResultVO<>(data);
    }
}
