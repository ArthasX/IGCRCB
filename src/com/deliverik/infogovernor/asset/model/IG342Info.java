/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: IG342Info接口
  * 功能描述: IG342Info接口
  * 创建记录: 2012/08/03
  * 修改记录: 
  */
public interface IG342Info extends BaseModel {

	/**
	 * 单位编号取得
	 *
	 * @return 单位编号
	 */
	public Integer getEiid();

	/**
	 * 单位名称取得
	 *
	 * @return 单位名称
	 */
	public String getEiname();

	/**
	 * 地址取得
	 *
	 * @return 地址
	 */
	public String getAddress();

	/**
	 * 联系人取得
	 *
	 * @return 联系人
	 */
	public String getLinkman();

	/**
	 * 联系方式取得
	 *
	 * @return 联系方式
	 */
	public String getPhone();

	/**
	 * 注册资金取得
	 *
	 * @return 注册资金
	 */
	public String getFund();

	/**
	 * 登记时间取得
	 *
	 * @return 登记时间
	 */
	public String getEiinsdate();

	/**
	 * 是否列入资源池取得
	 *
	 * @return 是否列入资源池
	 */
	public String getCivalue();

	/**
	 * 公司资质取得
	 *
	 * @return 公司资质
	 */
	public String getAptitude();

	/**
	 * 成功案例取得
	 *
	 * @return 成功案例
	 */
	public String getSucceedcase();
	
	/**
	 * 修改时间取得
	 *
	 * @return 修改时间
	 */
	public String getEiupdtime();

}