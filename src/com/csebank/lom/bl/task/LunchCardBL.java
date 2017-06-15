/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.ItemsCodesSt;
import com.csebank.lom.model.condition.LunchCardSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * �Ϳ���Ϣҵ���߼��ӿ�
 */
public interface LunchCardBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(LunchCardSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param typecode �Ϳ�ID
	 * @return �Ϳ�ID
	 */
	public ItemsCodesSt searchLunchCardByKey(Integer icid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ʳ�óɱ���Ϣ
	 */
	public List<ItemsCodesSt> searchLunchCardAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ItemsCodesSt> searchLunchCard(LunchCardSearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param Eatery ��¼����
	 * @return �Ϳ���Ϣ
	 */
	public ItemsCodesSt registLunchCard(ItemsCodesSt eatery) throws BLException;

	/**
	 * �������
	 * 
	 * @param Eatery �������
	 * @return �Ϳ���Ϣ
	 */
	public ItemsCodesSt updateLunchCard(ItemsCodesSt eatery) throws BLException;

}
