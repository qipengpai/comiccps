package com.qpp.comiccps.basics.service.impl;

import com.qpp.comiccps.basics.dao.AdminMapper;
import com.qpp.comiccps.basics.dao.AdminRoleMapper;
import com.qpp.comiccps.basics.entity.Admin;
import com.qpp.comiccps.basics.entity.AdminRoleKey;
import com.qpp.comiccps.exception.BusinessException;
import com.qpp.comiccps.tool.DateUtil;
import com.qpp.comiccps.tool.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    /**
     *    cps 用户登录
     *
     * @author pengpai
     * @date 2018/4/18 21:18
     * @param admin
     * @return com.qpp.comiccps.basics.entity.Admin
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin adminLogin(Admin admin) {
        String userPwd= MD5.getMd5(admin.getPassword());
        Admin admin1 =adminMapper.cpsAdminLogin(admin.getUsername(),userPwd);
        if (admin1==null)
            return admin1;
        return admin1;
    }

    /**
     *    为生成用户token
     *
     * @author pengpai
     * @date 2018/4/18 21:23
     * @param username
     * @return com.qpp.comiccps.basics.entity.Admin
     */
    public Admin getCpsAdmin(String username) {
        return adminMapper.getCpsAdmin(username);
    }

    /**
     *    创建Cps用户
     *
     * @author pengpai
     * @date 2018/4/21 11:30
     * @param admin
     * @return boolean
     */
    public boolean createCpsAdmin(Admin admin) {
        boolean flag=false;
        try {
            String password = MD5.getMd5(admin.getPassword());
            //创建cps用户
            Admin admin1=new Admin();
            admin1.setUsername(admin.getUsername());
            admin1.setPassword(password);
            admin1.setIsSystem("yunying");
            admin1.setSalt(password);
            admin1.setState(1);
            admin1.setUpdatedAt(DateUtil.getdate_yyyy_MM_dd_HH_MM_SS());
            admin1.setCreatedAt(DateUtil.getdate_yyyy_MM_dd_HH_MM_SS());
            //int index =adminMapper.createCpsAdmin(admin.getUsername(),password,1, DateUtil.getdate_yyyy_MM_dd_HH_MM_SS());
            int index=adminMapper.insertSelective(admin1);
            if (index<1)
                return flag;
            System.out.println("-------------"+admin1.getUid()+"----------");
            AdminRoleKey adminRole=new AdminRoleKey();
            adminRole.setAdminId(admin1.getUid());
            adminRole.setRoleId("29aafd8ab08c4078bec439c8d9fb7e04");
            int index1 =adminRoleMapper.insert(adminRole);
            if (index1<1)
                return flag;
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("异常");
        }
        return flag;
    }
    /**
     *    查询所有CPS用户
     *
     * @author pengpai
     * @date 2018/4/23 17:12
     * @return java.util.List<com.qpp.comiccps.basics.entity.Admin>
     */
    public List<Admin> getAllCpsAdmin() {
        return adminMapper.getAllCpsAdmin();
    }


    /**
     *    解除绑定前验证密码
     *
     * @author pengpai
     * @date 2018/4/23 19:47
     * @param userType, password
     * @return com.qpp.comiccps.basics.entity.Admin
     */
    public Admin checkUser(String userType, String password) {
        return adminMapper.getAdminByCheckUser(userType,MD5.getMd5(password));
    }

    /**
     *    获取角色权限
     *
     * @author pengpai
     * @date 2018/4/26 14:25
     * @param username
     * @return com.qpp.comiccps.basics.entity.Admin
     */
    public Admin getCpsAdminRoleMenu(String username) {
        return adminMapper.getCpsAdminRoleMenu(username);
    }

    /**
     *    根据用户名获取用户Id
     *
     * @author pengpai
     * @date 2018/4/28 11:39
     * @param authorization
     * @return com.qpp.comiccps.basics.entity.Admin
     */
    public Admin getAdminByUserName(String authorization) {
        return adminMapper.getAdminByUserName(authorization);
    }
}
