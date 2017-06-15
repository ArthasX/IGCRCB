/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.rpt.bl.task;

 import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0203Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0203SearchCond;


/**
 * 
 * @Description:自动报表配置列表BL接口
 * @Author
 * @History
 * @Version V1.0
 * 修改记录：2012/08/09 将ReportConfigurationBL表名改为SOC0203BL
 */
public interface SOC0203BL extends BaseBL{
   /**
    * 持久化处理
    * @param SOC0203实体类
    * @return SOC0203实体类
    */
 public SOC0203Info saveSOC0203(SOC0203Info soc0203) throws BLException;

   /**
    * 主键检索处理
    * @param id 主键
    * @return 检索结果
    */
 public SOC0203Info findSOC0203ByPK(Integer id) throws BLException;

   /**
    * 全件检索
    * @return 检索结果集
    */
 public List<SOC0203Info> findAllSOC0203() throws BLException;

   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
 public int getSearchCount(SOC0203SearchCond cond) throws BLException;

    /**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
 public List<SOC0203Info> findSOC0203ByCond(SOC0203SearchCond cond, int start, int count) throws BLException;

    /**
     * 删除处理
     * @param SOC0203实体类
     */
 public void deleteSOC0203(SOC0203Info soc0203) throws BLException;

}

