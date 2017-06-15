/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.IndicatorLightsSystemInfo;
import com.deliverik.framework.soc.asset.model.condition.IndicatorLightsSystemSearchCond;
import com.deliverik.framework.soc.asset.model.entity.IndicatorLightsSystemTB;

/**
  * ����: �澯ϵͳ��ʾ��Ϣ��ҵ���߼��ӿ�
  * ��������: �澯ϵͳ��ʾ��Ϣ��ҵ���߼��ӿ�
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public interface IndicatorLightsSystemBL extends BaseBL {

	/**
	 * �澯ϵͳ��ʾ��Ϣ��ʵ��ȡ��
	 *
	 * @return �澯ϵͳ��ʾ��Ϣ��ʵ��
	 */
	public IndicatorLightsSystemTB getIndicatorLightsSystemTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IndicatorLightsSystemInfo> searchIndicatorLightsSystem();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IndicatorLightsSystemInfo searchIndicatorLightsSystemByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IndicatorLightsSystemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IndicatorLightsSystemInfo> searchIndicatorLightsSystem(
			IndicatorLightsSystemSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IndicatorLightsSystemInfo> searchIndicatorLightsSystem(
			IndicatorLightsSystemSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IndicatorLightsSystemInfo registIndicatorLightsSystem(IndicatorLightsSystemInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IndicatorLightsSystemInfo updateIndicatorLightsSystem(IndicatorLightsSystemInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIndicatorLightsSystemByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIndicatorLightsSystem(IndicatorLightsSystemInfo instance)
		throws BLException;

}