/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * 概述: 资产关系表检索条件实现
  * 功能描述: 资产关系表检索条件实现
  * 创建记录: 杨龙全 2013/05/27
  * 修改记录: 
  */
public class SOC0152SearchCondImpl implements
		SOC0152SearchCond {
	/**模型码*/
	protected String rlnCode_eq;

	/** 开始模型ID */
	protected String fromModelEid_eq;

	/** 到模型ID */
	protected String toModelEid_eq;
	
	/**多个模型码*/
	protected List<String> rlnCode_in;

	/**关系类别等于*/
	protected String rlnType_eq;

	/**
	 * 模型码取得
	 *
	 * @return rlnCode_eq 模型码
	 */
	
	public String getRlnCode_eq() {
		return rlnCode_eq;
	}

	/**
	 * 模型码设定
	 *
	 * @param rlnCode_eq 模型码
	 */
	
	public void setRlnCode_eq(String rlnCode_eq) {
		this.rlnCode_eq = rlnCode_eq;
	}

	/**
	 * 开始模型ID取得
	 *
	 * @return fromModelEid_eq 开始模型ID
	 */
	
	public String getFromModelEid_eq() {
		return fromModelEid_eq;
	}

	/**
	 * 开始模型ID设定
	 *
	 * @param fromModelEid_eq 开始模型ID
	 */
	
	public void setFromModelEid_eq(String fromModelEid_eq) {
		this.fromModelEid_eq = fromModelEid_eq;
	}

	/**
	 * 到模型ID取得
	 *
	 * @return toModelEid_eq 到模型ID
	 */
	
	public String getToModelEid_eq() {
		return toModelEid_eq;
	}

	/**
	 * 到模型ID设定
	 *
	 * @param toModelEid_eq 到模型ID
	 */
	
	public void setToModelEid_eq(String toModelEid_eq) {
		this.toModelEid_eq = toModelEid_eq;
	}

	/**
	 * 多个模型码取得
	 *
	 * @return rlnCode_in 多个模型码
	 */
	
	public List<String> getRlnCode_in() {
		return rlnCode_in;
	}

	/**
	 * 多个模型码设定
	 *
	 * @param rlnCode_in 多个模型码
	 */
	
	public void setRlnCode_in(List<String> rlnCode_in) {
		this.rlnCode_in = rlnCode_in;
	}

	/**
	 * 关系类别等于取得
	 *
	 * @return rlnType_eq 关系类别等于
	 */
	
	public String getRlnType_eq() {
		return rlnType_eq;
	}

	/**
	 * 关系类别等于设定
	 *
	 * @param rlnType_eq 关系类别等于
	 */
	
	public void setRlnType_eq(String rlnType_eq) {
		this.rlnType_eq = rlnType_eq;
	}


	

}