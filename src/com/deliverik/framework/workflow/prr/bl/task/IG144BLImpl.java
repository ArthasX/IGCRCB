package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG144DAO;

/**
 * <p>
 * 事件和服务请求流程汇总统计业务逻辑实现
 * </p>
 */
public class IG144BLImpl extends BaseBLImpl implements IG144BL{
	
	/**事件和服务请求流程汇总统计操作*/
	protected IG144DAO ig144DAO;
	
	/**
	 * 设置事件和服务请求流程汇总统计操作
	 * @param ig144DAO Ig144DAO
	 */
	public void setIg144DAO(IG144DAO ig144DAO) {
		this.ig144DAO = ig144DAO;
	}

	/**
	 * 事件流程汇总统计
	 * 
	 * @return 事件流程汇总统计列表
	 */
	
	public List<IG500Info> searchIG019Info(final IG019SearchCond cond, final int start, final int count) {
		return ig144DAO.findIncidentByCond(cond, start, count);
	}
	
	/**
	 * 事件流程汇总统计个数
	 * 
	 * @return 事件流程汇总统计个数
	 */
	public int getIG019Info(IG019SearchCond cond) {
		return ig144DAO.getIncidentSearchCount(cond);
	}
	
	/**
	 * 服务请求流程汇总统计
	 * 
	 * @return 服务请求流程汇总统计列表
	 */
	
	public List<IG500Info> searchServiceRequest(final IG019SearchCond cond, final int start, final int count) {
		return ig144DAO.findServiceRequestByCond(cond, start, count);
	}

	/**
	 * 服务请求流程汇总统计个数
	 * 
	 * @return 服务请求流程汇总统计个数
	 */
	public int getServiceRequestSearchCount(IG019SearchCond cond) {
		return ig144DAO.getServiceRequestSearchCount(cond);
	}
	
	

}
