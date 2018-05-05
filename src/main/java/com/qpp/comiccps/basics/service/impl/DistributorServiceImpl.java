package com.qpp.comiccps.basics.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qpp.comiccps.basics.dao.DistributorMapper;
import com.qpp.comiccps.basics.entity.Admin;
import com.qpp.comiccps.basics.entity.Distributor;
import com.qpp.comiccps.basics.entity.data.DistributorData;
import com.qpp.comiccps.tool.DateUtil;
import com.qpp.comiccps.tool.MD5;
import com.qpp.comiccps.tool.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistributorServiceImpl {

    @Autowired
    private DistributorMapper distributorMapper;

    /**
     *    （条件）分页查询分销商列表
     *
     * @author pengpai
     * @date 2018/4/23 16:45
     * @param pageInfo
     * @return com.github.pagehelper.Page<com.qpp.comiccps.basics.entity.Distributor>
     */
    public Page<Distributor> getDistributor(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        return distributorMapper.getDistributor(pageInfo);
    }

    /**
     *    增加分销商并绑定CPS
     *
     * @author pengpai
     * @date  17:33
     * @param distributorData
     * @return int
     */
    public int addDistributor(DistributorData distributorData) {
        distributorData.setWithdrawalstype(1);
        distributorData.setState(1);
        distributorData.setAllrecharge(0.0);
        distributorData.setBalance(0.0);
        distributorData.setOverrecharge(0.0);
        distributorData.setImpldate(DateUtil.getdate_yyyy_MM_dd_HH_MM_SS());
        distributorData.setLastlogindate(DateUtil.getdate_yyyy_MM_dd_HH_MM_SS());
        distributorData.setQd(distributorData.getQd().toUpperCase());
        distributorData.setUserpwd(MD5.getMd5(distributorData.getUserpwd().trim()));
        return distributorMapper.addDistributor(distributorData);
    }

    /**
     *    修改分销商或 修改绑定CPS
     *
     * @author pengpai
     * @date 2018/4/23 19:07
     * @param distributorData
     * @return int
     */
    public int updateDistributor(DistributorData distributorData) {
        distributorData.setImpldate(DateUtil.getdate_yyyy_MM_dd_HH_MM_SS());
        return distributorMapper.updateDistributor(distributorData);
    }

    /**
     *   根据id查询分销商
     *
     * @author pengpai
     * @date 2018/4/23 19:17
     * @param id
     * @return com.qpp.comiccps.basics.entity.Distributor
     */
    public Distributor getDistributorById(String id) {
        return distributorMapper.selectByPrimaryKey(id);
    }

    /**
     *    解除绑定
     *
     * @author pengpai
     * @date 2018/4/23 19:40
     * @param id
     * @return int
     */
    public int updateDistributorNull(String id) {
        return distributorMapper.updateDistributorNull(id,null);
    }


    /**
     *    修改分销商状态为下架
     *
     * @author pengpai
     * @date 2018/5/4 11:02
     * @param id
     * @return int
     */
    public int updateDistributorState(String id) {
        return distributorMapper.updateDistributorState(id,0);
    }
}
