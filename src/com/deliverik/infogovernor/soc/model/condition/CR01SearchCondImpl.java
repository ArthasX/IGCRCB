/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.model.condition;

import javax.persistence.Id;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�ɼ������ѯ����ʵ�� 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 * ����˵�� ���Ӳ�ѯ�����ɼ�����
 */
public class CR01SearchCondImpl implements CR01SearchCond{

	/** �������� */
	protected String tablename;
	
	/** �豸��ʶ */
	protected String host;
	
	/** �ɼ�ʱ�� */
	protected String collecttime;
	
	/** �ɼ�����*/
	protected String command;
	
	/** ƽ̨IP */
	protected String ip;
	
	/** server�� */
	protected String servername;
	
	/** server���� */
	protected String servertype;

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * ���������趨
	 * @param tablename ��������
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * �豸��ʶȡ��
	 * @return �豸��ʶ
	 */
	public String getHost() {
		return host;
	}

	/**
	 * �豸��ʶ�趨
	 * @param host �豸��ʶ
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * �ɼ�ʱ��ȡ��
	 *
	 * @return �ɼ�ʱ��
	 */
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * �ɼ�ʱ���趨
	 *
	 * @param collecttime �ɼ�ʱ��
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * �ɼ�����ȡ��
	 *
	 * @return command �ɼ�����
	 */
	
	public String getCommand() {
		return command;
	}

	/**
	 * �ɼ������趨
	 *
	 * @param command �ɼ�����
	 */
	
	public void setCommand(String command) {
		this.command = command;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public String getServertype() {
		return servertype;
	}

	public void setServertype(String servertype) {
		this.servertype = servertype;
	}
	
}
