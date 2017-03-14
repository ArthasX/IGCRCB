/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 对比对象历史表接口
  * 功能描述: 对比对象历史表接口
  * 创建记录: 2014/04/24
  * 修改记录: 
  */
public interface CompareobjectHistoryInfo extends BaseModel {

	/**
	 * 对象历史表主键取得
	 *
	 * @return 对象历史表主键
	 */
	public Integer getCohid();

	/**
	 * 对象表主键取得
	 *
	 * @return 对象表主键
	 */
	public Integer getCoid();

	/** 
     * 对比规则外键 取得
     * @return fkCrid 对比规则外键 
     */
    public Integer getFkCrid();

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getConame();

	/**
	 * 对比目标主机id取得
	 *
	 * @return 对比目标主机id
	 */
	public Integer getCotarget();

	/**
	 * 源主机IP取得
	 *
	 * @return 源主机IP
	 */
	public String getSourceIP();

	/**
	 * targetIP取得
	 *
	 * @return targetIP
	 */
	public String getTargetIP();

	/**
	 * 比对规则表版本取得
	 *
	 * @return 比对规则表版本
	 */
	public Integer getCrversion();
	
	public Integer getCosource();

}