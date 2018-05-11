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

    // 获取角色权限
    Admin getCpsAdminRoleMenu(@Param("username")String username);

    // 根据用户名获取用户Id
    Admin getAdminByUserName(@Param("authorization")String authorization);

    // 查詢所有可用狀態cps 并且已經關連公衆號
    List<Admin> getAllCpsAdminState();

    // cps 总数
    int getCpsCount(@Param("uid") String uid);

    // Cps用户修改密码
    int updatePassword(@Param("username")String username,
                       @Param("password")String password,@Param("newPassword") String newPassword);
}