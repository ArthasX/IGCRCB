/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.svc.model.OrganizationServiceVWInfo;
import com.deliverik.infogovernor.svc.model.condition.OrganizationServiceSearchCond;
import com.deliverik.infogovernor.svc.model.dao.OrganizationServiceDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 部门服务统计BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class OrganizationServiceBLImpl extends BaseBLImpl implements OrganizationServiceBL{

	/** 部门服务统计DAO */
	protected OrganizationServiceDAO organizationServiceDAO;

	/**
	 * 部门服务统计DAO设定
	 * @param organizationServiceDAO 部门服务统计DAO
	 */
	public void setOrganizationServiceDAO(
			OrganizationServiceDAO organizationServiceDAO) {
		this.organizationServiceDAO = organizationServiceDAO;
	}
	
	/**
	 * 统计数据检索
	 * @param cond 检索条件
	 * @return
	 */
	public List<OrganizationServiceVWInfo> searchOrganizationService(OrganizationServiceSearchCond cond){
		return organizationServiceDAO.searchOrganizationService(cond);
	}
}
