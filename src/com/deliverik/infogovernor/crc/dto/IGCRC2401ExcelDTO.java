/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2402VO;

/**
 * ����:�����¼�ƽ�����ʱ��DTO 
 */
public class IGCRC2401ExcelDTO extends ExcelDTO {

	private static final long serialVersionUID = 1L;
	/** �������� */
	protected List<IGCRC2402VO> igcrc2402voList;
	/**
	 * ��������ȡ��
	 * @return igcrc2402voList  ��������
	 */
	public List<IGCRC2402VO> getIgcrc2402voList() {
		return igcrc2402voList;
	}
	/**
	 * ���������趨
	 * @param igcrc2402voList  ��������
	 */
	public void setIgcrc2402voList(List<IGCRC2402VO> igcrc2402voList) {
		this.igcrc2402voList = igcrc2402voList;
	}


}
