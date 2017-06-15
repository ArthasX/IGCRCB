/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.EworkingLunch;
import com.csebank.lom.model.condition.EworkingLunchSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ʳ�ù�������Ϣҵ���߼��ӿ�
 */
public interface EworkingLunchBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(EworkingLunchSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param ewlid ʳ�ù�����ID
	 * @return ʳ�ù�����ID
	 */
	public EworkingLunch searchEworkingLunchByKey(Integer ewlid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ʳ�ù�������Ϣ
	 */
	public List<EworkingLunch> searchEworkingLunchAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EworkingLunch> searchEworkingLunch(EworkingLunchSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param EworkingLunch ��¼����
	 * @return ʳ�ù�������Ϣ
	 */
	public EworkingLunch registEworkingLunch(EworkingLunch EworkingLunch) throws BLException;

	/**
	 * �������
	 * 
	 * @param EworkingLunch �������
	 * @return ʳ�ù�������Ϣ
	 */
	public EworkingLunch updateEworkingLunch(EworkingLunch EworkingLunch) throws BLException;

}
