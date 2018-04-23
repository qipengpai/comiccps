package com.qpp.comiccps.system;

public class ActionUrl {

    // Cps用户登录
    public static final String CPS_ADMIN_LOGIN="/crxl/qpp/comicCps/cpsAdminLogin";
    // 创建Cps用户
    public static final String CPS_CREATE_ADMIN="/crxl/qpp/comicCps/createCpsAdmin";
    // 绑定(解除绑定)Cps用户与分销商
    public static final String BINDING_CPS_DISTRIBUTOR="/crxl/qpp/comicCps/bindingCpsAndDistributor";
    // 查询所有Cps用户
    public static final String GET_ALL_CPS_ADMIN="/crxl/qpp/comicCps/getAllCpsAdmin";



    //（条件）分页查询用户列表
    public static final String ADMIN_GET_ALL_USER="/crxl/qpp/comicCps/admin/get/getAllUser";
    //（条件）分页查询用户订单列表
    public static final String ADMIN_GET_ALL_USER_ORDER="/crxl/qpp/comicCps/admin/get/getAllUserOrder";
    //（条件）分页查询用户反馈列表
    public static final String ADMIN_GET_ALL_FEED_BACK="/crxl/qpp/comicCps/admin/get/getAllFeedBack";



    //（条件）分页查询分销商列表
    public static final String ADMIN_GET_ALL_DISTRIBUTOR="/crxl/qpp/comicCps/admin/get/getAllDistributor";
    // 增加分销商
    public static final String ADMIN_ADD_DISTRIBUTOR="/crxl/qpp/comicCps/admin/addDistributor";
    // 修改分销商
    public static final String ADMIN_UPDATE_DISTRIBUTOR="/crxl/qpp/comicCps/admin/updateDistributor";
    // 根据id查询分销商
    public static final String ADMIN_GET_DISTRIBUTOR_BYID="/crxl/qpp/comicCps/admin/getDistributorId";




}
