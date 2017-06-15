/*	
 * ��������������������޹�˾��Ȩ���У���������Ȩ����	
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.infogovernor.crc.dto.IGCRC04ExcelDTO;
import com.deliverik.infogovernor.crc.model.vo.IGCRC14012VO;

/**
 * ����:���������BL 
 * ������¼�������� 2014/07/07
 */
public class IGCRC04ExcelBLImpl extends ExcelBaseBLImpl implements
		IGCRC04ExcelBL {
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC04ExcelBLImpl.class);

	/**
	 * ��ȡ������Ӧ��Ϣ��дExcel�ļ����������
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================��ȡ�����������ʼ=================");
		IGCRC04ExcelDTO exceldto = (IGCRC04ExcelDTO) excelDTO;
		// ���в�������Ϣ
		List<IG337Info> processParticipantList = exceldto.getProcessParticipantList();
		/* 
		 * ���������ݼ�
		 * ���Map��Key(prid:���̱��) Value(Map:��Ӧ״̬�Ĳ����˼���)
		 * �ڲ�Map��Key(psdid:������״̬) Value(List:���ж�Ӧ״̬�Ĳ�����)
		 */
		Map<Integer, Map<String, List<IG337Info>>> ppMap = new HashMap<Integer, Map<String, List<IG337Info>>>();
		
		// ���в�����
		for (IG337Info pp : processParticipantList) {
			// �жϸ������Ƿ���ڣ�����������Ը����̱����ΪKey������һ��map����ʵ����������װ��Ӧ���в�����
			if (ppMap.get(pp.getPrid()) == null) {
				ppMap.put(pp.getPrid(), new HashMap<String, List<IG337Info>>());
			}
			// �жϲ�����״̬�Ƿ���ڣ�����������Բ�����״̬��ΪKey������һ��List����ʵ����������װ��Ӧ���̶�Ӧ״̬�Ĳ�����
			if (ppMap.get(pp.getPrid()).get(pp.getPpstatus()) == null) {
				ppMap.get(pp.getPrid()).put(pp.getPpstatus(), new ArrayList<IG337Info>());
			}
			// ��������
			ppMap.get(pp.getPrid()).get(pp.getPpstatus()).add(pp);
		}
		// ������ʼ����
		exceldto.setStartRow(2);
		List<IGCRC14012VO> listVO = exceldto.getVoLists();
		if(listVO!=null && listVO.size()>0){
			for(int i=0;i<listVO.size();i++){
				StringBuffer str = new StringBuffer();
				IGCRC14012VO info = listVO.get(i);
				addCell(0, i, info.getPrserialnum());
				addCell(1, i, info.getPrtitle());
				addCell(2, i, info.getPrdesc());
				addCell(3, i, info.getChangetype());
				addCell(4, i, info.getChangeclassify());
				addCell(5, i, info.getUpdateplatform());
				addCell(6, i, info.getPrusername());
				
				// ��ȡ��Ӧ���̴�����
				if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
					str.append("");
				}else{					
					List<IG337Info> list = ppMap.get(info.getPrid()).get(info.getPrstatus());
					// ƴ�����̴�����
					if (list != null) {
						for (int j = 0; j < list.size(); j++) {
							if (j > 0) {
								str.append(",");
							}
							str.append(list.get(j).getPpusername());
						}
					}
				}
				addCell(7, i, str.toString());
				addCell(8, i, info.getOrderstatus());
				addCell(9, i, info.getPropentime());
				addCell(10, i, info.getPrclosetime());
			}
		}
		log.debug("=================��ȡ�������������=================");
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
