/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.ReportHistorySearchVWInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCond;

/**
  * ����: �����ʵ����DAO�ӿ�
  * ��������: �����ʵ����DAO�ӿ�
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
public interface RegulatoryReportInstanceDAO extends BaseHibernateDAO<RegulatoryReportInstanceInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RegulatoryReportInstanceInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RegulatoryReportInstanceInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RegulatoryReportInstanceSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RegulatoryReportInstanceInfo> findByCond(
			final RegulatoryReportInstanceSearchCond cond, final int start,
			final int count);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RegulatoryReportInstanceInfo> findByCond(
			final RegulatoryReportInstanceSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AnnualReportVWInfo> findAnnualReportByCond(
			final RegulatoryReportInstanceSearchCond cond,final int start,final int count);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RegulatoryReportInstanceInfo> findSectionAnnualReportByCond(
			final RegulatoryReportInstanceSearchCond cond,final int start,final int count);
	
	/**
	 * ��ѯ�걨�����ڵ����������
	 * @return ��������б�
	 */
	public List<BatchExamineVWInfo> findBatchExanmie(final RegulatoryReportInstanceSearchCond cond);
	
	
	/**
	 * ��ѯ������ʷ
	 * @return ��������б�
	 */
	public List<ReportHistorySearchVWInfo> findReportHistory(final RegulatoryReportInstanceSearchCond cond,final int start,final int count);
	
	/**
	 * ��ѯ������ʷ����
	 * @return ��������б�
	 */
	public int findReportHistoryCount(final RegulatoryReportInstanceSearchCond cond);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public void deleteTestInstance() throws BLException;
	
	/**
	 * ��ල
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public List<AnnualReportVWInfo> lookatFillIn(final RegulatoryReportInstanceSearchCond cond);
}