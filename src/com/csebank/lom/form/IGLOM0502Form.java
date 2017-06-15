/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.condition.EaterySearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 食堂成本管理Form
 *
 */
public class IGLOM0502Form extends BaseForm  implements EaterySearchCond {


	private static final long serialVersionUID = 1L;

	/** 自增无意义主键 */
	protected Integer eid;
	
	/** 日期 */
	protected String edate;
	
	/** 采购原料成本 */
	protected BigDecimal estaplecost;
	
	/** 调味品成本 */
	protected BigDecimal eflavouringcost;
	
	/** 其他成本 */
	protected BigDecimal eothercost;
	
	/** 记录版本标识 */
	protected String fingerprint;
	
	/** 食堂成本信息开始时间 */
	public String etime_from;
	
	/** 食堂成本信息结束时间 */
	public String etime_to;

	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	protected String mode = "0";	
	
	/**
	 * 自增无意义主键
	 * @return 自增无意义主键
	 */
	public Integer getEid() {
		return eid;
	}
	
	/**
	 * 自增无意义主键
	 * @return 自增无意义主键
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getEdate() {
		return edate;
	}
	
	/**
	 * 日期
	 * @return 日期
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	/**
	 * 采购原料成本
	 * @return 采购原料成本
	 */
	public BigDecimal getEstaplecost() {
		return estaplecost;
	}
	
	/**
	 * 采购原料成本
	 * @return 采购原料成本
	 */
	public void setEstaplecost(BigDecimal estaplecost) {
		this.estaplecost = estaplecost;
	}
	
	/**
	 * 调味品成本
	 * @return 调味品成本
	 */
	public BigDecimal getEflavouringcost() {
		return eflavouringcost;
	}
	
	/**
	 * 调味品成本
	 * @return 调味品成本
	 */
	public void setEflavouringcost(BigDecimal eflavouringcost) {
		this.eflavouringcost = eflavouringcost;
	}
	
	/**
	 * 其他成本
	 * @return 其他成本
	 */
	public BigDecimal getEothercost() {
		return eothercost;
	}
	
	/**
	 * 其他成本
	 * @return 其他成本
	 */
	public void setEothercost(BigDecimal eothercost) {
		this.eothercost = eothercost;
	}
	
	/**
	 * 记录版本标识
	 * @return 记录版本标识
	 */
	public String getFingerprint() {
		return fingerprint;
	}
	
	/**
	 * 记录版本标识
	 * @return 记录版本标识
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
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
	
	/**
	 * 食堂成本信息时间查询取得
	 * @return 食堂成本信息开始时间查询
	 */
	public String getEtime_from() {
		return etime_from;
	}

	/**
	 * 食堂成本信息开始时间查询设定
	 * @param etime_from 食堂成本信息开始时间查询
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}

	/**
	 * 食堂成本信息结束时间查询取得
	 * @return 食堂成本信息结束时间查询
	 */
	public String getEtime_to() {
		return etime_to;
	}

	/**
	 * 食堂成本信息结束时间查询设定
	 * @param etime_to 食堂成本信息结束时间查询
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}

}
