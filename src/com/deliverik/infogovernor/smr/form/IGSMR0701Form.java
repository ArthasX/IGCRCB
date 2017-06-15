/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 不定期报表发起Form
 *
 */
@SuppressWarnings("serial")
public class IGSMR0701Form extends BaseForm{

	/** 填报限制时间 */
	protected String limittime;

	/** 备注 */
	protected String remark;
	
	/** 要发起的流程id集合 */
	protected String pdids;
	
	/** 是否测试发起 */
	protected String test;

	/**
	 *填报限制时间取得
	 */
	public String getLimittime() {
		return limittime;
	}

	/**
	 *填报限制时间设定
	 */
	public void setLimittime(String limittime) {
		this.limittime = limittime;
	}

	/**
	 *备注取得
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 *备注设定
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 *要发起的流程id集合取得
	 */
	public String getPdids() {
		return pdids;
	}

	/**
	 *要发起的流程id集合设定
	 */
	public void setPdids(String pdids) {
		this.pdids = pdids;
	}

	/**
	 * 是否测试发起取得
	 * 
	 * @return 是否测试发起
	 */
	public String getTest() {
		return test;
	}

	/**
	 * 是否测试发起设定
	 * 
	 * @param test 是否测试发起
	 */
	public void setTest(String test) {
		this.test = test;
	}
	
}
