/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * ����: CRM06��������ʵ��
  * ��������: CRM06��������ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public class CRM06SearchCondImpl implements CRM06SearchCond {
	
	protected String serverName_like;
	
	protected String ip_like;
	
	protected String fileid_eq;
	
	private String serverName;
	
	public String getFileid_eq() {
		return fileid_eq;
	}

	public void setFileid_eq(String fileid_eq) {
		this.fileid_eq = fileid_eq;
	}

	public String getServerName_like() {
		return serverName_like;
	}

	public void setServerName_like(String serverName_like) {
		this.serverName_like = serverName_like;
	}

	public String getIp_like() {
		return ip_like;
	}

	public void setIp_like(String ip_like) {
		this.ip_like = ip_like;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerName() {
		return serverName;
	}
	
}