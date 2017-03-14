package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ɼ����������
 * </p>
 * 
 * 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CRM01PK extends BasePK implements Serializable {

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
	protected Integer servertype;

	protected String cdata;

	protected String objectname;

	/**
	 * ���췽��
	 */
	public CRM01PK() {

	}

	public Integer getServertype() {
		return servertype;
	}

	public void setServertype(Integer servertype) {
		this.servertype = servertype;
	}

	public CRM01PK(String host, String collecttime, String command,
			Integer cdataorder, String ip, String servername,
			Integer servertype, String cdata, String objectname) {
		super();
		this.host = host;
		this.collecttime = collecttime;
		this.command = command;
		this.cdataorder = cdataorder;
		this.ip = ip;
		this.servername = servername;
		this.servertype = servertype;
		this.cdata = cdata;
		this.objectname = objectname;
	}

	public String getObjectname() {
		return objectname;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

	/**
	 * ������ʶȡ��
	 * 
	 * @return ������ʶ
	 */
	public String getHost() {
		return host;
	}

	/**
	 * ����i��ʶ�趨
	 * 
	 * @param host
	 *            ������ʶ
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
	 * @param collecttime
	 *            �ɼ�ʱ��
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * �ɼ�����ȡ��
	 * 
	 * @return �ɼ�����
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * �ɼ������趨
	 * 
	 * @param command
	 *            �ɼ�����
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * �ɼ����˳��ȡ��
	 * 
	 * @return �ɼ����˳��
	 */
	public Integer getCdataorder() {
		return cdataorder;
	}

	/**
	 * �ɼ����˳���趨
	 * 
	 * @param cdataorder
	 *            �ɼ����˳��
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

	public String getCdata() {
		return cdata;
	}

	public void setCdata(String cdata) {
		this.cdata = cdata;
	}

}
