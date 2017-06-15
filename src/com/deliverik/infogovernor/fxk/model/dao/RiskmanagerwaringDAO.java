/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.fxk.model.RiskmanagerwaringInfo;
import com.deliverik.infogovernor.fxk.model.condition.RiskmanagerwaringSearchCond;

/**
  * ����: ���չ�����ʾ���ݱ�DAO�ӿ�
  * ��������: ���չ�����ʾ���ݱ�DAO�ӿ�
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public interface RiskmanagerwaringDAO extends BaseHibernateDAO<RiskmanagerwaringInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskmanagerwaringInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskmanagerwaringInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskmanagerwaringSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskmanagerwaringInfo> findByCond(
			final RiskmanagerwaringSearchCond cond, final int start,
			final int count);

}