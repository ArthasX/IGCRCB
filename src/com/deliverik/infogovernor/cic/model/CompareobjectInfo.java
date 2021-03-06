/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.cic.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 对比对象接口
  * 功能描述: 对比对象接口
  * 创建记录: 2014/04/22
  * 修改记录: 
  */
public interface CompareobjectInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCoid();

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getConame();

	/**
	 * 对比源主机id取得
	 *
	 * @return 对比源主机id
	 */
	public Integer getCosource();

	/**
	 * 对比目标主机id取得
	 *
	 * @return 对比目标主机id
	 */
	public Integer getCotarget();

	/**
	 * 对比规则外键取得
	 *
	 * @return 对比规则外键
	 */
	public Integer getFkCrid();

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
     * 对比规则版本 取得
     * @return crversion 对比规则版本 
     */
    public Integer getCrversion();

}