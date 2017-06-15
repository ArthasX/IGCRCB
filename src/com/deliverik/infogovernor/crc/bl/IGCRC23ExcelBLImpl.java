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
import com.deliverik.infogovernor.crc.dto.IGCRC2301ExcelDTO;
import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;

/**	
 * ����:���򿪷�ͳ�Ƶ���ҵ���߼�ʵ��
 * ������¼��yukexin    2014-8-15 ����5:12:20	
 * �޸ļ�¼��null
 */	
public class IGCRC23ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC23ExcelBL {

	/** ��־���� */
	private static final Log log = LogFactory
			.getLog(IGCRC23ExcelBLImpl.class);

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================���򿪷�ͳ�Ʋ�ѯ�����������ʼ=================");
		// ʵ����DTO
		IGCRC2301ExcelDTO exceldto = (IGCRC2301ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		// ��ò�ѯ����list����
		List<IGCRC2301VWInfo> processList = exceldto.getIgcrc2301VWList();
		// д�������Ԫ��
		if (processList != null && processList.size() > 0) {
			for (int i = 0; i < processList.size(); i++) {
				// ��ȡ����
				IGCRC2301VWInfo info = processList.get(i);
				// ��Ա����
				addCell(0, i, info.getUserName());
				// �¼�����
				addCell(1, i, info.getDisposeNum());
				// �������
				addCell(2, i, info.getTestUpdateRejectNum());
				// �������
				addCell(3, i, info.getTestRejectNum());
				// �����������
				addCell(4, i, info.getConfirmRejectNum());
			}
		}

		log.debug("=================���򿪷�ͳ�Ʋ�ѯ��������������=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}
	
}
