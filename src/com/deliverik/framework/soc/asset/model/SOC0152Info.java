/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
  * 概述: 资产关系表接口
  * 功能描述: 资产关系表接口
  * 创建记录: 杨龙全 2013/05/27
  * 修改记录: 
  */
public interface SOC0152Info extends BaseModel {

	/**
	 * 关系码取得
	 *
	 * @return 关系码
	 */
	public String getRlnCode();

	/**
	 * 开始模型名字取得
	 *
	 * @return 开始模型名字
	 */
	public String getFromModelName();

	/**
	 * 开始模型ID取得
	 *
	 * @return 开始模型ID
	 */
	public String getFromModelEid();

	/**
	 * 到模型名字取得
	 *
	 * @return 到模型名字
	 */
	public String getToModelName();

	/**
	 * 到模型ID取得
	 *
	 * @return 到模型ID
	 */
	public String getToModelEid();

	/**
	 * 关系描述取得
	 *
	 * @return 关系描述
	 */
	public String getRlnDesc();

	/**
	 * 预留字段1取得
	 *
	 * @return 预留字段1
	 */
	public String getRlnKey1();

	/**
	 * 预留字段2取得
	 *
	 * @return 预留字段2
	 */
	public String getRlnKey2();
	
	/**
	 * 关系类别取得
	 *
	 * @return rlnType 关系类别
	 */
	
	public String getRlnType();
	
	/**
	 * 关系父模型取得
	 * @return
	 */
	public SOC0117TB getFrom0117TB();
	
	/**
	 * 关系子模型取得
	 * @return
	 */
	public SOC0117TB getTo0117TB();

}