package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.support.WebApplicationObjectSupport;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.crc.dto.IGCRC01ExcelDTO;

public class IGCRC01ExcelBLImpl extends ExcelBaseBLImpl implements IGCRC01ExcelBL {
	/** ��־���� */
	private static final Log log = LogFactory
			.getLog(IGCRC01ExcelBLImpl.class);

//	public ExcelDTO initExcel(ExcelDTO dto) throws BLException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub

		log.debug("=================������ѯ�����������ʼ=================");
		// ʵ����DTO
		IGCRC01ExcelDTO exceldto = (IGCRC01ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		// ��ò�ѯ����list����
		List<IG500Info> itemList = exceldto.getPrList();
		// ����������Ϣ
		List<IG500Info> processList = exceldto.getProcessList();
		// ���б���Ϣ
		List<IG599Info> processInfoList = exceldto.getProcessInfoList();
		// ���в�������Ϣ
		List<IG337Info> processParticipantList = exceldto.getProcessParticipantList();
		// ����״̬��Ϣ
		List<IG333Info> processStatusDefList = exceldto.getProcessStatusDefList();

		/* 
		 * �����ݼ�
		 * ���map: Key(prid:���̱��) Value(Map:��Ӧ���̱�����)
		 * �ڲ�Map: String(pivarname:������) value(��Ӧ������)
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

		// ���еı�
		for (IG599Info info599 : processInfoList) {
			// �ж��Ƿ��и����̶�Ӧ����Ϣ,����������Ը����̱����ΪKey������һ��mapʵ�������ڴ洢���ж�Ӧ��
			if (piMap.get(info599.getPrid()) == null) {
				piMap.put(info599.getPrid(), new HashMap<String, IG599Info>());
			}
			// �������̶�Ӧ�����б���Ϣ
			piMap.get(info599.getPrid()).put(info599.getPivarname(), info599);
		}

		// ���е�״̬
		for (IG333Info psd : processStatusDefList) {
			//������״̬��ʾ��ΪKey�������������״̬��Ϣ
			psdMap.put(psd.getPsdcode(), psd);
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
		// д�������Ԫ��
		if (itemList != null && itemList.size() > 0) {

			for (int i = 0; i < itemList.size(); i++) {
				
				
				WorkFlowDefinitionBL ctlBL = (WorkFlowDefinitionBL) WebApplicationSupport.getBean("workFlowDefinitionBL");
				//ʵ����״̬�����ѯ����
				IG333SearchCondImpl cond = new IG333SearchCondImpl();
				cond.setPdid(itemList.get(0).getPrpdid());
				//��ѯ״̬����
				List<IG333Info> psdList = ctlBL.searchProcessStatusDef(cond);
				//��������
				Map<String, String> psdMap1 = new HashMap<String, String>();
				for(IG333Info info:psdList){
					psdMap1.put(info.getPsdcode(), info.getPsdname());
				}
				//״̬����
			
				
				// ��ȡ���̶���
				IG500Info info = itemList.get(i);
				String psdname = null;
				if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
					psdname = "��ֹ";
				}else{
					psdname = psdMap1.get(info.getPrstatus());
				}
				
				// �����
				addCell(0, i, info.getPrserialnum());
				// �������
				addCell(1, i, info.getPrtitle());
				// ��乤�����
				String strs = piMap.get(info.getPrid()).get("�������")
 						.getPivarvalue();
				addCell(2, i, strs);
				// ����������
				String prdesc = info.getPrdesc();
				if(StringUtils.isNotEmpty(prdesc)){
					prdesc = prdesc.replace("&nbsp;", " ");
					prdesc = prdesc.replace("<br>", "");
				}
				addCell(3, i, prdesc);
				// ��䷢����
				addCell(4, i, info.getPrusername());
				// ��䷢��ʱ��
				addCell(5, i, info.getPropentime());
				// ���ر�ʱ��
				addCell(6, i, info.getPrclosetime());
				// ��ǰ��ǰ������
				StringBuffer str = new StringBuffer();
				// ��ȡ��Ӧ���̴�����
				List<IG337Info> list = ppMap.get(info.getPrid()).get(
						psdMap.get(info.getPrstatus()).getPsdid());
				// ƴ�����̵�ǰ������
				if (list != null) {
					for (int j = 0; j < list.size(); j++) {
						if (j > 0) {
							str.append(",");
						}
						str.append(list.get(j).getPpusername());
					}
				}
				addCell(7, i, str.toString());
				// ���״̬
				addCell(8, i, psdname);
			}
		}
		log.debug("=================������ѯ��������������=================");
		return dto;
		
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub

	
	
	return null;

}
}
