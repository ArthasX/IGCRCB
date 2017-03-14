/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.risk.model.CheckStrategyInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckStrategySearchCond;
import com.deliverik.infogovernor.risk.model.dao.CheckStrategyDAO;
import com.deliverik.infogovernor.risk.model.entity.CheckStrategyTB;

/**
  * ����: ������ҵ���߼�ʵ��
  * ��������: ������ҵ���߼�ʵ��
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public class CheckStrategyBLImpl extends BaseBLImpl implements
		CheckStrategyBL {

	/** ������DAO�ӿ� */
	protected CheckStrategyDAO checkStrategyDAO;
	
	/**
	 * ������DAO�ӿ��趨
	 *
	 * @param checkStrategyDAO ������DAO�ӿ�
	 */
	public void setCheckStrategyDAO(CheckStrategyDAO checkStrategyDAO) {
		this.checkStrategyDAO = checkStrategyDAO;
	}

	/**
	 * ������ʵ��ȡ��
	 *
	 * @return ������ʵ��
	 */
	public CheckStrategyTB getCheckStrategyTBInstance() {
		return new CheckStrategyTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckStrategyInfo> searchCheckStrategy() {
		return checkStrategyDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckStrategyInfo searchCheckStrategyByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckStrategySearchCond cond) {
		return checkStrategyDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckStrategyInfo> searchCheckStrategy(
			CheckStrategySearchCond cond) {
		return checkStrategyDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckStrategyInfo> searchCheckStrategy(
			CheckStrategySearchCond cond, int start,
			int count) {
		return checkStrategyDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckStrategyInfo registCheckStrategy(CheckStrategyInfo instance)
		throws BLException {
		return checkStrategyDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckStrategyInfo updateCheckStrategy(CheckStrategyInfo instance)
		throws BLException {
		checkExistInstance(instance.getCsid());
		return checkStrategyDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckStrategyByPK(Integer pk)
		throws BLException {
		checkStrategyDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckStrategy(CheckStrategyInfo instance)
		throws BLException {
		checkStrategyDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CheckStrategyInfo checkExistInstance(Integer pk)
		throws BLException {
		CheckStrategyInfo instance = checkStrategyDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	

}