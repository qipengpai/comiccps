package com.qpp.comiccps.basics.controller;

import com.qpp.comiccps.basics.entity.Admin;
import com.qpp.comiccps.basics.service.impl.AdminServiceImpl;
import com.qpp.comiccps.system.ActionUrl;
import com.qpp.comiccps.tool.JWTUtil;
import com.qpp.comiccps.tool.MD5;
import com.qpp.comiccps.tool.Model;
import com.qpp.comiccps.tool.ParaClick;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    /**
     * cps 用户登录
     *
     * @param admin
     * @return com.qpp.comiccps.tool.Model
     * @author pengpai
     * @date 2018/4/18 21:06
     */

    @ApiOperation(value = "CPS用戶登錄", notes = "CPS用戶登錄")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
    })
    @PostMapping(value = ActionUrl.CPS_ADMIN_LOGIN)
    public Model userRegisterSend(HttpServletRequest request, Admin admin)
            throws Exception {
        if (ParaClick.clickString(admin.getUsername()))
            return new Model(500, "请输入账号");
        if (ParaClick.clickString(admin.getPassword()))
            return new Model(500, "请输入密码");
        //  登录
        Admin admin1 = adminServiceImpl
                .adminLogin(admin);
        if (admin1 == null)
            return new Model(500, "用户名或密码错误");
        //System.out.println(JWTUtil.sign(distributor.getUsername(), MD5.getMd5(distributor.getUserpwd())));
        request.getSession().setAttribute("userInfo", admin1.getUid());
        request.getSession().setMaxInactiveInterval(1800);
        Map<String,Object> map =new HashMap<>();
        map.put("userName",admin1.getUsername());
        map.put("isSystem",admin1.getIsSystem());
        return new Model(map, JWTUtil.sign(admin1.getUsername(), admin1.getPassword()));
    }

    /**
     *    创建Cps用户
     *
     * @author pengpai
     * @date 2018/4/21 11:14
     * @param admin
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("CPS创建用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String", paramType = "query"),
    })
    @PostMapping(value = ActionUrl.CPS_CREATE_ADMIN)
    @RequiresAuthentication
    @RequiresPermissions("admin:create")
    public Model createCpsAdmin(Admin admin)
            throws Exception {
        if (ParaClick.clickString(admin.getUsername()))
            return new Model(500, "请输入账号");
        if (ParaClick.clickString(admin.getPassword()))
            return new Model(500, "请输入密码");
        //  登录
        boolean flag = adminServiceImpl
                .createCpsAdmin(admin);
        if (!flag)
            return new Model(500, "创建Cps用户失败");
        return new Model(200, "创建Cps用户成功");
    }

    /**
     *    查询所有CPS用户
     *
     * @author pengpai
     * @date 2018/4/23 17:10
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("查询所有CPS用户")
    @PostMapping(value = ActionUrl.GET_ALL_CPS_ADMIN)
    @RequiresAuthentication
    @RequiresPermissions("admin:select")
    public Model getCpsAdmin()
            throws Exception {
        //  查询所有CPS用户
        List<Admin> admin = adminServiceImpl.getAllCpsAdmin();
        if (!ParaClick.clickList(admin))
            return new Model(500, "查询所有CPS用户失败");
        return new Model(admin);
    }
}
