/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.EiDomainDefSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 资产域定义Form
 * 功能描述: 资产域定义Form
 * 创建记录: 2011/04/26
 * 修改记录: 
 */
public class IGASM2012Form extends BaseForm implements EiDomainDefSearchCond{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	protected Integer eiddid;
	
	/** 版本号 */
	protected Integer version;
	
	
	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * 主键设置
	 * 
	 * @param eiddid主键
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}
	
	/**
	 * 版本号取得
	 * 
	 * @return 版本号
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 版本号设置
	 * 
	 * @param version版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	
	
	
	
	
	
	public String getCreatetime_from() {
		return null;
	}

	public String getCreatetime_to() {
		return null;
	}

	public String getEiddid_eq() {
		return null;
	}

	public String getName_like() {
		return null;
	}
	
	
	
}
