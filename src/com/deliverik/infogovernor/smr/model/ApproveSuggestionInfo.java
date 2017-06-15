/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 审批意见表接口
  * 功能描述: 审批意见表接口
  * 创建记录: 2013/07/22
  * 修改记录: 
  */
public interface ApproveSuggestionInfo extends BaseModel {

	/**
	 * 自增ID取得
	 *
	 * @return 自增ID
	 */
	public Integer getId();

	/**
	 * 表单定义ID取得
	 *
	 * @return 表单ID
	 */
	public String getPidid();

	/**
	 * 流程ID取得
	 *
	 * @return prid 流程ID
	 */
	public Integer getPrid();
	
	/**
	 * 状态标识取得
	 *
	 * @return 状态标识
	 */
	public String getPsdcode();

	/**
	 * 状态名称取得
	 *
	 * @return 状态名称
	 */
	public String getPsdname();

	/**
	 * 意见取得
	 *
	 * @return 意见
	 */
	public String getSuggestion();

	/**
	 * 意见状态取得
	 *
	 * @return 意见状态
	 */
	public String getStatus();

	/**
	 * 驳回时间取得
	 *
	 * @return 驳回时间
	 */
	public String getInserttime();

	/**
	 * 驳回人ID取得
	 *
	 * @return 驳回人ID
	 */
	public String getUserid();

	/**
	 * 驳回人姓名取得
	 *
	 * @return 驳回人姓名
	 */
	public String getUsername();
	
	/**
	 * 表格式表单行号取得
	 * @return rownumber 表格式表单行号
	 */
	public String getRownumber();

}