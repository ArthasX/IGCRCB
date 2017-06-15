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
import com.deliverik.infogovernor.crc.dto.IGCRC2101ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2102VO;

/**
 * 
 *
 */
/**	
 * ����:��Ա����ͳ�Ƶ���ҵ���߼�ʵ��
 * ������¼��yukexin    2014-8-15 ����5:10:31	
 * �޸ļ�¼��null
 */	
public class IGCRC21ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC21ExcelBL {

	/** ��־���� */
	private static final Log log = LogFactory
			.getLog(IGCRC21ExcelBLImpl.class);

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================��Ա����ͳ�Ʋ�ѯ�����������ʼ=================");
		// ʵ����DTO
		IGCRC2101ExcelDTO exceldto = (IGCRC2101ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		// ��ò�ѯ����list����
		List<IGCRC2102VO> processList = exceldto.getIgcrc2102voList();
		List<Integer> listSum = exceldto.getListSum();
		// д�������Ԫ��
		if (processList != null && processList.size() > 0) {
			for (int i = 0; i < processList.size(); i++) {
				// ��ȡ����
				IGCRC2102VO info = processList.get(i);
				// ��Ա����
				addCell(0, i, info.getUserName());
				// �¼�����
				addCell(1, i, info.getIncidentNum());
				// �������
				addCell(2, i, info.getProblemNum());
				// �������
				addCell(3, i, info.getChangeNum());
				// �����������
				addCell(4, i, info.getServiceNum());
				// �����������
				addCell(5, i, info.getDevelopNum());
				// �ϼƸ���
				addCell(6, i, info.getTotal());
			}
			// �ϼ�
			addCell(0, processList.size(), "�ϼ�");
			for(int i = 0; i < listSum.size(); i++){
				addCell(i + 1, processList.size(), listSum.get(i));
			}
		}

		log.debug("=================��Ա����ͳ�Ʋ�ѯ��������������=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}
	
}
