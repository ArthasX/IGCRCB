/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.GuestRecption;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.condition.RecptionSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * �Ӵ�����DAO�ӿ�
 *
 */
public interface RecptionDAO extends BaseHibernateDAO<Recption> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Recption> findAll();

	/**
	 * ������������
	 * @param rid ����
	 * @return �������
	 */
	public Recption findByPK(Serializable rid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RecptionSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Recption> findByCond(final RecptionSearchCond cond, final int start, final int count);
	
	/**
	 * ���ݿͻ��������ͻ���λ��ѯ�Ӵ�������Ϣ
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return �Ӵ�������Ϣ
	 */
	public List<GuestRecption> findByGuestInfoCond(final RecptionGuestInfoCond cond, final int start, final int count);
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getRecptionSearchCount(RecptionGuestInfoCond cond);

}
