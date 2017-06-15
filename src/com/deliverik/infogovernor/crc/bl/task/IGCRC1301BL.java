/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1301Cond;

/**
 * ����: �ĵ���ѯҵ���߼��ӿ�
 * ��������: �ĵ���ѯҵ���߼��ӿ�
 * ������¼: 2014/07/15
 * �޸ļ�¼: 
 */
public interface IGCRC1301BL extends BaseBL {
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGCRC1301Cond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGCRC1301VWInfo> searchIGCRC1301(
			IGCRC1301Cond cond, int start,
			int count);
	
	
	public List<IGCRC1301VWInfo> searchIGCRC1302(IGCRC1301Cond cond, int start,
			int count);
}
