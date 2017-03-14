/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2402VO;

/**
 * 概述:导出事件平均解决时间DTO 
 */
public class IGCRC2401ExcelDTO extends ExcelDTO {

	private static final long serialVersionUID = 1L;
	/** 导出内容 */
	protected List<IGCRC2402VO> igcrc2402voList;
	/**
	 * 导出内容取得
	 * @return igcrc2402voList  导出内容
	 */
	public List<IGCRC2402VO> getIgcrc2402voList() {
		return igcrc2402voList;
	}
	/**
	 * 导出内容设定
	 * @param igcrc2402voList  导出内容
	 */
	public void setIgcrc2402voList(List<IGCRC2402VO> igcrc2402voList) {
		this.igcrc2402voList = igcrc2402voList;
	}


}
