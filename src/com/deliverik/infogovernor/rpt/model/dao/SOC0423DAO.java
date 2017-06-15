/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0423SearchCond;

/**
  * ����: ���������DAO�ӿ�
  * ��������: ���������DAO�ӿ�
  * ������¼: 2012/07/17
  * �޸ļ�¼: 2012/08/09 ��CapacityObjectListDAO������ΪSOC0423DAO
  */
public interface SOC0423DAO extends BaseHibernateDAO<SOC0423Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0423Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0423Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0423SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0423Info> findByCond(
			final SOC0423SearchCond cond, final int start,
			final int count);

}