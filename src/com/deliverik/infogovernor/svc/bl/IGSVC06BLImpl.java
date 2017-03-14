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
	
	private boolean showFlag;//���û����������Ϊfalse,����Ϊtrue

	protected IG500BL ig500BL;//��ѯ��bl
	
	protected IG259BL ig259BL;
	
	/**��Ա����������BL*/
	protected SummaryCountPersonBL summaryCountPersonBL;
	
	/** ��������ͳ��BL */
	protected IncidentTypeBL incidentTypeBL;
	
	/** ���ŷ���ͳ��BL */
	protected OrganizationServiceBL organizationServiceBL;
	
	/** ���ŷ���top5ͳ��BL */
	protected ServiceTopFiveVWBL serviceTopFiveVWBL;
	
	/** ʱ��ƽ�����ʱ��ͳ��BL */
	protected IncidentAveSolveTimeVWBL incidentAveSolveTimeVWBL;
	
	/** ��ȹ�������ͳ��BL */
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
	 * ��Ա����������BL�趨
	 * @param summaryCountPersonBL
	 */
	public void setSummaryCountPersonBL(SummaryCountPersonBL summaryCountPersonBL) {
		this.summaryCountPersonBL = summaryCountPersonBL;
	}
	/**
	 * ��������ͳ��BL�趨
	 * @param incidentTypeBL ��������ͳ��BL
	 */
	public void setIncidentTypeBL(IncidentTypeBL incidentTypeBL) {
		this.incidentTypeBL = incidentTypeBL;
	}
	/**
	 * ���ŷ���ͳ��BL�趨
	 * @param organizationServiceBL ���ŷ���ͳ��BL
	 */
	public void setOrganizationServiceBL(OrganizationServiceBL organizationServiceBL) {
		this.organizationServiceBL = organizationServiceBL;
	}
	
	/**
	 * ���ŷ���top5ͳ��BL�趨
	 * @param serviceTopFiveVWBL ���ŷ���top5ͳ��BL
	 */
	public void setServiceTopFiveVWBL(ServiceTopFiveVWBL serviceTopFiveVWBL) {
		this.serviceTopFiveVWBL = serviceTopFiveVWBL;
	} 
	/**
	 * ʱ��ƽ�����ʱ��ͳ��BL�趨
	 * @param incidentAveSolveTimeVWBL ʱ��ƽ�����ʱ��ͳ��BL
	 */
	public void setIncidentAveSolveTimeVWBL(
			IncidentAveSolveTimeVWBL incidentAveSolveTimeVWBL) {
		this.incidentAveSolveTimeVWBL = incidentAveSolveTimeVWBL;
	}
	/**
	 * ��ȹ�������ͳ��BL�趨
	 * @param annualTrendVWBL ��ȹ�������ͳ��BL
	 */
	public void setAnnualTrendVWBL(AnnualTrendVWBL annualTrendVWBL) {
		this.annualTrendVWBL = annualTrendVWBL;
	}
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	/**
	 * ����ͳ��������ѯ���,�����������Ľ��������
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
	 * ������Ͳ�ѯ����ͳ�Ƹ��¼����������������XML��ʽƴΪ�ַ������ظ�ǰ̨
	 */
	public String getXmlByCondition(IGSVC0601Form form) throws BLException {
		
		log.debug("================��ʼͳ��=================");
		showFlag = false;
		StringBuffer xml = new StringBuffer();
		String dataXml = "";
		xml.append("<chart palette='3' baseFontSize='12' bgcolor='#FFFFFF' xAxisName='�·�' showValues='0' decimals='1' formatNumberScale='0' useRoundEdges='1'");

		form.setMode("1");
		String svcyear = form.getPryear();//��ѯ���
		String prkind = form.getPrkind();//��������
		String prname = form.getPrname();//��������
		form.setPrtype(prkind);
		form.setSelectMode("");
		
		xml.append(" caption='���̹���ͳ��  ��");
		xml.append(svcyear);
		xml.append("�� ");
		xml.append(prname);
		xml.append("������'>");	// yAxisName='�¼�'		
		xml.append(getXmlInfo(form,svcyear));//��ѯ���ص���Ϣ

		xml.append("</chart>");
		dataXml=xml.toString();
		if(showFlag){
			form.setSvcxml(dataXml);
		}else{
			form.setSvcxml("");
		}
		log.debug("================ͳ�ƽ���=================");
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
	private String getXmlInfo(IGSVC0601Form form,String svcyear)  throws BLException {
		IGSVC06DTO igsdl06DTO = new IGSVC06DTO();
		StringBuffer xml = new StringBuffer();
		
		for(int n=1,m=13;n<m;n++){
			//���ò�ѯ��ʼ������ʱ�� ��ʽΪyyyy/mm/dd
			String querydate = svcyear+"/"+getMonth(n)+"/01";//���ò�ѯ��ʼ����
			form.setPrplantime(null);
			form.setPropentime(null);
			form.setPrduration(null);
			form.setPrclosetime(null);
			if(IGPROCESSType.INCIDENT_PRTYPE.equals(form.getPrkind())){
				form.setPrplantime(querydate);//������ʼʱ��	
			}else{
				form.setPropentime(querydate);//����ʼʱ��
			}

//			if(n==12){
//				querydate = String.valueOf(Integer.parseInt(svcyear)+1)+"/01/01";
//			}else{
//				querydate = svcyear+"/"+getMonth(n)+"/31";
//			}
			
			querydate = svcyear+"/"+getMonth(n)+"/31";//���ò�ѯ��������
			
			if(IGPROCESSType.INCIDENT_PRTYPE.equals(form.getPrkind())){
				form.setPrduration(querydate);//��������ʱ��
			}else{
				form.setPrclosetime(querydate);//�������ʱ��
			}
			//���ò�ѯ
			igsdl06DTO.setProcessRecordSearchCond(form);
			String value = findByCond(igsdl06DTO);
			
			if(!"0".equals(value)){
				showFlag = true;
			}
			
			//ƴдxml
			xml.append("<set label='");
			xml.append(n);
			xml.append("��' value='");
			xml.append(value);
			xml.append("' />");

		}
		
		return xml.toString();
	}
	
	/**
	 * ��������ͳ�����ݲ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchIncidentTypeAction(IGSVC06DTO dto) throws BLException{
		log.debug("========��������ͳ�����ݲ�ѯ������ʼ=======");
		//dto����ȡ��
		IGSVC0635Form form = dto.getIgsvc0635Form();
		//ʵ������ѯ����
		IncidentTypeSearchCondImpl cond = new IncidentTypeSearchCondImpl();
		cond.setPdid("01080");
		cond.setYear(form.getYear());
		cond.setMonth(form.getMonth());
		IncidentTypeVWInfo data = incidentTypeBL.searchIncidentTypeData(cond);
		dto.setIncidentType(data);
		log.debug("========��������ͳ�����ݲ�ѯ��������=======");
		return dto;
	}
	
	/**
	 * ���ŷ���ͳ�Ʋ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchOrganizationServiceAction(IGSVC06DTO dto) throws BLException{
		log.debug("===========���ŷ���ͳ�����ݲ�ѯ������ʼ==========");
		//dto����ȡ��
		IGSVC0636Form form = dto.getIgsvc0636Form();
		//ʵ������ѯ����
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
		
		log.debug("===========���ŷ���ͳ�����ݲ�ѯ��������==========");
		return dto;
	}
	
	/**
	 * ��ѯ��Ա������ͳ������
	 * @param cond ��������
	 * @return
	 */
	public IGSVC06DTO searchSummary(IGSVC06DTO dto)throws BLException{
		
		SummaryCountPersonSearchCondImpl cond = new SummaryCountPersonSearchCondImpl();
		
		IGSVC0639Form form = dto.getIgsvc0639Form();
		cond.setYear(form.getYear());
		cond.setMonth(form.getMonth());
		
		List<IG160Info> list = summaryCountPersonBL.searchSummary(cond);
		//��Ա�ļ���
		List<String> presons = new ArrayList<String>();
		//ͳ����Ϣ��map��ʽ���heighchartsͼ������ݸ�ʽ
		Map<String,List<Integer>> acountMap = new HashMap<String, List<Integer>>();
		List<Integer> works = new LinkedList<Integer>();
		List<Integer> changes = new LinkedList<Integer>();
		List<Integer> asks = new LinkedList<Integer>();
		List<Integer> problems = new LinkedList<Integer>();
		List<Integer> incidents = new LinkedList<Integer>();
		
		//���������װ������
		for (IG160Info ig160Info : list) {
			
			//����û�����ݵ���Ա��Ϣ
			
			if(ig160Info.getWork()!=null||ig160Info.getChange()!=null){
				presons.add(ig160Info.getPpusername());
				works.add(ig160Info.getWork()==null?0:ig160Info.getWork()); 
				changes.add(ig160Info.getChange());
				asks.add(ig160Info.getAsk());
				problems.add(ig160Info.getProblem());
				incidents.add(ig160Info.getIncident());
			}
		}
		acountMap.put("���񹤵�", works);
		acountMap.put("���", changes);
		acountMap.put("����", asks);
		acountMap.put("����", problems);
		acountMap.put("�¼�", incidents);
		Gson gson = new Gson();
		String presonsJson = gson.toJson(presons);
		String acountJson = gson.toJson(acountMap);
		
		dto.setAcountJson(acountJson);
		
		dto.setPresonsJson(presonsJson);
		return dto;
	}
	

	
	/**
	 * ���ŷ���top5ͳ�����ݲ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchServiceTopFiveDateAction(IGSVC06DTO dto) throws BLException {
		log.debug("============���ŷ���top5ͳ�����ݲ�ѯ������ʼ=============");
		//dto����ȡ��
		IGSVC0637Form form = dto.getIgsvc0637Form();
		//ʵ������ѯ����
		ServiceTopFiveSearchCondImpl cond = new ServiceTopFiveSearchCondImpl();
		cond.setIpdid("01080");
		cond.setSpdid("01100");
		cond.setYear(form.getYear());
		cond.setMonth(form.getMonth());
		cond.setType(form.getType());
		List<ServiceTopFiveVWInfo> list = serviceTopFiveVWBL.searchServiceDate(cond);
		dto.setServiceTopFiveList(list);
		log.debug("============���ŷ���top5ͳ�����ݲ�ѯ��������=============");
		return dto;
	}
	
	/**
	 * ʱ��ƽ�����ʱ��ͳ�����ݲ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchIncidentAveSolveTimeAction(IGSVC06DTO dto) throws BLException {
		log.debug("===========ʱ��ƽ�����ʱ��ͳ�����ݲ�ѯ������ʼ==========");
		//dto����ȡ��
		IGSVC0638Form form = dto.getIgsvc0638Form();
		//ʵ������ѯ����
		IncidentAveSolveTimeSearchCondImpl cond = new IncidentAveSolveTimeSearchCondImpl();
		cond.setIpdid("01080");
		cond.setYear(form.getYear());
		cond.setMonth(form.getMonth());
		List<IncidentAveSolveTimeVWInfo> list = incidentAveSolveTimeVWBL.searchSolveTimeData(cond);
		if(list != null && list.size() > 0){
			dto.setIncidentAveSolveTimeDate(list);
		}
		log.debug("===========ʱ��ƽ�����ʱ��ͳ�����ݲ�ѯ��������==========");
		return dto;
	}
	
	/**
	 * ��ȹ�������ͳ�����ݲ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchAnnualTrendVWAction(IGSVC06DTO dto) throws BLException{
		log.debug("========��ȹ�������ͳ�����ݲ�ѯ������ʼ=======");
		//dto����ȡ��
		IGSVC0640Form form = dto.getIgsvc0640Form();
		//ʵ������ѯ����
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
		log.debug("========��ȹ�������ͳ�����ݲ�ѯ��������=======");
		return dto;
	}
	
	/**
	 * ��������ͳ�����ݲ�ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC06DTO searchProcessRecordCountAction(IGSVC06DTO dto) throws BLException {
		log.debug("==========��������ͳ�����ݲ�ѯ������ʼ===========");
		//dto����ȡ��
		IGSVC0642Form form = dto.getIgsvc0642Form();
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPropentime(form.getPropentime_from());
		cond.setPrclosetime(form.getPropentime_to());
		List<IG500Info> list = ig500BL.searchIG500Info(cond);
		//�¼�����
		int countI = 0;
		//�¼�δ�ر�����
		int countI_E = 0;
		//�¼��ѹر�����
		int countI_C = 0;
		//��������
		int countP = 0;
		//����δ�ر�����
		int countP_E = 0;
		//�����ѹر�����
		int countP_C = 0;
		//�������
		int countC = 0;
		//���δ�ر�����
		int countC_E = 0;
		//����ѹر�����
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
		log.debug("==========��������ͳ�����ݲ�ѯ��������===========");
		return dto;
	}
}
