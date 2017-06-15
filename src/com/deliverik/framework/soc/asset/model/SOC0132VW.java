/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
  * ����: �������˿�����
  * ��������: ���չ�ϵ��ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@Entity
public class SOC0132VW implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;
	
	@Id
	/**portID*/
    protected Integer eiid;
    
	/** �˿ں� */
	protected String port;

	/** WWN */
	protected String wwn;
	@Transient
	protected String eiids;

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getWwn() {
		return wwn;
	}

	public void setWwn(String wwn) {
		this.wwn = wwn;
	}

	public String getEiids() {
		return eiids;
	}

	public void setEiids(String eiids) {
		this.eiids = eiids;
	}

	
}