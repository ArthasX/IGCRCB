/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.condition.IG499SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: ��ͬ�ʲ���Ϣ��ͼDAO�ӿ�
  * ��������: ��ͬ�ʲ���Ϣ��ͼDAO�ӿ�
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
public interface IG499DAO extends BaseHibernateDAO<IG499Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG499Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG499Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG499SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG499Info> findByCond(
			final IG499SearchCond cond, final int start,
			final int count);
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchImprestCount(final IG499SearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG499Info> findImprestByCond(final IG499SearchCond cond, 
			final int start, final int count);

}