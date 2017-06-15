/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * <p>
 * 流程事件多线程任务处理HandlerBL
 * </p>
 */
public abstract class WorkFlowThreadEventHandlerBLImpl extends BaseBLImpl
		implements WorkFlowThreadEventHandlerBL, Runnable  {
	
	static Log log = LogFactory.getLog(WorkFlowThreadEventHandlerBLImpl.class);

	/** 流程基本信息*/
	protected IG500Info processRecord;

	/** 源状态信息 */
	protected IG333Info fpsd;

	/** 跃迁状态信息 */
	protected IG333Info tpsd;
	
	/** 登录用户信息 */
	protected User user;
	
	/** 操作角色ID */
	protected Integer roleid;

	/**
	 * 线程启动入口
	 */
	public void run() {
		try {
			this.threadTreatmentExecute(processRecord, fpsd, tpsd, user, roleid);
		} catch (BLException e) {
			log.error("流程（" + processRecord.getPrpdid() + processRecord.getPrpdname() 
					+ ")的（" + fpsd.getPsdname()+ "）状态多线程任务运行失败。");
		}
	}

	/**
	 * 初始化
	 * @param processRecord流程基本信息
	 * @param fpsd源状态信息
	 * @param tpsd跃迁状态信息
	 * @param user登录用户信息
	 * @param roleid操作角色ID
	 */
	public void init(IG500Info processRecord, IG333Info fpsd,
			IG333Info tpsd, User user, Integer roleid) {
		this.processRecord = processRecord;
		this.fpsd = fpsd;
		this.tpsd = tpsd;
		this.user = user;
		this.roleid = roleid;
	}

}
 