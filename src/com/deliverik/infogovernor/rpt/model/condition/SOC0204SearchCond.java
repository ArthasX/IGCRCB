/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: �����Զ����Ӽ��������ӿ�
  * ��������: �����Զ����Ӽ��������ӿ�
  * ������¼: 2012/07/20
  * �޸ļ�¼: 2012/08/10 ��ReportCustomLinkSearchCond�����޸�ΪSOC0204SearchCond
  */
public interface SOC0204SearchCond {
	/**
	 * ��������ȡ��
	 *
	 * @return rclReportType_eq ��������
	 */
	public String getRclReportType_eq();

	/**
	 * ��������ȡ��
	 *
	 * @return rclObjName_eq ��������
	 */
	public String getRclObjName_eq();

	/**
	 * ģ������ȡ��
	 *
	 * @return rclTemName_eq ģ������
	 */
	public String getRclTemName_eq();

	/**
	 * ģ������ȡ��
	 *
	 * @return rclTemDesc_eq ģ������
	 */
	public String getRclTemDesc_eq();

	/**
	 * ģ�����ȡ��
	 *
	 * @return rclRfdTitle_eq ģ�����
	 */
	public String getRclRfdTitle_eq();

	/**
	 * ����Eiidȡ��
	 *
	 * @return rclObjEiid_eq ����Eiid
	 */
	public Integer getRclObjEiid_eq();

	/**
	 * ��������ȡ��
	 *
	 * @return rclObjType_eq ��������
	 */
	public String getRclObjType_eq();

	/**
	 * ����Modeȡ��
	 *
	 * @return rclMode_eq ����Mode
	 */
	public String getRclMode_eq();

	/**
	 * ��������С����ȡ��
	 *
	 * @return rclCaType_eq ��������С����
	 */
	public String getRclCaType_eq();

	/**
	 * �˵�Ĭ��ȡ��
	 *
	 * @return rclMenuDefault_eq �˵�Ĭ��
	 */
	public String getRclMenuDefault_eq();

	/**
	 * �û��ʺ�ȡ��
	 *
	 * @return rclUserId_eq �û��ʺ�
	 */
	public String getRclUserId_eq();
}