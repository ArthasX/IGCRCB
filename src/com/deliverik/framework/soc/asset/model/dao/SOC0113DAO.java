/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0113SearchCond;

/**
  * ����: �����������DAO�ӿ�
  * ��������: �����������DAO�ӿ�
  * ������¼: 2011/05/05
  * �޸ļ�¼: 
  */
public interface SOC0113DAO extends BaseHibernateDAO<SOC0113Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0113Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0113Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0113SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0113Info> findByCond(
			final SOC0113SearchCond cond, final int start,
			final int count);

}