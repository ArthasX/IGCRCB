/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.dbs.dto;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;

public class IGDBS01DTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ��ά����
	 */
	protected String operationManagement;
	
	/**
	 * ��ô洢��ͼall
	 */	
	protected String pieall;
	/**
	 * ��ô洢list
	 */
	protected String warninglist;
	/**
	 * ҵ������
	 */
	protected String businessRus;
		
	/**
	 * ����KPI
	 */
	protected String processKPI;
	
	/**
	 * ��ά��������
	 */
	protected String valueOfDate;
	/**
	 * �û���Ϣ
	 */
	
	/**
	 * �������к�
	 */
	protected String symmid;
	
	/**
	 * ����ѡ���0Ϊ�ϣ�1Ϊ��
	 */
	protected String hostchoose;
	
	/**
	 * IOPS��������xml
	 */
	protected String iopsThroughput;
	
	/**
	 * ����: ������/д����/����������
	 */
	protected String readperWriteperHitper;
	
	/**
	 * ������ϸ��Ϣ
	 */
	protected String hostInfo;
	
	/**
	 * ���Ա�־
	 */
	protected String language;
	
	/** �洢���� */
	protected String symm_type;
	
	
	/**
	 * �洢����ȡ��
	 *
	 * @return symm_type �洢����
	 */
	
	public String getSymm_type() {
		return symm_type;
	}

	/**
	 * �洢�����趨
	 *
	 * @param symm_type �洢����
	 */
	
	public void setSymm_type(String symm_type) {
		this.symm_type = symm_type;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	protected User user;
	public String getOperationManagement() {
		return operationManagement;
	}

	public void setOperationManagement(String operationManagement) {
		this.operationManagement = operationManagement;
	}

	public String getValueOfDate() {
		return valueOfDate;
	}

	public void setValueOfDate(String valueOfDate) {
		this.valueOfDate = valueOfDate;
	}

	public String getBusinessRus() {
		return businessRus;
	}

	public void setBusinessRus(String businessRus) {
		this.businessRus = businessRus;
	}
	
	public String getProcessKPI() {
		return processKPI;
	}
	
	public void setProcessKPI(String processKPI) {
		this.processKPI = processKPI;
	}

	/**
	 * �����û���Ϣ
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �����û���Ϣ
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public String getSymmid() {
		return symmid;
	}

	public void setSymmid(String symmid) {
		this.symmid = symmid;
	}

	public String getHostchoose() {
		return hostchoose;
	}

	public void setHostchoose(String hostchoose) {
		this.hostchoose = hostchoose;
	}

	public String getIopsThroughput() {
		return iopsThroughput;
	}

	public void setIopsThroughput(String iopsThroughput) {
		this.iopsThroughput = iopsThroughput;
	}

	public String getReadperWriteperHitper() {
		return readperWriteperHitper;
	}

	public void setReadperWriteperHitper(String readperWriteperHitper) {
		this.readperWriteperHitper = readperWriteperHitper;
	}

	public String getHostInfo() {
		return hostInfo;
	}

	public void setHostInfo(String hostInfo) {
		this.hostInfo = hostInfo;
	}

	/**
	 * ��ô洢��ͼallȡ��
	 *
	 * @return pieall ��ô洢��ͼall
	 */
	public String getPieall() {
		return pieall;
	}

	/**
	 * ��ô洢listȡ��
	 *
	 * @return warninglist ��ô洢list
	 */
	public String getWarninglist() {
		return warninglist;
	}

	/**
	 * ��ô洢��ͼall�趨
	 *
	 * @param pieall ��ô洢��ͼall
	 */
	public void setPieall(String pieall) {
		this.pieall = pieall;
	}

	/**
	 * ��ô洢list�趨
	 *
	 * @param warninglist ��ô洢list
	 */
	public void setWarninglist(String warninglist) {
		this.warninglist = warninglist;
	}

	
	
	
}