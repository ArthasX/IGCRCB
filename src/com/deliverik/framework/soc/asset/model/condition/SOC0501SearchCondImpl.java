/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: ��ռ䷥ֵ�趨��������ʵ��
  * ��������: ��ռ䷥ֵ�趨��������ʵ��
  * ������¼: 
  * �޸ļ�¼: 
  */
public class SOC0501SearchCondImpl implements
SOC0501SearchCond {
	
	private String pwdType;
	private String userName;
	private String serverIP;
	private Integer pid;
	
	
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public void setPwdType(String pwdType) {
		this.pwdType = pwdType;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}
	public String getPwdType() {
		return pwdType;
	}
	public String getUserName() {
		return userName;
	}
	public String getServerIP() {
		return serverIP;
	}
	

	
}