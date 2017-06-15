/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0415Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0415SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0415TB;

/**
  * ����: ��ռ�����ʵʱ��ҵ���߼��ӿ�
  * ��������: ��ռ�����ʵʱ��ҵ���߼��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/10 ��TSCapacityRealTimeBL�����޸�ΪSOC0415BL
  */
public interface SOC0415BL extends BaseBL {

	/**
	 * ��ռ�����ʵʱ��ʵ��ȡ��
	 *
	 * @return ��ռ�����ʵʱ��ʵ��
	 */
	public SOC0415TB getSOC0415Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0415Info> searchSOC0415();

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0415SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0415Info> searchSOC0415(
			SOC0415SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0415Info> searchSOC0415(
			SOC0415SearchCond cond, int start,
			int count);


}