/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0151VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0151VWSearchCond;

/**
  * ����: SOC0151VWDAO�ӿ�
  * ��������: SOC0151VWDAO�ӿ�
  * ������¼: 2016/06/23
  * �޸ļ�¼: 
  */
public interface SOC0151VWDAO extends BaseHibernateDAO<SOC0151VWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0151VWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0151VWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0151VWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0151VWInfo> findByCond(
			final SOC0151VWSearchCond cond, final int start,
			final int count);
	/**
	 * ��ȡȡֵ��Χ��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ConfigurationCodeDetailBean> findConfigurationCodeDetailBean(final SOC0151VWSearchCond cond);
}