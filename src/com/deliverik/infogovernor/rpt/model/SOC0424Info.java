/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �������ͱ�ӿ�
  * ��������: �������ͱ�ӿ�
  * ������¼: 2012/07/18
  * �޸ļ�¼: 2012/08/09 ��ReportTypeInfo������ΪSOC0424Info
  */
public interface SOC0424Info extends BaseModel {

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getReportName();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRtType();

	/**
	 * �洢����ȡ��
	 *
	 * @return �洢����
	 */
	public String getStorageType();

}