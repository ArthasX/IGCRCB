/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;


/**
  * 概述: 资产域定义表检索条件实现
  * 功能描述: 资产域定义表检索条件实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class EiDomainDefSearchCondImpl implements
		EiDomainDefSearchCond {
	/**
	 * 资产域定义名称
	 */
	protected String name_like;
	/**
	 * 资产域定义开始时间
	 */
	protected String createtime_from;
	/**
	 * 资产域定义截止时间
	 */
	protected String createtime_to;
	
	/** 域定义ID */
	protected String eiddid_eq;
	
	/** 主键 */
	protected Integer eiddid;
	
	/** 版本号 */
	protected Integer version;
	
	
	/**
	 * 资产域定义名称取得
	 */
	public String getName_like() {
		return name_like;
	}
	/**
	 * 资产域定义名称设定
	 * @param name资产域定义名称
	 */
	public void setName_like(String name_like) {
		this.name_like = name_like;
	}
	/**
	 * 资产域定义开始时间取得
	 */
	public String getCreatetime_from() {
		return createtime_from;
	}
	/**
	 * 资产域定义开始时间设定
	 * @param createtime_from资产域定义开始时间
	 */
	public void setCreatetime_from(String createtime_from) {
		this.createtime_from = createtime_from;
	}
	/**
	 * 资产域定义截止时间取得
	 */
	public String getCreatetime_to() {
		return createtime_to;
	}
	/**
	 * 资产域定义截止时间设定
	 * @param createtime_to资产域定义截止时间
	 */
	public void setCreatetime_to(String createtime_to) {
		this.createtime_to = createtime_to;
	}
	
	/**
	 * 域定义ID取得
	 * 
	 * @return 域定义ID
	 */
	public String getEiddid_eq() {
		return eiddid_eq;
	}
	
	/**
	 * 域定义ID设定
	 * 
	 * @param eiddid_eq域定义ID
	 */
	public void setEiddid_eq(String eiddid_eq) {
		this.eiddid_eq = eiddid_eq;
	}
	
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
}