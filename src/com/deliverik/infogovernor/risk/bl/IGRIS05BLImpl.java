/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.risk.bl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.infogovernor.risk.bl.task.CheckWorkConutVWBL;
import com.deliverik.infogovernor.risk.dto.IGRIS05DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0501Form;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkConutVWSearchCondImpl;
import com.deliverik.infogovernor.risk.model.entity.CheckWorkConutVW;

/**
 * @Description: ��������ѯ
 * @Author
 * @20140709 �½�
 * @Version V1.0
 */
public class IGRIS05BLImpl extends BaseBLImpl implements IGRIS05BL {

	static Log log = LogFactory.getLog(IGRIS05BLImpl.class);


	/** ��������ѯ */
	protected CheckWorkConutVWBL checkWorkConutVWBL;

	/** ������ѯ */
	protected AttachmentBL attachmentBL;

	/** ÿ�� */
	protected String DAY = "day";

	/** һ�� */
	protected String ONCE = "once";

	/**
	 * ��������ѯ�趨
	 * 
	 * @param checkWorkConutVWBL
	 *            ��������ѯ
	 */
	public void setCheckWorkConutVWBL(CheckWorkConutVWBL checkWorkConutVWBL) {
		this.checkWorkConutVWBL = checkWorkConutVWBL;
	}

	/**
	 * ������ѯ�趨
	 * 
	 * @param attachmentBL
	 *            ������ѯ
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	/***
	 * ���ͳ�Ʊ���
	 * @param dto
	 * @return dto
	 */
	public IGRIS05DTO searchRiskCount(IGRIS05DTO dto) throws BLException {
		
		log.debug("====================ctrlBL ����ͳ�Ʋ�ѯ��ʼ=======================");
		//��ѯ������ʼ��
		CheckWorkConutVWSearchCondImpl cond = new  CheckWorkConutVWSearchCondImpl();
		cond.setRcrtestmode(dto.getIgris0501Form().getRcrtestmode());
		IGRIS0501Form form =dto.getIgris0501Form();
		int month=Integer.parseInt(dto.getIgris0501Form().getMonth().trim());
		/**ƴ����*/
		if(month>6){
			String condtion=" and ((t.rcfrequency = 'halfyear' and t.RCSTARTDATE between '"+form.getYear()+"/06/01 00:00' and '"+form.getYear()+"/"+form.getMonth()+"/31 23:59')" ;  
			cond.setHalfyear(condtion);
		}else {
			String condtion=" and ((t.rcfrequency = 'halfyear' and t.RCSTARTDATE between '"+form.getYear()+"/01/01 00:00' and '"+form.getYear()+"/"+form.getMonth()+"/31 23:59')" ;
			cond.setHalfyear(condtion);
		}
		/**ƴ����*/
		if(month<4){
			String condtion= " or (t.rcfrequency = 'quarter' and t.RCSTARTDATE between '"+form.getYear()+"/01/01 00:00' and '"+form.getYear()+"/"+form.getMonth()+"/31 23:59')" ;
			cond.setQuart(condtion);
		}else if (month>3&month<7){
			String condtion= " or (t.rcfrequency = 'quarter' and t.RCSTARTDATE between '"+form.getYear()+"/04/01 00:00' and '"+form.getYear()+"/"+form.getMonth()+"/31 23:59')" ;
			cond.setQuart(condtion);
		}else if (month>6&month<10){
			String condtion= " or (t.rcfrequency = 'quarter' and t.RCSTARTDATE between '"+form.getYear()+"/07/01 00:00' and '"+form.getYear()+"/"+form.getMonth()+"/31 23:59')" ;
			cond.setQuart(condtion);
		}else if (month>9&month<12){
			String condtion= " or (t.rcfrequency = 'quarter' and t.RCSTARTDATE between '"+form.getYear()+"/10/01 00:00' and '"+form.getYear()+"/"+form.getMonth()+"/31 23:59')" ;
			cond.setQuart(condtion);
		}
		
		/**ƴ��*/
		String yearCond="  or (t.rcfrequency = 'year' and t.RCSTARTDATE between '"+form.getYear()+"/01/01 00:00' and '"+form.getYear()+"/"+form.getMonth()+"/31 23:59')";
		cond.setYear(yearCond);
		
		/**ƴweek ��day ��once ��month*/
		String cgCond="   or ( t.rcfrequency = 'week' and t.RCSTARTDATE like '"+form.getYear()+"/"+form.getMonth()+"%')" +
				"  or ( t.rcfrequency = 'day' and t.RCSTARTDATE like '"+form.getYear()+"/"+form.getMonth()+"%')" +
				"  or ( t.rcfrequency = 'once' and t.RCSTARTDATE like '"+form.getYear()+"/"+form.getMonth()+"%')" +
				"  or ( t.rcfrequency = 'month' and t.RCSTARTDATE like '"+form.getYear()+"/"+form.getMonth()+"%'))";
		cond.setCg(cgCond);
		
		
		//����taskBL��ѯ
		List<CheckWorkConutVWInfo> checkWorkConutList = checkWorkConutVWBL.searchCheckWorkConutVW(cond, 0, 0);
		
		
		//���Ƶ���趨
		for (CheckWorkConutVWInfo info : checkWorkConutList) {
			CheckWorkConutVW  tb= (CheckWorkConutVW)info;
			if(ONCE.equals(tb.getRcfrequency())){
				tb.setRcfrequency("��һ��");
			}else if(DAY.equals(tb.getRcfrequency())){
				tb.setRcfrequency("ÿ��");
			}else if("week".equals(tb.getRcfrequency())){
				tb.setRcfrequency("ÿ��");
			}else if("month".equals(tb.getRcfrequency())){
				tb.setRcfrequency("ÿ��");
			}else if("halfyear".equals(tb.getRcfrequency())){
				tb.setRcfrequency("ÿ����");
			}else if("year".equals(tb.getRcfrequency())){
				tb.setRcfrequency("ÿ��");
			}else if("quarter".equals(tb.getRcfrequency())){
				tb.setRcfrequency("����");
			}
			
			if("B".equals(tb.getRcrresult())){
				tb.setRcrresult("��������");
			}else if("C".equals(tb.getRcrresult())){
				tb.setRcrresult("�����ش�����");
			}else if("A".equals(tb.getRcrresult())){
				tb.setRcrresult("����");
			}
		}
		//ͳ�Ʊ�����������Ʒ���
		dto = setMapType2(dto,checkWorkConutList);
		//if(StringUtils.isNotBlank(dto.getFlag()) && "2".equals(dto.getFlag()) ){
		/*}else{
			//ͳ�Ʊ�����������ͷ���
			dto = setMapType1(dto,checkWorkConutList);
		}
		*/
		log.debug("====================ctrlBL ����ͳ�Ʋ�ѯ����=======================");
		return dto;
	}

	/**
	 * ͳ�Ʊ�����������ͷ���
	 * @param dto
	 * @param checkWorkConutList
	 */
	private IGRIS05DTO setMapType1(IGRIS05DTO dto,List<CheckWorkConutVWInfo> checkWorkConutList) {
		//����map
		Map<String, List<CheckWorkConutVWInfo>> map = new LinkedHashMap<String, List<CheckWorkConutVWInfo>>();
		Map<Integer,String> mapType = new LinkedHashMap<Integer,String>();
		int i = 0;
		//map(key,value) ������   ��鼯��
		for(CheckWorkConutVWInfo info:checkWorkConutList){
			if (map.get(info.getRcclass()) == null) {
				map.put(info.getRcclass(), new ArrayList<CheckWorkConutVWInfo>());
				mapType.put(i, info.getRcclass());
				i++;
			}
			map.get(info.getRcclass()).add(info);
		}
		
		dto.setCheckWorkConutmap(map);
		dto.setMapType(mapType);
		return dto;
	}
	
	/**
	 * ͳ�Ʊ�����������Ʒ���
	 * @param dto
	 * @param checkWorkConutList
	 */
	private IGRIS05DTO setMapType2(IGRIS05DTO dto, List<CheckWorkConutVWInfo> checkWorkConutList) {
		//����map
		Map<String, Map<String,List<CheckWorkConutVWInfo>>> map = new LinkedHashMap<String, Map<String,List<CheckWorkConutVWInfo>>>();
		Map<String,Map<Integer,String>> mapType = new LinkedHashMap<String,Map<Integer,String>>();
		Set<String> setType = new HashSet<String>();
		for(CheckWorkConutVWInfo info:checkWorkConutList){
			setType.add(info.getRcname());
		}
		int j = 0;
		//map(key,value) ������   ��鼯��
		for(CheckWorkConutVWInfo info:checkWorkConutList){
			if (map.get(info.getRcclass()) == null) {
				map.put(info.getRcclass(),new LinkedHashMap<String,List<CheckWorkConutVWInfo>>());
			}
			if(mapType.get(info.getRcclass()) == null){
				mapType.put(info.getRcclass(),new LinkedHashMap<Integer,String>());
			}
			mapType.get(info.getRcclass()).put(j, info.getRcname());
			if(map.get(info.getRcclass()).get(info.getRcname()) == null){
				map.get(info.getRcclass()).put(info.getRcname(), new ArrayList<CheckWorkConutVWInfo>());
				j++;
			}
			map.get(info.getRcclass()).get(info.getRcname()).add(info);
		}
		dto.setCheckExcelWorkConutmap(map);
		dto.setMapTypeExcel(mapType);
		return dto;
	}

}
