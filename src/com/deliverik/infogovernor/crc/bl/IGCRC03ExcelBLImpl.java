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
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.infogovernor.crc.dto.IGCRC03ExcelDTO;
import com.deliverik.infogovernor.crc.model.IGCRC0301VWInfo;

/**
 * ����:������������BL 
 * ������¼��ʷ����
 */
public class IGCRC03ExcelBLImpl extends ExcelBaseBLImpl implements
		IGCRC03ExcelBL {
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC03ExcelBLImpl.class);

	/**
	 * ��ȡ������Ӧ��Ϣ��дExcel�ļ����������
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================�����������ʼ=================");
		IGCRC03ExcelDTO exceldto = (IGCRC03ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		
		// ���в�������Ϣ
		List<IG337Info> processParticipantList = exceldto.getProcessParticipantList();

		/* 
		 * ���������ݼ�
		 * ���Map��Key(prid:���̱��) Value(Map:��Ӧ״̬�Ĳ����˼���)
		 * �ڲ�Map��Key(psdid:������״̬) Value(List:���ж�Ӧ״̬�Ĳ�����)
		 */
		Map<Integer, Map<String, List<IG337Info>>> ppMap = new HashMap<Integer, Map<String, List<IG337Info>>>();
		/* 
		 * ״̬���ݼ�
		 * Key��(psdcode������״̬��ʾ)
		 * Value��(��Ӧ״̬����)
		 */
		Map<String, IG333Info> psdMap = new HashMap<String, IG333Info>();

	

		// ���в�����
		for (IG337Info pp : processParticipantList) {
			// �жϸ������Ƿ���ڣ�����������Ը����̱����ΪKey������һ��map����ʵ����������װ��Ӧ���в�����
			if (ppMap.get(pp.getPrid()) == null) {
				ppMap.put(pp.getPrid(), new HashMap<String, List<IG337Info>>());
			}
			// �жϲ�����״̬�Ƿ���ڣ�����������Բ�����״̬��ΪKey������һ��List����ʵ����������װ��Ӧ���̶�Ӧ״̬�Ĳ�����
			if (ppMap.get(pp.getPrid()).get(pp.getPsdid()) == null) {
				ppMap.get(pp.getPrid()).put(pp.getPsdid(),
						new ArrayList<IG337Info>());
			}
			// ��������
			ppMap.get(pp.getPrid()).get(pp.getPsdid()).add(pp);
		}
		
		List<IGCRC0301VWInfo> infolist = exceldto.getIgcrc0301List(); 
		
		// д�������Ԫ��
		if (infolist != null && infolist.size() > 0) {
			
			for (int i = 0; i < infolist.size(); i++) {
				// ��ȡ���̶���
				IGCRC0301VWInfo info = infolist.get(i);
				
				
				// ��乤����
				addCell(0, i, info.getPrserialnum());
				// �����������
				addCell(1, i, info.getPrtitle());
				// ��乤��״̬
				if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
					addCell(2, i, "��ֹ");
				}else{
					addCell(2, i,  info.getOrderstatus());
				}
				
				StringBuffer str = new StringBuffer();
				// ��ȡ��Ӧ���̴�����
				if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
					str.append("");
				}else{					
					List<IG337Info> list = ppMap.get(info.getPrid()).get(info.getPsdid());
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
				// ��䴦����
				addCell(3, i, str.toString());
				// ��䷢��ʱ��
				addCell(4, i, info.getPropentime());
				// ���ر�ʱ��
				addCell(5, i, info.getPrclosetime());
				
				
				//�������Ż�����
				if(info.getAfterplan()!=null){
					addCell(6, i, info.getAfterplan());
				}else{
					addCell(6, i, "");
				}
				if(info.getPlanstime()!=null){
					//���ƻ����ʱ��
					addCell(7, i, info.getPlanstime());
				}else{
					addCell(7, i, "");
				}
				if(info.getDutypersion()!=null){
					//���������
					addCell(8, i,info.getDutypersion());
				}else{
					addCell(8, i, "");
				}
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
