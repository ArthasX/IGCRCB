/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.ven.model.StrategyIndexRelationInfo;
import com.deliverik.infogovernor.ven.model.condition.StrategyIndexRelationSearchCond;
import com.deliverik.infogovernor.ven.model.entity.StrategyIndexRelationTB;

/**
  * ����: ���ղ���ָ���ϵ��ҵ���߼��ӿ�
  * ��������: ���ղ���ָ���ϵ��ҵ���߼��ӿ�
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public interface StrategyIndexRelationBL extends BaseBL {

	/**
	 * ���ղ���ָ���ϵ��ʵ��ȡ��
	 *
	 * @return ���ղ���ָ���ϵ��ʵ��
	 */
	public StrategyIndexRelationTB getStrategyIndexRelationTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<StrategyIndexRelationInfo> searchStrategyIndexRelation();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public StrategyIndexRelationInfo searchStrategyIndexRelationByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(StrategyIndexRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<StrategyIndexRelationInfo> searchStrategyIndexRelation(
			StrategyIndexRelationSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public StrategyIndexRelationInfo registStrategyIndexRelation(StrategyIndexRelationInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public StrategyIndexRelationInfo updateStrategyIndexRelation(StrategyIndexRelationInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteStrategyIndexRelationByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteStrategyIndexRelation(StrategyIndexRelationInfo instance)
		throws BLException;

}