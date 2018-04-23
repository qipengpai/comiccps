package com.qpp.comiccps.basics.dao;

import com.qpp.comiccps.basics.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    int deleteByPrimaryKey(String uid);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    //  cps用户登录
    Admin cpsAdminLogin(@Param("username") String username, @Param("password")String password);

    //  为生成用户token
    Admin getCpsAdmin(@Param("username")String username);

    //  创建Cps用户
    int createCpsAdmin(@Param("username")String username,
                       @Param("password") String password, @Param("state")int state,
                       @Param("date")String date);

    // 查询所有CPS用户
    List<Admin> getAllCpsAdmin();

    // 解除绑定前验证密码
    Admin getAdminByCheckUser(@Param("userType")String userType,@Param("password")String password);
}