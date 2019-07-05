package cn.wyx.controller.exception;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: wyx
 * @Date: 2019/7/5 14：33
 * @Version 1.0
 * <p>
 * 如果任意的控制器方法抛出了 UnauthorizedException，
 * 不管这个方法位于哪个控制器中，都会调用这个duplicateSpittleHandler()方法来处理异常。
 * 可以像编写@RequestMapping注解的方法那样来编写 @ExceptionHandler注解的方法。
 */
@ControllerAdvice
/**
 * /@ControllerAdvice注解能够将通用的
 * /@ExceptionHandler、@ InitBinder和 @ModelAttributes方法收集到一个类中，并应用到所有控制器上
 */
public class DefaultExceptionHandler {

    /**
     * 权限校验失败异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler({UnauthorizedException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception", e);
        mv.setViewName("login");
        return mv;
    }


//    /**
//     * 权限校验失败异常
//     *
//     * @param request
//     * @param e
//     * @return
//     */
//    @ExceptionHandler({UnauthorizedException.class})
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ModelAndView processUnauthenticatedException(NativeWebRequest request, UnauthorizedException e) {
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("exception", e);
//        mv.setViewName("login");
//        return mv;
//    }
}
