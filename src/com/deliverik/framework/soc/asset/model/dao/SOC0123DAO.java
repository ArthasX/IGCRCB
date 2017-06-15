/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0123SearchCond;

/**
  * ����: �ʲ�ģ����ͼDAO�ӿ�
  * ��������: �ʲ�ģ����ͼDAO�ӿ�
  * ������¼: 2011/04/21
  * �޸ļ�¼: 
  */
public interface SOC0123DAO extends BaseHibernateDAO<SOC0123Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0123Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0123Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0123SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0123Info> findByCond(
			final SOC0123SearchCond cond, final int start,
			final int count);

}