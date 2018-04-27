package com.qpp.comiccps.basics.controller.exception;

import com.qpp.comiccps.tool.Model;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomException {
    /**
     * 401
     *
     * @param 【】
     * @return com.qpp.comiccps.tool.Model
     * @author pengpai
     * @date 2018/4/18 21:08
     */
    @ApiOperation(value = "/401认证失败", notes = "/401认证失败")
    @RequestMapping(path = "/401")
    @ResponseStatus(value =HttpStatus.UNAUTHORIZED,reason = "认证失败")
    public Model unauthorized() {
        System.out.println("4");
        return new Model(401, "Unauthorized", null);
    }

    /**
     * 403
     *
     * @param 【】
     * @return com.qpp.comiccps.tool.Model
     * @author pengpai
     * @date 2018/4/18 21:08
     */
    @ApiOperation(value = "/403授权失败", notes = "/403授权失败")
    @RequestMapping(path = "/403")
    @ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "暂无权限")
    public Model unauthorization() {
        System.out.println("5");
        return new Model(403, "unauthorization", null);
    }


}
