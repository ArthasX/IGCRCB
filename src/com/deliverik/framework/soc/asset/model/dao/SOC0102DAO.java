/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0102Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0102SearchCond;

/**
  * ����: ����ʲ���DAO�ӿ�
  * ��������: ����ʲ���DAO�ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface SOC0102DAO extends BaseHibernateDAO<SOC0102Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0102Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0102Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0102SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0102Info> findByCond(
			final SOC0102SearchCond cond, final int start,
			final int count);

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteSOC0102();

}