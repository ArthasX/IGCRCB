/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.condition;

/**
 * 概述：应急日志信息表检索条件接口
 * 功能描述：应急日志信息表检索条件接口
 * 创建记录：2014/05/19
 * (1)升序与降序排序条件以EmergencyLogTB中的字段列为主且这里只是简单排序没涉及复杂关系
 * 修改记录：
 */
public interface EmergencyLogSearchCond {
	/**
	 * 应急相关流程ID取得
	 * @return 应急相关流程ID(完全匹配)
	 */
	public String getElprid_eq();
	/**
	 * 日志信息类型取得
	 * @return 日志信息类型(完全匹配)
	 */
	public String getEllitype_eq();
	
	/**
	 * 升序排序条件取得
	 * @return 升序排序条件字段组组
	 */
	public String[] getAscs();
	/**
	 * 降序排序条件取得
	 * @return 降序排序条件字段组组
	 */
	public String[] getDesc();
	
	public String[] getPsdid_in();
	
	public Integer[] getPrid_in();
}