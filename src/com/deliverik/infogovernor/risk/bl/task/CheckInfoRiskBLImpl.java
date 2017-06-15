/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.CheckInfoRiskInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckInfoRiskSearchCond;
import com.deliverik.infogovernor.risk.model.dao.CheckInfoRiskDAO;
import com.deliverik.infogovernor.risk.model.entity.CheckInfoRiskTB;

/**
  * ����: �����Թ���������ҵ���߼�ʵ��
  * ��������: �����Թ���������ҵ���߼�ʵ��
  * ������¼: 2014/09/03
  * �޸ļ�¼: 
  */
public class CheckInfoRiskBLImpl extends BaseBLImpl implements
		CheckInfoRiskBL {

	/** �����Թ���������DAO�ӿ� */
	protected CheckInfoRiskDAO checkInfoRiskDAO;
	
	/**
	 * �����Թ���������DAO�ӿ��趨
	 *
	 * @param checkInfoRiskDAO �����Թ���������DAO�ӿ�
	 */
	public void setCheckInfoRiskDAO(CheckInfoRiskDAO checkInfoRiskDAO) {
		this.checkInfoRiskDAO = checkInfoRiskDAO;
	}

	/**
	 * �����Թ���������ʵ��ȡ��
	 *
	 * @return �����Թ���������ʵ��
	 */
	public CheckInfoRiskTB getCheckInfoRiskTBInstance() {
		return new CheckInfoRiskTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckInfoRiskInfo> searchCheckInfoRisk() {
		return checkInfoRiskDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckInfoRiskInfo searchCheckInfoRiskByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckInfoRiskSearchCond cond) {
		return checkInfoRiskDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckInfoRiskInfo> searchCheckInfoRisk(
			CheckInfoRiskSearchCond cond) {
		return checkInfoRiskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckInfoRiskInfo> searchCheckInfoRisk(
			CheckInfoRiskSearchCond cond, int start,
			int count) {
		return checkInfoRiskDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckInfoRiskInfo registCheckInfoRisk(CheckInfoRiskInfo instance)
		throws BLException {
		return checkInfoRiskDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckInfoRiskInfo updateCheckInfoRisk(CheckInfoRiskInfo instance)
		throws BLException {
		checkExistInstance(instance.getCieid());
		return checkInfoRiskDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckInfoRiskByPK(Integer pk)
		throws BLException {
		checkInfoRiskDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckInfoRisk(CheckInfoRiskInfo instance)
		throws BLException {
		checkInfoRiskDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CheckInfoRiskInfo checkExistInstance(Integer pk)
		throws BLException {
		CheckInfoRiskInfo instance = checkInfoRiskDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}