/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.ItemsCodesSt;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 餐卡信息VO
 *
 */
public class IGLOM05181VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 餐卡信息结果
	 */
	protected List<ItemsCodesSt> lunchCardList;

	/**
	 * 餐卡信息结果取得
	 * @return 餐卡信息结果
	 */
	public List<ItemsCodesSt> getLunchCardList() {
		return lunchCardList;
	}

	/**
	 * 餐卡信息结果
	 * @param itemsCodes 餐卡信息结果
	 */
	public void setLunchCardList(List<ItemsCodesSt> lunchCardList) {
		this.lunchCardList = lunchCardList;
	}
	
}
