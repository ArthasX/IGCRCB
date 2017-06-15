/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.svc.bl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.com.bl.task.ProcessInHandBL;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.svc.dto.IGSVC01DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_����̨ҵ���߼��ӿ�ʵ����
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSVC01BLImpl extends BaseBLImpl implements IGSVC01BL {
	
	static Log log = LogFactory.getLog(IGSVC01BLImpl.class);
	
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**���̶���BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/**�û���ɫ��Ȩ��ϢBL*/
	protected UserRoleBL userRoleBL;
	
	/** �������BL */
	protected ProcessInHandBL processInHandBL;
	
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * �������BL�趨
	 * @param processInHandBL �������BL
	 */
	public void setProcessInHandBL(ProcessInHandBL processInHandBL) {
		this.processInHandBL = processInHandBL;
	}

	/**
	 * <p>
	 * �ҵķ��𣬻�ȡ�û������δ�رյ�����
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getWorkInitByMe(IGSVC01DTO dto) throws BLException {
		log.debug("========��ȡ�ҵķ���ʼ========");
		String userId = dto.getUserid();
		Map<String, List<IG500Info>> processRecordMap = new LinkedHashMap<String, List<IG500Info>>();
		//��ȡ��������ģ��
		List<IG259Info> processTemplates = workFlowDefinitionBL.searchProcessTemplate(new IG259SearchCondImpl());
		Map<String,String> detailPgMap = new LinkedHashMap<String, String>();//ģ��鿴ҳURL
		for (int i=0;i<processTemplates.size();i++) {
			detailPgMap.put(processTemplates.get(i).getPttype(), processTemplates.get(i).getPtdetailpg());
		}
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");//δ�ر�
		cond.setPruserid(userId);
		List<IG500Info> processRecords = workFlowOperationBL.searchProcessRecordSubStatusList(cond, 0, 0);
		processRecordMap.put(dto.getUsername(), processRecords);
		dto.setProcessRecordMap(processRecordMap);
		dto.setDetailPgMap(detailPgMap);
		log.debug("========��ȡ�ҵķ������========");
		return dto;
	}
	/**
	 * <p>
	 * �ҵķ��𣬻�ȡ�û��������������
	 * </p>
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 */
	public IGSVC01DTO getWorkInitByMeForAll(IGSVC01DTO dto) throws BLException {
		log.debug("========��ȡ�ҵķ���ʼ========");
		String userId = dto.getUserid();
		Map<String, List<IG500Info>> processRecordMap = new LinkedHashMap<String, List<IG500Info>>();
		//��ȡ��������ģ��
		List<IG259Info> processTemplates = workFlowDefinitionBL.searchProcessTemplate(new IG259SearchCondImpl());
		Map<String,String> detailPgMap = new LinkedHashMap<String, String>();//ģ��鿴ҳURL
		for (int i=0;i<processTemplates.size();i++) {
			detailPgMap.put(processTemplates.get(i).getPttype(), processTemplates.get(i).getPtdetailpg());
		}
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPruserid(userId);
		List<IG500Info> processRecords = workFlowOperationBL.searchProcessRecordSubStatusList(cond, 0, 0);
		processRecordMap.put(dto.getUsername(), processRecords);
		dto.setProcessRecordMap(processRecordMap);
		dto.setDetailPgMap(detailPgMap);
		log.debug("========��ȡ�ҵķ������========");
		return dto;
	}
	

	/**
	 * <p>
	 * ��ط��𣬻�ȡ�û�������Ľ�ɫ�����δ�رյ�����
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getWorkInitByMyManyRole(IGSVC01DTO dto) throws BLException {
		log.debug("========��ȡ��ط���ʼ========");
		List<UserRoleInfo> userRoleList = userRoleBL.getUserRoles(dto.getUserid());
		Map<String, List<IG500Info>> processRecordMap = new LinkedHashMap<String, List<IG500Info>>();
		List<IG259Info> processTemplates = workFlowDefinitionBL.searchProcessTemplate(new IG259SearchCondImpl());
		Map<String,String> detailPgMap = new LinkedHashMap<String, String>();//ģ��鿴ҳURL
		for (int i=0;i<processTemplates.size();i++) {
			detailPgMap.put(processTemplates.get(i).getPttype(), processTemplates.get(i).getPtdetailpg());
		}
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");//δ�ر�
		for (UserRoleInfo info : userRoleList) {
			cond.setPrroleid(info.getRoleid());
			//��ȡ����δͣ�õ�����ģ��
			List<IG500Info> processRecords = workFlowOperationBL.searchProcessRecordSubStatusList(cond, 0, 0);
			List<IG500Info> newprInfoForGroupList = new ArrayList<IG500Info>();
			for(IG500Info pr:processRecords){
				if(!pr.getPrtype().equals(IGPROCESSType.NEW_WORK_PRTYPE_1) && !pr.getPrtype().equals(IGPROCESSType.NEW_WORK_PRTYPE_2)){
					newprInfoForGroupList.add(pr);
				}
			}
			processRecords.clear();
			processRecords.addAll(newprInfoForGroupList);
			
			processRecordMap.put(info.getRolename(), processRecords);
		}
		dto.setProcessRecordMap(processRecordMap);
		dto.setDetailPgMap(detailPgMap);
		log.debug("========��ȡ��ط������========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ع�������ȡָ���û�������Ľ�ɫ�����δ�رյ�����
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getWorkAssignedToMyManyRole(IGSVC01DTO dto) throws BLException {
		log.debug("========��ȡ��ع�����ʼ========");
		String userid = dto.getUserid();
		List<ProcessInHandVWInfo> list = this.processInHandBL.searchProcessInHandGroupByUserID(userid,0,0, true);
		dto.setWorkList(list);
		log.debug("========��ȡ��ع�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * �ҵĹ�������ȡָ���û������δ�رյ�����
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getWorkAssignedToMe(IGSVC01DTO dto) throws BLException {
		log.debug("========��ȡ�ҵĹ�����ʼ========");
		String userId = dto.getUserid();
		List<ProcessInHandVWInfo> list = this.processInHandBL.searchProcessInHandByUserID(userId,0,0,true);
		dto.setWorkList(list);
		log.debug("========��ȡ�ҵĹ�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * �����ල����ȡ����δ�رյ�����
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getAllActiveProcessRecords(IGSVC01DTO dto) throws BLException {
		log.debug("========��ȡ�����ල��ʼ========");
		Map<String, List<IG500Info>> processRecordMap = new LinkedHashMap<String, List<IG500Info>>();

		//��ȡ��������ģ��
//		List<IG259Info> processTemplates = workFlowDefinitionBL.searchProcessTemplate(new IG259SearchCondImpl());
//		String[] templateNames = new String[processTemplates.size()];//ģ������
//		String[] detailPgs = new String[processTemplates.size()];//ģ��鿴ҳURL
		//***************�ĳ�ͨ�����̶��廮��tab*********************
		//��ȡ���̶���
		IG380SearchCondImpl pdcond = new IG380SearchCondImpl();
		pdcond.setPtid(IGPRDCONSTANTS.PROCESS_DEFINITION_COMMON_TEMPLATE_ID);
		List<IG380Info> processDefinitonList = workFlowDefinitionBL.searchHistoryProcessDefinition(pdcond, 0, 0);
		String[] definitonNames = new String[processDefinitonList.size()];
		String[] pages = new String[processDefinitonList.size()];
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");//δ�ر�
		
		for (int i = 0; i < processDefinitonList.size(); i++) {
			IG380Info definition = processDefinitonList.get(i);
			//���˼�ܱ���
			if(IGPRDCONSTANTS.PRTYPE_YEAR_ID.equals(definition.getPtid()) 
					|| IGPRDCONSTANTS.PRTYPE_SEASON_ID.equals(definition.getPtid()) 
					|| IGPRDCONSTANTS.PRTYPE_IRREGULAR_ID.equals(definition.getPtid())){
				continue;
			}
			cond.setUserid_q(dto.getUserid_q());
//			cond.setPrpdid(definition.getPdid());
			cond.setPrpdid_like_or(new String[]{definition.getPdid().substring(0, 5)});
			List<IG500Info> processRecords = workFlowOperationBL.searchProcessRecord(cond);
			definitonNames[i] = definition.getPdname();
			pages[i] = "IGPRR0102_Disp.do?prtype=WD&prid=";
			processRecordMap.put(definitonNames[i], processRecords);
		}
		
//		for (int i=0;i<processTemplates.size();i++) {
//			cond.setPrtype(processTemplates.get(i).getPttype());
//			cond.setUserid_q(dto.getUserid_q());
////			cond.setPrpdid_like_or(new String[]{processTemplates.get(i).getPtid().toString().substring(0, 5)});
//			List<IG500Info> processRecords = workFlowOperationBL.searchProcessRecordSubStatusList(cond,0,0);
//			templateNames[i] = processTemplates.get(i).getPtname();
//			detailPgs[i] = processTemplates.get(i).getPtdetailpg();
//			processRecordMap.put(processTemplates.get(i).getPtname(), processRecords);
//		}
		dto.setProcessRecordMap(processRecordMap);
		dto.setTemplateNames(definitonNames);
		dto.setDetailPgs(pages);
		log.debug("========��ȡ�����ල����========");
		return dto;
	}

	/**
	 * <p>
	 * ��ѯ���̼�¼
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getProcessRecords(IGSVC01DTO dto) throws BLException {
		log.debug("========��ȡ��ѯ���̼�¼��ʼ========");
		// ��ѯ��¼����
		int totalCount = workFlowOperationBL.getProcessRecordSubStatusSearchCount(dto
				.getPrSearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<IG500Info> prList = workFlowOperationBL.searchProcessRecordSubStatusList(
				dto.getPrSearchCond(), pDto.getFromCount(), pDto
						.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setProcessList(prList);
		log.debug("========��ȡ��ѯ���̼�¼����========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ���̼�¼
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getProcessRecordsForLook(IGSVC01DTO dto) throws BLException {
		log.debug("========��ȡ��ѯ���̼�¼��ʼ========");
		// ��ѯ��¼����
		int totalCount = workFlowOperationBL.getProcessRecordSubStatusSearchCount(dto
				.getPrSearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<IG500Info> prList = workFlowOperationBL.searchProcessRecordSubStatusList(
				dto.getPrSearchCond(), pDto.getFromCount(), pDto
						.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setProcessList(prList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		dto.setProcessList(prList);
		List<IG259Info> processTemplates = workFlowDefinitionBL.searchProcessTemplate(new IG259SearchCondImpl());
		Map<String,String> detailPgMap = new LinkedHashMap<String, String>();//ģ��鿴ҳURL
		for (int i=0;i<processTemplates.size();i++) {
			detailPgMap.put(processTemplates.get(i).getPttype(), processTemplates.get(i).getPtdetailpg());
		}
		dto.setDetailPgMap(detailPgMap);
		log.debug("========��ȡ��ѯ���̼�¼����========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ��ʷ������ѯ
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author zhaojun@deliverik.com
	 */
	
	public IGSVC01DTO getDoneProcessRecordsForLook(IGSVC01DTO dto) throws BLException {
		log.debug("========��ȡ��ѯ���̼�¼��ʼ========");
		// ��ѯ��¼����
		int totalCount = workFlowOperationBL.queryCorrelationProcessByUseridCount(dto.getProcessInfoSearchCond(),0,0,2,0);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<IG500Info> prList = workFlowOperationBL.queryCorrelationProcessByUserid(dto.getProcessInfoSearchCond(),pDto.getFromCount(),pDto
				.getPageDispCount(),2,0);

		pDto.setTotalCount(totalCount);
		dto.setProcessList(prList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		dto.setProcessList(prList);
		List<IG259Info> processTemplates = workFlowDefinitionBL.searchProcessTemplate(new IG259SearchCondImpl());
		Map<String,String> detailPgMap = new LinkedHashMap<String, String>();//ģ��鿴ҳURL
		for (int i=0;i<processTemplates.size();i++) {
			detailPgMap.put(processTemplates.get(i).getPttype(), processTemplates.get(i).getPtdetailpg());
		}
		dto.setDetailPgMap(detailPgMap);
		log.debug("========��ȡ��ѯ���̼�¼����========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ���̼�¼(֪ʶ���ʹ��)
	 * </p>
	 * 
	 * @param dto
	 * @return IGSVC01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSVC01DTO getProcessRecordsForKGM(IGSVC01DTO dto) throws BLException {
		log.debug("========��ȡ��ѯ���̼�¼��ʼ========");
		// ��ѯ��¼����
		int totalCount = workFlowOperationBL.getProcessRecordSearchCount(dto
				.getPrSearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<IG500Info> prList = workFlowOperationBL.searchProcessRecord(
				dto.getPrSearchCond(), pDto.getFromCount(), pDto
						.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setProcessList(prList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		dto.setProcessList(prList);
		List<IG259Info> processTemplates = workFlowDefinitionBL.searchProcessTemplate(new IG259SearchCondImpl());
		Map<String,String> detailPgMap = new LinkedHashMap<String, String>();//ģ��鿴ҳURL
		for (int i=0;i<processTemplates.size();i++) {
			detailPgMap.put(processTemplates.get(i).getPttype(), processTemplates.get(i).getPtdetailpg());
		}
		dto.setDetailPgMap(detailPgMap);
		log.debug("========��ȡ��ѯ���̼�¼����========");
		return dto;
	}

	/**
	 * ��ֹ������ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSVC01DTO getDiscontinueWork(IGSVC01DTO dto) throws BLException {
		log.debug("========��ȡ��ֹ�Ĺ�����ʼ========");
		String userId = dto.getUserid();
		Map<String, List<IG500Info>> processRecordMap = new LinkedHashMap<String, List<IG500Info>>();
		//��ȡ��������ģ��
		List<IG259Info> processTemplates = workFlowDefinitionBL.searchProcessTemplate(new IG259SearchCondImpl());
		Map<String,String> detailPgMap = new LinkedHashMap<String, String>();//ģ��鿴ҳURL
		for (int i=0;i<processTemplates.size();i++) {
			detailPgMap.put(processTemplates.get(i).getPttype(), processTemplates.get(i).getPtdetailpg());
		}
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPruserid(userId);
		cond.setPrstatus("C");
		cond.setPrsubstatus("C");
		List<IG500Info> processRecords = workFlowOperationBL.searchProcessRecordSubStatusList(cond, 0, 0);
		processRecordMap.put(dto.getUsername(), processRecords);
		dto.setProcessRecordMap(processRecordMap);
		dto.setDetailPgMap(detailPgMap);
		log.debug("========��ȡ��ֹ�Ĺ�������========");
		return dto;
	}
	
	public IGSVC01DTO getPrtypeList(IGSVC01DTO dto){
		//��ȡ��������ģ��
		List<IG259Info> processTemplates = workFlowDefinitionBL.searchProcessTemplate(new IG259SearchCondImpl());
		List<LabelValueBean> prtypeList = new ArrayList<LabelValueBean>();
		for(IG259Info prtype:processTemplates){
			boolean flag = true;
//			if(prtype.getPttype().length()>1){
//				if(prtype.getPttype().charAt(1)=='D'){
//					flag = false;
//				}
//			}
			if(flag){
				prtypeList.add(new LabelValueBean(prtype.getPtname(), prtype.getPttype()));
			}
		}
		dto.setPrtypeList(prtypeList);
		return dto;
	}
	
}

