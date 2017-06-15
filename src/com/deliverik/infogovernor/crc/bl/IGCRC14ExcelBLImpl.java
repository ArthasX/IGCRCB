/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.crc.dto.IGCRC1306ExcelDTO;
import com.deliverik.infogovernor.crc.model.entity.DepartModelVW;

/**
 * ����:���������ύͳ��BL 
 * ������¼����� 2014/07/25
 */
public class IGCRC14ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC14ExcelBL {

	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC14ExcelBLImpl.class);
	
	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================�����ύͳ�Ƶ�����ʼ=================");
		IGCRC1306ExcelDTO exceldto = (IGCRC1306ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		List<DepartModelVW> list = exceldto.getListVM();
		for(int i=0;i<list.size();i++){
			DepartModelVW info = list.get(i);
			addCell(0, i, info.getEiname());
			addCell(1, i, info.getDowSum());
			addCell(2, i, info.getReadSum());
		}
		log.debug("=================�����ύͳ�Ƶ�����ʼ=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
