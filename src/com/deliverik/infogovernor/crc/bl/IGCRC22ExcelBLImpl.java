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
import com.deliverik.infogovernor.crc.dto.IGCRC2201ExcelDTO;
import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;
import com.deliverik.infogovernor.crc.vo.IGCRC2202VO;

/**	
 * ����:���򿪷�ͳ�Ƶ���ҵ���߼�ʵ��
 * ������¼��yukexin    2014-8-15 ����5:11:46	
 * �޸ļ�¼��null
 */	
public class IGCRC22ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC22ExcelBL {

	/** ��־���� */
	private static final Log log = LogFactory
			.getLog(IGCRC22ExcelBLImpl.class);

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================�������ͳ�Ʋ�ѯ�����������ʼ=================");
		// ʵ����DTO
		IGCRC2201ExcelDTO exceldto = (IGCRC2201ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		// ��ò�ѯ����list����
		List<IGCRC2202VO> processList = exceldto.getIgcrc2202voList();
		// д�������Ԫ��
		if (processList != null && processList.size() > 0) {
			for (int i = 0; i < processList.size(); i++) {
				// ��ȡ����
				IGCRC2202VO info = processList.get(i);
				// ����ȡ��
				addCell(0, i, info.getTypeName());
				// ����ȡ��
				addCell(1, i, info.getTotalnum());
				// ����ͨ������
				addCell(2, i, info.getPassnum());
				// ����ͨ����
				addCell(3, i, info.getPassrate());
				// �ɹ�����
				addCell(4, i, info.getSuccessnum());
				// �ɹ���
				addCell(5, i, info.getSuccessrate());
			}
		}

		log.debug("=================�������ͳ�Ʋ�ѯ��������������=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}
	
}
