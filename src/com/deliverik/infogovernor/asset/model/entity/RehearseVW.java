/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.infogovernor.asset.model.RehearseVWInfo;


/**
 * ������Ӧ����Ա��λ��ʵ��
 * ����������Ӧ����Ա��λ��ʵ��
 * ������¼��2014/05/19
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class RehearseVW implements Serializable, Cloneable, RehearseVWInfo {
	/**��ID*/
	@Id
	protected Integer rowid;

	/**Ӧ����������ID*/
	protected Integer counts;
	/**Ӧ����������ID*/
	protected String esyscoding;

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	public Integer getRowid() {
		return rowid;
	}

	public void setRowid(Integer rowid) {
		this.rowid = rowid;
	}
	
}