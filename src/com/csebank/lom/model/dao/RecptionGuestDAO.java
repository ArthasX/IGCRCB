/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.RecptionGuest;
import com.csebank.lom.model.condition.RecptionGuestSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * �Ӵ�����DAO�ӿ�
 *
 */
public interface RecptionGuestDAO extends BaseHibernateDAO<RecptionGuest> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RecptionGuest> findAll();

	/**
	 * ������������
	 * @param rid ����
	 * @return �������
	 */
	public RecptionGuest findByPK(Serializable rid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RecptionGuestSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionGuest> findByCond(final RecptionGuestSearchCond cond, final int start, final int count);
	
}
