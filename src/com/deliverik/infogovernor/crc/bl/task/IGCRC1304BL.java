package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1301Cond;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1304Cond;

/**
 * 
 * ���ܣ������ĵ�ͳ��BL
 * @author ʷ����   2014-7-24
 */
public interface IGCRC1304BL extends BaseBL{
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGCRC1304Cond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGCRC1303VWInfo> searchIGCRC1304(
			IGCRC1304Cond cond, int start,
			int count);
	
	/**
	 * ��������ͳ�Ƽ�¼
	 * @return
	 */
	public List<String> searchType();
	
	/**
	 * ��ѯ�����ص��ĵ��Ĳ���
	 * @return
	 */
	public List<String> searchDownDepart();
	
	
	public List<Integer> searchTypeID(IGCRC1304Cond cond);
}
