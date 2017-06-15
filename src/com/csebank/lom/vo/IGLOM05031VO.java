/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.EworkingLunch;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 食堂工作餐管理VO
 *
 */
public class IGLOM05031VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 食堂工作餐管理检索结果
	 */
	protected List<EworkingLunch> eworkingLunchList;

	/**
	 * 食堂工作餐管理检索结果取得
	 * @return 食堂工作餐管理检索结果
	 */
	public List<EworkingLunch> getEworkingLunchList() {
		return eworkingLunchList;
	}

	/**
	 * 食堂工作餐管理检索结果
	 * @param eateryList 食堂工作餐管理检索结果
	 */
	public void setEworkingLunchList(List<EworkingLunch> eworkingLunchList) {
		this.eworkingLunchList = eworkingLunchList;
	}

}
