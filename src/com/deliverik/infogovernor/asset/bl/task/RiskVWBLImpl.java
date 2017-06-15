/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskVWCond;
import com.deliverik.infogovernor.asset.model.dao.RiskVWDAO;

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
public class RiskVWBLImpl extends BaseBLImpl implements RiskVWBL {

	/** 风险检查统计查询DAO接口 */
	protected RiskVWDAO riskVWDAO;
	
	/**
	 * 风险检查统计查询DAO接口设定
	 * @param riskVWDAO 风险检查统计查询DAO接口
	 */
	public void setRiskVWDAO(RiskVWDAO riskVWDAO) {
		this.riskVWDAO = riskVWDAO;
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<RiskVWInfo> findByCond(RiskVWCond cond) {
		return riskVWDAO.findByCond(cond);
	}

}
