/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.base.BaseForm;
/**
 * 概述: 资产域定义详细信息查询画面FORM
 * 功能描述: 资产域定义详细信息查询画面FORM
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
public class IGASM2005Form extends BaseForm implements EiDomainDefInfo{
	private static final long serialVersionUID = 1L;
	/** 主键 */
	protected Integer eiddid;

	/** 名称 */
	protected String name;

	/** 版本号 */
	protected Integer version;

	/** 描述 */
	protected String description;

	/**
	 * 创建时间
	 */
	protected String createtime;
	/**
	 * 更新时间
	 */
	protected String updatetime;
	/**
	 * 记录时间戳
	 */
	protected String fingerPrint;

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
	 * 名称取得
	 * 
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名称设置
	 * 
	 * @param name名称
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * 描述取得
	 * 
	 * @return 描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 描述设置
	 * 
	 * @param description描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 创建时间取得
	 * 
	 * @return 创建时间
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * 创建时间设置
	 * 
	 * @param createtime创建时间
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * 更新时间取得
	 * 
	 * @return 更新时间
	 */
	public String getUpdatetime() {
		return updatetime;
	}

	/**
	 * 更新时间设置
	 * 
	 * @param updatetime更新时间
	 */
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	/**
	 * 记录时间戳取得
	 * @return 记录时间
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 记录时间戳设置
	 * @param fingerPrint记录时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
}
