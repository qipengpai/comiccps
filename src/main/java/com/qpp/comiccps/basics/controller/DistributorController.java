package com.qpp.comiccps.basics.controller;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.Admin;
import com.qpp.comiccps.basics.entity.Distributor;
import com.qpp.comiccps.basics.entity.data.DistributorData;
import com.qpp.comiccps.basics.service.impl.AdminServiceImpl;
import com.qpp.comiccps.basics.service.impl.DistributorServiceImpl;
import com.qpp.comiccps.system.ActionUrl;
import com.qpp.comiccps.tool.Model;
import com.qpp.comiccps.tool.PageInfo;
import com.qpp.comiccps.tool.ParaClick;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistributorController {

    @Autowired
    private DistributorServiceImpl distributorService;
    @Autowired
    private AdminServiceImpl adminService;


    /**
     * （条件）分页查询分销商列表
     *
     * @param pageInfo
     * @return com.qpp.comiccps.tool.Model
     * @author pengpai
     * @date 2018/4/23 16:44
     */
    @ApiOperation("（条件）分页查询分销商列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "condition", value = "查詢条件", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping(value = ActionUrl.ADMIN_GET_ALL_DISTRIBUTOR)
    @RequiresAuthentication
    @RequiresPermissions("distributor:select")
    public Model getDistributor(PageInfo pageInfo)
            throws Exception {
        //  分页查询分销商列表
        Page<Distributor> list = distributorService.getDistributor(pageInfo);
        if (!ParaClick.clickList(list))
            return new Model(500, "查询失败");
        PageInfo<Distributor> pageInfos = new PageInfo<>(list);
        return new Model(pageInfos);
    }


    /**
     * 增加分销商并绑定CPS
     *
     * @param distributorData
     * @return com.qpp.comiccps.tool.Model
     * @author pengpai
     * @date 2018/4/23 17:24
     */
    @ApiOperation("增加分销商并绑定CPS")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "账号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "qd", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "userpwd", value = "密碼", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "nickname", value = "用户姓名", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "accountnum", value = "付款账号", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "accountname", value = "每页的数量", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "paytype", value = "用户支付类型", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "proportion", value = "分成比例", required = true, dataType = "Double", paramType = "query"),
            @ApiImplicitParam(name = "usertype", value = "cps用戶Id", required = true, dataType = "String", paramType = "query"),
    })
    @PostMapping(value = ActionUrl.ADMIN_ADD_DISTRIBUTOR)
    @RequiresAuthentication
    @RequiresPermissions("distributor:create")
    public Model addDistributor(DistributorData distributorData)
            throws Exception {
        //  增加分销商
        int index = distributorService.addDistributor(distributorData);
        if (index < 1)
            return new Model(500, "增加失败");
        return new Model(200, "增加成功");
    }


    /**
     * 修改分销商或 修改绑定CPS
     *
     * @param distributorData
     * @return com.qpp.comiccps.tool.Model
     * @author pengpai
     * @date 2018/4/23 19:03
     */
    @ApiOperation("修改分销商或 修改绑定CPS")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "state", value = "状态", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "username", value = "账号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "qd", value = "当前页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "nickname", value = "用户姓名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "手机号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "邮箱", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "accountnum", value = "付款账号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "accountname", value = "每页的数量", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "paytype", value = "用户支付类型", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "proportion", value = "分成比例", dataType = "Double", paramType = "query"),
            @ApiImplicitParam(name = "usertype", value = "cps用戶Id", dataType = "String", paramType = "query"),
    })
    @PostMapping(value = ActionUrl.ADMIN_UPDATE_DISTRIBUTOR)
    @RequiresAuthentication
    @RequiresPermissions("distributor:create")
    public Model updateDistributor(DistributorData distributorData)
            throws Exception {
        if (!ParaClick.clickString(distributorData.getId()))
            return new Model(500, "ID为空");
        //  修改分销商
        int index = distributorService.updateDistributor(distributorData);
        if (index < 1)
            return new Model(500, "增加失败");
        return new Model(200, "增加成功");
    }


    /**
     *    根据id查询分销商
     *
     * @author pengpai
     * @date 2018/4/23 19:16
     * @param id
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("根据id查询分销商")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", dataType = "String", required = true, paramType = "query"),
    })
    @PostMapping(value = ActionUrl.ADMIN_GET_DISTRIBUTOR_BYID)
    @RequiresAuthentication
    @RequiresPermissions("distributor:get")
    public Model updateDistributor(@RequestParam("id") String id)
            throws Exception {
        if (!ParaClick.clickString(id))
            return new Model(500, "ID为空");
        //  根据id查询分销商
        Distributor distributor = distributorService.getDistributorById(id);
        if (distributor == null)
            return new Model(500, "查詢失敗");
        return new Model(distributor);
    }

    /**
     *    解除绑定Cps用户与分销商
     *
     * @author pengpai
     * @date 2018/4/23 19:52
     * @param id, password, userType
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("解除绑定Cps用户与分销商")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "userType", value = "adminId", dataType = "String", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", required = true, paramType = "query"),
    })
    @PostMapping(value = ActionUrl.BINDING_CPS_DISTRIBUTOR)
    @RequiresAuthentication
    @RequiresPermissions("distributor:unbind")
    public Model unbindDistributor(@RequestParam("id") String id,
                                   @RequestParam("password") String password,
                                   @RequestParam("userType") String userType)
            throws Exception {
        if (!ParaClick.clickString(id))
            return new Model(500, "ID为空");
        if (!ParaClick.clickString(password))
            return new Model(500, "密码为空");
        Admin admin =adminService.checkUser(userType,password);
        if (admin == null)
            return new Model(500, "密码错误");
        //  根据id查询分销商
        int index = distributorService.updateDistributorNull(id);
        if (index<1)
            return new Model(500, "解除绑定失敗");
        return new Model(200, "解除绑定成功");
    }

}