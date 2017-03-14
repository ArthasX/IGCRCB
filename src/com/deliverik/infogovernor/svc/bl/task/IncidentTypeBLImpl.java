/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.bl.task;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.svc.model.IncidentTypeVWInfo;
import com.deliverik.infogovernor.svc.model.condition.IncidentTypeSearchCond;
import com.deliverik.infogovernor.svc.model.dao.IncidentTypeDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 故障类型统计BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IncidentTypeBLImpl extends BaseBLImpl implements IncidentTypeBL{

	/** 故障类型统计DAO */
	protected IncidentTypeDAO incidentTypeDAO;

	/**
	 * 故障类型统计DAO设定
	 * @param incidentTypeDAO 故障类型统计DAO
	 */
	public void setIncidentTypeDAO(IncidentTypeDAO incidentTypeDAO) {
		this.incidentTypeDAO = incidentTypeDAO;
	}
	
	/**
	 * 统计数据检索
	 * @param cond 检索条件
	 * @return
	 */
	public IncidentTypeVWInfo searchIncidentTypeData(IncidentTypeSearchCond cond){
		return incidentTypeDAO.searchIncidentTypeData(cond);
	}
}
