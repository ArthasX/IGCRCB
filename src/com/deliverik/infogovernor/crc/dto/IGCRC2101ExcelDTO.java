/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2102VO;

/**	
 * 概述:人员工作统计导出用DTO
 * 创建记录：yukexin    2014-8-15 下午5:15:02	
 * 修改记录：null
 */	
@SuppressWarnings("serial")
public class IGCRC2101ExcelDTO extends ExcelDTO{
	
	/** 人员工作统计检索结果 带合计*/
	protected List<IGCRC2102VO> igcrc2102voList;

	/** 人员工作统计分项合计结果 */
	protected List<Integer> listSum;

	public List<IGCRC2102VO> getIgcrc2102voList() {
		return igcrc2102voList;
	}

	public void setIgcrc2102voList(List<IGCRC2102VO> igcrc2102voList) {
		this.igcrc2102voList = igcrc2102voList;
	}

	public List<Integer> getListSum() {
		return listSum;
	}

	public void setListSum(List<Integer> listSum) {
		this.listSum = listSum;
	}
	

	

}
