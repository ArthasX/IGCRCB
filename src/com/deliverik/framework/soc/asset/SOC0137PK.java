/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset;

import java.io.Serializable;

import javax.persistence.Id;


import com.deliverik.framework.base.BasePK;

/**
 * 概述: 设备关系信息(VG-PV-Meta)
 * 功能描述: 设备关系信息VO(VG-PV-Meta)
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class SOC0137PK extends BasePK implements Serializable {
	/** 审计任务ID */
	@Id
	protected Integer autid;
	
	/** 资产ID */
	@Id
	protected Integer eiid;

	/** 大版本 */
	@Id
	protected Integer eiversion;

	/** 小版本 */
	@Id
	protected Integer eismallversion;
	
	
	/**
	 * 构造函数
	 */
	public SOC0137PK() {
		super();
	}
	
	
	/**
	 * 构造函数
	 * @param autid
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 */
	public SOC0137PK(Integer autid, Integer eiid, Integer eiversion,
			Integer eismallversion) {
		super();
		this.autid = autid;
		this.eiid = eiid;
		this.eiversion = eiversion;
		this.eismallversion = eismallversion;
	}



	/**
	 * 审计任务ID取得
	 *
	 * @return 审计任务ID
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * 审计任务ID设定
	 *
	 * @param autid 审计任务ID
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}

	/**
	 * 资产ID取得
	 *
	 * @return 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 大版本取得
	 *
	 * @return 大版本
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 大版本设定
	 *
	 * @param eiversion 大版本
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 小版本取得
	 *
	 * @return 小版本
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}

	/**
	 * 小版本设定
	 *
	 * @param eismallversion 小版本
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}

}
