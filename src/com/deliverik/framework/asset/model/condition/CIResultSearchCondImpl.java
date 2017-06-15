/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
  * 概述: 对比结果信息表检索条件实现
  * 功能描述: 对比结果信息表检索条件实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class CIResultSearchCondImpl implements
		CIResultSearchCond {
	
	/** 时间戳 开始 */
	protected String citime_from;
	
	/** 时间戳 结束 */
	protected String citime_to;
	
	/** 任务描述 */
	protected String citdesc;
	
	/** 资产层次码 */
	protected String esyscoding;



	/**
	 * 任务描述取得
	 * @return 任务描述
	 */
	public String getCitdesc() {
		return citdesc;
	}

	/**
	 * 任务描述设定
	 * @param citdesc 任务描述
	 */
	public void setCitdesc(String citdesc) {
		this.citdesc = citdesc;
	}

	/**
	 * 时间戳 开始取得
	 * @return 时间戳 开始
	 */
	public String getCitime_from() {
		return citime_from;
	}

	/**
	 * 时间戳 开始设定
	 * @param citime_from 时间戳 开始
	 */
	public void setCitime_from(String citime_from) {
		this.citime_from = citime_from;
	}

	/**
	 * 时间戳 结束取得
	 * @return 时间戳 结束
	 */
	public String getCitime_to() {
		return citime_to;
	}

	/**
	 * 时间戳 结束设定
	 * @param citime_to 时间戳 结束
	 */
	public void setCitime_to(String citime_to) {
		this.citime_to = citime_to;
	}

	/**
	 * 资产层次码取得
	 * @return 资产层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产层次码设定
	 * @param esyscoding 资产层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	

}