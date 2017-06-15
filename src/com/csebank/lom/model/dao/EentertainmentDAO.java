/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EentertainmentSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ʳ�ýӴ���ϢDAO�ӿ�
 *
 */
public interface EentertainmentDAO extends BaseHibernateDAO<Eentertainment> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Eentertainment> findAll();

	/**
	 * ������������
	 * @param eeid ����
	 * @return �������
	 */
	public Eentertainment findByPK(Serializable eeid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EentertainmentSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Eentertainment> findByCond(final EentertainmentSearchCond cond, final int start, final int count);
	
	


}
