/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2202VO;

/**	
 * 概述:变更总体统计导出用DTO
 * 创建记录：yukexin    2014-8-15 下午5:15:36	
 * 修改记录：null
 */	
@SuppressWarnings("serial")
public class IGCRC2201ExcelDTO extends ExcelDTO{
	
	/** 变更总体信息集合 */
	protected List<IGCRC2202VO> igcrc2202voList;

	/**
	 * 变更总体信息集合取得
	 * @return igcrc2202voList  变更总体信息集合
	 */
	public List<IGCRC2202VO> getIgcrc2202voList() {
		return igcrc2202voList;
	}

	/**
	 * 变更总体信息集合设定
	 * @param igcrc2202voList  变更总体信息集合
	 */
	public void setIgcrc2202voList(List<IGCRC2202VO> igcrc2202voList) {
		this.igcrc2202voList = igcrc2202voList;
	}



	

}
