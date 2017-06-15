/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 审计对比结果信息表接口
  * 功能描述: 审计对比结果信息表接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface AuditResultInfo extends BaseModel {

	/**
	 * 审计对比结果取得
	 *
	 * @return 审计对比结果
	 */
	public Integer getAurid();

	/**
	 * 审计任务ID取得
	 *
	 * @return 审计任务ID
	 */
	public Integer getAutid();

	/**
	 * 审计时间戳取得
	 *
	 * @return 审计时间戳
	 */
	public String getAutime();

	/**
	 * 对比结果类型取得
	 *
	 * @return 对比结果类型
	 */
	public String getAucmptype();

	/**
	 * 资产ID取得
	 *
	 * @return 资产ID
	 */
	public Integer getEiid();

	/**
	 * 大版本取得
	 *
	 * @return 大版本
	 */
	public Integer getEiversion();

	/**
	 * 小版本取得
	 *
	 * @return 小版本
	 */
	public Integer getEismallversion();

	/**
	 * 资产名称取得
	 *
	 * @return 资产名称
	 */
	public String getEiname();

	/**
	 * 顶级CI标识取得
	 *
	 * @return 顶级CI标识
	 */
	public Integer getEirootmark();

	/**
	 * 属性ID取得
	 *
	 * @return 属性ID
	 */
	public Integer getCiid();

	/**
	 * 属性名取得
	 *
	 * @return 属性名
	 */
	public String getCname();

	/**
	 * 当前版本值取得
	 *
	 * @return 当前版本值
	 */
	public String getCivalue();

	/**
	 * 采集值取得
	 *
	 * @return 采集值
	 */
	public String getAuvalue();

	/**
	 * 合理标识取得
	 *
	 * @return 合理标识
	 */
	public String getAuflag();

	/**
	 * 审计结果说明取得
	 *
	 * @return 审计结果说明
	 */
	public String getAuresultdesc();
	
	/**
	 * 资产层次码取得
	 * 
	 * @return 资产层次码
	 */
	public String getEsyscoding();

}