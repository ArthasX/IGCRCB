/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * 值班计划
 */
public class IGDUT03012VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private List<IGDUT03013VO> cellVOList;

	public List<IGDUT03013VO> getCellVOList() {
		return cellVOList;
	}

	public void setCellVOList(List<IGDUT03013VO> cellVOList) {
		this.cellVOList = cellVOList;
	}

}
