package com.qpp.comiccps.shiro;


import com.qpp.comiccps.basics.entity.Admin;
import com.qpp.comiccps.basics.entity.CpsRole;
import com.qpp.comiccps.basics.entity.Menu;
import com.qpp.comiccps.basics.service.impl.AdminServiceImpl;
import com.qpp.comiccps.tool.JWTUtil;
import com.qpp.comiccps.tool.ParaClick;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class MyRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LogManager.getLogger(MyRealm.class);

    private AdminServiceImpl adminServiceImpl;

    @Autowired
    public void setUserService(AdminServiceImpl adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }

    /**
     *    大坑！，必须重写此方法，不然Shiro会报错
     *
     * @author pengpai
     * @date 2018/3/8 13:50
     * @param token
     * @return boolean
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 此方法调用  hasRole,hasPermission的时候才会进行回调.
     *
     * 权限信息.(授权):
     * 1、如果用户正常退出，缓存自动清空；
     * 2、如果用户非正常退出，缓存自动清空；
     * 3、如果我们修改了用户的权限，而用户不退出系统，修改的权限无法立即生效。
     * （需要手动编程进行实现；放在service进行调用）
     * 在权限修改后调用realm中的方法，realm已经由spring管理，所以从spring中获取realm实例，
     * 调用clearCached方法；
     * :Authorization 是授权访问控制，用于对用户进行的操作授权，证明该用户是否允许进行当前操作，如访问某个链接，某个资源文件等。
     * @author pengpai
     * @date 2018/3/8 13:50
     * @param
     * @return
     */

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        /*
        * 当没有使用缓存的时候，不断刷新页面的话，这个代码会不断执行，
        * 当其实没有必要每次都重新设置权限信息，所以我们需要放到缓存中进行管理；
        * 当放到缓存中时，这样的话，doGetAuthorizationInfo就只会执行一次了，
        * 缓存过期之后会再次执行。
        * logger.info("后台权限校验-->AdminShiroRealm.doGetAuthorizationInfo()");
        * @RequiresPermissions(value={“xxx:xxx”,”xxx:xxx”},logical=Logical.OR
        */
        String username = JWTUtil.getUsername(principals.toString());
        Admin adminUser = adminServiceImpl.getCpsAdminRoleMenu(username);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        if (ParaClick.clickList(adminUser.getRoleList())) {
            for (CpsRole cpsRole : adminUser.getRoleList()) {
                simpleAuthorizationInfo.addRole(cpsRole.getRoleDesc());
                for (Menu menu : cpsRole.getMenuList()) {
                    simpleAuthorizationInfo.addStringPermission(menu.getMenuCode());
                }
            }
        }
        return simpleAuthorizationInfo;
}

    /**
     *   默认使用此方法进行用户名正确与否验证，
     *   错误抛出异常即可。
     * @author pengpai
     * @date 2018/3/8 13:50
     * @param auth
     * @return org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null)
            throw new AuthenticationException("token invalid");
        Admin admin = adminServiceImpl.getCpsAdmin(username);
        if (admin == null)
            throw new AuthenticationException("User didn't existed!");
        if (! JWTUtil.verify(token, username, admin.getPassword()))
            throw new AuthenticationException("Username or password error");
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }


}
