/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Gstock;
import com.csebank.lom.model.condition.GstockSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ��ƷDAO�ӿ�
 *
 */
public interface GstockDAO extends BaseHibernateDAO<Gstock> {

	/**
	 * ȫ������
	 * @return ��������� 
	 */
	public List<Gstock> findAll();

	/**
	 * ������������
	 * @param gsid ����
	 * @return �������
	 */
	public Gstock findByPK(Serializable gsid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final GstockSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Gstock> findByCond(final GstockSearchCond cond, final int start, final int count);
	
}
