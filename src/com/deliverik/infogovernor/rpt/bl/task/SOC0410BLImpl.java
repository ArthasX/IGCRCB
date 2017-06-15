/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0410Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0410SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0410DAO;

/**
  * 概述: 存储lun实时表业务逻辑实现
  * 功能描述: 存储lun实时表业务逻辑实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将PVStorageRealTimeBLImpl表名改为SOC0410BLImpl
  */
public class SOC0410BLImpl extends BaseBLImpl implements
		SOC0410BL {

	/** 存储lun实时表DAO接口 */
	protected SOC0410DAO soc0410DAO;

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0410Info> searchSOC0410() {
		return soc0410DAO.findAll();
	}


	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0410SearchCond cond) {
		return soc0410DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0410Info> searchSOC0410(
			SOC0410SearchCond cond) {
		return soc0410DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0410Info> searchSOC0410(
			SOC0410SearchCond cond, int start,
			int count) {
		return soc0410DAO.findByCond(cond, start, count);
	}


	/**
	 * 存储lun实时表DAO接口设定
	 *
	 * @param soc0410DAO 存储lun实时表DAO接口
	 */
	public void setSoc0410DAO(SOC0410DAO soc0410DAO) {
		this.soc0410DAO = soc0410DAO;
	}

}