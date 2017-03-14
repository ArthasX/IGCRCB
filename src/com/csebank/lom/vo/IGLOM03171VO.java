/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.AdvanceDetail;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 预支明细统计VO
 *
 */
public class IGLOM03171VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/** 预支明细统计查询结果列表 */
	protected List<AdvanceDetail> advanceDetailList;

	/**
	 * 预支明细统计查询结果列表取得
	 * @return 预支明细统计查询结果列表
	 */
	public List<AdvanceDetail> getAdvanceDetailList() {
		return advanceDetailList;
	}

	/**
	 * 预支明细统计查询结果列表设定
	 * @param advanceDetailList 预支明细统计查询结果列表
	 */
	public void setAdvanceDetailList(
			List<AdvanceDetail> advanceDetailList) {
		this.advanceDetailList = advanceDetailList;
	}

}
