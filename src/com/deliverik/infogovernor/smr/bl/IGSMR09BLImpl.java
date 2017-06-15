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
 * 概述:非现场监管报表DashBoard后台处理
 * 创建人：王省
 * 创建记录： 2013-09-10
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
	 * 获取上个季度的T-Q-4季报流程ID
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private Integer getQuarterPrid(IGSMR09DTO dto) throws BLException {
		
		String pdid = IGSMRDBMCONSTANT.PDID_TQ1;//流程定义ID
		String prtype = Constants.REGULATORYREPORT_TYPE_SEASON;//流程类型ID
		
		IGSMR0901Form form = dto.getIgsmr0901Form();
		String year = form.getYear();
		String quarter = form.getQuarter();//格式应为“一”、“二”、“三”、“四”
		String time = "";
		if(StringUtils.isEmpty(year) || StringUtils.isEmpty(quarter)){
			time = getTime(1,null).get(0);
		}else{
			time = year + "_"+quarter+"季度";
		}
		
		List<Integer> list = flowSearchBL.searchRegulatoryReportInfo(prtype, pdid ,time, true);
		if(list.size() == 0){
			return null;
		}
		Integer prid = Integer.parseInt(list.get(list.size()-1)+"");
		
		return prid;
	}

	/**
	 * 电子交易笔数合计
	 * 季报
	 */
	public IGSMR09DTO getElecTransTotal(IGSMR09DTO dto) throws BLException {
		
		Integer prid = getQuarterPrid(dto);
		if(prid == null) return dto;
		
		Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
		//数量
		String count = new DecimalFormat("0").format(Double.parseDouble(flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#合计#1#数量", prid, "1_1_1")));
		//金额
		String money = new DecimalFormat("0").format(Double.parseDouble(flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易金额#合计#1#数量", prid, "1_1_1")));
		
		String arr[] = fixNumber(new String[]{count,money});
		
		String value = getStr(arr);  
		dto.setResult(value);
		
		return dto;
	} 
	
	/**
	 * 跨行交易分析（笔数）
	 * 季报 
	 */
	public IGSMR09DTO getMultiBankTransCount(IGSMR09DTO dto) throws BLException {
		
		Integer prid = getQuarterPrid(dto);
		if(prid == null) return dto;
		Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
		
		/** ATM他代本 */
		String atm1_1 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#他代本#1#数量", prid, "1_1_1_1");
		String atm1_2 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#他代本#1#环比", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(atm1_2)) atm1_2 =atm1_2 + "%";
		String atm1_3 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#他代本#2#数量", prid, "1_1_1_1");
		String atm1_4 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#他代本#2#环比", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(atm1_4)) atm1_4 =atm1_4 + "%";
		/** ATM 本代他*/
		String atm2_1 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#本代他#1#数量", prid, "1_1_1_1");
		String atm2_2 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#本代他#1#环比", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(atm2_2)) atm2_2 =atm2_2 + "%";
		String atm2_3 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#本代他#2#数量", prid, "1_1_1_1");
		String atm2_4 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#本代他#2#环比", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(atm2_4)) atm2_4 =atm2_4 + "%";
		
//		/** 网上银行-个人网上银行 */
//		String pos1_1 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#个人网上银行#1#数量", prid, "1_1_1_1");
//		String pos1_2 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#个人网上银行#1#环比", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(pos1_2)) pos1_2 =pos1_2 + "%";
//		String pos1_3 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#个人网上银行#2#数量", prid, "1_1_1_1");
//		String pos1_4 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#个人网上银行#2#环比", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(pos1_4)) pos1_4 =pos1_4 + "%";
//		
//		/** 网上银行-企业网上银行 */
//		String pos2_1 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#企业网上银行#1#数量", prid, "1_1_1_1");
//		String pos2_2 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#企业网上银行#1#环比", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(pos2_2)) pos2_2 =pos2_2 + "%";
//		String pos2_3 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#企业网上银行#2#数量", prid, "1_1_1_1");
//		String pos2_4 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#企业网上银行#2#环比", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(pos2_4)) pos2_4 =pos2_4 + "%";
		
		String[] arr = new String[]{atm1_1, atm1_2 ,"0" ,atm1_3 , atm1_4 , "0" ,
				atm2_1 , atm2_2, "0" , atm2_3 , atm2_4 , "0"};
		String value = getStr(arr);
		dto.setResult(value);
		return dto;
	}
	
	/**
	 * 跨行交易分析（金额）
	 * 季报 
	 */
	public IGSMR09DTO getMultiBankTransMoney(IGSMR09DTO dto) throws BLException {
		
		Integer prid = getQuarterPrid(dto);
		if(prid == null) return dto;
		Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
		
//		/** ATM他代本 */
//		String atm1_1 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#他代本#1#数量", prid, "1_1_1_1");
//		String atm1_2 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#他代本#1#环比", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(atm1_2)) atm1_2 =atm1_2 + "%";
//		String atm1_3 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#本代他#2#数量", prid, "1_1_1_1");
//		String atm1_4 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#本代他#2#环比", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(atm1_4)) atm1_4 =atm1_4 + "%";
//		/** ATM 本代他*/
//		String atm2_1 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#本代他#1#数量", prid, "1_1_1_1");
//		String atm2_2 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#本代他#1#环比", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(atm2_2)) atm2_2 =atm2_2 + "%";
//		String atm2_3 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#本代他#2#数量", prid, "1_1_1_1");
//		String atm2_4 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#ATM#本代他#2#环比", prid, "1_1_1_1");
//		if(StringUtils.isNotEmpty(atm2_4)) atm2_4 =atm2_4 + "%";
		
		/** 网上银行-个人网上银行 */
		String pos1_1 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#个人网上银行#1#数量", prid, "1_1_1_1");
		String pos1_2 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#个人网上银行#1#环比", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(pos1_2)) pos1_2 =pos1_2 + "%";
		String pos1_3 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#个人网上银行#2#数量", prid, "1_1_1_1");
		String pos1_4 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#个人网上银行#2#环比", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(pos1_4)) pos1_4 =pos1_4 + "%";
		
		/** 网上银行-企业网上银行 */
		String pos2_1 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#企业网上银行#1#数量", prid, "1_1_1_1");
		String pos2_2 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#企业网上银行#1#环比", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(pos2_2)) pos2_2 =pos2_2 + "%";
		String pos2_3 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#企业网上银行#2#数量", prid, "1_1_1_1");
		String pos2_4 = flowSearchBL.searchPublicTableColumnValue(map, "主要电子交易笔数#网上银行#企业网上银行#2#环比", prid, "1_1_1_1");
		if(StringUtils.isNotEmpty(pos2_4)) pos2_4 =pos2_4 + "%";
		
		String[] arr = new String[]{pos1_1, pos1_2 ,"0" ,pos1_3 , pos1_4 , "0" ,
				pos2_1 , pos2_2, "0" , pos2_3 , pos2_4 , "0"};
		
		String value = getStr(arr);
		dto.setResult(value);
		return dto;
	}
	
	/**
	 * 交易笔数趋势分析
	 * 季报 
	 */
	public IGSMR09DTO getMultiBankTransCountTrend(IGSMR09DTO dto) throws BLException {
		String xml = getTrend(dto,1);   
		dto.setResult(xml);
		return dto;
	}
	
	/**
	 * 交易金额趋势分析
	 * 季报 
	 */
	public IGSMR09DTO getMultiBankTransMoneyTrend(IGSMR09DTO dto) throws BLException {
		String xml = getTrend(dto,2);
		dto.setResult(xml);
		return dto;
	}
	
	/**
	 * 私有方法
	 * 交易笔数或金额趋势分析
	 */
	private String getTrend(IGSMR09DTO dto,int trendType) throws BLException {
		
		String pdid = IGSMRDBMCONSTANT.PDID_TQ1;//流程定义ID 
		String prtype = Constants.REGULATORYREPORT_TYPE_SEASON;//流程类型ID
		
		IGSMR0901Form form = dto.getIgsmr0901Form();
		String year = form.getYear();
		String quarter = form.getQuarter();//格式应为“一”、“二”、“三”、“四”
		List<String> times;
		if(StringUtils.isEmpty(year) || StringUtils.isEmpty(quarter)){
			times = getTime(5,null);//默认取当前时间的上5个季度
		}else{
			int quarterVal = 0;
			if("一".equals(quarter)) quarterVal = 1;
			else if("二".equals(quarter)) quarterVal = 2;
			else if("三".equals(quarter)) quarterVal = 3;
			else if("四".equals(quarter)) quarterVal = 4;
			String queryStr = year + "#" + quarterVal;
			times = getTime(5,queryStr);//默认取当前时间的上5个季度
		}
		List<Integer> prids = new ArrayList<Integer>();
		String[] qs = new String[times.size()];//五个季度的字符串
		for(int i =0 ;i < times.size();i++){
			List<Integer> list = flowSearchBL.searchRegulatoryReportInfo(prtype, pdid ,times.get(i), true);
			if(list.size() != 0 && list.get(list.size()-1) != null) {
				prids.add(Integer.parseInt(list.get(list.size()-1)+""));
			}else prids.add(null);
			qs[i] = times.get(i).replace("_", "");
		}

		
		String title = "";
		if(trendType == 1) title = "主要电子交易笔数";
		else if(trendType == 2) title = "主要电子交易金额";
		
		//数据存储格式
		Map<String,List<Double>> valueMap = new LinkedHashMap<String,List<Double>>();
		
		String[] names = {"ATM", "POS", "个人网上银行", "企业网上银行" ,"电话银行" ,"手机银行","其他电子银行业务"};
		
//		if(prids.size() < 5){
//			log.debug("------------季度数据不全-------------");
//			return null;
//		}
		
		/**
		 * 获取报表数据
		 */
		for (int i = 0; i < 5; i++) {//List的顺序为从过去到现在
			
			Map<String,Double> tempMap = new HashMap<String,Double>();
			
			Integer prid = prids.get(i);
			
			if(prid != null){
				
				Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
				
				//ATM
				String atm1 = "0";
				String atm2 = "0";
				String atm3 = "0";
				if(trendType == 1){
					 atm1 = flowSearchBL.searchPublicTableColumnValue(map, title+"#ATM#本行#3#数量", prid, "1_1_1_1");
					 atm2 = flowSearchBL.searchPublicTableColumnValue(map, title+"#ATM#他代本#3#数量", prid, "1_1_1_1");
					 atm3 = flowSearchBL.searchPublicTableColumnValue(map, title+"#ATM#本代他#3#数量", prid, "1_1_1_1");
				}else{
					 atm1 = flowSearchBL.searchPublicTableColumnValue(map, title+"#ATM#本行#1#数量", prid, "1_1_1_1");
					 atm2 = flowSearchBL.searchPublicTableColumnValue(map, title+"#ATM#他代本#1#数量", prid, "1_1_1_1");
					 atm3 = flowSearchBL.searchPublicTableColumnValue(map, title+"#ATM#本代他#1#数量", prid, "1_1_1_1");
				}
				atm1 = fixNumber(atm1);
				atm2 = fixNumber(atm2);
				atm3 = fixNumber(atm3);
				Double atm = Double.parseDouble(atm1) + Double.parseDouble(atm2) + Double.parseDouble(atm3);
				tempMap.put(names[0], atm);
				
				//POS
				String pos1 = flowSearchBL.searchPublicTableColumnValue(map, title+"#POS#本行#1#数量", prid, "1_1_1_1");
				String pos2 = flowSearchBL.searchPublicTableColumnValue(map, title+"#POS#他代本#1#数量", prid, "1_1_1_1");
				String pos3 = flowSearchBL.searchPublicTableColumnValue(map, title+"#POS#本代他#1#数量", prid, "1_1_1_1");
				pos1 = fixNumber(pos1);
				pos2 = fixNumber(pos2);
				pos3 = fixNumber(pos3);
				Double pos = Double.parseDouble(pos1) + Double.parseDouble(pos2) + Double.parseDouble(pos3);
				tempMap.put(names[1], pos);
				
				//个人网上银行
				String ebank1 = flowSearchBL.searchPublicTableColumnValue(map, title+"#网上银行#个人网上银行#1#数量", prid, "1_1_1_1");
				tempMap.put(names[2], Double.parseDouble(fixNumber(ebank1)));
				
				//企业网上银行
				String ebank2 = fixNumber(flowSearchBL.searchPublicTableColumnValue(map, title+"#网上银行#企业网上银行#1#数量", prid, "1_1_1_1"));
				tempMap.put(names[3], Double.parseDouble(ebank2));
				
				//电话银行
				String telbank = fixNumber(flowSearchBL.searchPublicTableColumnValue(map, title+"#电话银行#1#数量", prid, "1_1_1"));
				tempMap.put(names[4], Double.parseDouble(telbank));
				
				//手机银行
				String mobelbank = fixNumber(flowSearchBL.searchPublicTableColumnValue(map, title+"#手机银行#1#数量", prid, "1_1_1"));
				tempMap.put(names[5], Double.parseDouble(mobelbank));
				
				//其他电子银行业务
				String otherbank = fixNumber(flowSearchBL.searchPublicTableColumnValue(map, title+"#其他电子银行业务#1#数量", prid, "1_1_1"));
				tempMap.put(names[6], Double.parseDouble(otherbank));
				
				/**
				 * 按类别、季度组装数据
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
				 * 按类别、季度组装数据
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
		 * 拼装XML
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
			sb.append("<LINE MINVALUE=\"0\" MAXVALUE=\""+df.format(getMax(turnListToArrDouble(tempList)))+"\" UNIT=\"(万笔)\" TITLE=\""+name+"\">");
			for (int i = 0; i < tempList.size(); i++) {
				sb.append("<VALUE MONTH=\""+qs[i]+"\">"+df.format(tempList.get(i))+"</VALUE>");
			}
			sb.append("</LINE>");
		}
		sb.append("</LINES></ROOT>");
		return sb.toString();
	
	}
	
	/**
	 * 电子银行业务规模
	 * 季报
	 */
	public IGSMR09DTO getElecWorkScale(IGSMR09DTO dto) throws BLException {
		
		Integer prid = getQuarterPrid(dto);
		if(prid == null) return dto;
		
		List values = (List) flowSearchBL.searchPublicTableValue("电子银行主要业务规模", prid, null);
		Map map = (Map) values.get(0);
		String valueKey1 = "明细";
		String valueKey1plu = "明细项目";
		String valueKey2 = "数量";
		String valueKey3 = "环比";
		String valueKey3plu = "环比增减（%/百分点）";
		String value1 = "";
		String value2 = "";
		String value3 = "";
		String value4 = "";
		StringBuilder sb = new StringBuilder();
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			List list = (List) map.get(key);
			for (int i = 0; i < list.size(); i++) {//atm级别
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
							//value4环比
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
//				if(!"手机银行".equals(key)&&!"POS".equals(key)){
//					for (Iterator iterator1 = valueMap.keySet().iterator(); iterator1.hasNext();) {
//						String key1 = (String) iterator1.next();
//						List valueList = (List)valueMap.get(key1);
//						for (int j = 0; j < valueList.size(); j++) {
//							value1 =  fixNullStr((String) ((Map)valueList.get(j)).get("明细项目"));
//							value2 =  fixNullStr((String) ((Map)valueList.get(j)).get("数量"));
//							value3 =  fixNullStr((String) ((Map)valueList.get(j)).get("同比增减(%)"));
//							if(StringUtils.isNotEmpty(value3)) value3 = value3 + "%";
//							
//							value4 =  fixNullStr((String) ((Map)valueList.get(j)).get("环比增减(%)"));
//							if(StringUtils.isNotEmpty(value4)) value4 = value4 + "%";
//							sb.append(value1 + "#" + value2 + "#" + value3 + "#" + value4 + "#");
//						}
//					}
//				}else{
//					value1 = fixNullStr((String) valueMap.get("明细项目"));
//					value2 = fixNullStr((String) valueMap.get("数量"));
//					value3 = fixNullStr((String) valueMap.get("同比增减(%)"));
//					if(StringUtils.isNotEmpty(value3)) value3 = value3 + "%";
//					else {
//						value3 = fixNullStr((String) valueMap.get("环比增减(%）"));
//						if(StringUtils.isNotEmpty(value3)) value3 = value3 + "%";
//					}
//					value4 = fixNullStr((String) valueMap.get("环比增减(%)"));
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
	 * 获取年报流程ID
	 * @param dto
	 * @param pdid
	 * @return
	 * @throws BLException
	 */
	private Integer getYearPrid(IGSMR09DTO dto ,String pdid) throws BLException {
		
		String prtype = Constants.REGULATORYREPORT_TYPE_YEAR;//流程类型ID
		
		IGSMR0902Form form = dto.getIgsmr0902Form();
		String year = form.getYear();
		if(StringUtils.isEmpty(year)){
			year = getLastYear(null);//默认获取当前年份的上一年
		}
		
		List list = flowSearchBL.searchRegulatoryReportInfo(prtype, pdid ,year, true);
		if(list.size() == 0){
			return null;
		}
		Integer prid = Integer.parseInt(list.get(list.size()-1).toString());
		
		return prid;
	}
	
	/**
	 * 左侧第一行横图
	 * 年报
	 */
	public IGSMR09DTO getTechnologyInfo(IGSMR09DTO dto) throws BLException {
		
		String pdid = IGSMRDBMCONSTANT.PDID_TB1;
		Integer prid = getYearPrid(dto, pdid);
		
		if(prid == null) return dto;
		
		Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
		
		//资产规模
		String value1 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_2+"#"+IGSMRDBMCONSTANT.TB1_2_1+"#"+IGSMRDBMCONSTANT.TB1_2_1_1, prid, "1_1"));
		value1 = new DecimalFormat("0.00").format(Double.parseDouble(value1));
		//网点数量
		String value2 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_2+"#"+IGSMRDBMCONSTANT.TB1_2_1+"#"+IGSMRDBMCONSTANT.TB1_2_1_2, prid, "1_1"));
		value2 = new DecimalFormat("0").format(Double.parseDouble(value2));
		//科技投入
		String value3 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_7+"#"+IGSMRDBMCONSTANT.TB1_7_1+"#"+IGSMRDBMCONSTANT.TB1_7_1_1, prid, "1_1"));
		value3 = new DecimalFormat("0.0").format(Double.parseDouble(value3));
		//占比
		String value4 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_7+"#"+IGSMRDBMCONSTANT.TB1_7_1+"#"+IGSMRDBMCONSTANT.TB1_7_1_11, prid, "1_1"));
		value4 = new DecimalFormat("0.00").format(Double.parseDouble(value4)) + "%";
		String value = getStr(new String[]{value1 ,value2 ,value3 ,value4});
		
		dto.setResult(value);
		return dto;
	}
	
	/**
	 * 右侧第一行横图
	 * 年报 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getPersonnel(IGSMR09DTO dto) throws BLException {
		
		String pdid = IGSMRDBMCONSTANT.PDID_TB1;
		Integer prid = getYearPrid(dto, pdid);
		if(prid == null) return dto;
		
		Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
		//科技人员数量
		String value1 = flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_8+"#"+IGSMRDBMCONSTANT.TB1_8_1+"#"+IGSMRDBMCONSTANT.TB1_8_1_2, prid, "1_1");
		//风险人员数量
		String value2 = flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_10+"#"+IGSMRDBMCONSTANT.TB1_10_1+"#"+IGSMRDBMCONSTANT.TB1_10_1_7, prid, "1_1");
		//审计人员数量
		String value3 = flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_11+"#"+IGSMRDBMCONSTANT.TB1_11_1+"#"+IGSMRDBMCONSTANT.TB1_11_1_6, prid, "1_1");
		
		String value = getStr(new String[]{value1 ,value2 ,value3});
		
		dto.setResult(value);
		
		return dto;
	}
	
	/**
	 * 左侧第二行第一个竖图
	 * 年报
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getTechnologyNumber(IGSMR09DTO dto) throws BLException {
		
		//本年信息系统总数
		String pdid = IGSMRDBMCONSTANT.PDID_TB10;
		Integer prid_10 = getYearPrid(dto, pdid);
		String value1 = "";
		if(prid_10 != null){
			Map<String, ProcessInfoDefinitionInfo> map_10 = flowSearchBL.searchProcessTableColumnDef(prid_10);
			value1 = flowSearchBL.searchPublicTableColumnValue(
					map_10, IGSMRDBMCONSTANT.TB10_1+"#"+IGSMRDBMCONSTANT.TB10_1_1+"#"+IGSMRDBMCONSTANT.TB10_1_1_1+"#"+IGSMRDBMCONSTANT.TB10_1_1_1_1, prid_10, "1_1_1");
		}
		
		//外包商总数
		pdid = IGSMRDBMCONSTANT.PDID_TB12;
		Integer prid_12 = getYearPrid(dto, pdid);
		String value2 = "";
		if(prid_12 != null){
			Map<String, ProcessInfoDefinitionInfo> map_12 = flowSearchBL.searchProcessTableColumnDef(prid_12);
		    value2 = flowSearchBL.searchPublicTableColumnValue(
				map_12, "信息科技外包风险管理#信息科技外包风险管理架构#内容#本年度重要信息科技外包服务提供商数量".trim(), prid_12, "1_1_1");
		}
		
		//制度总数
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
	 * 科技投入占比分析
	 * 左侧第三行饼图
	 * 年报
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getPieGraph(IGSMR09DTO dto) throws BLException {
		
		
		String pdid = IGSMRDBMCONSTANT.PDID_TB1;
		Integer prid = getYearPrid(dto , pdid);
		if(prid == null) return dto; 
		//机构信息科技投入
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
	 * 信息科技人力资源投入
	 * 最下面的饼图
	 * 年报
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getPieGraph1(IGSMR09DTO dto) throws BLException {
		
		
		String pdid = IGSMRDBMCONSTANT.PDID_TB1;
		Integer prid = getYearPrid(dto , pdid);
		if(prid == null) return dto; 
		//机构信息科技投入
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
	 * 年度项目情况
	 * 右侧第三行柱图
	 * 年报
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
			year = getLastYear(null);//默认获取当前年份的上一年
		}
		IGSMR0902Form form1 = dto.getIgsmr0902Form();
		String year1 = form1.getYear();
		if(StringUtils.isEmpty(year1)){
			year1 = getLastYear(null);//默认获取当前年份的上一年
		}
		
		Map<String, ProcessInfoDefinitionInfo> map = flowSearchBL.searchProcessTableColumnDef(prid);
		Map<String, ProcessInfoDefinitionInfo> map1 = flowSearchBL.searchProcessTableColumnDef(prid1);
		//科技项目总数
		String value1 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_6+"#"+IGSMRDBMCONSTANT.TB1_6_1+"#"+IGSMRDBMCONSTANT.TB1_6_1_1, prid, "1_1"));
		//项目完成率
		String value = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_6+"#"+IGSMRDBMCONSTANT.TB1_6_1+"#"+IGSMRDBMCONSTANT.TB1_6_1_5, prid, "1_1"))+"%";
		//新增立项目数（重大）
		String value3 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_6+"#"+IGSMRDBMCONSTANT.TB1_6_1+"#"+IGSMRDBMCONSTANT.TB1_6_1_2, prid, "1_1"));
//		//新增立项目数（一般）
//		String value4 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
//				map, IGSMRDBMCONSTANT.TB4_1+"#"+IGSMRDBMCONSTANT.TB4_1_1+"#"+IGSMRDBMCONSTANT.TB4_1_1_2
//				+"#"+IGSMRDBMCONSTANT.TB4_1_1_2_1+"#"+IGSMRDBMCONSTANT.TB4_1_1_2_1_2, prid, "1_1_1_1"));
		
		//本年完成项目数（重大）
		String value5 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_6+"#"+IGSMRDBMCONSTANT.TB1_6_1+"#"+IGSMRDBMCONSTANT.TB1_6_1_3, prid, "1_1"));
//		//本年完成项目数（一般）
//		String value6 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
//				map, IGSMRDBMCONSTANT.TB4_1+"#"+IGSMRDBMCONSTANT.TB4_1_1+"#"+IGSMRDBMCONSTANT.TB4_1_1_3
//				+"#"+IGSMRDBMCONSTANT.TB4_1_1_3_1+"#"+IGSMRDBMCONSTANT.TB4_1_1_3_1_2, prid, "1_1_1_1"));
		
		//本年延期项目数（重大）
		String value7 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map, IGSMRDBMCONSTANT.TB1_6+"#"+IGSMRDBMCONSTANT.TB1_6_1+"#"+IGSMRDBMCONSTANT.TB1_6_1_4, prid, "1_1"));
//		//本年延期项目数（一般）
//		String value8 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
//				map, IGSMRDBMCONSTANT.TB4_1+"#"+IGSMRDBMCONSTANT.TB4_1_1+"#"+IGSMRDBMCONSTANT.TB4_1_1_5
//				+"#"+IGSMRDBMCONSTANT.TB4_1_1_5_1+"#"+IGSMRDBMCONSTANT.TB4_1_1_5_1_2, prid, "1_1_1_1"));
		
		//软件开发项目工作量
		String value9 = fixNumber(flowSearchBL.searchPublicTableColumnValue(
				map1, IGSMRDBMCONSTANT.TB6_1+"#"+IGSMRDBMCONSTANT.TB6_1_1+"#"+IGSMRDBMCONSTANT.TB6_1_1_7, 
				prid1, "1_1"));
		
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>");
		sb.append("<YEAR>"+year+"</YEAR>");
		sb.append("<TOTALVALUE>"+value1+"</TOTALVALUE>");
		sb.append("<PERCENTAGE>"+value+"</PERCENTAGE>");
		sb.append("<WORKLOAD>"+value9+"人月</WORKLOAD>");
		sb.append("<NAMES><NAME>新增立项项目</NAME><NAME>本年完成</NAME><NAME>本年延迟</NAME></NAMES>");
		sb.append("<DATAS>");
		String max = df.format(getMax(new Double[]{Double.parseDouble(value3),Double.parseDouble(value5),Double.parseDouble(value7)}));
		
		//sb.append("<DATA MINVALUE=\"0\" MAXVALUE=\""+max+"\" TITLE=\"一般项目\">");
		//sb.append("<VALUE>"+df.format(Double.parseDouble(value3))+"</VALUE><VALUE>"+df.format(Double.parseDouble(value3))+"</VALUE><VALUE>"+df.format(Double.parseDouble(value7))+"</VALUE></DATA>");
		sb.append("<DATA MINVALUE=\"0\" MAXVALUE=\""+max+"\" TITLE=\"重大项目\">");
		sb.append("<VALUE>"+df.format(Double.parseDouble(value3))+"</VALUE><VALUE>"+df.format(Double.parseDouble(value5))+"</VALUE><VALUE>"+df.format(Double.parseDouble(value7))+"</VALUE></DATA>");
		sb.append("</DATAS></ROOT>");

		dto.setResult(sb.toString());
		return dto;
	}
	
	/**
	 * 右侧第二行三个横图
	 * 年报
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public IGSMR09DTO getTechnologySort(IGSMR09DTO dto) throws BLException {
		
		String[] qnames = {"一季度","二季度","三季度","四季度"};
		String prtype = Constants.REGULATORYREPORT_TYPE_SEASON;//流程类型ID
		
		IGSMR0902Form form = dto.getIgsmr0902Form();
		String year = form.getYear();
		if(StringUtils.isEmpty(year)){
			year = getLastYear(null);//默认获取当前年份的上一年
		}
		
		/**
		 * 当年四个季度的TQ1流程ID
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
		 * 当年四个季度的TQ4流程ID
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
		 * 核心业务系统
		 */
		Integer prid1 = prid1s.get(3);//取第四季度流程id(TQ1)
		//公司账户
		String value1 = " ";
		//个人账户
		String value2 = " ";
		if(prid1 != null){
			Map map1 = flowSearchBL.searchProcessTableColumnDef(prid1);
			value1= flowSearchBL.searchPublicTableColumnValue(map1, "核心业务系统重要性能指标#6#账户数及变动表#账户数及变动1#数量#公司账户", prid1, "1_1_1_1_1")+"万户";
			value2 = flowSearchBL.searchPublicTableColumnValue(map1, "核心业务系统重要性能指标#6#账户数及变动表#账户数及变动2#数量#个人账户", prid1, "1_1_1_1_1")+"万户";
		}
		double total = 0;
		double total3 = 0;
		int prid1size = 0;
		for (int i = 0; i < prid1s.size(); i++) {
			if(prid1s.get(i) == null) continue;
			Map tempMap = flowSearchBL.searchProcessTableColumnDef(prid1s.get(i));
			String temp = flowSearchBL.searchPublicTableColumnValue(tempMap, "核心业务系统重要性能指标#5#处理能力#处理能力1#数量", prid1s.get(i), "1_1_1_1");
			String temp1 = flowSearchBL.searchPublicTableColumnValue(tempMap, "网上银行系统运行情况#网上银行系统运行情况1#数量", prid1s.get(i), "1_1");
			
			total3 = total3 + Double.parseDouble(fixNumber(temp1));
			total = total + Double.parseDouble(fixNumber(temp));
			
			prid1size++;
		}
		String value3 = " ";
		String value9 = " ";
		if(prid1size != 0){
			value3 = computDivide(total, prid1size*90.0) + "万笔";
			value9 = computDivide(total3, prid1size*90.0) + "笔";
		}
		
		/**
		 * 手机银行业务
		 */
		Integer prid4 = prid4s.get(3);//取第四季度流程id(TQ4)
		String value4 = " ";
		//企业网银现有开户数
		String value7 = " ";
		//个人网银现有开户数
		String value8 = " ";
		if(prid4 != null){
			Map map4 = flowSearchBL.searchProcessTableColumnDef(prid4);
			value4 = flowSearchBL.searchPublicTableColumnValue(map4, "电子银行主要业务规模#手机银行#数量", prid4, "1_1") + "户";
			
			/**
			 * 网上银行业务 part.1
			 */
			value7 = flowSearchBL.searchPublicTableColumnValue(map4, "电子银行主要业务规模#网上银行#数量", prid4, "1_1") + "户";
			value8 = flowSearchBL.searchPublicTableColumnValue(map4, "电子银行主要业务规模#网上银行#数量", prid4, "1_2") + "户";
		}
		
		double total1 = 0;
		double total2 = 0;
		double total4 = 0;
		int prid4size = 0;
		for (int i = 0; i < prid4s.size(); i++) {
			if(prid4s.get(i) == null) continue;
			Map tempMap = flowSearchBL.searchProcessTableColumnDef(prid4s.get(i));
			String temp1 = flowSearchBL.searchPublicTableColumnValue(tempMap, "主要电子交易笔数#手机银行#数量", prid4s.get(i), "1_1");
			String temp2 = flowSearchBL.searchPublicTableColumnValue(tempMap, "主要电子交易金额#手机银行#数量", prid4s.get(i), "1_1");
			total1 = total1 + Double.parseDouble(fixNumber(temp1));
			total2 = total2 + Double.parseDouble(fixNumber(temp2));
			
			String temp3 = flowSearchBL.searchPublicTableColumnValue(tempMap, "主要电子交易金额#网上银行#网上银行1#数量", prid4s.get(i), "1_1_1");
			String temp4 = flowSearchBL.searchPublicTableColumnValue(tempMap, "主要电子交易金额#网上银行#网上银行2#数量", prid4s.get(i), "1_1_1");
			
			total4 = total4 + Double.parseDouble(fixNumber(temp3)) + Double.parseDouble(fixNumber(temp4));
			
			prid4size++;
		}
		String value5 = " ";
		String value6 = " ";
		String value10 = " ";
		if(prid4size != 0){
			value5 = computDivide(total1, prid4size*90.0) + "万笔";
			value6 = computDivide(total2, prid4size*90.0) + "亿元";
			
			value10 = computDivide(total4, prid4size*90.0) + "亿元";
		}
		

		String value = getStr(new String[]{value1 , value2 ,value3 , value4 , value5 , value6 , value7 , 
			value8 , value9 , value10});
		
		dto.setResult(value);
		return dto;
	}
	
	/**
	 * 左侧第二行第二个竖图
	 * 年报
	 */
	public IGSMR09DTO getTechnologyAudit(IGSMR09DTO dto) throws BLException {
		
		String pdid = IGSMRDBMCONSTANT.PDID_TB3;
		Integer prid = getYearPrid(dto, pdid);
		if(prid == null) return dto;
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPrid(prid);
		cond.setPvcolname("项目名称");
		IG898BL ig898BL = (IG898BL) WebApplicationSupport.getBean("ig898BL");
		List<IG898Info> ig898List = ig898BL.searchIG898(cond);
		List<List> findList = new ArrayList<List>();
		List<List> changeList = new ArrayList<List>();
		if(ig898List != null && ig898List.size()>0){
			for(int i = 0;i<ig898List.size();i++){
				List list = (List) flowSearchBL.searchPublicTableValue(//[{高=12, 中=16, 低=8}, {高=12, 中=16, 低=8}]
						IGSMRDBMCONSTANT.TB3_1+"#"+IGSMRDBMCONSTANT.TB3_1_10, prid,(i+1)+"");
				findList.add(list);
				List list1 = (List) flowSearchBL.searchPublicTableValue(//[{高=12, 中=16, 低=8}, {高=12, 中=16, 低=8}]
						IGSMRDBMCONSTANT.TB3_1+"#"+IGSMRDBMCONSTANT.TB3_1_11, prid, (i+1)+"");
				changeList.add(list1);
			}
			//审计总合
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
			//未整改数
			int value3 = value1 - value2;
			StringBuilder sb = new StringBuilder();
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>");
			sb.append("<AUDITNUMBER>"+ig898List.size()+"</AUDITNUMBER>");
			sb.append("<PRODUCT name=\"已整改数量("+value2+")\" data=\""+computPercent(value2, value1)+"\" />");
			sb.append("<PRODUCT name=\"未整改数量("+value3+")\" data=\""+computPercent(value3, value1)+"\" /></ROOT>");
			dto.setResult(sb.toString());
		}
		

//		//审计总合
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
//		List list1 = (List) flowSearchBL.searchPublicTableValue(//[{高=12, 中=16, 低=8}, {高=12, 中=16, 低=8}]
//				IGSMRDBMCONSTANT.TB3_1+"#"+IGSMRDBMCONSTANT.TB3_1_11, prid, "1");
//		//已经整改数
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
//		//未整改数
//		int value3 = value1 - value2;
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROOT>");
//		sb.append("<AUDITNUMBER>"+value1+"</AUDITNUMBER>");
//		sb.append("<PRODUCT name=\"已整改数量("+value2+")\" data=\""+computPercent(value2, value1)+"\" />");
//		sb.append("<PRODUCT name=\"未整改数量("+value3+")\" data=\""+computPercent(value3, value1)+"\" /></ROOT>");
//		
//		dto.setResult(sb.toString());
		return dto;
	}
	
	/**
	 * 计算百分比
	 * @param y 分子
	 * @param z 分母
	 * @return
	 */
	private String computPercent(int y,int z){
		   String baifenbi="";//接受百分比的值
		   double baiy=y*1.0;
		   double baiz=z*1.0;
		   double fen=baiy/baiz;
		   DecimalFormat df1 = new DecimalFormat("##.0%");   
		   baifenbi= df1.format(fen);  
		   return baifenbi.split("%")[0];
	}
	
	/**
	 * 除法运算保留两位小数
	 * @param y
	 * @param z
	 * @return
	 */
	private static String computDivide(double y,double z){
		   String baifenbi="";//接受百分比的值
		   double fen=y/z;
		   DecimalFormat df1 = new DecimalFormat("0.0");   
		   baifenbi= df1.format(fen);  
		   return baifenbi;
	}
	
	/**
	 * 类型转换
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
	 * 类型转换(整型)
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
	 * 找出最大数字(小数)
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
	 * 找出最大数字(整型)
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
	 * 获取年份
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
     * 获取某一年的上一年，默认为当年的上一年
     * @return
     */
    private static String getLastYear(Integer year){
    	Calendar ca = Calendar.getInstance();//得到一个Calendar的实例  
    	if(year != null) ca.set(Calendar.YEAR, year);
    	ca.add(Calendar.YEAR, -1); //年份减1  
    	Date date = ca.getTime(); //结果 
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy");  
    	
    	return sf.format(date);
    }
    
	/**
	 * 获取上个季度的T-Q-2季报流程ID
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private Integer getTQ2QuarterPrid(IGSMR09DTO dto) throws BLException {
		
		String pdid = IGSMRDBMCONSTANT.PDID_TQ2;//流程定义ID
		String prtype = Constants.REGULATORYREPORT_TYPE_SEASON;//流程类型ID
		
		IGSMR0903Form form = dto.getIgsmr0903Form();
		String year = form.getYear();
		String quarter = form.getQuarter();//格式应为“一”、“二”、“三”、“四”
		String time = "";
		if(StringUtils.isEmpty(year) || StringUtils.isEmpty(quarter)){
			time = getTime(1,null).get(0);
		}else{
			time = year + "_"+quarter+"季度";
		}
		
		List list = flowSearchBL.searchRegulatoryReportInfo(prtype, pdid ,time, true);
		if(list.size() == 0){
			return null;
		}
		Integer prid = Integer.parseInt(list.get(list.size()-1).toString());
		
		return prid;
	}
    
    
	/**
	 * 信息科技项目分析报表
	 * 系统类别占比
	 * 左侧饼图
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getQuarAnalysePieGraph(IGSMR09DTO dto) throws BLException {
		
		/**
		 * 1 设定相关参数
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
		 * 2 组织数据
		 */
		List list = (List) flowSearchBL.searchPublicTableValue(projectAttr , prid, null);
		index:
		for(int i = 0; i < list.size();i++){
			Map temp1 = (Map) list.get(i);
			Map temp2 = (Map)((List)temp1.get(projectAttr)).get(0);
			if(StringUtils.isNotEmpty(sign)){
				if(sign.equals(((String)temp2.get("本季度实施情况")).replace("#", ""))){
					Map temp3 = (Map)((List)temp2.get("渠道管理")).get(0);
					for (Iterator iterator = temp3.keySet().iterator(); iterator.hasNext();) {
						String key1 = (String) iterator.next();
						List tempList = (List)temp3.get(key1);
						if(tempList.size() == 0) 
							continue index;
						Map temp4 = (Map)(tempList).get(0);
						String temp5 = (String)temp4.get("系统类别");
						if(StringUtils.isNotEmpty(temp5)){//如果不为空，则说明该项为所选择的项
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
				Map temp3 = (Map)((List)temp2.get("渠道管理")).get(0);
				for (Iterator iterator = temp3.keySet().iterator(); iterator.hasNext();) {
					String key1 = (String) iterator.next();
					List tempList = (List)temp3.get(key1);
					if(tempList.size() == 0) 
						continue index;
					Map temp4 = (Map)(tempList).get(0);
					String temp5 = (String)temp4.get("系统类别");
					if(StringUtils.isNotEmpty(temp5)){//如果不为空，则说明该项为所选择的项
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
		 * 3 拼装XML
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
	 * 信息科技项目分析报表
	 * 近一年项目情况分析
	 * 右侧折线图
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getQuarAnalyseTrendGraph(IGSMR09DTO dto) throws BLException {
		
		/**
		 * 1 配置参数
		 */
		String pdid = IGSMRDBMCONSTANT.PDID_TQ2;//流程定义ID 
		String prtype = Constants.REGULATORYREPORT_TYPE_SEASON;//流程类型ID
		
		IGSMR0903Form form = dto.getIgsmr0903Form();
		String year = form.getYear();
		String quarter = form.getQuarter();//格式应为“一”、“二”、“三”、“四”
		List<String> times;
		if(StringUtils.isEmpty(year) || StringUtils.isEmpty(quarter)){
			times = getTime(4,null);//默认取当前时间的上4个季度
		}else{
			int quarterVal = 0;
			if("一".equals(quarter)) quarterVal = 1;
			else if("二".equals(quarter)) quarterVal = 2;
			else if("三".equals(quarter)) quarterVal = 3;
			else if("四".equals(quarter)) quarterVal = 4;
			String queryStr = year + "#" + quarterVal;
			times = getTime(4,queryStr);//默认取当前时间的上4个季度
		}
		List<Integer> prids = new ArrayList<Integer>();
		String[] qs = new String[times.size()];//4个季度的字符串
		for(int i =0 ;i < times.size(); i++){
			List list = flowSearchBL.searchRegulatoryReportInfo(prtype, pdid ,times.get(i),true);
			if(list.size() != 0 && list.get(list.size()-1) != null) {
				prids.add(Integer.parseInt(list.get(list.size()-1).toString()));
			}else prids.add(null);
			qs[i] = times.get(i).replace("_", "");
		}
//		if(prids.size() < 4) {
//			log.debug(">>>>>>>>>>>>>>>季度数据不全<<<<<<<<<<<<<<<<");
//			return dto;
//		}
		String[] projectAttrs = {"新增","执行中","已完成"};
//		String[] wholeProjectAttrs = {IGSMRDBMCONSTANT.TQ2_1,IGSMRDBMCONSTANT.TQ2_2,IGSMRDBMCONSTANT.TQ2_3};
		
		
		/**
		 * 2 组织数据
		 */
		Map<String,List<Integer>> valueMap = new LinkedHashMap<String,List<Integer>>();//数据存储格式，保持最开始的存放顺序
		List<Integer> newList = new ArrayList<Integer>();
		List<Integer> ingList = new ArrayList<Integer>();
		List<Integer> overList = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {//List的顺序为从过去到现在
			String star ="";
			String ing ="";
			String over ="";
			Integer prid = prids.get(i);
			if(prid != null){
			List list = (List) flowSearchBL.searchPublicTableValue("本季度新增的重大项目" , prid, null);
				for(int a = 0;a<list.size();a++){
					Map map = (Map) list.get(a);
					for (Iterator iterator1 = map.keySet().iterator(); iterator1.hasNext();) {
						String key1 = (String) iterator1.next();
						List valueList = (List)map.get(key1);
						for (int h = 0; h < valueList.size(); h++) {
							String value =  ((String) ((Map)valueList.get(h)).get("本季度实施情况")).replace("#", "");
							if(StringUtils.isNotEmpty(value)&&"新增".equals(value))star = star +"#";
							if(StringUtils.isNotEmpty(value)&&"执行中".equals(value))ing = ing +"#";
							if(StringUtils.isNotEmpty(value)&&"已完成".equals(value))over = over +"#";
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
		valueMap.put("新增", newList);
		valueMap.put("执行中", ingList);
		valueMap.put("已完成", overList);
		
		/**
		 * 3 拼装XML
		 */
		Integer[] tempArr = new Integer[prids.size()*projectAttrs.length];//把所有的值存入数组，以比较最大值
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
			sb.append("<LINE MINVALUE=\"0\" MAXVALUE=\""+getMax(turnListToArrInt(tempList))+"\" UNIT=\"(个)\" TITLE=\""+name+"\">");
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
	 * 信息科技项目分析报表
	 * 项目明细
	 * 上部表格
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR09DTO getQuarAnalyseGridGraph(IGSMR09DTO dto) throws BLException {
		
		/**
		 * 1 设定相关参数
		 */
		Integer prid = getTQ2QuarterPrid(dto);
		if(prid == null) return dto; 
		String[] wholeProjectAttrs = {IGSMRDBMCONSTANT.TQ2_2};
		/**
		 * 组织数据和拼装XML
		 */
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < wholeProjectAttrs.length; i++) {//三种项目类别
			List list = (List) flowSearchBL.searchPublicTableValue(wholeProjectAttrs[i] , prid, null);
			index:
			for(int j = 0; j < list.size();j++){
				num++;
				Map temp1 = (Map) list.get(j);
				String sort = "";
				
				/***获取类别信息开始***/
				Map temp2 = (Map)((List)temp1.get(wholeProjectAttrs[i])).get(0);
				Map temp3 = (Map)((List)temp2.get("渠道管理")).get(0);
				for (Iterator iterator = temp3.keySet().iterator(); iterator.hasNext();) {
					String key1 = (String) iterator.next();
					List tempList = (List)temp3.get(key1);
					if(tempList.size() == 0) break;
					Map temp4 = (Map)(tempList).get(0);
					String temp5 = (String)temp4.get("系统类别");
					if(StringUtils.isNotEmpty(temp5)){//如果不为空，则说明该项为所选择的项
						sort = temp5;
						break;
					}
				}
				/***获取类别信息结束***/
				
				
				String touru = "";
				if(StringUtils.isNotEmpty((String)temp2.get("合同金额"))) touru = temp2.get("合同金额") + "万元";
				String name = "";
				if(temp2.get("项目名称") != null) name = (String) temp2.get("项目名称");
				String moshi = "";
				if(temp2.get("实施模式") != null) moshi = (String) temp2.get("实施模式");
				String shishi = "";
				if(temp2.get("本季度实施情况") != null) shishi = (String) temp2.get("本季度实施情况");
				if(StringUtils.isEmpty(name) && StringUtils.isEmpty(sort) && StringUtils.isEmpty(touru) &&
						StringUtils.isEmpty(moshi)&&StringUtils.isEmpty(shishi)){
					num--;
					continue index;
				}
				//拼装数据
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
     * 获取前n个季度
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
        int value = quarter - 1;//默认为当前时间的上一季度
        if(StringUtils.isNotEmpty(queryStr)) value = Integer.parseInt(queryStr.split("#")[1]);//或者指定从某个季度开始
        String year;
        if(StringUtils.isEmpty(queryStr)) year = String.valueOf(getYear());
        else year = queryStr.split("#")[0];
        for(int i =0; i< n ; i++){
	        valueflag = value;
	        if(value == 0) value = 4;
	        
	        switch (value) {
				case 1:
					quarterStr = "一季度";
					break;
					
				case 2:
					quarterStr = "二季度";
					break;
					
				case 3:
					quarterStr = "三季度";
					break;
					
				case 4:
					quarterStr = "四季度";
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
     * 拼接字符串
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
     * 修补数据
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
     * 测试
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
