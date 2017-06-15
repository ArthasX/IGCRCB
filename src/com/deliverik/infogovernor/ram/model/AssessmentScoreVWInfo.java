/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ram.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 评分历史查询接口
  * 功能描述: 评分历史查询接口
  * 创建记录: 2013/10/10
  * 修改记录: 
  */
public interface AssessmentScoreVWInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPpiid();

	/**
	 * 公有表单id取得
	 *
	 * @return 公有表单id
	 */
	public Integer getPiid();

	/**
	 * 流程id取得
	 *
	 * @return 流程id
	 */
	public Integer getPrid();

	/**
	 * 表单名取得
	 *
	 * @return 表单名
	 */
	public String getPivarname();

	/**
	 * 表单内容取得
	 *
	 * @return 表单内容
	 */
	public String getPivarlabel();

	/**
	 * 表单类型取得
	 *
	 * @return 表单类型
	 */
	public String getPivartype();

	/**
	 * 表单id取得
	 *
	 * @return 表单id
	 */
	public String getPidid();

	/**
	 * 角色id取得
	 *
	 * @return 角色id
	 */
	public String getRoleid();

	/**
	 * 用户id取得
	 *
	 * @return 用户id
	 */
	public String getUserid();

	/**
	 * 私有表单值取得
	 *
	 * @return 私有表单值
	 */
	public String getPpivalue();

	/**
	 * 机构码取得
	 *
	 * @return 机构码
	 */
	public String getOrgid();

	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getUsername();
	
	/**
	 * ppicomment取得
	 */
	public String getPpicommect();

}