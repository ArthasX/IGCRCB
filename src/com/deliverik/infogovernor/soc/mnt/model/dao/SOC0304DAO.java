/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0304SearchCond;

/**
  * ����: �����������DAO�ӿ�
  * ��������: �����������DAO�ӿ�
  * ������¼: 2012/05/10
  * �޸ļ�¼: 
  */
public interface SOC0304DAO extends BaseHibernateDAO<SOC0304Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0304Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0304Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0304SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0304Info> findByCond(
			final SOC0304SearchCond cond, final int start,
			final int count);

}