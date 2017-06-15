/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2002VO;

/**
 * 概述:年度统计统计DTO 
 */
public class IGCRC2001ExcelDTO extends ExcelDTO {

	/** 导出年度工作统计内容和行合计的集合*/ 
	protected List<IGCRC2002VO> igcrc2002voList;
	/** 列合计List */
	protected List<Integer> SumList;
	
	public List<IGCRC2002VO> getIgcrc2002voList() {
		return igcrc2002voList;
	}
	public void setIgcrc2002voList(List<IGCRC2002VO> igcrc2002voList) {
		this.igcrc2002voList = igcrc2002voList;
	}
	public List<Integer> getSumList() {
		return SumList;
	}
	public void setSumList(List<Integer> sumList) {
		SumList = sumList;
	}


	
}
