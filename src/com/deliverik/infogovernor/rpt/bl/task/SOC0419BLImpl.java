/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0419Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0419SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0419DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0419TB;

/**
  * 概述: 卷组容量实时表业务逻辑实现
  * 功能描述: 卷组容量实时表业务逻辑实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/10 将VGCapacityRealTimeBLImpl表名修改为SOC0419BLImpl
  */
public class SOC0419BLImpl extends BaseBLImpl implements
		SOC0419BL {

	/** 卷组容量实时表DAO接口 */
	protected SOC0419DAO soc0419DAO;
	
	/**
	 * 卷组容量实时表DAO接口设定
	 *
	 * @param soc0419DAO 卷组容量实时表DAO接口
	 */
	public void setSoc0419DAO(SOC0419DAO soc0419DAO) {
		this.soc0419DAO = soc0419DAO;
	}

	/**
	 * 卷组容量实时表实例取得
	 *
	 * @return 卷组容量实时表实例
	 */
	public SOC0419TB getSOC0419Instance() {
		return new SOC0419TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0419Info> searchSOC0419() {
		return soc0419DAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0419SearchCond cond) {
		return soc0419DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0419Info> searchSOC0419(
			SOC0419SearchCond cond) {
		return soc0419DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0419Info> searchSOC0419(
			SOC0419SearchCond cond, int start,
			int count) {
		return soc0419DAO.findByCond(cond, start, count);
	}


}