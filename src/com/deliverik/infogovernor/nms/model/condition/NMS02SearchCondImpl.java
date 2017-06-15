/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: SNMP������Ϣʵ���ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS02SearchCondImpl implements NMS02SearchCond{
	
	/** SNMP�汾 */
	protected Integer snmpVersion;
	
	/** �˿� */
	protected Integer snmpPort;
	
	/** ��ȡ������ */
	protected String readCommit;
	
	/** V3��ȫ�û� */
	protected String snmpUser;
	
	/** V3�����֤���� */
	protected String snmpPassword;
	
	/** ɾ����ʶ */
	protected String deleteflag;

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
	
}
