/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset;

import java.io.Serializable;


import com.deliverik.framework.base.BasePK;
/**
 * ����: �ʲ�����ϸ��ʵ������
 * ��������: �ʲ�����ϸ��ʵ������
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class SOC0136PK extends BasePK implements Serializable {
	
	protected Integer domainid;
	
	
	protected Integer domainversion;
	
	protected Integer eiversion;
	
	protected Integer eiid;
	
	/**
	 * ���캯��
	 */
	public SOC0136PK(){}
	
	/**
	 * ���캯��
	 */
	public SOC0136PK(Integer domainid, Integer domainversion,
			Integer eiversion, Integer eiid) {
		super();
		this.domainid = domainid;
		this.domainversion = domainversion;
		this.eiversion = eiversion;
		this.eiid = eiid;
	}

	public Integer getDomainid() {
		return domainid;
	}


	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}

	public Integer getDomainversion() {
		return domainversion;
	}

	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}

	public Integer getEiversion() {
		return eiversion;
	}

	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	
	
}
