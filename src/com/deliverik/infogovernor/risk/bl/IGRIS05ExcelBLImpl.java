/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.bl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.risk.dto.IGRIS05ExcelDTO;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;

/**
 * @Description:
 * @Author zhangqiang
 * @History @2014-7-11�½�
 * 
 * @Version V1.0
 */
public class IGRIS05ExcelBLImpl extends ExcelBaseBLImpl implements
		IGRIS05ExcelBL {

	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGRIS05ExcelBLImpl.class);

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================��ȡ������ⱨ������ʼ=================");
		IGRIS05ExcelDTO exceldto = (IGRIS05ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		// ��ȡ��������
		Map<String, Map<String, List<CheckWorkConutVWInfo>>> map = exceldto.getMap();
		
		int i = 0;  //�к�
		int j = 0;
		int index = 0; //����
		//����map
		for(Iterator<Entry<String, Map<String, List<CheckWorkConutVWInfo>>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, List<CheckWorkConutVWInfo>>> entry = iter.next();
			String key = entry.getKey();
			
			Map<String, List<CheckWorkConutVWInfo>> mapName = entry.getValue();
			int mergeStartClass = j;
			//ѭ������
			for(Iterator<Entry<String, List<CheckWorkConutVWInfo>>> iterName = mapName.entrySet().iterator();iterName.hasNext();){
				Entry<String, List<CheckWorkConutVWInfo>> entryName = iterName.next();
				index ++;
				//ȡ�ü�����⼯��
				List<CheckWorkConutVWInfo> list = entryName.getValue();
				//��ʼλ��
				int mergeStart = i;
				for(CheckWorkConutVWInfo info:list){
					// ������
					addCell(0, i, index);
					String type = "";
					// ����������
					Integer temp = Integer.parseInt(key);
					switch(temp){
					case 1:type="����";break;
					case 2:type="ϵͳ";break;
					case 3:type="����";break;
					case 4:type="���氲ȫ";break;
					case 5:type="���ʿ���";break;
					case 6:type="����";break;
					default: break;
					}
					addCell(1, i, type);
					// �����������
					addCell(2, i, info.getRcname());
					// �������˵��
					addCell(3, i, info.getRcdesc());
					// ���ʵ�ʼ��ʱ��
					/*addCell(4, i, info.getRccreatetime());*/
					// �����Ƶ��
					addCell(4, i, info.getRcfrequency());
					// �����
					addCell(5, i, info.getRcrresult());
					// ���˵��
					addCell(6, i, info.getRcrcomment());
					// ����
					addCell(7, i,StringUtils.isNotEmpty(info.getRcrattch()) ? info.getRcrattch().substring(info.getRcrattch().lastIndexOf("_") + 1) : ""); 
					// ��������
					addCell(8, i, info.getPrtitle());
					i++;
					j++;
				}
				//����λ��
				int mergeEnd = i - 1;
				//�жϺϲ�
				if(mergeStart != mergeEnd){
					try {
						dto.getWritableSheet().mergeCells(0,dto.getStartRow() + mergeStart,0, dto.getStartRow() + mergeEnd);
						dto.getWritableSheet().mergeCells(2,dto.getStartRow() + mergeStart,2, dto.getStartRow() + mergeEnd);
					} catch (Exception e) {
						log.error("",e);
					} 
				}
			}
			int mergeEndClass = j - 1;
			//�жϺϲ�
			if(mergeStartClass != mergeEndClass){
				try {
					dto.getWritableSheet().mergeCells(1,dto.getStartRow() + mergeStartClass,1, dto.getStartRow() + mergeEndClass);
				} catch (Exception e) {
					log.error("",e);
				} 
			}
		}
		log.debug("=================��ȡ������ⱨ��������=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}
}
