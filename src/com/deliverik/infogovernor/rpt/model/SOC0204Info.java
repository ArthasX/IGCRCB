/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����Զ����ӽӿ�
  * ��������: �����Զ����ӽӿ�
  * ������¼: 2012/07/20
  * �޸ļ�¼: 2012/08/09 ��ReportCustomLinkInfo������ΪSOC0204Info
  */
public interface SOC0204Info extends BaseModel {

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getRclId();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRclReportType();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRclObjName();

	/**
	 * ģ������ȡ��
	 *
	 * @return ģ������
	 */
	public String getRclTemName();

	/**
	 * ģ������ȡ��
	 *
	 * @return ģ������
	 */
	public String getRclTemDesc();

	/**
	 * ����Eiidȡ��
	 *
	 * @return ����Eiid
	 */
	public Integer getRclObjEiid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRclObjType();

	/**
	 * ����Modeȡ��
	 *
	 * @return ����Mode
	 */
	public String getRclMode();

	/**
	 * ��������С����ȡ��
	 *
	 * @return ��������С����
	 */
	public String getRclCaType();

	/**
	 * �˵�Ĭ��ȡ��
	 *
	 * @return �˵�Ĭ��
	 */
	public String getRclMenuDefault();

	/**
	 * �û��ʺ�ȡ��
	 *
	 * @return �û��ʺ�
	 */
	public String getRclUserId();
	/**
	 * ģ�����ȡ��
	 *
	 * @return rclRfdTitle ģ�����
	 */
	public String getRclRfdTitle();

}