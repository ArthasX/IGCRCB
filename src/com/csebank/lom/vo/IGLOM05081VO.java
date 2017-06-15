/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.EentertainmentStatistics;
import com.csebank.lom.model.GoutDetailInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 接待统计VO
 *
 */
public class IGLOM05081VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 接待统计结果
	 */
	protected List<EentertainmentStatistics> eentertainmentStatistics;
	//食堂物品消耗明细结果集合
	protected List<GoutDetailInfo> goutDetailInfoList;

	/**
	 * 接待统计结果取得
	 * @return 接待统计结果
	 */
	public List<EentertainmentStatistics> getEentertainmentStatisticsList() {
		return eentertainmentStatistics;
	}

	/**
	 * 接待统计结果
	 * @param eentertainmentStatistics 接待统计结果
	 */
	public void setEentertainmentStatisticsList(List<EentertainmentStatistics> eentertainmentStatistics) {
		this.eentertainmentStatistics = eentertainmentStatistics;
	}

	public List<GoutDetailInfo> getGoutDetailInfoList() {
		return goutDetailInfoList;
	}

	public void setGoutDetailInfoList(List<GoutDetailInfo> goutDetailInfoList) {
		this.goutDetailInfoList = goutDetailInfoList;
	}

}
