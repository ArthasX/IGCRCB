/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.ReportHistorySearchVWInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCond;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;

/**
  * ����: �����ʵ����ҵ���߼��ӿ�
  * ��������: �����ʵ����ҵ���߼��ӿ�
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
public interface RegulatoryReportInstanceBL extends BaseBL {

	/**
	 * �����ʵ����ʵ��ȡ��
	 *
	 * @return �����ʵ����ʵ��
	 */
	public RegulatoryReportInstanceTB getRegulatoryReportInstanceTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RegulatoryReportInstanceInfo> searchRegulatoryReportInstanceInfo();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RegulatoryReportInstanceInfo searchRegulatoryReportInstanceInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RegulatoryReportInstanceSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RegulatoryReportInstanceInfo> searchRegulatoryReportInstanceInfo(
			RegulatoryReportInstanceSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RegulatoryReportInstanceInfo> searchRegulatoryReportInstanceInfo(
			RegulatoryReportInstanceSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RegulatoryReportInstanceInfo registRegulatoryReportInstanceInfo(RegulatoryReportInstanceInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RegulatoryReportInstanceInfo updateRegulatoryReportInstanceInfo(RegulatoryReportInstanceInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRegulatoryReportInstanceInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRegulatoryReportInstanceInfo(RegulatoryReportInstanceInfo instance)
		throws BLException;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AnnualReportVWInfo> findAnnualReportByCond(
			final RegulatoryReportInstanceSearchCond cond,int start, int count);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RegulatoryReportInstanceInfo> findSectionAnnualReportByCond(
			final RegulatoryReportInstanceSearchCond cond,int start, int count);
	
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
	 * ɾ����Ч�ʵ��
	 * �����̾�ͣ�ú󣬱������̻ᱻɾ��
	 * ��ʵ����������Ч
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