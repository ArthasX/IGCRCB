/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: ����ԭ������������ϵ��ʵ������
  * ��������: ����ԭ������������ϵ��ʵ������
  * ������¼: 2013/04/08
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class CR03PK extends BasePK implements Serializable {

	/** �ɼ�ʱ�� */
	protected Integer type;

	/** �������� */
	protected String ip;
	
	/** ������ʶ */
	protected String host;
	
	/**  */
	protected String collecttime;

	/**
	 * ���캯��
	 */
	public CR03PK() {

	}

	




	public CR03PK(Integer type, String ip, String host, String collecttime) {
		super();
		this.type = type;
		this.ip = ip;
		this.host = host;
		this.collecttime = collecttime;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCollecttime() {
		return collecttime;
	}

	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}
	
}