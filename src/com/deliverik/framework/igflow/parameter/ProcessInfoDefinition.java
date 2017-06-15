/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.igflow.parameter;

/**
 * 表单定义信息
 */
public class ProcessInfoDefinition implements ProcessInfoDefinitionInfo{

	/** 表单定义主键 */
	protected String pidid;
	
	/** 表单名称 */
	protected String pidname;
	
	/** 父级表单定义主键 */
	protected String ppidid;

	/**
	 * 表单定义主键取得
	 * @return 表单定义主键
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义主键设定
	 * @param pidid 表单定义主键
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 表单名称取得
	 * @return 表单名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 表单名称设定
	 * @param pidname 表单名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 父级表单定义主键取得
	 * @return 父级表单定义主键
	 */
	public String getPpidid() {
		return ppidid;
	}

	/**
	 * 父级表单定义主键设定
	 * @param ppidid 父级表单定义主键
	 */
	public void setPpidid(String ppidid) {
		this.ppidid = ppidid;
	}
}
