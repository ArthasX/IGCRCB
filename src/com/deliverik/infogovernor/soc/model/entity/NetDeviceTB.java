/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;

/**
 * 概述: 网络设备端口实体
 * 功能描述: 网络设备端口实体
 * 创建记录: 2013/12/30
 * 修改记录: 
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
	 * eiid取得
	 *
	 * @return eiid eiid
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * eilabel取得
	 *
	 * @return eilabel eilabel
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * civalue取得
	 *
	 * @return civalue civalue
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * eiupdtime取得
	 *
	 * @return eiupdtime eiupdtime
	 */
	public String getEiupdtime() {
		return eiupdtime;
	}

	/**
	 * eiid设定
	 *
	 * @param eiid eiid
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * eilabel设定
	 *
	 * @param eilabel eilabel
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * civalue设定
	 *
	 * @param civalue civalue
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	/**
	 * eiupdtime设定
	 *
	 * @param eiupdtime eiupdtime
	 */
	public void setEiupdtime(String eiupdtime) {
		this.eiupdtime = eiupdtime;
	}
}