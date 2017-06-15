package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 流程模板信息
 *
 */
public interface IG259Info  extends BaseModel {

	/**
	 * 流程模板ID取得
	 * @return 流程模板ID
	 */
	public Integer getPtid();

	/**
	 * 流程模板名称取得
	 * @return 流程模板名称
	 */
	public String getPtname();

	/**
	 * 流程模板类型取得
	 * @return 流程模板类型
	 */
	public String getPttype();

	/**
	 * 流程模板发起页URL取得
	 * @return 流程模板发起页URL
	 */
	public String getPtstartpg();

	/**
	 * 流程模板创建时间取得
	 * @return 流程模板创建时间
	 */
	public String getPtcrtdate();

	/**
	 * 流程模板信息取得
	 * @return 流程模板信息
	 */
	public String getPtpicinfo();

	/**
	 * 流程模板状态取得
	 * @return 流程模板状态
	 */
	public String getPtstatus();

	/**
	 * 流程模板查看页URL取得
	 * @return 流程模板查看页URL
	 */
	public String getPtdetailpg();

	/**
	 * 通过流程模版所跳转的发起页的URL（平台保留）取得
	 * @return 通过流程模版所跳转的发起页的URL
	 */
	public String getPtsavepg();

	/**
	 * 流程模板使用位置标识（平台保留）取得
	 * @return 流程模板使用位置标识
	 */
	public String getPtqrtzflag();
	
	/**
	 * 首位置标识取得
	 * @return firstsite 首位置标识
	 */
	public String getFirstsite();

	/**
	 * 序列定义取得
	 * @return pdsequence 序列定义
	 */
	public String getPdsequence();
}