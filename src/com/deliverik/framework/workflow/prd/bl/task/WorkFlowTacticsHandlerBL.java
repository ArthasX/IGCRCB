/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * ����: ���̲��Թ���ҵ���߼��ӿ�
  * ��������: ���̲��Թ���ҵ���߼��ӿ�
  * ������¼: 2013/09/04
  * �޸ļ�¼: 
  */
public interface WorkFlowTacticsHandlerBL extends BaseBL {

	public abstract void initExecute(String pdid, String psdid) throws BLException;
	
}
