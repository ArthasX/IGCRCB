/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0115Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0115SearchCond;

/**
  * ����: ����������DAO�ӿ�
  * ��������: ����������DAO�ӿ�
  * ������¼: 2011/04/29
  * �޸ļ�¼: 
  */
public interface SOC0115DAO extends BaseHibernateDAO<SOC0115Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0115Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0115Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0115SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0115Info> findByCond(
			final SOC0115SearchCond cond, final int start,
			final int count);

}