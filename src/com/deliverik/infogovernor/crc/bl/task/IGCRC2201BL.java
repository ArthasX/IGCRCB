/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2201Cond;

/**	
 * ����:�������ͳ��BL�ӿ�
 * ������¼��yukexin    2014-8-15 ����5:13:22	
 * �޸ļ�¼��null
 */	
public interface IGCRC2201BL extends BaseBL{
	
	/**
	 * ͳ�����ݼ���
	 * 
	 * @param cond ��������
	 * @return List<ChangeTreadVWInfo>
	 */
	public List<IGCRC2201VWInfo> searchIncidentTypeData(IGCRC2201Cond cond);
}
