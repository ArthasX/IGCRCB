/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rpt.model.SOC0401Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0401SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0401TB;

/**
  * ����: ���ݿ�����ʵʱ��ҵ���߼��ӿ�
  * ��������: ���ݿ�����ʵʱ��ҵ���߼��ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��DBCapacityRealTimeBL������ΪSOC0401BL
  */
public interface SOC0401BL extends BaseBL {

	/**
	 * ���ݿ�����ʵʱ��ʵ��ȡ��
	 *
	 * @return ���ݿ�����ʵʱ��ʵ��
	 */
	public SOC0401TB getSOC0401Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0401Info> searchSOC0401();


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0401SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0401Info> searchSOC0401(
			SOC0401SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0401Info> searchSOC0401(
			SOC0401SearchCond cond, int start,
			int count);


}