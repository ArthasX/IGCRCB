package com.deliverik.infogovernor.bl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG105BL;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG933BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG677VW;
import com.deliverik.infogovernor.com.bl.task.ProcessInHandBL;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.dto.IGCOM04DTO;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BLImpl;
import com.deliverik.infogovernor.util.CodeDefine;
import com.deliverik.infogovernor.vo.IGCOM03041VO;
import com.deliverik.infogovernor.vo.IGCOM04031VO;
import com.deliverik.infogovernor.vo.IGCOM04051VO;

public class IGCOM04BLImpl extends BaseBLImpl implements IGCOM04BL {
	
	
	public static final String incperm = "ACT02SVC0204";//�¼��鿴Ȩ��
	
	public static final String wkmperm = "ACT02SVC0901";//�����鿴Ȩ��
	
	public static final String prjperm = "ACT03SDL0301";//��Ŀ�鿴Ȩ��
	
	public static final String serperm = "ACT02SVC0605";//��������鿴Ȩ��
	
	protected IG500BL ig500BL;
	
	protected IG259BL ig259BL;
	
	protected UserRoleBL userRoleBL;
	
	protected IG933BL ig933BL;
	
	/** ���̲���BL */
	protected IG105BL ig105BL;
	
	/** ����״̬��־BL */
	protected IG224BL ig224BL;
	
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	protected WorkFlowOperationBL workFlowOperationBL;

	protected Map<String,String> nameURLMap = new HashMap<String,String>();
	
	/** ��������BL */
	protected CodeDetailBL codeDetailBL;
	
	/** �������BL */
	protected ProcessInHandBL processInHandBL;
	

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
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

	/**
	 * ���̲���BL�趨
	 * @param ig105BL ���̲���BL
	 */
	public void setIg105BL(IG105BL ig105BL) {
		this.ig105BL = ig105BL;
	}

    /**
     * ����״̬��־BL�趨
     * @param ig224BL ����״̬��־BL
     */
	public void setIg224BL(IG224BL ig224BL) {
		this.ig224BL = ig224BL;
	}
	
	/**
	 * ��������BL�趨
	 * @param codeDetailBL ��������BL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * �������BL�趨
	 * @param processInHandBL �������BL
	 */
	public void setProcessInHandBL(ProcessInHandBL processInHandBL) {
		this.processInHandBL = processInHandBL;
	}

	public IGCOM04DTO getWorkAssigned(IGCOM04DTO dto) throws BLException {
		
		IGCOM03041VO vo = new IGCOM03041VO();
		String userId = dto.getUserId();
		List<IG677Info> processRecordInfoForMeList = ig500BL.getTodoProcessRecordsByUser(userId, "",null,null);
		vo.setProcessRecordInfoForMeList(processRecordInfoForMeList);
		this.setWorkAssignedToMyGroupToVO(vo, dto, processRecordInfoForMeList);
		vo.setUrlMap(nameURLMap);
		dto.setIgcom03041VO(vo);
		return dto;
		
	}
	
	
	public IGCOM04DTO getProcessRecordList(IGCOM04DTO dto) throws BLException {
		
		IGCOM03041VO vo = new IGCOM03041VO();
		String userId = dto.getUserId();
		
		//============================>>�޸� 0001101 Start
		//������ָ������ɫʱ,�ڽ�ɫ�����˵��ҵĹ�������ʾ����������Ϣ
		List<IG677Info> roleManagerInfo  = this.getRoleManagerWork(userId);
		
		//�жϵ�ǰ�û��Ƿ�Ϊ���̷�����
		List<IG677Info> assignInfo  = this.getAssignWork(userId);
		
		//һ��������ҵĹ���
		List<IG677Info> myInfo  = this.getMyWork(userId);
		
		//ȫ�����ҵĹ���
		List<IG677Info> processRecordInfos = new ArrayList<IG677Info>();
		
		processRecordInfos.addAll(roleManagerInfo);
		processRecordInfos.addAll(assignInfo);
		processRecordInfos.addAll(myInfo);
		
		//�����Ż�-�������ʱ���������ˡ������������󣬹������������˵��ҵĹ����б�����ʾ begin
		//׷��--��Ŀ������һ��δ��������������
		List<IG337Info> approveOneList = null;
		List<IG337Info> approveTwoList = null;
		List<IG337Info> failList = null;
		List<IG337Info> failList2 = null;
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		for(Iterator<IG677Info> iter = processRecordInfos.iterator();iter.hasNext();){
			approveOneList = null;
			approveTwoList = null;
			failList = null;
			failList2 = null;
			IG677Info pr = iter.next();
			if((IGPROCESSType.CHANGE_PRTYPE.equals(pr.getPrtype()) 
					|| IGPROCESSType.SERVICE_PRTYPE.equals(pr.getPrtype())
					|| IGPROCESSType.DEPLOYMENT_PRTYPE.equals(pr.getPrtype()) )){
				//����û��ǵ�ǰ���̵ķ����ˡ������ˡ������˵�����֮һ�����ߵ�½�û���ָ������ɫ��ʵʩ��ɫ�Ľ�ɫ������ʱ���򲻽����Ų�
				if(!checkRole(userId, pr.getPrid())){
					cond.setPrid(pr.getPrid());
					cond.setPpproctimeIsNull("Y");
					failList = workFlowOperationBL.searchProcessParticipants(cond);
					if(failList.size() > 0){
						iter.remove();
					}else{
						failList2 = workFlowOperationBL.searchProcessParticipants(cond);
						if(failList2.size() > 0){
							iter.remove();
						}else if(WorkFlowConstDefine.ADD_APPROVOR_LEVEL_TWO.equals(pr.getPpsubstatus()) 
								||WorkFlowConstDefine.DEFAULT_APPROVOR_LEVEL_TWO.equals(pr.getPpsubstatus())
								||WorkFlowConstDefine.DEFAULT_APPROVOR_LEVEL_THREE.equals(pr.getPpsubstatus())
								||WorkFlowConstDefine.ADD_APPROVOR_LEVEL_THREE.equals(pr.getPpsubstatus())){
							//������������ʱ
							cond.setPrid(pr.getPrid());
							cond.setPpsubstatus(WorkFlowConstDefine.DEFAULT_APPROVOR_LEVEL_ONE);
							cond.setPpproctimeIsNull("Y");
							approveOneList = workFlowOperationBL.searchProcessParticipants(cond);
							cond.setPpsubstatus(WorkFlowConstDefine.DEFAULT_APPROVOR_LEVEL_ONE.toLowerCase());
							approveOneList.addAll(workFlowOperationBL.searchProcessParticipants(cond));
							if(approveOneList.size() > 0){
								iter.remove();
							}else if(WorkFlowConstDefine.ADD_APPROVOR_LEVEL_THREE.equals(pr.getPpsubstatus())
									||WorkFlowConstDefine.DEFAULT_APPROVOR_LEVEL_THREE.equals(pr.getPpsubstatus())){
								cond.setPpsubstatus(WorkFlowConstDefine.DEFAULT_APPROVOR_LEVEL_TWO);
								approveTwoList = workFlowOperationBL.searchProcessParticipants(cond);
								cond.setPpsubstatus(WorkFlowConstDefine.DEFAULT_APPROVOR_LEVEL_TWO.toLowerCase());
								approveTwoList.addAll(workFlowOperationBL.searchProcessParticipants(cond));
								if(approveTwoList.size() > 0){
									iter.remove();
								}
							}
						}else if(WorkFlowConstDefine.ADD_APPROVOR_LEVEL_FOUR.equals(pr.getPpsubstatus()) 
							   ||WorkFlowConstDefine.DEFAULT_APPROVOR_LEVEL_FOUR.equals(pr.getPpsubstatus()) ){
							cond.setPrid(pr.getPrid());
							cond.setPpsubstatus(WorkFlowConstDefine.ADD_APPROVOR_LEVEL_FOUR);
							cond.setPpproctimeIsNull("Y");
							approveOneList = workFlowOperationBL.searchProcessParticipants(cond);
							cond.setPpsubstatus(WorkFlowConstDefine.DEFAULT_APPROVOR_LEVEL_FOUR.toLowerCase());
							approveOneList.addAll(workFlowOperationBL.searchProcessParticipants(cond));
							if(approveOneList.size() > 0){
								iter.remove();
							}
						}
					}
				}
			}
		}
		//�����Ż�-�������ʱ���������ˡ������������󣬹������������˵��ҵĹ����б�����ʾ end
		
		//ȥ���ظ����ҵĹ�����
		for(int i=0; i<processRecordInfos.size(); i++){
			for(int j=0; j<processRecordInfos.size(); j++){
				if(processRecordInfos.get(i).getPrid().equals(processRecordInfos.get(j).getPrid())){
					if(i!=j){
						processRecordInfos.remove(j);
					}
				}
			}
		}
		
		//�¼�����ǰ��
		List<IG677Info> incidentList = new ArrayList<IG677Info>();
		List<IG677Info> processRecordInfoForMeList = new ArrayList<IG677Info>();
		for(IG677Info pr : processRecordInfos){
			if("I".equals(pr.getPrtype())){
				incidentList.add(pr);
			}
		}
		processRecordInfoForMeList.addAll(incidentList);
		processRecordInfos.removeAll(incidentList);
		processRecordInfoForMeList.addAll(processRecordInfos);
		vo.setProcessRecordInfoForMeList(processRecordInfoForMeList);
		//�ҵĹ����߼�����
		
		
		//��ع����߼���ʼ
		List<IG677Info> processRecordInfoForGroupoList = this.getGroupWork(userId);
		//��ع����߼�����
		
		//<<============================�޸� 0001101 End
		/**�ҵĹ���       ����Ǳ��ȡ�ƻ�ʱ�䣬����ȡ����ʱ�� ��ʼ**/
		List<IGCOM04031VO> meListTmp = new ArrayList<IGCOM04031VO>();   
		for(int i=0;i<processRecordInfoForMeList.size();i++){
			IG677VW obj = (IG677VW)processRecordInfoForMeList.get(i);
			IGCOM04031VO vo04 = new IGCOM04031VO();
			BeanUtils.copyProperties(obj, vo04);
			if((IGPROCESSType.CHANGE_PRTYPE.equals(obj.getPrtype()))||IGPROCESSType.DEPLOYMENT_PRTYPE.equals(obj.getPrtype())){
				vo04.setPropentime(obj.getPrplantime());
			}
			meListTmp.add(vo04);
		}
		/**�ҵĹ���      ����Ǳ��ȡ�ƻ�ʱ�䣬����ȡ����ʱ�� ����**/

		/**��ع���       ����Ǳ��ȡ�ƻ�ʱ�䣬����ȡ����ʱ�� ��ʼ**/
		List<IGCOM04031VO> groupListTmp = new ArrayList<IGCOM04031VO>();   
		for(int i=0;i<processRecordInfoForGroupoList.size();i++){
			IGCOM04031VO vo04 = new IGCOM04031VO();
			IG677VW obj = (IG677VW)processRecordInfoForGroupoList.get(i);
			BeanUtils.copyProperties(obj, vo04);
			if((IGPROCESSType.CHANGE_PRTYPE.equals(obj.getPrtype()))||IGPROCESSType.DEPLOYMENT_PRTYPE.equals(obj.getPrtype())){
				vo04.setPropentime(obj.getPrplantime());
			}
			groupListTmp.add(vo04);
		}
		/**��ع���      ����Ǳ��ȡ�ƻ�ʱ�䣬����ȡ����ʱ�� ����**/
		
//		//�ҵĹ�������ʱ���������
//		Collections.sort(meListTmp, new Comparator<IGCOM04031VO>(){
//			public int compare(IGCOM04031VO o1, IGCOM04031VO o2){ 
//				return o2.getPropentime().compareTo(o1.getPropentime());
//			}
//		});
//		
//		//��ع�������ʱ���������
//		Collections.sort(groupListTmp, new Comparator<IGCOM04031VO>(){
//			public int compare(IGCOM04031VO o1, IGCOM04031VO o2){ 
//				return o2.getPropentime().compareTo(o1.getPropentime());
//			}
//		});

		//ȡ���������ӵ�ַ
		for (IG677Info processRecordInfo : groupListTmp) {
			Integer prid = processRecordInfo.getPrid();
			setDetailURLToMAP(processRecordInfo.getPrtype(),String.valueOf(prid));
		}
		
		for (IG677Info processRecordInfo : meListTmp) {
			Integer prid = processRecordInfo.getPrid();
			setDetailURLToMAP(processRecordInfo.getPrtype(),String.valueOf(prid));
		}
		
		vo.setUrlMap(nameURLMap);
		vo.setProcessRecordInfoForMeList(new ArrayList<IG677Info>(meListTmp));
		vo.setProcessRecordInfoForGroupList(processRecordInfoForGroupoList);
		dto.setIgcom03041VO(vo);
		
		return dto;
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
	 * ȡ�ý�ɫ�����˵��ҵĹ���
	 * 
	 * @param userId
	 * @return ����List
	 * @throws BLException
	 */
	private List<IG677Info> getRoleManagerWork(String userid){
		List<IG677Info> processrecordinfomanagerlist = workFlowOperationBL.queryActiveProcessByFPRoleid(userid);
		return processrecordinfomanagerlist;
	}
	
	/**
	 * ȡ��һ����ҵĹ���
	 * 
	 * @param userId
	 * @return ����List
	 * @throws BLException
	 */
	private List<IG677Info> getMyWork(String userid){
		//��ȡ��������ģ��
		List<IG259Info> processTemplates = workFlowDefinitionBL.searchProcessTemplate(new IG259SearchCondImpl());
		Map<String,String> detailPgMap = new LinkedHashMap<String, String>();//ģ��鿴ҳURL
		for (int i=0;i<processTemplates.size();i++) {
			detailPgMap.put(processTemplates.get(i).getPttype(), processTemplates.get(i).getPtdetailpg());
		}
		List<IG677Info> processRecordInfos = workFlowOperationBL.getWorkAssignedToMe(userid,null,null,null);
		return processRecordInfos;
	}
	
	/**
	 * ȡ����ع���
	 * 
	 * @param userId
	 * @return ��ع���List
	 * @throws BLException
	 */
	private List<IG677Info> getGroupWork(String userid){
		List<IG677Info> processRecordInfos = new ArrayList<IG677Info>();
		List<UserRoleInfo> userRoleList = userRoleBL.getUserRoles(userid);
		//�Ƿ����Ա
		boolean flag = true;
		for(UserRoleInfo ur : userRoleList) {
			if(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE.equals(ur.getRoletype())) {
				flag = false;
				break;
			}
		}
		for (UserRoleInfo info : userRoleList) {
			List<IG677Info> processRecords = workFlowOperationBL.getWorkAssignedToMyManyRole(info.getRoleid(),null);
			List<IG677Info> newprInfoForGroupList = new ArrayList<IG677Info>();
			for(IG677Info pr:processRecords){
				if(!pr.getPrtype().equals(IGPROCESSType.NEW_WORK_PRTYPE_1) && !pr.getPrtype().equals(IGPROCESSType.NEW_WORK_PRTYPE_2)){
					newprInfoForGroupList.add(pr);
				}
				
			}
			processRecords.clear();
			processRecords.addAll(newprInfoForGroupList);
			
			//�����������ɫ����,���������״̬���ɼ�
			if(IGSYM03BLImpl.GROUP_ROLE_MARK.equals(info.getRoledomain())) {
				IG677Info prInfo = null;
				for(Iterator<IG677Info> iter = processRecords.iterator(); iter.hasNext();) {
					prInfo = iter.next();
					if(prInfo.getPproleid().equals(info.getRoleid())) {
						if(flag && IGPROCESSType.SERVICE_PRTYPE.equals(prInfo.getPrtype()) && !userid.equals(prInfo.getPpuserid())) {
							if(!WorkFlowConstDefine.DEFAULT_APPROVOR_LEVEL_FOUR.equals(prInfo.getPpsubstatus())
								&& !WorkFlowConstDefine.ADD_APPROVOR_LEVEL_FOUR.equals(prInfo.getPpsubstatus())
									) {
								iter.remove();
							}
						}
					}
				}
			}
			
			IG677Info pri = null;
			for(Iterator<IG677Info> iter = processRecords.iterator(); iter.hasNext();) {
				pri = iter.next();
				
				//�������ǵ�ǰ�û�����ع������Ƴ�
				if(userid.equals(pri.getPpuserid())){
					iter.remove();
				}else{//��ɫ�����˵�����ָ�����ý�ɫ����ûָ�����˵�ʱ�����ع������Ƴ�
					List<IG337Info> manager = workFlowOperationBL.queryRolemanager(userid, pri.getPrid());
					if(!manager.isEmpty() && StringUtils.isEmpty(pri.getPpuserid())) {
						iter.remove();
					}
				}
			}
			
			processRecordInfos.addAll(processRecords);
		}
		return processRecordInfos;
	}

	/**
	 * ȡ�����̷����ߵ��ҵĹ���
	 * 
	 * @param userId
	 * @return ����List
	 * @throws BLException
	 */
	private List<IG677Info> getAssignWork(String userid){
		List<UserRoleInfo> userroleinfolist = this.userRoleBL.getUserRoles(userid);
		List<IG677Info> processrecordlist = new ArrayList<IG677Info>();
		boolean flag = true;
		for(UserRoleInfo uri : userroleinfolist){
			if(uri.getRoletype().equals(WorkFlowConstDefine.DISPATCH_ROLE_TYPE) && flag){
				//�¼�������ȴ����ɵ�������Ϣ
				processrecordlist = workFlowOperationBL.getWorkAssignedToFPRole(uri.getRoleid(), "P_I");
				flag = false;
			}
		}
		return processrecordlist;
	}
	
	/**
	 * ��֤��ǰ�û��Ƿ����账��ĺ����ˡ�����������
	 * 
	 * @param userId
	 * @param prid
	 * @return boolean
	 * @throws BLException
	 */
	private boolean checkRole(String userId, Integer prid){
		boolean flag = false;
		return flag;
	}
	
	/**
	 * ��֤��ǰ�û��Ƿ���ָ�����������̵��еĽ�ɫ������
	 * 
	 * @param userId
	 * @param prid
	 * @param status
	 * @param substatus
	 * @return boolean
	 * @throws BLException
	 */
	private boolean checkUserManager(String userId,Integer prid,String status,String substatus){
		boolean flag = false;
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPpstatus(status);
		cond.setPpsubstatus(substatus);
		cond.setPpproctimeIsNull("Y");
		List<IG337Info> failList = workFlowOperationBL.searchProcessParticipants(cond);
		UserRoleSearchCondImpl cond1 = new UserRoleSearchCondImpl();
		if(failList.size() > 0){
			for(int i = 0; i < failList.size(); i++){
				cond1 = new UserRoleSearchCondImpl();
				if(StringUtils.isEmpty(failList.get(i).getPpuserid())){
					cond1.setRoleid(failList.get(i).getPproleid());
					List<UserRole> userRoleList = userRoleBL.searchUserRole(cond1, 0, 0);
					for(UserRole ur: userRoleList){
						if("1".equals(ur.getRolemanager())){
							flag = true;
							break;
						}
					}
				}
			}
			
		}
		return flag;
	}
	
	/**
	 * ��֤��ǰ�û��Ƿ���ָ�����������̵���
	 * 
	 * @param userId
	 * @param prid
	 * @param status
	 * @param substatus
	 * @return boolean
	 * @throws BLException
	 */
	private boolean checkUserId(String userId,Integer prid,String status,String substatus){
		boolean flag = false;
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPpstatus(status);
		cond.setPpsubstatus(substatus);
		cond.setPpuserid(userId);
		cond.setPpproctimeIsNull("Y");
		List<IG337Info> failList = workFlowOperationBL.searchProcessParticipants(cond);
		if(failList.size() > 0){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * ҵ����Ա��ҳ��Ϣȡ��
	 * 
	 * @param dto IGCOM04DTO
	 * @param vo IGCOM04051VO
	 * @return IGCOM04DTO
	 * @throws BLException 
	 */
	public IGCOM04DTO initIGCOM0405Action(IGCOM04DTO dto, IGCOM04051VO vo) throws BLException{
		//��ȡ��������ģ��
		List<IG259Info> processTemplates = workFlowDefinitionBL.searchProcessTemplate(new IG259SearchCondImpl());
		Map<String,String> detailPgMap = new LinkedHashMap<String, String>();//ģ��鿴ҳURL
		for (int i=0;i<processTemplates.size();i++) {
			detailPgMap.put(processTemplates.get(i).getPttype(), processTemplates.get(i).getPtdetailpg());
		}
		//�趨URL
		vo.setUrlMap(detailPgMap);
		
		String userid = dto.getUserId();
		//��ѯ�ҵĹ���
		List<ProcessInHandVWInfo> myWorkList = this.processInHandBL.searchProcessInHandByUserID(userid,0,0,true);
		vo.setMyWorkList(myWorkList);
		//��ѯ��ع���
		List<ProcessInHandVWInfo> relevanceWorkList = this.processInHandBL.searchProcessInHandGroupByUserID(userid,0,0, true);
		vo.setRelevanceWorkList(relevanceWorkList);
		
		//��ѯ�ҷ���Ĺ���
		IG677SearchCondImpl cond = new IG677SearchCondImpl();
		//�趨������ԱID
		cond.setPpuserid(dto.getUserId());
		//����״̬
		cond.setPpstatus("Z");
		//δ�ر�����
		//cond.setPrActive("Y");
		//����BLȡ���ҷ���Ĺ���
		//���ҷ���Ĺ�������VO
		vo.setProcessRecordInitForMeList(ig500BL.searchProcessRecordInfo(cond));
		//��ѯ��ʷ����
		IG500SearchCondImpl cond500 = new IG500SearchCondImpl();
		cond500.setApproveflag("0");
		cond500.setIsWork(1);
		cond500.setOrder("propentime");
		cond500.setSing("DESC");
		cond500.setUserid_q(dto.getUserId());
		List<IG500Info> prList = workFlowOperationBL.searchProcessByType(cond500, 0, 0, IGPRDCONSTANTS.SEARCH_MY_PROCESS);
		vo.setProcessRecordInitForHistoryList(prList);
		return dto;
	}
	
	/**
     * ����:������ҳ�����¼�����ȡ�ô���
     * @param IGCOM07DTO dto
     * @return �����¼�����
     * @throws BLException
     */
    public IGCOM04DTO getCurrentMouthEventCount(IGCOM04DTO dto)  throws BLException{
    	String incident_prtype = "01080";//Ĭ��ֵ
    	CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.PRPDID.getCcid());
        List<CodeDetail> cds = codeDetailBL.searchCodeDetail(condimpl,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
        for (CodeDetail cd : cds) {
        	if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.INCIDENT_PRTYPE))){
        		incident_prtype = cd.getCvalue();
        	}
        }
    	
        Calendar  c=new  GregorianCalendar();//�½����ڶ���  
        int  year=c.get(Calendar.YEAR);//��ȡ���  
        int  month=c.get(Calendar.MONTH)+1;//��ȡ�·�  
        String startDate = year + "/" + (month < 10 ? "0" + month : month) + "/01";
        String endDate = year + "/" + (month < 10 ? "0" + month : month) + "/31";
        
        IG500SearchCondImpl cond = new IG500SearchCondImpl();
        cond.setPropentime(startDate);
        cond.setPrclosetime(endDate);
//        cond.setPrTypeArray(new String[]{"I","ID"});
//        cond.setPrserialnum(incident_prtype);
        cond.setPrpdid(incident_prtype);
        
        List<IG500Info> dataList = workFlowOperationBL.searchProcessRecord(cond, 0, 0);
        if(dataList != null){
            dto.setCurrentMouthEventCount(dataList.size());
        }else{
            dto.setCurrentMouthEventCount(0);
        }
        
        return dto;
    }
    
    /**
     * ����:������ҳ������������ȡ�ô���
     * @param IGCOM07DTO dto
     * @return ������������
     * @throws BLException
     */
    public IGCOM04DTO getCurrentMouthProblemCount(IGCOM04DTO dto)  throws BLException{
    	String change_prtype = "01084";//Ĭ��ֵ
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.PRPDID.getCcid());
        List<CodeDetail> cds = codeDetailBL.searchCodeDetail(condimpl,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
        for (CodeDetail cd : cds) {
        	if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.CHANGE_PRTYPE))){
        		change_prtype = cd.getCvalue();
        	}
        }
    	
        Calendar  c=new  GregorianCalendar();//�½����ڶ���  
        int  year=c.get(Calendar.YEAR);//��ȡ���  
        int  month=c.get(Calendar.MONTH)+1;//��ȡ�·�  
        String startDate = year + "/" + (month < 10 ? "0" + month : month) + "/01";
        String endDate = year + "/" + (month < 10 ? "0" + month : month) + "/31";
        
        IG500SearchCondImpl cond = new IG500SearchCondImpl();
        cond.setPropentime(startDate);
        cond.setPrclosetime(endDate);
//        cond.setPrTypeArray(new String[]{"C","CD"});
//        cond.setPrserialnum(change_prtype);
        cond.setPrpdid(change_prtype);
        
        List<IG500Info> dataList = workFlowOperationBL.searchProcessRecord(cond, 0, 0);
        if(dataList != null){
            dto.setCurrentMouthProblemCount(dataList.size());
        }else{
            dto.setCurrentMouthProblemCount(0);
        }
        return dto;
    }
    
	/**
	 * 
	 * ����:��������������͹�������ȡ�ô���
	 * @param IGCOM07DTO dto
	 * @return �������͹�������
	 * @throws BLException
	 */
	public IGCOM04DTO getAllTypeWorkCount(IGCOM04DTO dto)  throws BLException{
		Random rand = new Random();
		
		
		dto.setAllTypeWorkCount(""+(rand.nextInt(99)+1) +"|" +(rand.nextInt(99)+1) +"|"+ (rand.nextInt(99)+1)+"|"+ (rand.nextInt(99)+1)+"|"+ (rand.nextInt(99)
				         +1)+",����Ѳ��|ϵͳ����|���ݵ���|ҵ��֧��|���մ���");
		return dto;
	}
	
	/**
	 * ����:���ɴ�����ҳ����¼�������ƽ�����ʱ��xml
	 * @param IGCOM07DTO dto
	 * @return ����¼�������ƽ�����ʱ��
	 * @throws BLException���¼����ƣ�
	 */
	public IGCOM04DTO setEventAvgCost(IGCOM04DTO dto)  throws BLException{
		String incident_prtype = "01080";//Ĭ��ֵ
    	CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.PRPDID.getCcid());
        List<CodeDetail> cds = codeDetailBL.searchCodeDetail(condimpl,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
        for (CodeDetail cd : cds) {
        	if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.INCIDENT_PRTYPE))){
        		incident_prtype = cd.getCvalue();
        	}
        }
		String date = IGStringUtils.getCurrentDate();
		List<Integer> incidentList = new ArrayList<Integer>();
		List<Integer> timeList = new ArrayList<Integer>();
		int maxAmount = 5 ;
		int maxTime = 10 ;
		for(int i=0;i<12;i++){
			//��ȡÿ���³�ʱ��
			Calendar   c   =   Calendar.getInstance(); 
			c.set(Integer.parseInt(date.substring(0, 4)), i, 1);
			String dateParam = "" ;
			if(i<9){
//				dateParam = date.substring(0,4)+"/0"+(i+1)+"/"+c.getActualMaximum(c.DAY_OF_MONTH) ;
				dateParam = date.substring(0,4)+"/0"+(i+1)+"/";
			}else{
				dateParam = date.substring(0,4)+"/"+(i+1)+"/";
//				dateParam = date.substring(0,4)+"/"+(i+1)+"/"+c.getActualMaximum(c.DAY_OF_MONTH) ;
			}
			IG500SearchCondImpl cond = new IG500SearchCondImpl();
			cond.setPrpdid(incident_prtype);
			cond.setPropentime(dateParam + "01");
			cond.setPrclosetime(dateParam + c.getActualMaximum(Calendar.DAY_OF_MONTH));
			//���²�ѯÿ�����¼�����
			int amount = workFlowOperationBL.getProcessRecordSearchCount(cond);
			//�����¼���ʱ����
			int timeTotal = 0 ;
			//��ƽ���¼����ʱ��
			int time = 0 ;
			if(amount!=0){
				//�¼�������Ϊ0
				//��ѯ����ʱ����ʱ����
//				timeTotal = incidentTendencyBL.searchEventDisposeTimeCountByCond(cond, 0, 0);
				//������ƽ���¼����ʱ��
				time = timeTotal/amount ;
			}else{
				//�¼�����Ϊ0
				//��ƽ���¼����ʱ��Ϊ0
				time = 0 ;
			}
			if(amount >= maxAmount){
				//��������¼�����
				maxAmount=amount ;
			}
			
			if(time >= maxTime){
				//���������ƽ���¼����ʱ��
				maxTime = time ;
			}
			incidentList.add(amount);
			timeList.add(time);
		}

		if(maxAmount != 5){
			if(maxAmount%5 != 0){
				maxAmount = (maxAmount/5 + 1)*5;
			}
		}
		if(maxTime != 10){
			if(maxTime%5 != 0){
				maxTime = (maxTime/5 + 1)*5;
			}
		}
	    String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	    
	    content = content+"<LEFTMAXVALUE>" + maxAmount + "</LEFTMAXVALUE>";
	    content = content+"<RIGHTMAXVALUE>" + maxTime + "</RIGHTMAXVALUE>";
	    content = content+"<LEFTLINE>" ;
	    for(int m=0;m<12;m++){
	    	content = content+"<value>" + (Integer)incidentList.get(m) + "</value>";
	    }
	    content = content+"</LEFTLINE>" ;
	    content = content+"<RIGHTLINE>" ;
	    for(int t=0;t<12;t++){
	    	content = content+"<value>" + (Integer)timeList.get(t)  + "</value>";
	    }
	    content = content+"</RIGHTLINE>" ;
	    content = content+"</ROOT>";
	    dto.setResultXML(content);
		return dto;
	}
	
	/**
	 * ����:���ɴ�����ҳ����¼�������ƽ�����ʱ��xml
	 * @param IGCOM07DTO dto
	 * @return ����¼�������ƽ�����ʱ��
	 * @throws BLException���¼����ƣ�
	 */
	public IGCOM04DTO searchProblemAvgSuccess(IGCOM04DTO dto)  throws BLException{
		String problem_prtype = "01083";//Ĭ��ֵ
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
		condimpl.setCcid(CodeDefine.PRPDID.getCcid());
		List<CodeDetail> cds = codeDetailBL.searchCodeDetail(condimpl,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		for (CodeDetail cd : cds) {
			if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.PROBLEM_PRTYPE))){
				problem_prtype = cd.getCvalue();
			}
		}
		String date = IGStringUtils.getCurrentDate();
		List<Integer> incidentList = new ArrayList<Integer>();
		List<Integer> timeList = new ArrayList<Integer>();
		int maxAmount = 5 ;
		int maxTime = 10 ;
		for(int i=0;i<12;i++){
			//��ȡÿ���³�ʱ��
			Calendar   c   =   Calendar.getInstance(); 
			c.set(Integer.parseInt(date.substring(0, 4)), i, 1);
			String dateParam = "" ;
			if(i<9){
//				dateParam = date.substring(0,4)+"/0"+(i+1)+"/"+c.getActualMaximum(c.DAY_OF_MONTH) ;
				dateParam = date.substring(0,4)+"/0"+(i+1)+"/";
			}else{
				dateParam = date.substring(0,4)+"/"+(i+1)+"/";
//				dateParam = date.substring(0,4)+"/"+(i+1)+"/"+c.getActualMaximum(c.DAY_OF_MONTH) ;
			}
			IG500SearchCondImpl cond = new IG500SearchCondImpl();
			cond.setPrpdid(problem_prtype);
			cond.setPropentime(dateParam + "01");
			cond.setPrclosetime(dateParam + c.getActualMaximum(Calendar.DAY_OF_MONTH));
			//���²�ѯÿ�����¼�����
			int amount = workFlowOperationBL.getProcessRecordSearchCount(cond);
			//�����¼���ʱ����
			int timeTotal = 0 ;
			//��ƽ���¼����ʱ��
			int time = 0 ;
			if(amount!=0){
				//�¼�������Ϊ0
				//��ѯ����ʱ����ʱ����
//				timeTotal = incidentTendencyBL.searchEventDisposeTimeCountByCond(cond, 0, 0);
				//������ƽ���¼����ʱ��
				time = timeTotal/amount ;
			}else{
				//�¼�����Ϊ0
				//��ƽ���¼����ʱ��Ϊ0
				time = 0 ;
			}
			if(amount >= maxAmount){
				//��������¼�����
				maxAmount=amount ;
			}
			
			if(time >= maxTime){
				//���������ƽ���¼����ʱ��
				maxTime = time ;
			}
			incidentList.add(amount);
			timeList.add(time);
		}
		
		if(maxAmount != 5){
			if(maxAmount%5 != 0){
				maxAmount = (maxAmount/5 + 1)*5;
			}
		}
		if(maxTime != 10){
			if(maxTime%5 != 0){
				maxTime = (maxTime/5 + 1)*5;
			}
		}
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		
		content = content+"<LEFTMAXVALUE>" + maxAmount + "</LEFTMAXVALUE>";
		content = content+"<RIGHTMAXVALUE>" + maxTime + "</RIGHTMAXVALUE>";
		content = content+"<LEFTLINE>" ;
		for(int m=0;m<12;m++){
			content = content+"<value>" + (Integer)incidentList.get(m) + "</value>";
		}
		content = content+"</LEFTLINE>" ;
		content = content+"<RIGHTLINE>" ;
		for(int t=0;t<12;t++){
			content = content+"<value>" + (Integer)timeList.get(t)  + "</value>";
		}
		content = content+"</RIGHTLINE>" ;
		content = content+"</ROOT>";
		dto.setResultXML(content);
		return dto;
	}
	
	/**
	 * ����:�����¼����ȼ���Ӱ��̶ȡ������̶�xml
	 * @param IGCOM07DTO dto
	 * @throws BLException
	 */
	public IGCOM04DTO setproincidentInfo(IGCOM04DTO dto)  throws BLException{
		String incident_prpdid = "01080";//Ĭ��ֵ
    	CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.PRPDID.getCcid());
        List<CodeDetail> codes = codeDetailBL.searchCodeDetail(condimpl,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
        for (CodeDetail cd : codes) {
        	if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.INCIDENT_PRTYPE))){
        		incident_prpdid = cd.getCvalue();
        	}
        }
		Calendar  c=new  GregorianCalendar();//�½����ڶ���  
		int  year=c.get(Calendar.YEAR);//��ȡ���  
        int  month=c.get(Calendar.MONTH)+1;//��ȡ�·�  
        String startDate = year + "/" + (month < 10 ? "0" + month : month) + "/01";
        String endDate = year + "/" + (month < 10 ? "0" + month : month) + "/31";
		String xml  = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		List<IG007Info> ig007Infos = null;
		//�����̶�
		IG007SearchCondImpl ig007searchcond = new IG007SearchCondImpl();
		ig007searchcond.setPidid_like(incident_prpdid);
		ig007searchcond.setPidname("���ȼ�");
		ig007Infos = workFlowDefinitionBL.searchProcessInfoDef(ig007searchcond);
		IG500SearchCondImpl incident = new IG500SearchCondImpl();
		incident.setPrpdid(incident_prpdid);
		incident.setPropentime(startDate);
		incident.setPrclosetime(endDate);
		String [] pivarname = new String[1];
		pivarname[0] = "���ȼ�";
		incident.setVarnames(pivarname);
		
		if(ig007Infos != null){
//		    String [] urgency = ig007Infos.get(ig007Infos.size()-1).getPidoption().split("#");
			xml +="<PIEGRAPH>";
//            for (int i = 0; i < urgency.length; i++) {
//                if (StringUtils.isNotEmpty(urgency[i])) {
//                	String [] pivarvalue = new String[1];
//                	pivarvalue[0] = urgency[i];
//                	incident.setVarvalues(pivarvalue);
//                    xml += "<VALUE title='" + urgency[i] + "'>" + workFlowOperationBL.searchProcessCount(incident, null) + "</VALUE>";
//                }
//            }
			xml +="</PIEGRAPH>";
		}
		
		//�����̶�
		ig007searchcond.setPidname("�����̶�");
		ig007Infos = workFlowDefinitionBL.searchProcessInfoDef(ig007searchcond);
		
		pivarname = new String[1];
		pivarname[0] = "�����̶�";
		incident.setVarnames(pivarname);
		if(ig007Infos != null){
		    String [] urgency = ig007Infos.get(ig007Infos.size()-1).getPidoption().split("#");
			xml +="<PIEGRAPH>";
            for (int i = 0; i < urgency.length; i++) {
                if (StringUtils.isNotEmpty(urgency[i])) {
                	String [] pivarvalue = new String[1];
                	pivarvalue[0] = urgency[i];
                	incident.setVarvalues(pivarvalue);
                    xml += "<VALUE title='" + urgency[i] + "'>" + workFlowOperationBL.searchProcessCount(incident, null) + "</VALUE>";
                }
            }
			xml +="</PIEGRAPH>";
		}
		
		//Ӱ��̶�
		ig007searchcond.setPidname("Ӱ��̶�");
		ig007Infos = workFlowDefinitionBL.searchProcessInfoDef(ig007searchcond);
		pivarname = new String[1];
		pivarname[0] = "Ӱ��̶�";
	    incident.setVarnames(pivarname);
        if(ig007Infos != null && ig007Infos.size() > 0){
            String [] impact = ig007Infos.get(ig007Infos.size()-1).getPidoption().split("#");
			xml +="<PIEGRAPH>";
            for (int i = 0; i < impact.length; i++) {
                if (StringUtils.isNotEmpty(impact[i])) {
                    String [] pivarvalue = new String[1];
                	pivarvalue[0] = impact[i];
                	incident.setVarvalues(pivarvalue);
                    xml += "<VALUE title='" + impact[i] + "'>" + workFlowOperationBL.searchProcessCount(incident, null) + "</VALUE>";
                }
            }
			xml +="</PIEGRAPH>";
		}
		
		
		
		xml +="</ROOT>";
		dto.setResultXML(xml);
		return dto;
	}
	
	/**
	 * ���²�ѯ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCOM04DTO searchProblemTotalByMonth(IGCOM04DTO dto) throws BLException {
		String change_prtype = "01084";//Ĭ��ֵ
		CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.PRPDID.getCcid());
        List<CodeDetail> cds = codeDetailBL.searchCodeDetail(condimpl,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
        for (CodeDetail cd : cds) {
        	if(cd.getCdinfo().equals(IGPROCESSType.getTypeName(IGPROCESSType.CHANGE_PRTYPE))){
        		change_prtype = cd.getCvalue();
        	}
        }
		String date = IGStringUtils.getCurrentDate();
		List<Integer> incidentList = new ArrayList<Integer>();
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		int maxAmount = 5 ;
		for(int i=0;i<12;i++){
			//��ȡÿ���³�ʱ��
			Calendar   c   =   Calendar.getInstance(); 
			c.set(Integer.parseInt(date.substring(0, 4)), i, 1);
			String dateParam = "" ;
			if(i<9){
				dateParam = date.substring(0,4)+"/0"+(i+1)+"/";
			}else{
				dateParam = date.substring(0,4)+"/"+(i+1)+"/";
			}
			cond.setPrpdid(change_prtype);
			cond.setPropentime(dateParam + "01");
			cond.setPrclosetime(dateParam + c.getActualMaximum(Calendar.DAY_OF_MONTH));
			//���²�ѯÿ�����¼�����
			
			int amount = workFlowOperationBL.getProcessRecordSearchCount(cond);
			if(amount >= maxAmount){
				//��������¼�����
				maxAmount=amount ;
			}
			incidentList.add(amount);
			
		}
		if(maxAmount != 5){
			if(maxAmount%5 != 0){
				maxAmount = (maxAmount/5 + 1)*5;
			}
		}
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=1.0 encoding=UTF-8?><ROOT>");
		xml.append("<MAXVALUE>").append(maxAmount).append("</MAXVALUE>");
		xml.append("<PILLAR>");
		for(int i=0;i<incidentList.size();i++){
			xml.append("<value>").append((Integer)incidentList.get(i)==0?0:(Integer)incidentList.get(i)).append("</value>");
		}
		xml.append("</PILLAR>");
		
		xml.append("<AREA>");
		for(int i=0;i<incidentList.size();i++){
//			xml.append("<value>").append((Integer)incidentList.get(i)==0?0.00001:(Integer)incidentList.get(i)).append("</value>");
			xml.append("<value>").append(0).append("</value>");
		}
		xml.append("</AREA>");
		
		xml.append("<LINE>");
		for(int i=0;i<incidentList.size();i++){
//			xml.append("<value>").append((Integer)incidentList.get(i)==0?0.00001:(Integer)incidentList.get(i)).append("</value>");
			xml.append("<value>").append(0).append("</value>");
		}
		xml.append("</LINE>");

		
		xml.append("<MONTH>");
		xml.append("<value>1</value>");
		xml.append("<value>2</value>");
		xml.append("<value>3</value>");
		xml.append("<value>4</value>");
		xml.append("<value>5</value>");
		xml.append("<value>6</value>");
		xml.append("<value>7</value>");
		xml.append("<value>8</value>");
		xml.append("<value>9</value>");
		xml.append("<value>10</value>");
		xml.append("<value>11</value>");
		xml.append("<value>12</value>");
		xml.append("</MONTH>");
		
		xml.append("</ROOT>");
		
		dto.setResultXML(xml.toString());
		
		return dto;
	}
}
