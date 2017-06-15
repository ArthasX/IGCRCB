/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0116Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0116SearchCond;

/**
  * ����: EiWaitTaskTempDAO�ӿ�
  * ��������: EiWaitTaskTempDAO�ӿ�
  * ������¼: 2012/07/30
  * �޸ļ�¼: 
  */
public interface SOC0116DAO extends BaseHibernateDAO<SOC0116Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0116Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0116Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0116SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0116Info> findByCond(
			final SOC0116SearchCond cond, final int start,
			final int count);

}