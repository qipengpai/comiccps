package com.qpp.comiccps.basics.controller;

import com.github.pagehelper.Page;
import com.qpp.comiccps.basics.entity.Admin;
import com.qpp.comiccps.basics.entity.DistributorWithdrawals;
import com.qpp.comiccps.basics.service.impl.AdminServiceImpl;
import com.qpp.comiccps.basics.service.impl.DistributorServiceImpl;
import com.qpp.comiccps.basics.service.impl.DistributorWithdrawalsServiceImpl;
import com.qpp.comiccps.system.ActionUrl;
import com.qpp.comiccps.tool.*;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DistributorWithdrawalsController {

    @Autowired
    private DistributorWithdrawalsServiceImpl distributorWithdrawalsService;

    @Autowired
    private AdminServiceImpl adminService;

    /**
     *    （条件）分页查看分销商结算单
     *
     * @author pengpai
     * @date 2018/4/24 11:32
     * @param pageInfo
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("（条件）分页查看分销商结算单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "condition", value = "查詢条件", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "pageSize", value = "每页的数量", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始时间",  dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "结束时间", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "withdrawalsState", value = "结算状态", required = true, dataType = "String", paramType = "query"),
    })
    @PostMapping(value = ActionUrl.DISTRIBUTOR_WITHDRAWALS_GET)
    @RequiresPermissions("withdrawals:select")
    public Model getDistributor(HttpServletRequest request, @RequestParam("withdrawalsState") String withdrawalsState, PageInfo pageInfo)
            throws Exception {
        PageInfo pageInfo1;
        try{
            pageInfo1= DateUtil.checkPageInfo(pageInfo);
        }catch (RuntimeException e){
            return new Model(500, "时间有误");
        }
        // 根据用户名获取用户Id
        Admin admin =adminService.getAdminByUserName(JWTUtil.getUsername(request.getHeader("Authorization").toString()));
        if (withdrawalsState.equals("2"))
            withdrawalsState=null;
        //  分页查询分销商结算单列表
        Page<DistributorWithdrawals> list = distributorWithdrawalsService.selectDistributorWithdrawals(withdrawalsState,pageInfo1,admin.getUid());
        if (!ParaClick.clickList(list))
            return new Model(500, "暂无数据");
        for (DistributorWithdrawals distributorWithdrawals:list) {
            distributorWithdrawals.setWithdrawalsdate(distributorWithdrawals.getWithdrawalsdate().substring(0,distributorWithdrawals.getWithdrawalsdate().lastIndexOf(" ")));
        }
        // 结算单求和
        //Double sum = distributorWithdrawalsService.selectSumDistributorWithdrawals(withdrawalsState,pageInfo,admin.getUid());
        PageInfo<DistributorWithdrawals> pageInfos = new PageInfo<>(list);
        return new Model(pageInfos);
    }


    /**
     *    打款后完成结算单
     *
     * @author pengpai
     * @date 2018/4/24 13:07
     * @param id
     * @return com.qpp.comiccps.tool.Model
     */
    @ApiOperation("打款后完成结算单")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "String", paramType = "query")
    @PostMapping(value = ActionUrl.DISTRIBUTOR_WITHDRAWALS_FINISH)
    @RequiresAuthentication
    @RequiresPermissions("withdrawals:finish")
    public Model finishDistributorWithdrawals(@RequestParam("id") String id)
            throws Exception {
        //  分页查询分销商列表
        try{
            boolean flag= distributorWithdrawalsService.finishDistributorWithdrawals(id);
            if (!flag)
                return new Model(500,"结算失败");
        }catch (RuntimeException e){
            e.printStackTrace();
            return new Model(500,"结算失败");
        }
        return new Model(200,"结算成功");
    }
}
