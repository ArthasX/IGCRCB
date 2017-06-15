/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 场景响应策略检索条件实现
  * 功能描述: 场景响应策略检索条件实现
  * 创建记录: 2016/09/20
  * 修改记录: 
  */
public class ResponseStrategySearchCondImpl implements
		ResponseStrategySearchCond {

	/**
	 * 场景id
	 */
	private Integer senceid;

	private Integer[] senceids;

	public Integer[] getSenceids() {
		return senceids;
	}

	public void setSenceids(Integer[] senceids) {
		this.senceids = senceids;
	}

	/**
	 * 关键字匹配 in
	 * 
	 * @return
	 */
	private String[] keyword_in;

	public Integer getSenceid() {
		return senceid;
	}

	public void setSenceid(Integer senceid) {
		this.senceid = senceid;
	}

	public String[] getKeyword_in() {
		return keyword_in;
	}

	public void setKeyword_in(String[] keyword_in) {
		this.keyword_in = keyword_in;
	}

}