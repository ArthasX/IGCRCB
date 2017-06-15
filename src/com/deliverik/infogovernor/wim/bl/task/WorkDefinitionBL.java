/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkDefinitionSearchCond;
import com.deliverik.infogovernor.wim.model.entity.WorkDefinitionTB;

/**
  * ����: WorkDefinitionҵ���߼��ӿ�
  * ��������: WorkDefinitionҵ���߼��ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkDefinitionBL extends BaseBL {

	/**
	 * WorkDefinitionʵ��ȡ��
	 *
	 * @return WorkDefinitionʵ��
	 */
	public WorkDefinitionTB getWorkDefinitionTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkDefinitionInfo> searchWorkDefinition();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkDefinitionInfo searchWorkDefinitionByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(WorkDefinitionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<WorkDefinitionInfo> searchWorkDefinition(
			WorkDefinitionSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkDefinitionInfo> searchWorkDefinition(
			WorkDefinitionSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public WorkDefinitionInfo registWorkDefinition(WorkDefinitionInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public WorkDefinitionInfo updateWorkDefinition(WorkDefinitionInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteWorkDefinitionByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteWorkDefinition(WorkDefinitionInfo instance)
		throws BLException;

}