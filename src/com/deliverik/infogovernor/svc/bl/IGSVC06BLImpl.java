package com.deliverik.infogovernor.svc.bl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.svc.bl.task.AnnualTrendVWBL;
import com.deliverik.infogovernor.svc.bl.task.IncidentAveSolveTimeVWBL;
import com.deliverik.infogovernor.svc.bl.task.IncidentTypeBL;
import com.deliverik.infogovernor.svc.bl.task.OrganizationServiceBL;
import com.deliverik.infogovernor.svc.bl.task.SummaryCountPersonBL;
import com.deliverik.infogovernor.svc.bl.task.ServiceTopFiveVWBL;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0601Form;
import com.deliverik.infogovernor.svc.form.IGSVC0635Form;
import com.deliverik.infogovernor.svc.form.IGSVC0636Form;
import com.deliverik.infogovernor.svc.form.IGSVC0639Form;
import com.deliverik.infogovernor.svc.form.IGSVC0637Form;
import com.deliverik.infogovernor.svc.form.IGSVC0638Form;
import com.deliverik.infogovernor.svc.form.IGSVC0640Form;
import com.deliverik.infogovernor.svc.form.IGSVC0642Form;
import com.deliverik.infogovernor.svc.model.AnnualTrendVWInfo;
import com.deliverik.infogovernor.svc.model.IncidentAveSolveTimeVWInfo;
import com.deliverik.infogovernor.svc.model.IncidentTypeVWInfo;
import com.deliverik.infogovernor.svc.model.OrganizationServiceVWInfo;
import com.deliverik.infogovernor.svc.model.ServiceTopFiveVWInfo;
import com.deliverik.infogovernor.svc.model.condition.AnnualTrendVWSearchCondImpl;
import com.deliverik.infogovernor.svc.model.condition.IncidentAveSolveTimeSearchCondImpl;
import com.deliverik.infogovernor.svc.model.condition.IncidentTypeSearchCondImpl;
import com.deliverik.infogovernor.svc.model.condition.OrganizationServiceSearchCondImpl;
import com.deliverik.infogovernor.svc.model.condition.SummaryCountPersonSearchCondImpl;
import com.google.gson.Gson;
import com.deliverik.infogovernor.svc.model.condition.ServiceTopFiveSearchCondImpl;
import com.deliverik.infogovernor.svc.vo.IGSVC06421VO;
import com.deliverik.infogovernor.util.CodeDefine;


public class IGSVC06BLImpl extends BaseBLImpl implements IGSVC06BL {
	

	private static Log log = LogFactory.getLog(IGSVC06BLImpl.class);
	
	private boolean showFlag;//如果没有数据则置为false,否则为true

	protected IG500BL ig500BL;//查询用bl
	
	protected IG259BL ig259BL;
	
	/**人员工作量共计BL*/
	protected SummaryCountPersonBL summaryCountPersonBL;
	
	/** 故障类型统计BL */
	protected IncidentTypeBL incidentTypeBL;
	
	/** 部门服务统计BL */
	protected OrganizationServiceBL organizationServiceBL;
	
	/** 部门服务top5统计BL */
	protected ServiceTopFiveVWBL serviceTopFiveVWBL;
	
	/** 时间平均解决时间统计BL */
	protected IncidentAveSolveTimeVWBL incidentAveSolveTimeVWBL;
	
	/** 年度工作趋势统计BL */
	protected AnnualTrendVWBL annualTrendVWBL;
	
	private CodeDetailBL codeDetailBL;

	public void setIg259BL(IG259BL ig259BL) {
		this.ig259BL = ig259BL;
	}
	/**
	 * @param ig500BL the ig500BL to set
	 */
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	/**
	 * 人员工作量共计BL设定
	 * @param summaryCountPersonBL
	 */
	public void setSummaryCountPersonBL(SummaryCountPersonBL summaryCountPersonBL) {
		this.summaryCountPersonBL = summaryCountPersonBL;
	}
	/**
	 * 故障类型统计BL设定
	 * @param incidentTypeBL 故障类型统计BL
	 */
	public void setIncidentTypeBL(IncidentTypeBL incidentTypeBL) {
		this.incidentTypeBL = incidentTypeBL;
	}
	/**
	 * 部门服务统计BL设定
	 * @param organizationServiceBL 部门服务统计BL
	 */
	public void setOrganizationServiceBL(OrganizationServiceBL organizationServiceBL) {
		this.organizationServiceBL = organizationServiceBL;
	}
	
	/**
	 * 部门服务top5统计BL设定
	 * @param serviceTopFiveVWBL 部门服务top5统计BL
	 */
	public void setServiceTopFiveVWBL(ServiceTopFiveVWBL serviceTopFiveVWBL) {
		this.serviceTopFiveVWBL = serviceTopFiveVWBL;
	} 
	/**
	 * 时间平均解决时间统计BL设定
	 * @param incidentAveSolveTimeVWBL 时间平均解决时间统计BL
	 */
	public void setIncidentAveSolveTimeVWBL(
			IncidentAveSolveTimeVWBL incidentAveSolveTimeVWBL) {
		this.incidentAveSolveTimeVWBL = incidentAveSolveTimeVWBL;
	}
	/**
	 * 年度工作趋势统计BL设定
	 * @param annualTrendVWBL 年度工作趋势统计BL
	 */
	public void setAnnualTrendVWBL(AnnualTrendVWBL annualTrendVWBL) {
		this.annualTrendVWBL = annualTrendVWBL;
	}
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	/**
	 * 根据统计条件查询结果,将符合条件的结果数返回
	 */
	public String findByCond(IGSVC06DTO dto) throws BLException {
		
		String count="0";
		IG500SearchCond cond = dto.getProcessRecordSearchCond();
		
		List<IG500Info> processRecordList = ig500BL.searchIG500Info(cond, 0, 0);
		if(processRecordList.size()>0){
			count=String.valueOf(processRecordList.size());
		}

		return count;
	}
	
	public List<IG259Info> getAllActiveTemplate() throws BLException {
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		//cond.setPtstatus("a");
		List<IG259Info> processTemplateList = ig259BL.searchIG259Info(cond);
		
		return processTemplateList;
	}
	
	
	/**
	 * 按种类和查询条件统计各事件的数量，将结果按XML格式拼为字符串返回给前台
	 */
	public String getXmlByCondition(IGSVC0601Form form) throws BLException {
		
		log.debug("================开始统计=================");
		showFlag = false;
		StringBuffer xml = new StringBuffer();
		String dataXml = "";
		xml.append("<chart palette='3' baseFontSize='12' bgcolor='#FFFFFF' xAxisName='月份' showValues='0' decimals='1' formatNumberScale='0' useRoundEdges='1'");

		form.setMode("1");
		String svcyear = form.getPryear();//查询年份
		String prkind = form.getPrkind();//流程类型
		String prname = form.getPrname();//流程名称
		form.setPrtype(prkind);
		form.setSelectMode("");
		
		xml.append(" caption='流程管理统计  （");
		xml.append(svcyear);
		xml.append("年 ");
		xml.append(prname);
		xml.append("数量）'>");	// yAxisName='事件'		
		xml.append(getXmlInfo(form,svcyear));//查询返回的信息

		xml.append("</chart>");
		dataXml=xml.toString();
		if(showFlag){
			form.setSvcxml(dataXml);
		}else{
			form.setSvcxml("");
		}
		log.debug("================统计结束=================");
		return dataXml;
		
	}
	
	/**
	 * 将传入月份变为2位长度的字符串
	 */
	private String getMonth(int i){
		String month = String.valueOf(i);
		if(month.length()<2){
			month="0"+month;
		}
		
		return month;
	}
	
	/**
	 * 查询具体的值并进行统计
	 */
	private String getXmlInfo(IGSVC0601Form form,String svcyear)  throws BLException {
		IGSVC06DTO igsdl06DTO = new IGSVC06DTO();
		StringBuffer xml = new StringBuffer();
		
		for(int n=1,m=13;n<m;n++){
			//设置查询起始、结束时间 格式为yyyy/mm/dd
			String querydate = svcyear+"/"+getMonth(n)+"/01";//设置查询起始日期
			form.setPrplantime(null);
			form.setPropentime(null);
			form.setPrduration(null);
			form.setPrclosetime(null);
			if(IGPROCESSType.INCIDENT_PRTYPE.equals(form.getPrkind())){
				form.setPrplantime(querydate);//发生开始时间	
			}else{
				form.setPropentime(querydate);//发起开始时间
			}

//			if(n==12){
//				querydate = String.valueOf(Integer.parseInt(svcyear)+1)+"/01/01";
//			}else{
//				querydate = svcyear+"/"+getMonth(n)+"/31";
//			}
			
			querydate = svcyear+"/"+getMonth(n)+"/31";//设置查询结束日期
			
			if(IGPROCESSType.INCIDENT_PRTYPE.equals(form.getPrkind())){
				form.setPrduration(querydate);//发生结束时间
			}else{
				form.setPrclosetime(querydate);//发起结束时间
			}
			//调用查询
			igsdl06DTO.setProcessRecordSearchCond(form);
			String value = findByCond(igsdl06DTO);
			
			if(!"0".equals(value)){
				showFlag = true;
			}
			
			//拼写xml
			xml.append("<set label='");
			xml.append(n);
			xml.append("月' value='");
			xml.append(value);
			xml.append("' />");

		}
		
		return xml.toString();
	}
	
	/**
	 * 故障类型统计数据查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchIncidentTypeAction(IGSVC06DTO dto) throws BLException{
		log.debug("========故障类型统计数据查询操作开始=======");
		//dto参数取得
		IGSVC0635Form form = dto.getIgsvc0635Form();
		//实例化查询条件
		IncidentTypeSearchCondImpl cond = new IncidentTypeSearchCondImpl();
		cond.setPdid("01080");
		cond.setYear(form.getYear());
		cond.setMonth(form.getMonth());
		IncidentTypeVWInfo data = incidentTypeBL.searchIncidentTypeData(cond);
		dto.setIncidentType(data);
		log.debug("========故障类型统计数据查询操作结束=======");
		return dto;
	}
	
	/**
	 * 部门服务统计查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchOrganizationServiceAction(IGSVC06DTO dto) throws BLException{
		log.debug("===========部门服务统计数据查询操作开始==========");
		//dto参数取得
		IGSVC0636Form form = dto.getIgsvc0636Form();
		//实例化查询条件
		OrganizationServiceSearchCondImpl cond = new OrganizationServiceSearchCondImpl();
		cond.setYear(form.getYear());
		cond.setMonth(form.getMonth());
		cond.setIpdid("01080");
		cond.setSpdid("01100");
		List<OrganizationServiceVWInfo> list = organizationServiceBL.searchOrganizationService(cond);
		if(list != null && list.size() > 0){
			Integer icount = 0;
			Integer scount = 0;
			Integer gcount = 0;
			for(OrganizationServiceVWInfo info:list){
				icount += info.getIncidentCount();
				scount += info.getServiceCount();
				gcount += info.getGdCount();
			}
			Integer totalCount = icount + scount + gcount;
			dto.setOrganizationServiceList(list);
			dto.setIcount(icount);
			dto.setScount(scount);
			dto.setGcount(gcount);
			dto.setTotalCount(totalCount);
		}
		
		log.debug("===========部门服务统计数据查询操作结束==========");
		return dto;
	}
	
	/**
	 * 查询人员工作量统计数据
	 * @param cond 检索条件
	 * @return
	 */
	public IGSVC06DTO searchSummary(IGSVC06DTO dto)throws BLException{
		
		SummaryCountPersonSearchCondImpl cond = new SummaryCountPersonSearchCondImpl();
		
		IGSVC0639Form form = dto.getIgsvc0639Form();
		cond.setYear(form.getYear());
		cond.setMonth(form.getMonth());
		
		List<IG160Info> list = summaryCountPersonBL.searchSummary(cond);
		//人员的集合
		List<String> presons = new ArrayList<String>();
		//统计信息的map格式配合heighcharts图标的数据格式
		Map<String,List<Integer>> acountMap = new HashMap<String, List<Integer>>();
		List<Integer> works = new LinkedList<Integer>();
		List<Integer> changes = new LinkedList<Integer>();
		List<Integer> asks = new LinkedList<Integer>();
		List<Integer> problems = new LinkedList<Integer>();
		List<Integer> incidents = new LinkedList<Integer>();
		
		//遍历结果集装载数据
		for (IG160Info ig160Info : list) {
			
			//舍弃没有数据的人员信息
			
			if(ig160Info.getWork()!=null||ig160Info.getChange()!=null){
				presons.add(ig160Info.getPpusername());
				works.add(ig160Info.getWork()==null?0:ig160Info.getWork()); 
				changes.add(ig160Info.getChange());
				asks.add(ig160Info.getAsk());
				problems.add(ig160Info.getProblem());
				incidents.add(ig160Info.getIncident());
			}
		}
		acountMap.put("服务工单", works);
		acountMap.put("变更", changes);
		acountMap.put("请求", asks);
		acountMap.put("问题", problems);
		acountMap.put("事件", incidents);
		Gson gson = new Gson();
		String presonsJson = gson.toJson(presons);
		String acountJson = gson.toJson(acountMap);
		
		dto.setAcountJson(acountJson);
		
		dto.setPresonsJson(presonsJson);
		return dto;
	}
	

	
	/**
	 * 部门服务top5统计数据查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchServiceTopFiveDateAction(IGSVC06DTO dto) throws BLException {
		log.debug("============部门服务top5统计数据查询操作开始=============");
		//dto参数取得
		IGSVC0637Form form = dto.getIgsvc0637Form();
		//实例化查询条件
		ServiceTopFiveSearchCondImpl cond = new ServiceTopFiveSearchCondImpl();
		cond.setIpdid("01080");
		cond.setSpdid("01100");
		cond.setYear(form.getYear());
		cond.setMonth(form.getMonth());
		cond.setType(form.getType());
		List<ServiceTopFiveVWInfo> list = serviceTopFiveVWBL.searchServiceDate(cond);
		dto.setServiceTopFiveList(list);
		log.debug("============部门服务top5统计数据查询操作结束=============");
		return dto;
	}
	
	/**
	 * 时间平均解决时间统计数据查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchIncidentAveSolveTimeAction(IGSVC06DTO dto) throws BLException {
		log.debug("===========时间平均解决时间统计数据查询操作开始==========");
		//dto参数取得
		IGSVC0638Form form = dto.getIgsvc0638Form();
		//实例化查询条件
		IncidentAveSolveTimeSearchCondImpl cond = new IncidentAveSolveTimeSearchCondImpl();
		cond.setIpdid("01080");
		cond.setYear(form.getYear());
		cond.setMonth(form.getMonth());
		List<IncidentAveSolveTimeVWInfo> list = incidentAveSolveTimeVWBL.searchSolveTimeData(cond);
		if(list != null && list.size() > 0){
			dto.setIncidentAveSolveTimeDate(list);
		}
		log.debug("===========时间平均解决时间统计数据查询操作结束==========");
		return dto;
	}
	
	/**
	 * 年度工作趋势统计数据查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchAnnualTrendVWAction(IGSVC06DTO dto) throws BLException{
		log.debug("========年度工作趋势统计数据查询操作开始=======");
		//dto参数取得
		IGSVC0640Form form = dto.getIgsvc0640Form();
		//实例化查询条件
		AnnualTrendVWSearchCondImpl cond = new AnnualTrendVWSearchCondImpl();
		cond.setYear(form.getYear());
		cond.setOrgid(form.getOrgid());
		List<AnnualTrendVWInfo> annualTrendVWList = this.annualTrendVWBL.searchIncidentTypeData(cond);
		Integer[] incidentnum = {0,0,0,0,0,0,0,0,0,0,0,0};
		Integer[] problemnum = {0,0,0,0,0,0,0,0,0,0,0,0};
		Integer[] changenum = {0,0,0,0,0,0,0,0,0,0,0,0};
		Integer[] servicenum = {0,0,0,0,0,0,0,0,0,0,0,0};
		Integer[] sfnum = {0,0,0,0,0,0,0,0,0,0,0,0};
		String[] numOrder = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		for (String no : numOrder) {
			for (AnnualTrendVWInfo annualTrendVWInfo : annualTrendVWList) {
				Integer a = (Integer.valueOf(no)-1);
				if(no.equals(annualTrendVWInfo.getPropentime().subSequence(5, 7))){
					incidentnum[a] = annualTrendVWInfo.getIncidentnum();
					problemnum[a] = annualTrendVWInfo.getProblemnum();
					changenum[a] = annualTrendVWInfo.getChangenum();
					servicenum[a] = annualTrendVWInfo.getServicenum();
					sfnum[a] = annualTrendVWInfo.getSfnum();
				}
			}
		}
		String incident = "";
		String problem = "";
		String change = "";
		String service = "";
		String sf = "";
		for (Integer i : incidentnum) {
			incident+=i+",";
		}
		for (Integer p : problemnum) {
			problem+=p+",";
		}
		for (Integer c : changenum) {
			change+=c+",";
		}
		for (Integer s : servicenum) {
			service+=s+",";
		}
		for (Integer s : sfnum) {
			sf+=s+",";
		}
		dto.setIncidentnum(incident);
		dto.setProblemnum(problem);
		dto.setChangenum(change);
		dto.setServicenum(service);
		dto.setSfnum(sf);
		log.debug("========年度工作趋势统计数据查询操作结束=======");
		return dto;
	}
	
	/**
	 * 流程数量统计数据查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchProcessRecordCountAction(IGSVC06DTO dto) throws BLException {
		log.debug("==========流程数量统计数据查询操作开始===========");
		//dto参数取得
		IGSVC0642Form form = dto.getIgsvc0642Form();
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPropentime(form.getPropentime_from());
		cond.setPrclosetime(form.getPropentime_to());
		List<IG500Info> list = ig500BL.searchIG500Info(cond);
		//事件总数
		int countI = 0;
		//事件未关闭数量
		int countI_E = 0;
		//事件已关闭数量
		int countI_C = 0;
		//问题总数
		int countP = 0;
		//问题未关闭数量
		int countP_E = 0;
		//问题已关闭数量
		int countP_C = 0;
		//变更总数
		int countC = 0;
		//变更未关闭数量
		int countC_E = 0;
		//变更已关闭数量
		int countC_C = 0;
		
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.PRPDID.getCcid());
        List<CodeDetail> cds = codeDetailBL.searchCodeDetail(condimpl,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
        for(IG500Info info:list){
        	if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(info.getPrstatus())){
        		continue;
        	}
        	for(CodeDetail cd:cds){
        		if(info.getPrpdid().startsWith(cd.getCvalue())){
        			 if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.INCIDENT_PRTYPE))){
        				 if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(info.getPrstatus())){
        					 countI_C ++ ;
        				 }else{
        					 countI_E ++ ;
        				 }
        				 countI ++;
        			 }
        			 if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.PROBLEM_PRTYPE))){
        				 if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(info.getPrstatus())){
        					 countP_C ++ ;
        				 }else{
        					 countP_E ++ ;
        				 }
        				 countP ++;
        			 }
        			 if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.CHANGE_PRTYPE))){
        				 if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(info.getPrstatus())){
        					 countP_C ++ ;
        				 }else{
        					 countP_E ++ ;
        				 }
        				 countC ++;
        			 }
        			break;
        		}
        	}
        }
        IGSVC06421VO vo = new IGSVC06421VO();
		vo.setCountC(countC);
		vo.setCountC_C(countC_C);
		vo.setCountC_E(countC_E);
		vo.setCountI(countI);
		vo.setCountI_C(countI_C);
		vo.setCountI_E(countI_E);
		vo.setCountP(countP);
		vo.setCountP_C(countP_C);
		vo.setCountP_E(countP_E);
		dto.setIgsvc06421VO(vo);
		log.debug("==========流程数量统计数据查询操作结束===========");
		return dto;
	}
}
