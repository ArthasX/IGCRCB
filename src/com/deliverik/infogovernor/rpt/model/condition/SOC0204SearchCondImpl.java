/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: �����Զ����Ӽ�������ʵ��
  * ��������: �����Զ����Ӽ�������ʵ��
  * ������¼: 2012/07/20
  * �޸ļ�¼: 2012/08/10 ��ReportCustomLinkSearchCondImpl�����޸�ΪSOC0204SearchCondImpl
  */
public class SOC0204SearchCondImpl implements
		SOC0204SearchCond {
	/** �������� */
	protected String rclReportType_eq;

	/** �������� */
	protected String rclObjName_eq;

	/** ģ������ */
	protected String rclTemName_eq;

	/** ģ������ */
	protected String rclTemDesc_eq;
	/** ģ�����*/
	protected String rclRfdTitle_eq;
	/** ����Eiid */
	protected Integer rclObjEiid_eq;

	/** �������� */
	protected String rclObjType_eq;

	/** ����Mode */
	protected String rclMode_eq;

	/** ��������С���� */
	protected String rclCaType_eq;

	/** �˵�Ĭ�� */
	protected String rclMenuDefault_eq;

	/** �û��ʺ� */
	protected String rclUserId_eq;

	/**
	 * ��������ȡ��
	 *
	 * @return rclReportType_eq ��������
	 */
	public String getRclReportType_eq() {
		return rclReportType_eq;
	}

	/**
	 * ���������趨
	 *
	 * @param rclReportType_eq ��������
	 */
	public void setRclReportType_eq(String rclReportType_eq) {
		this.rclReportType_eq = rclReportType_eq;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return rclObjName_eq ��������
	 */
	public String getRclObjName_eq() {
		return rclObjName_eq;
	}

	/**
	 * ���������趨
	 *
	 * @param rclObjName_eq ��������
	 */
	public void setRclObjName_eq(String rclObjName_eq) {
		this.rclObjName_eq = rclObjName_eq;
	}

	/**
	 * ģ������ȡ��
	 *
	 * @return rclTemName_eq ģ������
	 */
	public String getRclTemName_eq() {
		return rclTemName_eq;
	}

	/**
	 * ģ�������趨
	 *
	 * @param rclTemName_eq ģ������
	 */
	public void setRclTemName_eq(String rclTemName_eq) {
		this.rclTemName_eq = rclTemName_eq;
	}

	/**
	 * ģ������ȡ��
	 *
	 * @return rclTemDesc_eq ģ������
	 */
	public String getRclTemDesc_eq() {
		return rclTemDesc_eq;
	}

	/**
	 * ģ�������趨
	 *
	 * @param rclTemDesc_eq ģ������
	 */
	public void setRclTemDesc_eq(String rclTemDesc_eq) {
		this.rclTemDesc_eq = rclTemDesc_eq;
	}

	/**
	 * ģ�����ȡ��
	 *
	 * @return rclRfdTitle_eq ģ�����
	 */
	public String getRclRfdTitle_eq() {
		return rclRfdTitle_eq;
	}

	/**
	 * ģ������趨
	 *
	 * @param rclRfdTitle_eq ģ�����
	 */
	public void setRclRfdTitle_eq(String rclRfdTitle_eq) {
		this.rclRfdTitle_eq = rclRfdTitle_eq;
	}

	/**
	 * ����Eiidȡ��
	 *
	 * @return rclObjEiid_eq ����Eiid
	 */
	public Integer getRclObjEiid_eq() {
		return rclObjEiid_eq;
	}

	/**
	 * ����Eiid�趨
	 *
	 * @param rclObjEiid_eq ����Eiid
	 */
	public void setRclObjEiid_eq(Integer rclObjEiid_eq) {
		this.rclObjEiid_eq = rclObjEiid_eq;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return rclObjType_eq ��������
	 */
	public String getRclObjType_eq() {
		return rclObjType_eq;
	}

	/**
	 * ���������趨
	 *
	 * @param rclObjType_eq ��������
	 */
	public void setRclObjType_eq(String rclObjType_eq) {
		this.rclObjType_eq = rclObjType_eq;
	}

	/**
	 * ����Modeȡ��
	 *
	 * @return rclMode_eq ����Mode
	 */
	public String getRclMode_eq() {
		return rclMode_eq;
	}

	/**
	 * ����Mode�趨
	 *
	 * @param rclMode_eq ����Mode
	 */
	public void setRclMode_eq(String rclMode_eq) {
		this.rclMode_eq = rclMode_eq;
	}

	/**
	 * ��������С����ȡ��
	 *
	 * @return rclCaType_eq ��������С����
	 */
	public String getRclCaType_eq() {
		return rclCaType_eq;
	}

	/**
	 * ��������С�����趨
	 *
	 * @param rclCaType_eq ��������С����
	 */
	public void setRclCaType_eq(String rclCaType_eq) {
		this.rclCaType_eq = rclCaType_eq;
	}

	/**
	 * �˵�Ĭ��ȡ��
	 *
	 * @return rclMenuDefault_eq �˵�Ĭ��
	 */
	public String getRclMenuDefault_eq() {
		return rclMenuDefault_eq;
	}

	/**
	 * �˵�Ĭ���趨
	 *
	 * @param rclMenuDefault_eq �˵�Ĭ��
	 */
	public void setRclMenuDefault_eq(String rclMenuDefault_eq) {
		this.rclMenuDefault_eq = rclMenuDefault_eq;
	}

	/**
	 * �û��ʺ�ȡ��
	 *
	 * @return rclUserId_eq �û��ʺ�
	 */
	public String getRclUserId_eq() {
		return rclUserId_eq;
	}

	/**
	 * �û��ʺ��趨
	 *
	 * @param rclUserId_eq �û��ʺ�
	 */
	public void setRclUserId_eq(String rclUserId_eq) {
		this.rclUserId_eq = rclUserId_eq;
	}
	
	
}