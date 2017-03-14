/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;

/**
 * 统计分析-报表列表画面FORM
 * 
 */
@SuppressWarnings("serial")
public class IGRPT0102Form extends BaseForm implements ReportFileDefinitionSearchCond{
	
	/** 报表显示名称(模糊匹配) */
	protected String rfdtitle_like;
	
	/** 报表显示名称 */
	protected String rfdtitle;
	
	/**  报表分类 */
	protected String rfdtype;
	
	/** 报表发布名称 */
	protected String rfdfilename;
	
	/** 报表ID */
	protected Integer rfdid;
	
	/** 将要订制的报表ID */
	protected String[] unselect;
	
	/** 将要删除的报表ID */
	protected String[] selected;
	
	/** 已订制的报表顺序号 */
	protected Integer ordernum;
	
	/** 需要交换的报表ID甲 */
	protected Integer rfdidI;
	
	/** 需要交换的报表ID乙 */
	protected Integer rfdidII;
	
	
	
	public Integer getRfdidI() {
		return rfdidI;
	}

	public void setRfdidI(Integer rfdidI) {
		this.rfdidI = rfdidI;
	}

	public Integer getRfdidII() {
		return rfdidII;
	}

	public void setRfdidII(Integer rfdidII) {
		this.rfdidII = rfdidII;
	}

	public String[] getSelected() {
		return selected;
	}

	public void setSelected(String[] selected) {
		this.selected = selected;
	}

	public Integer getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}

	public String[] getUnselect() {
		return unselect;
	}

	public void setUnselect(String[] unselect) {
		this.unselect = unselect;
	}

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
