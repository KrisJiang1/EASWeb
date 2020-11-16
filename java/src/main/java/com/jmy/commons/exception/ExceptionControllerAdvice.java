package com.jmy.commons.exception;

import com.jmy.commons.result.ResultCode;
import com.jmy.commons.result.ResultVO;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

//全局异常处理
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultVO<List> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        //从异常对象中拿到ObjectError对象
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        for (ObjectError error : allErrors) {
            System.out.println(error.getDefaultMessage());
        }
        //然后提取错误信息进行返回
        return new ResultVO<>(ResultCode.VALIDATE_FAILED,allErrors);
    }

    @ExceptionHandler(APIException.class)
    public ResultVO<String> APIExceptionHandler(APIException e){
        return new ResultVO<>(ResultCode.FAILED,e.getMsg());
    }


    @ExceptionHandler(Exception.class)
    public ResultVO<String> IndexOutOfBoundsExceptionHandler(Exception e){
        return new ResultVO<>(ResultCode.FAILED,e.getMessage());
    }


}
