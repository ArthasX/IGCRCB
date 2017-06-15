/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;

/**
 * ����: �����豸�˿�ʵ��
 * ��������: �����豸�˿�ʵ��
 * ������¼: 2013/12/30
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
@Entity
public class NetDeviceTB extends BaseEntity implements Serializable,Cloneable,NetDeviceInfo {

	/** eiid */
	@Id
	protected String eiid;
	/** eilabel */
	protected String eilabel;
	/** civalue */
	protected String civalue;
	/** eiupdtime */
	protected String eiupdtime;
	
	@Override
	public Serializable getPK() {
		//
		return eiid;
	}

	/**
	 * eiidȡ��
	 *
	 * @return eiid eiid
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * eilabelȡ��
	 *
	 * @return eilabel eilabel
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * civalueȡ��
	 *
	 * @return civalue civalue
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * eiupdtimeȡ��
	 *
	 * @return eiupdtime eiupdtime
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * eiid�趨
	 *
	 * @param eiid eiid
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * eilabel�趨
	 *
	 * @param eilabel eilabel
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * civalue�趨
	 *
	 * @param civalue civalue
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	/**
	 * eiupdtime�趨
	 *
	 * @param eiupdtime eiupdtime
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}
}