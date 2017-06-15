/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 导入程序管理表接口
  * 功能描述: 导入程序管理表接口
  * 创建记录: 2011/05/05
  * 修改记录: 
  */
public interface SOC0113Info extends BaseModel {

	/**
	 * 类型ID取得
	 *
	 * @return 类型ID
	 */
	public Integer getImpTypeid();

	/**
	 * 类型名称取得
	 *
	 * @return 类型名称
	 */
	public String getImpTypename();

	/**
	 * 导入bat名称取得
	 *
	 * @return 导入bat名称
	 */
	public String getImpProgramme();
	
	/**
	 * 审计bat名称取得
	 * @return 审计bat名称
	 */
	public String getImpProgrammeAudit();
	
	/**
	 * 更新bat名称取得
	 * @return 更新bat名称
	 */
	public String getImpProgrammeUpdate();
	
	/**
	 * 脚本名称取得
	 * @return 脚本名称
	 */
	public String getShellname();

}