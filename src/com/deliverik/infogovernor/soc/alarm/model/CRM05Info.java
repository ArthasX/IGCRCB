/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: CRM05接口
  * 功能描述: CRM05接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM05Info extends BaseModel {

	/**
	 * fileid取得
	 *
	 * @return fileid
	 */
	public Integer getFileid();

	/**
	 * filename取得
	 *
	 * @return filename
	 */
	public String getFilename();

	/**
	 * uploadtime取得
	 *
	 * @return uploadtime
	 */
	public String getUploadtime();

	/**
	 * filepath取得
	 *
	 * @return filepath
	 */
	public String getFilepath();

}