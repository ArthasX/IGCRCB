/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.dbs.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;

import com.deliverik.infogovernor.soc.dbs.model.Collect_CXVWInfo;

@SuppressWarnings("serial")
public class Collect_CXVW implements Serializable, Cloneable, Collect_CXVWInfo {

	/** 获取使用率 */
	protected BigDecimal sysBusy;
	/** 获取时间 */
	protected String symtime;
	/** 获取设备 */
	protected String Object_Name;
	/** 获取设备序列号 */
	protected String dataid;

	public String getDataid() {
		return dataid;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
	}

	public String getObject_Name() {
		return Object_Name;
	}

	public void setObject_Name(String object_Name) {
		Object_Name = object_Name;
	}

	public String getSymtime() {
		return symtime;
	}

	public void setSymtime(String symtime) {
		this.symtime = symtime;
	}

	@Id
	private String director_number;
	private String prot;

	public String getProt() {
		return prot;
	}

	public void setProt(String prot) {
		this.prot = prot;
	}

	public BigDecimal getSysBusy() {
		return sysBusy;
	}

	public void setSysBusy(BigDecimal sysBusy) {
		this.sysBusy = sysBusy;
	}

	public String getDirector_number() {
		return director_number;
	}

	public void setDirector_number(String director_number) {
		this.director_number = director_number;
	}

}
