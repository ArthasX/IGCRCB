/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2002VO;

/**
 * ����:���ͳ��ͳ��DTO 
 */
public class IGCRC2001ExcelDTO extends ExcelDTO {

	/** ������ȹ���ͳ�����ݺ��кϼƵļ���*/ 
	protected List<IGCRC2002VO> igcrc2002voList;
	/** �кϼ�List */
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
