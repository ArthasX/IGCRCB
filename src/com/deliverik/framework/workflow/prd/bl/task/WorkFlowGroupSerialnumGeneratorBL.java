/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * ������ʵ��������������HandlerBL
 * </p>
 */
public interface WorkFlowGroupSerialnumGeneratorBL extends BaseBL {

	/**
	 * ������ʵ�����������ɴ���
	 * 
	 * @param pgdid �����鶨��ID
	 * @return ������ʵ��������
	 * @throws BLException
	 */
	public String serialnumGenerator(String pgdid) throws BLException;

}
