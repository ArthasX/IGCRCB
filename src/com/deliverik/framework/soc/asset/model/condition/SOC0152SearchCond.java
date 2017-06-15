/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * 概述: 资产关系表检索条件接口
  * 功能描述: 资产关系表检索条件接口
  * 创建记录: 杨龙全 2013/05/27
  * 修改记录: 
  */
public interface SOC0152SearchCond {
	
	/**
	 * 模型码取得
	 *
	 * @return rlnCode_eq 模型码
	 */
	
	public String getRlnCode_eq();


	/**
	 * 开始模型ID取得
	 *
	 * @return fromModelEid_eq 开始模型ID
	 */
	
	public String getFromModelEid_eq();


	/**
	 * 到模型ID取得
	 *
	 * @return toModelEid_eq 到模型ID
	 */
	
	public String getToModelEid_eq();
	
	/**
	 * 多个模型码取得
	 *
	 * @return rlnCode_in 多个模型码
	 */
	
	public List<String> getRlnCode_in();
	
	/**
	 * 关系类别等于取得
	 *
	 * @return rlnType_eq 关系类别等于
	 */
	
	public String getRlnType_eq();
}