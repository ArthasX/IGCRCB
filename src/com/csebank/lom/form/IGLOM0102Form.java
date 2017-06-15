/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.RecptionGuest;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 接待客人登记变更Form
 *
 */
public class IGLOM0102Form extends BaseForm  implements RecptionGuest {
	
	
	private static final long serialVersionUID = 1L;

	/** 接待客人ID */
	protected Integer rgid;

	/** 接待工作ID */
	public Integer rid;
	
	/** 接待客人姓名 */
	public String rgname;
	
	/** 接待客人职务 */
	public String rgpost;
	
	/** 接待客人单位 */
	public String rgunit;
	
	/** 接待客人联系方式 */
	public String rgtel;
	
	/** 登记日期 */
	public String rgdate;

	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	protected String mode = "0";

	
	


	/**
	 * 接待客人ID取得
	 * @return 接待工作ID
	 */
	public Integer getRgid() {
		return rgid;
	}

	/**
	 * 接待客人ID设定
	 * @param rgid 接待工作ID
	 */
	public void setRgid(Integer rgid) {
		this.rgid = rgid;
	}

	/**
	 * 接待工作ID取得
	 * @return 接待工作ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * 接待工作ID设定
	 * @param rgid 接待工作ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * 接待客人姓名取得
	 * @return 接待客人姓名
	 */
	public String getRgname() {
		return rgname;
	}

	/**
	 * 接待客人姓名设定
	 * @param rgname 接待客人姓名
	 */
	public void setRgname(String rgname) {
		this.rgname = rgname;
	}

	/**
	 * 接待客人职务取得
	 * @return 接待客人职务
	 */
	public String getRgpost() {
		return rgpost;
	}

	/**
	 * 接待客人职务设定
	 * @param rgpost 接待客人职务
	 */
	public void setRgpost(String rgpost) {
		this.rgpost = rgpost;
	}

	/**
	 * 接待客人单位取得
	 * @return 接待客人单位
	 */
	public String getRgunit() {
		return rgunit;
	}

	/**
	 * 接待客人单位设定
	 * @param rgunit 接待客人单位
	 */
	public void setRgunit(String rgunit) {
		this.rgunit = rgunit;
	}

	/**
	 * 接待客人联系方式取得
	 * @return 接待客人联系方式
	 */
	public String getRgtel() {
		return rgtel;
	}

	/**
	 * 接待客人联系方式设定
	 * @param rgtel 接待客人联系方式
	 */
	public void setRgtel(String rgtel) {
		this.rgtel = rgtel;
	}

	/**
	 * 登记日期取得
	 * @return 登记日期
	 */
	public String getRgdate() {
		return rgdate;
	}

	/**
	 * 登记日期设定
	 * @param rgdate 登记日期
	 */
	public void setRgdate(String rgdate) {
		this.rgdate = rgdate;
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



}
