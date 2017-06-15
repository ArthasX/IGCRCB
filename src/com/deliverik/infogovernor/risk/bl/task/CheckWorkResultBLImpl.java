/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkResultSearchCond;
import com.deliverik.infogovernor.risk.model.dao.CheckWorkResultDAO;
import com.deliverik.infogovernor.risk.model.entity.CheckWorkResultTB;

/**
  * ����: �������ҵ���߼�ʵ��
  * ��������: �������ҵ���߼�ʵ��
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public class CheckWorkResultBLImpl extends BaseBLImpl implements
		CheckWorkResultBL {

	/** �������DAO�ӿ� */
	protected CheckWorkResultDAO checkWorkResultDAO;
	
	/**
	 * �������DAO�ӿ��趨
	 *
	 * @param checkWorkResultDAO �������DAO�ӿ�
	 */
	public void setCheckWorkResultDAO(CheckWorkResultDAO checkWorkResultDAO) {
		this.checkWorkResultDAO = checkWorkResultDAO;
	}

	/**
	 * �������ʵ��ȡ��
	 *
	 * @return �������ʵ��
	 */
	public CheckWorkResultTB getCheckWorkResultTBInstance() {
		return new CheckWorkResultTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckWorkResultInfo> searchCheckWorkResult() {
		return checkWorkResultDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckWorkResultInfo searchCheckWorkResultByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckWorkResultSearchCond cond) {
		return checkWorkResultDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckWorkResultInfo> searchCheckWorkResult(
			CheckWorkResultSearchCond cond) {
		return checkWorkResultDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckWorkResultInfo> searchCheckWorkResult(
			CheckWorkResultSearchCond cond, int start,
			int count) {
		return checkWorkResultDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckWorkResultInfo registCheckWorkResult(CheckWorkResultInfo instance)
		throws BLException {
		return checkWorkResultDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckWorkResultInfo updateCheckWorkResult(CheckWorkResultInfo instance)
		throws BLException {
		checkExistInstance(instance.getCwrid());
		return checkWorkResultDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckWorkResultByPK(Integer pk)
		throws BLException {
		checkWorkResultDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckWorkResult(CheckWorkResultInfo instance)
		throws BLException {
		checkWorkResultDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CheckWorkResultInfo checkExistInstance(Integer pk)
		throws BLException {
		CheckWorkResultInfo instance = checkWorkResultDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}