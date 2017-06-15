/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCond;

/**
 * ����״̬��־ʵ��DAO�ӿ�
 * 
 */
public interface IG224DAO extends BaseHibernateDAO<IG224Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG224Info> findAll();

	/**
	 * ������������
	 * @param rslid ����
	 * @return �������
	 */
	public IG224Info findByPK(Serializable rslid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG224SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG224Info> findByCond(final IG224SearchCond cond, final int start, final int count);
	/**
	 * ������������ dashboard ���ݳ�ʼ��ר��
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG224Info> findByCondOrderByRslopentime(final IG224SearchCond cond);
	
}
