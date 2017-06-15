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
import com.deliverik.infogovernor.crc.dto.IGCRC2401ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2402VO;

/**
 * ����:�����¼�ƽ�����ʱ��BL 
 * 
 */
public class IGCRC24ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC24ExcelBL {

	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC24ExcelBLImpl.class);
	
	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================�����ύͳ�Ƶ�����ʼ=================");
		IGCRC2401ExcelDTO exceldto = (IGCRC2401ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		//��ȡ��������
		List<IGCRC2402VO> igcrc2402voList = exceldto.getIgcrc2402voList();
		
		for(int i=0;i<igcrc2402voList.size();i++){
			//��ȡ���̶���
			IGCRC2402VO info = igcrc2402voList.get(i);
			//����
			addCell(0, i, info.getName());
			//�¼�����1
			addCell(1, i, info.getGrade5Str());
			//�¼�����2
			addCell(2, i, info.getGrade4Str());
			//�¼�����3
			addCell(3, i, info.getGrade3Str());
			//�¼�����4
			addCell(4, i, info.getGrade2Str());
			//�¼�����5
			addCell(5, i, info.getGrade1Str());
			//�¼�����
			addCell(6, i, info.getPridNUM());
//			//�¼�����6
//			addCell(6, i, info.getGrade6());
//			//�¼�����7
//			addCell(7, i, info.getGrade7());
//			//�¼�����8
//			addCell(8, i, info.getGrade8());
		}
		
		log.debug("=================�����ύͳ�Ƶ�����ʼ=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
