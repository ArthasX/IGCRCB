package com.deliverik.framework.workflow.prr.model.condition;


/**
 * <p>
 * 表单日志信息检索条件
 * </p>
 * 
 */
public interface IG113SearchCond {
	

	/**
	 * 变量ID取得
	 * @return 变量ID
	 */
	public Integer getPiid();
	

	/**
	 * 日志ID取得
	 * @return 日志ID
	 */
	public Integer getRlid();

	/**
	 * 流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid();
	
	/**
	 * 表单值是否为空取得
	 * @return valueIsNull 表单值是否为空
	 */
	public String getValueIsNull();
}
