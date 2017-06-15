/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Goutstock;
import com.csebank.lom.model.condition.GoutstockSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ��Ʒ������ϢDAO�ӿ�
 *
 */
public interface GoutstockDAO extends BaseHibernateDAO<Goutstock> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Goutstock> findAll();

	/**
	 * ������������
	 * @param rid ����
	 * @return �������
	 */
	public Goutstock findByPK(Serializable goid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final GoutstockSearchCond cond);
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Goutstock> findByCond(final GoutstockSearchCond cond, final int start, final int count);

	
}
