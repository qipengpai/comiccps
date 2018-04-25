package com.qpp.comiccps.system;

public class ActionUrl {

    // Cps用户登录
    public static final String CPS_ADMIN_LOGIN="/crxl/qpp/comicCps/cpsAdminLogin";
    // 创建Cps用户
    public static final String CPS_CREATE_ADMIN="/crxl/qpp/comicCps/createCpsAdmin";
    // 查询所有Cps用户
    public static final String GET_ALL_CPS_ADMIN="/crxl/qpp/comicCps/getAllCpsAdmin";



    //（条件）分页查询用户列表
    public static final String ADMIN_GET_ALL_USER="/crxl/qpp/comicCps/admin/get/getAllUser";
    //（条件）分页查询用户订单列表
    public static final String ADMIN_GET_ALL_USER_ORDER="/crxl/qpp/comicCps/admin/get/getAllUserOrder";
    //（条件）分页查询用户反馈列表
    public static final String ADMIN_GET_ALL_FEED_BACK="/crxl/qpp/comicCps/admin/get/getAllFeedBack";



    //（条件）分页查询分销商列表
    public static final String ADMIN_GET_ALL_DISTRIBUTOR="/crxl/qpp/comicCps/get/getAllDistributor";
    // 增加分销商
    public static final String ADMIN_ADD_DISTRIBUTOR="/crxl/qpp/comicCps/addDistributor";
    // 修改分销商
    public static final String ADMIN_UPDATE_DISTRIBUTOR="/crxl/qpp/comicCps/updateDistributor";
    // 根据id查询分销商
    public static final String ADMIN_GET_DISTRIBUTOR_BYID="/crxl/qpp/comicCps/getDistributorId";
    // 解除绑定Cps用户与分销商
    public static final String BINDING_CPS_DISTRIBUTOR="/crxl/qpp/comicCps/bindingCpsAndDistributor";

    // (条件)分页查看分销商结算单
    public static final String DISTRIBUTOR_WITHDRAWALS_GET="/crxl/qpp/comicCps/distributor/selectWitndrawals";
    // 付款后完成结算单
    public static final String DISTRIBUTOR_WITHDRAWALS_FINISH = "/crxl/qpp/comicCps/finish/distributor/finishWitndrawals";


    // （条件）分页咔咔豆订单查询
    public static final String SELECT_CARTOON_MALL_ORDER = "/crxl/qpp/comicCps/selectKakaBeanOrder";
    // （条件）咔咔豆收益
    public static final String SELECT_CARTOON_MALL_ORDER_TOTAL = "/crxl/qpp/comicCps/selectKakaOrderTotal";



    // 后台查询各公众号现金收益(新)
    public static final String SELECT_CARTOON_PROFIT_NEW = "/crxl/qpp/comicCps/select/cartoon/profit/new";

}
