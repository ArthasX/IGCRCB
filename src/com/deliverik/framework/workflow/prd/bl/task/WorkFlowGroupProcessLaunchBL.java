/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * �������̷�����BL
 */
public interface WorkFlowGroupProcessLaunchBL extends BaseBL {
	
	/**
	 * �������̷�����
	 * 
	 * @return ����ID
	 * @throws BLException
	 */
	public Integer launchProcess(Integer groupID, String groupDefID, String pdid, String title, 
			String executorID, Integer executorRoleID) throws BLException;

}
