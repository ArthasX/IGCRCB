/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.svc.model.ServiceTopFiveVWInfo;
import com.deliverik.infogovernor.svc.model.condition.ServiceTopFiveSearchCond;
import com.deliverik.infogovernor.svc.model.dao.ServiceTopFiveVWDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 部门服务top5统计BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ServiceTopFiveVWBLImpl extends BaseBLImpl implements ServiceTopFiveVWBL{
	
	/** 部门服务top5统计DAO */
	protected ServiceTopFiveVWDAO serviceTopFiveVWDAO;

	/**
	 * 部门服务top5统计DAO设定
	 * @param serviceTopFiveVWDAO 部门服务top5统计DAO
	 */
	public void setServiceTopFiveVWDAO(ServiceTopFiveVWDAO serviceTopFiveVWDAO) {
		this.serviceTopFiveVWDAO = serviceTopFiveVWDAO;
	}

	/**
	 * 统计数据查询
	 * @param cond
	 * @return
	 */
	public List<ServiceTopFiveVWInfo> searchServiceDate(ServiceTopFiveSearchCond cond){
		return serviceTopFiveVWDAO.searchServiceDate(cond);
	}
}
