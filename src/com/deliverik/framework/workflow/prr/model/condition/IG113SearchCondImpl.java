package com.deliverik.framework.workflow.prr.model.condition;

/**
 * 表单日志信息检索条件实现
 */
public class IG113SearchCondImpl implements IG113SearchCond {

	/** 变量ID */
	protected Integer piid;
	
	/** 日志ID */
	protected Integer rlid;
	
	/** 流程记录ID */
	protected Integer prid;
	
	/** 表单值是否为空 Y 为空 N 不为空*/
	protected String valueIsNull;
	
	
	/**
	 * 变量ID取得
	 * @return 变量ID
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * 变量ID设定
	 * @param piid 变量ID
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	

	/**
	 * 日志ID取得
	 * @return 日志ID
	 */
	public Integer getRlid() {
		return rlid;
	}

	/**
	 * 日志ID设定
	 * @param rlid 日志ID
	 */
	public void setRlid(Integer rlid) {
		this.rlid = rlid;
	}

	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程记录ID设定
	 * @param prid 流程记录ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 表单值是否为空取得
	 * @return valueIsNull 表单值是否为空
	 */
	public String getValueIsNull() {
		return valueIsNull;
	}

	/**
	 * 表单值是否为空设定
	 * @param valueIsNull 表单值是否为空
	 */
	public void setValueIsNull(String valueIsNull) {
		this.valueIsNull = valueIsNull;
	}

}
