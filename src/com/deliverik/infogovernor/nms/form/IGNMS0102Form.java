/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.nms.model.NMS02Info;

/**
 * ����: SNMP����Form
 * ��������: SNMP����Form
 * ������¼: 2013/12/20
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGNMS0102Form extends BaseForm implements NMS02Info {
	
	/** ���� */
	protected String id;
	
	/** SNMP�汾 */
	protected Integer snmpVersion;
	
	/** �˿� */
	protected Integer snmpPort;
	
	/** ��ȡ������ */
	protected String readCommit;
	
	/** д�������� */
	protected String writeCommit;
	
	/** �Ƿ�����SNMP���� */
	protected String isEnableSnmpProxy;
	
	/** ����IP */
	protected String snmpProxyIP;
	
	/** V3��ȫ���� */
	protected String snmpSecurityLevel;
	
	/** V3��ȫ�û� */
	protected String snmpUser;
	
	/** V3���������� */
	protected String snmpSecurityContext;
	
	/** V3�����֤Э�� */
	protected String snmpAuthType;
	
	/** V3�����֤���� */
	protected String snmpPassword;
	
	/** V3��˽Э�� */
	protected String snmpPrivacyType;
	
	/** V3��˽���� */
	protected String snmpPrivacyPassPhrase;
	
	/** ����ʱ�� */
	protected String instime;
	
	/** ��¼ʱ��� */
	protected String fingerPrint;
	
	/** ɾ����ʶ */
	protected String deleteflag;

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getId() {
		return id;
	}

	/**
	 * �����趨
	 * @param id ����
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * SNMP�汾ȡ��
	 * @return SNMP�汾
	 */
	public Integer getSnmpVersion() {
		return snmpVersion;
	}

	/**
	 * SNMP�汾�趨
	 * @param snmpVersion SNMP�汾
	 */
	public void setSnmpVersion(Integer snmpVersion) {
		this.snmpVersion = snmpVersion;
	}

	/**
	 * �˿�ȡ��
	 * @return �˿�
	 */
	public Integer getSnmpPort() {
		return snmpPort;
	}

	/**
	 * �˿��趨
	 * @param snmpPort �˿�
	 */
	public void setSnmpPort(Integer snmpPort) {
		this.snmpPort = snmpPort;
	}

	/**
	 * ��ȡ������ȡ��
	 * @return ��ȡ������
	 */
	public String getReadCommit() {
		return readCommit;
	}

	/**
	 * ��ȡ�������趨
	 * @param readCommit ��ȡ������
	 */
	public void setReadCommit(String readCommit) {
		this.readCommit = readCommit;
	}

	/**
	 * д��������ȡ��
	 * @return д��������
	 */
	public String getWriteCommit() {
		return writeCommit;
	}

	/**
	 * д���������趨
	 * @param writeCommit д��������
	 */
	public void setWriteCommit(String writeCommit) {
		this.writeCommit = writeCommit;
	}

	/**
	 * �Ƿ�����SNMP����ȡ��
	 * @return �Ƿ�����SNMP����
	 */
	public String getIsEnableSnmpProxy() {
		return isEnableSnmpProxy;
	}

	/**
	 * �Ƿ�����SNMP�����趨
	 * @param isEnableSnmpProxy �Ƿ�����SNMP����
	 */
	public void setIsEnableSnmpProxy(String isEnableSnmpProxy) {
		this.isEnableSnmpProxy = isEnableSnmpProxy;
	}

	/**
	 * ����IPȡ��
	 * @return ����IP
	 */
	public String getSnmpProxyIP() {
		return snmpProxyIP;
	}

	/**
	 * ����IP�趨
	 * @param snmpProxyIP ����IP
	 */
	public void setSnmpProxyIP(String snmpProxyIP) {
		this.snmpProxyIP = snmpProxyIP;
	}

	/**
	 * V3��ȫ����ȡ��
	 * @return V3��ȫ����
	 */
	public String getSnmpSecurityLevel() {
		return snmpSecurityLevel;
	}

	/**
	 * V3��ȫ�����趨
	 * @param snmpSecurityLevel V3��ȫ����
	 */
	public void setSnmpSecurityLevel(String snmpSecurityLevel) {
		this.snmpSecurityLevel = snmpSecurityLevel;
	}

	/**
	 * V3��ȫ�û�ȡ��
	 * @return V3��ȫ�û�
	 */
	public String getSnmpUser() {
		return snmpUser;
	}

	/**
	 * V3��ȫ�û��趨
	 * @param snmpUser V3��ȫ�û�
	 */
	public void setSnmpUser(String snmpUser) {
		this.snmpUser = snmpUser;
	}

	/**
	 * V3����������ȡ��
	 * @return V3����������
	 */
	public String getSnmpSecurityContext() {
		return snmpSecurityContext;
	}

	/**
	 * V3�����������趨
	 * @param snmpSecurityContext V3����������
	 */
	public void setSnmpSecurityContext(String snmpSecurityContext) {
		this.snmpSecurityContext = snmpSecurityContext;
	}

	/**
	 * V3�����֤Э��ȡ��
	 * @return V3�����֤Э��
	 */
	public String getSnmpAuthType() {
		return snmpAuthType;
	}

	/**
	 * V3�����֤Э���趨
	 * @param snmpAuthType V3�����֤Э��
	 */
	public void setSnmpAuthType(String snmpAuthType) {
		this.snmpAuthType = snmpAuthType;
	}

	/**
	 * V3�����֤����ȡ��
	 * @return V3�����֤����
	 */
	public String getSnmpPassword() {
		return snmpPassword;
	}

	/**
	 * V3�����֤�����趨
	 * @param snmpPassword V3�����֤����
	 */
	public void setSnmpPassword(String snmpPassword) {
		this.snmpPassword = snmpPassword;
	}

	/**
	 * V3��˽Э��ȡ��
	 * @return V3��˽Э��
	 */
	public String getSnmpPrivacyType() {
		return snmpPrivacyType;
	}

	/**
	 * V3��˽Э���趨
	 * @param snmpPrivacyType V3��˽Э��
	 */
	public void setSnmpPrivacyType(String snmpPrivacyType) {
		this.snmpPrivacyType = snmpPrivacyType;
	}

	/**
	 * V3��˽����ȡ��
	 * @return V3��˽����
	 */
	public String getSnmpPrivacyPassPhrase() {
		return snmpPrivacyPassPhrase;
	}

	/**
	 * V3��˽�����趨
	 * @param snmpPrivacyPassPhrase V3��˽����
	 */
	public void setSnmpPrivacyPassPhrase(String snmpPrivacyPassPhrase) {
		this.snmpPrivacyPassPhrase = snmpPrivacyPassPhrase;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getInstime() {
		return instime;
	}

	/**
	 * ����ʱ���趨
	 * @param instime ����ʱ��
	 */
	public void setInstime(String instime) {
		this.instime = instime;
	}

	/**
	 * ��¼ʱ���ȡ��
	 * @return ��¼ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ��¼ʱ����趨
	 * @param fingerPrint ��¼ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	
	/**
	 * ɾ����ʶȡ��
	 * @return ɾ����ʶ
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * ɾ����ʶ�趨
	 * @param deleteflag ɾ����ʶ
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
	
}
