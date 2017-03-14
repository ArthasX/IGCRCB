/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 授权管理接口
 * 
 * 
 */

public interface IG711Info extends BaseModel {
	/**
	 * 授权管理ID取得
	 * 
	 * @return 授权管理ID
	 */
	public Integer getPaid();
	
	/**
	 * 使用人ID取得
	 * 
	 * @return 使用人ID
	 */
	public String getPaiid();
	
	/**
	 * 授权人ID取得
	 * 
	 * @return 授权人ID
	 */
	public String getPauid();
	
	/**
	 * 授权开始日期取得
	 * 
	 * @return 授权开始日期
	 */
	public String getPabegintime();
	
	/**
	 * 授权结束日期取得
	 * 
	 * @return 授权结束日期
	 */
	public String getPaendtime();
	
	/**
	 * 授权标识位(0.未授权，1.已授权)取得
	 * 
	 * @return 授权标识位
	 */
	public String getPaflag();

	/**
	 * 授权类型(0.所有工作，1.单一工作)取得
	 * 
	 * @return 授权标识位
	 */
	public String getPatype();
	
	/**
	 * 工作(流程)ID取得
	 * 
	 * @return 工作(流程)ID
	 */
	public Integer getPaprocessid();
	
	/**
	 * 工作(流程)编号取得
	 * 
	 * @return 工作(流程)编号
	 */
	public String getPaprocessnum();
	
	/**
	 * 授权登记时间取得
	 * 
	 * @return 授权登记时间
	 */
	public String getPalogintime();
	
	/**
	 * 授权说明取得
	 * @return 授权说明
	 */
	public String getRemarks();
}