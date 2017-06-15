/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 流程缺省参与者变量权限
 * 
 */
public interface IG699Info  extends BaseModel {
	/**
	 * 流程缺省参与者变量权限ID取得
	 * @return 流程缺省参与者变量权限ID
	 */
	public String getPdvid();
	
	/**
	 * 流程变量ID取得
	 * @return 流程变量ID
	 */
	public String getPidid();
	
	/**
	 * 流程状态的ID取得
	 * @return 流程状态的ID
	 */
	public String getPsdid();

	/**
	 * 表单信息取得
	 * @return 表单信息
	 */
	public IG007Info getProcessInfoDef();
	
	/**
	 * 流程缺省参与者变量权限取得
	 * @return 流程缺省参与者变量权限
	 */
	public String getPidaccess();

	/**
	 * 流程变量是否必填取得
	 *
	 * @return 流程变量是否必填
	 */
	public String getPidrequired();
}
