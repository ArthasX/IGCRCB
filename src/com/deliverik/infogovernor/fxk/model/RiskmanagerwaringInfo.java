/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.fxk.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 风险管理提示数据表接口
  * 功能描述: 风险管理提示数据表接口
  * 创建记录: 2014/06/17
  * 修改记录: 
  */
public interface RiskmanagerwaringInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRwid();

	/**
	 * 风险提示名称取得
	 *
	 * @return 风险提示名称
	 */
	public String getRwname();

	/**
	 * 下发起者id取得
	 *
	 * @return 下发起者id
	 */
	public String getNuserid();

	/**
	 * 下发起者名字取得
	 *
	 * @return 下发起者名字
	 */
	public String getNusername();

	/**
	 * 下发者机构名取得
	 *
	 * @return 下发者机构名
	 */
	public String getNorgname();

	/**
	 * 下发者机构码取得
	 *
	 * @return 下发者机构码
	 */
	public String getNorgid();

	/**
	 * 下发时间取得
	 *
	 * @return 下发时间
	 */
	public String getNtime();

	/**
	 * 下发者联系方式取得
	 *
	 * @return 下发者联系方式
	 */
	public String getNtel();

	/**
	 * 风险提示描述取得
	 *
	 * @return 风险提示描述
	 */
	public String getRwcontext();

	/**
	 * 提示附件取得
	 *
	 * @return 提示附件
	 */
	public String getRwkey();
	
	/**
	 * 显示日期取得
	 * @return showTime 显示日期
	 */
	public String getShowTime();

}