/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Eatery;
import com.csebank.lom.model.condition.EaterySearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ʳ�óɱ���Ϣҵ���߼��ӿ�
 */
public interface EateryBL extends BaseBL {

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(EaterySearchCond cond);

	/**
	 * ������������
	 * 
	 * @param eid ʳ�óɱ�ID
	 * @return ʳ�óɱ�ID
	 */
	public Eatery searchEateryByKey(Integer eid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ʳ�óɱ���Ϣ
	 */
	public List<Eatery> searchEateryAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Eatery> searchEatery(EaterySearchCond cond, int start, int count);

	/**
	 * ��¼����
	 * 
	 * @param Eatery ��¼����
	 * @return ʳ�óɱ���Ϣ
	 */
	public Eatery registEatery(Eatery eatery) throws BLException;

	/**
	 * �������
	 * 
	 * @param Eatery �������
	 * @return ʳ�óɱ���Ϣ
	 */
	public Eatery updateEatery(Eatery eatery) throws BLException;

}
