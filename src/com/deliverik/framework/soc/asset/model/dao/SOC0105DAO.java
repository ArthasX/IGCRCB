/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0105Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0105SearchCond;

/**
  * ����: ��ƴ���������DAO�ӿ�
  * ��������: ��ƴ���������DAO�ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface SOC0105DAO extends BaseHibernateDAO<SOC0105Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0105Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0105Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0105SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0105Info> findByCond(
			final SOC0105SearchCond cond, final int start,
			final int count);

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteAll();

}