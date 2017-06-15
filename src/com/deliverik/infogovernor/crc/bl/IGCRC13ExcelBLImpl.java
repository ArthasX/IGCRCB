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
import com.deliverik.infogovernor.crc.dto.IGCRC1305ExcelDTO;
import com.deliverik.infogovernor.crc.model.entity.ModelVW;

/**
 * ����:�����ĵ�����ͳ��BL 
 * ������¼����� 2014/07/25
 */
public class IGCRC13ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC13ExcelBL {
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC13ExcelBLImpl.class);
	
	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	/**
	 * ��дEXCEL�ļ�����
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================�ĵ�����ͳ�Ƶ�����ʼ=================");
		IGCRC1305ExcelDTO exceldto = (IGCRC1305ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		List<ModelVW> list = exceldto.getListVM();
		for(int i=0;i<list.size();i++){
			ModelVW info = list.get(i);
			addCell(0, i, info.getType());
			addCell(1, i, info.getWordSum());
		}
		log.debug("=================�ĵ�����ͳ�Ƶ�����ʼ=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
