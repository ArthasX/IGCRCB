/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2202VO;

/**	
 * ����:�������ͳ�Ƶ�����DTO
 * ������¼��yukexin    2014-8-15 ����5:15:36	
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
public class IGCRC2201ExcelDTO extends ExcelDTO{
	
	/** ���������Ϣ���� */
	protected List<IGCRC2202VO> igcrc2202voList;

	/**
	 * ���������Ϣ����ȡ��
	 * @return igcrc2202voList  ���������Ϣ����
	 */
	public List<IGCRC2202VO> getIgcrc2202voList() {
		return igcrc2202voList;
	}

	/**
	 * ���������Ϣ�����趨
	 * @param igcrc2202voList  ���������Ϣ����
	 */
	public void setIgcrc2202voList(List<IGCRC2202VO> igcrc2202voList) {
		this.igcrc2202voList = igcrc2202voList;
	}



	

}
