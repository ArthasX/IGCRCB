/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.bl.task.IGCRC2001BL;
import com.deliverik.infogovernor.crc.dto.IGCRC2001DTO;
import com.deliverik.infogovernor.crc.form.IGCRC2001Form;
import com.deliverik.infogovernor.crc.model.IGCRC2001VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2001CondImpl;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2001VW;
import com.deliverik.infogovernor.crc.vo.IGCRC2002VO;

/**
 * ����:������ȹ���ͳ��BL 
 */
public class IGCRC20BLImpl extends BaseBLImpl implements IGCRC20BL {
	
	/**���ͳ��BL*/
	protected IGCRC2001BL igcrc2001bl;

	public IGCRC2001BL getIgcrc2001bl() {
		return igcrc2001bl;
	}

	public void setIgcrc2001bl(IGCRC2001BL igcrc2001bl) {
		this.igcrc2001bl = igcrc2001bl;
	}
	
	/**����ݲ�ѯ���๤������*/
	public IGCRC2001DTO getFindStatistics(IGCRC2001DTO dto) {
		// TODO Auto-generated method stub

		IGCRC2001Form form = dto.getIgcrc2001Form();

		IGCRC2001CondImpl cond = new IGCRC2001CondImpl();
		//��Ӳ�ѯ���� ��
		cond.setYear(form.getYear());
		//��ѯ�����ŵ�DTO��
		dto.setCond(cond);
		//�洢�кϼ�List
		List<Integer> sumList = new ArrayList<Integer>();
		//��ѯ����浽List��
		List<IGCRC2001VWInfo> list = igcrc2001bl.list(cond);
		List<IGCRC2002VO> igcrc2002voList = new ArrayList<IGCRC2002VO>();
		IGCRC2001VW igcrc2001vw = null;
		//�·ݳ�ʼ��
		Map<String, String> monthMap = new LinkedHashMap<String, String>(){
			{
				put("1","01");
				put("2","02");
				put("3","03");
				put("4","04");
				put("5","05");
				put("6","06");
				put("7","07");
				put("8","08");
				put("9","09");
				put("10","10");
				put("11","11");
				put("12","12");
			}
		};
		//�¼��ϼ�
		Integer incidentNum = 0;
		//����ϼ�
		Integer problemNum = 0;
		//����ϼ�
		Integer changeNum = 0;
		//�Ƽ���������ϼ�
		Integer serviceNum = 0;
		//���򿪷��ϼ�
		Integer sfNum = 0;
		//�ϼ�
		Integer total = 0;
		//�����еĺϼ�
		for (int i = 0; i < list.size(); i++) {
			igcrc2001vw = (IGCRC2001VW) list.get(i);
			//����·���0��ͷ ȥ��0
			if(igcrc2001vw.getPropentime().matches("0\\d")){
				igcrc2001vw.setPropentime(igcrc2001vw.getPropentime().replace("0", ""));
			}
			//����·�С��12����
			if(list.size() < 12){
				//ѭ���趨�õ�map
				for(Map.Entry<String, String> entry : monthMap.entrySet()){
					//����������д��·� ����ͬ ����ֵ �ÿ�,��Ϊ��־
					if(igcrc2001vw.getPropentime().equals(entry.getKey())){
						entry.setValue("");
					}
				}
			}
			//�����кϼ�
			Integer sum = (igcrc2001vw.getIncidentnum()
					+ igcrc2001vw.getProblemnum() + igcrc2001vw.getChangenum()
					+ igcrc2001vw.getServicenum() + igcrc2001vw.getSfnum());
			//�����кϼ�
			incidentNum += igcrc2001vw.getIncidentnum();
			problemNum += igcrc2001vw.getProblemnum();
			changeNum += igcrc2001vw.getChangenum();
			serviceNum += igcrc2001vw.getServicenum();
			sfNum += igcrc2001vw.getSfnum();
			total += sum;
			//�кϼƽ����䵽������
			igcrc2002voList.add(new IGCRC2002VO(igcrc2001vw, sum));
		}
		//���еĺϼ���䵽sumList��
		sumList.add(incidentNum);
		sumList.add(problemNum);
		sumList.add(changeNum);
		sumList.add(serviceNum);
		sumList.add(sfNum);
		sumList.add(total);
		
		//��ӿ�������
		for(Map.Entry<String, String> entry : monthMap.entrySet()){
			//���ֵ��Ϊ����Ӵ���
			if(!"".equals(entry.getValue())){
				igcrc2002voList.add(new IGCRC2002VO(entry.getKey(), 0, 0, 0, 0, 0, 0));
			}
		}
		//���ݰ��·�����
		Collections.sort(igcrc2002voList, new Comparator<IGCRC2002VO>() {
			public int compare(IGCRC2002VO vo1, IGCRC2002VO vo2) {
				return new Integer(Integer.parseInt(vo1.getPropentime()))
						.compareTo(Integer.parseInt(vo2.getPropentime()));
			}
		});
		
		//���浽DTO
		dto.setIgcrc2002voList(igcrc2002voList);
		dto.setSumList(sumList);
		
		return dto;
	}

}
