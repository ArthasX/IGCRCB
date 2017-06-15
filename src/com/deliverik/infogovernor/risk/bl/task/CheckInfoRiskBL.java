/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.CheckInfoRiskInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckInfoRiskSearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckInfoRiskTB;

/**
  * ����: �����Թ���������ҵ���߼��ӿ�
  * ��������: �����Թ���������ҵ���߼��ӿ�
  * ������¼: 2014/09/03
  * �޸ļ�¼: 
  */
public interface CheckInfoRiskBL extends BaseBL {

	/**
	 * �����Թ���������ʵ��ȡ��
	 *
	 * @return �����Թ���������ʵ��
	 */
	public CheckInfoRiskTB getCheckInfoRiskTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckInfoRiskInfo> searchCheckInfoRisk();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckInfoRiskInfo searchCheckInfoRiskByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckInfoRiskSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckInfoRiskInfo> searchCheckInfoRisk(
			CheckInfoRiskSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckInfoRiskInfo registCheckInfoRisk(CheckInfoRiskInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckInfoRiskInfo updateCheckInfoRisk(CheckInfoRiskInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckInfoRiskByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckInfoRisk(CheckInfoRiskInfo instance)
		throws BLException;

}