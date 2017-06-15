/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportDetailSearchCond;

/**
  * ����: �������ϸ��DAO�ӿ�
  * ��������: �������ϸ��DAO�ӿ�
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
public interface RegulatoryReportDetailDAO extends BaseHibernateDAO<RegulatoryReportDetailInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RegulatoryReportDetailInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RegulatoryReportDetailInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RegulatoryReportDetailSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RegulatoryReportDetailInfo> findByCond(
			final RegulatoryReportDetailSearchCond cond, final int start,
			final int count);

}