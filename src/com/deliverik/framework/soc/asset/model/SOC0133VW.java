/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
  * ����: ������Zone����
  * ��������: ���չ�ϵ��ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@Entity
public class SOC0133VW implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;
	
	@Id
	/**ZoneID*/
    protected Integer eiid;
    
	/** Zone���� */
	protected String zonename;

	/** Zone��Ա */
	protected String zonemember;
	
	/** cfg */
	protected String effectivecfg;
	
	@Transient
	protected String eiids;

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getZonename() {
		return zonename;
	}

	public void setZonename(String zonename) {
		this.zonename = zonename;
	}

	public String getZonemember() {
		return zonemember;
	}

	public void setZonemember(String zonemember) {
		this.zonemember = zonemember;
	}

	public String getEffectivecfg() {
		return effectivecfg;
	}

	public void setEffectivecfg(String effectivecfg) {
		this.effectivecfg = effectivecfg;
	}

	public String getEiids() {
		return eiids;
	}

	public void setEiids(String eiids) {
		this.eiids = eiids;
	}
	
}