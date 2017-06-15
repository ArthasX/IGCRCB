/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0410Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0410SearchCond;

/**
  * ����: �洢lunʵʱ��ҵ���߼��ӿ�
  * ��������: �洢lunʵʱ��ҵ���߼��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVStorageRealTimeBL������ΪSOC0410BL
  */
public interface SOC0410BL extends BaseBL {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0410Info> searchSOC0410();


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0410SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0410Info> searchSOC0410(
			SOC0410SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0410Info> searchSOC0410(
			SOC0410SearchCond cond, int start,
			int count);

}