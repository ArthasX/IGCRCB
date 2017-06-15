/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 流程状态变量前处理
 *
 */
public interface IG211Info  extends BaseModel {
	/**
	 * 流程状态变量前处理ID取得
	 * @return 流程状态变量前处理ID
	 */
	public String getPsidid();
	
	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid();
	
	/**
	 * 流程变量ID取得
	 * @return 流程变量ID
	 */
	public String getPidid();

	/**
	 * 流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPidname();
	
	/**
	 * 流程变量显示名称取得
	 * @return 流程变量显示名称
	 */
	public String getPidlabel();
	
	/**
	 * 流程变量描述取得
	 * @return 流程变量描述
	 */
	public String getPiddesc();
	
	/**
	 * 流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPidtype();
	

	/**
	 * 流程变量值取得
	 * @return 流程变量值
	 */
	public String getPidvalue();
	
	/**
	 * 文本域绑定附件
	 */
	public String getPidattkey();
}
