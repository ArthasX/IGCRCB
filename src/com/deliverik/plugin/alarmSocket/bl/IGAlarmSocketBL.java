/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.plugin.alarmSocket.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;

/***
 * ���ɸ澯���ҵ���߼��ӿ�
 * @time 2014/06/20
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */

public interface IGAlarmSocketBL extends BaseBL{
	
	/**
	 * �������ɸ澯����
	 * @param msg socket��ȡ�澯��Ϣ
	 * @return int 0���ɹ�  1��ʧ��
	 * @throws BLException
	 */
	public int registIgalarm(IGCRC02DTO dto) throws Exception;
}
