/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.condition.EworkingLunchSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 食堂工作餐管理Form
 *
 */
public class IGLOM0504Form extends BaseForm  implements EworkingLunchSearchCond {


	private static final long serialVersionUID = 1L;

	/** 自增无意义主键 */
	protected Integer ewlid;

	/** 日期 */
	protected String ewldate;
	
	/** 餐卡名称 */
	protected String lunchcardname;
	
	/** 餐卡数量 */
	protected Integer lunchcardnum;
	
	/** 餐卡名称 */
	protected String[] lunchcardnameList;
	
	/** 餐卡数量 */
	protected Integer[] lunchcardnumList;
	
	/** 餐卡编号 */
	protected Integer[] icidList;
	
	/** 餐卡价钱 */
	protected BigDecimal lunchcardprince;
	
	/** 餐卡编号 */
	protected Integer icid;
	
	/** 食堂成本信息开始时间 */
	protected String ewltime_from;
	
	/** 食堂成本信息结束时间 */
	protected String ewltime_to;

	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	protected String mode = "0";	
	
	/**
	 * 自增无意义主键
	 * @return 自增无意义主键
	 */
	public Integer getEwlid() {
		return ewlid;
	}
	
	/**
	 * 自增无意义主键
	 * @return 自增无意义主键
	 */
	public void setEwlid(Integer ewlid) {
		this.ewlid = ewlid;
	}
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getEwldate() {
		return ewldate;
	}
	/**
	 * 日期
	 * @param ewldate 日期
	 */
	public void setEwldate(String ewldate) {
		this.ewldate = ewldate;
	}

	/**
	 * 食堂成本信息开始时间查询取得
	 * @return 食堂成本信息开始时间查询
	 */
	public String getEwltime_from() {
		return ewltime_from;
	}

	/**
	 * 食堂成本信息开始时间查询设定
	 * @param ewltime_from 食堂成本信息开始时间查询
	 */
	public void setEwltime_from(String ewltime_from) {
		this.ewltime_from = ewltime_from;
	}

	/**
	 * 食堂成本信息结束时间查询取得
	 * @return 食堂成本信息结束时间查询
	 */
	public String getEwltime_to() {
		return ewltime_to;
	}

	/**
	 * 食堂成本信息结束时间查询设定
	 * @param ewltime_to 食堂成本信息结束时间查询
	 */
	public void setEwltime_to(String ewltime_to) {
		this.ewltime_to = ewltime_to;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 页面标题显示取得
	 * @return 页面标题显示
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 页面标题显示设定
	 * @param mode 页面标题显示
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	public BigDecimal getLunchcardprince() {
		return lunchcardprince;
	}

	public void setLunchcardprince(BigDecimal lunchcardprince) {
		this.lunchcardprince = lunchcardprince;
	}

	public Integer getIcid() {
		return icid;
	}

	public void setIcid(Integer icid) {
		this.icid = icid;
	}

	public String[] getLunchcardnameList() {
		return lunchcardnameList;
	}

	public void setLunchcardnameList(String[] lunchcardnameList) {
		this.lunchcardnameList = lunchcardnameList;
	}

	public Integer[] getLunchcardnumList() {
		return lunchcardnumList;
	}

	public void setLunchcardnumList(Integer[] lunchcardnumList) {
		this.lunchcardnumList = lunchcardnumList;
	}

	public String getLunchcardname() {
		return lunchcardname;
	}

	public void setLunchcardname(String lunchcardname) {
		this.lunchcardname = lunchcardname;
	}

	public Integer getLunchcardnum() {
		return lunchcardnum;
	}

	public void setLunchcardnum(Integer lunchcardnum) {
		this.lunchcardnum = lunchcardnum;
	}

	public Integer[] getIcidList() {
		return icidList;
	}

	public void setIcidList(Integer[] icidList) {
		this.icidList = icidList;
	}

}
