/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * �ο����̴���Ӱ�촦��BL
 */
public interface WorkFlowGroupEventBL extends BaseBL {

	/**
	 * �ο����̴���Ӱ�촦��
	 * 
	 * @param rprid �ο�����ID
	 * @param iprid Ӱ������ID
	 * @throws BLException
	 */
	public void execute(Integer rprid, Integer iprid) throws BLException;

}
