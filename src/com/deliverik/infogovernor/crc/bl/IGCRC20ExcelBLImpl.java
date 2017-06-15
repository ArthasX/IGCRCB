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
import com.deliverik.infogovernor.crc.dto.IGCRC2001ExcelDTO;
import com.deliverik.infogovernor.crc.vo.IGCRC2002VO;

/**
 * ����:������ȹ���ͳ��
 * 
 */
/**
 * ����: ��ȹ���ͳ�Ƶ����߼�ʵ��
 * ������¼:  lianghongyang 2014-8-11 09:34:11
 * �޸ļ�¼: 
 */
public class IGCRC20ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC20ExcelBL {

	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC20ExcelBLImpl.class);
	
	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	/**
	 * ��ȡ������Ӧ��Ϣ��дExcel�ļ����������
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================��ȹ���ͳ�Ƶ�����ʼ=================");
		IGCRC2001ExcelDTO exceldto = (IGCRC2001ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		//��ȡ��������
		List<IGCRC2002VO> igcrc2002voList = exceldto.getIgcrc2002voList();
		//���źϼ�List
		List<Integer> sumList=exceldto.getSumList();
		
		for(int i=0;i<igcrc2002voList.size();i++){
			// ��ȡ���̶���
			IGCRC2002VO info = igcrc2002voList.get(i);
			//����·�
			addCell(0, i, info.getPropentime());
			//����¼�
			addCell(1, i, info.getIncidentnum());
			//�������
			addCell(2, i, info.getProblemnum());
			//�����
			addCell(3, i, info.getChangenum());
			//���Ƽ���������
			addCell(4, i, info.getServicenum());
			//���Ƽ�����
			addCell(5, i, info.getSfnum());
			//���ϼ�
			addCell(6, i, info.getSum());
		}
		addCell(0,igcrc2002voList.size(), "�ϼ�");
		//�������źϼ�
		for(int i=0;i<sumList.size();i++){
			// ��ȡ���̶���
			int sum = sumList.get(i);
			addCell(i+1, igcrc2002voList.size(),sum);
		}
		
		log.debug("=================��ȹ���ͳ�Ƶ�����ʼ=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
