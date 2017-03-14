/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
 * 报表信息查询条件实现
 * 
 */
public class ReportFileDefinitionSearchCondImpl implements ReportFileDefinitionSearchCond {
	
	/** 报表显示名称(模糊匹配) */
	protected String rfdtitle_like;
	
	/** 报表显示名称 */
	protected String rfdtitle;
	
	/** 报表发布名称 */
	protected String rfdfilename;
	
	/** 报表分类 */
	protected String rfdtype;
	
	/** 报表ID*/
	protected Integer rfdid;

	/**
	 * 报表显示名称(模糊匹配)取得
	 * @return 报表显示名称(模糊匹配)
	 */
	public String getRfdtitle_like() {
		return rfdtitle_like;
	}
	
	/**
	 * 报表显示名称(模糊匹配)设定
	 * @param rfdtitle_like 报表显示名称(模糊匹配)
	 */
	public void setRfdtitle_like(String rfdtitle_like) {
		this.rfdtitle_like = rfdtitle_like;
	}
	
	/**
	 * 报表显示名称取得
	 * @return 报表显示名称
	 */
	public String getRfdtitle() {
		return rfdtitle;
	}

	/**
	 * 报表显示名称设定
	 * @param rfdtitle 报表显示名称
	 */
	public void setRfdtitle(String rfdtitle) {
		this.rfdtitle = rfdtitle;
	}

	/**
	 * 报表分类取得
	 * @return 报表分类
	 */
	public String getRfdtype() {
		return rfdtype;
	}

	/**
	 * 报表分类设定
	 * @param rfdtype 报表分类
	 */
	public void setRfdtype(String rfdtype) {
		this.rfdtype = rfdtype;
	}

	/**
	 * 报表发布名称取得
	 * @return 报表发布名称
	 */
	public String getRfdfilename() {
		return rfdfilename;
	}

	/**
	 * 报表发布名称设定
	 * @param rfdfilename 报表发布名称
	 */
	public void setRfdfilename(String rfdfilename) {
		this.rfdfilename = rfdfilename;
	}
	
	public Integer getRfdid() {
		return rfdid;
	}

	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}
	
}
