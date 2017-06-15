/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2301Cond;

/**	
 * ����:���򿪷�ͳ��BL
 * ������¼��yukexin    2014-8-15 ����5:14:01	
 * �޸ļ�¼��null
 */	
public interface IGCRC2301BL extends BaseBL{
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IGCRC2301VWInfo> searchIGCRC2301(IGCRC2301Cond cond);
	
	
	/**
	 * ������������
	 * 		��ѯ�����ش���
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Integer> searchList(IGCRC2301Cond cond);
	
	/**
	 * ������������
	 *		��ѯ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Integer> searchListSum(IGCRC2301Cond cond);
}
