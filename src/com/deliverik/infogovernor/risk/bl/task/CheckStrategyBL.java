/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.CheckStrategyInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckStrategySearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckStrategyTB;

/**
  * ����: ������ҵ���߼��ӿ�
  * ��������: ������ҵ���߼��ӿ�
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public interface CheckStrategyBL extends BaseBL {

	/**
	 * ������ʵ��ȡ��
	 *
	 * @return ������ʵ��
	 */
	public CheckStrategyTB getCheckStrategyTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckStrategyInfo> searchCheckStrategy();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckStrategyInfo searchCheckStrategyByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckStrategySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckStrategyInfo> searchCheckStrategy(
			CheckStrategySearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckStrategyInfo registCheckStrategy(CheckStrategyInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckStrategyInfo updateCheckStrategy(CheckStrategyInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckStrategyByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckStrategy(CheckStrategyInfo instance)
		throws BLException;
}