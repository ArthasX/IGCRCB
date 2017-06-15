/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model;

import java.io.Serializable;

/**
 * 概述:通用查询视图接口
 * 功能描述：通用查询视图接口
 * 创建人：赵梓廷
 * 创建记录： 2013-08-14
 * 修改记录：
 */
public interface ReportHistorySearchVWInfo extends Serializable{

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPrid();
	
	/**
	 * 报表名 取得
	 *
	 * @return 报表名 
	 */
	public String getPrtitle();
	
	/**
	 * 填报人 取得
	 *
	 * @return 填报人 
	 */
	public String getFillinname();
	
	/**
	 * 报表审批人取得
	 *
	 * @return 报表审批人
	 */
	public String getReportapprovename();
	
	/**
	 * 发起人取得
	 *
	 * @return 发起人
	 */
	public String getPrusername();
	
	/**
	 *发起时间取得
	 *
	 * @return 发起时间
	 */
	public String getPrstarttime();
	
	/**
	 *流程类型取得
	 *
	 * @return 流程类型
	 */
	public String getPrpdid();
	
	public String getPrtype();
	
}
