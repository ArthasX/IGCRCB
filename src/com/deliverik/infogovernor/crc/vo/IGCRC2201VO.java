/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;


/**	
 * 概述: 变更统计查询VO
 * 创建记录：yukexin    2014-8-8 上午9:08:40	
 * 修改记录：null
 */	
public class IGCRC2201VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 变更统计查询List */
	private List<IGCRC2202VO> igcrc2202voList;
	/**
	 * 变更统计查询List取得
	 * @return igcrc2202voList  变更统计查询List
	 */
	public List<IGCRC2202VO> getIgcrc2202voList() {
		return igcrc2202voList;
	}
	/**
	 * 变更统计查询List设定
	 * @param igcrc2202voList  变更统计查询List
	 */
	public void setIgcrc2202voList(List<IGCRC2202VO> igcrc2202voList) {
		this.igcrc2202voList = igcrc2202voList;
	}

}
