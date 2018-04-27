package com.qpp.comiccps.basics.controller;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.UserEntity;
import com.qpp.comiccps.basics.service.impl.UserEntityServiceImpl;
import com.qpp.comiccps.system.ActionUrl;
import com.qpp.comiccps.tool.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEntityController {


    @Autowired
    private UserEntityServiceImpl userEntityService;



    /**
     *    （条件）分页查询用户列表
     *
     * @author pengpai
     * @date 2018/4/23 11:10
     * @param pageInfo
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("（条件）分页查询用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "condition", value = "查詢条件", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", required = true, dataType = "String", paramType = "query")
    })
    @PostMapping(value = ActionUrl.ADMIN_GET_ALL_USER)
    @RequiresPermissions("userEntity:select")
    public Model getUserEntity(PageInfo pageInfo)
            throws Exception {
        //  查询平台用户列表
        Page<UserEntity> list;
        if(ParaClick.clickString(pageInfo.getCondition())){
            list= userEntityService.getAllUserEntity(pageInfo);
        }else{
            list= userEntityService.getAllUserEntityByCondition(pageInfo);
        }
        if (!ParaClick.clickList(list))
            return new Model(500, "查询失败");
        for (UserEntity userEntity:list) {
            userEntity.setCity(StringToInt.toString(userEntity.getCity()));
            if(!ParaClick.clickString(userEntity.getStartdate())&&!ParaClick.clickString(userEntity.getEnddate())) {
                userEntity.setStartdate(userEntity.getStartdate().substring(0, userEntity.getStartdate().lastIndexOf(" ")));
                userEntity.setEnddate(userEntity.getEnddate().substring(0, userEntity.getEnddate().lastIndexOf(" ")));
            }
            try {
                userEntity.setUsername(StringToInt.toString(userEntity.getUsername()));
            } catch (Exception e) {
                userEntity.setNickname("漫画用户");
            }
        }
        PageInfo<UserEntity> pageInfos = new PageInfo<>(list);
        return new Model(pageInfos);
    }
}
