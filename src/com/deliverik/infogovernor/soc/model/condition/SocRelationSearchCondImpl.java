package com.deliverik.infogovernor.soc.model.condition;


/**
 * 风险检查信息查询条件实现
 * 
 */
public class SocRelationSearchCondImpl implements SocRelationSearchCond {

	/** 资产label */
	protected String sreilabel;
	
	/** 关联资产label */
	protected String srpareilabel;
	
	/** 关联资产coding */
	protected String sresycoding;
	
	/** 关联资产类型名称 */
	protected String srename;
	
	/** 预留1(保存版本号) */
	protected String srkey1;
	
	/** 版本号 */
	protected Integer version;
	
	/**
	 * 版本号
	 * @return 版本号
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * 版本号设定
	 *
	 * @param version 版本号
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	/**
	 * 预留1(保存版本号)
	 * @return 预留1(保存版本号)
	 */
	public String getSrkey1() {
		return srkey1;
	}

	/**
	 * 预留1(保存版本号)设定
	 *
	 * @param srkey1 预留1(保存版本号)
	 */
	public void setSrkey1(String srkey1) {
		this.srkey1 = srkey1;
	}

	/**
	 * 资产label
	 * @return 资产label
	 */
	public String getSreilabel() {
		return sreilabel;
	}

	/**
	 * 资产label设定
	 *
	 * @param sreilabel 资产label
	 */
	public void setSreilabel(String sreilabel) {
		this.sreilabel = sreilabel;
	}

	
	/**
	 * 关联资产label
	 * @return 关联资产label
	 */
	public String getSrpareilabel() {
		return srpareilabel;
	}

	/**
	 * 关联资产label设定
	 *
	 * @param srpareilabel 关联资产label
	 */
	public void setSrpareilabel(String srpareilabel) {
		this.srpareilabel = srpareilabel;
	}

	/**
	 * 关联资产coding
	 * @return 关联资产coding
	 */
	public String getSresycoding() {
		return sresycoding;
	}

	/**
	 * 关联资产coding设定
	 *
	 * @param sresycoding 关联资产coding
	 */
	public void setSresycoding(String sresycoding) {
		this.sresycoding = sresycoding;
	}

	/**
	 * 关联资产类型名称
	 * @return 关联资产类型名称
	 */
	public String getSrename() {
		return srename;
	}

	/**
	 * 关联资产类型名称设定
	 *
	 * @param srename 关联资产类型名称
	 */
	public void setSrename(String srename) {
		this.srename = srename;
	}
}
