/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.dev.crc.igflow.event.status.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���չ���ʱ����BL�ӿ�
 * </p>
 * 
 * @author zhangq@deliverik.com
 * @version 1.0
 */
public interface IGFXKDataSendBL extends BaseBL{
	
	/**
	 * ������Ϣ
	 * @throws BLException
	 */
	public void dataSend(Object bTime,Object eTime,Object title) throws BLException;
}
