package top.nilaoda.apps.cms.util;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @author nilaoda
 * @version 1.0
 * @description 统一拦截 异常
 * @date 2019/12/20
 * @time 9:54
 */
@RestControllerAdvice
public class CustomerExceptionHandler {
    //拦截异常信息
    @ExceptionHandler(value = Exception.class)
    public Message handler(Exception exception) {
        exception.printStackTrace();
        //将拦截到的异常信息封装为Message 交给Controller返回前端
        String msg = "后台系统异常";
        if (exception instanceof CustomerException ||
                exception instanceof ConstraintViolationException) {
            msg = exception.getMessage();
        }
        return MessageUtil.error(msg);
    }
}
