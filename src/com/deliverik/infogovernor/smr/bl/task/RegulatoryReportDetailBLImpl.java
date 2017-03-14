/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportDetailSearchCond;
import com.deliverik.infogovernor.smr.model.dao.RegulatoryReportDetailDAO;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportDetailTB;

/**
  * ����: �������ϸ��ҵ���߼�ʵ��
  * ��������: �������ϸ��ҵ���߼�ʵ��
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
public class RegulatoryReportDetailBLImpl extends BaseBLImpl implements
		RegulatoryReportDetailBL {

	/** �������ϸ��DAO�ӿ� */
	protected RegulatoryReportDetailDAO regulatoryReportDetailDAO;
	
	/**
	 * �������ϸ��DAO�ӿ��趨
	 *
	 * @param regulatoryReportDetailDAO �������ϸ��DAO�ӿ�
	 */
	public void setRegulatoryReportDetailDAO(RegulatoryReportDetailDAO regulatoryReportDetailDAO) {
		this.regulatoryReportDetailDAO = regulatoryReportDetailDAO;
	}

	/**
	 * �������ϸ��ʵ��ȡ��
	 *
	 * @return �������ϸ��ʵ��
	 */
	public RegulatoryReportDetailTB getRegulatoryReportDetailTBInstance() {
		return new RegulatoryReportDetailTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RegulatoryReportDetailInfo> searchRegulatoryReportDetailInfo() {
		return regulatoryReportDetailDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RegulatoryReportDetailInfo searchRegulatoryReportDetailInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RegulatoryReportDetailSearchCond cond) {
		return regulatoryReportDetailDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RegulatoryReportDetailInfo> searchRegulatoryReportDetailInfo(
			RegulatoryReportDetailSearchCond cond) {
		return regulatoryReportDetailDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return regulatoryReportDetailDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RegulatoryReportDetailInfo registRegulatoryReportDetailInfo(RegulatoryReportDetailInfo instance)
		throws BLException {
		return regulatoryReportDetailDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RegulatoryReportDetailInfo updateRegulatoryReportDetailInfo(RegulatoryReportDetailInfo instance)
		throws BLException {
		checkExistInstance(instance.getDetailID());
		return regulatoryReportDetailDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRegulatoryReportDetailInfoByPK(Integer pk)
		throws BLException {
		regulatoryReportDetailDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRegulatoryReportDetailInfo(RegulatoryReportDetailInfo instance)
		throws BLException {
		regulatoryReportDetailDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RegulatoryReportDetailInfo checkExistInstance(Integer pk)
		throws BLException {
		RegulatoryReportDetailInfo instance = regulatoryReportDetailDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}