/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 流程定义查询画面Form
 * 
 * @author liupeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGPRD0109Form extends BaseForm {

	/** 
	 * 流程参与者变量权限ID 
	 */
	protected String ptdid;
	
	/** 流程ID */
	protected String pdid;
	
	/**
	 * 流程状态ID（From）
	 */
	protected String fpsdid;
	
	/**
	 * 流程状态ID（To）
	 */
	protected String tpsdid;
	
	/** 父流程状态ID */
	protected String ppsdid;
	
	/**
	 * 是否缺省规则定义标识，1是
	 */
	protected String flag;
	
	/**
	 * 流程状态参与者ID
	 */
	protected String[] roleidArray;
	
	/**
	 * 流程状态跃迁规则
	 */
	protected String[] condArray;
	
	/**
	 * 逻辑运算符号
	 */
	protected String[] logicSign;
	
	/**
	 * 变量ID
	 */
	protected String[] variableID;
	
	/**
	 * 变量值
	 */
	protected String[] vvalue;
	
	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程状态跃迁规则ID取得
	 * @return 流程状态跃迁规则ID
	 */
	public String getPtdid() {
		return ptdid;
	}

	/**
	 * 流程状态跃迁规则ID设定
	 * @param ptdid 流程状态跃迁规则ID
	 */
	public void setPtdid(String ptdid) {
		this.ptdid = ptdid;
	}

	/**
	 * 流程状态ID（From）取得
	 * @return 流程状态ID（From）
	 */
	public String getFpsdid() {
		return fpsdid;
	}

	/**
	 * 流程状态ID（From）设定
	 * @param fpsdid 流程状态ID（From）
	 */
	public void setFpsdid(String fpsdid) {
		this.fpsdid = fpsdid;
	}

	/**
	 * 流程状态ID（To）取得
	 * @return 流程状态ID（To）
	 */
	public String getTpsdid() {
		return tpsdid;
	}

	/**
	 * 流程状态ID（To）设定
	 * @param tpsdid 流程状态ID（To）
	 */
	public void setTpsdid(String tpsdid) {
		this.tpsdid = tpsdid;
	}

	/**
	 * 流程状态参与者ID取得
	 * @return 流程状态参与者ID
	 */
	public String[] getRoleidArray() {
		return roleidArray;
	}

	/**
	 * 流程状态参与者ID设定
	 * @param roleidArray 流程状态参与者ID
	 */
	public void setRoleidArray(String[] roleidArray) {
		this.roleidArray = roleidArray;
	}

	/**
	 * 流程状态跃迁规则取得
	 * @return 流程状态跃迁规则
	 */
	public String[] getCondArray() {
		return condArray;
	}

	/**
	 * 流程状态跃迁规则设定
	 * @param condArray 流程状态跃迁规则
	 */
	public void setCondArray(String[] condArray) {
		this.condArray = condArray;
	}

	public String[] getLogicSign() {
		return logicSign;
	}

	public void setLogicSign(String[] logicSign) {
		this.logicSign = logicSign;
	}

	public String[] getVariableID() {
		return variableID;
	}

	public void setVariableID(String[] variableID) {
		this.variableID = variableID;
	}

	public String[] getVvalue() {
		return vvalue;
	}

	public void setVvalue(String[] vvalue) {
		this.vvalue = vvalue;
	}

	/**
	 * 是否缺省规则定义标识取得
	 * @return 是否缺省规则定义标识
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 是否缺省规则定义标识设定
	 * @param flag是否缺省规则定义标识
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	/** 查看模式 0最新：可编辑，1：历史：只查看 */
	protected String viewhistory;

	/**
	 * 查看模式
	 *
	 * @return 查看模式
	 */
	public String getViewhistory() {
		return viewhistory;
	}

	/**
	 * 查看模式
	 *
	 * @param viewHistory  0：最新，1历史
	 */
	public void setViewhistory(String viewhistory) {
		this.viewhistory = viewhistory;
	}

	/**
	 * 父流程状态ID取得
	 * @return 父流程状态ID
	 */
	public String getPpsdid() {
		return ppsdid;
	}

	/**
	 * 父流程状态ID设定
	 * @param ppsdid 父流程状态ID
	 */
	public void setPpsdid(String ppsdid) {
		this.ppsdid = ppsdid;
	}
	
}
