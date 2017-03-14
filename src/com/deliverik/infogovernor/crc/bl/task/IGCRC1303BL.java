package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC1303Cond;

/**
 * 
 * ���ܣ��ĵ�ͳ��BL
 * @author ʷ����   2014-7-24
 */
public interface IGCRC1303BL extends BaseBL{
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGCRC1303Cond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGCRC1303VWInfo> searchIGCRC1303(
			IGCRC1303Cond cond, int start,
			int count);
	
	/**
	 * ��������ͳ�Ƽ�¼
	 * @return
	 */
	public List<String> searchType();
	
	/**
	 * ���ݲ�ѯ�������̵Ĳ�������
	 * @return
	 */
	public List<String> searchDownType();
}
