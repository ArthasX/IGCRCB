/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * @Description: 检查问题查询
 * @Author
 * @20140709 新建
 * @Version V1.0
 */
public class IGRIS05BLImpl extends BaseBLImpl implements IGRIS05BL {

	static Log log = LogFactory.getLog(IGRIS05BLImpl.class);


	/** 检查问题查询 */
	protected CheckWorkConutVWBL checkWorkConutVWBL;

	/** 附件查询 */
	protected AttachmentBL attachmentBL;

	/** 每年 */
	protected String DAY = "day";

	/** 一次 */
	protected String ONCE = "once";

	/**
	 * 检查问题查询设定
	 * 
	 * @param checkWorkConutVWBL
	 *            检查问题查询
	 */
	public void setCheckWorkConutVWBL(CheckWorkConutVWBL checkWorkConutVWBL) {
		this.checkWorkConutVWBL = checkWorkConutVWBL;
	}

	/**
	 * 附件查询设定
	 * 
	 * @param attachmentBL
	 *            附件查询
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	/***
	 * 检查统计报表
	 * @param dto
	 * @return dto
	 */
	public IGRIS05DTO searchRiskCount(IGRIS05DTO dto) throws BLException {
		
		log.debug("====================ctrlBL 报表统计查询开始=======================");
		//查询条件初始化
		CheckWorkConutVWSearchCondImpl cond = new  CheckWorkConutVWSearchCondImpl();
		cond.setRcrtestmode(dto.getIgris0501Form().getRcrtestmode());
		IGRIS0501Form form =dto.getIgris0501Form();
		int month=Integer.parseInt(dto.getIgris0501Form().getMonth().trim());
		/**拼半年*/
		if(month>6){
			String condtion=" and ((t.rcfrequency = 'halfyear' and t.RCSTARTDATE between '"+form.getYear()+"/06/01 00:00' and '"+form.getYear()+"/"+form.getMonth()+"/31 23:59')" ;  
			cond.setHalfyear(condtion);
		}else {
			String condtion=" and ((t.rcfrequency = 'halfyear' and t.RCSTARTDATE between '"+form.getYear()+"/01/01 00:00' and '"+form.getYear()+"/"+form.getMonth()+"/31 23:59')" ;
			cond.setHalfyear(condtion);
		}
		/**拼季度*/
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
		
		/**拼年*/
		String yearCond="  or (t.rcfrequency = 'year' and t.RCSTARTDATE between '"+form.getYear()+"/01/01 00:00' and '"+form.getYear()+"/"+form.getMonth()+"/31 23:59')";
		cond.setYear(yearCond);
		
		/**拼week 、day 、once 、month*/
		String cgCond="   or ( t.rcfrequency = 'week' and t.RCSTARTDATE like '"+form.getYear()+"/"+form.getMonth()+"%')" +
				"  or ( t.rcfrequency = 'day' and t.RCSTARTDATE like '"+form.getYear()+"/"+form.getMonth()+"%')" +
				"  or ( t.rcfrequency = 'once' and t.RCSTARTDATE like '"+form.getYear()+"/"+form.getMonth()+"%')" +
				"  or ( t.rcfrequency = 'month' and t.RCSTARTDATE like '"+form.getYear()+"/"+form.getMonth()+"%'))";
		cond.setCg(cgCond);
		
		
		//调用taskBL查询
		List<CheckWorkConutVWInfo> checkWorkConutList = checkWorkConutVWBL.searchCheckWorkConutVW(cond, 0, 0);
		
		
		//检查频率设定
		for (CheckWorkConutVWInfo info : checkWorkConutList) {
			CheckWorkConutVW  tb= (CheckWorkConutVW)info;
			if(ONCE.equals(tb.getRcfrequency())){
				tb.setRcfrequency("仅一次");
			}else if(DAY.equals(tb.getRcfrequency())){
				tb.setRcfrequency("每天");
			}else if("week".equals(tb.getRcfrequency())){
				tb.setRcfrequency("每周");
			}else if("month".equals(tb.getRcfrequency())){
				tb.setRcfrequency("每月");
			}else if("halfyear".equals(tb.getRcfrequency())){
				tb.setRcfrequency("每半年");
			}else if("year".equals(tb.getRcfrequency())){
				tb.setRcfrequency("每年");
			}else if("quarter".equals(tb.getRcfrequency())){
				tb.setRcfrequency("季度");
			}
			
			if("B".equals(tb.getRcrresult())){
				tb.setRcrresult("存在问题");
			}else if("C".equals(tb.getRcrresult())){
				tb.setRcrresult("存在重大问题");
			}else if("A".equals(tb.getRcrresult())){
				tb.setRcrresult("正常");
			}
		}
		//统计报表按检查项名称分类
		dto = setMapType2(dto,checkWorkConutList);
		//if(StringUtils.isNotBlank(dto.getFlag()) && "2".equals(dto.getFlag()) ){
		/*}else{
			//统计报表按检查项类型分类
			dto = setMapType1(dto,checkWorkConutList);
		}
		*/
		log.debug("====================ctrlBL 报表统计查询结束=======================");
		return dto;
	}

	/**
	 * 统计报表按检查项类型分类
	 * @param dto
	 * @param checkWorkConutList
	 */
	private IGRIS05DTO setMapType1(IGRIS05DTO dto,List<CheckWorkConutVWInfo> checkWorkConutList) {
		//定义map
		Map<String, List<CheckWorkConutVWInfo>> map = new LinkedHashMap<String, List<CheckWorkConutVWInfo>>();
		Map<Integer,String> mapType = new LinkedHashMap<Integer,String>();
		int i = 0;
		//map(key,value) 检查分类   检查集合
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
	 * 统计报表按检查项名称分类
	 * @param dto
	 * @param checkWorkConutList
	 */
	private IGRIS05DTO setMapType2(IGRIS05DTO dto, List<CheckWorkConutVWInfo> checkWorkConutList) {
		//定义map
		Map<String, Map<String,List<CheckWorkConutVWInfo>>> map = new LinkedHashMap<String, Map<String,List<CheckWorkConutVWInfo>>>();
		Map<String,Map<Integer,String>> mapType = new LinkedHashMap<String,Map<Integer,String>>();
		Set<String> setType = new HashSet<String>();
		for(CheckWorkConutVWInfo info:checkWorkConutList){
			setType.add(info.getRcname());
		}
		int j = 0;
		//map(key,value) 检查分类   检查集合
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
