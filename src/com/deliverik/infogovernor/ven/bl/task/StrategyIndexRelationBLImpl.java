/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.ven.model.StrategyIndexRelationInfo;
import com.deliverik.infogovernor.ven.model.condition.StrategyIndexRelationSearchCond;
import com.deliverik.infogovernor.ven.model.dao.StrategyIndexRelationDAO;
import com.deliverik.infogovernor.ven.model.entity.StrategyIndexRelationTB;

/**
  * ����: ���ղ���ָ���ϵ��ҵ���߼�ʵ��
  * ��������: ���ղ���ָ���ϵ��ҵ���߼�ʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public class StrategyIndexRelationBLImpl extends BaseBLImpl implements
		StrategyIndexRelationBL {

	/** ���ղ���ָ���ϵ��DAO�ӿ� */
	protected StrategyIndexRelationDAO strategyIndexRelationDAO;
	
	/**
	 * ���ղ���ָ���ϵ��DAO�ӿ��趨
	 *
	 * @param strategyIndexRelationDAO ���ղ���ָ���ϵ��DAO�ӿ�
	 */
	public void setStrategyIndexRelationDAO(StrategyIndexRelationDAO strategyIndexRelationDAO) {
		this.strategyIndexRelationDAO = strategyIndexRelationDAO;
	}

	/**
	 * ���ղ���ָ���ϵ��ʵ��ȡ��
	 *
	 * @return ���ղ���ָ���ϵ��ʵ��
	 */
	public StrategyIndexRelationTB getStrategyIndexRelationTBInstance() {
		return new StrategyIndexRelationTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<StrategyIndexRelationInfo> searchStrategyIndexRelation() {
		return strategyIndexRelationDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public StrategyIndexRelationInfo searchStrategyIndexRelationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(StrategyIndexRelationSearchCond cond) {
		return strategyIndexRelationDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<StrategyIndexRelationInfo> searchStrategyIndexRelation(
			StrategyIndexRelationSearchCond cond) {
		return strategyIndexRelationDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<StrategyIndexRelationInfo> searchStrategyIndexRelation(
			StrategyIndexRelationSearchCond cond, int start,
			int count) {
		return strategyIndexRelationDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public StrategyIndexRelationInfo registStrategyIndexRelation(StrategyIndexRelationInfo instance)
		throws BLException {
		return strategyIndexRelationDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public StrategyIndexRelationInfo updateStrategyIndexRelation(StrategyIndexRelationInfo instance)
		throws BLException {
		checkExistInstance(instance.getSirid());
		return strategyIndexRelationDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteStrategyIndexRelationByPK(Integer pk)
		throws BLException {
		strategyIndexRelationDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteStrategyIndexRelation(StrategyIndexRelationInfo instance)
		throws BLException {
		strategyIndexRelationDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public StrategyIndexRelationInfo checkExistInstance(Integer pk)
		throws BLException {
		StrategyIndexRelationInfo instance = strategyIndexRelationDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}