/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.IGCRC2101VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2101Cond;

/**	
 * ����:��Ա����ͳ��BL
 * ������¼��yukexin    2014-8-15 ����5:12:52	
 * �޸ļ�¼��null
 */	
public interface IGCRC2101BL extends BaseBL{
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGCRC2101VWInfo> searchIGCRC2101(
			IGCRC2101Cond cond, int start,
			int count);
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IGCRC2101VWInfo> searchIGCRC2101(IGCRC2101Cond cond);
	
	/**	
	 * ���ܣ���ѯ���������б�
	 * @return ���������б�
	 * �޸ļ�¼��null 	
	 */	
	public List<IGCRC2102VWInfo> searchDepartmentBeanList();
}
