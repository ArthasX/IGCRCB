/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Recption;
import com.csebank.lom.model.RecptionGuest;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 接待客人管理VO
 *
 */
public class IGLOM01041VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/** 接待客人搜索结果集 */
	protected List<RecptionGuest> recptionGuestList;
	
	/** 接待工作信息 */
	protected Recption recptionData;

	/**
	 * 接待客人搜索结果集取得
	 * @return 接待客人搜索结果集
	 */
	public List<RecptionGuest> getRecptionGuestList() {
		return recptionGuestList;
	}

	/**
	 * 接待客人搜索结果集设定
	 * @param recptionGuestList 接待客人搜索结果集
	 */
	public void setRecptionGuestList(List<RecptionGuest> recptionGuestList) {
		this.recptionGuestList = recptionGuestList;
	}

	/**
	 * 接待工作信息取得
	 * @return 接待工作信息
	 */
	public Recption getRecptionData() {
		return recptionData;
	}

	/**
	 * 接待工作信息设定
	 * @param recptionData 接待工作信息
	 */
	public void setRecptionData(Recption recptionData) {
		this.recptionData = recptionData;
	}

}
