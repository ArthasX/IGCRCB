/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.plugin.eventProcess.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������ͬ�����BL�ӿ�
 * </p>
 * 
 * @author shikailong@deliverik.com
 * @version 1.0
 */
public interface EVEProBL extends BaseBL{

	/**
	 * �¼����̳�ʱ����ͬ��
	 * @throws BLException
	 */
	public void dataSynchronism() throws BLException;
}
