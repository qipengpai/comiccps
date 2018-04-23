package com.qpp.comiccps.basics.service.impl;

import com.qpp.comiccps.basics.dao.AdminMapper;
import com.qpp.comiccps.basics.entity.Admin;
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
        String password= MD5.getMd5(admin.getPassword());
        int index =adminMapper.createCpsAdmin(admin.getUsername(),password,1, DateUtil.getdate_yyyy_MM_dd_HH_MM_SS());
        if (index<1)
            return false;
        return true;
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
}
