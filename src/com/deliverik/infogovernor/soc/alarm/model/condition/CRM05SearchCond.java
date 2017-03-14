/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * 概述: CRM05检索条件接口
  * 功能描述: CRM05检索条件接口
  * 创建记录: 2013/07/30
  * 修改记录: 2013/07/31 xudong wang
  */
public interface CRM05SearchCond {
	
	/**
	 * filename_like取得
	 *
	 * @return filename_like filename_like
	 */
	public String getFilename_like();
	/**
	 * uploadtime_begin取得
	 *
	 * @return uploadtime_begin uploadtime_begin
	 */
	public String getUploadtime_begin();
	/**
	 * uploadtime_end取得
	 *
	 * @return uploadtime_end uploadtime_end
	 */
	public String getUploadtime_end();
}