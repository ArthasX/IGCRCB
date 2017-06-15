/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 对比规则接口
  * 功能描述: 对比规则接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface CompareroleInfo extends BaseModel {

	/**
	 * crid取得
	 *
	 * @return crid
	 */
	public Integer getCrid();

	/**
	 * 对比类型取得
	 *
	 * @return 对比类型
	 */
	public String getCrtype();

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getCrname();

	/**
	 * 对比域外键取得
	 *
	 * @return 对比域外键
	 */
	public Integer getFkCsid();

	/**
	 * 业务系统id取得
	 *
	 * @return 业务系统id
	 */
	public Integer getCrsystemid();

	/**
	 * 业务系统名称取得
	 *
	 * @return 业务系统名称
	 */
	public String getCrsystemname();
	
	/** 
     * 对比规则版本 取得
     * @return crversion 对比规则版本 
     */
    public Integer getCrversion();
    
}