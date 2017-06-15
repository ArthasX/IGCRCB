/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.ven.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**	
 * 概述: 风险监测工作执行查询VO
 * 创建记录：yukexin    2014-12-15 上午10:30:49	
 * 修改记录：null
 */	
@SuppressWarnings("serial")
public class IGVEN02013VO extends BaseVO implements Serializable{
	/** 风险检查结果信息检索结果 */
	protected List<IGVEN02012VO> igven02012voList;

	/**
	 * 风险检查结果信息检索结果取得
	 * @return igven02012voList 风险检查结果信息检索结果
	 */
	public List<IGVEN02012VO> getIgven02012voList() {
		return igven02012voList;
	}

	/**
	 * 风险检查结果信息检索结果设定
	 * @param igven02012voList 风险检查结果信息检索结果
	 */
	public void setIgven02012voList(List<IGVEN02012VO> igven02012voList) {
		this.igven02012voList = igven02012voList;
	}
}
