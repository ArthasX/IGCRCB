/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.CheckVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckVWCond;
import com.deliverik.infogovernor.asset.model.dao.CheckVWDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险检查统计查询业务逻辑实现
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class CheckVWBLImpl extends BaseBLImpl implements CheckVWBL {

	/** 风险检查统计查询DAO接口 */
	protected CheckVWDAO checkVWDAO;
	
	/**
	 * 风险检查统计查询DAO接口设定
	 * @param checkVWDAO 风险检查统计查询DAO接口
	 */
	public void setCheckVWDAO(CheckVWDAO checkVWDAO) {
		this.checkVWDAO = checkVWDAO;
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CheckVWInfo> findByCond(CheckVWCond cond) {
		return checkVWDAO.findByCond(cond);
	}

}
