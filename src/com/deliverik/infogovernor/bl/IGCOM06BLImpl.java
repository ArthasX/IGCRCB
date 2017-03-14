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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.dto.IGCOM04DTO;
import com.deliverik.infogovernor.risk.bl.IGRIS02BL;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0601Form;
import com.deliverik.infogovernor.sym.bl.IGSYM03BLImpl;
import com.deliverik.infogovernor.vo.IGCOM03041VO;

public class IGCOM06BLImpl extends BaseBLImpl implements IGCOM06BL {
	
	private static Log log = LogFactory.getLog(IGCOM06BLImpl.class);
	
	public static final String incperm = "ACT02SVC0204";//�¼��鿴Ȩ��
	
	public static final String wkmperm = "ACT02SVC0901";//�����鿴Ȩ��
	
	public static final String prjperm = "ACT03SDL0301";//��Ŀ�鿴Ȩ��
	
	public static final String serperm = "ACT02SVC0605";//��������鿴Ȩ��
	
	protected IG500BL ig500BL;
	
	protected IG259BL ig259BL;
	
	protected UserRoleBL userRoleBL;
	
	//ͼ��ͳ����
	private final String workType = "W";//��������

	protected Map<String,String> nameURLMap = new HashMap<String,String>();
	
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	public void setIg259BL(IG259BL ig259BL) {
		this.ig259BL = ig259BL;
	}

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public IGCOM04DTO getWorkAssigned(IGCOM04DTO dto) throws BLException {
		
		IGCOM03041VO vo = new IGCOM03041VO();
		String userId = dto.getUserId();
		List<IG677Info> processRecordInfoForMeList = ig500BL.getTodoProcessRecordsByUser(userId, "",null,null);
		vo.setProcessRecordInfoForMeList(processRecordInfoForMeList);
		this.setInfoToVO(vo,dto);//�Ǳ�(�¼�������)
		//this.setWorkAssignedToMyGroupToVO(vo, dto, processRecordInfoForMeList);
		//this.setProjectCountToVO(vo);
		this.setServiceRequestCountToVO(vo,dto);//�Ǳ�(��������)
		this.setLastRiskCheckResultToVo(vo,dto);
		vo.setUrlMap(nameURLMap);
		vo.setColxml(getColXmlByCondition());//��������ͼxml
		vo.setPiexml(getPieXmlInfo());//���ñ���ͼxml
		dto.setIgcom03041VO(vo);
		return dto;
		
	}
	
	
	/**
	 * ���һ�η��ռ������ѯͳ��
	 */
	private void setLastRiskCheckResultToVo(IGCOM03041VO vo,IGCOM04DTO dto) throws BLException {
		log.debug("================���һ�η��ռ������ѯͳ�ƿ�ʼ=================");
		IGRIS02BL ris02BL = (IGRIS02BL) WebApplicationSupport.getBean("igris02BL");
		vo.setRiskCheckResultDataList(ris02BL.searchLastRiskCheckResultToVo());
		
		log.debug("================���һ�η��ռ������ѯͳ�ƽ���=================");
	}
	
	
	
	/**
	 * ����ͳ��������ѯ���,�����������Ľ��������
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
		//cond.setPtstatus("a");
		List<IG259Info> processTemplateList = ig259BL.searchIG259Info(cond);
		
		return processTemplateList;
	}
	
	/**
	 * portalҳ����ͼͳ��
	 */
	private String getPieXmlInfo()  throws BLException {
		String xmlinfo = "";
		StringBuffer xml = new StringBuffer();
		try{
			xml.append("<chart palette='4' use3DLighting='0' enableRotation='0'   chartTopMargin='5' chartBottomMargin='5' chartLeftMargin='5' chartRightMargin='5'  baseFontSize='12' bgcolor='#FFFFFF' canvasBorderAlpha='50' showBorder='0'  canvasBgAlpha='50' canvasBgColor='#FFFFFF' decimals='0' enableSmartLabels='1' enableRotation='0'  bgAlpha='40,100' bgRatio='0,100' bgAngle='360'  startingAngle='70' >");
			
			
			SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
			String nowYear = sdfTime.format(new Date()).split("-")[0];//��ǰ��
			String start_time = nowYear+"/01/01";
			String end_time = nowYear+"/12/31";

			//����������ͳ�Ƹ����͹�������
			Field[] fieldList = IGPROCESSType.class.getFields();
			
			//ͳ����������
			for(int i=0,j=fieldList.length;i<j;i++){
				Field field = fieldList[i];//ȡ������
				String label = field.get(new IGPROCESSType()).toString();//ȡ������ֵ
				boolean isSliced = false;
				if(IGPROCESSType.WORK_PRTYPE.equals(label)){
					continue;
				}
				//������������ͳ��
			
				IG500SearchCondImpl cond = new IG500SearchCondImpl();
				cond.setPrtype(label);
				if(IGPROCESSType.INCIDENT_PRTYPE.equals(label)){
					isSliced = true;
					cond.setPrplantime(start_time);//������ʼʱ��
					cond.setPrduration(end_time);//��������ʱ��
				}else{
					
					cond.setPropentime(start_time);//�������ʱ��
					cond.setPrclosetime(end_time);//�������ʱ��
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
	 * portalҳ����ͼ����set��ǩ
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
	 * portalҳ��ѯδ�رյĹ��������⡢�¼��������������������ͼXML��ʽƴΪ�ַ�������
	 */
	private String getColXmlByCondition() throws BLException {
		
		log.debug("================��ʼ����ͳ��=================");

		IGSVC0601Form form = new IGSVC0601Form();
		StringBuffer xml = new StringBuffer();
		String dataXml = "";
		xml.append("<chart palette='2' baseFontSize='12' bgcolor='#FFFFFF' canvasBorderAlpha='50' showBorder='0'  canvasBgAlpha='50' canvasBgColor='#FFFFFF'  caption='' subCaption='' showValues='0' divLineDecimalPrecision='1' limitsDecimalPrecision='1' PYAxisName='' SYAxisName='' numberPrefix='' formatNumberScale='1'>");
		xml.append("<categories><category label='1��' /><category label='2��' /><category label='3��' /><category label='4��' /><category label='5��' /><category label='6��' /><category label='7��' />");
		xml.append("<category label='8��' /><category label='9��' /><category label='10��' /><category label='11��' /><category label='12��' /></categories>");
		
		SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd");
		String nowYear = sdfTime.format(new Date()).split("-")[0];//��ǰ��
		form.setPryear(nowYear);
		form.setMode("1");
		
		form.setSelectMode("");
		for(int i=0,j=3;i<j;i++){
			
			String prkind = "";//��������
			if(i==0){
				//����
				prkind = workType;
				xml.append("<dataset seriesName='����'>");
			}else if(i==1){
				//����
				prkind = IGPROCESSType.PROBLEM_PRTYPE;
				form.setPrkind(prkind);
				xml.append("<dataset seriesName='");
				xml.append("����");
				xml.append("' renderAs='Area' parentYAxis='P'>");
			}else if(i==2){
				
				//�¼�
				prkind = IGPROCESSType.INCIDENT_PRTYPE;	
				form.setPrkind(prkind);
				xml.append("<dataset seriesName='");
				xml.append("�¼�");
				xml.append("' lineThickness='3' parentYAxis='S'>");
			}
			
			form.setPrtype(prkind);
			xml.append(getColXmlInfo(form,nowYear,prkind));
			xml.append("</dataset>");
			
		}
		
		xml.append("</chart>");
		dataXml=xml.toString();
		
		log.debug("================����ͳ�ƽ���=================");
		return dataXml;
		
	}
	
	/**
	 * �������·ݱ�Ϊ2λ���ȵ��ַ���
	 */
	private String getMonth(int i){
		String month = String.valueOf(i);
		if(month.length()<2){
			month="0"+month;
		}
		
		return month;
	}
	
	/**
	 * ��ѯ�����ֵ������ͳ��
	 */
	private String getColXmlInfo(IGSVC0601Form form,String svcyear,String prkind)  throws BLException {
		IGSVC06DTO igsdl06DTO = new IGSVC06DTO();
		StringBuffer xml = new StringBuffer();
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		for(int n=1,m=13;n<m;n++){
			//���ò�ѯ��ʼ������ʱ�� ��ʽΪyyyy/mm
			String querydate = svcyear+"/"+getMonth(n)+"/01";//���ò�ѯ��ʼ����
			form.setPrplantime(null);
			form.setPropentime(null);
			form.setPrduration(null);
			form.setPrclosetime(null);
			if(IGPROCESSType.INCIDENT_PRTYPE.equals(prkind)){
				form.setPrplantime(querydate);//����ʱ��
			}else{
				form.setPropentime(querydate);//����ʱ��
			}
			
			cond.setPropentime(querydate);
//			if(n==12){
//				querydate = String.valueOf(Integer.parseInt(svcyear)+1)+"/01/01";
//			}else{
//				querydate = svcyear+"/"+getMonth(n)+"/31";
//			}
			querydate = svcyear+"/"+getMonth(n)+"/31";//���ò�ѯ��������
			
			if(IGPROCESSType.INCIDENT_PRTYPE.equals(prkind)){
				form.setPrduration(querydate);//����ʱ��
			}else{
				form.setPrclosetime(querydate);//����ʱ��
			}
			
			cond.setPrclosetime(querydate);
			//���ò�ѯ
			igsdl06DTO.setProcessRecordSearchCond(form);
			String value = "";
			if(workType.equals(prkind)){
				//ͳ�Ʊ���ȵ�ȫ����������	
				cond.setPrtype(null);
				cond.setIsWork(1);
				int workTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
				value = String.valueOf(workTotalCount);
			}else {
				value = findByCond(igsdl06DTO);
			}
			
			//ƴдxml
			xml.append("<set value='");
			xml.append(value);
			xml.append("' />");

		}
		
		return xml.toString();
	}
	
	/**
	 * portalҳ�Ǳ�ͼ��ͳ��
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
//			xml.append("clickURL=\"JavaScript:goToDetails('");
//			xml.append(url);
//			xml.append("');\"");
			//��ǰ�û�ӵ����Ӧ�˵���Ȩ��ʱ�����url
//			if("INC".equals(type)){
//				if(dto.getPerm()!=null && dto.getPerm().checkPermission(IGCOM06BLImpl.incperm)){
//					xml.append("clickURL='");
//					xml.append(url);
//					xml.append("'");
//				}
//			}else if("WKM".equals(type)){
//				if(dto.getPerm()!=null && dto.getPerm().checkPermission(IGCOM06BLImpl.wkmperm)){
//					xml.append("clickURL='");
//					xml.append(url);
//					xml.append("'");
//				}
//			}else if("PRJ".equals(type)){
//				if(dto.getPerm()!=null && dto.getPerm().checkPermission(IGCOM06BLImpl.prjperm)){
//					xml.append("clickURL='");
//					xml.append(url);
//					xml.append("'");
//				}
//			}else if("SER".equals(type)){
//				if(dto.getPerm()!=null && dto.getPerm().checkPermission(IGCOM06BLImpl.serperm)){
//					xml.append("clickURL='");
//					xml.append(url);
//					xml.append("'");
//				}
//			}
			
		}
		xml.append(" lowerLimit='");
		xml.append(lowerLimit);
		xml.append("' upperLimit='");
		xml.append(upperLimit);
		xml.append("'  showBorder='0' basefontColor='000000' chartTopMargin='10' chartBottomMargin='20' chartLeftMargin='10' chartRightMargin='10' toolTipBgColor='80A905' gaugeFillMix='{dark-10},FFFFFF,{dark-10}' gaugeFillRatio='3'>");
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
	
	private void setInfoToVO(IGCOM03041VO vo,IGCOM04DTO dto) throws BLException{
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		log.debug("================�Ǳ�ͼ�Σ��¼���ͳ�ƿ�ʼ=================");
		//�¼�
		cond.setPrActive("Y");
		cond.setPrtype(IGPROCESSType.INCIDENT_PRTYPE);
		cond.setPrstatus("E");
		int incidentTotalCount= this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setIncidentTotalCount(incidentTotalCount);
		//ͳ���¼�(�Ǳ�)
		String xmlinfo = getAngularXmlInfo(String.valueOf(incidentTotalCount),"IGCOM0202.do?linkID=IGSVC0204","INC",dto);
		vo.setIncxml(xmlinfo);
		log.debug("================�Ǳ�ͼ�Σ��¼���ͳ�ƽ���=================");
		
		cond.setPrtype(IGPROCESSType.PROBLEM_PRTYPE);
		int problemTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setProblemTotalCount(problemTotalCount);
		cond.setPrtype(IGPROCESSType.CHANGE_PRTYPE);
		int changeTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setChangeTotalCount(changeTotalCount);
		cond.setPrtype(IGPROCESSType.DEPLOYMENT_PRTYPE);
		int deploymentTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setDeploymentTotalCount(deploymentTotalCount);
		
		log.debug("================�Ǳ�ͼ�Σ�������ͳ�ƿ�ʼ=================");
		cond.setPrtype(null);
		cond.setIsWork(1);
		cond.setPrstatus("");
		int workTotalCount = this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setWorkTotalCount(workTotalCount);
		//ͳ�ƹ���(�Ǳ�)
		xmlinfo = getAngularXmlInfo(String.valueOf(workTotalCount),"IGWKM0101.do?prActive=Y","WKM",dto);
		vo.setWkmxml(xmlinfo);
		log.debug("================�Ǳ�ͼ�Σ�������ͳ�ƽ���=================");
	}
	
	@SuppressWarnings("unused")
//	private void setWorkAssignedToMyGroupToVO(IGCOM03041VO vo,IGCOM04DTO dto,
//			List<ProcessRecordInfo> processRecordInfoForMeList) throws BLException {
//		List<ProcessRecordInfo> processRecordInfoForGroupList = new ArrayList<ProcessRecordInfo>();
//		List<ProcessRecordInfo> retList = new ArrayList<ProcessRecordInfo>();
//		List<Integer> tempList = new ArrayList<Integer>();
//		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
//		cond.setUserid(dto.getUserId());
//		List<UserRoleInfo> userRoleList = userRoleBL.searchUserRoleVW(cond, 0, 0);
//		if (userRoleList != null && userRoleList.size() > 0) {
//			for (UserRoleInfo info : userRoleList) {
//				Integer roleid = info.getRoleid();
//				List<ProcessRecordInfo> ret = ig500BL.getTodoProcessRecordsByRole(roleid, "");
//				processRecordInfoForGroupList.addAll(ret);
//			}
//		}
//		for(ProcessRecordInfo processRecordInfo : processRecordInfoForMeList){
//			Integer prid = processRecordInfo.getPrid();
//			setDetailURLToMAP(processRecordInfo.getPrtype(),String.valueOf(prid));
//		}
//		
//		processRecordInfoForGroupList.removeAll(processRecordInfoForMeList);
//		for (ProcessRecordInfo processRecordInfo : processRecordInfoForGroupList) {
//			Integer prid = processRecordInfo.getPrid();
//			setDetailURLToMAP(processRecordInfo.getPrtype(),String.valueOf(prid));
//			if(tempList.contains(prid)){
//				continue;
//			}
//			tempList.add(prid);
//			retList.add(processRecordInfo);
//		}
//		vo.setProcessRecordInfoForGroupList(retList);
//		
//	}
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
		//����ع�����ȥ��ָ�ɹ����͸��˹���
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
			//�����������ɫ����,���������״̬���ɼ�
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
		log.debug("================�Ǳ�ͼ�Σ���������ͳ�ƿ�ʼ=================");
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		//��������
		cond.setPrActive("Y");
		cond.setPrtype(IGPROCESSType.SERVICE_PRTYPE);
		cond.setPrstatus("E");
		int serviceTotalCount= this.ig500BL.getIG500InfoSearchCount(cond);
		vo.setServiceTotalCount(serviceTotalCount);
		//ͳ���¼�(�Ǳ�)
		String xmlinfo = getAngularXmlInfo(String.valueOf(serviceTotalCount),"IGCOM0202.do?linkID=IGSVC0805","SER",dto);
		vo.setSerxml(xmlinfo);
		log.debug("================�Ǳ�ͼ�Σ���������ͳ�ƽ���=================");
	}
	
	
	private void setDetailURLToMAP(String prtype,String prid) throws BLException{
		//Map<String,String> nameURLMap = new HashMap<String,String>();
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		//cond.setPtstatus("a");
		List<IG259Info> processTemplateList = ig259BL.searchIG259Info(cond);
		for (IG259Info processTemplate : processTemplateList) {
			if(processTemplate.getPttype().equals(prtype)){
				nameURLMap.put(prid, processTemplate.getPtdetailpg());
			}
			
		}
		
	}
	
	
	
	/**
	 * д�ļ�
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
			String s = "\r\n"+info + "----����ʱ��----"+datetime+"\r\n";
			fw.write(s,0,s.length());
			fw.flush();
			fw.close();

		}catch(IOException e){
			e.getMessage();
		}
		
	}


	
}
