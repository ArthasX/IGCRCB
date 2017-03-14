/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.rpt.model.SOC0428Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0428SearchCond;

/**
  * ����: ҵ��ϵͳ��ͼDAO�ӿ�
  * ��������: ҵ��ϵͳ��ͼDAO�ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��BusinessCapacityRealTimeVWDAO������ΪSOC0428DAO
  */
public interface SOC0428DAO extends BaseHibernateDAO<SOC0428Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0428Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0428Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0428SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0428Info> findByCond(
			final SOC0428SearchCond cond, final int start,
			final int count);

}