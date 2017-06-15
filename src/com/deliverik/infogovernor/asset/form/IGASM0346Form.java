/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 配置包含关系显示FORM
 * 功能描述: 配置包含关系显示FORM
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGASM0346Form extends BaseForm {

	/** 顶级配置资产ID */
	protected String eirootmark;
	
	/** 设备ID */
	protected String eiid;
	
	/** 设备配置大版本 */
	protected String eiversion;
	
	/** 设备配置小版本 */
	protected String eismallversion;
	
	/**
	 * 顶级配置资产ID取得
	 * 
	 * @return 顶级配置资产ID
	 */
	public String getEirootmark() {
		return eirootmark;
	}

	/**
	 * 顶级配置资产ID设定
	 * 
	 * @param eirootmark
	 */
	public void setEirootmark(String eirootmark) {
		this.eirootmark = eirootmark;
	}

	/**
	 * 设备ID取得
	 * @return 设备ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 设备ID设定
	 *
	 * @param eiid 设备ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 设备配置大版本取得
	 * 
	 * @return 设备配置大版本
	 */
	public String getEiversion() {
		return eiversion;
	}

	/**
	 * 设备配置大版本设定
	 *
	 * @param eiversion 设备配置大版本
	 */
	public void setEiversion(String eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * 设备配置小版本取得
	 * @return 设备配置小版本
	 */
	public String getEismallversion() {
		return eismallversion;
	}
	
	/**
	 * 设备配置小版本设定
	 *
	 * @param eismallversion 设备配置小版本
	 */
	public void setEismallversion(String eismallversion) {
		this.eismallversion = eismallversion;
	}
}
