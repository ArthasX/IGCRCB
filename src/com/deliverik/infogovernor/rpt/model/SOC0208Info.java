/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �¼��������Ч�ʽӿ�
  * ��������: �¼��������Ч�ʽӿ�
  * ������¼: 2011/11/23
  * �޸ļ�¼: 2012/08/09 ��ServeEfficiencyInfo������ΪSOC0208Info
  */
public interface SOC0208Info extends BaseModel {

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtype();

	/**
	 * ������Դȡ��
	 *
	 * @return ������Դ
	 */
	public String getPivaralue();

	/**
	 * ʱ��ȡ��
	 *
	 * @return ʱ��
	 */
	public String getEfficiencyTime();

	/**
	 * ��ǰ�·���Ч��ȡ��
	 *
	 * @return ��ǰ�·���Ч��
	 */
	public String getMonthEfficiency();

	/**
	 * ��ʷ����Ч��ȡ��
	 *
	 * @return ��ʷ����Ч��
	 */
	public String getHistoryEfficiency();

}