/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>概述:流程共通变量接口</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public interface IG202Info extends BaseModel {
	
	/**
	 * 功能：流程变量定义ID取得
	 * @return 流程变量定义ID
	 */
	public Integer getPidid();

	/**
	 * 功能：流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPidname();

	/**
	 * 功能：流程变量显示名称取得
	 * @return 流程变量显示名称
	 */
	public String getPidlabel();

	/**
	 * 功能：流程变量描述取得
	 * @return 流程变量描述
	 */
	public String getPiddesc();

	/**
	 * 功能：流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPidtype();

	/**
	 * 功能：流程变量选项取得
	 * @return 流程变量选项
	 */
	public String getPidoption();

	/**
	 * 功能：流程变量默认值取得
	 * @return 流程变量默认值
	 */
	public String getPiddefault();

	/**
	 * 功能：流程变量是否必填取得
	 * @return 流程变量是否必填
	 */
	public String getPidrequired();

	/**
	 * 功能：流程变量排序标识取得
	 * @return 流程变量排序标识
	 */
	public String getPidsortid();

	/**
	 * 功能：树形流程变量CCID取得
	 * @return 树形流程变量CCID
	 */
	public String getCcid();

	public String getPidmode();
	
	/**
	 * 表单信息的行显示模式取得
	 *
	 * @return 表单信息的行模式
	 */
	public String getRowwidth();
	
	/**
	 * 私有变量权限范围设定
	 * 
	 * @return 私有变量权限范围
	 */
	public String getPrivatescope();
}
