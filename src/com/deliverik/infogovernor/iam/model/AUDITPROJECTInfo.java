/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 审计报告表接口
  * 功能描述: 审计报告表接口
  * 创建记录: 2012/08/08
  * 修改记录: 
  */
public interface AUDITPROJECTInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getApid();

	/**
	 * 审计报告类型取得
	 *
	 * @return 审计报告类型
	 */
	public String getApreporttype();

	/**
	 * 审计项目ID取得
	 *
	 * @return 审计项目ID
	 */
	public Integer getApprojectid();

	/**
	 * 项目名称取得
	 *
	 * @return 项目名称
	 */
	public String getApprojectname();

	/**
	 * 项目年度取得
	 *
	 * @return 项目年度
	 */
	public String getApprojectyear();

	/**
	 * 审计报告附件KEY取得
	 *
	 * @return 审计报告附件KEY
	 */
	public String getApattkey();

}