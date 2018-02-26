package com.jqq.handle;
import com.jqq.demain.Result;
import com.jqq.exception.JqqException;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lql on 2017/02/12.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof JqqException){
            JqqException jqqException = (JqqException) e;
            return Result.error(jqqException.getCode(),jqqException.getMessage());
        }else {
            logger.error("【系统异常】{}",e);
            return Result.error(-1,"未知错误");
        }
    }
}
