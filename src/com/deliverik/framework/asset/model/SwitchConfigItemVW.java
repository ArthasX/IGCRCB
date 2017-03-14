/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
  * ����: ����������
  * ��������: ���չ�ϵ��ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@Entity
public class SwitchConfigItemVW implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;
	
	@Id
	/**������ID*/
    protected Integer switchid;
    
	/** ���������� */
	protected String switchname;

	/** IP��ַ */
	protected String switchip;

	/** �������� */
	protected String switchdomain;
	
	/** �������� */
	protected String effectivecfg;

	public String getSwitchname() {
		return switchname;
	}

	public void setSwitchname(String switchname) {
		this.switchname = switchname;
	}

	public String getSwitchip() {
		return switchip;
	}

	public void setSwitchip(String switchip) {
		this.switchip = switchip;
	}

	public String getSwitchdomain() {
		return switchdomain;
	}

	public void setSwitchdomain(String switchdomain) {
		this.switchdomain = switchdomain;
	}

	public String getEffectivecfg() {
		return effectivecfg;
	}

	public void setEffectivecfg(String effectivecfg) {
		this.effectivecfg = effectivecfg;
	}

	public Integer getSwitchid() {
		return switchid;
	}

	public void setSwitchid(Integer switchid) {
		this.switchid = switchid;
	}
}