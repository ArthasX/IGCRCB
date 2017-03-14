/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.csebank.lom.model.WorkLunchEatery;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 工作餐成本统计VO
 *
 */
public class IGLOM05051VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 工作餐成本统计结果
	 */
	protected List<WorkLunchEatery> workLunchEateryList;
	
	protected Map<String,IGLOM05051VO> map;

	/**
	 * 工作餐成本统计结果取得
	 * @return 工作餐成本统计结果
	 */
	public List<WorkLunchEatery> getWorkLunchEateryList() {
		return workLunchEateryList;
	}

	/**
	 * 工作餐成本统计结果
	 * @param eentertainmentList 工作餐成本统计结果
	 */
	public void setWorkLunchEateryList(List<WorkLunchEatery> workLunchEateryList) {
		this.workLunchEateryList = workLunchEateryList;
	}

	public Map<String, IGLOM05051VO> getMap() {
		return map;
	}

	public void setMap(Map<String, IGLOM05051VO> map) {
		this.map = map;
	}
	
}
