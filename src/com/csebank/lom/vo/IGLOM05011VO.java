/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Eatery;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 食堂成本管理VO
 *
 */
public class IGLOM05011VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 食堂成本管理检索结果
	 */
	protected List<Eatery> eateryList;

	/**
	 * 食堂成本管理检索结果取得
	 * @return 食堂成本管理检索结果
	 */
	public List<Eatery> getEateryList() {
		return eateryList;
	}

	/**
	 * 食堂成本管理检索结果
	 * @param eateryList 食堂成本管理检索结果
	 */
	public void setEateryList(List<Eatery> eateryList) {
		this.eateryList = eateryList;
	}

}
