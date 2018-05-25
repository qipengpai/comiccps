package com.qpp.comiccps.basics.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qpp.comiccps.basics.dao.DistributorMapper;
import com.qpp.comiccps.basics.dao.DistributorWithdrawalsMapper;
import com.qpp.comiccps.basics.entity.Distributor;
import com.qpp.comiccps.basics.entity.DistributorWithdrawals;
import com.qpp.comiccps.basics.entity.data.UserOrderProfitNew;
import com.qpp.comiccps.basics.entity.data.WithdrawalsStatistics;
import com.qpp.comiccps.exception.BusinessException;
import com.qpp.comiccps.tool.ArithUtil;
import com.qpp.comiccps.tool.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DistributorWithdrawalsServiceImpl {

    @Autowired
    private DistributorWithdrawalsMapper distributorWithdrawalsMapper;

    @Autowired
    private DistributorMapper distributorMapper;


    /**
     *    （条件）分页查看分销商结算单
     *
     * @author pengpai
     * @date 2018/4/24 11:33
     * @param pageInfo
     * @return com.github.pagehelper.Page<com.qpp.comiccps.basics.entity.DistributorWithdrawals>
     */
    public Page<DistributorWithdrawals> selectDistributorWithdrawals(String withdrawalsState,PageInfo pageInfo,String uid) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        return distributorWithdrawalsMapper.selectDistributorWithdrawals(withdrawalsState,pageInfo.getStartDate(),
                pageInfo.getCondition(),pageInfo.getEndDate(),uid);
    }

    /**  
     *    打款后完成结算单
     *   
     * @author pengpai 
     * @date 2018/4/24 13:11
     * @param id
     * @return boolean  
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor=Exception.class)
    public boolean finishDistributorWithdrawals(String id) {
        // 修改结算单状态
        if (distributorWithdrawalsMapper.finishDistributorWithdrawals(id)<1)
            return false;
        // 查询结算单
        DistributorWithdrawals distributorWithdrawals=distributorWithdrawalsMapper.selectByPrimaryKey(id);
        if (distributorWithdrawals == null)
            throw new BusinessException("回滚异常");
        // 查询分销商
        Distributor distributor = distributorMapper.selectByPrimaryKey(distributorWithdrawals.getDistridutionid());
        if (distributor == null)
            throw new BusinessException("回滚异常");
        // 增加已领取金额减少余额
        int 亓澎湃 = distributorMapper.updateOverReCharge(ArithUtil.add(distributor.getOverrecharge(),distributorWithdrawals.getWithdrawalsmoney()),
                ArithUtil.sub(distributor.getBalance(), distributorWithdrawals.getWithdrawalsmoney()),distributorWithdrawals.getDistridutionid());
        if (亓澎湃<1)
            throw new BusinessException("回滚异常");
        return true;
    }

    /**
     *    结算单求和
     *
     * @author pengpai
     * @date 2018/4/25 11:59
     * @param withdrawalsState, pageInfo, uid
     * @return java.lang.Double
     */
    public Double selectSumDistributorWithdrawals(String withdrawalsState, PageInfo pageInfo, String uid) {
        return distributorWithdrawalsMapper.selectSumDistributorWithdrawals(withdrawalsState,pageInfo,uid);
    }

    /**
     *    分页条件查询现金收益列表
     *
     * @author pengpai
     * @date 2018/5/7 11:53
     * @param pageInfo1
     * @return com.github.pagehelper.Page<com.qpp.comiccps.basics.entity.data.UserOrderProfitNew>
     */
    public Page<WithdrawalsStatistics> selectOrderProfitNew(PageInfo pageInfo1) {
        PageHelper.startPage(pageInfo1.getPageNum(),pageInfo1.getPageSize());
        return distributorWithdrawalsMapper.selectOrderProfitNew(pageInfo1);
    }
}
