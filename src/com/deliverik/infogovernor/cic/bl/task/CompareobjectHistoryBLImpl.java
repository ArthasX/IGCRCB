/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.cic.model.CompareobjectHistoryInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectHistorySearchCond;
import com.deliverik.infogovernor.cic.model.dao.CompareobjectHistoryDAO;
import com.deliverik.infogovernor.cic.model.entity.CompareobjectHistoryTB;

/**
  * ����: �Աȶ�����ʷ��ҵ���߼�ʵ��
  * ��������: �Աȶ�����ʷ��ҵ���߼�ʵ��
  * ������¼: 2014/04/24
  * �޸ļ�¼: 
  */
public class CompareobjectHistoryBLImpl extends BaseBLImpl implements
		CompareobjectHistoryBL {

	/** �Աȶ�����ʷ��DAO�ӿ� */
	protected CompareobjectHistoryDAO compareobjectHistoryDAO;
	
	/**
	 * �Աȶ�����ʷ��DAO�ӿ��趨
	 *
	 * @param compareobjectHistoryDAO �Աȶ�����ʷ��DAO�ӿ�
	 */
	public void setCompareobjectHistoryDAO(CompareobjectHistoryDAO compareobjectHistoryDAO) {
		this.compareobjectHistoryDAO = compareobjectHistoryDAO;
	}

	/**
	 * �Աȶ�����ʷ��ʵ��ȡ��
	 *
	 * @return �Աȶ�����ʷ��ʵ��
	 */
	public CompareobjectHistoryTB getCompareobjectHistoryTBInstance() {
		return new CompareobjectHistoryTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareobjectHistoryInfo> searchCompareobjectHistory() {
		return compareobjectHistoryDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareobjectHistoryInfo searchCompareobjectHistoryByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareobjectHistorySearchCond cond) {
		return compareobjectHistoryDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareobjectHistoryInfo> searchCompareobjectHistory(
			CompareobjectHistorySearchCond cond) {
		return compareobjectHistoryDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareobjectHistoryInfo> searchCompareobjectHistory(
			CompareobjectHistorySearchCond cond, int start,
			int count) {
		return compareobjectHistoryDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareobjectHistoryInfo registCompareobjectHistory(CompareobjectHistoryInfo instance)
		throws BLException {
		return compareobjectHistoryDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareobjectHistoryInfo updateCompareobjectHistory(CompareobjectHistoryInfo instance)
		throws BLException {
		checkExistInstance(instance.getCohid());
		return compareobjectHistoryDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareobjectHistoryByPK(Integer pk)
		throws BLException {
		compareobjectHistoryDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCompareobjectHistory(CompareobjectHistoryInfo instance)
		throws BLException {
		compareobjectHistoryDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CompareobjectHistoryInfo checkExistInstance(Integer pk)
		throws BLException {
		CompareobjectHistoryInfo instance = compareobjectHistoryDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}