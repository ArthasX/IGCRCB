/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: vim05接口
  * 功能描述: vim05接口
  * 创建记录: 2014/02/21
  * 修改记录: 
  */
public interface VIM05Info extends BaseModel {

	/**
	 * id取得
	 *
	 * @return id
	 */
	public Integer getId();

	/**
	 * name取得
	 *
	 * @return name
	 */
	public String getName();
	
	
	public String getCreatetime();
	
	public List<VIM06Info> getConfigItemList();

}