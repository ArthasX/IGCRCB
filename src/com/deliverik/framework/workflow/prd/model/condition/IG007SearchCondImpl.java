/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>概述:流程变量定义信息检索条件实现</p>
 * <p>功能描述:</p>
 * <p>创建记录：</p>
 */
public class IG007SearchCondImpl implements IG007SearchCond{
	
	/** 流程变量定义ID */
	protected String pidid;

	/** 流程类型ID */
	protected String pdid;

	/** 流程变量显示名称 */
	protected String pidlabel;
	
	/** 流程变量名称 */
	protected String pidname;

	/** 流程变量类型 */
	protected String pidtype;

	/** 流程变量是否必填 */
	protected String pidrequired;
	
	/** 流程变量名称(模糊匹配) */
	protected String pidname_like;
	
	/** 流程变量定义是否判断变量为缺省变量标识（IGWFBaseBLType.YES判断，IGWFBaseBLType.NO不判断） */
	protected String isDefault;
	
	/** 表单信息的模式 */
	protected String pidmode;
	
	protected String pidid_notlike;
	
	protected String ppdid_like;
	
	protected String psdid_like;
	
	protected String[] pidtypes;
	
	/** 父表单定义主键 */
    protected String ppidid;
	
	/** 表格类表单列标识 */
	protected String tableColumn;
	
	/** 是否导出操作 */
	protected String isExport;
	
	/** 表格使用模式 */
	protected String piduse;
	
	public String getPiduse() {
		return piduse;
	}

	public void setPiduse(String piduse) {
		this.piduse = piduse;
	}

	public String[] getPidtypes() {
		return pidtypes;
	}

	public void setPidtypes(String[] pidtypes) {
		this.pidtypes = pidtypes;
	}

	/** 流程定义ID */
	protected String pidid_like;

	public String getPidid_notlike() {
		return pidid_notlike;
	}

	public void setPidid_notlike(String pidid_notlike) {
		this.pidid_notlike = pidid_notlike;
	}

	/**
	 * 共通变量ID
	 */
	protected Integer pidgid;

	/**
	 * 流程共通变量ID取得
	 * @return 流程共通变量ID
	 */
	public Integer getPidgid() {
		return pidgid;
	}
	
	/**
	 * 功能：流程共通变量ID设定
	  * @param pidgid 流程共通变量ID
	 */
	public void setPidgid(Integer pidgid) {
		this.pidgid = pidgid;
	}
	
	/**
	 * 功能：流程变量定义ID取得
	 * @return 流程变量定义ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 功能：流程变量定义ID设定
	  * @param pidid 流程变量定义ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 功能：流程类型ID取得
	 * @return 流程类型ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 功能：流程类型ID设定
	  * @param pdid 流程类型ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 功能：流程变量显示名称取得
	 * @return 流程变量显示名称
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * 功能：流程变量显示名称设定
	  * @param pidlabel 流程变量显示名称
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * 功能：流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * 功能：流程变量类型设定
	  * @param pidtype 流程变量类型
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * 功能：流程变量是否必填取得
	 * @return 流程变量是否必填
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * 功能：流程变量是否必填设定
	  * @param pidrequired 流程变量是否必填
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

	/**
	 * 功能：流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 功能：流程变量名称设定
	  * @param pidname 流程变量名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 功能：流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPidname_like() {
		return pidname_like;
	}

	/**
	 * 功能：流程变量名称设定
	 * @param pidname_like 流程变量名称
	 */
	public void setPidname_like(String pidname_like) {
		this.pidname_like = pidname_like;
	}

	/**
	 * 功能：流程变量定义是否判断变量为缺省变量标识取得
	 * @return 流程变量定义是否判断变量为缺省变量标识
	 */
	public String getIsDefault() {
		return isDefault;
	}

	/**
	 * 功能：流程变量定义是否判断变量为缺省变量标识设定
	  * @param isDefault 流程变量定义是否判断变量为缺省变量标识
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	/**
	 * 表单信息的模式取得
	 *
	 * @return pidmode 表单信息的模式
	 */
	public String getPidmode() {
		return pidmode;
	}

	/**
	 * 表单信息的模式设定
	 *
	 * @param pidmode 表单信息的模式
	 */
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}

	public String getPpdid_like() {
		return ppdid_like;
	}

	public void setPpdid_like(String ppdid_like) {
		this.ppdid_like = ppdid_like;
	}

	public String getPsdid_like() {
		return psdid_like;
	}

	public void setPsdid_like(String psdid_like) {
		this.psdid_like = psdid_like;
	}
	
	protected String psdcode_like;

	public String getPsdcode_like() {
		return psdcode_like;
	}

	public void setPsdcode_like(String psdcode_like) {
		this.psdcode_like = psdcode_like;
	}

	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPidid_like() {
		return pidid_like;
	}

	/**
	 * 流程定义ID设定
	 * 
	 * @param pidid_like 流程定义ID
	 */
	public void setPidid_like(String pidid_like) {
		this.pidid_like = pidid_like;
	}

	/**
	 * 表格类表单列标识取得
	 * @return tableColumn 表格类表单列标识
	 */
	public String getTableColumn() {
		return tableColumn;
	}

	/**
	 * 表格类表单列标识设定
	 * @param tableColumn 表格类表单列标识
	 */
	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	}
	
	/**
	 * 父表单定义主键取得
	 * @return ppidid 父表单定义主键
	 */
	public String getPpidid() {
		return ppidid;
	}

	/**
	 * 父表单定义主键设定
	 * @param ppidid 父表单定义主键
	 */
	public void setPpidid(String ppidid) {
		this.ppidid = ppidid;
	}

	/**
	 *是否导出操作取得
	 */
	public String getIsExport() {
		return isExport;
	}

	/**
	 *是否导出操作设定
	 */
	public void setIsExport(String isExport) {
		this.isExport = isExport;
	}
	
}
