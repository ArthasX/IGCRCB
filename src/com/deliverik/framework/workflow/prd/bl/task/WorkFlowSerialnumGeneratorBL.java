/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * ���̹�����������HandlerBL
 * </p>
 */
public interface WorkFlowSerialnumGeneratorBL extends BaseBL {

	/**
	 * ���̹��������ɴ���
	 * 
	 * @param ����ID
	 * @return ���̹�����
	 * @throws BLException
	 */
	public String serialnumGenerator(Integer prid) throws BLException;

}
