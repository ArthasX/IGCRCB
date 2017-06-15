package com.deliverik.infogovernor.bl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG933BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG933SearchCondImpl;
import com.deliverik.infogovernor.dto.IGCOM04DTO;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0601Form;
import com.deliverik.infogovernor.sym.bl.IGSYM03BLImpl;
import com.deliverik.infogovernor.vo.IGCOM03041VO;

/**
 * 修改记录：yangliang 2010/12/01 增加获取全部工作
 * 修改记录：LuJiayuan 2013/01/31 版本迁移SOC原功能由原来的IGCOM04BL更名为IGCOM07BL
 */
public class IGCOM07BLImpl extends BaseBLImpl implements IGCOM07BL {
	
	private static Log log = LogFactory.getLog(IGCOM07BLImpl.class);
	
	public static final String incperm = "ACT02SVC0204";//事件查看权限
	
	public static final String wkmperm = "ACT02SVC0901";//工作查看权限
	
	public static final String prjperm = "ACT03SDL0301";//项目查看权限
	
	public static final String serperm = "ACT02SVC0605";//服务请求查看权限
	
	protected IG500BL ig500BL;
	
	protected IG259BL ig259BL;
	
	protected UserRoleBL userRoleBL;
	
	protected IG933BL ig933BL;
	
	protected UserBL userBL;
	
	//图形统计用
	private final String workType = "W";//工作类型

	protected Map<String,String> nameURLMap = new HashMap<String,String>();
	protected Map<String,String> allnameURLMap = new HashMap<String,String>();
	
	/**
	 * 现场工程师角色ID
	 */
	public static final String socRoleid = ResourceUtility.getString("SOCROLEID");
	
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	public void setIg259BL(IG259BL ig259BL) {
		this.ig259BL = ig259BL;
	}

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public void setIg933BL(IG933BL ig933BL) {
		this.ig933BL = ig933BL;
	}
	
	public IGCOM04DTO getWorkAssigned(IGCOM04DTO dto) throws BLException {
		IGCOM03041VO vo = new IGCOM03041VO();
		String userId = dto.getUserId();
		List<IG677Info> processRecordInfoForMeList = ig500BL.getTodoProcessRecordsByUser(userId, "","",null);
		vo.setProcessRecordInfoForMeList(processRecordInfoForMeList);
		this.setInfoToVO(vo,dto);//设置仪表图形xml
		this.setWorkAssignedToMyGroupToVO(vo, dto, processRecordInfoForMeList);
		
		this.setServiceRequestCountToVO(vo,dto);
		vo.setUrlMap(nameURLMap);
		vo.setColxml(getColXmlByCondition());//设置柱形图xml
		vo.setPiexml(getPieXmlInfo());//设置饼形图xml
		dto.setIgcom03041VO(vo);
		return dto;
	}
	
	@SuppressWarnings("unchecked")
	public IGCOM04DTO getProcessRecordList(IGCOM04DTO dto) throws BLException {
//		IGCOM03041VO vo = new IGCOM03041VO();
//		String userId = dto.getUserId();
//		List<IG677Info> processRecordInfoForGroupoList = ig500BL.getTodoProcessRecordsByUser(userId, "",userId);
//		
//		Map<String,String> varList = ig500BL.getProcessInfoDefGeneral(processRecordInfoForGroupoList);
//		
//		List aboutmeList = new ArrayList();
//		
//		this.setInfoToVOForMangerPortal(vo,dto);//为领导首页设置仪表图形xml
//		
//		this.setServiceRequestCountToVO(vo,dto);
//		aboutmeList.addAll(processRecordInfoForGroupoList);
//		
//		List groupListTmp = new ArrayList();
//		List<IG677Info> groupListTmpAsc = new ArrayList();
//
//		for(int i=0;i<processRecordInfoForGroupoList.size();i++){
//			IGCOM04031VO vo04 = new IGCOM04031VO();
//			IG677VW obj = (IG677VW)processRecordInfoForGroupoList.get(i);
//			BeanUtils.copyProperties(obj, vo04);
//			if((IGPROCESSType.CHANGE_PRTYPE.equals(obj.getPrtype()))||IGPROCESSType.DEPLOYMENT_PRTYPE.equals(obj.getPrtype())){
//				vo04.setPropentime(obj.getPrplantime());
//			}
//			groupListTmp.add(vo04);
//		}
//		
//		groupListTmpAsc.addAll(groupListTmp);
//
//		Collections.sort(groupListTmp, new Comparator<IGCOM04031VO>(){
//			public int compare(IGCOM04031VO o1, IGCOM04031VO o2){ 
//				return o1.getPropentime().compareTo(o2.getPropentime());
//			}
//		});
//		Collections.sort(groupListTmpAsc, new Comparator<IG677Info>(){
//			public int compare(IG677Info o1, IG677Info o2){ 
//				return o2.getPropentime().compareTo(o1.getPropentime());
//			}
//		});
//		for (IG677Info processRecordInfo : groupListTmpAsc) {
//			Integer prid = processRecordInfo.getPrid();
//			setDetailURLToMAP(processRecordInfo.getPrtype(),String.valueOf(prid));
//		}
//		vo.setUrlMap(nameURLMap);
//		vo.setColxml(getColXmlByCondition());//设置柱形图xml
//		vo.setPiexml(getPieXmlInfo());//设置饼形图xml
//	
//		/** 修改 by yangliang  将原来用的Group 改成 me 
//		 * vo.setProcessRecordInfoForGroupList(groupListTmp);
//		 * vo.setProcessRecordInfoForGroupListAsc(groupListTmpAsc);	
//		 */		
//		vo.setProcessRecordInfoForMeList(groupListTmp);
//		vo.setProcessRecordInfoForMeListAsc(groupListTmpAsc);
//		
//		vo.setSocxml(getSocXml());
//		vo.setVarList(varList);
//		dto.setIgcom03041VO(vo);
//		//yangliang  增加全部工作
//		getProcessRecordListALL(dto);
		return dto;
	}

	/**
	 * 获取全部工作  yangliang 2010/12/01
	 * @param dto
	 * @return IGCOM04DTO
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public IGCOM04DTO getProcessRecordListALL(IGCOM04DTO dto) throws BLException {
//		IGCOM03041VO vo = dto.getIgcom03041VO();
//		String userId = dto.getUserId();
//		List<IG677Info> processRecordInfoForGroupoList = ig500BL.getTodoProcessRecordsALL(userId, "",userId);
//		Map<String,String> varList = ig500BL.getProcessInfoDefGeneral(processRecordInfoForGroupoList);		
//		List aboutmeList = new ArrayList();
//
//		aboutmeList.addAll(processRecordInfoForGroupoList);
//
//		List groupListTmp = new ArrayList();
//
//		List<IG677Info> groupListTmpAsc = new ArrayList();
//
//		for(int i=0;i<processRecordInfoForGroupoList.size();i++){
//			IGCOM04031VO vo04 = new IGCOM04031VO();
//			IG677VW obj = (IG677VW)processRecordInfoForGroupoList.get(i);
//			BeanUtils.copyProperties(obj, vo04);
//			if((IGPROCESSType.CHANGE_PRTYPE.equals(obj.getPrtype()))||IGPROCESSType.DEPLOYMENT_PRTYPE.equals(obj.getPrtype())){
//				vo04.setPropentime(obj.getPrplantime());
//			}
//		
//			groupListTmp.add(vo04);
//		}
//
//		groupListTmpAsc.addAll(groupListTmp);
//
//		Collections.sort(groupListTmp, new Comparator<IGCOM04031VO>(){
//			public int compare(IGCOM04031VO o1, IGCOM04031VO o2){ 
//				return o1.getPropentime().compareTo(o2.getPropentime());
//			}
//		});
//
//		Collections.sort(groupListTmpAsc, new Comparator<IG677Info>(){
//			public int compare(IG677Info o1, IG677Info o2){ 
//				return o2.getPropentime().compareTo(o1.getPropentime());
//			}
//		});	
//		for (IG677Info processRecordInfo : groupListTmpAsc) {
//			Integer prid = processRecordInfo.getPrid();
//			setDetailURLToMAPALL(processRecordInfo.getPrtype(),String.valueOf(prid));
//		}
//		vo.setAllurlMap(allnameURLMap);		
//		vo.setProcessRecordInfoForGroupList(groupListTmp);
//		vo.setProcessRecordInfoForGroupListAsc(groupListTmpAsc);
//		vo.setVarAllList(varList);
		return dto;	
	}
	
	/**
	 * 根据统计条件查询结果,将符合条件的结果数返回
	 */
	public String findByCond(IGSVC06DTO dto) throws BLException {
		String count="0";

		IG500SearchCond cond = dto.getProcessRecordSearchCond();
		
		List<IG500Info> processRecordList = ig500BL.searchIG500Info(cond);
		if(processRecordList.size()>0){
			count=String.valueOf(processRecordList.size());
		}
		return count;
	}
	
	public List<IG259Info> getAllActiveTemplate() throws BLException {
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		
		List<IG259Info> processTemplateList = ig259BL.searchIG259Info(cond);
		
		return processTemplateList;
	}
	
	/**
	 * portal页饼形图统计
	 */
	private String getPieXmlInfo()  throws BLException {
		String xmlinfo = "";
		StringBuffer xml = new StringBuffer();
		try{
			xml.append("<chart palette='4' use3DLighting='0' enableRotation='0'   chartTopMargin='5' chartBottomMargin='5' chartLeftMargin='5' chartRightMargin='5'  baseFontSize='12' bgcolor='#FFFFFF' canvasBorderAlpha='50' showBorder='0'  canvasBgAlpha='50' canvasBgColor='#FFFFFF' decimals='0' enableSmartLabels='1' enableRotation='0'  bgAlpha='40,100' bgRatio='0,100' bgAngle='360'  startingAngle='70' >");
			
			SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
			String nowYear = sdfTime.format(new Date()).split("-")[0];//当前年
			String start_time = nowYear+"/01/01";
			String end_time = nowYear+"/12/31";

			//按工作类型统计各类型工作数量
			Field[] fieldList = IGPROCESSType.class.getFields();
			
			//统计流程数量
			for(int i=0,j=fieldList.length;i<j;i++){
				Field field = fieldList[i];//取得属性
				String label = field.get(new IGPROCESSType()).toString();//取得属性值
				boolean isSliced = false;
				if(IGPROCESSType.WORK_PRTYPE.equals(label)){
					continue;
				}
				//基本流程类型统计
				IG500SearchCondImpl cond = new IG500SearchCondImpl();
				cond.setPrtype(label);
				if(IGPROCESSType.INCIDENT_PRTYPE.equals(label)){
					isSliced = true;
					cond.setPrplantime(start_time);//发生开始时间
					cond.setPrduration(end_time);//发生结束时间
				}else{
					cond.setPropentime(start_time);//发起开始时间
					cond.setPrclosetime(end_time);//发起结束时间
				}
				int totalCount= this.ig500BL.getIG500InfoSearchCount(cond);
				
				xml.append(getPieSetLabel(IGPROCESSType.getTypeName(label),String.valueOf(totalCount),isSliced));
			}
			xml.append("</chart>");
			
			xmlinfo = xml.toString();	
		}catch(IllegalArgumentException e){
			log.debug(e.getMessage());
		}catch(IllegalAccessException iae){
			log.debug(iae.getMessage());
		}
		return xmlinfo;
	}
	
	/**
	 * portal页饼形图设置set标签
	 */
	private String getPieSetLabel(String label,String value,boolean isSliced)  throws BLException {
		StringBuffer xml = new StringBuffer();
		
		xml.append("<set label='");
		xml.append(label);
		xml.append("' value='");
		xml.append(value);
		if(isSliced){
			xml.append("' isSliced='1' />");
		}else{
			xml.append("' />");
		}
		return xml.toString();
	}
	
	/**
	 * portal页查询未关闭的工作、问题、事件的数量，将结果按柱形图XML格式拼为字符串返回
	 */
	public String getColXmlByCondition() throws BLException {
		
		log.debug("================开始柱形统计=================");

		IGSVC0601Form form = new IGSVC0601Form();
		StringBuffer xml = new StringBuffer();
		String dataXml = "";
		xml.append("<chart palette='2' baseFontSize='12' bgcolor='#FFFFFF' canvasBorderAlpha='50' showBorder='0'  canvasBgAlpha='50' canvasBgColor='#FFFFFF'  caption='' subCaption='' showValues='0' divLineDecimalPrecision='1' limitsDecimalPrecision='1' PYAxisName='' SYAxisName='' numberPrefix='' formatNumberScale='1'>");
		xml.append("<categories><category label='1月' /><category label='2月' /><category label='3月' /><category label='4月' /><category label='5月' /><category label='6月' /><category label='7月' />");
		xml.append("<category label='8月' /><category label='9月' /><category label='10月' /><category label='11月' /><category label='12月' /></categories>");
		
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
		String nowYear = sdfTime.format(new Date()).split("-")[0];//当前年
		form.setPryear(nowYear);
		form.setMode("1");
		
		form.setSelectMode("");
		for(int i=0,j=3;i<j;i++){
			String prkind = "";//流程类型
			if(i==0){
				//工作
				prkind = workType;
				xml.append("<dataset seriesName='工作'>");
			}else if(i==1){
				/*//问题
				prkind = IGPROCESSType.PROBLEM_PRTYPE;
				form.setPrkind(prkind);
				xml.append("<dataset seriesName='");
				xml.append("问题");
				xml.append("' renderAs='Area' parentYAxis='P'>");*/
				//变更
				prkind = IGPROCESSType.CHANGE_PRTYPE;
				form.setPrkind(prkind);
				xml.append("<dataset seriesName='");
				xml.append("变更");
				xml.append("' renderAs='Area' parentYAxis='P'>");
			}else if(i==2){
				
				//事件
				prkind = IGPROCESSType.INCIDENT_PRTYPE;	
				form.setPrkind(prkind);
				xml.append("<dataset seriesName='");
				xml.append("事件");
				xml.append("' lineThickness='3' parentYAxis='S'>");
			}
			
			form.setPrtype(prkind);
			xml.append(getColXmlInfo(form,nowYear,prkind));
			xml.append("</dataset>");
			
		}
		
		xml.append("</chart>");
		dataXml=xml.toString();
		
		log.debug("================柱形统计结束=================");
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
	private String getColXmlInfo(IGSVC0601Form form,String svcyear,String prkind)  throws BLException {
		IGSVC06DTO igsdl06DTO = new IGSVC06DTO();
		StringBuffer xml = new StringBuffer();
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		for(int n=1,m=13;n<m;n++){
			//设置查询起始、结束时间 格式为yyyy/mm
			String querydate = svcyear+"/"+getMonth(n)+"/01";//设置查询起始日期
			form.setPrplantime(null);
			form.setPropentime(null);
			form.setPrduration(null);
			form.setPrclosetime(null);
			
			form.setPropentime(querydate);//发起时间
			cond.setPropentime(querydate);
			
			querydate = svcyear+"/"+getMonth(n)+"/31";//设置查询结束日期
			
			form.setPrclosetime(querydate);//发起时间
			cond.setPrclosetime(querydate);
			//调用查询
			igsdl06DTO.setProcessRecordSearchCond(form);
			String value = "";
			if(workType.equals(prkind)){
				//统计本年度的全部工作数量	
				cond.setPrtype(null);
				cond.setIsWork(1);
				int workTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
				value = String.valueOf(workTotalCount);
			}else {
				value = findByCond(igsdl06DTO);
			}
			
			//拼写xml
			xml.append("<set value='");
			xml.append(value);
			xml.append("' />");
		}
		return xml.toString();
	}
	
	/**
	 * portal页仪表图形统计
	 */
	private String getAngularXmlInfo(String count,String url,String type,IGCOM04DTO dto)  throws BLException {
		String xmlinfo = "";
		StringBuffer xml = new StringBuffer();
		String lowerLimit = ResourceUtility.getString("ANGULAR_LOWERLIMIT")==null?"0":ResourceUtility.getString("ANGULAR_LOWERLIMIT");
		String upperLimit = ResourceUtility.getString("ANGULAR_UPPERLIMIT")==null?"60":ResourceUtility.getString("ANGULAR_UPPERLIMIT");
		if("INC".equals(type)){
			upperLimit = "20";
		}else if("WKM".equals(type)){
			upperLimit = "60";
		}else if("PRJ".equals(type)){
			upperLimit = "40";
		}else if("SER".equals(type)){
			upperLimit = "60";
		}

		xml.append("<chart bgAlpha='0' bgColor='FFFFFF' ");
		if(Integer.valueOf(count)>0){
			//当前用户拥有相应菜单的权限时才添加url
			if("INC".equals(type)){
				if(dto.getPerm()!=null && dto.getPerm().checkPermission(IGCOM04BLImpl.incperm)){
					xml.append("clickURL='");
					xml.append(url);
					xml.append("'");
				}
			}else if("WKM".equals(type)){
				if(dto.getPerm()!=null && dto.getPerm().checkPermission(IGCOM04BLImpl.wkmperm)){
					xml.append("clickURL='");
					xml.append(url);
					xml.append("'");
				}
			}else if("PRJ".equals(type)){
				if(dto.getPerm()!=null && dto.getPerm().checkPermission(IGCOM04BLImpl.prjperm)){
					xml.append("clickURL='");
					xml.append(url);
					xml.append("'");
				}
			}else if("SER".equals(type)){
				if(dto.getPerm()!=null && dto.getPerm().checkPermission(IGCOM04BLImpl.serperm)){
					xml.append("clickURL='");
					xml.append(url);
					xml.append("'");
				}
			}
		}
		xml.append(" lowerLimit='");
		xml.append(lowerLimit);
		xml.append("' upperLimit='");
		xml.append(upperLimit);
		xml.append("'  showBorder='0' basefontColor='000000'  chartTopMargin='10' chartBottomMargin='20' chartLeftMargin='10' chartRightMargin='10' toolTipBgColor='80A905' gaugeFillMix='{dark-10},FFFFFF,{dark-10}' gaugeFillRatio='3'>");
		xml.append("<colorRange>");
		if("INC".equals(type)){
			xml.append("<color minValue='0' maxValue='10' code='8BBA00'/><color minValue='10' maxValue='15' code='F6BD0F'/><color minValue='15' maxValue='20' code='FF654F'/>");
		}else if("WKM".equals(type)){
			xml.append("<color minValue='0' maxValue='30' code='8BBA00'/><color minValue='30' maxValue='45' code='F6BD0F'/><color minValue='45' maxValue='60' code='FF654F'/>");
		}else if("PRJ".equals(type)){
			xml.append("<color minValue='0' maxValue='20' code='8BBA00'/><color minValue='20' maxValue='30' code='F6BD0F'/><color minValue='30' maxValue='40' code='FF654F'/>");		
		}else if("SER".equals(type)){
			xml.append("<color minValue='0' maxValue='30' code='8BBA00'/><color minValue='30' maxValue='45' code='F6BD0F'/><color minValue='45' maxValue='60' code='FF654F'/>");		
		}
		xml.append("</colorRange>");
		xml.append("<dials><dial value='");
		xml.append(count);
		xml.append("' rearExtension='10' />");
		xml.append("</dials></chart>");
		
		xmlinfo = xml.toString();
		return xmlinfo;
	}
	
	/**
	 * portal页仪表图形统计(3表合1)
	 */
	private String getAngularXmlInfoForThreeOnOne(String incCount,String wkmCount,String serviceCount,IGCOM04DTO dto)  throws BLException {
		String xmlinfo = "";
		StringBuffer xml = new StringBuffer();
		String lowerLimit = ResourceUtility.getString("ANGULAR_LOWERLIMIT")==null?"0":ResourceUtility.getString("ANGULAR_LOWERLIMIT");
		String upperLimit = ResourceUtility.getString("ANGULAR_UPPERLIMIT")==null?"60":ResourceUtility.getString("ANGULAR_UPPERLIMIT");
		if(StringUtils.isEmpty(lowerLimit)){
			upperLimit = "0";
		}
		if(StringUtils.isEmpty(upperLimit)){
			upperLimit = "60";
		}

		xml.append("<chart bgAlpha='0' bgColor='FFFFFF' ");

		xml.append(" lowerLimit='");
		xml.append(lowerLimit);
		xml.append("' upperLimit='");
		xml.append(upperLimit);
		xml.append("'  showBorder='0' basefontColor='000000'  baseFontSize='12' gaugeOuterRadius='100' gaugeInnerRadius='80%' chartTopMargin='10' chartBottomMargin='20' chartLeftMargin='10' chartRightMargin='10' toolTipBgColor='80A905' gaugeFillMix='{dark-10},FFFFFF,{dark-10}' gaugeFillRatio='3'>");
		xml.append("<colorRange>");
		
		xml.append("<color minValue='0' maxValue='20' code='8BBA00'/><color minValue='20' maxValue='40' code='F6BD0F'/><color minValue='40' maxValue='60' code='FF654F'/>");
		
		xml.append("</colorRange>");
		xml.append("<dials>");
		//添加事件
		xml.append("<dial value='");
		xml.append(incCount);
		xml.append("' rearExtension='10' bgcolor='66cc33' />");
		//添加工作
		xml.append("<dial value='");
		xml.append(wkmCount);
		xml.append("' rearExtension='10' bgcolor='a6d4ec' />");
		//添加服务请求
		xml.append("<dial value='");
		xml.append(serviceCount);
		xml.append("' rearExtension='10' bgcolor='F08080' />");
		xml.append("</dials></chart>");
		
		xmlinfo = xml.toString();
		return xmlinfo;
	}
	
	/**
	 * 领导首页仪表图形化信息生成
	 * @param vo
	 * @param dto
	 * @throws BLException
	 */
	private void setInfoToVOForMangerPortal(IGCOM03041VO vo,IGCOM04DTO dto) throws BLException{
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		log.debug("================仪表图形（事件、工作、服务请求）统计开始=================");
		//事件
		cond.setPrActive("Y");
		cond.setPrtype(IGPROCESSType.INCIDENT_PRTYPE);

		int incidentTotalCount= this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setIncidentTotalCount(incidentTotalCount);
		
		cond.setPrtype(IGPROCESSType.PROBLEM_PRTYPE);
		int problemTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setProblemTotalCount(problemTotalCount);
		cond.setPrtype(IGPROCESSType.CHANGE_PRTYPE);
		int changeTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setChangeTotalCount(changeTotalCount);
		cond.setPrtype(IGPROCESSType.DEPLOYMENT_PRTYPE);
		int deploymentTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setDeploymentTotalCount(deploymentTotalCount);
		
		cond.setPrtype(null);
		cond.setIsWork(1);
		
		int workTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setWorkTotalCount(workTotalCount);

		IG500SearchCondImpl sercond = new IG500SearchCondImpl();

		//变更
		sercond.setPrActive("Y");
		sercond.setPrtype(IGPROCESSType.CHANGE_PRTYPE);
		
		int serviceTotalCount= this.ig500BL.getIG500InfoSearchCount(sercond);
		vo.setServiceTotalCount(serviceTotalCount);
		//统计
		String xmlinfo = getAngularXmlInfoForThreeOnOne(String.valueOf(incidentTotalCount),String.valueOf(workTotalCount),String.valueOf(serviceTotalCount),dto);
		vo.setIncxml(xmlinfo);
		log.debug("================仪表图形（事件、工作、服务请求）统计结束=================");
	}
	
	private void setInfoToVO(IGCOM03041VO vo,IGCOM04DTO dto) throws BLException{
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		log.debug("================仪表图形（事件）统计开始=================");
		//事件
		cond.setPrActive("Y");
		cond.setPrtype(IGPROCESSType.INCIDENT_PRTYPE);
		cond.setPrstatus("E");
		int incidentTotalCount= this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setIncidentTotalCount(incidentTotalCount);
		//统计事件(仪表)
		String xmlinfo = getAngularXmlInfo(String.valueOf(incidentTotalCount),"IGCOM0202.do?linkID=IGSVC0204","INC",dto);
		
		vo.setIncxml(xmlinfo);
		log.debug("================仪表图形（事件）统计结束=================");
		
		cond.setPrtype(IGPROCESSType.PROBLEM_PRTYPE);
		int problemTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setProblemTotalCount(problemTotalCount);
		cond.setPrtype(IGPROCESSType.CHANGE_PRTYPE);
		int changeTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setChangeTotalCount(changeTotalCount);
		cond.setPrtype(IGPROCESSType.DEPLOYMENT_PRTYPE);
		int deploymentTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setDeploymentTotalCount(deploymentTotalCount);
		
		log.debug("================仪表图形（工作）统计开始=================");
		cond.setPrtype(null);
		cond.setIsWork(1);
		cond.setPrstatus("");
		int workTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setWorkTotalCount(workTotalCount);
		//统计工作(仪表)
		xmlinfo = getAngularXmlInfo(String.valueOf(workTotalCount),"IGWKM0101.do?prActive=Y","WKM",dto);
		vo.setWkmxml(xmlinfo);
		log.debug("================仪表图形（工作）统计结束=================");
	}
	
	private void setWorkAssignedToMyGroupToVO(IGCOM03041VO vo,IGCOM04DTO dto,
			List<IG677Info> processRecordInfoForMeList) throws BLException {
		List<IG677Info> processRecordInfoForGroupList = new ArrayList<IG677Info>();
		List<IG677Info> retList = new ArrayList<IG677Info>();
		List<Integer> tempList = new ArrayList<Integer>();
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(dto.getUserId());
		List<UserRoleInfo> userRoleList = userRoleBL.searchUserRoleVW(cond, 0, 0);
		if (userRoleList != null && userRoleList.size() > 0) {
			for (UserRoleInfo info : userRoleList) {
				Integer roleid = info.getRoleid();
				List<IG677Info> ret = ig500BL.getTodoProcessRecordsByRole(roleid, "");
				processRecordInfoForGroupList.addAll(ret);
			}
		}
		for(IG677Info processRecordInfo : processRecordInfoForMeList){
			Integer prid = processRecordInfo.getPrid();
			setDetailURLToMAP(processRecordInfo.getPrtype(),String.valueOf(prid));
		}
		
		processRecordInfoForGroupList.removeAll(processRecordInfoForMeList);
		//在相关工作中去掉指派工作和个人工作
		List<IG677Info> newprInfoForGroupList = new ArrayList<IG677Info>();
		for (IG677Info pr : processRecordInfoForGroupList) {
			if(!pr.getPrtype().equals(IGPROCESSType.NEW_WORK_PRTYPE_1) && !pr.getPrtype().equals(IGPROCESSType.NEW_WORK_PRTYPE_2)){
				newprInfoForGroupList.add(pr);
			}
		}
		processRecordInfoForGroupList.clear();
		processRecordInfoForGroupList.addAll(newprInfoForGroupList);
		
		for (IG677Info processRecordInfo : processRecordInfoForGroupList) {
			Integer prid = processRecordInfo.getPrid();
			setDetailURLToMAP(processRecordInfo.getPrtype(),String.valueOf(prid));
			if(tempList.contains(prid)){
				continue;
			}
			tempList.add(prid);
			retList.add(processRecordInfo);
		}
		for (UserRoleInfo info : userRoleList) {
			//服务请求集体角色过滤,发起和审批状态不可见
			if(IGSYM03BLImpl.GROUP_ROLE_MARK.equals(info.getRoledomain())) {
				for(Iterator<IG677Info> iter = retList.iterator(); iter.hasNext();) {
					IG677Info prInfo = iter.next();
					if(prInfo.getPproleid().equals(info.getRoleid())) {
						if(IGPROCESSType.SERVICE_PRTYPE.equals(prInfo.getPrtype()) && !dto.getUserId().equals(prInfo.getPpuserid())) {
							if(!WorkFlowConstDefine.DEFAULT_APPROVOR_LEVEL_FOUR.equals(prInfo.getPpsubstatus())
								&& !WorkFlowConstDefine.ADD_APPROVOR_LEVEL_FOUR.equals(prInfo.getPpsubstatus())
							) {
								iter.remove();
							}
						}
					}
				}
			}
		}
		vo.setProcessRecordInfoForGroupList(retList);
	}
	
	private void setServiceRequestCountToVO(IGCOM03041VO vo,IGCOM04DTO dto) throws BLException {
		log.debug("================仪表图形（服务请求）统计开始=================");
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		//服务请求
		cond.setPrActive("Y");
		cond.setPrtype(IGPROCESSType.SERVICE_PRTYPE);
		cond.setPrstatus("E");
		int serviceTotalCount= this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setServiceTotalCount(serviceTotalCount);
		//统计事件(仪表)
		String xmlinfo = getAngularXmlInfo(String.valueOf(serviceTotalCount),"IGCOM0202.do?linkID=IGSVC0805","SER",dto);
		vo.setSerxml(xmlinfo);
		log.debug("================仪表图形（服务请求）统计结束=================");
	}
	
	private void setDetailURLToMAP(String prtype,String prid) throws BLException{
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		List<IG259Info> processTemplateList = ig259BL.searchIG259Info(cond);
		for (IG259Info processTemplate : processTemplateList) {
			if(processTemplate.getPttype().equals(prtype)){
				nameURLMap.put(prid, processTemplate.getPtdetailpg());
			}
		}
	}
	
	private void setDetailURLToMAPALL(String prtype,String prid) throws BLException{
		//Map<String,String> nameURLMap = new HashMap<String,String>();
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		//cond.setPtstatus("a");
		List<IG259Info> processTemplateList = ig259BL.searchIG259Info(cond);
		for (IG259Info processTemplate : processTemplateList) {
			if(processTemplate.getPttype().equals(prtype)){
				allnameURLMap.put(prid, processTemplate.getPtdetailpg());
			}
		}
	}
	
	/**
	 * 写文件
	 * @param file
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unused")
	private void setIPToFile(String info) throws BLException {

		String filepath = "c:"+File.separator+"visitorsIP.txt";
		String datetime = IGStringUtils.getCurrentDateTime();
		try{
			FileWriter fw = new FileWriter(filepath,true);
			String s = "\r\n"+info + "----访问时间----"+datetime+"\r\n";
			fw.write(s,0,s.length());
			fw.flush();
			fw.close();
		}catch(IOException e){
			e.getMessage();
		}
	}
	
	/**
	 * 设置服务工单
	 * @param file
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unused")
	private void setServiceFormListToVo(IGCOM03041VO vo , IGCOM04DTO dto) throws BLException {
		log.debug("================设置服务工单开始=================");
		
		List<IG933Info> serviceFormList = null;
		String userid = dto.getUserId();
		int len = 10;
		
		IG933SearchCondImpl cond = new IG933SearchCondImpl();
		//状态条件
		cond.setSfstatus("0001");
		//全部默认
		serviceFormList = ig933BL.searchIG933Info(cond, 0, 0);
		//取前十个数据
		if(serviceFormList.size() > len) {
			serviceFormList = serviceFormList.subList(0, len);
		}
		vo.setServiceFormInfoForGroupList(serviceFormList);
		//全部时间升序
		serviceFormList = ig933BL.searchIG933InfoAsc(cond, 0, 0);
		//取前十个数据
		if(serviceFormList.size() > len) {
			serviceFormList = serviceFormList.subList(0, len);
		}
		vo.setServiceFormInfoForGroupListAsc(serviceFormList);
		
		//人员条件
		cond.setSfregisterid(userid);
		serviceFormList = ig933BL.searchIG933Info(cond, 0, 0);
		//取前十个数据
		if(serviceFormList.size() > len) {
			serviceFormList = serviceFormList.subList(0, len);	
		}
		vo.setServiceFormInfoForMeList(serviceFormList);
		
		//个人时间升序
		serviceFormList = ig933BL.searchIG933InfoAsc(cond, 0, 0);
		//取前十个数据
		if(serviceFormList.size() > len) {
			
			serviceFormList = serviceFormList.subList(0, len);
		}	
		vo.setServiceFormInfoForMeListAsc(serviceFormList);
				
		log.debug("================设置服务工单结束=================");
	}
	
	/**
	 * 统计各个现场工程师现有的工作量（未关闭流程）
	 */
	public String getSocXml() throws BLException {
		log.debug("================开始统计=================");
		StringBuffer xml = new StringBuffer();
		String dataXml = "";
		xml.append("<chart palette='3' showBorder='0' chartTopMargin='1' chartLeftMargin='4' chartBottomMargin='4' chartRightMargin='4'  baseFontSize='12' bgcolor='#FFFFFF' xAxisName='' showValues='0' decimals='1' formatNumberScale='0' useRoundEdges='1'");

		xml.append(" caption=' ");
		xml.append("'>");	
		xml.append(getXmlInfo());//查询返回的信息

		xml.append("</chart>");
		dataXml=xml.toString();

		log.debug("================统计结束=================");
		return dataXml;		
	}
	
	/**
	 * 查询具体的值并进行统计
	 */
	private String getXmlInfo()  throws BLException {
		if(socRoleid!=null && !"".equals(socRoleid)){
			StringBuffer xml = new StringBuffer();
			//查询具有现场工程师角色的用户，roletype=IGBP03,roleid=1001
			UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
			urcond.setRoleid(Integer.valueOf(socRoleid));
			List<UserRoleInfo> urList = userRoleBL.searchUserRoleVW(urcond);
			for(UserRoleInfo ur:urList){
				//调用查询
				String value = findByCondForXML(ur.getUserid());
				User user = userBL.searchUserByKey(ur.getUserid());
				//拼写xml
				xml.append("<set label='");
				xml.append(user.getUsername());
				xml.append("' value='");
				xml.append(value);
				xml.append("' />");
			}	
			return xml.toString();
		}else{
			return "";
		}
	}
	
	/**
	 * 根据统计条件查询结果,将符合条件的结果数返回
	 */
	public String findByCondForXML(String userid) throws BLException {	
		String count="0";
		List<IG677Info> processRecordList = ig500BL.getTodoProcessRecordsByUser(userid,"",null,null);
		if(processRecordList.size()>0){
			count=String.valueOf(processRecordList.size());
		}
		return count;
	}
}
