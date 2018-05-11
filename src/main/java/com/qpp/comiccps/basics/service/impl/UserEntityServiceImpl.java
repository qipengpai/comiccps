package com.qpp.comiccps.basics.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qpp.comiccps.basics.dao.UserEntityMapper;
import com.qpp.comiccps.basics.entity.UserEntity;
import com.qpp.comiccps.basics.entity.data.AdminFansData;
import com.qpp.comiccps.basics.entity.data.UserOrderProfitNew;
import com.qpp.comiccps.tool.PageInfo;
import com.qpp.comiccps.tool.ParaClick;
import com.qpp.comiccps.tool.StringToInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (pageInfo.getPageNum()>2000)
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

    /**
     *   公众号粉丝分布
     *
     * @author pengpai
     * @date 2018/5/3 14:52
     * @return java.util.List<com.qpp.comiccps.basics.entity.data.AdminFansData>
     */
    public Page<UserOrderProfitNew> selectUserDistribution(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        return userEntityMapper.selectUserDistribution(pageInfo);
    }

    /**
     *    公众号粉丝性別
     *
     * @author pengpai
     * @date 2018/5/3 15:14
     * @return java.util.List<com.qpp.comiccps.basics.entity.data.AdminFansData>
     */
    public List<AdminFansData> selectUserSex() {
        return userEntityMapper.selectUserSex();
    }
}
