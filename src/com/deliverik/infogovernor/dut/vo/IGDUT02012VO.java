/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * ֵ��ƻ�
 */
public class IGDUT02012VO extends BaseVO {

	private static final long serialVersionUID = 1L;

	private List<IGDUT02013VO> cellVOList;

	public List<IGDUT02013VO> getCellVOList() {
		return cellVOList;
	}

	public void setCellVOList(List<IGDUT02013VO> cellVOList) {
		this.cellVOList = cellVOList;
	}

}
