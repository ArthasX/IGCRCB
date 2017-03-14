/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.mnt.form;

/**
 * ����: ������־��ѯ����FORM
 * ��������: ������־��ѯ����FORM
 * ������¼: 2011/06/09
 * �޸ļ�¼: 
 */
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCond;

public class IGMNT0206Form extends BaseForm implements SOC0305SearchCond {
	
	private static final long serialVersionUID = 1L;
	
	/** ��ѡ��澯id���� */
	private String[] ids;
	
	/** id */
	private String id;
	
	/** ��ѯ���� */
	public String impcitype;
	
	/** ������־�Ķ���ʵ���� */
	public String eirootmark_eq;

	/** ������־��DIR */
	public String dir_eq;

	/** ������־�Ĵ���� */
	public String errornum_eq;
	
	/** ��־����ʱ�� */
	protected String detectiontime_eq;

	/** ��ʼ�Ĵ洢��־����ʱ�� */
	protected String detectiontime_from;

	/** �����Ĵ洢��־����ʱ�� */
	protected String detectiontime_to;

	/** �澯���� */
	public String severity_eq;

	/** �澯���� */
	private String alarmType;
	
	/** �������� */
	private String errorDesc;
	
	/** ����״̬ */
	private String status;
	
	private String flag;
	
	
	
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * ��־����ʱ��ȡ��
	 * @return
	 */
	public String getDetectiontime_eq() {
		return detectiontime_eq;
	}

	/**
	 * ��־����ʱ���趨
	 * @param detectiontime_eq
	 */
	public void setDetectiontime_eq(String detectiontime_eq) {
		this.detectiontime_eq = detectiontime_eq;
	}
	
	/**
	 * ��������ȡ��
	 * @return
	 */
	public String getErrorDesc() {
		return errorDesc;
	}

	/**
	 * ���������趨
	 * @param errorDesc
	 */
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	/**
	 * �澯����ȡ��
	 * @return
	 */
	public String getAlarmType() {
		return alarmType;
	}

	/**
	 * �澯�����趨
	 * @param alarmType
	 */
	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	/**
	 * �澯����ȡ��
	 * 
	 * @return severity_eq
	 */
	public String getSeverity_eq() {
		return severity_eq;
	}

	/**
	 * �澯��������
	 * 
	 * @param severity_eq
	 */
	public void setSeverity_eq(String severity_eq) {
		this.severity_eq = severity_eq;
	}

	/**
	 * ������־�Ķ���ʵ����ȡ��
	 * 
	 * @return eirootmark_eq
	 */
	public String getEirootmark_eq() {
		return eirootmark_eq;
	}

	/**
	 * ������־�Ķ���ʵ��������
	 * 
	 * @param eirootmark_eq
	 */
	public void setEirootmark_eq(String eirootmark_eq) {
		this.eirootmark_eq = eirootmark_eq;
	}

	/**
	 * ������־��DIRȡ��
	 * 
	 * @return dir_eq
	 */
	public String getDir_eq() {
		return dir_eq;
	}

	/**
	 * ������־��DIR����
	 * 
	 * @param dir_eq
	 */
	public void setDir_eq(String dir_eq) {
		this.dir_eq = dir_eq;
	}

	/**
	 * ������־�Ĵ����ȡ��
	 * 
	 * @return errornum_eq
	 */
	public String getErrornum_eq() {
		return errornum_eq;
	}

	/**
	 * ������־�Ĵ��������
	 * 
	 * @param errornum_eq
	 */
	public void setErrornum_eq(String errornum_eq) {
		this.errornum_eq = errornum_eq;
	}

	/**
	 * ��ʼ�Ĵ洢��־����ʱ��ȡ��
	 * 
	 * @return detectiontime_to
	 */
	public String getDetectiontime_from() {
		return detectiontime_from;
	}

	/**
	 * ��ʼ�Ĵ洢��־����ʱ������
	 * 
	 * @param detectiontime_from
	 */
	public void setDetectiontime_from(String detectiontime_from) {
		this.detectiontime_from = detectiontime_from;
	}

	/**
	 * �����Ĵ洢��־����ʱ��ȡ��
	 * 
	 * @return detectiontime_to
	 */
	public String getDetectiontime_to() {
		return detectiontime_to;
	}

	/**
	 * �����Ĵ洢��־����ʱ������
	 * 
	 * @param detectiontime_to
	 */
	public void setDetectiontime_to(String detectiontime_to) {
		this.detectiontime_to = detectiontime_to;
	}

	/**
	 * ��������ȡ��
	 */
	public String getImpcitype() {
		return impcitype;
	}

	/**
	 * ���������趨
	 * @param impcitype
	 */
	public void setImpcitype(String impcitype) {
		this.impcitype = impcitype;
	}

	/**
	 * idȡ��
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * id�趨
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

}
