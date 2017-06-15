/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.srv.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG715BL;
import com.deliverik.framework.workflow.prr.bl.task.IG933BL;
import com.deliverik.framework.workflow.prr.bl.task.ProcessTimeBL;
import com.deliverik.framework.workflow.prr.bl.task.ProcessWorkTimeBL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzJobsBL;
import com.deliverik.infogovernor.scheduling.jobs.JOBCONSTANTS;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCondImpl;
import com.deliverik.infogovernor.soc.srv.dto.IGSRV02DTO;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�¼�ҵ���߼��ӿ�ʵ����
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @History 2010-7-13     0000000: ���ӿ�ݷ����¼�����
 *          2010-12-07    yangliang: ���Ӳ�ѯȫ�����̹���
 * @version 1.0
 */

public class IGSRV02BLImpl extends BaseBLImpl implements IGSRV02BL {




	/**
	 * ig715BL�趨
	 *
	 * @param ig715bl ig715BL
	 */
	public void setIg715BL(IG715BL ig715bl) {
		ig715BL = ig715bl;
	}


	static Log log = LogFactory.getLog(IGSRV02BLImpl.class);
	
	private CodeDetailBL codeDetailBL;
	
	//private SendMessageBL sendMessageBL;
	
	private QuartzJobsBL quartzJobsBL;
	
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**���̶���BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/**�û���ɫ��Ȩ��ϢBL*/
	protected UserRoleBL userRoleBL;
	
	/**��ɫ��Ϣҵ��BL*/
	protected RoleBL roleBL;
	
	/**���񹤵�BL*/
	protected IG933BL ig933BL;
	
	/**���񹤵���������BL*/
	protected IG715BL ig715BL;

	/**�鿴��ϸ��ʱ���BL*/
	protected ProcessTimeBL processTimeBL;
	
	/**�û���Ϣ����ϸ���BL*/
	protected ProcessWorkTimeBL processWorkTimeBL;
	
	public void setProcessTimeBL(ProcessTimeBL processTimeBL) {
		this.processTimeBL = processTimeBL;
	}
	
	public void setProcessWorkTimeBL(ProcessWorkTimeBL processWorkTimeBL) {
		this.processWorkTimeBL = processWorkTimeBL;
	}
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

//	public void setSendMessageBL(SendMessageBL sendMessageBL) {
//		this.sendMessageBL = sendMessageBL;
//	}

	public void setQuartzJobsBL(QuartzJobsBL quartzJobsBL) {
		this.quartzJobsBL = quartzJobsBL;
	}

	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * ig933BL�趨
	 *
	 * @param ig933bl ig933BL
	 */
	public void setIg933BL(IG933BL ig933bl) {
		ig933BL = ig933bl;
	}


	/**
	 * <p>
	 * Description: ��ȡ�¼�������ʾ״̬������ťȨ�ޣ� 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getActionStatus(IGSRV02DTO dto) throws BLException{
		log.debug("========��ȡ�¼�������ʾ״̬��ʼ========");
		String userid = dto.getUserid();
		Integer prid = dto.getPrid();
		List<UserRoleInfo> userRoleList = userRoleBL.getUserRoles(dto.getUserid());
		IG500Info processRecord = workFlowOperationBL.searchProcessRecordByKey(prid);
		char curStatus = processRecord.getPrstatus().charAt(0);
		String todoAction;
		switch(curStatus){
			case IGSRV02BLType.PROCESS_STATUS_WAITING_DISPATCH_CHAR:
			//�ȴ�����	
				todoAction = IGSRV02BLType.PROCESS_ACTION_DISPATCH;
				break;
			case IGSRV02BLType.PROCESS_STATUS_WAITING_IMPLEMENT_CHAR:
			//�ȴ�����
				todoAction = IGSRV02BLType.PROCESS_ACTION_IMPLEMENT;
				break;
			case IGSRV02BLType.PROCESS_STATUS_WAITING_VERIFY_CHAR:
			//�ȴ����
				todoAction = IGSRV02BLType.PROCESS_ACTION_VERIFY;
				break;
			case IGSRV02BLType.PROCESS_STATUS_CLOSE_CHAR:
			//�Ѿ��ر�
				todoAction = IGSRV02BLType.ACTION_NONE;
				break;
			default:
				throw new BLException("IGSVC0203.E001", "������"+processRecord.getPrserialnum()+"״̬"+curStatus );
		}
		if(todoAction.equals(IGSRV02BLType.ACTION_NONE)){
			dto.setActionnameList(null);
			dto.addMessage(new ActionMessage("IGSVC0203.I001",prid));
			return dto;
		}
		List<IG337Info> todoRoleList = workFlowOperationBL.searchProcessParticipantTodoRole(prid, 
				String.valueOf(curStatus));
		List<Integer> todoRoleidList = new ArrayList<Integer>();
		for (int i = 0; i < todoRoleList.size(); i++) {
			todoRoleidList.add(todoRoleList.get(i).getPproleid());
		}
		List<String> actionList = new ArrayList<String>();
		actionList.add(IGSRV02BLType.PROCESS_ACTION_ADDCOMMENT);
		boolean confirmflag = false;
		
		
		boolean showDoFlag = false;//�Ƿ���ʾ"���븴��"

		for(int i=0; i<userRoleList.size(); i++){
			UserRoleInfo ur = userRoleList.get(i);
			//�������ϵͳ����Ա�Ľ�ɫ����������,��ֹ������˰�ť����
			if(roleBL.isProcessAdminRole(ur.getRoleid())){
				actionList.add(IGSRV02BLType.PROCESS_ACTION_ADJUSTLEVEL);
				actionList.add(IGSRV02BLType.PROCESS_ACTION_TERMINATE);
				actionList.add(IGSRV02BLType.PROCESS_ACTION_VERIFIORS);
				//����¼����ڴ�����״̬�����̹���Ա�������·���
				if(todoAction.equals(IGSRV02BLType.PROCESS_ACTION_IMPLEMENT)){
					actionList.add(IGSRV02BLType.PROCESS_ACTION_IMPLEMENTORS);
				}
			}
			
			for(IG337Info pp : todoRoleList){
				if(pp.getPproleid().equals(ur.getRoleid())&&!IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())&&!"0".equals(dto.getConfirmflag())){
					confirmflag = true;
				}
			}
			//�������̵�ǰ��״̬���趨����ť
			if(todoRoleidList.contains(ur.getRoleid())){
				//�������״̬Ϊ�ȴ�������ֻ��ȷ���˿��Դ���
				if(todoAction.equals(IGSRV02BLType.PROCESS_ACTION_IMPLEMENT) && !confirmflag){
					String uid = "";
					for(IG337Info pp : todoRoleList){
						if(IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT.equals(pp.getPpstatus()) && 
								IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())){
							uid = pp.getPpuserid();
							//if(StringUtils.isNotEmpty(uid) && userid.equals(uid)){
							if(StringUtils.isNotEmpty(uid)){
								if(!actionList.contains(todoAction)){
									actionList.add(todoAction);
									break;
								}
									
							}
						}
					}
				}else{
					//�ȴ�����״̬�£���ǰ�û�Ϊ�Ѿ�ȷ�Ϲ��Ĵ����ˣ�����������븴��
					if(todoAction.equals(IGSRV02BLType.PROCESS_ACTION_IMPLEMENT) && !showDoFlag){
						String uid = "";
						for(IG337Info pp:todoRoleList){
							if(IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT.equals(pp.getPpstatus()) && 
									IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())){
								uid = pp.getPpuserid();
								//if(StringUtils.isNotEmpty(uid) && userid.equals(uid)){
								if(StringUtils.isNotEmpty(uid)){
									showDoFlag = true;
									break;	
								}
								
							}
						}
						//�ȴ������ڵ�ǰ������δȷ�ϣ���ɼ�ȷ�ϰ�ť
						if(!showDoFlag){
							if(!actionList.contains(todoAction))
								actionList.add(todoAction);//����ȷ��
						}
					}else{
						//�ǵȴ�������
						if(!todoAction.equals(IGSRV02BLType.PROCESS_ACTION_IMPLEMENT)){
							if(!actionList.contains(todoAction))
								actionList.add(todoAction);
						}else{
							//�ȴ������ڵ�ǰ������δȷ�ϣ���ɼ�ȷ�ϰ�ť
							if(!showDoFlag){
								if(!actionList.contains(todoAction))
									actionList.add(todoAction);//����ȷ��
							}
						}
						
					}
					
					
				}

			}
			
		}
		
		if(IGSRV02BLType.PROCESS_ACTION_IMPLEMENT.equals(todoAction)){
			if(confirmflag){
				dto.setConfirmflag("0");//����ȷ��
			}else{
				dto.setConfirmflag("1");//�Ѿ�ȷ��
			}
		}
		if(showDoFlag){
			dto.setCanDoFlag("1");//��ǰ�û����Դ���
			if(!actionList.contains(todoAction))
				actionList.add(todoAction);//���Դ���
		}
		
		//�����ǰ״̬Ϊ�ȴ�����
		boolean imgFlag = false;//�鿴ҳ����ͼ�Ƿ�����ȴ�ȷ��ͼ��
		if(todoAction.equals(IGSRV02BLType.PROCESS_ACTION_IMPLEMENT)){
			//��õȴ�����״̬�µ����в����߼���
			List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipant(processRecord.getPrid(),IGSRV02BLType.PROCESS_STATUS_WAITING_IMPLEMENT);
			if(pplist!=null && pplist.size()>0){
				for(IG337Info pp:pplist){
					if(IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRM.equals(pp.getPpsubstatus())){
						imgFlag = true;
						break;
					}
				}
			}
		}
		if(imgFlag){
			dto.setConfirmImgFlag("1");//����δȷ�ϵĲ�����
		}else{
			dto.setConfirmImgFlag("0");//������δȷ�ϵĲ�����
		}
		
		List<IG337Info> manager = workFlowOperationBL.queryRolemanager(userid, prid);
		if(!manager.isEmpty()) {
			//��ǰ�û������̲����߽�ɫ�ĸ�����
			actionList.add(IGSRV02BLType.PROCESS_ACTION_MANAGER);
		}
		dto.setActionnameList(actionList);
		log.debug("========��ȡ�¼�������ʾ״̬����========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ��ȡ�¼������� 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getImplementors(IGSRV02DTO dto) throws BLException {
		log.debug("========�����˲�ѯ����ʼ========");
		// ��ȡ����ӽ�ɫ
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipant(dto.getPrid(),IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT);
		dto.setProcessParticipantList(pplist);
		// ��ȡ����ӽ�ɫ
		List<Role> roleList = workFlowOperationBL.getRoleNotInProcessParticipants(pplist);
		dto.setRoleList(roleList);
		log.debug("========�����˲�ѯ��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ��ȡ��ʷ��¼ 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getRecordLogs(IGSRV02DTO dto) throws BLException {
		log.debug("========��ȡ�¼���ʷ��¼����ʼ========");
		workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		dto.setRecordLogAttachmentMap(workFlowOperationBL.searchRecordLog(dto.getPrid()));
		dto.addMessage(new ActionMessage("IGSVC0211.I001",dto.getPrid()));
		log.debug("========��ȡ�¼���ʷ��¼��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ��ȡ�¼������
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getVerifiors(IGSRV02DTO dto) throws BLException {
		log.debug("========����˲�ѯ����ʼ========");
		// ��ȡ����ӽ�ɫ
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipant(dto.getPrid(),IGSRV02BLType.PARTICIPANT_STATUS_VERIFY);
		dto.setProcessParticipantList(pplist);
		// ��ȡ����ӽ�ɫ
		List<Role> roleList = workFlowOperationBL.getRoleNotInProcessParticipants(pplist);
		dto.setRoleList(roleList);
		log.debug("========����˲�ѯ��������========");
		return dto;
	}
////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * <p>
	 * Description: ɾ���¼���¼
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGSRV02DTO delProcessRecord(IGSRV02DTO dto) throws BLException {
		workFlowOperationBL.delProcessRecord(dto.getPrid());
		dto.addMessage(new ActionMessage("IGSVC0201.I001"));
		return dto;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * <p>
	 * Description: ��ѯ�¼���¼
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGSRV02DTO getProcessRecords(IGSRV02DTO dto) throws BLException {
		log.debug("========��ѯ�¼���¼����ʼ========");
		boolean flag = false;//���̹���Ա��ʶ
		List<UserRoleInfo> userroleList = userRoleBL.getUserRoles(dto.getUser().getUserid());
		for(UserRoleInfo uri:userroleList){
			//�ж��Ƿ�Ϊ���̹���Ա
			if(roleBL.isProcessAdminRole(uri.getRoleid())){
				flag = true;
				break;
			}
		}
		
		
		log.debug("========��ѯ�¼���¼��������========");
		return dto;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * <p>
	 * Description: ��ѯȫ�����̼�¼
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update yangliang@deliverik.com
	 */
	
	public IGSRV02DTO getProcessRecordsAll(IGSRV02DTO dto) throws BLException {
		log.debug("========��ѯȫ����¼����ʼ========");
		boolean flag = false;//���̹���Ա��ʶ
		List<UserRoleInfo> userroleList = userRoleBL.getUserRoles(dto.getUser().getUserid());
		for(UserRoleInfo uri:userroleList){
			//�ж��Ƿ�Ϊ���̹���Ա
			if(roleBL.isProcessAdminRole(uri.getRoleid())){
				flag = true;
				break;
			}
		}
		
		log.debug("========��ѯȫ����¼��������========");
		return dto;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * <p>
	 * Description: ͨ��prid����ѯ����
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public List<IG500Info> searchProcessRecordByKey(Integer prid) throws BLException {
		log.debug("========��ȡ�¼�������Ϣ����ʼ========");
		return null;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * <p>
	 * Description: �û���ɫ��ѯ
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getUserRoles(IGSRV02DTO dto) throws BLException{
		log.debug("========�û���ɫ��ѯ����ʼ========");
		List<UserRoleInfo> roleList = userRoleBL.getUserRoles(dto.getUserid());
		dto.setUserRoleList(roleList);
		log.debug("========�û���ɫ��ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �û������̽�ɫ��ѯ
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */

	public IGSRV02DTO getUserRolesNotInProcess(IGSRV02DTO dto) throws BLException {
		log.debug("========�û����¼���ɫ��ѯ����ʼ========");
		List<UserRoleInfo> roleList = userRoleBL.getUserRolesNotInProcess(dto.getUserid());
		dto.setUserRoleList(roleList);
		log.debug("========�û����¼���ɫ��ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ȡָ���¼�״̬�Ĳ�����
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSRV02DTO getProcessParticipantsByStatus(IGSRV02DTO dto) throws BLException {
		log.debug("========��ȡָ���¼�״̬�Ĳ����ߴ���ʼ========");
		String status = dto.getStatus();
		if(IGSRV02BLType.PROCESS_STATUS_WAITING_CONFIRM.equals(status)){
			status = IGSRV02BLType.PROCESS_STATUS_WAITING_IMPLEMENT;
		}
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipant(dto.getPrid(), status);
		if(pplist.isEmpty()){
			throw new BLException("IGSVC0200.E002",
					dto.getPrid().toString());
		}
		String comment = "";
		comment = this.appendLogTitleCssBegin(comment);
		for(IG337Info pp : pplist){
			String message = "δ����";
			if(!IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())&&IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT.equals(pp.getPpstatus())){
				message = "δȷ��";
			}
			if(IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())&&IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT.equals(pp.getPpstatus())){
				message = "������";
			}
			comment +=this.appendLogContent(pp.getPprolename(),(StringUtils.isEmpty(pp.getPpusername())?"":pp.getPpusername())
					+(StringUtils.isEmpty(pp.getPpproctime())?message:"�Ѵ���"));
		}
		comment =this.appendLogTitleCssEnd(comment);
		dto.setStatus(comment.replaceAll(",", "&nbsp;&nbsp;&nbsp;&nbsp;"));
		log.debug("========��ȡָ���¼�״̬�Ĳ����ߴ�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ȡ�û������е�ָ���¼��Ĳ����߽�ɫ
	 * </p>
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */

	public IGSRV02DTO getUserRolesInProcessParticipants(IGSRV02DTO dto) throws BLException {
		log.debug("========��ȡ�û������е�ָ���¼��Ĳ����߽�ɫ����ʼ========");
		List<UserRoleInfo> userRoleList = workFlowOperationBL.getUserRolesInProcessParticipants(dto.getPrid(), dto.getUserid(), dto.getStatus());
		if(userRoleList.isEmpty()){
			throw new BLException("IGSVC0200.E002",
					dto.getPrid().toString());
		}
		//�����ǰ����״̬Ϊ�ȴ�������Ҫ���˵�δȷ�ϵĴ����߽�ɫ
		if(IGSRV02BLType.PROCESS_STATUS_WAITING_IMPLEMENT.equals(dto.getStatus())){
			List<UserRoleInfo> reallist = new ArrayList<UserRoleInfo>();
			//��õȴ�����״̬�µ����в����߼���
			List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipant(dto.getPrid(),IGSRV02BLType.PROCESS_STATUS_WAITING_IMPLEMENT);
			if(pplist!=null && pplist.size()>0){
				for(IG337Info pp:pplist){
					for(UserRoleInfo uri:userRoleList){
						if(uri.getRoleid().equals(pp.getPproleid())){
							//if(IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus()) && dto.getUserid().equals(pp.getPpuserid())){
							if(IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())){
								reallist.add(uri);
							}
						}
					}
					
				}
			}
			if(reallist.size()>0){
				dto.setUserRoleList(reallist);
			}else{
				dto.setUserRoleList(userRoleList);
			}
			
		}else{
			dto.setUserRoleList(userRoleList);
		}

		log.debug("========��ȡ�û������е�ָ���¼��Ĳ����߽�ɫ��������========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: ��ѯ���Է��ɵĽ�ɫ
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getDispatchRoles(IGSRV02DTO dto) throws BLException {
		log.debug("========���̽�ɫ��ѯ����ʼ========");
		List<Role> roleList = roleBL.getRolesNotInProcess();
		dto.setRoleList(roleList);
		log.debug("========���̽�ɫ��ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ѯ�¼����
	 * <p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 */
	
	public IGSRV02DTO searchIncidentCategory(IGSRV02DTO dto) throws BLException{
		log.debug("========�¼�����ѯ����ʼ========");
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.getCodeDefine("INCIDENT_CATEGORY_CODE").getCcid());
		List<CodeDetail> cds = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		for(CodeDetail cd : cds){
			if(StringUtils.isNotEmpty(cd.getPccid())){
				continue;
			}
			TreeNode node = new TreeNode();
			node.setId(cd.getCid());
			node.setName(cd.getCvalue());
			node.setRemark("#"+cd.getCid());
			getChildTreeNodeMap(cd.getCcid(),cd.getCid(),node);
			treeNodeMap.put(node.getId(),node);
		}
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========�¼�����ѯ����ʼ========");
		return dto;
		
	}

	/**
	 * <p>
	 * Description:  ��ѯҶ�ӽڵ�
	 * </p>
	 * 
	 * @param pccid ���ݷ���id
	 * @param pcid ����id
	 * @param parentNode
	 */
	private void getChildTreeNodeMap(String pccid,String pcid,TreeNode parentNode){
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setPccid(pccid);
		cond.setPcid(pcid);
		List<CodeDetail> cds = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		for(CodeDetail cd : cds){
			TreeNode node = new TreeNode();
			node.setId(cd.getCid());
			node.setName(cd.getCvalue());
			node.setRemark(parentNode.getRemark()+"#"+cd.getCid());
			getChildTreeNodeMap(cd.getCcid(),cd.getCid(),node);
			parentNode.addChildTreeNode(node.getId(), node);
		}
	}
	
	/**
	 * <p>
	 * ��¼��־����ʽ��ƴ�ӿ�ʼ����ʱ�Ǽ�¼��Ա��Ϣʱ����
	 * </p>
	 * 
	 * @param massage ��־������Ϣ
	 * @return ����HTML��ǩ����־������Ϣ
	 */

	private String appendLogTitleCssBegin(String massage) {
		return massage + "<span>";
	}

	/**
	 * <p>
	 * ��¼��Ա��־����ƴ�ӣ���ʱ��¼��Ա��Ϣʱ����
	 * </p>
	 * 
	 * @param rolename ��ɫ����
	 * @param username �û�����
	 * @return ����HTML��ǩ����־������Ϣ����", "��β����ȥ��ĩβ����λ
	 */

	private String appendLogContent(String rolename, String username) {
		String str ="";
		if("�Ѵ���".equals(username)||"δ����".equals(username)){
			str = rolename+ "(" + username + ")"+ ", ";
		}else{
			str = rolename+ (StringUtils.isEmpty(username) ? ", " : "(" + username + ")"+ ", ");
			
		}
		return str;
	}

	/**
	 * <p>
	 * ��¼��־����ʽ��ƴ�ӽ�������ʱ�Ǽ�¼��Ա��Ϣʱ����
	 * </p>
	 * 
	 * @param massage ��־������Ϣ
	 * @return ����HTML��ǩ����־������Ϣ
	 */

	private String appendLogTitleCssEnd(String massage) {
		massage=massage.substring(0, massage.length() - 2);
		return massage + "</span>";
	}
	
	
//	/**
//	 * ������
//	 * 
//	 * @param participantList
//	 * @param prid
//	 * @throws BLException 
//	 */
//	private void sendMessage(List<IG337Info> participantList,Integer prid) throws BLException{
//		if(participantList!=null){
//			for(IG337Info pp : participantList){
//				if(!StringUtils.isEmpty(pp.getPpuserid())){
//					sendMessageToUser(pp.getPpuserid(), prid);
//					continue;
//				}
//				if(pp.getPproleid()!=null&&pp.getPproleid()!=0){
//					sendMessageToRole(pp.getPproleid(), prid);
//				}
//			}
//		}
//	}

//	/**
//	 * ���û�������
//	 * 
//	 * @param userid
//	 * @param prid
//	 * @throws BLException 
//	 */
//	private void sendMessageToUser(String userid, Integer prid) throws BLException{
//		IG500Info processrecord = workFlowOperationBL.searchProcessRecordByKey(prid);
//		String message = "�¼�����Ϊ��"+processrecord.getPrpdname() + ")��" + 
//		                 "������Ϊ("+ processrecord.getPrserialnum() + ")��"+processrecord.getPrtitle()+"�¼���Ҫ������";
//		sendMessageBL.sendSmsToUser(userid, message);
//	}

//	/**
//	 * ����ɫֵ���ֻ�������
//	 * 
//	 * @param roleid
//	 * @param prid
//	 * @throws BLException 
//	 */
//	private void sendMessageToRole(Integer roleid, Integer prid) throws BLException{
//		IG500Info processrecord = workFlowOperationBL.searchProcessRecordByKey(prid);
//		String message = "�¼�����Ϊ��"+processrecord.getPrpdname() + ")��" + 
//		                 "������Ϊ("+ processrecord.getPrserialnum() + ")��"+processrecord.getPrtitle()+"�¼���Ҫ������";
//		sendMessageBL.sendSmsToRole(roleid, message);
//	}
	
//	/**
//	 * �������߷�����
//	 * 
//	 * @param userid
//	 * @param prid
//	 * @throws BLException 
//	 */
//	private void sendMessageToOpener(String userid, Integer prid, String sms) throws BLException{
//		IG500Info processrecord = workFlowOperationBL.searchProcessRecordByKey(prid);
//		String message = "�¼�����Ϊ��"+processrecord.getPrpdname() + ")��" + 
//			             "������Ϊ("+ processrecord.getPrserialnum() + ")��"+processrecord.getPrtitle()+"�¼���"+sms+"��";
//		sendMessageBL.sendSmsToUser(userid, message);
//	}
	
//	/**
//	 * �Ƚ�ʱ��
//	 * 
//	 * @param timeA
//	 * @param timeB
//	 * @return int
//	 */
//	private static int getBetweenTimeNumber(String timeA, String timeB) throws Exception {
//		long timeNumber = 0;
//		// 1Сʱ=60����=3600��=3600000
//		long mins = 60L * 1000L;
//		// long time= 24L * 60L * 60L * 1000L;��������֮��
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//		Date d1 = df.parse(timeA);
//		Date d2 = df.parse(timeB);
//		timeNumber = (d2.getTime() - d1.getTime()) / mins;
//		return (int) timeNumber;
//	}
	
	/**
	 * �¼������̶ȷ�����Բ�ѯ
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 */
	
	public IGSRV02DTO searchIncidentUrgency(IGSRV02DTO dto) throws BLException{
		
		QuartzJobsSearchCondImpl cond = new QuartzJobsSearchCondImpl();
		cond.setQjname(JOBCONSTANTS.INCIDENT_MONITOR);
		List<QuartzJobs> qjList = quartzJobsBL.searchQuartzJobs(cond, 0, 0);
		if (qjList.size() > 1) {
			throw new BLException("IGSCH0401.E001");
		}
		
		for (QuartzJobs quartzJobs : qjList) {
			String[] resolveTime =quartzJobs.getQjinfo().split("#");
			String temp = "" ;
			for(String str : resolveTime){
				if("-1".equals(str)){
					temp += "#";
				}else{
					temp += this.dateOperation(dto.getProcess().getPropentime(),Integer.parseInt(str))+"#";
				}
			}
			dto.setUrgency(quartzJobs.getQjorgname());
			dto.setResolveTime(temp);
		}
		 return dto;
	}
	
	/**
	 * �ۼ�ʱ��
	 * @param dateStr
	 * @param m
	 * @return
	 */
	private String dateOperation(String dateStr,int m){
		
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");   
		Date mydate;
		try {
			mydate = myFormatter.parse(dateStr);
			Calendar cal=Calendar.getInstance();
			cal.setTime(mydate);
			cal.add(Calendar.MINUTE,m); //�ӷ�����
			return myFormatter.format(cal.getTime());
		} catch (ParseException e) {
			log.error(e);
			return "";
		}
	}
	
	/**
	 * <p>
	 * Description: ��ȡδȷ�ϲ�����
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGSRV02DTO getConfirmer(IGSRV02DTO dto) throws BLException {
		log.debug("========��ȡδȷ�ϲ����ߴ���ʼ========");
		Integer prid = dto.getPrid();
		List<IG337Info> piList = workFlowOperationBL.searchProcessParticipant(prid, IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT);
		List<UserRoleInfo> uiList = workFlowOperationBL.getUserRolesInProcessParticipants(prid, dto.getUserid(), IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT);
		List<IG337Info> confirmerList = new ArrayList<IG337Info>();
		for(int i=0;i<piList.size();i++){
			IG337Info pp =piList.get(i);
			for(UserRoleInfo ur : uiList){
				if(pp.getPproleid().equals(ur.getRoleid()) && !IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())){
					confirmerList.add(pp);
					break;
				}
			}
		}
		if(confirmerList.size()==0){
			throw new BLException("IGSVC0215.E001");
		}
		log.debug("========��ȡδȷ�ϲ����ߴ�������========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: ��ȡִ����
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO searchAssignPersonAction(IGSRV02DTO dto) throws BLException {
		log.debug("========ִ���˲�ѯ����ʼ========");
		// ��ȡ����ӽ�ɫ
		List<IG337Info> pplist = workFlowOperationBL.queryRolemanager(dto.getUserid(), dto.getPrid());
		dto.setProcessParticipantList(pplist);
		log.debug("========ִ���˲�ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ȡ����״̬�б�
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update yangshengnan@deliverik.com
	 */
	
	public IGSRV02DTO getProcessDefinition(IGSRV02DTO dto) throws BLException {
		
		log.debug("========����״̬�б���Ϣ��Ѱ����ʼ========");
		
  		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setPttype(IGPROCESSType.INCIDENT_PRTYPE);
		List<IG259Info> pts = workFlowDefinitionBL.searchProcessTemplate(cond);
		cond.setPttype(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_ID);
		List<IG259Info> zdypts = workFlowDefinitionBL.searchProcessTemplate(cond);
		pts.addAll(zdypts);
		
  		IG380SearchCondImpl pdCond = new IG380SearchCondImpl();
		String[] pdstatuses = new String[2];
		pdstatuses[0] = "a";
		pdstatuses[1] = "t";
		pdCond.setPdstatuses(pdstatuses);
		
		List<IG380Info> pds = new ArrayList<IG380Info>();
		for(IG259Info pt : pts) {
			pdCond.setPtid(pt.getPtid());
			pds.addAll(workFlowDefinitionBL.searchProcessDefinition(pdCond));
		}

		dto.setProcessDefinitionList(pds);
		
		log.debug("========����״̬�б���Ϣ��Ѱ��������========");
		return dto;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * <p>
	 * Description: ��ȡȫ������״̬�б�
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update yangliang@deliverik.com
	 */
	
	public IGSRV02DTO getProcessDefinitionAll(IGSRV02DTO dto) throws BLException {
		
		log.debug("========����״̬�б���Ϣ��Ѱ����ʼ========");
	
  		IG380SearchCondImpl pdCond = new IG380SearchCondImpl();
		
		List<IG380Info> pds = workFlowDefinitionBL.searchProcessDefinition(pdCond);
		
		dto.setProcessDefinitionList(pds);
		
		log.debug("========����״̬�б���Ϣ��Ѱ��������========");
		return dto;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * <p>
	 * Description: ����״̬��־�鿴 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGSRV02DTO searchRecordStatusLogAction(IGSRV02DTO dto) throws BLException {
		log.debug("========�¼�״̬��־�鿴����ʼ========");
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		
		if(pr == null) {
			throw new BLException("IGCO10000.E004","�¼�����");
		}
		dto.setRecordStatusLogList(this.workFlowOperationBL.searchRecordStatusLog(dto.getPrid()));
		
		log.debug("========�¼�״̬��־�鿴��������========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: ���ӹ����ֶεĴ��������޸ĵײ㣬���Դ��ֶε�ֵ����ӵ������ֶ���
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update
	 */
	public IGSRV02DTO getSortOrder(IGSRV02DTO dto) throws BLException{
		
		String ptitle = dto.getPrtitle();
		String param = "";
		//�Ƿ�ѡ������ֶν�������
		if(StringUtils.isNotEmpty(dto.getPsort_order()))
		{
			param = dto.getPsort_order();
		}
		
		//����ֶ���������
		if(StringUtils.isNotEmpty(dto.getPOrder()))
		{
			if(StringUtils.isEmpty(param))
			{
				param = dto.getPOrder();
			}
			else
			{
				if(dto.getPOrder().startsWith(dto.getPSort()))
				{
					param = dto.getPOrder();
					dto.setPsort_order(dto.getPOrder());
				}
				else
				{
					param = param + "," + dto.getPOrder();
				}
			}
		}
		
		if(StringUtils.isNotEmpty(param))
		{
			ptitle = StringUtils.isEmpty(ptitle) ? "&&&" + param : ptitle + "&&&" + param;
		}
		dto.setPrtitle(ptitle);
		return dto;
	}
}
