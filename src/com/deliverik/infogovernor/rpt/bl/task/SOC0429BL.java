/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0429Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0429SearchCond;

/**
  * ����: ����������ͼҵ���߼��ӿ�
  * ��������: ����������ͼҵ���߼��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��HostCapacityRealTimeVWBL������ΪSOC0429BL
  */
public interface SOC0429BL extends BaseBL {


	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0429Info> searchSOC0429();


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0429SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0429Info> searchSOC0429(
			SOC0429SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0429Info> searchSOC0429(
			SOC0429SearchCond cond, int start,
			int count);

}