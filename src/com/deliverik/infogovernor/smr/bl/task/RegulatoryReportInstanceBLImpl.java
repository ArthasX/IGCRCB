/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.ReportHistorySearchVWInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCond;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCondImpl;
import com.deliverik.infogovernor.smr.model.dao.RegulatoryReportInstanceDAO;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;

/**
  * ����: �����ʵ����ҵ���߼�ʵ��
  * ��������: �����ʵ����ҵ���߼�ʵ��
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
public class RegulatoryReportInstanceBLImpl extends BaseBLImpl implements
		RegulatoryReportInstanceBL {

	/** �����ʵ����DAO�ӿ� */
	protected RegulatoryReportInstanceDAO regulatoryReportInstanceDAO;
	
	/**
	 * �����ʵ����DAO�ӿ��趨
	 *
	 * @param regulatoryReportInstanceDAO �����ʵ����DAO�ӿ�
	 */
	public void setRegulatoryReportInstanceDAO(RegulatoryReportInstanceDAO regulatoryReportInstanceDAO) {
		this.regulatoryReportInstanceDAO = regulatoryReportInstanceDAO;
	}

	/**
	 * �����ʵ����ʵ��ȡ��
	 *
	 * @return �����ʵ����ʵ��
	 */
	public RegulatoryReportInstanceTB getRegulatoryReportInstanceTBInstance() {
		return new RegulatoryReportInstanceTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RegulatoryReportInstanceInfo> searchRegulatoryReportInstanceInfo() {
		return regulatoryReportInstanceDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RegulatoryReportInstanceInfo searchRegulatoryReportInstanceInfoByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RegulatoryReportInstanceSearchCond cond) {
		return regulatoryReportInstanceDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RegulatoryReportInstanceInfo> searchRegulatoryReportInstanceInfo(
			RegulatoryReportInstanceSearchCond cond) {
		return regulatoryReportInstanceDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return regulatoryReportInstanceDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RegulatoryReportInstanceInfo registRegulatoryReportInstanceInfo(RegulatoryReportInstanceInfo instance)
		throws BLException {
		checkKey(instance.getKey(),instance.getPrtype());
		return regulatoryReportInstanceDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RegulatoryReportInstanceInfo updateRegulatoryReportInstanceInfo(RegulatoryReportInstanceInfo instance)
		throws BLException {
		checkExistInstance(instance.getInstanceID());
		return regulatoryReportInstanceDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRegulatoryReportInstanceInfoByPK(Integer pk)
		throws BLException {
		regulatoryReportInstanceDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRegulatoryReportInstanceInfo(RegulatoryReportInstanceInfo instance)
		throws BLException {
		regulatoryReportInstanceDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public RegulatoryReportInstanceInfo checkExistInstance(Integer pk)
		throws BLException {
		RegulatoryReportInstanceInfo instance = regulatoryReportInstanceDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param key ���ʶ
	 * @return ʵ��
	 */
	public void checkKey(String key,String type) throws BLException {
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		cond.setKey_eq(key);
		cond.setStatus_eq(IGSMRCONSTANT.REPORT_STATUS_BEGIN);
		List<RegulatoryReportInstanceInfo> lst_Instance = regulatoryReportInstanceDAO.findByCond(cond);
		if (lst_Instance.size() > 0) {
			String info = IGSMRCONSTANT.PRYTPE_REPORT.equals(type) ? key + "��" : key;
			throw new BLException("IGSMR0101.E001", info);
		}
	}

	public List<AnnualReportVWInfo> findAnnualReportByCond(
			RegulatoryReportInstanceSearchCond cond, int start, int count) {
		
		return regulatoryReportInstanceDAO.findAnnualReportByCond(cond, start, count);
	}

	public List<RegulatoryReportInstanceInfo> findSectionAnnualReportByCond(
			RegulatoryReportInstanceSearchCond cond,int start, int count) {
	
		return regulatoryReportInstanceDAO.findSectionAnnualReportByCond(cond,start, count);
	}

	public List<BatchExamineVWInfo> findBatchExanmie(
			RegulatoryReportInstanceSearchCond cond) {
		
		return regulatoryReportInstanceDAO.findBatchExanmie(cond);
	}

	public List<ReportHistorySearchVWInfo> findReportHistory(
			RegulatoryReportInstanceSearchCond cond, int start, int count) {
		
		return regulatoryReportInstanceDAO.findReportHistory(cond, start, count);
	}

	public int findReportHistoryCount(RegulatoryReportInstanceSearchCond cond) {
		
		return regulatoryReportInstanceDAO.findReportHistoryCount(cond);
	}
	
	/**
	 * ɾ����Ч�ʵ��
	 * �����̾�ͣ�ú󣬱������̻ᱻɾ��
	 * ��ʵ����������Ч
	 */
	public void deleteTestInstance() throws BLException {
		this.regulatoryReportInstanceDAO.deleteTestInstance();
	}

	public List<AnnualReportVWInfo> lookatFillIn(
			RegulatoryReportInstanceSearchCond cond) {
		return regulatoryReportInstanceDAO.lookatFillIn(cond);
	}

}