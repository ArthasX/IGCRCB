/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 表格类表单值表接口
  * 功能描述: 表格类表单值表接口
  * 创建记录: 2013/06/25
  * 修改记录: 
  */
public interface IG898Info extends BaseModel {

	/**
	 * 流程主键取得
	 *
	 * @return 流程主键
	 */
	public Integer getPrid();

	/**
	 * 表单定义主键取得
	 *
	 * @return 表单定义主键
	 */
	public String getPidid();

	/**
	 * 列定义主键取得
	 * @return pvcolpidid 列定义主键
	 */
	public String getPvcolpidid();

	/**
	 * 行号取得
	 *
	 * @return 行号
	 */
	public String getPvrownumber();

	/**
	 * 表单值取得
	 *
	 * @return 表单值
	 */
	public String getPvalue();
	
	/**
	 * 表单名称取得
	 * @return pidname 表单名称
	 */
	public String getPidname();

	/**
	 * 列名取得
	 * @return pvcolname 列名
	 */
	public String getPvcolname();
	
	/**
	 * 附件key取得
	 * @return attkey 附件key
	 */
	public String getAttkey();

}