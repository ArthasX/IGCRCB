/*	
 * ���������������������޹�˾��Ȩ���У���������Ȩ����	
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.crc.dto.IGCRC03ExcelDTO;

/**
 * ����:���������������BL 
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
		log.debug("=================�������������ʼ=================");
		IGCRC03ExcelDTO exceldto = (IGCRC03ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		// ������������ȡ��

		// ����������Ϣ
		List<IG500Info> processList = exceldto.getProcessList();
		// ���б�����Ϣ
		List<IG599Info> processInfoList = exceldto.getProcessInfoList();
		// ���в�������Ϣ
		List<IG337Info> processParticipantList = exceldto.getProcessParticipantList();
		// ����״̬��Ϣ
		List<IG333Info> processStatusDefList = exceldto.getProcessStatusDefList();

		/* 
		 * �������ݼ�
		 * ���map: Key(prid:���̱��) Value(Map:��Ӧ���̱�������)
		 * �ڲ�Map: String(pivarname:��������) value(��Ӧ��������)
		 */
		Map<Integer, Map<String, IG599Info>> piMap = new HashMap<Integer, Map<String, IG599Info>>();
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

		// ���еı���
		for (IG599Info info599 : processInfoList) {
			// �ж��Ƿ��и����̶�Ӧ������Ϣ,����������Ը����̱����ΪKey������һ��mapʵ�������ڴ洢���ж�Ӧ����
			if (piMap.get(info599.getPrid()) == null) {
				piMap.put(info599.getPrid(), new HashMap<String, IG599Info>());
			}
			// �������̶�Ӧ�����б�����Ϣ
			piMap.get(info599.getPrid()).put(info599.getPivarname(), info599);
		}

		// ���е�״̬
		for (IG333Info psd : processStatusDefList) {
			//������״̬��ʾ��ΪKey�������������״̬��Ϣ
			psdMap.put(psd.getPsdcode() + "-" + psd.getPdid(), psd);
		}

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

		// д�������Ԫ��
		if (processList != null && processList.size() > 0) {
			
			for (int i = 0; i < processList.size(); i++) {
				// ��ȡ���̶���
				IG500Info info = processList.get(i);
				
				
				// ��乤����
				addCell(0, i, info.getPrserialnum());
				// �����������
				addCell(1, i, info.getPrtitle());
				// ����������
//				String prdesc = info.getPrdesc();
				String prdesc = piMap.get(info.getPrid()).get("��������").getPivarvalue();
				
				if(StringUtils.isNotEmpty(prdesc)){
					prdesc = prdesc.replaceAll("&nbsp;", " ");
					prdesc = prdesc.replaceAll("<br>", "");
				}
				addCell(2, i, prdesc);
				StringBuffer str = new StringBuffer();
				// ��ȡ��Ӧ���̴�����
				if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
					str.append("");
				}else{					
					List<IG337Info> list = ppMap.get(info.getPrid()).get(
							psdMap.get(info.getPrstatus() + "-" + info.getPrpdid()).getPsdid());
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
				//���������
				IG599Info info599 = piMap.get(info.getPrid()).get("�����̶�");
				addCell(3, i, info599.getPivarvalue());
				//���Ӱ��̶�
				addCell(4, i, piMap.get(info.getPrid()).get("Ӱ��̶�").getPivarvalue());
				//����������
				String[] strques = piMap.get(info.getPrid()).get("�������").getPivarvalue().split("_");
				addCell(5, i, strques[strques.length-1]);
				// ��乤��״̬
				if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
					addCell(6, i, "��ֹ");
				}else{
					addCell(6, i, psdMap.get(info.getPrstatus() + "-" + info.getPrpdid()).getPsdname());
				}
				// ��䴦����
				addCell(7, i, str.toString());
				// ��䷢��ʱ��
				addCell(8, i, info.getPropentime());
				// ���ر�ʱ��
				addCell(9, i, info.getPrclosetime());
			}
		}
		log.debug("=================��ȡ���������������=================");
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}