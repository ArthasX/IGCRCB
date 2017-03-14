/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 报表信息接口
 * 
 */

public interface ReportFileVersion  extends BaseModel {

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Integer getRfvid();
	
	/**
	 * 报表主键取得
	 * @return 报表主键
	 */
	public Integer getRfdid();

	/**
	 * 版本号取得
	 * @return 版本号
	 */
	public Integer getRfvversion();

	/**
	 * 创建时间取得
	 * @return 创建时间
	 */
	public String getRfvinstime();

}