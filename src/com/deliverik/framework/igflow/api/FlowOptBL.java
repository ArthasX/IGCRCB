/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.api;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.igflow.parameter.ProcessGroupInfo;
import com.deliverik.framework.igflow.parameter.ProcessRecordInfo;
import com.deliverik.framework.igflow.parameter.SuspendProcessInfo;

/**
 * 流程处理功能API
 */
public interface FlowOptBL extends BaseBL {

	/**
	 * 流程组发起
	 * 
	 * @param processGroupInfo 流程组发起信息
	 * @return 流程组ID
	 * @throws BLException
	 */
	public Integer initProcessGroupAction(ProcessGroupInfo processGroupInfo) throws BLException;
	
	/**
	 * 流程发起
	 * 
	 * @param processRecordInfo 流程发起信息
	 * @return 流程ID
	 * @throws BLException
	 */
	public Integer initProcessAction(ProcessRecordInfo processRecordInfo) throws BLException;
	
	
	/**
	 * 流程发起
	 * 
	 * @param processRecordInfo 流程发起信息
	 * @return 流程ID
	 * @throws BLException
	 */
	public Integer saveProcessAction(ProcessRecordInfo processRecordInfo) throws BLException;
	
	/**
	 * 流程中止
	 * 
	 * @param suspendProcessInfo 流程中止信息
	 * @throws BLException
	 */
	public void suspendProcess(SuspendProcessInfo suspendProcessInfo) throws BLException;
	
	/**
	 * 流程跃迁
	 * 只支持普通模式下的普通节点，支持按钮跃迁规则但不支持表单跃迁规则
	 * 
	 * @param prid 流程ID
	 * @param userid 处理用户ID
	 * @param action 按钮名称
	 * @param datetime 处理时间
	 * @throws BLException
	 */
	public void transitionProcess(Integer prid, String userid, String action, String datetime) throws BLException;

}
