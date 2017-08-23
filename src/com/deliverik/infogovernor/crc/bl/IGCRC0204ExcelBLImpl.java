/*	
 * ��������������������޹�˾��Ȩ���У���������Ȩ����	
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.crc.dto.IGCRC02ExcelDTO;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;

/**
 * ����:�¼����������BL 
 * ������¼��ʷ���� 2014/07/20
 */
public class IGCRC0204ExcelBLImpl extends ExcelBaseBLImpl implements
		IGCRC0204ExcelBL {
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC0204ExcelBLImpl.class);

	/**
	 * ��ȡ������Ӧ��Ϣ��дExcel�ļ����������
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================�¼���������ʼ=================");
		IGCRC02ExcelDTO exceldto = (IGCRC02ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		// ������������ȡ��

		// ����������Ϣ
		List<IGCRC0208VWInfo> processList = exceldto.getProcessList();
		// ���б���Ϣ
		List<IG599Info> processInfoList = exceldto.getProcessInfoList();

		/* 
		 * �����ݼ�
		 * ���map: Key(prid:���̱��) Value(Map:��Ӧ���̱�����)
		 * �ڲ�Map: String(pivarname:������) value(��Ӧ������)
		 */
		Map<Integer, Map<String, IG599Info>> piMap = new HashMap<Integer, Map<String, IG599Info>>();


		// ���еı�
		for (IG599Info info599 : processInfoList) {
			// �ж��Ƿ��и����̶�Ӧ����Ϣ,����������Ը����̱����ΪKey������һ��mapʵ�������ڴ洢���ж�Ӧ��
			if (piMap.get(info599.getPrid()) == null) {
				piMap.put(info599.getPrid(), new HashMap<String, IG599Info>());
			}
			// �������̶�Ӧ�����б���Ϣ
			piMap.get(info599.getPrid()).put(info599.getPivarname(), info599);
		}

	/*	// ���е�״̬
		for (IG333Info psd : processStatusDefList) {
			//������״̬��ʾ��ΪKey�������������״̬��Ϣ
			psdMap.put(psd.getPsdcode() + "-" + psd.getPdid(), psd);
		}*/

		// ���в�����
		/*for (IG337Info pp : processParticipantList) {
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
		}*/

		// д�������Ԫ��
		if (processList != null && processList.size() > 0) {
			for (int i = 0; i < processList.size(); i++) {
				// ��ȡ���̶���
				IGCRC0208VWInfo info = processList.get(i);
				
				// ��乤����
				addCell(0, i, info.getPrserialnum());
				// ����ʱ��
				addCell(1, i, info.getHappenTime());
				
				//�Ƿ��ѹر�
				if(StringUtils.isNotEmpty(info.getPrclosetime())){
					addCell(2, i, "��");
				}else{
					addCell(2, i, "��");
				}
				// ����¼���Դ
				addCell(3, i, piMap.get(info.getPrid()).get("�¼���Դ").getPivarvalue());
				
				// ����¼�����
				addCell(4, i, info.getPrtitle());
				// ����Ƿ���Ҫ����
				String[] strs = piMap.get(info.getPrid()).get("�¼�����").getPivarvalue().split("_");
				String[] strs2 = strs[strs.length-1].split("-");
				addCell(5, i, strs2[strs2.length-1]);
				if(piMap.get(info.getPrid()).get("�漰ϵͳ")!=null){
					// �漰Ӧ��ϵͳ
					addCell(6, i, piMap.get(info.getPrid()).get("�漰ϵͳ").getPivarvalue());
				}else{
					addCell(6, i, "");
				}
				
				if(piMap.get(info.getPrid()).get("Ӱ�췶Χ")!=null){
					// Ӱ�췶Χ
					addCell(7, i, piMap.get(info.getPrid()).get("Ӱ�췶Χ").getPivarvalue());
				}else{
					addCell(7, i, "");
				}
				
				if(piMap.get(info.getPrid()).get("Ӱ�췶Χ��ע")!=null){
					// Ӱ�췶Χ��ע
					addCell(8, i, piMap.get(info.getPrid()).get("Ӱ�췶Χ��ע").getPivarvalue());
				}else{
					addCell(8, i, "");
				}
				
				if(piMap.get(info.getPrid()).get("�¼��ȼ�")!=null){
					// �¼��ȼ�
					addCell(9, i, piMap.get(info.getPrid()).get("�¼��ȼ�").getPivarvalue());
				}else{
					addCell(9, i, "");
				}
				
				if(piMap.get(info.getPrid()).get("�¼�ԭ��")!=null){
					// �¼�ԭ��
					addCell(10, i, piMap.get(info.getPrid()).get("�¼�ԭ��").getPivarvalue());
				}else{
					addCell(10, i, "");
				}
				
				if(piMap.get(info.getPrid()).get("Ӧ���������")!=null){
					// Ӧ���������
					addCell(11, i, piMap.get(info.getPrid()).get("Ӧ���������").getPivarvalue());
				}else{
					addCell(11, i, "");
				}
				
			}
		}
		log.debug("=================�¼���������������=================");
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
