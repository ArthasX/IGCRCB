/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;

/**	
 * ����:���򿪷�ͳ�Ƶ�����DTO
 * ������¼��yukexin    2014-8-15 ����5:16:12	
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
public class IGCRC2301ExcelDTO extends ExcelDTO{
	
	/** ���򿪷���Ϣ���� */
	protected List<IGCRC2301VWInfo> igcrc2301VWList;

	public List<IGCRC2301VWInfo> getIgcrc2301VWList() {
		return igcrc2301VWList;
	}

	public void setIgcrc2301VWList(List<IGCRC2301VWInfo> igcrc2301vwList) {
		igcrc2301VWList = igcrc2301vwList;
	}


	

}
