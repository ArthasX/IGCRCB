/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.mtp.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * 工作计划
 */
public class IGMTP01042VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private List<IGMTP01043VO> cellVOList;

	public List<IGMTP01043VO> getCellVOList() {
		return cellVOList;
	}

	public void setCellVOList(List<IGMTP01043VO> cellVOList) {
		this.cellVOList = cellVOList;
	}

}
