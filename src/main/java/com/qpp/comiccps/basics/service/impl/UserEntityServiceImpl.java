package com.qpp.comiccps.basics.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qpp.comiccps.basics.dao.UserEntityMapper;
import com.qpp.comiccps.basics.entity.UserEntity;
import com.qpp.comiccps.tool.PageInfo;
import com.qpp.comiccps.tool.ParaClick;
import com.qpp.comiccps.tool.StringToInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityServiceImpl {

    @Autowired
    private UserEntityMapper userEntityMapper;

    /**
     *  分页查询用户列表
     *
     * @param pageInfo
     * @return com.github.pagehelper.Page<com.qpp.comiccps.basics.entity.UserEntity>
     * @author pengpai
     * @date 2018/4/23 11:13
     */
    public Page<UserEntity> getAllUserEntity(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        if (pageInfo.getPageNum()>1000)
            return userEntityMapper.getAllUserEntityBetter1000(pageInfo);
        return userEntityMapper.getAllUserEntity(pageInfo);
    }

    /**
     *   （ 条件）分页查询用户列表
     *
     * @author pengpai
     * @date 2018/4/27 14:04
     * @param pageInfo
     * @return com.github.pagehelper.Page<com.qpp.comiccps.basics.entity.UserEntity>
     */
    public Page<UserEntity> getAllUserEntityByCondition(PageInfo pageInfo) {
        pageInfo.setCondition2(StringToInt.toInt(pageInfo.getCondition()));
        return userEntityMapper.getConditionUserEntity(pageInfo);
    }
}
