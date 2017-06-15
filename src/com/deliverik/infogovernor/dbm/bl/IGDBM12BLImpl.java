/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dbm.bl;

import java.math.BigDecimal;
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
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCondImpl;
import com.deliverik.infogovernor.asset.bl.task.CheckItemVWBL;
import com.deliverik.infogovernor.asset.bl.task.RiskPointVMBL;
import com.deliverik.infogovernor.asset.bl.task.RiskcaseVWBL;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckItemVWSearchCondImpl;
import com.deliverik.infogovernor.asset.model.condition.RehearseSearchCondImpl;
import com.deliverik.infogovernor.asset.model.condition.RiskPointVMSearchCondImpl;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCondImpl;
import com.deliverik.infogovernor.dbm.bl.task.ScienceOperationReportBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM12DTO;
import com.deliverik.infogovernor.dbm.form.IGDBM1200Form;
import com.deliverik.infogovernor.dbm.form.IGDBM1201Form;
import com.deliverik.infogovernor.dbm.form.IGDBM1202Form;
import com.deliverik.infogovernor.dbm.form.IGDBM1203Form;
import com.deliverik.infogovernor.dbm.model.condition.ScienceOperationReportSearchCondImpl;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckBL;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckResultSearchCondImpl;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckTB;


/**
 * @概述常熟农商银行科技运行Dashboard BL
 * @功能描述 	 1. 
 *           2. 
 *           3. 
 *           4. 查询业务部和科技部工作数量
 * @创建记录 孙东冬  2014/07/17
 * @version 1.0
 */
public class IGDBM12BLImpl extends BaseBLImpl implements IGDBM12BL{
	
	/** 日志对象 */
	protected static final Log log = LogFactory.getLog(IGDBM12BLImpl.class);
	
	/** 风险检查信息业务BL */
	protected RiskCheckBL riskCheckBL;
	
	/** 风险检查结果信息业务BL */
	protected RiskCheckResultBL riskCheckResultBL;
	
	/** 数据信息处理 */
	protected CodeDetailBL codeDetailBL;
	
	/** 流程处理业务BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** 基础数据工具类 */
	protected CodeListUtils codeListUtils;
	
	/** 科技运行统计分析BL */
	protected ScienceOperationReportBL scienceOperationReportBL;
	
	/** 资产信息BL */
	protected SOC0117BL soc0117BL;

	/** 配置项信息BL */
	protected SOC0118BL soc0118BL;
	
	/**流程运行表*/
	protected IG500BL ig500BL;
	
	/**风险点BL*/
	protected RiskPointVMBL riskPointVMBL;
	
	/**检查项BL*/
	protected CheckItemVWBL checkItemVWBL;
	
	/**检查项BL*/
	protected RiskcaseVWBL riskcaseVWBL;
	

	public void setRiskcaseVWBL(RiskcaseVWBL riskcaseVWBL) {
		this.riskcaseVWBL = riskcaseVWBL;
	}

	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}
	
	/**
	 * 风险点BL   设定
	 * @param riskPointVMBL 风险点BL
	 */
	public void setRiskPointVMBL(RiskPointVMBL riskPointVMBL) {
		this.riskPointVMBL = riskPointVMBL;
	}

	/**
	 * 检查项BL   设定
	 * @param checkItemVWBL 检查项BL
	 */
	public void setCheckItemVWBL(CheckItemVWBL checkItemVWBL) {
		this.checkItemVWBL = checkItemVWBL;
	}

	/**
	 * 流程运行表   设定
	 * @param ig500BL 流程运行表
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * 风险检查信息业务BL设定
	 * @param riskCheckBL 风险检查信息业务BL
	 */
	public void setRiskCheckBL(RiskCheckBL riskCheckBL) {
		this.riskCheckBL = riskCheckBL;
	}

	/**
	 * 风险检查结果信息业务BL设定
	 * @param riskCheckResultBL 风险检查结果信息业务BL
	 */
	public void setRiskCheckResultBL(RiskCheckResultBL riskCheckResultBL) {
		this.riskCheckResultBL = riskCheckResultBL;
	}

	/**
	 * 数据信息处理设定
	 * @param codeDetailBL 数据信息处理
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * 流程处理业务BL设定
	 * @param workFlowOperationBL 流程处理业务BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 基础数据工具类设定
	 * @param codeListUtils 基础数据工具类
	 */
	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	/**
	 * 科技运行统计分析BL设定
	 * @param scienceOperationReportBL 科技运行统计分析BL
	 */
	public void setScienceOperationReportBL(
			ScienceOperationReportBL scienceOperationReportBL) {
		this.scienceOperationReportBL = scienceOperationReportBL;
	}

	/**
	 * 检查次数年度统计数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getRcclass(IGDBM12DTO dto) throws BLException{
		log.debug("===============检查次数年度统计数据取得操作开始=================");
		//取得上一年
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String year = sdf.format(new Date());
		//实例化查询条件
		RiskCheckResultSearchCondImpl rcrcond = new RiskCheckResultSearchCondImpl();
		rcrcond.setRcrrealtime_like(year);
		List<RiskCheckResult> rcrList = riskCheckResultBL.findResultByCond(rcrcond, 0, 0);
		//封装数据
		Map<String, Map<String, Integer>> map = new LinkedHashMap<String, Map<String,Integer>>();
		for(RiskCheckResult rc:rcrList){
			if(rc.getRiskCheck()!=null){
				if(map.get(rc.getRiskCheck().getRcclass()) == null){
					Map<String, Integer> temp = new LinkedHashMap<String, Integer>();
					for(int i=1;i<=12;i++){
						String key = i < 10 ? "0" + i : i +"";
						temp.put(key, new Integer(0));
					}
					map.put(rc.getRiskCheck().getRcclass(), temp);
				}
				String month = rc.getRcrrealtime().substring(5,7);
				map.get(rc.getRiskCheck().getRcclass()).put(month, map.get(rc.getRiskCheck().getRcclass()).get(month) + 1);
			}
			
		}
		//拼接XML
		StringBuffer xml = new StringBuffer();
		xml.append("<root>");
		for(Iterator<Entry<String, Map<String, Integer>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, Integer>> entry = iter.next();
			String key = entry.getKey();
			Map<String, Integer> valueMap = entry.getValue();
			xml.append("<datas type='");
			xml.append(codeListUtils.getCodeValue("143", null, null, key));
			xml.append("'>");
			for(Iterator<Entry<String, Integer>> iterator = valueMap.entrySet().iterator();iterator.hasNext();){
				Entry<String, Integer> next = iterator.next();
				String month = next.getKey();
				Integer count = next.getValue();
				xml.append("<data month='");
				xml.append(month);
				xml.append("' count='");
				xml.append(count);
				xml.append("'/>");
			}
			xml.append("</datas>");
		}
		xml.append("</root>");
		dto.setAjaxResult(xml.toString());
		log.debug("===============检查次数年度统计数据取得操作结束=================");
		return dto;
	}
	
	/**
	 * 
	 * 各类问题及工作占比数据取得
	 * 
	 * @return dto
	 * @throws BLException
	 */
	public IGDBM12DTO getRcclassByMonth(IGDBM12DTO dto) throws BLException{
		log.debug("=================各类问题及工作占比数据取得操作开始==============");
		//处理数据
		Map<String, Map<String, Integer>> map = new LinkedHashMap<String, Map<String,Integer>>();
		map.put("1", new LinkedHashMap<String, Integer>());
		map.put("2", new LinkedHashMap<String, Integer>());
		String param="";
		RiskCheckResultSearchCondImpl cond = new RiskCheckResultSearchCondImpl();
		if(dto.getForm() != null && dto.getForm() instanceof IGDBM1203Form && StringUtils.isNotEmpty(((IGDBM1203Form) dto.getForm()).getParams())){
			String params=((IGDBM1203Form) dto.getForm()).getParams();
			String year=params.split("-")[0];
			String month=params.split("-")[1];
			if(month.length()==1){
				month="0"+month;
			}
			param=year+"/"+month;
			
		}else{
			param=IGStringUtils.getCurrentDate().subSequence(0, 7).toString();
		}
		cond.setRcrrealtime_like(param);
		List<RiskCheckResult> list = riskCheckResultBL.findResultByCond(cond, 0, 0);
		for(RiskCheckResult rcr:list){
			RiskCheckTB rc = rcr.getRiskCheck();
			String key = null;
			if("1".equals(rc.getRcclass())){
				key = "机房";
			} else if("2".equals(rc.getRcclass())){
				key = "系统";
			} else if("3".equals(rc.getRcclass())){
				key = "网络";
			} else if("4".equals(rc.getRcclass())){
				key = "桌面安全";
			} else if("5".equals(rc.getRcclass())){
				key = "访问控制";
			} else if("6".equals(rc.getRcclass())){
				key = "开发";
			}else if("7".equals(rc.getRcclass())){
				key = "其他";
			}
			if(StringUtils.isNotEmpty(key)){
				if(map.get("1").get(key) == null){
					map.get("1").put(key, 0);
				}
				map.get("1").put(key, map.get("1").get(key) + 1);
			}
		}
		
		ScienceOperationReportSearchCondImpl scond = new ScienceOperationReportSearchCondImpl();
		scond.setPidoptions("机房#系统#网络#桌面安全#访问控制#开发#其他");
		scond.setPivarname("检查项类型 ");
		scond.setPropentime_like(param);
		List<String> prpdids = new ArrayList<String>();
		prpdids.add("01021");
		scond.setPrpdid_in(prpdids);
		List<Object[]> dataList = scienceOperationReportBL.getWorkOrderAction(scond);
		if(dataList != null && dataList.size() > 0){
			for(int i=0;i<dataList.get(0).length;i++){
				String key = null;
				if(i == 0){
					key = "机房";
				} else if(i == 1){
					key = "系统";
				} else if(i == 2){
					key = "网络";
				} else if(i == 3){
					key = "桌面安全";
				} else if(i == 4){
					key = "访问控制";
				} else if(i == 5){
					key = "开发";
				}
				if(StringUtils.isNotEmpty(key)){
					map.get("2").put(key, Integer.valueOf(dataList.get(0)[i].toString()));
				}
			}
		}
		StringBuilder outputXML=new StringBuilder("<rcclasses>");
		for(Iterator<Entry<String, Map<String, Integer>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, Integer>> next = iter.next();
			String flag = next.getKey();
			outputXML.append("<rcclass");
			outputXML.append(flag);
			outputXML.append(">");
			int total = 0;
			for(Iterator<Entry<String, Integer>> iterator = next.getValue().entrySet().iterator();iterator.hasNext();){
				Entry<String, Integer> entry = iterator.next();
				Integer value = entry.getValue();
				total += value;
			}
			for(Iterator<Entry<String, Integer>> iterator = next.getValue().entrySet().iterator();iterator.hasNext();){
				Entry<String, Integer> entry = iterator.next();
				String key = entry.getKey();
				Integer value = entry.getValue();
				outputXML.append("<count");
				outputXML.append(key);
				outputXML.append(">");
				outputXML.append(value);
				outputXML.append("</count");
				outputXML.append(key);
				outputXML.append(">");
				outputXML.append("<percent");
				outputXML.append(key);
				outputXML.append(">");
				if(total > 0){
					int percent = value * 10000 / total;
					double per = percent / 100.0;
					outputXML.append(per);
					outputXML.append("%");
				}else{
					outputXML.append("0%");
				}
				outputXML.append("</percent");
				outputXML.append(key);
				outputXML.append(">");
			}
			outputXML.append("</rcclass");
			outputXML.append(flag);
			outputXML.append(">");
		}
		outputXML.append("</rcclasses>");
		dto.setAjaxResult(outputXML.toString());
		log.debug("=================各类问题及工作占比数据取得操作结束==============");
		return dto;
	}
	
	/**
	 * 年度工作趋势数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getRcTestMode(IGDBM12DTO dto) throws BLException {
		log.debug("=============年度工作趋势数据取得操作开始=============");
		//取得当前月的最后一天
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		String endDate = sdf.format(cal.getTime());

		//取得11个月前的第一天
		cal.add(Calendar.MONTH, -11);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = sdf.format(cal.getTime());
		
		//封装检查工作查询条件
		RiskCheckResultSearchCondImpl rcrcond = new RiskCheckResultSearchCondImpl();
		rcrcond.setStartdate(startDate);
		rcrcond.setEnddate(endDate);
		
		//查询检查工作
		List<RiskCheckResult> rcrList = riskCheckResultBL.findResultByCond(rcrcond, 0, 0);
		Map<String,Map<String,Integer>> map = new LinkedHashMap<String, Map<String,Integer>>();
		
		map.put("1", new LinkedHashMap<String, Integer>());
		map.put("2", new LinkedHashMap<String, Integer>());
		map.put("3", new LinkedHashMap<String, Integer>());
		for(Iterator<Entry<String, Map<String, Integer>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, Integer>> entry = iter.next();
			Map<String, Integer> valueMap = entry.getValue();
			int startMonth = Integer.valueOf(endDate.substring(5,7));
			for(int i=0;i<12;i++){
				startMonth ++;
				String key = (startMonth % 12) + "";
				if(startMonth != 12 && startMonth % 12 < 10){
					key = "0" + (startMonth % 12);
				}
				valueMap.put(key, 0);
			}
		}
		for(RiskCheckResult rc:rcrList){
			if(StringUtils.isNotEmpty(rc.getRcrrealtime())){
				if(rc.getRiskCheck()!=null && map.get(rc.getRiskCheck().getRcrtestmode()) != null){
					String key = rc.getRcrrealtime().substring(5,7);
					if(map.get(rc.getRiskCheck().getRcrtestmode()).get(key) != null){
						map.get(rc.getRiskCheck().getRcrtestmode()).put(key, map.get(rc.getRiskCheck().getRcrtestmode()).get(key) + 1);
					}
				}
			}
		}
		StringBuilder outputXML=new StringBuilder("<rcclasses>");
		int max=0;
		for(Iterator<Entry<String, Map<String, Integer>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, Integer>> entry = iter.next();
			String key = entry.getKey();
			Map<String,Integer> valueMap=entry.getValue();
			outputXML.append("<rcclass");
			outputXML.append(key);
			outputXML.append(">");
			int flag = 0;
			for(Iterator<Entry<String, Integer>> iterator = valueMap.entrySet().iterator();iterator.hasNext();){
				Entry<String, Integer> next = iterator.next();
				flag ++;
				outputXML.append("<count"+flag+">");
				outputXML.append(next.getValue());
				outputXML.append("</count"+flag+">");
				if(next.getValue() > max){
					max = next.getValue();
				}
			}
			outputXML.append("</rcclass");
			outputXML.append(key);
			outputXML.append(">");
		}
		outputXML.append("<count>");
		outputXML.append(max);
		outputXML.append("</count>");
		outputXML.append("<month>");
		outputXML.append(endDate.subSequence(5, 7));
		outputXML.append("</month>");
		outputXML.append("</rcclasses>");
		dto.setAjaxResult(outputXML.toString());
		log.debug("=============年度工作趋势数据取得操作结束=============");
		return dto;
	}
	
	/**
	 * 信息安全工作总体趋势数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskCheckResult(IGDBM12DTO dto) throws BLException {
		log.debug("=================信息安全工作总体趋势数据取得操作开始==================");
		//取得当前月的最后一天
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		String endDate = sdf.format(cal.getTime());

		//取得11个月前的第一天
		cal.add(Calendar.MONTH, -11);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = sdf.format(cal.getTime());
		
		//封装检查工作查询条件
		RiskCheckResultSearchCondImpl rcrcond = new RiskCheckResultSearchCondImpl();
		rcrcond.setStartdate(startDate);
		rcrcond.setEnddate(endDate);
		//查询检查工作
		List<RiskCheckResult> rcrList = riskCheckResultBL.findResultByCond(rcrcond, 0, 0);
		Map<String, Integer> rcrMap = new LinkedHashMap<String, Integer>();
		int startMonth = Integer.valueOf(endDate.substring(5,7));
		for(int i=0;i<12;i++){
			startMonth ++;
			String key = (startMonth % 12) + "";
			if(startMonth != 12 && startMonth % 12 < 10){
				key = "0" + (startMonth % 12);
			}
			rcrMap.put(key, 0);
		}
		//取得最大数量
		int maxCount = 0;
		//处理检查工作数据
		for(RiskCheckResult rcr:rcrList){
			String key = rcr.getRcrplandate().substring(5,7);
			if(rcrMap.get(key) != null){
				rcrMap.put(key, rcrMap.get(key) + 1);
				if(rcrMap.get(key) > maxCount){
					maxCount = rcrMap.get(key);
				}
			}
			
		}

		//封装检查问题查询条件
		IG500SearchCondImpl prcond = new IG500SearchCondImpl();
		prcond.setPropentime(startDate);
		prcond.setPrclosetime(endDate);
		prcond.setPrpdid("01021");
		prcond.setPrstatus_ne(IGPRDCONSTANTS.PROCESS_TERMINATE);
		
		//查询检查问题
		List<IG500Info> prList = workFlowOperationBL.searchProcessRecord(prcond);
		//处理检查问题数据
		Map<String, Integer> prMap = new LinkedHashMap<String, Integer>();
		startMonth = Integer.valueOf(endDate.substring(5,7));
		for(int i=0;i<12;i++){
			startMonth ++;
			String key = (startMonth % 12) + "";
			if(startMonth != 12 && startMonth % 12 < 10){
				key = "0" + (startMonth % 12);
			}
			prMap.put(key, 0);
		}
		for(IG500Info pr:prList){
			String key = pr.getPropentime().substring(5,7);
			if(prMap.get(key) != null){
				prMap.put(key, prMap.get(key) + 1);
				if(prMap.get(key) > maxCount){
					maxCount = prMap.get(key);
				}
			}
			
		}
		
		//拼接xml
		StringBuffer xml = new StringBuffer();
		xml.append("<rcclasses>");
		xml.append("<count>");
		xml.append(maxCount);
		xml.append("</count>");
		xml.append("<month>");
		xml.append(endDate.substring(5,7));
		xml.append("</month>");
		xml.append("<rcclass1>");
		int key = 0;
		for(Iterator<Entry<String, Integer>> iter = rcrMap.entrySet().iterator();iter.hasNext();){
			Entry<String, Integer> entry = iter.next();
			key ++;
			Integer value = entry.getValue();
			xml.append("<count");
			xml.append(key);
			xml.append(">");
			xml.append(value);
			xml.append("</count");
			xml.append(key);
			xml.append(">");
		}
		xml.append("</rcclass1>");
		xml.append("<rcclass2>");
		key = 0;
		for(Iterator<Entry<String, Integer>> iterator = prMap.entrySet().iterator();iterator.hasNext();){
			Entry<String, Integer> entry = iterator.next();
			Integer value = entry.getValue();
			key ++;
			xml.append("<count");
			xml.append(key);
			xml.append(">");
			xml.append(value);
			xml.append("</count");
			xml.append(key);
			xml.append(">");
		}
		xml.append("</rcclass2>");
		xml.append("</rcclasses>");
		dto.setAjaxResult(xml.toString());
		log.debug("=================信息安全工作总体趋势数据取得操作结束==================");
		return dto;
	}
	
	/**
	 * 问题及整改情况数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getQuestions(IGDBM12DTO dto) throws BLException {
		log.debug("===========问题及整改情况数据取得操作开始=============");
		//取得当前月的最后一天
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		String endDate = sdf.format(cal.getTime());

		//取得11个月前的第一天
		cal.add(Calendar.MONTH, -11);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = sdf.format(cal.getTime());
		
		//封装检查问题查询条件
		IG500SearchCondImpl prcond = new IG500SearchCondImpl();
		prcond.setPropentime(startDate);
		prcond.setPrclosetime(endDate);
		prcond.setPrpdid("01021");
		prcond.setPrstatus_ne(IGPRDCONSTANTS.PROCESS_TERMINATE);
		//最大数量
		int maxCount = 0;
		//查询检查问题
		List<IG500Info> prList = workFlowOperationBL.searchProcessRecord(prcond);
		//处理数据
		Map<String, Map<String, Integer>> map = new LinkedHashMap<String, Map<String,Integer>>();
		map.put("1", new LinkedHashMap<String, Integer>());
		int startMonth = Integer.valueOf(endDate.substring(5,7));
		for(int i=0;i<12;i++){
			startMonth ++;
			String key = (startMonth % 12) + "";
			if(startMonth != 12 && startMonth % 12 < 10){
				key = "0" + (startMonth % 12);
			}
			map.get("1").put(key, 0);
		}
		map.put("2", new LinkedHashMap<String, Integer>());
		startMonth = Integer.valueOf(endDate.substring(5,7));
		for(int i=0;i<12;i++){
			startMonth ++;
			String key = (startMonth % 12) + "";
			if(startMonth != 12 && startMonth % 12 < 10){
				key = "0" + (startMonth % 12);
			}
			map.get("2").put(key, 0);
		}
		for(IG500Info pr:prList){
			String key = pr.getPropentime().substring(5,7);
			map.get("1").put(key, map.get("1").get(key) + 1);
			if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(pr.getPrstatus())){
				map.get("2").put(key, map.get("2").get(key) + 1);
			}
			
			if(map.get("1").get(key) > maxCount){
				maxCount = map.get("1").get(key);
			}
		}
		
		StringBuilder outputXML=new StringBuilder("<rcclasses>");
		outputXML.append("<count>");
		outputXML.append(maxCount);
		outputXML.append("</count>");
		outputXML.append("<month>");
		outputXML.append(endDate.substring(5,7));
		outputXML.append("</month>");
		for(Iterator<Entry<String, Map<String, Integer>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, Integer>> entry = iter.next();
			String flag = entry.getKey();
			
			outputXML.append("<rcclass");
			outputXML.append(flag);
			outputXML.append(">");
			Map<String, Integer> valueMap = entry.getValue();
			int key = 0;
			for(Iterator<Entry<String, Integer>> iterator = valueMap.entrySet().iterator();iterator.hasNext();){
				Entry<String, Integer> next = iterator.next();
				key ++;
				Integer value = next.getValue();
				outputXML.append("<count");
				outputXML.append(key);
				outputXML.append(">");
				outputXML.append(value);
				outputXML.append("</count");
				outputXML.append(key);
				outputXML.append(">");
			}
			outputXML.append("</rcclass");
			outputXML.append(flag);
			outputXML.append(">");
		}
		outputXML.append("</rcclasses>");
		dto.setAjaxResult(outputXML.toString());
		log.debug("===========问题及整改情况数据取得操作结束=============");
		return dto;
		
	}
	
	
	/**
	 * 功能: 取得业务部和科技部工作数量值
	 * @param  IGDBM12DTO dto
	 * @return 工作数量值
	 * @throws BLException
	 */
	public IGDBM12DTO getPieValue(IGDBM12DTO dto) throws BLException {
		IG500SearchCondImpl cond = new IG500SearchCondImpl();

		cond.setPrActive("Y");// PrActive为Y时，是未关闭流程
		String[] prpdid_like_or = new String[7];// 新建数组，将所需的流程定义的PRPDID前5位放到数组中
		prpdid_like_or[0] = IGDBM12BLType.PROCESSRECORD_PRPDID_L;// 服务工单
		prpdid_like_or[1] = IGDBM12BLType.PROCESSRECORD_PRPDID_I;// 事件
		prpdid_like_or[2] = IGDBM12BLType.PROCESSRECORD_PRPDID_C;// 变更
		prpdid_like_or[3] = IGDBM12BLType.PROCESSRECORD_PRPDID_P;// 问题
		prpdid_like_or[4] = IGDBM12BLType.PROCESSRECORD_PRPDID_YS;// 业务服务请求
		prpdid_like_or[5] = IGDBM12BLType.PROCESSRECORD_PRPDID_S;// 科技服务请求
		prpdid_like_or[6] = IGDBM12BLType.PROCESSRECORD_PRPDID_AW;// 指派
		cond.setPrpdid_like_or(prpdid_like_or);
		cond.setPrstatus_ne(IGPRDCONSTANTS.PROCESS_TERMINATE);
		// 获得查询结果，list
		List<IG500Info> list = workFlowOperationBL.searchProcessRecord(cond, 0, 0);
		// 调用封装好的处理方法
		dto = this.processDate(dto, list);
		return dto;
	}

	
	// 处理查询出来的数据，返回给IGDBM12DTO
	public IGDBM12DTO processDate(IGDBM12DTO dto, List<IG500Info> list) {

		int swo = 0;// 服务工单数量
		int ftd = 0;// 故障申报数量
		int ser = 0;// 服务请求数量
		int inc = 0;// 事件数量
		int tep = 0;// 问题数量
		int cha = 0;// 变更数量
		int req = 0;// 请求数量
		int ass = 0;// 指派数量

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getPrpdid().contains(IGDBM12BLType.PROCESSRECORD_PRPDID_L)) {// 服务工单
				if (IGDBM12BLType.ROLE_ROLEID_1146==list.get(i).getPrroleid()
						|| IGDBM12BLType.ROLE_ROLEID_1201==list.get(i).getPrroleid()) {
					swo += 1;
				}
			} else if (list.get(i).getPrpdid().contains(IGDBM12BLType.PROCESSRECORD_PRPDID_I)) {// 故障申报与事件
				if (IGDBM12BLType.ROLE_ROLEID_1146==list.get(i).getPrroleid()
						|| IGDBM12BLType.ROLE_ROLEID_1201==list.get(i).getPrroleid()) {
					ftd += 1;
				} else {
					inc += 1;
				}
			} else if (list.get(i).getPrpdid().contains(IGDBM12BLType.PROCESSRECORD_PRPDID_YS)) {// 业务服务请求
				//add by wym 服务请求数量 增加角色过滤
				if (IGDBM12BLType.ROLE_ROLEID_1146==list.get(i).getPrroleid()
						|| IGDBM12BLType.ROLE_ROLEID_1201==list.get(i).getPrroleid()) {
				ser += 1;
				}
			} else if (list.get(i).getPrpdid().contains(IGDBM12BLType.PROCESSRECORD_PRPDID_P)) {// 问题
				tep += 1;
			} else if (list.get(i).getPrpdid().contains(IGDBM12BLType.PROCESSRECORD_PRPDID_C)) {// 变更
				cha += 1;
			} else if (list.get(i).getPrpdid().contains(IGDBM12BLType.PROCESSRECORD_PRPDID_S)) {// 请求
				req += 1;
			} else if (list.get(i).getPrpdid().contains(IGDBM12BLType.PROCESSRECORD_PRPDID_AW)) {// 指派
				ass += 1;
			}
		}
		// 服务工单数量|故障申报数量|服务请求数量
		dto.setProcessCountYW(""+swo+"|" +ftd+"|"+ ser);
		// 事件|问题|变更|科技服务请求|指派
		dto.setProcessCountKJ(""+inc+"|" +tep+"|"+ cha+"|"+req+"|"+ass);
		return dto;
	}
	public Date lastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.roll(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }
	
	/**
	 * 功能:各部门处理工单数量趋势分析xml
	 * @param IGDBM12DTO dto
	 * @return 各部门处理工单数量趋势分析
	 * @throws BLException
	 */
	public IGDBM12DTO setEventAvgCost(IGDBM12DTO dto)  throws BLException{
		
		//取得当前月的最后一天
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		String endDate = sdf.format(cal.getTime());

		//取得11个月前的第一天
		cal.add(Calendar.MONTH, -11);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = sdf.format(cal.getTime());
		
		//封装问题查询条件
		IG677SearchCondImpl prcond = new IG677SearchCondImpl();
		prcond.setPropentime(startDate);
		prcond.setPrclosetime(endDate);
		if(dto.getForm() != null && dto.getForm() instanceof IGDBM1201Form){
			IGDBM1201Form form = (IGDBM1201Form) dto.getForm();
			if("I".equals(form.getPrtype())){
				prcond.setPrpdid("01080");
				prcond.setPsdid_eq("0108001005");
			}else if("P".equals(form.getPrtype())){
				prcond.setPrpdid("01083");
				prcond.setPsdid_eq("0108301005");//0108301005事件处理节点对应ppstatus为W
			}else if("C".equals(form.getPrtype())){
				prcond.setPrpdid("01084");
				prcond.setPsdid_eq("0108401011");
			}else if("S".equals(form.getPrtype())){
				prcond.setPrpdid("01100");
				prcond.setPsdid_eq("0110001007");
			}else{
				prcond.setPrpdid("01080");
				prcond.setPsdid_eq("0108001005");
			}
		}
		List<IG677Info> list = workFlowOperationBL.searchIG677InfoByCond(prcond);
		//处理数据
		Map<String, Map<String, Integer>> map = new LinkedHashMap<String, Map<String,Integer>>();
		map.put("0002001017004", new LinkedHashMap<String, Integer>());
		map.put("0002001017001", new LinkedHashMap<String, Integer>());
		map.put("0002001017002", new LinkedHashMap<String, Integer>());
		map.put("0002001017003", new LinkedHashMap<String, Integer>());
		int currentMonth = Integer.valueOf(endDate.substring(5,7));
		for(Iterator<Entry<String, Map<String, Integer>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, Integer>> entry = iter.next();
			Map<String, Integer> valueMap = entry.getValue();
			int startMonth = currentMonth;
			for(int i=0;i<12;i++){
				startMonth ++;
				String key = (startMonth % 12) + "";
				if(startMonth != 12 && startMonth % 12 < 10){
					key = "0" + (startMonth % 12);
				}
				valueMap.put(key, 0);
			}
		}
		//IG667可能包含同一prid的多个处理人数据所以需要进行过滤
		List<Map<Integer, String>> pridRelOrgidList = new ArrayList<Map<Integer, String>>();
		for(IG677Info info:list){
			if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
				continue;
			}
			Map<Integer, String> tempMap = new HashMap<Integer, String>();
			tempMap.put(info.getPrid(), info.getPporgid());
			//若未包含prid与orgid关联重复则正常顺序进行处理(同一节点存在不同机构处理人导致过滤删除掉)
			if(!pridRelOrgidList.contains(tempMap)){
				pridRelOrgidList.add(tempMap);
				String key = info.getPporgid();
				if(info.getPporgid().length() > 13){
					key = info.getPporgid().substring(0,13);
				}
				if(map.get(key) != null){
					String month = info.getPropentime().substring(5,7);
					map.get(key).put(month, map.get(key).get(month) + 1);
				}
			}
		}
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=1.0 encoding=UTF-8?><ROOT>");
		xml.append("<MONTH>");
		xml.append(endDate.substring(5,7));
		xml.append("</MONTH>");
		for(Iterator<Entry<String, Map<String, Integer>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, Integer>> entry = iter.next();
			String key = entry.getKey();
			
			String keyvalue="";
			if("0002001017004".equals(key)){
				keyvalue = "LEFTLINE";
			}else if("0002001017001".equals(key)){
				keyvalue = "RIGHTLINE";
			}else if("0002001017002".equals(key)){
				keyvalue = "TOPLINE";
			}else if("0002001017003".equals(key)){
				keyvalue = "DOWNLINE";
			}
			
			xml.append("<");
			xml.append(keyvalue);
			xml.append(">");
			int maxCount = 0;
			for(Iterator<Entry<String, Integer>> iterator = entry.getValue().entrySet().iterator();iterator.hasNext();){
				Entry<String, Integer> next = iterator.next();
				Integer value = next.getValue();
				xml.append("<VALUE>");
				xml.append(value);
				xml.append("</VALUE>");
				if(value > maxCount){
					maxCount = value;
				}
			}
			xml.append("</");
			xml.append(keyvalue);
			xml.append(">");
			xml.append("<");
			xml.append(keyvalue);
			xml.append("MAXVALUE");
			xml.append(">");
			xml.append(maxCount);
			xml.append("</");
			xml.append(keyvalue);
			xml.append("MAXVALUE");
			xml.append(">");
		}
		xml.append("</ROOT>");
		dto.setAjaxResult(xml.toString());
		return dto;
	}
	
	/**
	 * 工单个类别数量占比数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getWorkOrderAction(IGDBM12DTO dto) throws BLException {
		log.debug("===============工单个类别数量占比数据取得操作开始================");
		//取得当前年
		String year = IGStringUtils.getCurrentDate().substring(0,4);
		//取得当前月
		String month = IGStringUtils.getCurrentDate().substring(5,7);
		if(dto.getForm() != null && dto.getForm() instanceof IGDBM1202Form){
			IGDBM1202Form form = (IGDBM1202Form) dto.getForm();
			if(StringUtils.isNotEmpty(form.getYear())){
				year = form.getYear();
			}
			if(StringUtils.isNotEmpty(form.getMonth())){
				month = form.getMonth();
				month = month.length()==1?"0"+month:month;
			}
		}
		
		//处理数据
		Map<String, Map<String, Integer>>  map = new LinkedHashMap<String, Map<String,Integer>>();
		
		//封装流程查询呢条件
		IG500SearchCondImpl prcond = new IG500SearchCondImpl();
		prcond.setPrpdid_like_or(new String[]{"01080","01084","01100"});
		prcond.setPropentime_like(year + "/" + month);
		prcond.setPrstatus_ne(IGPRDCONSTANTS.PROCESS_TERMINATE);
		List<IG500Info> prList = workFlowOperationBL.searchProcessRecord(prcond);
		for(IG500Info info:prList){
			String prpdid = info.getPrpdid().substring(0, 5);
			if(map.get(prpdid) == null){
				map.put(prpdid, new LinkedHashMap<String, Integer>());
			}
			String pivarname = "";
			if(prpdid.startsWith("01080")){
				pivarname = "事件分类";
			}else if(prpdid.startsWith("01084")){
				pivarname = "变更类型";
			}else if(prpdid.startsWith("01100")){
				pivarname = "服务请求分类";
			}
			IG599SearchCondImpl picond = new IG599SearchCondImpl();
			picond.setPrid(info.getPrid());
			picond.setPivarname(pivarname);
			List<IG599Info> list = workFlowOperationBL.searchProcessInfoByCond(picond);
			if(!list.isEmpty()){
				String value = list.get(0).getPivarvalue();
				if(StringUtils.isNotEmpty(value) && value.contains("_tree_")){
					String key = value.split("_tree_")[1].split("-")[0];
					if(map.get(prpdid).get(key) == null){
						map.get(prpdid).put(key, 0);
					}
					map.get(prpdid).put(key, map.get(prpdid).get(key) + 1);
				}
			}
		}
		
		StringBuffer xml = new StringBuffer();
		xml.append("<rcclass>");
		for(Iterator<Entry<String, Map<String, Integer>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, Integer>> entry = iter.next();
			Map<String, Integer> valueMap = entry.getValue();
			String index = entry.getKey().substring(0,5);
			xml.append("<rcclass");
			xml.append(index);
			xml.append(">");
			int total = 0;
			for(Iterator<Entry<String, Integer>> iterator = valueMap.entrySet().iterator();iterator.hasNext();){
				Entry<String, Integer> next = iterator.next();
				total += next.getValue();
			}
			for(Iterator<Entry<String, Integer>> iterator = valueMap.entrySet().iterator();iterator.hasNext();){
				Entry<String, Integer> next = iterator.next();
				String key = next.getKey();
				Integer value = next.getValue();
				xml.append("<count");
				xml.append(key);
				xml.append(">");
				xml.append(value);
				xml.append("</count");
				xml.append(key);
				xml.append(">");
				xml.append("<percent");
				xml.append(key);
				xml.append(">");
				if(total > 0){
					String per = getPercent(value.toString(), total);
//					int percent = value * 10000 / total;
//					double per = ((double) percent) / 100.0;
					xml.append(per);
					xml.append("%");
				}else{
					xml.append("0.0%");
				}
				xml.append("</percent");
				xml.append(key);
				xml.append(">");
			}
			xml.append("</rcclass");
			xml.append(index);
			xml.append(">");
			
		}
		xml.append("</rcclass>");
		dto.setAjaxResult(xml.toString());
		log.debug("===============工单个类别数量占比数据取得操作结束================");
		return dto;
	}
	
	/**
	 * 变更结果占比统计数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getChangeResultAction(IGDBM12DTO dto) throws BLException {
		log.debug("=============变更结果占比统计数据取得操作开始==============");
		//取得当前年
		String year = IGStringUtils.getCurrentDate().substring(0,4);
		//取得当前月
		String month = IGStringUtils.getCurrentDate().substring(5,7);
		if(dto.getForm() != null && dto.getForm() instanceof IGDBM1202Form){
			IGDBM1202Form form = (IGDBM1202Form) dto.getForm();
			if(StringUtils.isNotEmpty(form.getYear())){
				year = form.getYear();
			}
			if(StringUtils.isNotEmpty(form.getMonth())){
				month = form.getMonth();
			}
		}
		
		//实例化查询条件
		ScienceOperationReportSearchCondImpl cond = new ScienceOperationReportSearchCondImpl();
		cond.setPropentime_like(year + "/" + month);
		cond.setPidoptions("0#1");
		cond.setPivarname("驳回次数");
		List<String> prpdidList = new ArrayList<String>();
		prpdidList.add("01084");
		cond.setPrpdid_in(prpdidList);
		List<Object[]> list = scienceOperationReportBL.getWorkOrderAction(cond);
		StringBuffer xml = new StringBuffer();
		//xml标题
		xml.append("<rcclasses>");
		//评审结果xml
		xml.append("<rcclass1>");
		String[] legend1 = {"通过", "驳回"};
		for(Object[] objs:list){
			int total1 = getSumInteger(objs);
			for(int i=0;i<objs.length;i++){
				xml.append("<count"+legend1[i]+">");
				xml.append(objs[i].toString());
				xml.append("</count"+legend1[i]+">");
				xml.append("<percent"+legend1[i]+">");
				String percent1 = getPercent(objs[i].toString(), total1);
				xml.append(percent1+"%");
				xml.append("</percent"+legend1[i]+">");
			}
		}
		xml.append("</rcclass1>");
		cond.setPidoptions("成功#失败#存在问题");
		cond.setPivarname("变更结果");
		list = scienceOperationReportBL.getWorkOrderAction(cond);
		//变更结果xml
		xml.append("<rcclass2>");
		String[] legend2 = {"成功", "失败", "存在问题"};
		for(Object[] objs:list){
			int total2 = getSumInteger(objs);
			for(int i=0;i<objs.length;i++){
				xml.append("<count"+legend2[i]+">");
				xml.append(objs[i].toString());
				xml.append("</count"+legend2[i]+">");
				xml.append("<percent"+legend2[i]+">");
				String percent2 = getPercent(objs[i].toString(), total2);
				xml.append(percent2+"%");
				xml.append("</percent"+legend2[i]+">");
			}
		}
		xml.append("</rcclass2>");
		//xml结尾
		xml.append("</rcclasses>");
		dto.setAjaxResult(xml.toString());
		log.debug("=============变更结果占比统计数据取得操作结束==============");
		return dto;
	}

	/**
	 * 问题解决数量对比数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getQotnDataAction(IGDBM12DTO dto) throws BLException {
		log.debug("===============问题解决数量对象数据取得操作开始===============");
		//取得当前月的最后一天
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		String endDate = sdf.format(cal.getTime());

		//取得11个月前的第一天
		cal.add(Calendar.MONTH, -11);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = sdf.format(cal.getTime());
		
		//封装问题查询条件
		IG500SearchCondImpl prcond = new IG500SearchCondImpl();
		prcond.setPropentime(startDate);
		prcond.setPrclosetime(endDate);
		prcond.setPrpdid("01083");
		prcond.setPrstatus_ne(IGPRDCONSTANTS.PROCESS_TERMINATE);
		//最大数量
		int maxCount = 0;
		//查询问题
		List<IG500Info> prList = workFlowOperationBL.searchProcessRecord(prcond);
		//处理数据
		Map<String, Map<String, Integer>> map = new LinkedHashMap<String, Map<String,Integer>>();
		map.put("1", new LinkedHashMap<String, Integer>());
		int startMonth = Integer.valueOf(endDate.substring(5,7));
		for(int i=0;i<12;i++){
			startMonth ++;
			String key = (startMonth % 12) + "";
			if(startMonth != 12 && startMonth % 12 < 10){
				key = "0" + (startMonth % 12);
			}
			map.get("1").put(key, 0);
		}
		map.put("2", new LinkedHashMap<String, Integer>());
		startMonth = Integer.valueOf(endDate.substring(5,7));
		for(int i=0;i<12;i++){
			startMonth ++;
			String key = (startMonth % 12) + "";
			if(startMonth != 12 && startMonth % 12 < 10){
				key = "0" + (startMonth % 12);
			}
			map.get("2").put(key, 0);
		}
		for(IG500Info pr:prList){
			String key = pr.getPropentime().substring(5,7);
			if(map.get("1").get(key) == null){
				map.get("1").put(key, 0);
			}
			if(map.get("2").get(key) == null){
				map.get("2").put(key, 0);
			}
			map.get("1").put(key, map.get("1").get(key) + 1);
			if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(pr.getPrstatus())){
				map.get("2").put(key, map.get("2").get(key) + 1);
			}
			
			if(map.get("1").get(key) > maxCount){
				maxCount = map.get("1").get(key);
			}
		}
		
		StringBuilder outputXML=new StringBuilder("<rcclasses>");
		outputXML.append("<count>");
		outputXML.append(maxCount);
		outputXML.append("</count>");
		outputXML.append("<month>");
		outputXML.append(endDate.substring(5,7));
		outputXML.append("</month>");
		for(Iterator<Entry<String, Map<String, Integer>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, Integer>> entry = iter.next();
			String flag = entry.getKey();
			
			outputXML.append("<rcclass");
			outputXML.append(flag);
			outputXML.append(">");
			Map<String, Integer> valueMap = entry.getValue();
			int key = 0;
			for(Iterator<Entry<String, Integer>> iterator = valueMap.entrySet().iterator();iterator.hasNext();){
				Entry<String, Integer> next = iterator.next();
				key ++;
				Integer value = next.getValue();
				outputXML.append("<count");
				outputXML.append(key);
				outputXML.append(">");
				outputXML.append(value);
				outputXML.append("</count");
				outputXML.append(key);
				outputXML.append(">");
			}
			outputXML.append("</rcclass");
			outputXML.append(flag);
			outputXML.append(">");
		}
		outputXML.append("</rcclasses>");
		dto.setAjaxResult(outputXML.toString());
		log.debug("===============问题解决数量对象数据取得操作结束===============");
		return dto;
	}
	
	/**
	 * 功能:生成处长首页变更计划日历xml
	 * @param IGDBM03DTO dto
	 * @return 变更计划数据
	 * @throws BLException
	 */
	public IGDBM12DTO setChangePlan(IGDBM12DTO dto) throws BLException {
		String incident_prpdid = "01084";//默认值
		Date paramDate = new Date(); // 默认取得系统时间
		String turnPageFlag = ""; // 翻页标志
		SimpleDateFormat formatterYearMonth = new SimpleDateFormat("yyyy 年 MM 月 ");
		SimpleDateFormat formatterDay = new SimpleDateFormat("dd");
		SimpleDateFormat formatterYMD = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat formatChangePlan = new SimpleDateFormat("yyyy/MM/dd");
		Calendar c = Calendar.getInstance();
		String valueOfDate = null;// 取得传入日期参数
		if(dto.getForm() != null && dto.getForm() instanceof IGDBM1202Form){
			IGDBM1202Form form = (IGDBM1202Form) dto.getForm();
			valueOfDate = form.getDate();
		}
		
		try {
			// 解析格式为'next|yyyyMMdd'的数据，back为向前翻页，next为向后翻页
			if (valueOfDate != null && !"".equals(valueOfDate)) {
				int location = valueOfDate.indexOf("|");
				turnPageFlag = valueOfDate.substring(0,location);
				paramDate  = formatterYMD.parse(valueOfDate.substring(location + 1));
				//paramDate
				c.setTime(paramDate);
				//changeFlag = false;
			}

			if ("".equals(turnPageFlag)) {// 日历初始化的情况取得本周第一天
				//bug fix by wxd
				int dayofweek = c.get(Calendar.DAY_OF_WEEK);
				if(dayofweek==1){//sunday=1 中国不适用
					dayofweek=7;
				}else{
					dayofweek=dayofweek-1;
				}
				c.add(Calendar.DATE,-dayofweek);
				//bug fix by wxd
			} else if ("back".equals(turnPageFlag)) {// 日历向前翻的情况取得上周第一天
				c.add(Calendar.DATE, -8);
			}
			String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ROOT>\n";
			IG500SearchCondImpl cond = new IG500SearchCondImpl();
			cond.setPrpdid(incident_prpdid);
			cond.setPrstatus_ne(IGPRDCONSTANTS.PROCESS_TERMINATE);
			for (int i = 1; i <= 7; i++) {
				c.add(Calendar.DATE, 1);
				
				//<dateroot yearmonth="2010年11月" day="08" color="1" week="星期一" url="http://wwww.baidu.com" amount="4" returnValue = "20101108">
				content = content + "<dateroot yearmonth= \"" + formatterYearMonth.format(c.getTime()) + "\"" +
				          " day=\"" + formatterDay.format(c.getTime()) + "\"" ;
				if("星期六".equals(getWeekStr(i))||"星期日".equals(getWeekStr(i))){
					content = content +" color=\"2\"";
				}else{
					content = content +" color=\"1\"";
				}
				         
				content = content + " week=\"" + getWeekStr(i) + "\"" +
				          " url=\"IGCOM0202.do?linkID=IGWKM0103&prtype=WD&prpdid=01084&propentime="+formatChangePlan.format(c.getTime())+"&prclosetime="+ formatChangePlan.format(c.getTime()) + "&actname=ACT02SVC0401\"" +
				          " amount=\"4\"" +
				          " returnValue=\"" +formatterYMD.format(c.getTime()) + "\">\n";
				cond.setPropentime_like(formatChangePlan.format(c.getTime()));
				List<IG500Info> dataList = workFlowOperationBL.searchProcessRecord(cond, 0, 0);
				if(dataList !=null && dataList.size() >0){
					if(dataList.size()>3){
						dataList=dataList.subList(0, 3);
					}
					

					for(int j=0;j<dataList.size();j++){
						IG500Info prbean=dataList.get(j);
						String prtitle = prbean.getPrtitle();
						if (prtitle.getBytes().length > 10) {
                            for (int k = 0; ; k++) {
                                if(prtitle.substring(0, k).getBytes().length > 8) {
                                    prtitle = prtitle.substring(0, k-1) + "…";
                                    break;
                                }
                            }
                        }
						content = content + " <cplan color=\"1\" url=\"IGPRR0102_Disp.do?prid="+prbean.getPrid()+"&jump=133\">"+(j+1)+"." + prtitle +  "</cplan>\n";
					}
					for(int j=0;j<(3-dataList.size());j++){
						content = content + " <cplan color=\"1\"></cplan>\n";
					}
					content = content + " </dateroot>\n";
				}else{
					content = content + " <cplan color=\"1\"></cplan>\n";
					content = content + " <cplan color=\"1\"></cplan>\n";
					content = content + " <cplan color=\"1\"></cplan>\n";
					content = content + " </dateroot>\n";
				}
			}
				
			content = content + "</ROOT>\n";
			dto.setAjaxResult(content);
		} catch (Exception e) {
			throw new BLException();
		}
		return dto;
	}
	
	/**
	 * 功能:将整型的数字变成汉字的星期
	 * 
	 * @param int dayofweek
	 * @return 星期X
	 * @throws BLException
	 */
	private String getWeekStr(int dayofweek) {
		String week = "";
		switch (dayofweek) {
		case 1:
			week = "星期一";
			break;
		case 2:
			week = "星期二";
			break;
		case 3:
			week = "星期三";
			break;
		case 4:
			week = "星期四";
			break;
		case 5:
			week = "星期五";
			break;
		case 6:
			week = "星期六";
			break;
		case 7:
			week = "星期日";
			break;
		}

		return week;
	}  
	
	/**
	 * 事件趋势分析数据取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO getEventTrendAction(IGDBM12DTO dto) throws BLException {
		log.debug("================时间趋势分析数据取得操作开始===============");
		
		//取得当前月的最后一天
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		String endDate = sdf.format(cal.getTime());

		//取得11个月前的第一天
		cal.add(Calendar.MONTH, -11);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = sdf.format(cal.getTime());
		IG677SearchCondImpl cond = new IG677SearchCondImpl();
		cond.setPrpdid("01080");
		cond.setPropentime(startDate);
		cond.setPrclosetime(endDate);
		List<IG677Info> list = workFlowOperationBL.searchIG677InfoByCond(cond);
		Map<String, Map<Integer, List<IG677Info>>> map = new LinkedHashMap<String, Map<Integer,List<IG677Info>>>();
		int startMonth = Integer.valueOf(endDate.substring(5,7));
		for(int i=0;i<12;i++){
			startMonth ++;
			String key = (startMonth % 12) + "";
			if(startMonth != 12 && startMonth % 12 < 10){
				key = "0" + (startMonth % 12);
			}
			map.put(key, new LinkedHashMap<Integer, List<IG677Info>>());
		}
		for(IG677Info info:list){
			if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
				continue;
			}
			String key = info.getPropentime().substring(5,7);
			if(map.get(key) != null){
				if(map.get(key).get(info.getPrid()) == null){
					map.get(key).put(info.getPrid(), new ArrayList<IG677Info>());
				}
				map.get(key).get(info.getPrid()).add(info);
			}
		}
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=1.0 encoding=UTF-8?><ROOT>");
		xml.append("<MONTH>");
		xml.append(endDate.substring(5,7));
		xml.append("</MONTH>");
		
		xml.append("<LEFTLINE>");
		int maxCount = 0;
		long maxTime = 0;
		for(Iterator<Entry<String, Map<Integer, List<IG677Info>>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<Integer, List<IG677Info>>> entry = iter.next();
//			String key = entry.getKey();
			Map<Integer, List<IG677Info>> value = entry.getValue();
			xml.append("<VALUE>");
			xml.append(value.size());
			xml.append("</VALUE>");
			if(value.size() > maxCount){
				maxCount = value.size();
			}
		}
		xml.append("</LEFTLINE>");
		xml.append("<LEFTMAXVALUE>");
		xml.append(maxCount);
		xml.append("</LEFTMAXVALUE>");
		
		xml.append("<RIGHTLINE>");
		for(Iterator<Entry<String, Map<Integer, List<IG677Info>>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<Integer, List<IG677Info>>> entry = iter.next();
//			String key = entry.getKey();
			long total = 0;
			long count = 0;
			for(Iterator<Entry<Integer, List<IG677Info>>> iterator = entry.getValue().entrySet().iterator();iterator.hasNext();){
				Entry<Integer, List<IG677Info>> next = iterator.next();
				for(IG677Info info : next.getValue()){
					if("0108001005".equals(info.getPsdid()) && StringUtils.isNotEmpty(info.getPpinittime()) && StringUtils.isNotEmpty(info.getPpproctime())){
						try{
							long time1 = sdf.parse(info.getPpproctime()).getTime();
							long time2 = sdf.parse(info.getPpinittime()).getTime();
							long c = time1 - time2;
							long cc = c/1000L/60L;
							total += cc;
							count ++;
						}catch (Exception e) {
						}
					}
				}
			}
			xml.append("<VALUE>");
			long time = count > 0 ? total /count : 0;
			xml.append(time);
			xml.append("</VALUE>");
			if(time > maxTime){
				maxTime = time;
			}
		}
		xml.append("</RIGHTLINE>");
		xml.append("<RIGHTMAXVALUE>");
		xml.append(maxTime);
		xml.append("</RIGHTMAXVALUE>");
		xml.append("</ROOT>");
		dto.setAjaxResult(xml.toString());
		log.debug("================时间趋势分析数据取得操作结束===============");
		return dto;
	}

	public IGDBM12DTO getBusinessDepart(IGDBM12DTO dto) throws BLException {
		//取得当前月的最后一天
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		String endDate = sdf.format(cal.getTime());

		//取得11个月前的第一天
		cal.add(Calendar.MONTH, -11);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = sdf.format(cal.getTime());
		//封装问题查询条件
		IG500SearchCondImpl prcond = new IG500SearchCondImpl();
		prcond.setPropentime(startDate);
		prcond.setPrclosetime(endDate);
		prcond.setPrpdid_like_or(new String[]{"01380","01080","01101"});
		prcond.setPrstatus_ne(IGPRDCONSTANTS.PROCESS_TERMINATE);
		//最大数量
		int maxCount = 0;
		//查询问题
		List<IG500Info> prList = workFlowOperationBL.searchProcessRecord(prcond);
		//处理数据
		Map<String, Map<String, Integer>> map =  new LinkedHashMap<String, Map<String,Integer>>();
		for(IG500Info info:prList){
			if(new Integer(1146).equals(info.getPrroleid()) || new Integer(1201).equals(info.getPrroleid())){
				String key = info.getPrpdid().substring(0,5);
				if(map.get(key) == null){
					Map<String, Integer> temp = new LinkedHashMap<String, Integer>();
					int startMonth = Integer.valueOf(endDate.substring(5,7));
					for(int i=0;i<12;i++){
						startMonth ++;
						String month = (startMonth % 12) + "";
						if(startMonth != 12 && startMonth % 12 < 10){
							month = "0" + (startMonth % 12);
						}
						temp.put(month, 0);
					}
					map.put(key, temp);
				}
				String month = info.getPropentime().substring(5,7);
				if(map.get(key).get(month) == null){
					map.get(key).put(month, 0);
				}
				map.get(key).put(month, map.get(key).get(month) + 1);
				if(map.get(key).get(month) > maxCount){
					maxCount = map.get(key).get(month);
				}
			}
		}
		StringBuffer xml = new StringBuffer();
		xml.append("<rcclasses>");
		xml.append("<count>");
		xml.append(maxCount);
		xml.append("</count>");
		xml.append("<month>");
		xml.append(endDate.substring(5,7));
		xml.append("</month>");
		for(Iterator<Entry<String, Map<String, Integer>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, Integer>> next = iter.next();
			String key = next.getKey();
			xml.append("<rcclass");
			String keyvalue="1";
			if(IGDBM12BLType.PROCESSRECORD_PRPDID_L.equals(key)){
				keyvalue = "1";
			}else if(IGDBM12BLType.PROCESSRECORD_PRPDID_I.equals(key)){
				keyvalue = "2";
			}else if(IGDBM12BLType.PROCESSRECORD_PRPDID_YS.equals(key)){
				keyvalue = "3";
			}
			xml.append(keyvalue);
			xml.append(">");
			int index = 0;
			for(Iterator<Entry<String, Integer>> iterator = next.getValue().entrySet().iterator();iterator.hasNext();){
				Entry<String, Integer> entry = iterator.next();
				Integer value = entry.getValue();
				index ++;
				xml.append("<count");
				xml.append(index);
				xml.append(">");
				xml.append(value);
				xml.append("</count");
				xml.append(index);
				xml.append(">");
			}
			xml.append("</rcclass");
			xml.append(keyvalue);
			xml.append(">");
		}
		xml.append("</rcclasses>");
		dto.setAjaxResult(xml.toString());
		return dto;
	}

	public IGDBM12DTO getScienceDepart(IGDBM12DTO dto) throws BLException {
		//取得当前月的最后一天
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.roll(Calendar.DAY_OF_MONTH, -1);
		String endDate = sdf.format(cal.getTime());

		//取得11个月前的第一天
		cal.add(Calendar.MONTH, -11);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		String startDate = sdf.format(cal.getTime());
		//封装问题查询条件
		IG500SearchCondImpl prcond = new IG500SearchCondImpl();
		prcond.setPropentime(startDate);
		prcond.setPrclosetime(endDate);
		prcond.setPrpdid_like_or(new String[]{"01080","01084","01100"});
		prcond.setPrstatus_ne(IGPRDCONSTANTS.PROCESS_TERMINATE);
		//最大数量
		int maxCount = 0;
		//查询问题
		List<IG500Info> prList = workFlowOperationBL.searchProcessRecord(prcond);
		//处理数据
		Map<String, Map<String, Integer>> map =  new LinkedHashMap<String, Map<String,Integer>>();
		for(IG500Info info:prList){
			if(!new Integer(1146).equals(info.getPrroleid()) && !new Integer(1201).equals(info.getPrroleid())){
				String key = info.getPrpdid().substring(0,5);
				if(map.get(key) == null){
					Map<String, Integer> temp = new LinkedHashMap<String, Integer>();
					int startMonth = Integer.valueOf(endDate.substring(5,7));
					for(int i=0;i<12;i++){
						startMonth ++;
						String month = (startMonth % 12) + "";
						if(startMonth != 12 && startMonth % 12 < 10){
							month = "0" + (startMonth % 12);
						}
						temp.put(month, 0);
					}
					map.put(key, temp);
				}
				String month = info.getPropentime().substring(5,7);
				if(map.get(key).get(month) == null){
					map.get(key).put(month, 0);
				}
				map.get(key).put(month, map.get(key).get(month) + 1);
				if(map.get(key).get(month) > maxCount){
					maxCount = map.get(key).get(month);
				}
			}
		}
		StringBuffer xml = new StringBuffer();
		xml.append("<rcclasses>");
		xml.append("<count>");
		xml.append(maxCount);
		xml.append("</count>");
		xml.append("<month>");
		xml.append(endDate.substring(5,7));
		xml.append("</month>");
		for(Iterator<Entry<String, Map<String, Integer>>> iter = map.entrySet().iterator();iter.hasNext();){
			Entry<String, Map<String, Integer>> next = iter.next();
			String key = next.getKey();
			String keyvalue = "1";
			if(IGDBM12BLType.PROCESSRECORD_PRPDID_I.substring(0, 5).equals(key)){
				keyvalue = "1";
			}else if(IGDBM12BLType.PROCESSRECORD_PRPDID_C.substring(0, 5).equals(key)){
				keyvalue = "2";
			}else if(IGDBM12BLType.PROCESSRECORD_PRPDID_S.substring(0, 5).equals(key)){
				keyvalue = "3";
			}
			xml.append("<rcclass");
			xml.append(keyvalue);
			xml.append(">");
			int index = 0;
			for(Iterator<Entry<String, Integer>> iterator = next.getValue().entrySet().iterator();iterator.hasNext();){
				Entry<String, Integer> entry = iterator.next();
				Integer value = entry.getValue();
				index ++;
				xml.append("<count");
				xml.append(index);
				xml.append(">");
				xml.append(value);
				xml.append("</count");
				xml.append(index);
				xml.append(">");
			}
			xml.append("</rcclass");
			xml.append(keyvalue);
			xml.append(">");
		}
		xml.append("</rcclasses>");
		dto.setAjaxResult(xml.toString());
		return dto;
	}
	
	/**
	 * 流程查询操作开始
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO searchProcessRecordAction(IGDBM12DTO dto) throws BLException {
		log.debug("===============流程查询操作开始===============");
		//封装查询条件
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrstatus_ne(IGPRDCONSTANTS.PROCESS_TERMINATE);
		//dto参数取得
		if(dto.getForm() != null && dto.getForm() instanceof IGDBM1200Form){
			IGDBM1200Form form = (IGDBM1200Form) dto.getForm();
			this.copyProperties(cond, form);
			
			//处理扩展参数
			if(StringUtils.isNotEmpty(form.getOther())){
				if("YW".equals(form.getOther())){
					List<Integer> roleList = new ArrayList<Integer>();
					roleList.add(1146);
					roleList.add(1201);
					cond.setPrroleid_in(roleList);
				}
				if("KJ".equals(form.getOther())){
					List<Integer> roleList = new ArrayList<Integer>();
					roleList.add(1146);
					roleList.add(1201);
					cond.setPrroleid_not_in(roleList);
				}
				if("0002001017004".equals(form.getOther())
						|| "0002001017001".equals(form.getOther())
						|| "0002001017002".equals(form.getOther())
						|| "0002001017003".equals(form.getOther())){
					cond.setPrid_in(getPrids(form));
				}
			}
			
			if(StringUtils.isNotEmpty(form.getMonth())){
				String currentDate = IGStringUtils.getCurrentDate();
				String year = currentDate.substring(0,4);
				String month = currentDate.substring(5,7);
				
				int pm = Integer.valueOf(form.getMonth());
				int cm = Integer.valueOf(month);
				String date = year + "/" + (pm < 10 ? "0" + pm : pm);
				if(pm > cm){
					date = (Integer.valueOf(year) - 1) + "/" + (pm < 10 ? "0" + pm : pm);
				}
				cond.setPropentime_like(date);
			}
			
			if(StringUtils.isNotEmpty(form.getPrclose())){
				cond.setPrStatusArray(new String[]{"#","C"});
			}
		}
		// 查询记录总数
		int totalCount = workFlowOperationBL.searchProcessCount(cond,null);
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<IG500Info> prList = workFlowOperationBL.searchProcessByType(cond, pDto.getFromCount(), pDto.getPageDispCount(),null);
		pDto.setTotalCount(totalCount);
		dto.setPrList(prList);
		log.debug("===============流程查询操作结束===============");
		return dto;
	}
	
	private String getPrids(IGDBM1200Form form) throws BLException{
		IG677SearchCondImpl prcond = new IG677SearchCondImpl();
		prcond.setPrpdid(form.getPrpdid());
		prcond.setPporgid_eq(form.getOther());//需要通过机构进行过滤
		if("01080".equals(form.getPrpdid())){
			prcond.setPsdid_eq("0108001005");
		}else if("01083".equals(form.getPrpdid())){
			prcond.setPsdid_eq("0108301005");
		}else if("01084".equals(form.getPrpdid())){
			prcond.setPsdid_eq("0108401011");
		}else if("01100".equals(form.getPrpdid())){
			prcond.setPsdid_eq("0110001007");
		}
		StringBuffer prids = new StringBuffer("0");
		List<IG677Info> list = workFlowOperationBL.searchIG677InfoByCond(prcond);
		int i = 0;
		for(IG677Info info:list){
			if(info.getPporgid()!=null){
				if(info.getPporgid().contains(form.getOther())){
//					if(i > 0){
						prids.append(",");
//					}
					prids.append(list.get(i).getPrid());
					i ++;
				}
			}
		}
		return prids.toString();
	}
	
	/**
	 * 资产砖取页面操作(风险点,检查项)
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO searchRiskRepositoryAction(IGDBM12DTO dto) throws BLException{
		
		log.debug("=============资产砖取查询操作开始==============");
		IGDBM1200Form form = (IGDBM1200Form) dto.getForm();
		PagingDTO pDto = dto.getPagingDto();
		
		int totalCount = 0;
		if(form.getEsyscoding().startsWith("999017")){
			RiskPointVMSearchCondImpl cond = new RiskPointVMSearchCondImpl();
			cond.setSyscoding(form.getEsyscoding());
			//工作数量
			 totalCount = riskPointVMBL.searchRiskPointVM(cond).size();
			List<RiskPointVMInfo> riskPointList = riskPointVMBL.searchRiskPointVM(cond, pDto.getFromCount(), pDto.getPageDispCount());
			
			dto.setRiskPointList(riskPointList);
		}else if(form.getEsyscoding().startsWith("999018")){
			CheckItemVWSearchCondImpl cond = new CheckItemVWSearchCondImpl();
			cond.setSyscoding(form.getEsyscoding());
			 totalCount = checkItemVWBL.searchCheckItemVW(cond).size();
			 List<CheckItemVWInfo> checkItemList = checkItemVWBL.searchCheckItemVW(cond, pDto.getFromCount(), pDto.getPageDispCount());
			 dto.setCheckItemList(checkItemList);
		}else{
			RiskcaseVWSearchCondImpl cond = new RiskcaseVWSearchCondImpl ();
			//cond.setSyscoding(form.getEsyscoding());
			totalCount = riskcaseVWBL.searchRiskcaseVW(cond).size();
			List<RiskcaseVWInfo> entityItemVWInfoList = this.riskcaseVWBL.searchRiskcaseVW(cond, pDto.getFromCount(), pDto.getPageDispCount());
			dto.setRiskcaseList(entityItemVWInfoList);
		}
		pDto.setTotalCount(totalCount);
		log.debug("=============资产砖取查询操作结束==============");
		
		
		
		return dto;
	}
	
	/**
	 * 检查工作查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO searchRiskWorkAction(IGDBM12DTO dto) throws BLException {
		log.debug("=============检查工作查询操作开始==============");
		//封装检查工作查询条件
		RiskCheckResultSearchCondImpl rcrcond = new RiskCheckResultSearchCondImpl();
		//dto参数取得
		if(dto.getForm() != null && dto.getForm() instanceof IGDBM1200Form){
			IGDBM1200Form form = (IGDBM1200Form) dto.getForm();
			this.copyProperties(rcrcond, form);
			if(StringUtils.isNotEmpty(form.getMonth())){
				String currentDate = IGStringUtils.getCurrentDate();
				String year = currentDate.substring(0,4);
				String month = currentDate.substring(5,7);
				
				int pm = Integer.valueOf(form.getMonth());
				int cm = Integer.valueOf(month);
				String date = year + "/" + (pm < 10 ? "0" + pm : pm);
				if(pm > cm){
					date = (Integer.valueOf(year) - 1) + "/" + (pm < 10 ? "0" + pm : pm);
				}
				rcrcond.setRcrrealtime_like(date);
			}
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		//工作数量
		int totalCount = riskCheckResultBL.findResultByCond(rcrcond,0,0).size();
		//查询检查工作
		List<RiskCheckResult> rcrList = riskCheckResultBL.findResultByCond(rcrcond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setRcrList(rcrList);
		log.debug("=============检查工作查询操作结束==============");
		return dto;
	}
	
	/**
	 * tools 工具类
	 */
	/**
	 * 取和
	 * @param ints
	 * @return
	 */
	private int getSumInteger(Object[] ints) {
		int num = 0;
		for(Object i : ints){
			num += Integer.parseInt(i.toString());
		}
		return num;
	}
	/**
	 * 获取小数点后一位的小数
	 * @param num
	 * @param total
	 * @return
	 */
	private String getPercent(String num, int total) {
		String result = "0.0";
		if(!"0".equals(num)){
			BigDecimal sentbit = new BigDecimal(num);
			BigDecimal div = new BigDecimal(total);
			result = sentbit.multiply(new BigDecimal(100)).divide(div, 1, BigDecimal.ROUND_HALF_UP).toString();
		}
		return result;
	}
	
	//科技风险 start↓↓↓↓↓
	/**
	 * 功能: 获取 风险部门工作情况-电子表数据
	 * @param  IGDBM12DTO dto
	 * @return 工作数量值
	 * @throws BLException
	 */
	public IGDBM12DTO getCounterValue(IGDBM12DTO dto) throws BLException {
		IG500SearchCondImpl cond = new IG500SearchCondImpl();

		cond.setPrActive("Y");// PrActive为Y时，是未关闭流程
		String[] prpdid_like_or = new String[3];// 新建数组，将所需的流程定义的PRPDID前5位放到数组中
		prpdid_like_or[0] = IGDBM12BLType.PROCESSRECORD_PRPDID_RISK1;// 风险计划
		prpdid_like_or[1] = IGDBM12BLType.PROCESSRECORD_PRPDID_RISK2;// 评估任务
		prpdid_like_or[2] = IGDBM12BLType.PROCESSRECORD_PRPDID_RISK3;// 问题整改
		cond.setPrpdid_like_or(prpdid_like_or);
		cond.setPrstatus_ne(IGPRDCONSTANTS.PROCESS_TERMINATE);
		// 获得查询结果，list
		List<IG500Info> list = workFlowOperationBL.searchProcessRecord(cond,  0, 0);
		
		SOC0118SearchCondImpl soc0118SearchCond = new SOC0118SearchCondImpl();
		String[] eid_in = new String[3];// 新建数组，将所需的流程定义的PRPDID前5位放到数组中
		eid_in[0] = IGDBM12BLType.PROCESSRECORD_EID_RISK1;// 风险点
		eid_in[1] = IGDBM12BLType.PROCESSRECORD_EID_RISK2;// 检查项
		eid_in[2] = IGDBM12BLType.PROCESSRECORD_EID_RISK3;// 风险事件
		soc0118SearchCond.setEids(eid_in);
		List<SOC0118Info> soc0118List = soc0118BL.searchEntityItem(soc0118SearchCond);
		// 调用封装好的处理方法
		dto = this.processCounter(dto, list,soc0118List);
		
		return dto;
	}
	
	/**
	 * 功能: 获取 风险部门工作情况-电子表数据
	 * @param  IGDBM12DTO dto
	 * @param  List<IG500Info> list 流程相关数据
	 * @param  List<SOC0118Info> soc0118List 资产相关数据
	 * 
	 * @return 工作数量值
	 * @throws BLException
	 */
	public IGDBM12DTO processCounter(IGDBM12DTO dto, List<IG500Info> list, List<SOC0118Info> soc0118List) {

		int fxd = 0;// 风险点
		int jcx = 0;// 检查项
		int qd = 0;// 风险清单(风险事件)

		int jh = 0;// 风险计划
		int rw = 0;// 评估任务
		int zg = 0;// 问题整改
		//资产
		for (int i = 0; i < soc0118List.size(); i++) {
			if (IGDBM12BLType.PROCESSRECORD_EID_RISK1.equals(soc0118List.get(i).getEid())) {// 服务工单
				fxd += 1;
			} else if (IGDBM12BLType.PROCESSRECORD_EID_RISK2.equals(soc0118List.get(i).getEid())) {// 故障申报与事件
				jcx += 1;
			} else if (IGDBM12BLType.PROCESSRECORD_EID_RISK3.equals(soc0118List.get(i).getEid())) {// 业务服务请求
				qd += 1;
			} 
		}
		//流程
		for (int i = 0; i < list.size(); i++) {
			if (IGDBM12BLType.PROCESSRECORD_PRPDID_RISK1.equals(list.get(i).getPrpdid())) {// 服务工单
				jh += 1;
			} else if (IGDBM12BLType.PROCESSRECORD_PRPDID_RISK2.equals(list.get(i).getPrpdid())) {// 故障申报与事件
				rw += 1;
			} else if (IGDBM12BLType.PROCESSRECORD_PRPDID_RISK3.equals(list.get(i).getPrpdid())) {// 业务服务请求
				zg += 1;
			} 
		}
		// 风险点|检查项|风险计划|评估任务|风险清单|问题整改   
		dto.setRiskCounter(""+fxd+"|"+jcx+"|"+jh+"|"+rw+"|" +qd+"|"+ zg);
		
		return dto;
	}
	
	/**
	 * 功能: 获取 本年度风险工作覆盖情况-风险点+检查项
	 * @param  IGDBM12DTO dto
	 * @return 工作数量值
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskCheck(IGDBM12DTO dto) throws BLException {
		
		//评估工作中所选的某一领域风险点数量（按本年度过滤掉重复的风险点）
		RehearseSearchCondImpl cond = new RehearseSearchCondImpl();
		List<HashMap<String, Object>> assessRiskList = soc0118BL.searchAssessRisk(cond, 0, 50000);
		List<HashMap<String, Object>> totalRiskList = soc0118BL.searchRiskInfo(cond, 0, 50000);
		totalRiskList = changeEname(totalRiskList);
		StringBuffer xml = new StringBuffer("<root>");
		int riskSum = 0;
		int inspectSum = 0;
		int asRiskSum = 0;
		int asInspectSum = 0;
		for(int i=0;i<8;i++){
			//领域名称
			String ename = (String)totalRiskList.get(i).get("ename");
			//风险点总数
			Object riskcountObj = totalRiskList.get(i).get("riskcount");
			String riskcount = riskcountObj!=null?(String)riskcountObj:"0";
			//检查项总数
			Object inspectcountObj = totalRiskList.get(i).get("inspectcount");
			String inspectcount = inspectcountObj!=null?(String)inspectcountObj:"0";
			//评估工作-风险点
			Object asRiskcountObj = assessRiskList.get(i).get("riskcount");
			String asRiskcount = asRiskcountObj!=null?(String)asRiskcountObj:"0";
			//评估工作-检查项
			Object asInspectcountObj = assessRiskList.get(i).get("inspectcount");
			String asInspectcount = asInspectcountObj!=null?(String)asInspectcountObj:"0";
			//风险点覆盖率=评估工作中所选的某一领域风险点数量（按本年度过滤掉重复的风险点）/该领域风险点的总数*100%
			BigDecimal riskPercent = new BigDecimal(0);
			if(!"0".equals(riskcount)){
				riskPercent = new BigDecimal(Double.valueOf(asRiskcount)/Double.valueOf(riskcount)*100)
				.setScale(1, BigDecimal.ROUND_HALF_UP);
			}
			//检查项覆盖率=评估工作中所选的某一领域检查项数量（按本年度过滤掉重复的检查项）/该领域检查项的总数*100% 
			BigDecimal inspectPercent = new BigDecimal(0);
			if(!"0".equals(inspectcount)){
				inspectPercent = new BigDecimal(Double.valueOf(asInspectcount)/Double.valueOf(inspectcount)*100)
				.setScale(1, BigDecimal.ROUND_HALF_UP);
			}
			xml.append("<row><td>"+ename+"</td>");
			xml.append("<td>"+riskcount+"</td>");
			xml.append("<td>"+riskPercent.toString()+"%"+"</td>");
			xml.append("<td>"+inspectcount+"</td>");
			xml.append("<td>"+inspectPercent.toString()+"%</td></row>");
			//合计:风险点
			riskSum+=Integer.valueOf(riskcount);
			//合计:检查项
			inspectSum+=Integer.valueOf(inspectcount);
			//合计:评估风险点
			asRiskSum+=Integer.valueOf(asRiskcount);
			//合计:评估检查项
			asInspectSum+=Integer.valueOf(asInspectcount);
		}
		//合计:风险覆盖率
		String totalRiskPercent = getPercent(String.valueOf(asRiskSum), riskSum);
		//合计:检查项覆盖率
		String totalInspectPercent = getPercent(String.valueOf(asInspectSum), inspectSum);
		//合计XML
		xml.append("<row><td>合计</td>");
		xml.append("<td>"+riskSum+"</td>");
		xml.append("<td>"+totalRiskPercent+"%"+"</td>");
		xml.append("<td>"+inspectSum+"</td>");
		xml.append("<td>"+totalInspectPercent+"%</td></row>");
		xml.append("</root>");
		
		dto.setAjaxResult(xml.toString());
		return dto;
	}
	/**
	 * 功能: 修改table画面显示的领域名称
	 * @param  List<HashMap<String, Object>> list
	 * @return List<HashMap<String, Object>> list
	 * @throws BLException
	 */
	public List<HashMap<String, Object>> changeEname(List<HashMap<String, Object>> list) throws BLException {
		for(int i=0;i<8;i++){
			if(1==i){
				list.get(i).put("ename", "科技风险管理");
			}
			if(3==i){
				list.get(i).put("ename", "开发测试维护");
			}
			if(5==i){
				list.get(i).put("ename", "业务连续性");
			}
		}
		return list;
	}
	/**
	 * 功能: 获取 本年度风险问题及整改占比-问题及整改
	 * @param  IGDBM12DTO dto
	 * @return 工作数量值
	 * @throws BLException
	 */
	public IGDBM12DTO getRiskProblem(IGDBM12DTO dto) throws BLException {
		RehearseSearchCondImpl cond = new RehearseSearchCondImpl();
		//问题整改
		List<HashMap<String, Object>> problemList =  ig500BL.searchIssueCorrectiveInfo(cond, 0, 50000);
		StringBuffer xml = new StringBuffer("<root>");
		StringBuffer problemXml = new StringBuffer("<tab>");
		StringBuffer correctiveXml = new StringBuffer("<tab>");
		for(int i=0;i<problemList.size();i++){
			//领域名称
			//String fieldvalue = (String)problemList.get(i).get("fieldvalue");
			//问题总数
			Object problemcountObj = problemList.get(i).get("prcount");
			String problemcount = problemcountObj!=null?(String)problemcountObj:"0";
			//整改总数
			Object correctivecountObj = problemList.get(i).get("recount");
			String correctivecount = correctivecountObj!=null?(String)correctivecountObj:"0";
			//各个领域问题数
			problemXml.append("<areas>");
			problemXml.append(problemcount);
			problemXml.append("</areas>");
			//各个领域整改数
			correctiveXml.append("<areas>");
			correctiveXml.append(correctivecount);
			correctiveXml.append("</areas>");
		}
		problemXml.append("</tab>");
		correctiveXml.append("</tab>");
		xml.append(problemXml);
		xml.append(correctiveXml);
		xml.append("</root>");
		dto.setAjaxResult(xml.toString());
		return dto;
	}
	
	/**
	 * 功能: 获取 风险库分布情况-风险库
	 * @param  IGDBM12DTO dto
	 * @return 工作数量值
	 * @throws BLException
	 */
	@SuppressWarnings("rawtypes")
	public IGDBM12DTO getRiskRepository(IGDBM12DTO dto) throws BLException {
		
		List<Map> resultList = soc0118BL.getRiskRepository();
		StringBuffer xml = new StringBuffer("<root>");
		StringBuffer type1 = new StringBuffer("<type>");
		StringBuffer type2 = new StringBuffer("<type>");
		for (Map map : resultList) {
			type1.append("<pillar syscoding = \""+map.get("riskesyscoding")+"\" name = \""+map.get("ename")+"\">");
			type1.append(map.get("riskcont"));
			type1.append("</pillar>");
			type2.append("<pillar syscoding = \""+map.get("inspectesyscoding")+"\" name = \""+map.get("ename")+"\">");
			type2.append(map.get("inspectcont"));
			type2.append("</pillar>");
		}
		type1.append("</type>");
		type2.append("</type>");
		xml.append(type1.toString());
		xml.append(type2.toString());
		
		xml.append("</root>");
		
		
		dto.setAjaxResult(xml.toString());
		
		return dto;
	}
	/**
	 * 功能: 获取 风险评估工作总体情况-柱图 -问题及整改完成
	 * @param  IGDBM12DTO dto
	 * @return 工作数量值
	 * @throws BLException
	 */
	@SuppressWarnings("rawtypes")
	public IGDBM12DTO getRiskRectification(IGDBM12DTO dto) throws BLException {
		
		Calendar ca = Calendar.getInstance();
		
		String curMonth = String.valueOf(ca.get(Calendar.MONTH)+1);
		
		//定义一个数字 存储 当前月份之前的一年之中的所有月份
		String a = "";
		for (int i = 0; i < 12; i++) {
			int temp = (ca.get(Calendar.MONTH)+1);
			a+=",('"+ca.get(Calendar.YEAR)+"/"+(temp<10?"0":"")+temp+"')";
			ca.add(Calendar.MONTH, -1);
		}
		StringBuffer xml = new StringBuffer("<root>");
		xml.append("<curMon>");
		xml.append(curMonth);
		xml.append("</curMon>");
		//01083 是<问题>流程的 定义id
		List<Map> resultList = ig500BL.getRiskAssess(a.substring(1),"01083");
		//反序
		Collections.reverse(resultList);
		StringBuffer type1 = new StringBuffer("<type>");
		StringBuffer type2 = new StringBuffer("<type>");
		for (Map map : resultList) {
			type1.append(" <pillar prpdid= \""+"01083"+"\" month=\""+map.get("DATEMONTH")+"\">"+(map.get("ACOUNT")==null?0:map.get("ACOUNT"))+"</pillar>");
			type2.append(" <pillar prpdid= \""+"01083"+"\" month=\""+map.get("DATEMONTH")+"\">"+(map.get("CLOSECOUNT")==null?0:map.get("CLOSECOUNT"))+"</pillar>");
		}
		type1.append("</type>");
		type2.append("</type>");
		xml.append(type1.toString());
		xml.append(type2.toString());
		xml.append("</root>");
		
		dto.setAjaxResult(xml.toString());
		return dto;
	}
	/**
	 * 功能: 获取 风险评估工作总体情况-线图 - 检查工作
	 * @param  IGDBM12DTO dto
	 * @return 工作数量值
	 * @throws BLException
	 */
	@SuppressWarnings("rawtypes")
	public IGDBM12DTO getRiskAssess(IGDBM12DTO dto) throws BLException {
		
	Calendar ca = Calendar.getInstance();
		
		String curMonth = String.valueOf(ca.get(Calendar.MONTH)+1);
		
		//定义一个数字 存储 当前月份之前的一年之中的所有月份
		String a = "";
		for (int i = 0; i < 12; i++) {
			int temp = (ca.get(Calendar.MONTH)+1);
			a+=",('"+ca.get(Calendar.YEAR)+"/"+(temp<10?"0":"")+temp+"')";
			ca.add(Calendar.MONTH, -1);
		}
		
		StringBuffer xml = new StringBuffer("<root>");
		xml.append("<curMon>");
		xml.append(curMonth);
		xml.append("</curMon><type>");
		//01001 是<风险评估>流程的 定义id
		List<Map> resultList = ig500BL.getRiskAssess(a.substring(1),"01001");
		//反序
		Collections.reverse(resultList);
		for (Map map : resultList) {
			xml.append(" <line prpdid= \""+"01001"+"\" month=\""+map.get("DATEMONTH")+"\">"+(map.get("ACOUNT")==null?0:map.get("ACOUNT"))+"</line>");
		}
		
		xml.append("</type></root>");
		
		dto.setAjaxResult(xml.toString());
		return dto;
	}
	
	/**
	 * 功能: 钻取-饼图图 - 问题整改
	 * @param  IGDBM12DTO dto
	 * @return 工作数量值
	 * @throws BLException
	 */
	public IGDBM12DTO searchIssueCorrectiveByField(IGDBM12DTO dto) throws BLException {
		RehearseSearchCondImpl cond = new RehearseSearchCondImpl();
		//dto参数取得
		if(dto.getForm() != null && dto.getForm() instanceof IGDBM1200Form){
			IGDBM1200Form form = (IGDBM1200Form) dto.getForm();
			cond.setPivarvalue(form.getPivarvalue());
			cond.setPrstatus(form.getPrstatus());
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//工作数量
		int totalCount = ig500BL.searchIssueCorrectiveByField(cond,0,0).size();
		//问题整改
		List<IG500Info> problemList =  ig500BL.searchIssueCorrectiveByField(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		// 调用DAO接口查询
		//工作数量
		pDto.setTotalCount(totalCount);
		dto.setPrList(problemList);
		return dto;
	}
	
	/**
	 * 流程查询操作开始
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDBM12DTO searchCounterInfo(IGDBM12DTO dto) throws BLException {
		log.debug("===============流程查询操作开始===============");
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		int totalCount = 0;
		List<IG500Info> prList = null;
		//dto参数取得
		String countid = "";
		if(dto.getForm() != null && dto.getForm() instanceof IGDBM1200Form){
			IGDBM1200Form form = (IGDBM1200Form) dto.getForm();
			countid = form.getCountid();
		}
		if(IGDBM12BLType.PROCESSRECORD_EID_RISK1.equals(countid)
				||IGDBM12BLType.PROCESSRECORD_EID_RISK2.equals(countid)
				||IGDBM12BLType.PROCESSRECORD_EID_RISK3.equals(countid)){
			
			SOC0118SearchCondImpl soc0118SearchCond = new SOC0118SearchCondImpl();
			soc0118SearchCond.setEid(countid);
			// 查询记录总数
			totalCount = soc0118BL.searchEntityItem(soc0118SearchCond, 0, 0).size();
			List<SOC0118Info> soc0118List = soc0118BL.searchEntityItem(soc0118SearchCond, pDto.getFromCount(), pDto.getPageDispCount());
			dto.setAssetList(soc0118List);
		}else if(IGDBM12BLType.PROCESSRECORD_PRPDID_RISK1.equals(countid)
				||IGDBM12BLType.PROCESSRECORD_PRPDID_RISK2.equals(countid)
				||IGDBM12BLType.PROCESSRECORD_PRPDID_RISK3.equals(countid)){
			//封装查询条件
			IG500SearchCondImpl cond = new IG500SearchCondImpl();
			cond.setPrActive("Y");// PrActive为Y时，是未关闭流程
			String[] prpdid_like_or = new String[1];// 新建数组，将所需的流程定义的PRPDID前5位放到数组中
			prpdid_like_or[0] = countid;// 流程prpdid
			cond.setPrpdid_like_or(prpdid_like_or);
			cond.setPrstatus_ne(IGPRDCONSTANTS.PROCESS_TERMINATE);
			// 查询记录总数
			totalCount = workFlowOperationBL.searchProcessRecord(cond, 0, 0).size();
			// 调用DAO接口查询
			prList = workFlowOperationBL.searchProcessRecord(cond, pDto.getFromCount(), pDto.getPageDispCount());
			dto.setPrList(prList);
		}
		pDto.setTotalCount(totalCount);
		
		log.debug("===============流程查询操作结束===============");
		return dto;
	}
	//科技风险 end↑↑↑↑↑
	
	
}
