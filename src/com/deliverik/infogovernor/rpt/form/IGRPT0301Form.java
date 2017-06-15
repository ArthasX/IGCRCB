/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.rpt.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;

/**
 * ����: ����ͳ��ҳ���ʼ��Form
 * ��������: 
 * ������¼:����ȫ 2012/07/20
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGRPT0301Form extends BaseForm{
	protected Integer rclId;

	/** �������� */
	protected String rclReportType;

	/** �������� */
	protected String rclObjName;

	/** ģ������ */
	protected String rclTemName;

	/** ģ������ */
	protected String rclTemDesc;
	/** ģ�����*/
	protected String rclRfdTitle;
	/** ����Eiid */
	protected Integer rclObjEiid;

	/** �������� */
	protected String rclObjType;

	/** ����Mode */
	protected String rclMode;

	/** ��������С���� */
	protected String rclCaType;

	/** �˵�Ĭ�� */
	protected String rclMenuDefault;

	/** �û��ʺ� */
	protected String rclUserId;

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getRclId() {
		return rclId;
	}

	/**
	 * ����ID�趨
	 *
	 * @param rclId ����ID
	 */
	public void setRclId(Integer rclId) {
		this.rclId = rclId;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRclReportType() {
		return rclReportType;
	}

	/**
	 * ���������趨
	 *
	 * @param rclReportType ��������
	 */
	public void setRclReportType(String rclReportType) {
		this.rclReportType = rclReportType;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRclObjName() {
		return rclObjName;
	}

	/**
	 * ���������趨
	 *
	 * @param rclObjName ��������
	 */
	public void setRclObjName(String rclObjName) {
		this.rclObjName = rclObjName;
	}

	/**
	 * ģ������ȡ��
	 *
	 * @return ģ������
	 */
	public String getRclTemName() {
		return rclTemName;
	}

	/**
	 * ģ�������趨
	 *
	 * @param rclTemName ģ������
	 */
	public void setRclTemName(String rclTemName) {
		this.rclTemName = rclTemName;
	}

	/**
	 * ģ������ȡ��
	 *
	 * @return ģ������
	 */
	public String getRclTemDesc() {
		return rclTemDesc;
	}

	/**
	 * ģ�������趨
	 *
	 * @param rclTemDesc ģ������
	 */
	public void setRclTemDesc(String rclTemDesc) {
		this.rclTemDesc = rclTemDesc;
	}

	/**
	 * ����Eiidȡ��
	 *
	 * @return ����Eiid
	 */
	public Integer getRclObjEiid() {
		return rclObjEiid;
	}

	/**
	 * ����Eiid�趨
	 *
	 * @param rclObjEiid ����Eiid
	 */
	public void setRclObjEiid(Integer rclObjEiid) {
		this.rclObjEiid = rclObjEiid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRclObjType() {
		return rclObjType;
	}

	/**
	 * ���������趨
	 *
	 * @param rclObjType ��������
	 */
	public void setRclObjType(String rclObjType) {
		this.rclObjType = rclObjType;
	}

	/**
	 * ����Modeȡ��
	 *
	 * @return ����Mode
	 */
	public String getRclMode() {
		return rclMode;
	}

	/**
	 * ����Mode�趨
	 *
	 * @param rclMode ����Mode
	 */
	public void setRclMode(String rclMode) {
		this.rclMode = rclMode;
	}

	/**
	 * ��������С����ȡ��
	 *
	 * @return ��������С����
	 */
	public String getRclCaType() {
		return rclCaType;
	}

	/**
	 * ��������С�����趨
	 *
	 * @param rclCaType ��������С����
	 */
	public void setRclCaType(String rclCaType) {
		this.rclCaType = rclCaType;
	}

	/**
	 * �˵�Ĭ��ȡ��
	 *
	 * @return �˵�Ĭ��
	 */
	public String getRclMenuDefault() {
		return rclMenuDefault;
	}

	/**
	 * �˵�Ĭ���趨
	 *
	 * @param rclMenuDefault �˵�Ĭ��
	 */
	public void setRclMenuDefault(String rclMenuDefault) {
		this.rclMenuDefault = rclMenuDefault;
	}

	/**
	 * �û��ʺ�ȡ��
	 *
	 * @return �û��ʺ�
	 */
	public String getRclUserId() {
		return rclUserId;
	}

	/**
	 * �û��ʺ��趨
	 *
	 * @param rclUserId �û��ʺ�
	 */
	public void setRclUserId(String rclUserId) {
		this.rclUserId = rclUserId;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rclId;
	}

	/**
	 * ģ�����ȡ��
	 *
	 * @return rclRfdTitle ģ�����
	 */
	public String getRclRfdTitle() {
		return rclRfdTitle;
	}

	/**
	 * ģ������趨
	 *
	 * @param rclRfdTitle ģ�����
	 */
	public void setRclRfdTitle(String rclRfdTitle) {
		this.rclRfdTitle = rclRfdTitle;
	}
	
	
}
