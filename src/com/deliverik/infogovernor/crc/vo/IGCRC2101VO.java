/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**	
 * 概述: 人员工作信息查询VO 
 * 创建记录：yukexin    2014-8-7 10:03:28
 * 修改记录：null
 */	
@SuppressWarnings("serial")
public class IGCRC2101VO extends BaseVO{

	/** 人员工作信息集合 */
	protected List<IGCRC2102VO> igcrc2102VOList;

	/** 人员工作统计分项合计结果 */
	protected List<Integer> listSum;
	
	/**
	 * 人员工作信息集合取得
	 * @return prList 人员工作信息集合
	 */
	public List<IGCRC2102VO> getIgcrc2102VOList() {
		return igcrc2102VOList;
	}
	
	/**
	 * 人员工作信息集合设定
	 * @param prList 人员工作信息集合
	 */
	public void setIgcrc2102VOList(List<IGCRC2102VO> igcrc2102voList) {
		igcrc2102VOList = igcrc2102voList;
	}

	/**
	 * 人员工作统计分项合计结果取得
	 * @return listSum  人员工作统计分项合计结果
	 */
	public List<Integer> getListSum() {
		return listSum;
	}

	/**
	 * 人员工作统计分项合计结果设定
	 * @param listSum  人员工作统计分项合计结果
	 */
	public void setListSum(List<Integer> listSum) {
		this.listSum = listSum;
	}

}
