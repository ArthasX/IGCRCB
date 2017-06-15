/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.CheckworkInfoResultInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckworkInfoResultSearchCond;
import com.deliverik.infogovernor.risk.model.dao.CheckworkInfoResultDAO;
import com.deliverik.infogovernor.risk.model.entity.CheckworkInfoResultTB;

/**
  * ����: ��鹤��������������ҵ���߼�ʵ��
  * ��������: ��鹤��������������ҵ���߼�ʵ��
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public class CheckworkInfoResultBLImpl extends BaseBLImpl implements
		CheckworkInfoResultBL {

	/** ��鹤��������������DAO�ӿ� */
	protected CheckworkInfoResultDAO checkworkInfoResultDAO;
	
	/**
	 * ��鹤��������������DAO�ӿ��趨
	 *
	 * @param checkworkInfoResultDAO ��鹤��������������DAO�ӿ�
	 */
	public void setCheckworkInfoResultDAO(CheckworkInfoResultDAO checkworkInfoResultDAO) {
		this.checkworkInfoResultDAO = checkworkInfoResultDAO;
	}

	/**
	 * ��鹤��������������ʵ��ȡ��
	 *
	 * @return ��鹤��������������ʵ��
	 */
	public CheckworkInfoResultTB getCheckworkInfoResultTBInstance() {
		return new CheckworkInfoResultTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckworkInfoResultInfo> searchCheckworkInfoResult() {
		return checkworkInfoResultDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckworkInfoResultInfo searchCheckworkInfoResultByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckworkInfoResultSearchCond cond) {
		return checkworkInfoResultDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckworkInfoResultInfo> searchCheckworkInfoResult(
			CheckworkInfoResultSearchCond cond) {
		return checkworkInfoResultDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckworkInfoResultInfo> searchCheckworkInfoResult(
			CheckworkInfoResultSearchCond cond, int start,
			int count) {
		return checkworkInfoResultDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckworkInfoResultInfo registCheckworkInfoResult(CheckworkInfoResultInfo instance)
		throws BLException {
		return checkworkInfoResultDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckworkInfoResultInfo updateCheckworkInfoResult(CheckworkInfoResultInfo instance)
		throws BLException {
		checkExistInstance(instance.getCwirid());
		return checkworkInfoResultDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckworkInfoResultByPK(Integer pk)
		throws BLException {
		checkworkInfoResultDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckworkInfoResult(CheckworkInfoResultInfo instance)
		throws BLException {
		checkworkInfoResultDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CheckworkInfoResultInfo checkExistInstance(Integer pk)
		throws BLException {
		CheckworkInfoResultInfo instance = checkworkInfoResultDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}