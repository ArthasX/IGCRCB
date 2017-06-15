/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportDetailSearchCond;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportDetailTB;

/**
  * ����: �������ϸ��ҵ���߼��ӿ�
  * ��������: �������ϸ��ҵ���߼��ӿ�
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
public interface RegulatoryReportDetailBL extends BaseBL {

	/**
	 * �������ϸ��ʵ��ȡ��
	 *
	 * @return �������ϸ��ʵ��
	 */
	public RegulatoryReportDetailTB getRegulatoryReportDetailTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RegulatoryReportDetailInfo> searchRegulatoryReportDetailInfo();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RegulatoryReportDetailInfo searchRegulatoryReportDetailInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RegulatoryReportDetailSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RegulatoryReportDetailInfo> searchRegulatoryReportDetailInfo(
			RegulatoryReportDetailSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RegulatoryReportDetailInfo> searchRegulatoryReportDetailInfo(
			RegulatoryReportDetailSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RegulatoryReportDetailInfo registRegulatoryReportDetailInfo(RegulatoryReportDetailInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RegulatoryReportDetailInfo updateRegulatoryReportDetailInfo(RegulatoryReportDetailInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRegulatoryReportDetailInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRegulatoryReportDetailInfo(RegulatoryReportDetailInfo instance)
		throws BLException;

}