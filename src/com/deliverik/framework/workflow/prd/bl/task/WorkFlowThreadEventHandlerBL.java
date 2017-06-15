/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * 流程事件多线程任务处理HandlerBL
 * </p>
 */
public interface WorkFlowThreadEventHandlerBL extends BaseBL {

	/**
	 * 流程状态多线程任务操作
	 * 
	 * @param processRecord流程信息
	 * @param fpsd流程源状态信息
	 * @param tpsd流程跃迁状态信息
	 * @param user登录用户信息
	 * @param roleid操作角色ID
	 */
	public void threadTreatmentExecute(IG500Info processRecord, IG333Info fpsd, IG333Info tpsd, User user, Integer roleid) throws BLException;

}
