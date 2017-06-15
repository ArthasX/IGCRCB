/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 每月盘点查询接口
 *
 */
public interface InventoryInfoSearchCond {
	
	/** 本月开始 */
	public String getDate_from();
	
	/** 本月结束 */
	public String getDate_to();
	
	/** 上月开始 */
	public String getPredate_from();
	
	/** 上月结束 */
	public String getPredate_to();
	

}
