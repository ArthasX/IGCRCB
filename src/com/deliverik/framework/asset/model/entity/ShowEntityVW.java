/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
  * ����: ���չ�ϵ��ʵ��
  * ��������: ���չ�ϵ��ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@Entity
public class ShowEntityVW implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	@Id
	protected Integer eiid;

	/** DomainID */
	protected Integer version;

	/** Domain�汾 */
	protected Integer smallversion;

	/** Դ�ʲ�ID */
	protected String civalue;

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getSmallversion() {
		return smallversion;
	}

	public void setSmallversion(Integer smallversion) {
		this.smallversion = smallversion;
	}

	public String getCivalue() {
		return civalue;
	}

	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}		
	
}