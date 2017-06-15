/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sta.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.model.entity.DispatchStatisticsVW;
import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;
import com.deliverik.infogovernor.sta.model.condition.RiskCheckProblemSuperviseVWSearchCond;

/**
  * ����: �������ļලҵ���߼��ӿ�
  * ��������: �������ļලҵ���߼��ӿ�
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public interface RiskCheckProblemSuperviseVWBL extends BaseBL {

	/**
	 * ��������ͳ��ʵ��ȡ��
	 *
	 * @return ��������ͳ��ʵ��
	 */
	public DispatchStatisticsVW getDispatchStatisticsVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskCheckProblemSuperviseVWInfo> searchDispatchStatisticsVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskCheckProblemSuperviseVWInfo searchDispatchStatisticsVWByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RiskCheckProblemSuperviseVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskCheckProblemSuperviseVWInfo> searchDispatchStatisticsVW(
			RiskCheckProblemSuperviseVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckProblemSuperviseVWInfo> searchDispatchStatisticsVW(
			RiskCheckProblemSuperviseVWSearchCond cond, int start,
			int count);

	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RiskCheckProblemSuperviseVWInfo> findDispatchStatisticsVW(
			RiskCheckProblemSuperviseVWSearchCond cond, int start,int count);
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getRiskCheckProblemSuperviseSearchCount(RiskCheckProblemSuperviseVWSearchCond cond);

}