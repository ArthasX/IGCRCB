/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0112SearchCond;

/**
  * ����: �ʲ�����ϸ��DAO�ӿ�
  * ��������: �ʲ�����ϸ��DAO�ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0112DAO extends BaseHibernateDAO<SOC0112Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0112Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0112Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0112SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0112Info> findByCond(
			final SOC0112SearchCond cond, final int start,
			final int count);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0112Info> findBySQL(final SOC0112SearchCond cond, final int start, final int count);
}