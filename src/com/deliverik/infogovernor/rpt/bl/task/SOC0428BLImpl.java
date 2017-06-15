/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0428Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0428SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0428DAO;

/**
  * 概述: 业务系统视图业务逻辑实现
  * 功能描述: 业务系统视图业务逻辑实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将BusinessCapacityRealTimeVWBLImpl表名改为SOC0428BLImpl
  */
public class SOC0428BLImpl extends BaseBLImpl implements
		SOC0428BL {

	/** 业务系统视图DAO接口 */
	protected SOC0428DAO soc0428DAO;
	
	/**
	 * 业务系统视图DAO接口设定
	 *
	 * @param soc0428DAO 业务系统视图DAO接口
	 */
	public void setSoc0428DAO(SOC0428DAO soc0428DAO) {
		this.soc0428DAO = soc0428DAO;
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0428Info> searchSOC0428() {
		return soc0428DAO.findAll();
	}


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0428SearchCond cond) {
		return soc0428DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0428Info> searchSOC0428(
			SOC0428SearchCond cond) {
		return soc0428DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0428Info> searchSOC0428(
			SOC0428SearchCond cond, int start,
			int count) {
		return soc0428DAO.findByCond(cond, start, count);
	}
	/**
	 * 主键检索
	 */
	public SOC0428Info searchSOC0428ByPK(Integer pk){
		return soc0428DAO.findByPK(pk); 
	}
}