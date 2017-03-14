/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: PVVIO接口
  * 功能描述: PVVIO接口
  * 创建记录: 2012/08/20
  * 修改记录: 
  */
public interface SOC0434Info extends BaseModel {

	/**
	 * PVVID取得
	 *
	 * @return PVVID
	 */
	public Integer getPVVID();

	/**
	 * SN取得
	 *
	 * @return SN
	 */
	public String getSN();

	/**
	 * PVID取得
	 *
	 * @return PVID
	 */
	public String getPVID();

	/**
	 * SNAME取得
	 *
	 * @return SNAME
	 */
	public String getSNAME();

	/**
	 * LUNID取得
	 *
	 * @return LUNID
	 */
	public String getLUNID();

	/**
	 * PVSIZE取得
	 *
	 * @return PVSIZE
	 */
	public Integer getPVSIZE();

	/**
	 * ISUSED取得
	 *
	 * @return ISUSED
	 */
	public String getISUSED();

	/**
	 * CREATEDATE取得
	 *
	 * @return CREATEDATE
	 */
	public String getCREATEDATE();

}