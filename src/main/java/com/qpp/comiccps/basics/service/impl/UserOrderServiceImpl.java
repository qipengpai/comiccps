package com.qpp.comiccps.basics.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qpp.comiccps.basics.dao.DistributorWithdrawalsMapper;
import com.qpp.comiccps.basics.dao.UserOrderMapper;
import com.qpp.comiccps.basics.entity.UserOrder;
import com.qpp.comiccps.basics.entity.data.UserOrderProfitNew;
import com.qpp.comiccps.basics.entity.data.WithdrawalsStatistics;
import com.qpp.comiccps.exception.BusinessException;
import com.qpp.comiccps.tool.ArithUtil;
import com.qpp.comiccps.tool.PageInfo;
import com.qpp.comiccps.tool.ParaClick;
import com.qpp.comiccps.tool.StringToInt;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.nio.cs.ext.PCK;

import javax.servlet.ServletOutputStream;
import java.util.List;

@Service
public class UserOrderServiceImpl {

    @Autowired
    private UserOrderMapper userOrderMapper;
    @Autowired
    private DistributorWithdrawalsMapper distributorWithdrawalsMapper;
    /**
     *    （条件）分页查询用户订单列表
     *
     * @author pengpai
     * @date 2018/4/23 14:22
     * @param pageInfo
     * @return com.github.pagehelper.Page<com.qpp.comiccps.basics.entity.UserOrder>
     */
    public Page<UserOrder> getAllUserOrder(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        if (!ParaClick.clickString(pageInfo.getCondition()))
            pageInfo.setCondition2(StringToInt.toInt(pageInfo.getCondition()));
        return userOrderMapper.getAllUserOrder(pageInfo);
    }

    /**
     *    用户订单求和
     *
     * @author pengpai
     * @date 2018/4/25 18:25
     * @param pageInfo
     * @return java.lang.Double
     */
    public Double getAllUserOrderSum(PageInfo pageInfo) {
        if (!ParaClick.clickString(pageInfo.getCondition()))
            pageInfo.setCondition2(StringToInt.toInt(pageInfo.getCondition()));
        return userOrderMapper.getAllUserOrderSum(pageInfo);
    }


    /**  
     *    分页条件查询现金收益列表
     *   
     * @author pengpai 
     * @date 2018/4/25 17:48  
     * @param pageInfo
     * @return com.github.pagehelper.Page<com.qpp.comiccps.basics.entity.data.UserOrderProfitNew>  
     */  
    public Page<UserOrderProfitNew> selectOrderProfitNew(PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        return userOrderMapper.selectOrderProfitNew(pageInfo);
    }

    /**
     *    查询现金收益
     *
     * @author pengpai
     * @date 2018/4/25 17:50
     * @param pageInfo
     * @return java.lang.Double
     */
    public Double selectOrderProfitNewSum(PageInfo pageInfo) {
        return userOrderMapper.selectOrderProfitNewSum(pageInfo.getStartDate(),pageInfo.getEndDate());
    }

    /**
     *    每日定时清除无效订单
     *
     * @author pengpai
     * @date 2018/4/27 14:51
     * @param
     * @return boolean
     */
    public boolean deleteInvalidOrder() {
        int index = userOrderMapper.deleteInvalidOrder();
        if (index<1)
            return false;
        return true;
    }

    /**
     *    導出Excel
     *
     * @author pengpai
     * @date 2018/5/8 13:57
     * @param titles, out, startDate, endDate
     * @return void
     */
    public void export(String[] titles, ServletOutputStream out, String startDate, String endDate) {
        // 生成Excel
        try {
            // 第一步，创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet hssfSheet = workbook.createSheet("sheet1");
            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
            HSSFRow hssfRow = hssfSheet.createRow(0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
            // 居中样式
            //hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            HSSFCell hssfCell = null;

            for (int i = 0; i < titles.length; i++) {
                hssfCell = hssfRow.createCell(i);// 列索引从0开始
                hssfCell.setCellValue(titles[i]);// 列名1
                hssfCell.setCellStyle(hssfCellStyle);// 列居中显示
            }
            List<WithdrawalsStatistics> profit=
                    distributorWithdrawalsMapper.selectOrderProfitNew2(startDate, endDate);
            if (!ParaClick.clickList(profit)) {
                throw new BusinessException("导出信息失败！");
            }
            for (int i = 0; i < profit.size(); i++) {
                hssfRow = hssfSheet.createRow(i+1);
                hssfRow.createCell(0).setCellValue(profit.get(i).getUsername()+"");
                hssfRow.createCell(1).setCellValue(profit.get(i).getProportion()+"");
                hssfRow.createCell(2).setCellValue(ArithUtil.interceptDouble(profit.get(i).getMoney(),3)+"");
            }
            // 第七步，将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("导出信息失败！");
        }
    }
}
