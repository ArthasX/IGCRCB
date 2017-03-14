/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;

/**
  * ����: ��ռ䷥ֵ�趨
  * ��������: ��ռ䷥ֵʵ��
  * ������¼: 
  * �޸ļ�¼: 
  */
@Entity
@Table(name="SOC0437")
public class SOC0437TB extends BaseEntity implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** ��ϵ�� */
	@Id
	protected Integer cvid;
	
	protected Integer eiid;
	
	protected String cvalue;
	
	protected String tsname;
	
	protected String tsize;
	
	protected String freesize;
	
	protected String usesize;
	
	protected String usagerate;

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getCvalue() {
		return cvalue;
	}

	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	public String getTsname() {
		return tsname;
	}

	public void setTsname(String tsname) {
		this.tsname = tsname;
	}

	public String getTsize() {
		return tsize;
	}

	public void setTsize(String tsize) {
		this.tsize = tsize;
	}

	public String getFreesize() {
		return freesize;
	}

	public void setFreesize(String freesize) {
		this.freesize = freesize;
	}

	public String getUsesize() {
		return usesize;
	}

	public void setUsesize(String usesize) {
		this.usesize = usesize;
	}

	public String getUsagerate() {
		return usagerate;
	}

	public void setUsagerate(String usagerate) {
		this.usagerate = usagerate;
	}
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return cvid;
	}
}