/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.dev.ext.igflow.generator.serialnum;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowSerialnumGeneratorBL;

/**
 * <p>
 * ������������
 * </p>
 */
public class IGGENERATOR0101BLImpl extends BaseBLImpl implements
		WorkFlowSerialnumGeneratorBL {

	/**
	 * ���̹��������ɴ���
	 * 
	 * @param ����ID
	 * @return ���̹�����
	 * @throws BLException
	 */
	public String serialnumGenerator(Integer prid) throws BLException {
		return "ddd";
	}
}
