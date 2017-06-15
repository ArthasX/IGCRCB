package com.deliverik.infogovernor.smr.bl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.infogovernor.smr.dto.IGSMR09DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0901Form;
import com.deliverik.infogovernor.smr.form.IGSMR0902Form;
import com.deliverik.infogovernor.smr.form.IGSMR0903Form;

/**
 * ����:���ֳ���ܱ���DashBoard��̨����
 * �����ˣ���ʡ
 * ������¼�� 2013-09-10
 */
@SuppressWarnings("rawtypes")
public class IGSMR09BLImpl extends BaseBLImpl implements IGSMR09BL{

	static Log log = LogFactory.getLog(IGSMR09BLImpl.class);

	private FlowSearchBL flowSearchBL;
	
	private DecimalFormat df = new DecimalFormat("0.0");  
	
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	
	/**
	 * ��ȡ�ϸ����ȵ�T-Q-4��������ID
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private Integer getQuarterPrid(IGSMR09DTO dto) throws BLException {
		
		String pdid = IGSMRDBMCONSTANT.PDID_TQ1;//���̶���ID
		String prtype = Constants.REGULATORYREPORT_TYPE_SEASON;//��������ID
		
		IGSMR0901Form form = dto.getIgsmr0901Form();
		String year = form.getYear();
		String quarter = form.getQuarter();//��ʽӦΪ��һ�����������������������ġ�
		String time = "";
		if(StringUtils.isEmpty(year) || StringUtils.isEmpty(quarter)){
			time = getTime(1,null).get(0);
		}else{
			time = year + "_"+quarter+"����";
		}
		
		List<Integer> list = flowSearchBL.searchRegulatoryReportInfo(prtype, pdid ,time, true);
		if(list.size() == 0){
			return null;
		}
		Integer prid = Integer.parseInt(list.get(list.size()-1)+"");
		
		return prid;
	}

	/**
	 * ���ӽ��ױ����ϼ�
	 * ����
	 */
	public IGSMR09DTO getElecTransTotal(IGSMR09DTO dto) throws BLException {
		
		Integer prid = getQuarterPrid(dto);
		if(prid == null) return dto;
		
		Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
		//����
		String count = new DecimalFormat("0").format(Double.parseDouble(flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#�ϼ�#1#����", prid, "1_1_1")));
		//���
		String money = new DecimalFormat("0").format(Double.parseDouble(flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��׽��#�ϼ�#1#����", prid, "1_1_1")));
		
		String arr[] = fixNumber(new String[]{count,money});
		
		String value = getStr(arr);  
		dto.setResult(value);
		
		return dto;
	} 
	
	/**
	 * ���н��׷�����������
	 * ���� 
	 */
	public IGSMR09DTO getMultiBankTransCount(IGSMR09DTO dto) throws BLException {
		
		Integer prid = getQuarterPrid(dto);
		if(prid == null) return dto;
		Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
		
		/** ATM������ */
		String atm1_1 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#1#����", prid, "1_1_1_1");
		String atm1_2 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#1#����", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(atm1_2)) atm1_2 =atm1_2 + "%";
		String atm1_3 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#2#����", prid, "1_1_1_1");
		String atm1_4 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#2#����", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(atm1_4)) atm1_4 =atm1_4 + "%";
		/** ATM ������*/
		String atm2_1 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#1#����", prid, "1_1_1_1");
		String atm2_2 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#1#����", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(atm2_2)) atm2_2 =atm2_2 + "%";
		String atm2_3 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#2#����", prid, "1_1_1_1");
		String atm2_4 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#2#����", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(atm2_4)) atm2_4 =atm2_4 + "%";
		
//		/** ��������-������������ */
//		String pos1_1 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#������������#1#����", prid, "1_1_1_1");
//		String pos1_2 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#������������#1#����", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(pos1_2)) pos1_2 =pos1_2 + "%";
//		String pos1_3 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#������������#2#����", prid, "1_1_1_1");
//		String pos1_4 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#������������#2#����", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(pos1_4)) pos1_4 =pos1_4 + "%";
//		
//		/** ��������-��ҵ�������� */
//		String pos2_1 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#��ҵ��������#1#����", prid, "1_1_1_1");
//		String pos2_2 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#��ҵ��������#1#����", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(pos2_2)) pos2_2 =pos2_2 + "%";
//		String pos2_3 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#��ҵ��������#2#����", prid, "1_1_1_1");
//		String pos2_4 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#��ҵ��������#2#����", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(pos2_4)) pos2_4 =pos2_4 + "%";
		
		String[] arr = new String[]{atm1_1, atm1_2 ,"0" ,atm1_3 , atm1_4 , "0" ,
				atm2_1 , atm2_2, "0" , atm2_3 , atm2_4 , "0"};
		String value = getStr(arr);
		dto.setResult(value);
		return dto;
	}
	
	/**
	 * ���н��׷�������
	 * ���� 
	 */
	public IGSMR09DTO getMultiBankTransMoney(IGSMR09DTO dto) throws BLException {
		
		Integer prid = getQuarterPrid(dto);
		if(prid == null) return dto;
		Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
		
//		/** ATM������ */
//		String atm1_1 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#1#����", prid, "1_1_1_1");
//		String atm1_2 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#1#����", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(atm1_2)) atm1_2 =atm1_2 + "%";
//		String atm1_3 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#2#����", prid, "1_1_1_1");
//		String atm1_4 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#2#����", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(atm1_4)) atm1_4 =atm1_4 + "%";
//		/** ATM ������*/
//		String atm2_1 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#1#����", prid, "1_1_1_1");
//		String atm2_2 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#1#����", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(atm2_2)) atm2_2 =atm2_2 + "%";
//		String atm2_3 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#2#����", prid, "1_1_1_1");
//		String atm2_4 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#ATM#������#2#����", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(atm2_4)) atm2_4 =atm2_4 + "%";
		
		/** ��������-������������ */
		String pos1_1 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#������������#1#����", prid, "1_1_1_1");
		String pos1_2 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#������������#1#����", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(pos1_2)) pos1_2 =pos1_2 + "%";
		String pos1_3 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#������������#2#����", prid, "1_1_1_1");
		String pos1_4 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#������������#2#����", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(pos1_4)) pos1_4 =pos1_4 + "%";
		
		/** ��������-��ҵ�������� */
		String pos2_1 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#��ҵ��������#1#����", prid, "1_1_1_1");
		String pos2_2 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#��ҵ��������#1#����", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(pos2_2)) pos2_2 =pos2_2 + "%";
		String pos2_3 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#��ҵ��������#2#����", prid, "1_1_1_1");
		String pos2_4 = flowSearchBL.searchPublicTableColumnValue(map, "��Ҫ���ӽ��ױ���#��������#��ҵ��������#2#����", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(pos2_4)) pos2_4 =pos2_4 + "%";
		
		String[] arr = new String[]{pos1_1, pos1_2 ,"0" ,pos1_3 , pos1_4 , "0" ,
				pos2_1 , pos2_2, "0" , pos2_3 , pos2_4 , "0"};
		
		String value = getStr(arr);
		dto.setResult(value);
		return dto;
	}
	
	/**
	 * ���ױ������Ʒ���
	 * ���� 
	 */
	public IGSMR09DTO getMultiBankTransCountTrend(IGSMR09DTO dto) throws BLException {
		String xml = getTrend(dto,1);   
		dto.setResult(xml);
		return dto;
	}
	
	/**
	 * ���׽�����Ʒ���
	 * ���� 
	 */
	public IGSMR09DTO getMultiBankTransMoneyTrend(IGSMR09DTO dto) throws BLException {
		String xml = getTrend(dto,2);
		dto.setResult(xml);
		return dto;
	}
	
	/**
	 * ˽�з���
	 * ���ױ����������Ʒ���
	 */
	private String getTrend(IGSMR09DTO dto,int trendType) throws BLException {
		
		String pdid = IGSMRDBMCONSTANT.PDID_TQ1;//���̶���ID 
		String prtype = Constants.REGULATORYREPORT_TYPE_SEASON;//��������ID
		
		IGSMR0901Form form = dto.getIgsmr0901Form();
		String year = form.getYear();
		String quarter = form.getQuarter();//��ʽӦΪ��һ�����������������������ġ�
		List<String> times;
		if(StringUtils.isEmpty(year) || StringUtils.isEmpty(quarter)){
			times = getTime(5,null);//Ĭ��ȡ��ǰʱ�����5������
		}else{
			int quarterVal = 0;
			if("һ".equals(quarter)) quarterVal = 1;
			else if("��".equals(quarter)) quarterVal = 2;
			else if("��".equals(quarter)) quarterVal = 3;
			else if("��".equals(quarter)) quarterVal = 4;
			String queryStr = year + "#" + quarterVal;
			times = getTime(5,queryStr);//Ĭ��ȡ��ǰʱ�����5������
		}
		List<Integer> prids = new ArrayList<Integer>();
		String[] qs = new String[times.size()];//������ȵ��ַ���
		for(int i =0 ;i < times.size();i++){
			List<Integer> list = flowSearchBL.searchRegulatoryReportInfo(prtype, pdid ,times.get(i), true);
			if(list.size() != 0 && list.get(list.size()-1) != null) {
				prids.add(Integer.parseInt(list.get(list.size()-1)+""));
			}else prids.add(null);
			qs[i] = times.get(i).replace("_", "");
		}

		
		String title = "";
		if(trendType == 1) title = "��Ҫ���ӽ��ױ���";
		else if(trendType == 2) title = "��Ҫ���ӽ��׽��";
		
		//���ݴ洢��ʽ
		Map<String,List<Double>> valueMap = new LinkedHashMap<String,List<Double>>();
		
		String[] names = {"ATM", "POS", "������������", "��ҵ��������" ,"�绰����" ,"�ֻ�����","������������ҵ��"};
		
//		if(prids.size() < 5){
//			log.debug("------------�������ݲ�ȫ-------------");
//			return null;
//		}
		
		/**
		 * ��ȡ��������
		 */
		for (int i = 0; i < 5; i++) {//List��˳��Ϊ�ӹ�ȥ������
			
			Map<String,Double> tempMap = new HashMap<String,Double>();
			
			Integer prid = prids.get(i);
			
			if(prid != null){
				
				Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
				
				//ATM
				String atm1 = "0";
				String atm2 = "0";
				String atm3 = "0";
				if(trendType == 1){
					 atm1 = flowSearchBL.searchPublicTableColumnValue(map, title+"#ATM#����#3#����", prid, "1_1_1_1");
					 atm2 = flowSearchBL.searchPublicTableColumnValue(map, title+"#ATM#������#3#����", prid, "1_1_1_1");
					 atm3 = flowSearchBL.searchPublicTableColumnValue(map, title+"#ATM#������#3#����", prid, "1_1_1_1");
				}else{
					 atm1 = flowSearchBL.searchPublicTableColumnValue(map, title+"#ATM#����#1#����", prid, "1_1_1_1");
					 atm2 = flowSearchBL.searchPublicTableColumnValue(map, title+"#ATM#������#1#����", prid, "1_1_1_1");
					 atm3 = flowSearchBL.searchPublicTableColumnValue(map, title+"#ATM#������#1#����", prid, "1_1_1_1");
				}
				atm1 = fixNumber(atm1);
				atm2 = fixNumber(atm2);
				atm3 = fixNumber(atm3);
				Double atm = Double.parseDouble(atm1) + Double.parseDouble(atm2) + Double.parseDouble(atm3);
				tempMap.put(names[0], atm);
				
				//POS
				String pos1 = flowSearchBL.searchPublicTableColumnValue(map, title+"#POS#����#1#����", prid, "1_1_1_1");
				String pos2 = flowSearchBL.searchPublicTableColumnValue(map, title+"#POS#������#1#����", prid, "1_1_1_1");
				String pos3 = flowSearchBL.searchPublicTableColumnValue(map, title+"#POS#������#1#����", prid, "1_1_1_1");
				pos1 = fixNumber(pos1);
				pos2 = fixNumber(pos2);
				pos3 = fixNumber(pos3);
				Double pos = Double.parseDouble(pos1) + Double.parseDouble(pos2) + Double.parseDouble(pos3);
				tempMap.put(names[1], pos);
				
				//������������
				String ebank1 = flowSearchBL.searchPublicTableColumnValue(map, title+"#��������#������������#1#����", prid, "1_1_1_1");
				tempMap.put(names[2], Double.parseDouble(fixNumber(ebank1)));
				
				//��ҵ��������
				String ebank2 = fixNumber(flowSearchBL.searchPublicTableColumnValue(map, title+"#��������#��ҵ��������#1#����", prid, "1_1_1_1"));
				tempMap.put(names[3], Double.parseDouble(ebank2));
				
				//�绰����
				String telbank = fixNumber(flowSearchBL.searchPublicTableColumnValue(map, title+"#�绰����#1#����", prid, "1_1_1"));
				tempMap.put(names[4], Double.parseDouble(telbank));
				
				//�ֻ�����
				String mobelbank = fixNumber(flowSearchBL.searchPublicTableColumnValue(map, title+"#�ֻ�����#1#����", prid, "1_1_1"));
				tempMap.put(names[5], Double.parseDouble(mobelbank));
				
				//������������ҵ��
				String otherbank = fixNumber(flowSearchBL.searchPublicTableColumnValue(map, title+"#������������ҵ��#1#����", prid, "1_1_1"));
				tempMap.put(names[6], Double.parseDouble(otherbank));
				
				/**
				 * ����𡢼�����װ����
				 */
				for (int j = 0; j < names.length; j++) {
					if(valueMap.get(names[j]) == null){
						List<Double> values = new ArrayList<Double>();
						values.add(tempMap.get(names[j]));
						valueMap.put(names[j], values);
					}else{
						valueMap.get(names[j]).add(tempMap.get(names[j]));
					}
				}
			}else{
				/**
				 * ����𡢼�����װ����
				 */
				for (int j = 0; j < names.length; j++) {
					if(valueMap.get(names[j]) == null){
						List<Double> values = new ArrayList<Double>();
						values.add(0.0);
						valueMap.put(names[j], values);
					}else{
						valueMap.get(names[j]).add(0.0);
					}
				}
			}
		}
		
		/**
		 * ƴװXML
		 */
		if(valueMap.size() == 0) return null;
		Double[] tempArr = new Double[prids.size()*names.length];
		int tempIndex = 0;
		for (Iterator<String> iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			List<Double> tempList = valueMap.get(key);
			for(int i =0;i<tempList.size();i++){
				tempArr[tempIndex++] = tempList.get(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT><LINES MINVALUE=\"0\" MAXVALUE=\""+df.format(getMax(tempArr))+"\">");
		for (Iterator<String> iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
			String name = iterator.next();
			List<Double> tempList = valueMap.get(name);
			sb.append("<LINE MINVALUE=\"0\" MAXVALUE=\""+df.format(getMax(turnListToArrDouble(tempList)))+"\" UNIT=\"(���)\" TITLE=\""+name+"\">");
			for (int i = 0; i < tempList.size(); i++) {
				sb.append("<VALUE MONTH=\""+qs[i]+"\">"+df.format(tempList.get(i))+"</VALUE>");
			}
			sb.append("</LINE>");
		}
		sb.append("</LINES></ROOT>");
		return sb.toString();
	
	}
	
	/**
	 * ��������ҵ���ģ
	 * ����
	 */
	public IGSMR09DTO getElecWorkScale(IGSMR09DTO dto) throws BLException {
		
		Integer prid = getQuarterPrid(dto);
		if(prid == null) return dto;
		
		List values = (List) flowSearchBL.searchPublicTableValue("����������Ҫҵ���ģ", prid, null);
		Map map = (Map) values.get(0);
		String valueKey1 = "��ϸ";
		String valueKey1plu = "��ϸ��Ŀ";
		String valueKey2 = "����";
		String valueKey3 = "����";
		String valueKey3plu = "����������%/�ٷֵ㣩";
		String value1 = "";
		String value2 = "";
		String value3 = "";
		String value4 = "";
		StringBuilder sb = new StringBuilder();
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			List list = (List) map.get(key);
			for (int i = 0; i < list.size(); i++) {//atm����
				Map valueMap = (Map) list.get(i);
					for (Iterator iterator1 = valueMap.keySet().iterator(); iterator1.hasNext();) {
						String key1 = (String) iterator1.next();
						List valueList = (List)valueMap.get(key1);
						for (int j = 0; j < valueList.size(); j++) {
							Map lastMap = (Map) valueList.get(j);
							if("ATM".equals(key)&&"1".equals(key1)&&j==0){
								value1 =  fixNullStr((String)lastMap.get(valueKey1plu));
								value4 =  fixNullStr((String)lastMap.get(valueKey3plu));
							}else{
								value1 =  fixNullStr((String)lastMap.get(valueKey1));
								value4 =  fixNullStr((String)lastMap.get(valueKey3));
							}
							value2 =  fixNullStr((String)lastMap.get(valueKey2));
							//value4����
							if(StringUtils.isNotEmpty(value4)) value4 = value4 + "%";
							sb.append(value1 + "#" + value2 + "#" + value3 + "#" + value4 + "#");

						}
					}
				}
			
		}
		
		
//		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
//			String key = (String) iterator.next();
//			List list = (List) map.get(key);
//			for (int i = 0; i < list.size(); i++) {
//				Map valueMap = (Map) list.get(i);
//				if(!"�ֻ�����".equals(key)&&!"POS".equals(key)){
//					for (Iterator iterator1 = valueMap.keySet().iterator(); iterator1.hasNext();) {
//						String key1 = (String) iterator1.next();
//						List valueList = (List)valueMap.get(key1);
//						for (int j = 0; j < valueList.size(); j++) {
//							value1 =  fixNullStr((String) ((Map)valueList.get(j)).get("��ϸ��Ŀ"));
//							value2 =  fixNullStr((String) ((Map)valueList.get(j)).get("����"));
//							value3 =  fixNullStr((String) ((Map)valueList.get(j)).get("ͬ������(%)"));
//							if(StringUtils.isNotEmpty(value3)) value3 = value3 + "%";
//							
//							value4 =  fixNullStr((String) ((Map)valueList.get(j)).get("��������(%)"));
//							if(StringUtils.isNotEmpty(value4)) value4 = value4 + "%";
//							sb.append(value1 + "#" + value2 + "#" + value3 + "#" + value4 + "#");
//						}
//					}
//				}else{
//					value1 = fixNullStr((String) valueMap.get("��ϸ��Ŀ"));
//					value2 = fixNullStr((String) valueMap.get("����"));
//					value3 = fixNullStr((String) valueMap.get("ͬ������(%)"));
//					if(StringUtils.isNotEmpty(value3)) value3 = value3 + "%";
//					else {
//						value3 = fixNullStr((String) valueMap.get("��������(%��"));
//						if(StringUtils.isNotEmpty(value3)) value3 = value3 + "%";
//					}
//					value4 = fixNullStr((String) valueMap.get("��������(%)"));
//					if(StringUtils.isNotEmpty(value4)) value4 = value4 + "%";
//					sb.append(value1 + "#" + value2 + "#" + value3 + "#" + value4 +"#");
//				}
//			}
//		}
		String value = sb.toString();
		if(StringUtils.isNotEmpty(value)) value = value.substring(0,value.length()-1);
		dto.setResult(value);
		return dto;
	}
	
	
	/**
	 * ��ȡ�걨����ID
	 * @param dto
	 * @param pdid
	 * @return
	 * @throws BLException
	 */
	private Integer getYearPrid(IGSMR09DTO dto ,String pdid) throws BLException {
		
		String prtype = Constants.REGULATORYREPORT_TYPE_YEAR;//��������ID
		
		IGSMR0902Form form = dto.getIgsmr0902Form();
		String year = form.getYear();
		if(StringUtils.isEmpty(year)){
			year = getLastYear(null);//Ĭ�ϻ�ȡ��ǰ��ݵ���һ��
		}
		
		List list = flowSearchBL.searchRegulatoryReportInfo(prtype, pdid ,year, true);
		if(list.size() == 0){
			return null;
		}
		Integer prid = Integer.parseInt(list.get(list.size()-1).toString());
		
		return prid;
	}
	
	/**
	 * ����һ�к�ͼ
	 * �걨
	 */
	public IGSMR09DTO getTechnologyInfo(IGSMR09DTO dto) throws BLException {
		
		String pdid = IGSMRDBMCONSTANT.PDID_TB1;
		Integer prid = getYearPrid(dto, pdid);
		
		if(prid == null) return dto;
		
		Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
		
		//�ʲ���ģ
		String value1 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_2+"#"+IGSMRDBMCONSTANT.TB1_2_1+"#"+IGSMRDBMCONSTANT.TB1_2_1_1, prid, "1_1"));
		value1 = new DecimalFormat("0.00").format(Double.parseDouble(value1));
		//��������
		String value2 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_2+"#"+IGSMRDBMCONSTANT.TB1_2_1+"#"+IGSMRDBMCONSTANT.TB1_2_1_2, prid, "1_1"));
		value2 = new DecimalFormat("0").format(Double.parseDouble(value2));
		//�Ƽ�Ͷ��
		String value3 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_7+"#"+IGSMRDBMCONSTANT.TB1_7_1+"#"+IGSMRDBMCONSTANT.TB1_7_1_1, prid, "1_1"));
		value3 = new DecimalFormat("0.0").format(Double.parseDouble(value3));
		//ռ��
		String value4 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_7+"#"+IGSMRDBMCONSTANT.TB1_7_1+"#"+IGSMRDBMCONSTANT.TB1_7_1_11, prid, "1_1"));
		value4 = new DecimalFormat("0.00").format(Double.parseDouble(value4)) + "%";
		String value = getStr(new String[]{value1 ,value2 ,value3 ,value4});
		
		dto.setResult(value);
		return dto;
	}
	
	/**
	 * �Ҳ��һ�к�ͼ
	 * �걨 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getPersonnel(IGSMR09DTO dto) throws BLException {
		
		String pdid = IGSMRDBMCONSTANT.PDID_TB1;
		Integer prid = getYearPrid(dto, pdid);
		if(prid == null) return dto;
		
		Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
		//�Ƽ���Ա����
		String value1 = flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_8+"#"+IGSMRDBMCONSTANT.TB1_8_1+"#"+IGSMRDBMCONSTANT.TB1_8_1_2, prid, "1_1");
		//������Ա����
		String value2 = flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_10+"#"+IGSMRDBMCONSTANT.TB1_10_1+"#"+IGSMRDBMCONSTANT.TB1_10_1_7, prid, "1_1");
		//�����Ա����
		String value3 = flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_11+"#"+IGSMRDBMCONSTANT.TB1_11_1+"#"+IGSMRDBMCONSTANT.TB1_11_1_6, prid, "1_1");
		
		String value = getStr(new String[]{value1 ,value2 ,value3});
		
		dto.setResult(value);
		
		return dto;
	}
	
	/**
	 * ���ڶ��е�һ����ͼ
	 * �걨
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getTechnologyNumber(IGSMR09DTO dto) throws BLException {
		
		//������Ϣϵͳ����
		String pdid = IGSMRDBMCONSTANT.PDID_TB10;
		Integer prid_10 = getYearPrid(dto, pdid);
		String value1 = "";
		if(prid_10 != null){
			Map<String, ProcessInfoDefinitionInfo> map_10 = flowSearchBL.searchProcessTableColumnDef(prid_10);
			value1 = flowSearchBL.searchPublicTableColumnValue(
					map_10, IGSMRDBMCONSTANT.TB10_1+"#"+IGSMRDBMCONSTANT.TB10_1_1+"#"+IGSMRDBMCONSTANT.TB10_1_1_1+"#"+IGSMRDBMCONSTANT.TB10_1_1_1_1, prid_10, "1_1_1");
		}
		
		//���������
		pdid = IGSMRDBMCONSTANT.PDID_TB12;
		Integer prid_12 = getYearPrid(dto, pdid);
		String value2 = "";
		if(prid_12 != null){
			Map<String, ProcessInfoDefinitionInfo> map_12 = flowSearchBL.searchProcessTableColumnDef(prid_12);
		    value2 = flowSearchBL.searchPublicTableColumnValue(
				map_12, "��Ϣ�Ƽ�������չ���#��Ϣ�Ƽ�������չ���ܹ�#����#�������Ҫ��Ϣ�Ƽ���������ṩ������".trim(), prid_12, "1_1_1");
		}
		
		//�ƶ�����
		pdid = IGSMRDBMCONSTANT.PDID_TB1;
		Integer prid_1 = getYearPrid(dto, pdid);
		String value3 = "";
		if(prid_1 != null){
			Map<String, ProcessInfoDefinitionInfo> map_1 = flowSearchBL.searchProcessTableColumnDef(prid_1);
			value3 = flowSearchBL.searchPublicTableColumnValue(
				map_1, IGSMRDBMCONSTANT.TB1_10+"#"+IGSMRDBMCONSTANT.TB1_10_1+"#"+IGSMRDBMCONSTANT.TB1_10_1_12, prid_1, "1_1");
		}
		String value = getStr(new String[]{value1 ,value2 ,value3});
		
		dto.setResult(value);
		return dto;
	}
	
	/**
	 * �Ƽ�Ͷ��ռ�ȷ���
	 * �������б�ͼ
	 * �걨
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getPieGraph(IGSMR09DTO dto) throws BLException {
		
		
		String pdid = IGSMRDBMCONSTANT.PDID_TB1;
		Integer prid = getYearPrid(dto , pdid);
		if(prid == null) return dto; 
		//������Ϣ�Ƽ�Ͷ��
		String value1 = "";
		String value2 = "";
		String value3 = "";
		String value4 = "";
		String value5 = "";
		String value6 = "";
		String value7 = "";
		String value8 = "";
		Map<String, ProcessInfoDefinitionInfo> map1 = flowSearchBL.searchProcessTableColumnDef(prid);
		value1 = flowSearchBL.searchPublicTableColumnValue(map1,IGSMRDBMCONSTANT.TB1_7+"#"+IGSMRDBMCONSTANT.TB1_7_1+"#"+IGSMRDBMCONSTANT.TB1_7_1_2,prid,"1_1");
		value2 = flowSearchBL.searchPublicTableColumnValue(map1,IGSMRDBMCONSTANT.TB1_7+"#"+IGSMRDBMCONSTANT.TB1_7_1+"#"+IGSMRDBMCONSTANT.TB1_7_1_3,prid,"1_1");
		value3 = flowSearchBL.searchPublicTableColumnValue(map1,IGSMRDBMCONSTANT.TB1_7+"#"+IGSMRDBMCONSTANT.TB1_7_1+"#"+IGSMRDBMCONSTANT.TB1_7_1_4,prid,"1_1");
		value4 = flowSearchBL.searchPublicTableColumnValue(map1,IGSMRDBMCONSTANT.TB1_7+"#"+IGSMRDBMCONSTANT.TB1_7_1+"#"+IGSMRDBMCONSTANT.TB1_7_1_5,prid,"1_1");
		value5 = flowSearchBL.searchPublicTableColumnValue(map1,IGSMRDBMCONSTANT.TB1_7+"#"+IGSMRDBMCONSTANT.TB1_7_1+"#"+IGSMRDBMCONSTANT.TB1_7_1_6,prid,"1_1");
		value6 = flowSearchBL.searchPublicTableColumnValue(map1,IGSMRDBMCONSTANT.TB1_7+"#"+IGSMRDBMCONSTANT.TB1_7_1+"#"+IGSMRDBMCONSTANT.TB1_7_1_7,prid,"1_1");
		value7 = flowSearchBL.searchPublicTableColumnValue(map1,IGSMRDBMCONSTANT.TB1_7+"#"+IGSMRDBMCONSTANT.TB1_7_1+"#"+IGSMRDBMCONSTANT.TB1_7_1_8,prid,"1_1");
		value8 = flowSearchBL.searchPublicTableColumnValue(map1,IGSMRDBMCONSTANT.TB1_7+"#"+IGSMRDBMCONSTANT.TB1_7_1+"#"+IGSMRDBMCONSTANT.TB1_7_1_9,prid,"1_1");
		Map<String, String> map = new HashMap<String, String>();
		map.put(IGSMRDBMCONSTANT.TB1_7_1_2, value1);
		map.put(IGSMRDBMCONSTANT.TB1_7_1_3, value2);
		map.put(IGSMRDBMCONSTANT.TB1_7_1_4, value3);
		map.put(IGSMRDBMCONSTANT.TB1_7_1_5, value4);
		map.put(IGSMRDBMCONSTANT.TB1_7_1_6, value5);
		map.put(IGSMRDBMCONSTANT.TB1_7_1_7, value6);
		map.put(IGSMRDBMCONSTANT.TB1_7_1_8, value7);
		map.put(IGSMRDBMCONSTANT.TB1_7_1_9, value8);

		if(map == null || map.size() == 0) return dto;
		String[] titles = {IGSMRDBMCONSTANT.TB1_7_1_2,IGSMRDBMCONSTANT.TB1_7_1_3,IGSMRDBMCONSTANT.TB1_7_1_4,
				IGSMRDBMCONSTANT.TB1_7_1_5,IGSMRDBMCONSTANT.TB1_7_1_6,IGSMRDBMCONSTANT.TB1_7_1_7,
				IGSMRDBMCONSTANT.TB1_7_1_8,IGSMRDBMCONSTANT.TB1_7_1_9};
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>");
		
		
		
		
		double total = 0;
//		int titleIndex = 0;
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			total = total + Double.parseDouble(fixNumber((String)map.get(key)));
		}
		 
		sb.append("<DATA TOTALVALUE=\""+df.format(total)+"\">");
		for(int titleIndex = 0;titleIndex<titles.length;titleIndex++){
			Double value = Double.parseDouble(fixNumber((String)map.get(titles[titleIndex])));
			sb.append("<VALUE NAME=\""+titles[titleIndex]+" "+ df.format(value) +"\">" + value + "</VALUE>");
		}
//		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
//			if(titleIndex<8){
//				Double value = Double.parseDouble(fixNumber((String)map.get(titles[titleIndex])));
//				sb.append("<VALUE NAME=\""+titles[titleIndex]+" "+ df.format(value) +"\">" + value + "</VALUE>");
//				titleIndex++;
//			}
//			
//		}
		sb.append("</DATA></ROOT>");
		
		dto.setResult(sb.toString());
		
		return dto;
	}
	
	/**
	 * ��Ϣ�Ƽ�������ԴͶ��
	 * ������ı�ͼ
	 * �걨
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getPieGraph1(IGSMR09DTO dto) throws BLException {
		
		
		String pdid = IGSMRDBMCONSTANT.PDID_TB1;
		Integer prid = getYearPrid(dto , pdid);
		if(prid == null) return dto; 
		//������Ϣ�Ƽ�Ͷ��
		String value1 = "";
		String value2 = "";
		String value3 = "";
		String value4 = "";
		String value5 = "";
		
		Map<String, ProcessInfoDefinitionInfo> map1 = flowSearchBL.searchProcessTableColumnDef(prid);
		value1 = flowSearchBL.searchPublicTableColumnValue(map1,IGSMRDBMCONSTANT.TB1_8+"#"+IGSMRDBMCONSTANT.TB1_8_1+"#"+IGSMRDBMCONSTANT.TB1_8_1_3,prid,"1_1");
		value2 = flowSearchBL.searchPublicTableColumnValue(map1,IGSMRDBMCONSTANT.TB1_8+"#"+IGSMRDBMCONSTANT.TB1_8_1+"#"+IGSMRDBMCONSTANT.TB1_8_1_4,prid,"1_1");
		value3 = flowSearchBL.searchPublicTableColumnValue(map1,IGSMRDBMCONSTANT.TB1_8+"#"+IGSMRDBMCONSTANT.TB1_8_1+"#"+IGSMRDBMCONSTANT.TB1_8_1_5,prid,"1_1");
		value4 = flowSearchBL.searchPublicTableColumnValue(map1,IGSMRDBMCONSTANT.TB1_8+"#"+IGSMRDBMCONSTANT.TB1_8_1+"#"+IGSMRDBMCONSTANT.TB1_8_1_6,prid,"1_1");
		value5 = flowSearchBL.searchPublicTableColumnValue(map1,IGSMRDBMCONSTANT.TB1_8+"#"+IGSMRDBMCONSTANT.TB1_8_1+"#"+IGSMRDBMCONSTANT.TB1_8_1_7,prid,"1_1");

		Map<String, String> map = new HashMap<String, String>();
		map.put(IGSMRDBMCONSTANT.TB1_8_1_3, value1);
		map.put(IGSMRDBMCONSTANT.TB1_8_1_4, value2);
		map.put(IGSMRDBMCONSTANT.TB1_8_1_5, value3);
		map.put(IGSMRDBMCONSTANT.TB1_8_1_6, value4);
		map.put(IGSMRDBMCONSTANT.TB1_8_1_7, value5);


		if(map == null || map.size() == 0) return dto;
		String[] titles = {IGSMRDBMCONSTANT.TB1_8_1_3,IGSMRDBMCONSTANT.TB1_8_1_4,IGSMRDBMCONSTANT.TB1_8_1_5,
				IGSMRDBMCONSTANT.TB1_8_1_6,IGSMRDBMCONSTANT.TB1_8_1_7};
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>");
		
		double total = 0;
//		int titleIndex = 0;
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			total = total + Double.parseDouble(fixNumber((String)map.get(key)));
		}
		 
		sb.append("<DATA TOTALVALUE=\""+df.format(total)+"\">");
		for(int titleIndex = 0;titleIndex<titles.length;titleIndex++){
			Double value = Double.parseDouble(fixNumber((String)map.get(titles[titleIndex])));
			sb.append("<VALUE NAME=\""+titles[titleIndex]+" "+  new DecimalFormat("0").format(value) +"\">" + value + "</VALUE>");
		}
//		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
//			if(titleIndex<5){
//				Double value = Double.parseDouble(fixNumber((String)map.get(titles[titleIndex])));
//				sb.append("<VALUE NAME=\""+titles[titleIndex]+" "+  new DecimalFormat("0").format(value) +"\">" + value + "</VALUE>");
//				titleIndex++;
//			}
//			
//		}
		sb.append("</DATA></ROOT>");
		
		dto.setResult(sb.toString());
		
		return dto;
	}
	
	/**
	 * �����Ŀ���
	 * �Ҳ��������ͼ
	 * �걨
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getBarGraph(IGSMR09DTO dto) throws BLException {
		
		String pdid = IGSMRDBMCONSTANT.PDID_TB1;
		String pdid1 = IGSMRDBMCONSTANT.PDID_TB6;
		Integer prid = getYearPrid(dto, pdid);
		Integer prid1 = getYearPrid(dto, pdid1);
		if(prid == null ||prid1 == null) return dto; 
		IGSMR0902Form form = dto.getIgsmr0902Form();
		String year = form.getYear();
		if(StringUtils.isEmpty(year)){
			year = getLastYear(null);//Ĭ�ϻ�ȡ��ǰ��ݵ���һ��
		}
		IGSMR0902Form form1 = dto.getIgsmr0902Form();
		String year1 = form1.getYear();
		if(StringUtils.isEmpty(year1)){
			year1 = getLastYear(null);//Ĭ�ϻ�ȡ��ǰ��ݵ���һ��
		}
		
		Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
		Map<String, ProcessInfoDefinitionInfo> map1 = flowSearchBL.searchProcessTableColumnDef(prid1);
		//�Ƽ���Ŀ����
		String value1 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_6+"#"+IGSMRDBMCONSTANT.TB1_6_1+"#"+IGSMRDBMCONSTANT.TB1_6_1_1, prid, "1_1"));
		//��Ŀ�����
		String value = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_6+"#"+IGSMRDBMCONSTANT.TB1_6_1+"#"+IGSMRDBMCONSTANT.TB1_6_1_5, prid, "1_1"))+"%";
		//��������Ŀ�����ش�
		String value3 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_6+"#"+IGSMRDBMCONSTANT.TB1_6_1+"#"+IGSMRDBMCONSTANT.TB1_6_1_2, prid, "1_1"));
//		//��������Ŀ����һ�㣩
//		String value4 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
//				map, IGSMRDBMCONSTANT.TB4_1+"#"+IGSMRDBMCONSTANT.TB4_1_1+"#"+IGSMRDBMCONSTANT.TB4_1_1_2
//				+"#"+IGSMRDBMCONSTANT.TB4_1_1_2_1+"#"+IGSMRDBMCONSTANT.TB4_1_1_2_1_2, prid, "1_1_1_1"));
		
		//���������Ŀ�����ش�
		String value5 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_6+"#"+IGSMRDBMCONSTANT.TB1_6_1+"#"+IGSMRDBMCONSTANT.TB1_6_1_3, prid, "1_1"));
//		//���������Ŀ����һ�㣩
//		String value6 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
//				map, IGSMRDBMCONSTANT.TB4_1+"#"+IGSMRDBMCONSTANT.TB4_1_1+"#"+IGSMRDBMCONSTANT.TB4_1_1_3
//				+"#"+IGSMRDBMCONSTANT.TB4_1_1_3_1+"#"+IGSMRDBMCONSTANT.TB4_1_1_3_1_2, prid, "1_1_1_1"));
		
		//����������Ŀ�����ش�
		String value7 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_6+"#"+IGSMRDBMCONSTANT.TB1_6_1+"#"+IGSMRDBMCONSTANT.TB1_6_1_4, prid, "1_1"));
//		//����������Ŀ����һ�㣩
//		String value8 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
//				map, IGSMRDBMCONSTANT.TB4_1+"#"+IGSMRDBMCONSTANT.TB4_1_1+"#"+IGSMRDBMCONSTANT.TB4_1_1_5
//				+"#"+IGSMRDBMCONSTANT.TB4_1_1_5_1+"#"+IGSMRDBMCONSTANT.TB4_1_1_5_1_2, prid, "1_1_1_1"));
		
		//���������Ŀ������
		String value9 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map1, IGSMRDBMCONSTANT.TB6_1+"#"+IGSMRDBMCONSTANT.TB6_1_1+"#"+IGSMRDBMCONSTANT.TB6_1_1_7, 
				prid1, "1_1"));
		
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>");
		sb.append("<YEAR>"+year+"</YEAR>");
		sb.append("<TOTALVALUE>"+value1+"</TOTALVALUE>");
		sb.append("<PERCENTAGE>"+value+"</PERCENTAGE>");
		sb.append("<WORKLOAD>"+value9+"����</WORKLOAD>");
		sb.append("<NAMES><NAME>����������Ŀ</NAME><NAME>�������</NAME><NAME>�����ӳ�</NAME></NAMES>");
		sb.append("<DATAS>");
		String max = df.format(getMax(new Double[]{Double.parseDouble(value3),Double.parseDouble(value5),Double.parseDouble(value7)}));
		
		//sb.append("<DATA MINVALUE=\"0\" MAXVALUE=\""+max+"\" TITLE=\"һ����Ŀ\">");
		//sb.append("<VALUE>"+df.format(Double.parseDouble(value3))+"</VALUE><VALUE>"+df.format(Double.parseDouble(value3))+"</VALUE><VALUE>"+df.format(Double.parseDouble(value7))+"</VALUE></DATA>");
		sb.append("<DATA MINVALUE=\"0\" MAXVALUE=\""+max+"\" TITLE=\"�ش���Ŀ\">");
		sb.append("<VALUE>"+df.format(Double.parseDouble(value3))+"</VALUE><VALUE>"+df.format(Double.parseDouble(value5))+"</VALUE><VALUE>"+df.format(Double.parseDouble(value7))+"</VALUE></DATA>");
		sb.append("</DATAS></ROOT>");

		dto.setResult(sb.toString());
		return dto;
	}
	
	/**
	 * �Ҳ�ڶ���������ͼ
	 * �걨
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public IGSMR09DTO getTechnologySort(IGSMR09DTO dto) throws BLException {
		
		String[] qnames = {"һ����","������","������","�ļ���"};
		String prtype = Constants.REGULATORYREPORT_TYPE_SEASON;//��������ID
		
		IGSMR0902Form form = dto.getIgsmr0902Form();
		String year = form.getYear();
		if(StringUtils.isEmpty(year)){
			year = getLastYear(null);//Ĭ�ϻ�ȡ��ǰ��ݵ���һ��
		}
		
		/**
		 * �����ĸ����ȵ�TQ1����ID
		 */
		List<Integer> prid1s = new ArrayList<Integer>();
		for(int i=0 ;i<4 ;i++){
			List temp = flowSearchBL.searchRegulatoryReportInfo(prtype, IGSMRDBMCONSTANT.PDID_TQ1 ,year + "_" + qnames[i], true);
			if(temp.size() == 0){
				prid1s.add(null);
			}else{
				Integer id = Integer.parseInt(temp.get(temp.size() -1).toString());
				prid1s.add(id);
			}
		}
		
		/**
		 * �����ĸ����ȵ�TQ4����ID
		 */
		List<Integer> prid4s = new ArrayList<Integer>();
		for(int i=0 ;i<4 ;i++){
			List temp = flowSearchBL.searchRegulatoryReportInfo(prtype, IGSMRDBMCONSTANT.PDID_TQ4 ,year + "_" + qnames[i] , true);
			if(temp.size() == 0){
				prid4s.add(null);
			}else{
				Integer id = Integer.parseInt(temp.get(temp.size() -1).toString());
				prid4s.add(id);
			}
		}
		
		/**
		 * ����ҵ��ϵͳ
		 */
		Integer prid1 = prid1s.get(3);//ȡ���ļ�������id(TQ1)
		//��˾�˻�
		String value1 = " ";
		//�����˻�
		String value2 = " ";
		if(prid1 != null){
			Map map1 = flowSearchBL.searchProcessTableColumnDef(prid1);
			value1= flowSearchBL.searchPublicTableColumnValue(map1, "����ҵ��ϵͳ��Ҫ����ָ��#6#�˻������䶯��#�˻������䶯1#����#��˾�˻�", prid1, "1_1_1_1_1")+"��";
			value2 = flowSearchBL.searchPublicTableColumnValue(map1, "����ҵ��ϵͳ��Ҫ����ָ��#6#�˻������䶯��#�˻������䶯2#����#�����˻�", prid1, "1_1_1_1_1")+"��";
		}
		double total = 0;
		double total3 = 0;
		int prid1size = 0;
		for (int i = 0; i < prid1s.size(); i++) {
			if(prid1s.get(i) == null) continue;
			Map tempMap = flowSearchBL.searchProcessTableColumnDef(prid1s.get(i));
			String temp = flowSearchBL.searchPublicTableColumnValue(tempMap, "����ҵ��ϵͳ��Ҫ����ָ��#5#��������#��������1#����", prid1s.get(i), "1_1_1_1");
			String temp1 = flowSearchBL.searchPublicTableColumnValue(tempMap, "��������ϵͳ�������#��������ϵͳ�������1#����", prid1s.get(i), "1_1");
			
			total3 = total3 + Double.parseDouble(fixNumber(temp1));
			total = total + Double.parseDouble(fixNumber(temp));
			
			prid1size++;
		}
		String value3 = " ";
		String value9 = " ";
		if(prid1size != 0){
			value3 = computDivide(total, prid1size*90.0) + "���";
			value9 = computDivide(total3, prid1size*90.0) + "��";
		}
		
		/**
		 * �ֻ�����ҵ��
		 */
		Integer prid4 = prid4s.get(3);//ȡ���ļ�������id(TQ4)
		String value4 = " ";
		//��ҵ�������п�����
		String value7 = " ";
		//�����������п�����
		String value8 = " ";
		if(prid4 != null){
			Map map4 = flowSearchBL.searchProcessTableColumnDef(prid4);
			value4 = flowSearchBL.searchPublicTableColumnValue(map4, "����������Ҫҵ���ģ#�ֻ�����#����", prid4, "1_1") + "��";
			
			/**
			 * ��������ҵ�� part.1
			 */
			value7 = flowSearchBL.searchPublicTableColumnValue(map4, "����������Ҫҵ���ģ#��������#����", prid4, "1_1") + "��";
			value8 = flowSearchBL.searchPublicTableColumnValue(map4, "����������Ҫҵ���ģ#��������#����", prid4, "1_2") + "��";
		}
		
		double total1 = 0;
		double total2 = 0;
		double total4 = 0;
		int prid4size = 0;
		for (int i = 0; i < prid4s.size(); i++) {
			if(prid4s.get(i) == null) continue;
			Map tempMap = flowSearchBL.searchProcessTableColumnDef(prid4s.get(i));
			String temp1 = flowSearchBL.searchPublicTableColumnValue(tempMap, "��Ҫ���ӽ��ױ���#�ֻ�����#����", prid4s.get(i), "1_1");
			String temp2 = flowSearchBL.searchPublicTableColumnValue(tempMap, "��Ҫ���ӽ��׽��#�ֻ�����#����", prid4s.get(i), "1_1");
			total1 = total1 + Double.parseDouble(fixNumber(temp1));
			total2 = total2 + Double.parseDouble(fixNumber(temp2));
			
			String temp3 = flowSearchBL.searchPublicTableColumnValue(tempMap, "��Ҫ���ӽ��׽��#��������#��������1#����", prid4s.get(i), "1_1_1");
			String temp4 = flowSearchBL.searchPublicTableColumnValue(tempMap, "��Ҫ���ӽ��׽��#��������#��������2#����", prid4s.get(i), "1_1_1");
			
			total4 = total4 + Double.parseDouble(fixNumber(temp3)) + Double.parseDouble(fixNumber(temp4));
			
			prid4size++;
		}
		String value5 = " ";
		String value6 = " ";
		String value10 = " ";
		if(prid4size != 0){
			value5 = computDivide(total1, prid4size*90.0) + "���";
			value6 = computDivide(total2, prid4size*90.0) + "��Ԫ";
			
			value10 = computDivide(total4, prid4size*90.0) + "��Ԫ";
		}
		

		String value = getStr(new String[]{value1 , value2 ,value3 , value4 , value5 , value6 , value7 , 
			value8 , value9 , value10});
		
		dto.setResult(value);
		return dto;
	}
	
	/**
	 * ���ڶ��еڶ�����ͼ
	 * �걨
	 */
	public IGSMR09DTO getTechnologyAudit(IGSMR09DTO dto) throws BLException {
		
		String pdid = IGSMRDBMCONSTANT.PDID_TB3;
		Integer prid = getYearPrid(dto, pdid);
		if(prid == null) return dto;
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPrid(prid);
		cond.setPvcolname("��Ŀ����");
		IG898BL ig898BL = (IG898BL) WebApplicationSupport.getBean("ig898BL");
		List<IG898Info> ig898List = ig898BL.searchIG898(cond);
		List<List> findList = new ArrayList<List>();
		List<List> changeList = new ArrayList<List>();
		if(ig898List != null && ig898List.size()>0){
			for(int i = 0;i<ig898List.size();i++){
				List list = (List) flowSearchBL.searchPublicTableValue(//[{��=12, ��=16, ��=8}, {��=12, ��=16, ��=8}]
						IGSMRDBMCONSTANT.TB3_1+"#"+IGSMRDBMCONSTANT.TB3_1_10, prid,(i+1)+"");
				findList.add(list);
				List list1 = (List) flowSearchBL.searchPublicTableValue(//[{��=12, ��=16, ��=8}, {��=12, ��=16, ��=8}]
						IGSMRDBMCONSTANT.TB3_1+"#"+IGSMRDBMCONSTANT.TB3_1_11, prid, (i+1)+"");
				changeList.add(list1);
			}
			//����ܺ�
			int value1 = 0;
			int value2 = 0;
			for(int sjCountIndex = 0;sjCountIndex<findList.size();sjCountIndex++){
				List findList1 = findList.get(sjCountIndex);
				for(int findCountIndex = 0;findCountIndex<findList1.size();findCountIndex++){
					Map map = (Map) findList1.get(findCountIndex);
					for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
						String key = (String) iterator.next();
						String buf = (String)map.get(key);
						value1 = value1 + Integer.parseInt(fixNumber(buf));
					}
				}
			}
			
			for(int zgCountIndex = 0;zgCountIndex<findList.size();zgCountIndex++){
				List changeList1 = changeList.get(zgCountIndex);
				for(int changeCountIndex = 0;changeCountIndex<changeList1.size();changeCountIndex++){
					Map map = (Map) changeList1.get(changeCountIndex);
					for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
						String key = (String) iterator.next();
						String buf = (String)map.get(key);
						value2 = value2 + Integer.parseInt(fixNumber(buf));
					}
				}
			}
			//δ������
			int value3 = value1 - value2;
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>");
			sb.append("<AUDITNUMBER>"+ig898List.size()+"</AUDITNUMBER>");
			sb.append("<PRODUCT name=\"����������("+value2+")\" data=\""+computPercent(value2, value1)+"\" />");
			sb.append("<PRODUCT name=\"δ��������("+value3+")\" data=\""+computPercent(value3, value1)+"\" /></ROOT>");
			dto.setResult(sb.toString());
		}
		

//		//����ܺ�
//		int value1 = 0;
//		for(int i =0;i<list.size();i++){
//			Map map = (Map) list.get(i);
//			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
//				String key = (String) iterator.next();
//				String buf = (String)map.get(key);
//				value1 = value1 + Integer.parseInt(fixNumber(buf));
//			}
//		}
//		
//		
//		List list1 = (List) flowSearchBL.searchPublicTableValue(//[{��=12, ��=16, ��=8}, {��=12, ��=16, ��=8}]
//				IGSMRDBMCONSTANT.TB3_1+"#"+IGSMRDBMCONSTANT.TB3_1_11, prid, "1");
//		//�Ѿ�������
//		int value2 = 0;
//		for(int i =0;i<list1.size();i++){
//			Map map = (Map) list1.get(i);
//			for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
//				String key = (String) iterator.next();
//				String buf = (String)map.get(key);
//				value2 = value2 + Integer.parseInt(fixNumber(buf));
//			}
//		}
//		
//		//δ������
//		int value3 = value1 - value2;
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>");
//		sb.append("<AUDITNUMBER>"+value1+"</AUDITNUMBER>");
//		sb.append("<PRODUCT name=\"����������("+value2+")\" data=\""+computPercent(value2, value1)+"\" />");
//		sb.append("<PRODUCT name=\"δ��������("+value3+")\" data=\""+computPercent(value3, value1)+"\" /></ROOT>");
//		
//		dto.setResult(sb.toString());
		return dto;
	}
	
	/**
	 * ����ٷֱ�
	 * @param y ����
	 * @param z ��ĸ
	 * @return
	 */
	private String computPercent(int y,int z){
		   String baifenbi="";//���ܰٷֱȵ�ֵ
		   double baiy=y*1.0;
		   double baiz=z*1.0;
		   double fen=baiy/baiz;
		   DecimalFormat df1 = new DecimalFormat("##.0%");   
		   baifenbi= df1.format(fen);  
		   return baifenbi.split("%")[0];
	}
	
	/**
	 * �������㱣����λС��
	 * @param y
	 * @param z
	 * @return
	 */
	private static String computDivide(double y,double z){
		   String baifenbi="";//���ܰٷֱȵ�ֵ
		   double fen=y/z;
		   DecimalFormat df1 = new DecimalFormat("0.0");   
		   baifenbi= df1.format(fen);  
		   return baifenbi;
	}
	
	/**
	 * ����ת��
	 * @param list
	 * @return
	 */
	private Double[] turnListToArrDouble(List<Double> list){
		Double[] arr = new Double[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	/**
	 * ����ת��(����)
	 * @param list
	 * @return
	 */
	private Integer[] turnListToArrInt(List<Integer> list){
		Integer[] arr = new Integer[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}
	
	/**
	 * �ҳ��������(С��)
	 * @param nums
	 * @return
	 */
	private Double getMax(Double[] nums){
		Double max = nums[0];
		for(Double num:nums){
			if(num > max) max = num;
		}
		return max;
	}
	
	/**
	 * �ҳ��������(����)
	 * @param nums
	 * @return
	 */
	private Integer getMax(Integer[] nums){
		Integer max = nums[0];
		for(Integer num:nums){
			if(num > max) max = num;
		}
		return max;
	}
	
	 
  
	/**
	 * ��ȡ���
	 * 
	 * @param dateTime
	 * @return
	 */
	private static int getYear() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int year = c.get(Calendar.YEAR);
		return year;
	}
    
    /**
     * ��ȡĳһ�����һ�꣬Ĭ��Ϊ�������һ��
     * @return
     */
    private static String getLastYear(Integer year){
    	Calendar ca = Calendar.getInstance();//�õ�һ��Calendar��ʵ��  
    	if(year != null) ca.set(Calendar.YEAR, year);
    	ca.add(Calendar.YEAR, -1); //��ݼ�1  
    	Date date = ca.getTime(); //��� 
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy");  
    	
    	return sf.format(date);
    }
    
	/**
	 * ��ȡ�ϸ����ȵ�T-Q-2��������ID
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private Integer getTQ2QuarterPrid(IGSMR09DTO dto) throws BLException {
		
		String pdid = IGSMRDBMCONSTANT.PDID_TQ2;//���̶���ID
		String prtype = Constants.REGULATORYREPORT_TYPE_SEASON;//��������ID
		
		IGSMR0903Form form = dto.getIgsmr0903Form();
		String year = form.getYear();
		String quarter = form.getQuarter();//��ʽӦΪ��һ�����������������������ġ�
		String time = "";
		if(StringUtils.isEmpty(year) || StringUtils.isEmpty(quarter)){
			time = getTime(1,null).get(0);
		}else{
			time = year + "_"+quarter+"����";
		}
		
		List list = flowSearchBL.searchRegulatoryReportInfo(prtype, pdid ,time, true);
		if(list.size() == 0){
			return null;
		}
		Integer prid = Integer.parseInt(list.get(list.size()-1).toString());
		
		return prid;
	}
    
    
	/**
	 * ��Ϣ�Ƽ���Ŀ��������
	 * ϵͳ���ռ��
	 * ����ͼ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getQuarAnalysePieGraph(IGSMR09DTO dto) throws BLException {
		
		/**
		 * 1 �趨��ز���
		 */
		Integer prid = getTQ2QuarterPrid(dto);
		if(prid == null) return dto; 
		IGSMR0903Form form = dto.getIgsmr0903Form();
		String temp = form.getProjectAttr();
		String projectAttr = "";
		String sign = "";
		projectAttr = IGSMRDBMCONSTANT.TQ2_2;
		if(StringUtils.isEmpty(temp)){
		}else{
			sign = temp;
		}
		
		Map<String,Integer> valueMap = new HashMap<String,Integer>();
		
		/**
		 * 2 ��֯����
		 */
		List list = (List) flowSearchBL.searchPublicTableValue(projectAttr , prid, null);
		index:
		for(int i = 0; i < list.size();i++){
			Map temp1 = (Map) list.get(i);
			Map temp2 = (Map)((List)temp1.get(projectAttr)).get(0);
			if(StringUtils.isNotEmpty(sign)){
				if(sign.equals(((String)temp2.get("������ʵʩ���")).replace("#", ""))){
					Map temp3 = (Map)((List)temp2.get("��������")).get(0);
					for (Iterator iterator = temp3.keySet().iterator(); iterator.hasNext();) {
						String key1 = (String) iterator.next();
						List tempList = (List)temp3.get(key1);
						if(tempList.size() == 0) 
							continue index;
						Map temp4 = (Map)(tempList).get(0);
						String temp5 = (String)temp4.get("ϵͳ���");
						if(StringUtils.isNotEmpty(temp5)){//�����Ϊ�գ���˵������Ϊ��ѡ�����
							if(valueMap.get(temp5) == null){
								valueMap.put(temp5, 1);
							}else{
								valueMap.put(temp5, valueMap.get(temp5)+1);
							}
							continue index;
						}
					}
				}
			}else{
				Map temp3 = (Map)((List)temp2.get("��������")).get(0);
				for (Iterator iterator = temp3.keySet().iterator(); iterator.hasNext();) {
					String key1 = (String) iterator.next();
					List tempList = (List)temp3.get(key1);
					if(tempList.size() == 0) 
						continue index;
					Map temp4 = (Map)(tempList).get(0);
					String temp5 = (String)temp4.get("ϵͳ���");
					if(StringUtils.isNotEmpty(temp5)){//�����Ϊ�գ���˵������Ϊ��ѡ�����
						if(valueMap.get(temp5) == null){
							valueMap.put(temp5, 1);
						}else{
							valueMap.put(temp5, valueMap.get(temp5)+1);
						}
						continue index;
					}
				}
			}
			
		}

		/**
		 * 3 ƴװXML
		 */
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>");
		
		int total = 0;
		for (Iterator iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			total = total + valueMap.get(key);
		}
		sb.append("<DATA TOTALVALUE=\""+total+"\">");
		for (Iterator iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			int value = valueMap.get(key);
			sb.append("<VALUE NAME=\""+key+" "+ value +"\">"
					+ value +"</VALUE>");
		}
		sb.append("</DATA></ROOT>");
		
		dto.setResult(sb.toString());
		
		return dto;
	}
	
	/**
	 * ��Ϣ�Ƽ���Ŀ��������
	 * ��һ����Ŀ�������
	 * �Ҳ�����ͼ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getQuarAnalyseTrendGraph(IGSMR09DTO dto) throws BLException {
		
		/**
		 * 1 ���ò���
		 */
		String pdid = IGSMRDBMCONSTANT.PDID_TQ2;//���̶���ID 
		String prtype = Constants.REGULATORYREPORT_TYPE_SEASON;//��������ID
		
		IGSMR0903Form form = dto.getIgsmr0903Form();
		String year = form.getYear();
		String quarter = form.getQuarter();//��ʽӦΪ��һ�����������������������ġ�
		List<String> times;
		if(StringUtils.isEmpty(year) || StringUtils.isEmpty(quarter)){
			times = getTime(4,null);//Ĭ��ȡ��ǰʱ�����4������
		}else{
			int quarterVal = 0;
			if("һ".equals(quarter)) quarterVal = 1;
			else if("��".equals(quarter)) quarterVal = 2;
			else if("��".equals(quarter)) quarterVal = 3;
			else if("��".equals(quarter)) quarterVal = 4;
			String queryStr = year + "#" + quarterVal;
			times = getTime(4,queryStr);//Ĭ��ȡ��ǰʱ�����4������
		}
		List<Integer> prids = new ArrayList<Integer>();
		String[] qs = new String[times.size()];//4�����ȵ��ַ���
		for(int i =0 ;i < times.size(); i++){
			List list = flowSearchBL.searchRegulatoryReportInfo(prtype, pdid ,times.get(i),true);
			if(list.size() != 0 && list.get(list.size()-1) != null) {
				prids.add(Integer.parseInt(list.get(list.size()-1).toString()));
			}else prids.add(null);
			qs[i] = times.get(i).replace("_", "");
		}
//		if(prids.size() < 4) {
//			log.debug(">>>>>>>>>>>>>>>�������ݲ�ȫ<<<<<<<<<<<<<<<<");
//			return dto;
//		}
		String[] projectAttrs = {"����","ִ����","�����"};
//		String[] wholeProjectAttrs = {IGSMRDBMCONSTANT.TQ2_1,IGSMRDBMCONSTANT.TQ2_2,IGSMRDBMCONSTANT.TQ2_3};
		
		
		/**
		 * 2 ��֯����
		 */
		Map<String,List<Integer>> valueMap = new LinkedHashMap<String,List<Integer>>();//���ݴ洢��ʽ�������ʼ�Ĵ��˳��
		List<Integer> newList = new ArrayList<Integer>();
		List<Integer> ingList = new ArrayList<Integer>();
		List<Integer> overList = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {//List��˳��Ϊ�ӹ�ȥ������
			String star ="";
			String ing ="";
			String over ="";
			Integer prid = prids.get(i);
			if(prid != null){
			List list = (List) flowSearchBL.searchPublicTableValue("�������������ش���Ŀ" , prid, null);
				for(int a = 0;a<list.size();a++){
					Map map = (Map) list.get(a);
					for (Iterator iterator1 = map.keySet().iterator(); iterator1.hasNext();) {
						String key1 = (String) iterator1.next();
						List valueList = (List)map.get(key1);
						for (int h = 0; h < valueList.size(); h++) {
							String value =  ((String) ((Map)valueList.get(h)).get("������ʵʩ���")).replace("#", "");
							if(StringUtils.isNotEmpty(value)&&"����".equals(value))star = star +"#";
							if(StringUtils.isNotEmpty(value)&&"ִ����".equals(value))ing = ing +"#";
							if(StringUtils.isNotEmpty(value)&&"�����".equals(value))over = over +"#";
						}
					}	
				}
				if(star.length()>0){
					newList.add(star.length());
				}else{
					newList.add(0);
				}
				if(ing.length()>0){
					ingList.add(ing.length());
				}else{
					ingList.add(0);
				}
				if(over.length()>0){
					overList.add(over.length());
				}else{
					overList.add(0);
				}
			}else{
				ingList.add(0);
				overList.add(0);
				newList.add(0);
			}
		}
		valueMap.put("����", newList);
		valueMap.put("ִ����", ingList);
		valueMap.put("�����", overList);
		
		/**
		 * 3 ƴװXML
		 */
		Integer[] tempArr = new Integer[prids.size()*projectAttrs.length];//�����е�ֵ�������飬�ԱȽ����ֵ
		int tempIndex = 0;
		for (Iterator<String> iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
			String key = iterator.next();
			List<Integer> tempList = valueMap.get(key);
			for(int i =0;i<tempList.size();i++){
				tempArr[tempIndex++] = tempList.get(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT><LINES MINVALUE=\"0\" MAXVALUE=\""+getMax(tempArr)+"\">");
		for (Iterator<String> iterator = valueMap.keySet().iterator(); iterator.hasNext();) {
			String name = iterator.next();
			List<Integer> tempList = valueMap.get(name);
			sb.append("<LINE MINVALUE=\"0\" MAXVALUE=\""+getMax(turnListToArrInt(tempList))+"\" UNIT=\"(��)\" TITLE=\""+name+"\">");
			for (int i = 0; i < tempList.size(); i++) {
				sb.append("<VALUE MONTH=\""+qs[i]+"\">"+tempList.get(i)+"</VALUE>");
			}
			sb.append("</LINE>");
		}
		sb.append("</LINES></ROOT>");
		
		dto.setResult(sb.toString());
		return dto;
	}
    
	/**
	 * ��Ϣ�Ƽ���Ŀ��������
	 * ��Ŀ��ϸ
	 * �ϲ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getQuarAnalyseGridGraph(IGSMR09DTO dto) throws BLException {
		
		/**
		 * 1 �趨��ز���
		 */
		Integer prid = getTQ2QuarterPrid(dto);
		if(prid == null) return dto; 
		String[] wholeProjectAttrs = {IGSMRDBMCONSTANT.TQ2_2};
		/**
		 * ��֯���ݺ�ƴװXML
		 */
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < wholeProjectAttrs.length; i++) {//������Ŀ���
			List list = (List) flowSearchBL.searchPublicTableValue(wholeProjectAttrs[i] , prid, null);
			index:
			for(int j = 0; j < list.size();j++){
				num++;
				Map temp1 = (Map) list.get(j);
				String sort = "";
				
				/***��ȡ�����Ϣ��ʼ***/
				Map temp2 = (Map)((List)temp1.get(wholeProjectAttrs[i])).get(0);
				Map temp3 = (Map)((List)temp2.get("��������")).get(0);
				for (Iterator iterator = temp3.keySet().iterator(); iterator.hasNext();) {
					String key1 = (String) iterator.next();
					List tempList = (List)temp3.get(key1);
					if(tempList.size() == 0) break;
					Map temp4 = (Map)(tempList).get(0);
					String temp5 = (String)temp4.get("ϵͳ���");
					if(StringUtils.isNotEmpty(temp5)){//�����Ϊ�գ���˵������Ϊ��ѡ�����
						sort = temp5;
						break;
					}
				}
				/***��ȡ�����Ϣ����***/
				
				
				String touru = "";
				if(StringUtils.isNotEmpty((String)temp2.get("��ͬ���"))) touru = temp2.get("��ͬ���") + "��Ԫ";
				String name = "";
				if(temp2.get("��Ŀ����") != null) name = (String) temp2.get("��Ŀ����");
				String moshi = "";
				if(temp2.get("ʵʩģʽ") != null) moshi = (String) temp2.get("ʵʩģʽ");
				String shishi = "";
				if(temp2.get("������ʵʩ���") != null) shishi = (String) temp2.get("������ʵʩ���");
				if(StringUtils.isEmpty(name) && StringUtils.isEmpty(sort) && StringUtils.isEmpty(touru) &&
						StringUtils.isEmpty(moshi)&&StringUtils.isEmpty(shishi)){
					num--;
					continue index;
				}
				//ƴװ����
				sb.append("<dg>");
				sb.append("<a1>"+num+"</a1><a2>"+name+"</a2><a3>"+shishi.replace("#", "")+"</a3><a4>"+sort+"</a4>" +
						"<a5>"+touru+"</a5><a6>"+moshi+"</a6>");
				sb.append("</dg>\n");
			}
		}
		dto.setResult(sb.toString());
		System.out.println(dto.getResult());
		return dto;
	}
	
    /**
     * ��ȡǰn������
     * @param month
     * @return
     */
    private static List<String> getTime(int n , String queryStr){ 
    	
    	int valueflag;
        Calendar c=Calendar.getInstance();
        int month=c.get(Calendar.MONTH)+1;
        int quarter = 0;  
        String result = "";
        String quarterStr = "";
        List<String> results = new ArrayList<String>();
        
        if(month >=1 && month <=3){     
            quarter=1;     
        }     
        if(month >=4 && month <=6){     
            quarter=2;       
        }     
        if(month >=7 && month <=9){     
            quarter = 3;     
        }     
        if(month >=10 && month <=12){     
            quarter = 4;     
        }
        int value = quarter - 1;//Ĭ��Ϊ��ǰʱ�����һ����
        if(StringUtils.isNotEmpty(queryStr)) value = Integer.parseInt(queryStr.split("#")[1]);//����ָ����ĳ�����ȿ�ʼ
        String year;
        if(StringUtils.isEmpty(queryStr)) year = String.valueOf(getYear());
        else year = queryStr.split("#")[0];
        for(int i =0; i< n ; i++){
	        valueflag = value;
	        if(value == 0) value = 4;
	        
	        switch (value) {
				case 1:
					quarterStr = "һ����";
					break;
					
				case 2:
					quarterStr = "������";
					break;
					
				case 3:
					quarterStr = "������";
					break;
					
				case 4:
					quarterStr = "�ļ���";
					break;
			}
	        
	        if(valueflag == 0) 
	        	year = getLastYear(Integer.parseInt(year));
	        
	        result = year + "_" + quarterStr;
	        results.add(result);
	        value--;
        }
        Collections.reverse(results);
        return results;
    }
    
    /**
     * ƴ���ַ���
     * @return
     */
    private static String getStr(String[] list){
    	StringBuilder builder = new StringBuilder();
    	for(int i = 0; i< list.length ; i++){
    		if(StringUtils.isEmpty(list[i])) builder.append("");
    		else builder.append(list[i]);
    		if(i < list.length -1) builder.append("#");
    	}
    	return builder.toString();
    }

    /**
     * �޲�����
     * @param num
     * @return
     */
    private static String[] fixNumber(String[] num){
    	for (int i = 0; i < num.length; i++) {
        	if(StringUtils.isEmpty(num[i])) num[i] = "0";
        	if(num[i].endsWith(".")) num[i] = num[i] + "0";
		}
    	return num;
    }
    
    private static String fixNumber(String num){
    	if(StringUtils.isEmpty(num)) num = "0";
    	if(num.endsWith(".")) num = num + "0";
    	return num;
    }
    
    private static String fixNullStr(String str){
    	if(str == null) str = "";
    	return str;
    }
    
    /**
     * ����
     * @param args
     */
    public static void main(String[] args) {
//    	System.out.println(fixNumber("34.2"));
//    	Object o1 = 1;
//    	Object o2 = 2;
//    	Object o3 = o1+o2;
//    	System.out.println(o3);
    	String a = null;
    	System.out.println(fixNumber(a));
	}


}
