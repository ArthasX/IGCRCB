/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.scheduling.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH05DTO;

/**
 *	<p>����: �ճ���ά�ƻ���ʱ����ӿ�</p>
 * 
 *	<p>������¼: ��ʢ�	2010-12-9</p>
 */
public interface IGSCH05BL extends BaseBL {
	
	public String getPeriodInfo(String periodType, String CustomDate, 
			String exeHour, String exeMinute,String startDate);
	
	public void init(IGSCH05DTO dto) throws BLException;
	
}
