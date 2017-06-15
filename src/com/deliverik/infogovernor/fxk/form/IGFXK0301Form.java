/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fxk.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 表单form信息
 * </p>
 * 2014-7-24
 * 
 * @author wangyaowen@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK0301Form extends BaseForm {
	
    /**计划编号*/
    protected String risknum_l;
    
    /**计划类型*/
    protected String risktype_q;
    
    /**计划标题*/
    protected String  title_l;
    
    /**计划发起者*/
    protected String  prusername_l;
    
    /**计划状态*/
    protected String  riskstatus_q;
    
    /**计划开始时间小于*/
    protected String  riskstart_le;
    
    /**计划开始时间大于*/
    protected String  riskstart_ge;

	/**
	 * 计划编号取得
	 * @return risknum_l 计划编号
	 */
	public String getRisknum_l() {
		return risknum_l;
	}

	/**
	 * 计划编号设定
	 * @param risknum_l 计划编号
	 */
	public void setRisknum_l(String risknum_l) {
		this.risknum_l = risknum_l;
	}

	/**
	 * 计划类型取得
	 * @return risktype_q 计划类型
	 */
	public String getRisktype_q() {
		return risktype_q;
	}

	/**
	 * 计划类型设定
	 * @param risktype_q 计划类型
	 */
	public void setRisktype_q(String risktype_q) {
		this.risktype_q = risktype_q;
	}

	/**
	 * 计划标题取得
	 * @return title_l 计划标题
	 */
	public String getTitle_l() {
		return title_l;
	}

	/**
	 * 计划标题设定
	 * @param title_l 计划标题
	 */
	public void setTitle_l(String title_l) {
		this.title_l = title_l;
	}

	/**
	 * 计划发起者取得
	 * @return prusername_l 计划发起者
	 */
	public String getPrusername_l() {
		return prusername_l;
	}

	/**
	 * 计划发起者设定
	 * @param prusername_l 计划发起者
	 */
	public void setPrusername_l(String prusername_l) {
		this.prusername_l = prusername_l;
	}

	/**
	 * 计划状态取得
	 * @return riskstatus_q 计划状态
	 */
	public String getRiskstatus_q() {
		return riskstatus_q;
	}

	/**
	 * 计划状态设定
	 * @param riskstatus_q 计划状态
	 */
	public void setRiskstatus_q(String riskstatus_q) {
		this.riskstatus_q = riskstatus_q;
	}

	/**
	 * 计划开始时间小于取得
	 * @return riskstart_le 计划开始时间小于
	 */
	public String getRiskstart_le() {
		return riskstart_le;
	}

	/**
	 * 计划开始时间小于设定
	 * @param riskstart_le 计划开始时间小于
	 */
	public void setRiskstart_le(String riskstart_le) {
		this.riskstart_le = riskstart_le;
	}

	/**
	 * 计划开始时间大于取得
	 * @return riskstart_ge 计划开始时间大于
	 */
	public String getRiskstart_ge() {
		return riskstart_ge;
	}

	/**
	 * 计划开始时间大于设定
	 * @param riskstart_ge 计划开始时间大于
	 */
	public void setRiskstart_ge(String riskstart_ge) {
		this.riskstart_ge = riskstart_ge;
	}
}

