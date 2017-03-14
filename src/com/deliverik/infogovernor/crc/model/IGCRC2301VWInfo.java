/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 功能：程序开发统计
 * @author yukexin 2014-8-12 10:57:37
 */
public interface IGCRC2301VWInfo extends BaseModel{
	
	/**
	 * 主键取得
	 * @return userID  主键
	 */
	public String getUserID();
	
	/**
	 * 人员名字取得
	 * @return userName  人员名字
	 */
	public String getUserName();
	/**
	 * 处理工单数取得
	 * @return disposeNum  处理工单数
	 */
	public Integer getDisposeNum();
	/**
	 * 测试更新驳回次数取得
	 * @return testUpdateRejectNum  测试更新驳回次数
	 */
	public int getTestUpdateRejectNum();
	/**
	 * 测试驳回次数取得
	 * @return testRejectNum  测试驳回次数
	 */
	public int getTestRejectNum();
	/**
	 * 确认驳回次数取得
	 * @return confirmRejectNum  确认驳回次数
	 */
	public int getConfirmRejectNum();
	
	
}
