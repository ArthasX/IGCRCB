/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0305Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCond;

/**
  * ����: StorageEventDAO�ӿ�
  * ��������: StorageEventDAO�ӿ�
  * ������¼: 2011/06/13
  * �޸ļ�¼: 
  */
public interface SOC0305DAO extends BaseHibernateDAO<SOC0305Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0305Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0305Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0305SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0305Info> findByCond(
			final SOC0305SearchCond cond, final int start,
			final int count);

}