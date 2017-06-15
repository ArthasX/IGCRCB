/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.SOC0154Info;
import com.deliverik.infogovernor.soc.vir.model.condition.SOC0154SearchCond;

/**
  * ����: soc0154DAO�ӿ�
  * ��������: soc0154DAO�ӿ�
  * ������¼: 2013/12/29
  * �޸ļ�¼: 
  */
public interface SOC0154DAO extends BaseHibernateDAO<SOC0154Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0154Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0154Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0154SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0154Info> findByCond(
			final SOC0154SearchCond cond, final int start,
			final int count);

}