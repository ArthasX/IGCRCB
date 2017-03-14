/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ɼ����������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CR01PK extends BasePK implements Serializable{

	/** �豸��ʶ */
	protected String host;
	
	/** �ɼ�ʱ�� */
	protected String collecttime;
	
	/** �ɼ����� */
	protected String command;
	
	/** �ɼ����˳�� */
	protected Integer cdataorder;
	
	/** ƽ̨IP */
	protected String ip;
	
	/** server�� */
	protected String servername;
	
	/** server���� */
	protected String servertype;
	
	/**
	 * ���췽��
	 */
	public CR01PK(){
		
	}

	public CR01PK(String host, String collecttime, String command,
			Integer cdataorder, String ip, String servername, String servertype) {
		super();
		this.host = host;
		this.collecttime = collecttime;
		this.command = command;
		this.cdataorder = cdataorder;
		this.ip = ip;
		this.servername = servername;
		this.servertype = servertype;
	}



	/**
	 * ������ʶȡ��
	 * @return ������ʶ
	 */
	public String getHost() {
		return host;
	}

	/**
	 * ����i��ʶ�趨
	 * @param host ������ʶ
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * �ɼ�ʱ��ȡ��
	 * @return �ɼ�ʱ��
	 */
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * �ɼ�ʱ���趨
	 * @param collecttime �ɼ�ʱ��
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * �ɼ�����ȡ��
	 * @return �ɼ�����
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * �ɼ������趨
	 * @param command �ɼ�����
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * �ɼ����˳��ȡ��
	 * @return �ɼ����˳��
	 */
	public Integer getCdataorder() {
		return cdataorder;
	}

	/**
	 * �ɼ����˳���趨
	 * @param cdataorder �ɼ����˳��
	 */
	public void setCdataorder(Integer cdataorder) {
		this.cdataorder = cdataorder;
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
