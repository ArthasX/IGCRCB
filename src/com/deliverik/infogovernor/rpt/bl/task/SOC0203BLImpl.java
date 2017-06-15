/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.rpt.bl.task;

 import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0203Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0203SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0203DAO;


/**
 * 
 * @Description:自动报表配置列表BL实现类
 * @Author
 * @History
 * @Version V1.0
 * 修改记录：2012/08/09 将ReportConfigurationBLImpl表名改为SOC0203BLImpl
 */
public class SOC0203BLImpl extends BaseBLImpl implements SOC0203BL{

  protected SOC0203DAO soc0203DAO;

 public void setSoc0203DAO(SOC0203DAO soc0203DAO) {
 this.soc0203DAO = soc0203DAO;
 }

   /**
    * 持久化处理
    * @param SOC0203实体类
    * @return SOC0203实体类
    */
 public SOC0203Info saveSOC0203(SOC0203Info soc0203) throws BLException{
 return soc0203DAO.save(soc0203);
 }

   /**
    * 主键检索处理
    * @param id 主键
    * @return 检索结果
    */
 public SOC0203Info findSOC0203ByPK(Integer id) throws BLException{
 return soc0203DAO.findByPK(id);
 }

   /**
    * 全件检索
    * @return 检索结果集
    */
 public List<SOC0203Info> findAllSOC0203() throws BLException{
 return soc0203DAO.findAll();
 }

   /**
    * 条件检索结果件数取得
    * @param cond 检索条件
    * @return 检索结果件数
    */
 public int getSearchCount(SOC0203SearchCond cond) throws BLException{
 return soc0203DAO.getSearchCount(cond);
 }

    /**
     * 条件检索处理
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
 public List<SOC0203Info> findSOC0203ByCond(SOC0203SearchCond cond, int start, int count) throws BLException{
 return soc0203DAO.findByCond(cond, start, count);
 }

    /**
     * 删除处理
     * @param SOC0203实体类
     */
 public void deleteSOC0203(SOC0203Info soc0203) throws BLException{
	 soc0203DAO.delete(soc0203);
 }

}

