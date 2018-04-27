package com.qpp.comiccps.basics.controller.exception;

import com.qpp.comiccps.tool.Model;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public static final String DEFAULT_ERROR_VIEW = "error";
    /**
     *    捕捉shiro的异常
     *
     * @author pengpai
     * @date 2018/3/7 13:21
     * @param e
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public Model handle401(ShiroException e) {
        System.out.println("1");
        return new Model(401, e.getMessage(), null);
    }
    /**
     *    捕捉shiro的异常
     *
     * @author pengpai
     * @date 2018/3/7 13:21
     * @param e
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthorizationException.class)
    public Model handle401(AuthorizationException e) {
        System.out.println("3");
        return new Model(401, e.getMessage(), null);
    }
    /**
     *    捕捉UnauthorizedException
     *
     * @author pengpai
     * @date 2018/3/7 13:22
     * @param
     * @return com.crxl.qpp.comicdis.tool.Model
     */
    @ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "暂无权限")
    @ExceptionHandler(UnauthorizedException.class)
    public Model handle403() {
        System.out.println("2");
        return new Model(403, "Unauthorized", null);
    }



    /**
     *    全局异常处理
     *
     * @author pengpai
     * @date 2018/3/7 13:21
     * @param , e
     * @return org.springframework.web.servlet.ModelAndView
     */
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName(DEFAULT_ERROR_VIEW);
//        return mav;
//    }
    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Model globalException(HttpServletRequest request, Throwable ex) {
        return new Model(getStatus(request).value(), ex.getMessage(), null);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
