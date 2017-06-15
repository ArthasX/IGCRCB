/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0106Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0106SearchCond;

/**
  * ����: SOC0106DAO�ӿ�
  * ��������: SOC0106DAO�ӿ�
  * ������¼: 2012/07/31
  * �޸ļ�¼: 
  */
public interface SOC0106DAO extends BaseHibernateDAO<SOC0106Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0106Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0106Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0106SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0106Info> findByCond(
			final SOC0106SearchCond cond, final int start,
			final int count);

}