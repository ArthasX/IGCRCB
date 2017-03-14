/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0405Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0405SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0405TB;

/**
  * ����: �߼�������ʵʱ��ҵ���߼��ӿ�
  * ��������: �߼�������ʵʱ��ҵ���߼��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��LVCapacityRealTimeBL�޸�ΪSOC0405BL
  */
public interface SOC0405BL extends BaseBL {

	/**
	 * �߼�������ʵʱ��ʵ��ȡ��
	 *
	 * @return �߼�������ʵʱ��ʵ��
	 */
	public SOC0405TB getSOC0405Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0405Info> searchSOC0405();


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0405SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0405Info> searchSOC0405(
			SOC0405SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0405Info> searchSOC0405(
			SOC0405SearchCond cond, int start,
			int count);

}