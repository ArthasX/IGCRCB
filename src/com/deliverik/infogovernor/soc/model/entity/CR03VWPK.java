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
public class CR03VWPK extends BasePK implements Serializable {

	/** �ɼ�ʱ�� */
	protected Integer type;

	/** �������� */
	protected String ip;
	
	/** ������ʶ */
	protected String host;
	
	/** ����ɼ�ʱ�� */
	protected String minctime;
	
	/** �ű��� */
	protected String servername;
	
	

	/**
	 * ���캯��
	 */
	public CR03VWPK() {

	}

	public CR03VWPK(Integer type, String ip, String host, String minctime,
			String servername) {
		super();
		this.type = type;
		this.ip = ip;
		this.host = host;
		this.minctime = minctime;
		this.servername = servername;
	}



	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public String getMinctime() {
		return minctime;
	}


	public void setMinctime(String minctime) {
		this.minctime = minctime;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}
}