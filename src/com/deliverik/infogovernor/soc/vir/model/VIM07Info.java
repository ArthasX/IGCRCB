/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 虚机调整信息表接口
  * 功能描述: 虚机调整信息表接口
  * 创建记录: 2014/03/24
  * 修改记录: 
  */
public interface VIM07Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

	/**
	 * 虚机主键取得
	 *
	 * @return 虚机主键
	 */
	public Integer getVmid();
	
	/**
	 * 项目ID取得
	 * @return pid 项目ID
	 */
	public Integer getPid();

	/**
	 * 调整类型取得
	 *
	 * @return 调整类型
	 */
	public String getCtype();

	/**
	 * 流程主键取得
	 *
	 * @return 流程主键
	 */
	public Integer getPrid();

	/**
	 * 调整申请时间取得
	 *
	 * @return 调整申请时间
	 */
	public String getCtime();

	/**
	 * 调整完成时间取得
	 *
	 * @return 调整完成时间
	 */
	public String getAtime();
	
	/**
	 * 调整用户ID取得
	 * @return userid 调整用户ID
	 */
	public String getUserid();

}