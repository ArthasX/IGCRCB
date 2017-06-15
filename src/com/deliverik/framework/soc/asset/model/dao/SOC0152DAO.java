/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0152Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0152SearchCond;

/**
  * ����: �ʲ���ϵ��DAO�ӿ�
  * ��������: �ʲ���ϵ��DAO�ӿ�
  * ������¼: ����ȫ 2013/05/27
  * �޸ļ�¼: 
  */
public interface SOC0152DAO extends BaseHibernateDAO<SOC0152Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0152Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0152Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0152SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0152Info> findByCond(
			final SOC0152SearchCond cond, final int start,
			final int count);

}