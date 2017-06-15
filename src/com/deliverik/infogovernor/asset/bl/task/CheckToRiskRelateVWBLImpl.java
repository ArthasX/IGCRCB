/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.CheckToRiskRelateVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckToRiskRelateVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.CheckToRiskRelateVWDAO;
import com.deliverik.infogovernor.asset.model.entity.CheckToRiskRelateVW;

/**
  * ����: �������յ��ϵģ��ҵ���߼�ʵ��
  * ��������: �������յ��ϵģ��ҵ���߼�ʵ��
  * ������¼: 2014/07/23
  * �޸ļ�¼: 
  */
public class CheckToRiskRelateVWBLImpl extends BaseBLImpl implements
		CheckToRiskRelateVWBL {

	/** �������յ��ϵģ��DAO�ӿ� */
	protected CheckToRiskRelateVWDAO checkToRiskRelateVWDAO;
	
	/**
	 * �������յ��ϵģ��DAO�ӿ��趨
	 *
	 * @param checkToRiskRelateVWDAO �������յ��ϵģ��DAO�ӿ�
	 */
	public void setCheckToRiskRelateVWDAO(CheckToRiskRelateVWDAO checkToRiskRelateVWDAO) {
		this.checkToRiskRelateVWDAO = checkToRiskRelateVWDAO;
	}

	/**
	 * �������յ��ϵģ��ʵ��ȡ��
	 *
	 * @return �������յ��ϵģ��ʵ��
	 */
	public CheckToRiskRelateVW getCheckToRiskRelateVWInstance() {
		return new CheckToRiskRelateVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckToRiskRelateVWInfo> searchCheckToRiskRelateVW() {
		return checkToRiskRelateVWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckToRiskRelateVWInfo searchCheckToRiskRelateVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckToRiskRelateVWSearchCond cond) {
		return checkToRiskRelateVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckToRiskRelateVWInfo> searchCheckToRiskRelateVW(
			CheckToRiskRelateVWSearchCond cond) {
		return checkToRiskRelateVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckToRiskRelateVWInfo> searchCheckToRiskRelateVW(
			CheckToRiskRelateVWSearchCond cond, int start,
			int count) {
		return checkToRiskRelateVWDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckToRiskRelateVWInfo registCheckToRiskRelateVW(CheckToRiskRelateVWInfo instance)
		throws BLException {
		return checkToRiskRelateVWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckToRiskRelateVWInfo updateCheckToRiskRelateVW(CheckToRiskRelateVWInfo instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return checkToRiskRelateVWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckToRiskRelateVWByPK(Integer pk)
		throws BLException {
		checkToRiskRelateVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckToRiskRelateVW(CheckToRiskRelateVWInfo instance)
		throws BLException {
		checkToRiskRelateVWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CheckToRiskRelateVWInfo checkExistInstance(Integer pk)
		throws BLException {
		CheckToRiskRelateVWInfo instance = checkToRiskRelateVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}