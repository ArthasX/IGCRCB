/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 实体链路图接口
  * 功能描述: 实体链路图接口
  * 创建记录: 2011/05/24
  * 修改记录: 
  */
public interface SOC0114Info extends BaseModel {

	/**
	 * 域ID取得
	 *
	 * @return 域ID
	 */
	public Integer getDomainid();

	/**
	 * Domain版本取得
	 *
	 * @return Domain版本
	 */
	public Integer getDomainversion();

	/**
	 * 链路ID取得
	 *
	 * @return 链路ID
	 */
	public Integer getLinkid();

	/**
	 * 链路顺序取得
	 *
	 * @return 链路顺序
	 */
	public Integer getLinkorder();

	/**
	 * 实体id取得
	 *
	 * @return 实体id
	 */
	public Integer getEiid();

	/**
	 * 实体名取得
	 *
	 * @return 实体名
	 */
	public String getEiname();

	/**
	 * 资产层次码取得
	 *
	 * @return 资产层次码
	 */
	public String getEsyscoding();

	/**
	 * 大版本取得
	 *
	 * @return 大版本
	 */
	public Integer getEiversion();

	/**
	 * 小版本取得
	 *
	 * @return 小版本
	 */
	public Integer getEismallversion();
	
	/**
	 * 绘图标记取得
	 *
	 * @return 绘图标记
	 */
	public String getLinkflag();
	
	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getCreatetime();
	
	/**
	 * 链路结束标识取得
	 *
	 * @return 链路结束标识
	 */
	public String getEndflag();

}