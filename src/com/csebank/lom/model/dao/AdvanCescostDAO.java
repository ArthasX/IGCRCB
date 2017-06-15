/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.AdvanCescost;
import com.csebank.lom.model.condition.AdvanCescostSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * Ԥ֧����DAO�ӿ�
 *
 */
public interface AdvanCescostDAO extends BaseHibernateDAO<AdvanCescost> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<AdvanCescost> findAll();

	/**
	 * ������������
	 * @param dadid ����
	 * @return �������
	 */
	public AdvanCescost findByPK(Serializable acid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AdvanCescostSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AdvanCescost> findByCond(final AdvanCescostSearchCond cond, final int start, final int count);
	
	


}
