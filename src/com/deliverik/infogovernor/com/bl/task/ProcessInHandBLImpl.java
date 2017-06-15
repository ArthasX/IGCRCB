/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.com.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.com.model.condition.ProcessInHandVWInfoSearchCondImpl;
import com.deliverik.infogovernor.com.model.dao.ProcessInHandSingleVWDAO;

/**
 * 值班检查管理业务逻辑接口
 */
public class ProcessInHandBLImpl extends BaseBLImpl implements ProcessInHandBL {
	/** DutyAuditDef DAO */
	protected ProcessInHandSingleVWDAO processInHandSingleVWDAO;

	public void setProcessInHandSingleVWDAO(
			ProcessInHandSingleVWDAO processInHandSingleVWDAO) {
		this.processInHandSingleVWDAO = processInHandSingleVWDAO;
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProcessInHandVWInfo> searchProcessInHandByUserID(String userid,int start, int count,boolean desc) throws BLException{
		ProcessInHandVWInfoSearchCondImpl cond = new ProcessInHandVWInfoSearchCondImpl();
		cond.setUserid(userid);
		return processInHandSingleVWDAO.searchProcessInhand(cond,start,count,desc);
		
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProcessInHandVWInfo> searchProcessInHandGroupByUserID(String userid,int start,int count,boolean desc) throws BLException{
		ProcessInHandVWInfoSearchCondImpl cond = new ProcessInHandVWInfoSearchCondImpl();
		cond.setUserid(userid);
		return processInHandSingleVWDAO.searchProcessInhandGroup(cond,start,count, desc);
		
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProcessInHandVWInfo> searchProcessInHandDiscontinueByUserID(
			String userid, boolean desc) throws BLException {
		ProcessInHandVWInfoSearchCondImpl cond = new ProcessInHandVWInfoSearchCondImpl();
		cond.setUserid(userid);
		return processInHandSingleVWDAO.searchProcessInhandDiscontinue(cond,desc);
	}
}
