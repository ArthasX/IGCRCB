/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0419Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0419SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0419TB;

/**
  * ����: ��������ʵʱ��ҵ���߼��ӿ�
  * ��������: ��������ʵʱ��ҵ���߼��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/10 ��VGCapacityRealTimeBL�����޸�ΪSOC0419BL
  */
public interface SOC0419BL extends BaseBL {

	/**
	 * ��������ʵʱ��ʵ��ȡ��
	 *
	 * @return ��������ʵʱ��ʵ��
	 */
	public SOC0419TB getSOC0419Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0419Info> searchSOC0419();


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0419SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0419Info> searchSOC0419(
			SOC0419SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0419Info> searchSOC0419(
			SOC0419SearchCond cond, int start,
			int count);

}